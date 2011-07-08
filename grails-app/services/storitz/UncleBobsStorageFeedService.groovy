package storitz

import com.storitz.StorageSite
import com.storitz.RentalTransaction
import com.storitz.Feed
import com.storitz.UncleBobs
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import static groovyx.net.http.ContentType.XML
import storitz.constants.State
import storitz.constants.TruckType
import storitz.constants.TransactionType
import com.storitz.StorageUnit
import storitz.constants.SearchType
import com.storitz.StorageSize
import storitz.constants.UnitType
import com.storitz.SpecialOffer
import storitz.constants.PromoType
import com.storitz.SpecialOfferRestriction
import storitz.constants.SpecialOfferRestrictionType
import com.storitz.SiteUser

class UncleBobsStorageFeedService extends BaseProviderStorageFeedService {

  // replace '<COMPANY>' with company name
  static final String uncleBobsStoreLocationFeedURL    = "http://www.unclebobs.com/xmlfeeds/<COMPANY>/stores.cfm";
  static final String uncleBobsStoreInventoryFeedURL   = "http://www.unclebobs.com/xmlfeeds/<COMPANY>/index.cfm?store=<ID>";
  static final String uncleBobsStoreReservationFeedURL = "http://www.unclebobs.com/xmlfeeds/<COMPANY>/reserve.cfm";

  private String UBCompanyName
  private UnitSizeService unitSizeService = new UnitSizeService()

  public UncleBobsStorageFeedService (String UBCompanyName) {
    this.UBCompanyName = UBCompanyName
  }

  private String getStoreLocationFeedURL() {
    return uncleBobsStoreLocationFeedURL.replace("<COMPANY>", UBCompanyName)
  }

  private String getStoreInventoryFeedURL(String id) {
    return uncleBobsStoreInventoryFeedURL.replace("<COMPANY>", UBCompanyName).replace("<ID>",id)
  }

  private String getStoreReservationFeedURL() {
    return uncleBobsStoreReservationFeedURL.replace("<COMPANY>", UBCompanyName)
  }

  def emailService

  EmailService getEmailService() {
    if (!emailService) {
      emailService = new EmailService()
    }
    return emailService
  }

  ///////////////////////
  // Interface Methods //
  ///////////////////////

  @Override
  void updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
    String sites = httpGetAction(getStoreLocationFeedURL())
    def xmlNodes = getXmlFromFeedString(sites,"<unclebobs>")
    if (!xmlNodes) {
      return
    }

