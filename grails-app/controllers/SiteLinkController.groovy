class SiteLinkController {

  def siteLinkService
  def geocodeService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  Integer createCount
  Integer updateCount
  Integer unitCount

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    [siteLinkInstanceList: SiteLink.list(params), siteLinkInstanceTotal: SiteLink.count()]
  }

  def create = {
    def siteLinkInstance = new SiteLink()
    siteLinkInstance.properties = params
    return [siteLinkInstance: siteLinkInstance]
  }

  def save = {
    def siteLinkInstance = new SiteLink(params)
    if (siteLinkInstance.save(flush: true)) {
      // read in sites
      corpSites(siteLinkInstance)
      flash.message = "Feed " + createCount + " sites created " + updateCount + " sites updated " + unitCount + " units added."
      redirect(action: "show", id: siteLinkInstance.id)
    }
    else {
      render(view: "create", model: [siteLinkInstance: siteLinkInstance])
    }
  }

  def show = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (!siteLinkInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'siteLink.label', default: 'SiteLink'), params.id])}"
      redirect(action: "list")
    }
    else {
      [siteLinkInstance: siteLinkInstance]
    }
  }

  def edit = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (!siteLinkInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'siteLink.label', default: 'SiteLink'), params.id])}"
      redirect(action: "list")
    }
    else {
      return [siteLinkInstance: siteLinkInstance]
    }
  }

  def update = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (siteLinkInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (siteLinkInstance.version > version) {

          siteLinkInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'siteLink.label', default: 'SiteLink')] as Object[], "Another user has updated this SiteLink while you were editing")
          render(view: "edit", model: [siteLinkInstance: siteLinkInstance])
          return
        }
      }
      siteLinkInstance.properties = params
      if (!siteLinkInstance.hasErrors() && siteLinkInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'siteLink.label', default: 'SiteLink'), siteLinkInstance.id])}"
        redirect(action: "show", id: siteLinkInstance.id)
      }
      else {
        render(view: "edit", model: [siteLinkInstance: siteLinkInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'siteLink.label', default: 'SiteLink'), params.id])}"
      redirect(action: "list")
    }
  }

  def delete = {
    def siteLinkInstance = SiteLink.get(params.id)
    if (siteLinkInstance) {
      try {
        siteLinkInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'siteLink.label', default: 'SiteLink'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'siteLink.label', default: 'SiteLink'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'siteLink.label', default: 'SiteLink'), params.id])}"
      redirect(action: "list")
    }
  }

  def corpSites(siteLink) {
    def ret = siteLinkService.getSites(siteLink.corpCode, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )

    updateCount = createCount = unitCount = 0

    records.'soap:Body'.'*:SiteSearchByPostalCodeResponse'.'*:SiteSearchByPostalCodeResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      StorageSite site = StorageSite.findBySourceAndSourceId("SL", tab.SiteID.text())
      if (site) {
        updateCount++
        site.contacts.each {contact ->
          contact.delete()
        }
        site.units.each {unit ->
          unit.delete()
        }
      } else {
        site = new StorageSite()
        createCount++
      }
      def address = tab.sSiteAddr1.text() + ' ' + tab.sSiteAddr2.text() + ', ' + tab.sSiteCity.text() + ', ' + tab.sSiteRegion.text() + ' ' + tab.sSitePostalCode.text()
      def geoResult = geocodeService.geocode(address)

      site.lng = geoResult.Placemark[0].Point.coordinates[0]
      site.lat = geoResult.Placemark[0].Point.coordinates[1]

      site.sourceId = tab.SiteID.text()
      site.sourceLoc = tab.sLocationCode.text()
      site.source = "SL"
      site.title = tab.sSiteName.text()
      site.address = tab.sSiteAddr1.text()
      site.address2 = tab.sSiteAddr2.text()
      site.city = tab.sSiteCity.text()
      site.state = tab.sSiteRegion.text()
      site.zipcode = tab.sSitePostalCode.text()
      site.requiresInsurance = false
      site.boxesAvailable = true
      site.freeTruck = false
      site.isGate = false
      site.isKeypad = false
      site.isCamera = false
      site.isUnitAlarmed = false

      def contact = new SiteContact(email: tab.sEmailAddress.text(), name: tab.sContactName.text())
      site.addToContacts(contact)

      site.save()
      
      unitsAvailable(siteLink, site)

      site.save(flush: true)
    }
  }

  def unitsAvailable(siteLink, site) {
    def ret = siteLinkService.getUnitsAvailable(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password, 0)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    records.'soap:Body'.'*:UnitsInformationAvailableUnitsOnly_v2Response'.'*:UnitsInformationAvailableUnitsOnly_v2Result'.'*:diffgram'.NewDataSet.'*:Table'.each {unit ->
      def siteUnit = new StorageUnit()
      siteUnit.description = unit.sTypeName.text()
      siteUnit.unitNumber = unit.UnitID.text()
      siteUnit.price = new BigDecimal(unit.dcStdRate.text())
      def floor = Integer.parseInt(unit.iFloor.text())
      def typeName = unit.sTypeName.text()
      siteUnit.isUpper = (floor > 1 || floor == 1 && typeName ==~ /(2ND|3RD).+/)
      siteUnit.isInterior = Boolean.parseBoolean(unit.bInside.text()) || typeName ==~ /MAIN FLOOR*/
      siteUnit.isAlarm = Boolean.parseBoolean(unit.bAlarm.text())
      siteUnit.isTempControlled = Boolean.parseBoolean(unit.bClimate.text())
      siteUnit.isDriveup = ((!siteUnit.isUpper && !siteUnit.isInterior) || typeName ==~ /DRIVE UP*/)
      siteUnit.isPowered = Boolean.parseBoolean(unit.bPower.text())
      siteUnit.isAvailable = true
      siteUnit.isSecure = false
      Integer width = (int) Double.parseDouble(unit.dcWidth.text())
      Integer length = (int) Double.parseDouble(unit.dcLength.text())
      siteUnit.displaySize = width + " X " + length

      def unitSize = StorageSize.findByWidthAndLength(width, length)
      if (unitSize == null) {

        def unitArea = width * length
        def foundSize = 0
        StorageSize.findAll().each {u ->
          if (Math.abs(unitArea - foundSize) > Math.abs(unitArea - u.width * u.length)) {
            unitSize = u
            foundSize = u.width * u.length
          }
        }
      }
      if (unitSize) {
        siteUnit.unitsize = unitSize
        if (!siteUnit.save()) {
          siteUnit.errors.allErrors.each { println it }
        }
        unitCount++;

        site.addToUnits(siteUnit)
      } else {
        println "Skipping unit due to size: width=" + width + " length=" + length
      }
    }
  }


}
