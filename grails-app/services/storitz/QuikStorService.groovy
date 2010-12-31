package storitz

import com.storitz.Insurance
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.StorageSite
import com.storitz.RentalTransaction
import com.storitz.QuikStor
import groovyx.net.ws.WSClient
import com.storitz.QuikStorLocation
import storitz.constants.State
import com.storitz.SiteUser
import com.storitz.Role
import com.storitz.UserRole
import com.storitz.UserNotificationType
import com.storitz.NotificationType
import com.storitz.User
import storitz.constants.TruckType
import storitz.constants.UnitType

class QuikStorService {

    static transactional = false
    def proxy
    def geocodeService
    def unitSizeService

    private getProxy() {
      if (!proxy) {
        proxy = new WSClient("https://ecom.quikstor.com:443/eCom3ServiceSS/QuikStorWebServiceSS.asmx?WSDL", this.class.classLoader)
        proxy.initialize()
      }
      return proxy
    }

    private getFacilityInfo(QuikStorLocation loc) {
      def myProxy = getProxy()
      def facilityInfo = myProxy.create("org.tempuri.FacilityInfo")
      facilityInfo.setCsSiteName(loc.sitename)
      facilityInfo.setCsUser(loc.username)
      facilityInfo.setCsPassword(loc.password)
      return myProxy.FacilityInfo(facilityInfo.csUser, facilityInfo.csPassword, facilityInfo.csSiteName)
    }

    def processLocations(QuikStor quikStor, SiteStats stats, PrintWriter writer) {
      for(loc in quikStor.locations) {
        if (loc.site) {
          // TODO this one already exists
          println "Found an existing site: ${loc.site.title}"
        } else {
          def site = new StorageSite()
          site.feed = quikStor
          updateSite(site, stats, writer)
          SiteUser.link(site, quikStor.manager)
          loc.site = site
          quikStor.addToSites(site)
          createSiteUser(site, facInfo.csSiteEmail, facInfo.csSiteEmail, quikStor.manager)
          loadInsurance(site, loc)
        }
      }

    }

    def createSiteUser(site, email, realName, manager) {
      def user = User.findByEmail(email)
      if (!user) {
        user = new User(
          username:email,
          password: (Math.random() * System.currentTimeMillis()) as String,
          description: "Site Manager for ${site.title}",
          email: email,
          userRealName:realName,
          accountExpired: false,
          accountLocked: false,
          passwordExpired: false,
          enabled: false
        )
        user.manager = manager
        if (user.validate()) {
          user.save(flush: true)
          SiteUser.link(site, user)
        } else {
          println "Bad user from feed - errors below: "
          user.errors.allErrors.each {
            println it
          }
          return;
        }
      }
      if (!UserNotificationType.userHasNotificationType(user, 'NOTIFICATION_SITE_MANAGER')) {
        def notificationType = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
        UserNotificationType.create(user, notificationType, true)
      }
      if (!UserRole.userHasRole(user,'ROLE_USER')) {
        UserRole.create(user, Role.findByAuthority('ROLE_USER'), true)
      }
    }

    def loadInsurance(StorageSite site, QuikStorLocation loc) {
      def myProxy = getProxy()
      def availIns = proxy.create("org.tempuri.AvailableInsurance")
      availIns.setCsSiteName(loc.sitename)
      availIns.setCsUser(loc.username)
      availIns.setCsPassword(loc.password)
      def insurances = myProxy.AvailableInsurance(availIns.csUser, availIns.csPassword, availIns.csSiteName)

      for(ins in insurances.availableInsuranceST) {
        def myIns = site.insurances.find{ it.totalCoverage == ins.dCoverageAmount && it.percentTheft == ins.dCoveragePercentage }
        if (myIns) {
          myIns.premium = ins.dMonthlyFee
          println "Updating insurance Coverage:${myIns.totalCoverage} percentTheft: ${myIns.percentTheft} Monthly: ${myIns.premium}"
          myIns.save(flush:true)
        } else {
          if (ins.typeID && ins.typeDesc) {
            myIns = new Insurance()
            myIns.totalCoverage = ins.dCoverageAmount
            myIns.percentTheft = ins.dCoveragePercentage
            myIns.insuranceId = 0
            myIns.premium = ins.dMonthlyFee
            myIns.active = true
            myIns.provider = ins.typeDesc
            myIns.save(flush:true)
            site.addToInsurances(myIns)
            println "Created insurance Coverage:${myIns.totalCoverage} percentTheft: ${myIns.percentTheft} Monthly: ${myIns.premium}"
          }
        }
      }
    }

  
    def createSiteUsers(QuikStor quikStor) {

    }

    def createSiteTaxes(QuikStor quikStor) {

    }