    for (int i = 0; i < xmlNodes.store.size(); i++) {
      def store_id       = xmlNodes.store[i].@id      as String
      def store_name     = xmlNodes.store[i].name     as String
      def store_address  = xmlNodes.store[i].address  as String
      def store_city     = xmlNodes.store[i].city     as String
      def store_state    = xmlNodes.store[i].state    as String
      def store_zip      = xmlNodes.store[i].zip      as String
      def store_phone    = xmlNodes.store[i].phone    as String
      if (storageSiteInstance.sourceLoc == store_id) {
        writer.println "Updating site ${store_name}}"
        storageSiteInstance.address = store_address
        storageSiteInstance.city = store_city
        storageSiteInstance.state = State.fromText(store_state)
        storageSiteInstance.zipcode = store_zip
        storageSiteInstance.phone = store_phone
        geoCodeSite(storageSiteInstance)
        updateUnits (storageSiteInstance, stats, writer)
        storageSiteInstance.save(flush:true)
      }
    }
  }

  @Override
  void updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
    zeroOutUnitsForSite(storageSiteInstance,stats,writer)

    String units = httpGetAction(getStoreInventoryFeedURL(storageSiteInstance.sourceLoc))
    def xmlNodes = getXmlFromFeedString(units,"<store>")
    if (!xmlNodes) {
      return
    }

    // Location specific information. Duplicate info we already have
    def store_id      = xmlNodes.id
    def store_name    = xmlNodes.name
    def store_address = xmlNodes.address
    def store_city    = xmlNodes.city
    def store_state   = xmlNodes.state
    def store_zip     = xmlNodes.zip

    // Unit specific info.
    for (int i = 0; i < xmlNodes.space.size(); i++) {
      def space_id        = xmlNodes.space[i].@id           as String
      def space_width     = xmlNodes.space[i].width         as String
      def space_length    = xmlNodes.space[i].length        as String
      def space_height    = xmlNodes.space[i].height        as String
      def space_climate   = xmlNodes.space[i].climate       as String
      def space_access    = xmlNodes.space[i].access        as String
      def space_floor     = xmlNodes.space[i].floor         as String
      def space_regprice  = xmlNodes.space[i].regprice      as String
      def space_curprice  = xmlNodes.space[i].curprice      as String
      def space_avail     = xmlNodes.space[i].avail         as String
      def space_special   = xmlNodes.space[i].special       as String
      def unit = createUpdateUnit(
          storageSiteInstance
          ,stats
          ,writer
          ,space_id
          ,new Double(space_width).doubleValue()
          ,new Double(space_length).doubleValue()
          ,new Double(space_height).doubleValue()
          ,space_climate
          ,space_access
          ,new Double(space_floor).doubleValue()
          ,new Double(space_regprice).doubleValue()
          ,new Double(space_curprice).doubleValue()
          ,new Double(space_avail).doubleValue()
          ,space_special.trim())

      if (unit) {
        storageSiteInstance.addToUnits(unit)
        loadPromos(storageSiteInstance,unit,space_special.trim())
      }
    }
  }

  @Override
  void loadPromos(StorageSite storageSiteInstance, PrintWriter writer) {
    // NO OP: promos are loaded along with inventory
  }

  @Override
  void addSitePhone(StorageSite storageSiteInstance, PrintWriter writer) {
    // NO OP: phones are loaded along with sites
  }

  @Override
  boolean isAvailable(RentalTransaction trans) {

    StorageUnit unit = StorageUnit.findById(trans.unitId)
    if (!unit) {
      println "Storage Unit ${trans.unitId} not found for transaction ${trans.id}!"
      return false
    }

    def unit_number = unit.unitNumber

    // Look for this unit in the available inventory from the feed
    String units = httpGetAction(getStoreInventoryFeedURL(trans.site.sourceLoc))
    def xmlNodes = getXmlFromFeedString(units,"<store>")
    if (!xmlNodes) {
      return false
    }

    // Unit specific info.
    for (int i = 0; i < xmlNodes.space.size(); i++) {
      def space_id        = xmlNodes.space[i].@id   as String
      def space_avail     = xmlNodes.space[i].avail as String

      if (space_id == unit_number) {
        return space_avail > 0
      }
    }

    return false
  }

  @Override
  loadInsurance(Feed feed, StorageSite site) {
    return null
  }

  @Override
  boolean moveIn(RentalTransaction trans) {
    return reserve(trans)
  }

  @Override
  boolean reserve(RentalTransaction trans) {
    def contact = trans.contactPrimary
    def address = contact.address2 ? "${contact.address1}, ${contact.address2}" : contact.address1
    def unit = StorageUnit.findById(trans.unitId)

    def payload = """<leadinfo>
  <note id="0">
    <ResID>""" + trans.bookingDate.format('yyyyMMdd') + sprintf('%08d', trans.id) + """</ResID>
    <dateNeeded>""" + trans.moveInDate.format("MM/dd/yyyy") + """</dateNeeded>
    <dateSubmitted>""" + trans.bookingDate.format("MM/dd/yyyy hh:mm:ss a") + """</dateSubmitted>
    <Email>""" + contact.email + """</Email>
    <NameFirst>""" + contact.firstName + """</NameFirst>
    <NameLast>""" + contact.lastName + """</NameLast>
    <Phone>""" + contact.phone + """</Phone>
    <Address>""" + address + """</Address>
    <City>""" + contact.city + """</City>
    <State>""" + contact.state.display + """</State>
    <Zip>""" + contact.zipcode + """</Zip>
    <Store>""" + trans.site.sourceLoc + """</Store>
    <Space>""" + unit.unitNumber + """</Space>
  </note>
</leadinfo>
    """

    println "/// UNCLE BOB'S RESERVATION REQUEST ///"
    println payload

    def resText     = httpPostAction (payload,getStoreReservationFeedURL())

    println "/// UNCLE BOB'S RESERVATION RESPONSE ///"
    println resText

    def retVal      = false
    def resMatcher  = resText =~ /(.*):(.*)/
    def resStatus   = null
    def resDetails  = null
    if (resMatcher.getCount()) {
      resStatus     = resMatcher[0][1]?.trim()
      resDetails    = resMatcher[0][2]?.trim()
    }

    if (resStatus?.startsWith("Success")) {
      retVal = true
      trans.idNumber = resDetails
      trans.feedUnitNumber = unit.unitNumber
      trans.save(flush:true)
    }
    else {
      StringBuffer body = new StringBuffer()
      body.append("Failed Uncle Bob's Reservation")
      body.append("\n ")
      body.append("\n REQUEST")
      body.append("\n ${payload}")
      body.append("\n ")
      body.append("\n RESPONSE")
      body.append("\n ${resText}")

      getEmailService().sendTextEmail(
        to: "notifications@storitz.com",
        from: "no-reply@storitz.com",
        subject: "UNCLEBOB - failed move-in",
        body: body.toString())
    }

    return retVal
  }

  @Override
  void init(StorageSite site) {
    UncleBobs uncleBobs = (UncleBobs)site.feed
    UBCompanyName = uncleBobs.UBCompanyName
  }

  @Override
  void refreshSites(Feed feed, String source, SiteStats stats, PrintWriter writer) {
    String sites = httpGetAction(getStoreLocationFeedURL())
    def xmlNodes = getXmlFromFeedString(sites,"<unclebobs>")
    if (!xmlNodes) {
      return
    }

    for (int i = 0; i < xmlNodes.store.size(); i++) {
      def store_id       = xmlNodes.store[i].@id      as String
      def store_name     = xmlNodes.store[i].name     as String
      def store_address  = xmlNodes.store[i].address  as String
      def store_city     = xmlNodes.store[i].city     as String
      def store_state    = xmlNodes.store[i].state    as String
      def store_zip      = xmlNodes.store[i].zip      as String
      def store_phone    = xmlNodes.store[i].phone    as String
      def site = createUpdateSite(store_id,store_name,store_address,store_city,store_state,store_zip,store_phone)
      feed.addToSites(site)
      SiteUser.link(site, feed.manager)
    }
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  private def httpPostAction(url, payload) {
    try {
      def http = new HTTPBuilder(url)

      http.handler.failure = {resp, req ->
        println "Unexpected failure: ${resp.statusLine} ${resp.dump()}"
      }

      http.request(Method.POST, XML) { req ->
        delegate.headers['Content-Type'] = "text/xml"

        body = payload

        response.error = {resp ->
          println "${resp.statusLine}"
        }
      }
    } catch (Throwable t) {
      t.printStackTrace()
    }
  }

  private def httpGetAction(url) {
    url.toURL().text
  }

  private def createUpdateSite (id,name,address,city,state,zip,phone) {
    StorageSite site = StorageSite.findBySourceAndSourceLoc('BOB',id)
    if (!site) {
      site = new StorageSite()

      // I know these values...
      site.source              = "BOB"
      site.sourceLoc           = id
      site.title               = "${name} - ${city} - ${id}"
      site.transactionType     = TransactionType.RENTAL
      site.lastChange          = new Date()

      // ...The rest are all basic defaults
      site.boxesAvailable      = false
      site.freeTruck           = TruckType.NONE
      site.isGate              = false
      site.isKeypad            = false
      site.isCamera            = false
      site.isUnitAlarmed       = false
      site.lastUpdate          = 0
      site.lat                 = 0
      site.lng                 = 0
      site.requiresInsurance   = false
      site.extendedHours       = false
      site.isManagerOnsite     = false
      site.hasElevator         = false
      site.taxRateMerchandise  = 0
      site.taxRateInsurance    = 0
      site.taxRateRental       = 0

    }
    site.address = address
    site.city = city
    site.state = State.fromText(state)
    site.zipcode = zip
    site.phone = phone
    geoCodeSite(site)

    SiteStats stats = new SiteStats()
    PrintWriter writer = new PrintWriter(System.out)
    updateUnits (site, stats, writer)

    return site.save(flush:true)
  }

  private def createUpdateUnit(site,stats,writer,space_id,space_width,space_length,
                               space_height,space_climate,space_access,
                               space_floor,space_regprice,space_curprice,
                               space_avail,space_special) {

    // Check the unit size (and possibly eliminate this as a potential unit)
    // before we fetch/create the actual unit so our site stats remain accurate.
    StorageSize unitSize = unitSizeService.getUnitSize(space_width, space_length, SearchType.STORAGE)
    if (!unitSize) {
      printf ("Cannot determine unitSize for ${space_width}, ${space_length}. Skipping\n")
      return
    }

    StorageUnit unit = site.units.find { it.unitName == space_id }
    if (!unit) {
      unit              = new StorageUnit()
      unit.unitName     = space_id
      unit.unitNumber   = space_id
      unit.isAlarm      = false;
      unit.isIrregular  = false
      unit.isPowered    = false;
      unit.isSecure     = true;
      stats.createCount++
    }
    else {
      stats.updateCount++
      stats.unitCount++
      stats.removedCount--
    }

    unit.price              = space_regprice
    unit.pushRate           = space_curprice
    unit.unitsize           = unitSize
    unit.unitType           = bestGuessUnitType (space_floor, space_access)
    unit.isAvailable        = true
    unit.unitCount          = space_avail
    unit.displaySize        = "${space_width as int} X ${space_length as int}"
    unit.isTempControlled   = bestGuessTempControl(space_climate)
    unit.unitSizeInfo       = "${space_width}X${space_length}"
    unit.unitTypeInfo       = "${space_id}:${space_width}X${space_length}"

    return unit.save()
  }

  def loadPromos(StorageSite site, StorageUnit unit, special) {
    def code = "${site.sourceLoc}:${unit.unitSizeInfo}"

    ///////////////////
    // SPECIAL OFFER //
    ///////////////////
    def specialOffer = site.specialOffers.find { it.code == code}
    if (!specialOffer) {
      specialOffer = new SpecialOffer()
      specialOffer.expireMonth  = 1
      specialOffer.inMonth      = 1
      specialOffer.prepayMonths = 0
      specialOffer.code         = code
      site.addToSpecialOffers(specialOffer)
    }
    if (!special) {
      specialOffer.featured     = false
      specialOffer.active       = false
    }
    else {
      specialOffer.featured     = true
      specialOffer.active       = true
    }
    specialOffer.description  = special
    if (!specialOffer.promoName) specialOffer.promoName = special
    specialOffer.promoType    = PromoType.AMOUNT_OFF // non-quantifiable special
    specialOffer.promoQty     = 0                    // non-quantifiable special
    specialOffer.save()

    ///////////////////////////////
    // SPECIAL OFFER RESTRICTION //
    ///////////////////////////////
    def specialOfferRestriction = specialOffer.restrictions.find { it.restrictionInfo = unit.unitTypeInfo }
    if (!specialOfferRestriction) {
      specialOfferRestriction = new SpecialOfferRestriction()
      specialOfferRestriction.restrictionInfo = unit.unitTypeInfo
      specialOfferRestriction.restrictive = false
      specialOfferRestriction.type = SpecialOfferRestrictionType.UNIT_TYPE
      specialOfferRestriction.save()
      specialOffer.addToRestrictions(specialOfferRestriction)
    }

  }

  private bestGuessTempControl (space_climate) {
    // options:
    // "non-climate controlled"           // no
    // "climate-controlled"               // yes
    // "humidity controlled"              // yes
    // "humidity/climate controlled"      // yes

    String climate = space_climate;
    if (climate.equalsIgnoreCase("non-climate controlled")) {
      return false
    }
    return true
  }

  private bestGuessUnitType (space_floor, space_access) {
    if (space_floor > 1) {
      return UnitType.UPPER
    }

    String access = space_access;
    if (access.toLowerCase().contains("outside")) {
      return UnitType.DRIVEUP
    }

    if (access.toLowerCase().contains("drive up")) {
      return UnitType.DRIVEUP
    }

    return UnitType.INTERIOR
  }

  private def getXmlFromFeedString(feedString, feedNode) {
    int start = feedString.indexOf(feedNode)
    if (start < 0) {
      println "Cannot determine start for Uncle Bob's! ${feedNode}}"
      return null
    }
    return grails.converters.XML.parse(feedString.substring(start))
  }

}
