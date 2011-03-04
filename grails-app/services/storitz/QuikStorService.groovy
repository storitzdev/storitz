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
import javax.xml.datatype.XMLGregorianCalendar
import javax.xml.datatype.DatatypeFactory
import com.storitz.Feed
import storitz.constants.SearchType
import storitz.constants.TransactionType
import com.storitz.SpecialOfferRestriction
import storitz.constants.SpecialOfferRestrictionType
import storitz.constants.PromoType

class QuikStorService extends BaseProviderService {

    def proxy = [:]
    def geocodeService
    def unitSizeService

    private getProxy(url) {
      if (!proxy[url]) {
        proxy[url] = new WSClient(url, this.class.classLoader)
        java.util.logging.Logger logger = proxy[url].getLogger()
        logger.setLevel(java.util.logging.Level.WARNING)
        proxy[url].initialize()
      }
      try {
        proxy[url].HelloWorld()
      } catch (Exception e) {
        proxy[url] = new WSClient(url, this.class.classLoader)
        java.util.logging.Logger logger = proxy[url].getLogger()
        logger.setLevel(java.util.logging.Level.WARNING)
        proxy[url].initialize()
      }
      return proxy[url]
    }

    private getFacilityInfo(QuikStorLocation loc) {
      def myProxy = getProxy(loc.quikStor.url)
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
          site.transactionType = TransactionType.RENTAL
          site.minInventory = 0
          site.rentalFee = 0
          loc.site = site
          updateSite(site, stats, writer)
          SiteUser.link(site, quikStor.manager)
          quikStor.addToSites(site)
          def facInfo = getFacilityInfo(loc)
          createSiteUser(site, facInfo.csSiteEmail, facInfo.csSiteEmail, quikStor.manager)
          loadInsurance(site, loc)
          loadPromos(quikStor, site, writer)
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

    def refreshInsurance(Feed feed) {
      QuikStor quikStor = (QuikStor)feed

      for (loc in quikStor.locations) {
        loadInsurance(loc.site, loc)
      }
    }

    def loadInsurance(Feed feed, StorageSite site) {
      
    }

    def loadInsurance(StorageSite site, QuikStorLocation loc) {
      def myProxy = getProxy(loc.quikStor.url)
      def availIns = myProxy.create("org.tempuri.AvailableInsurance")
      availIns.setCsSiteName(loc.sitename)
      availIns.setCsUser(loc.username)
      availIns.setCsPassword(loc.password)
      def insurances = myProxy.AvailableInsurance(availIns.csUser, availIns.csPassword, availIns.csSiteName)

      def siteInsurances = [:]
      site.insurances.each{ siteInsurances[it.provider] = false }

      for(ins in insurances?.availableInsuranceST) {
        def myIns = site.insurances.find{ it.totalCoverage == ins.dCoverageAmount && it.percentTheft == ins.dCoveragePercentage }
        siteInsurances[ins.typeDesc] = true
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
      for(entry in siteInsurances.entrySet()) {
        if (!entry.value) {
          def ins = site.insurances.find{it.provider == entry.key}
          println "Cleanup found deleted type: ${entry.key} - removing ${ins.id}"
          site.removeFromInsurances(ins)
        }
      }

    }

  
    def createSiteUsers(QuikStor quikStor) {
      // do nothing

    }

    def createSiteTaxes(QuikStor quikStor) {
      // do nothing

    }

    def refreshSites(QuikStor, SiteStats stats) {
      
    }

    def updateSite(StorageSite site, SiteStats stats, PrintWriter writer) {
      def quikStor = (QuikStor)site.feed
      def loc = quikStor.locations.find{it.site == site}

      def myProxy = getProxy(loc.quikStor.url)
      def facilityInfo = myProxy.create("org.tempuri.FacilityInfo")
      facilityInfo.setCsSiteName(loc.sitename)
      facilityInfo.setCsUser(loc.username)
      facilityInfo.setCsPassword(loc.password)
      def facInfo = myProxy.FacilityInfo(facilityInfo.csUser, facilityInfo.csPassword, facilityInfo.csSiteName)

      if (facInfo.success) {
        site.title = facInfo.csSiteName
        site.address = facInfo.csSiteAddress.trim()
        site.city = facInfo.csSiteCity.trim()
        site.state = State.getEnumFromId(facInfo.csSiteState)
        site.zipcode = facInfo.csSiteZip
        site.phone = facInfo.csSitePhone

        def address = site.address  + ', ' + site.city + ', ' + site.state.display + ' ' + site.zipcode

        println "Found address: ${address}"
        def geoResult = geocodeService.geocode(address)

        site.lng = geoResult.results[0].geometry.location.lng
        site.lat = geoResult.results[0].geometry.location.lat

        site.feed = quikStor
        site.sourceId = loc.password
        site.sourceLoc = loc.username
        site.source = "QS"

        site.disabled = false
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

        site.minInventory = 0
        site.transactionType = TransactionType.RENTAL
        site.netCommission = false
        site.allowPushPrice = true

        site.extendedHours = false

        site.save(flush:true)

        // Determine prorated or anniversary billing
        def facilityInfo2 = myProxy.create("org.tempuri.FacilityInfo2")
        facilityInfo2.setCsSiteName(loc.sitename)
        facilityInfo2.setCsUser(loc.username)
        facilityInfo2.setCsPassword(loc.password)
        def facInfo2 = myProxy.FacilityInfo2(facilityInfo2.csUser, facilityInfo2.csPassword, facilityInfo2.csSiteName)

        def found = false
        for(item in facInfo2.anyType) {
          if (item.csKey == 'ECommForceProRate') {
            site.useProrating = (item.obValue == 1)
            println "Setting prorating based on value ${item.obValue}"
            found = true
          }
        }
        if (!found) {
          site.useProrating = false
        }
        site.save(flush:true)

        // Determine admin fee
        def availUnits = myProxy.create("org.tempuri.AvailableUnitTypes")
        availUnits.setCsSiteName(loc.sitename)
        availUnits.setCsUser(loc.username)
        availUnits.setCsPassword(loc.password)
        def unitTypes = myProxy.AvailableUnitTypes(availUnits.csUser, availUnits.csPassword, availUnits.csSiteName)
        println "Available move in types: ${unitTypes.dump()}"
        if (unitTypes?.availableUnitTypesST[0]) {
          def myUnitType = unitTypes.availableUnitTypesST[0]

          def moveInReq = myProxy.create("org.tempuri.MoveInCost")
          moveInReq.setCsSiteName(loc.sitename)
          moveInReq.setCsUser(loc.username)
          moveInReq.setCsPassword(loc.password)
          moveInReq.setIUnitTypeId(myUnitType.iTypeId)
          GregorianCalendar gcal = new GregorianCalendar();
          XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
          moveInReq.setTMoveInDate(xgcal)
          def moveInCost = myProxy.MoveInCost(moveInReq.csUser, moveInReq.csPassword, moveInReq.csSiteName, moveInReq.iUnitTypeId, moveInReq.tMoveInDate)
          for(item in moveInCost.chargeST) {
            println "Move In cost item: ${item.itemDesc} amount = ${item.dItemAmount}"
            if (item.itemDesc == 'Setup Charge') {
              site.adminFee = item.dItemAmount
              site.save(flush:true)
            }
          }
        }
      }
    }

    def updateUnits(StorageSite site, SiteStats stats, PrintWriter writer) {
      def siteUnitTypes = [:]
      site.units.each{ siteUnitTypes[it.unitNumber as Integer] = false }
      def quikStor = (QuikStor)site.feed
      def loc = quikStor.locations.find{it.site == site}
      def myProxy = getProxy(quikStor.url)
      def availUnits = myProxy.create("org.tempuri.JustAvailableUnitTypesSpecial")
      availUnits.setCsSiteName(loc.sitename)
      availUnits.setCsUser(loc.username)
      availUnits.setCsPassword(loc.password)
      def unitTypes = myProxy.JustAvailableUnitTypesSpecial(availUnits.csUser, availUnits.csPassword, availUnits.csSiteName)
      for(unitType in unitTypes.availableUnitTypesSpecialST) {
        def unit = site.units.find{it.unitNumber == unitType.iTypeId }
        siteUnitTypes[unitType.iTypeId as Integer] = true
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
          def searchType = SearchType.STORAGE
          if (unitInfo.csUnitType == 'Parking') {
            searchType = SearchType.PARKING
          }
          def unitsize = unitSizeService.getUnitSize(unitInfo.dWidth, unitInfo.dLength, searchType)
          if (unitsize) {
            unit = new StorageUnit()
            unit.unitNumber = unitType.iTypeId
            unit.unitTypeInfo = unitType.iTypeId
            unit.price = unit.pushRate = unitType.dPrice
            unit.displaySize = unitType.sTypeDescription.tokenize(',')[0]
            unit.unitSizeInfo = unit.displaySize
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
        }
      }
      // clean up
      println "Site type entries: ${siteUnitTypes.dump()}"
      for(entry in siteUnitTypes.entrySet()) {
        if (!entry.value) {
          def unit = site.units.find{(it.unitNumber as Integer) == entry.key}
          println "Cleanup found deleted type: ${entry.key} - removing ${unit.unitCount} units"
          stats.removedCount += unit.unitCount
          site.removeFromUnits(unit)
        }
      }
    }

    def loadPromos(QuikStor quikStor, StorageSite storageSiteInstance, PrintWriter writer) {

      // clear old restrictions
      for(specialOffer in storageSiteInstance.specialOffers) {
        specialOffer?.restrictions.clear()
        specialOffer.save(flush:true)
      }

      def loc = quikStor.locations.find{it.site == storageSiteInstance}
      
      def myProxy = getProxy(loc.quikStor.url)
      def availUnits = myProxy.create("org.tempuri.AvailableUnitTypes")
      availUnits.setCsSiteName(loc.sitename)
      availUnits.setCsUser(loc.username)
      availUnits.setCsPassword(loc.password)
      def unitTypes = myProxy.AvailableUnitTypes(availUnits.csUser, availUnits.csPassword, availUnits.csSiteName)
      def idList = []
      for(unitType in unitTypes.availableUnitTypesST) {
        Integer iTypeId = unitType.iTypeId as Integer
        writer.println "About to retrieve specials for type ${iTypeId}"
        def activeSpecials = myProxy.create("org.tempuri.GetUnitActiveSpecials")
        activeSpecials.setCsSiteName(loc.sitename)
        activeSpecials.setCsUser(loc.username)
        activeSpecials.setCsPassword(loc.password)
        activeSpecials.setITypeId(iTypeId)
        def unitSpecials  = myProxy.GetUnitActiveSpecials(activeSpecials.csUser, activeSpecials.csPassword, activeSpecials.csSiteName, activeSpecials.iTypeId)
        def specialsXml = new XmlSlurper().parseText(unitSpecials)
        for (specialOffer in specialsXml.SL.SpecialNode) {
          String specialId = specialOffer.SpecialID.text()
          idList.add(specialId)
          SpecialOffer so = storageSiteInstance.specialOffers.find{ it.code == specialId }
          if (!so) {
            so = new SpecialOffer()
            so.code = specialId
            so.active = false
            so.concessionId = 0
            so.waiveAdmin = false
            so.featured= false
            so.description = specialOffer.Title.text()
          }  else {
            writer.println "Found existing special id = ${specialId}"
          }
          so.promoName = specialOffer.Title.text()
          so.inMonth = 1
          so.prepayMonths = 0
          def periods = new XmlSlurper().parseText(specialOffer.SpecialXml.text().replaceAll('&lt;', '<').replaceAll('&gt;', '>'))
          for (period in periods.Periods.Period) {
            writer.println "Period name ${period.Name} active = ${period.Active}, duration = ${period.Duration}, type = ${period.DiscountType}, amount = ${period.Amount}"
            if (Boolean.parseBoolean(period.Active.text())) {
              String periodType = period.DiscountType.text()
              Integer duration = period.Duration.text() as Integer
              BigDecimal amount = period.Amount.text() as BigDecimal
              switch(period.Name.text()) {
                case "ProRate":
                  if (storageSiteInstance.useProrating) {
                    if (periodType != "FixedDiscount" || amount != 0) {
                      // TODO - see if this impacts promo
                    }
                  }
                  break
                case "Period1":
                  switch(periodType) {
                    case "FixedDiscount":
                      if (amount != 0) {
                        so.promoType = PromoType.AMOUNT_OFF
                        so.promoQty = amount
                        so.expireMonth = duration
                      } else {
                        so.prepay = true
                        so.prepayMonths = duration
                      }
                      break
                    case "PercentageDiscount":
                      so.promoType = PromoType.PERCENT_OFF
                      so.promoQty = amount
                      so.expireMonth = duration
                      break
                    case "FixedRate":
                      so.promoType = PromoType.FIXED_RATE
                      so.promoQty = amount
                      so.expireMonth = duration
                      break
                  }
                  break
                case "RentRaise1":
                  switch(periodType) {
                    case "FixedDiscount":
                      if (amount != 0) {
                        so.promoType = PromoType.AMOUNT_OFF
                        so.promoQty = amount
                      }
                      break
                    case "PercentageDiscount":
                      if (!so.promoType || so.promoType == PromoType.PERCENT_OFF) {
                        so.promoType = PromoType.PERCENT_OFF
                        so.promoQty = amount
                        so.expireMonth = duration
                      }
                      break
                    case "FixedRate":
                      if (!so.promoType || so.promoType == PromoType.FIXED_RATE) {
                        so.promoType = PromoType.FIXED_RATE
                        so.promoQty = amount
                        so.expireMonth = duration
                      }
                      break
                  }
                  break
              }
            }
          }
          // add restriction for type
          SpecialOfferRestriction restriction = new SpecialOfferRestriction()
          restriction.restrictionInfo = false
          restriction.type = SpecialOfferRestrictionType.UNIT_TYPE
          restriction.restrictionInfo = iTypeId as String
          restriction.save(flush:true)
          so.addToRestrictions(restriction)
          so.save(flush:true)
          storageSiteInstance.addToSpecialOffers(so)
        }
      }
      // clean up
      def deleteList = []
      for (offer in storageSiteInstance.specialOffers) {
        if (!(offer.code in idList)) {
          writer.println "Found old promo - deleting specialId = ${offer.code}"
          deleteList.add(offer)
        }
      }
      for (offer in deleteList) {
        storageSiteInstance.removeFromSpecialOffers(offer)
      }
      storageSiteInstance.save(flush:true)
    }

    def addSitePhone(QuikStor quikStor, StorageSite storageSiteInstance, PrintWriter writer) {
        // Do nothing
    }

    def checkRented(RentalTransaction trans) {
      def unit = StorageUnit.get(trans.unitId)
      def availUnits = myProxy.create("org.tempuri.JustAvailableUnitTypesSpecial")
      availUnits.setCsSiteName(loc.sitename)
      availUnits.setCsUser(loc.username)
      availUnits.setCsPassword(loc.password)
      def unitTypes = myProxy.JustAvailableUnitTypesSpecial(availUnits.csUser, availUnits.csPassword, availUnits.csSiteName)
      if (unit && unitType.find{it.iTypeId == unit.unitNumber}.size() > 0) {
        return true
      }
      return false
    }

    def createTenant(RentalTransaction trans) {

    }

    def moveIn(RentalTransaction trans) {
      
    }

}