    def updateSite(StorageSite site, SiteStats stats, PrintWriter writer) {
      def quikStor = (QuikStor)site.feed
      def loc = quikStor.locations.find{it.site = site}
      def facInfo = getFacilityInfo(loc)

      if (facInfo.success) {
        site.title = facInfo.csSiteName
        site.address = facInfo.csSiteAddress.trim()
        site.city = facInfo.csSiteCity.trim()
        site.state = State.getEnumFromId(facInfo.csSiteState)
        site.zipcode = facInfo.csSiteZip
        site.phone = facInfo.csSitePhone

        def address = site.address  + ' ' + ', ' + site.city + ', ' + site.state.display + ' ' + site.zipcode

        println "Found address: ${address}"
        def geoResult = geocodeService.geocode(address)

        site.lng = geoResult.Placemark[0].Point.coordinates[0]
        site.lat = geoResult.Placemark[0].Point.coordinates[1]

        site.feed = quikStor
        site.sourceId = loc.password
        site.sourceLoc = loc.username
        site.source = "QS"

        site.disabled = false
        site.netCommission = false
        site.lastChange = new Date()
        site.lastUpdate = 0

        site.taxRateMerchandise = 0
        site.taxRateInsurance = 0
        site.taxRateRental = 0

        site.freeTruck = TruckType.NONE
        site.isCamera = false
        site.isGate = false
        site.isKeypad = false
        site.isManagerOnsite = false
        site.isUnitAlarmed = false
        site.hasElevator = false

        site.extendedHours = false

        site.save(flush:true)
      }
    }

    def updateUnits(StorageSite site, SiteStats stats, PrintWriter writer) {
      def quikStor = (QuikStor)site.feed
      def loc = quikStor.locations.find{it.site = site}
      def myProxy = getProxy()
      def availUnits = myProxy.create("org.tempuri.JustAvailableUnitTypesSpecial")
      availUnits.setCsSiteName(loc.sitename)
      availUnits.setCsUser(loc.username)
      availUnits.setCsPassword(loc.password)
      def unitTypes = myProxy.JustAvailableUnitTypesSpecial(availUnits.csUser, availUnits.csPassword, availUnits.csSiteName)
      for(unitType in unitTypes.availableUnitTypesSpecialST) {
        writer.println "Found unitType: ${unitType.dump()}"
        def unit = site.units.find{it.unitNumber == unitType.iTypeId }
        if (unit) {
          if (unitType.availability > unit.unitCount) {
            stats.updateCount += (unitType.availability - unit.unitCount)
            unit.unitCount = unitType.availability
            unit.price = unit.pushRate = unitType.dPrice
            unit.save(flush:true)
          } else if (unitType.availability < unit.unitCount) {
            stats.removedCount += (unit.unitCount - unitType.availability)
            unit.unitCount = unitType.availability
            unit.price = unit.pushRate = unitType.dPrice
            unit.save(flush:true)
          }
        } else {
          def unitInfoReq = myProxy.create("org.tempuri.UnitTypeInfo")
          unitInfoReq.setCsSiteName(loc.sitename)
          unitInfoReq.setCsUser(loc.username)
          unitInfoReq.setCsPassword(loc.password)
          unitInfoReq.setItypeId(unitType.iTypeId)
          def unitInfo = myProxy.UnitTypeInfo(unitInfoReq.csUser, unitInfoReq.csPassword, unitInfoReq.csSiteName, unitInfoReq.itypeId)
          writer.println ("retrieved unitInfo ${unitInfo.dump()}")
          if (unitInfo.csUnitType != 'Parking') {
            def unitsize = unitSizeService.getUnitSize(unitInfo.dWidth, unitInfo.dLength)
            if (unitsize) {
              unit = new StorageUnit()
              unit.unitNumber = unitType.iTypeId
              unit.price = unit.pushRate = unitType.dPrice
              unit.displaySize = unitType.sTypeDescription.tokenize(',')[0]
              unit.unitsize = unitsize
              unit.isAvailable = true
              unit.isSecure = false
              unit.isTempControlled = unitInfo.csUnitType == 'Climate'
              unit.isAlarm = false
              unit.isPowered = false
              unit.isIrregular = false
              unit.description = unitType.sTypeDescription
              unit.unitCount = unitType.availability
              stats.createCount += unit.unitCount
              if (unitInfo.iFloor > 1) {
                unit.unitType = UnitType.UPPER
              } else {
                if (unitInfo.csInside == 'Inside') {
                  // TODO - determine how to distinguish INTERIOR from DRIVEUP
                  unit.unitType = UnitType.INTERIOR
                } else {
                  unit.unitType = UnitType.DRIVEUP
                }
              }
              unit.save(flush:true)
              site.addToUnits(unit)
              writer.println "Created new unit ${unit.dump()}"
            } else {
              writer.println "Skipped due to unit size: ${unitInfo.dWidth} X ${unitInfo.dLength}"
            }
          } else {
            writer.println "Skipped due to unsupported type: ${unitInfo.csUnitType}"
          }
        }
      }
    }

    def loadPromos(QuikStor quickStor, StorageSite storageSiteInstance, PrintWriter writer) {

    }

    def addSitePhone(QuikStor quikStor, StorageSite storageSiteInstance, PrintWriter writer) {

    }

    def checkRented(RentalTransaction trans) {

    }

    def moveInDetail(RentalTransaction trans) {
      
    }

    def createTenant(RentalTransaction trans) {

    }

    def moveIn(RentalTransaction trans) {
      
    }

    def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, Boolean extended) {

    }

    def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate) {

    }

    def calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate, Boolean allowExtension) {

    }


}
