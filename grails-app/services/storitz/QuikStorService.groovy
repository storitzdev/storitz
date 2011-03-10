package storitz

import com.storitz.Insurance
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.StorageSite
import com.storitz.RentalTransaction
import com.storitz.QuikStor
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
import groovy.xml.MarkupBuilder
import org.tempuri.Service1
import org.tempuri.Service1Soap
import org.tempuri.PaymentST
import org.tempuri.UserAccountST
import storitz.constants.PhoneType

class QuikStorService extends BaseProviderService {

    def port = [:]
    def geocodeService
    def emailService
    def unitSizeService

    private getPort(url) {
      if (!port[url]) {
        URL wsUrl = new URL(url)
        def qsService = new Service1(wsUrl)
        port[url] = qsService.getService1Soap()
      }
      return port[url]
    }

    private getFacilityInfo(QuikStorLocation loc) {
      Service1Soap myProxy = getPort(loc.quikStor.url)
      return myProxy.facilityInfo(loc.username, loc.password, loc.sitename)
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
      Service1Soap myProxy = getPort(loc.quikStor.url)
      def insurances = myProxy.availableInsurance(loc.username, loc.password, loc.sitename)

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

      Service1Soap myProxy = getPort(loc.quikStor.url)
      def facInfo = myProxy.facilityInfo(loc.username, loc.password, loc.sitename)

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
        def facInfo2 = myProxy.facilityInfo2(loc.username, loc.password, loc.sitename)

        def found = false
        for(item in facInfo2.anyType) {
          if (item.csKey == 'ECommForceProRate') {
            site.useProrating = (item.obValue == 1)
            found = true
          }
        }
        if (!found) {
          site.useProrating = false
        }
        site.save(flush:true)

        // Determine admin fee
        def unitTypes = myProxy.availableUnitTypes(loc.username, loc.password, loc.sitename)
        if (unitTypes?.availableUnitTypesST[0]) {
          def myUnitType = unitTypes.availableUnitTypesST[0]

          GregorianCalendar gcal = new GregorianCalendar();
          XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
          def moveInCost = myProxy.moveInCost(loc.username, loc.password, loc.sitename, myUnitType.iTypeId, xgcal)
          for(item in moveInCost.chargeST) {
            if (item.itemDesc.toLowerCase() == 'setup charge') {
              site.adminFee = item.dItemAmount
              site.save(flush:true)
            }
            if (item.itemDesc.toLowerCase() == 'security deposit') {
              site.deposit = item.dItemAmount
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
      Service1Soap myProxy = getPort(quikStor.url)
      def unitTypes = myProxy.justAvailableUnitTypesSpecial(loc.username, loc.password, loc.sitename)
      for(unitType in unitTypes.availableUnitTypesSpecialST) {

        def unitDeposit
        GregorianCalendar gcal = new GregorianCalendar();
        XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        def moveInCost = myProxy.moveInCost(loc.username, loc.password, loc.sitename, unitType.iTypeId, xgcal)
        for(item in moveInCost.chargeST) {
          if (item.itemDesc.toLowerCase() == 'security deposit') {
            unitDeposit = item.dItemAmount
          }
        }

        def unit = site.units.find{it.unitNumber == unitType.iTypeId }
        siteUnitTypes[unitType.iTypeId as Integer] = true
        if (unit) {
          if (unitType.availability > unit.unitCount) {
            stats.updateCount += (unitType.availability - unit.unitCount)
            unit.unitCount = unitType.availability
            unit.price = unit.pushRate = unitType.dPrice
            unit.deposit = unitDeposit
            unit.save(flush:true)
          } else if (unitType.availability < unit.unitCount) {
            stats.removedCount += (unit.unitCount - unitType.availability)
            unit.unitCount = unitType.availability
            unit.price = unit.pushRate = unitType.dPrice
            unit.deposit = unitDeposit
            unit.save(flush:true)
          }
        } else {
          def unitInfo = myProxy.unitTypeInfo(loc.username, loc.password, loc.sitename, unitType.iTypeId)
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
            unit.deposit = unitDeposit
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
      for(entry in siteUnitTypes.entrySet()) {
        if (!entry.value) {
          def unit = site.units.find{(it.unitNumber as Integer) == entry.key}
          writer.println "Cleanup found deleted type: ${entry.key} - removing ${unit.unitCount} units"
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
      
      Service1Soap myProxy = getPort(loc.quikStor.url)
      def unitTypes = myProxy.availableUnitTypes(loc.username, loc.password, loc.sitename)
      def idList = []
      for(unitType in unitTypes.availableUnitTypesST) {
        Integer iTypeId = unitType.iTypeId as Integer
        writer.println "About to retrieve specials for type ${iTypeId}"
        def unitSpecials  = myProxy.getUnitActiveSpecials(loc.username, loc.password, loc.sitename, iTypeId)
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
          writer.println "Special offer id = ${specialId} - Title = ${so.promoName}"
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
                  if (periodType != "FixedDiscount" || amount != 0) {
                    switch(periodType) {
                      case "FixedDiscount":
                        if (storageSiteInstance.useProrating) {
                          if (amount != 0) {
                            so.promoType = PromoType.AMOUNT_OFF
                            so.promoQty = amount
                            so.expireMonth = duration
                          }
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
                  }
                  break
                case "Period1":
                  switch(periodType) {
                    case "FixedDiscount":
                      if (amount != 0) {
                        so.promoType = PromoType.AMOUNT_OFF
                        so.promoQty = amount
                        so.expireMonth = duration
                      } else if (so.promoType != PromoType.FIXED_RATE) {
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
                case "Period2":
                  switch(periodType) {
                    case "FixedDiscount":
                      if (amount != 0) {
                        so.promoType = PromoType.AMOUNT_OFF
                        so.promoQty = amount
                        so.expireMonth = duration
                      } else if (so.promoType != PromoType.FIXED_RATE) {
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

      QuikStor quikStor = (QuikStor)trans.site.feed
      def loc = quikStor.locations.find{it.site == trans.site}

      Service1Soap myProxy = getPort(loc.quikStor.url)
      def unitTypes = myProxy.justAvailableUnitTypesSpecial(loc.username, loc.password, loc.sitename)
      if (unit) {
        Long unitTypeId = unit.unitTypeInfo as Long
        for (availUnitType in unitTypes.availableUnitTypesSpecialST) {
          if (availUnitType.iTypeId == unitTypeId) {
            return true
          }
        }
      }
      return false
    }

    def createTenant(RentalTransaction trans) {

    }

    def moveIn(RentalTransaction trans) {
      def unit = StorageUnit.get(trans.unitId)
      String specialId = null
      if (trans.promoId != -999) {
        SpecialOffer specialOffer = SpecialOffer.get(trans.promoId)
        specialId = specialOffer.code
      }

      QuikStor quikStor = (QuikStor)trans.site.feed
      def loc = quikStor.locations.find{it.site == trans.site}

      Service1Soap myProxy = getPort(loc.quikStor.url)

      def retVal = false
      def errorMessage = ''

      def unitTypes = myProxy.justAvailableUnitTypesSpecial(loc.username, loc.password, loc.sitename)
      def sUnitID
      def specialXml
      BigDecimal totalMoveInCost = 0G
      if (unit) {
        Long unitTypeId = unit.unitTypeInfo as Long
        for (availUnitType in unitTypes.availableUnitTypesSpecialST) {
          if (availUnitType.iTypeId == unitTypeId) {
            sUnitID = availUnitType.sLastUnit
          }
        }
        if (specialId) {
          // grab the XML for the special
          def availUnitSpecials = myProxy.getUnitActiveSpecials(loc.username, loc.password, loc.sitename, unitTypeId)
          def specialsXml = new XmlSlurper().parseText(availUnitSpecials)
          for (specialOffer in specialsXml.SL.SpecialNode) {
            if (specialOffer.SpecialID.text() == specialId) {
              specialXml = specialOffer.SpecialXml.text()
            }
          }
          String moveInParams = buildMoveInParams(trans, sUnitID)
          def moveInCostResult = myProxy.getMoveIncostSpecial(loc.username, loc.password, loc.sitename, specialXml, moveInParams)
          println "MoveInCostSpecial specialId = ${specialId} returns ${moveInCostResult}"
          def moveInXml = new XmlSlurper().parseText(moveInCostResult)
          totalMoveInCost = moveInXml.TotalAmount.text() as BigDecimal

          String paymentST = buildPaymentST(trans)
          String tenantInfo = buildTenantParams(trans)

          println "params: moveInResult - ${moveInCostResult}\npaymentInfo - ${paymentST}\ntenantInfo - ${tenantInfo}"

          def moveInResults = myProxy.addAccountMoveInSpecial(loc.username, loc.password, loc.sitename, moveInCostResult, paymentST, tenantInfo, moveInParams)

          println "MoveInResults = ${moveInResults}"
          def moveInResultsXml = new XmlSlurper().parseText(moveInResults)
          retVal = moveInResultsXml.bResult.text().toLowerCase() == 'true'
          if (retVal) {
            trans.tenantId = moveInResultsXml.iCustomerID.text()
            trans.accessCode = moveInResultsXml.sAccessCode.text()
            trans.idNumber = moveInResultsXml.sOrderID.text()
            trans.save(flush:true)
          }
          errorMessage = moveInResultsXml.sReturnMessage.text()
        } else {
          GregorianCalendar gcal = new GregorianCalendar();
          gcal.setTime(trans.moveInDate)
          XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
          def moveInCostResult = myProxy.moveInCost(loc.username, loc.password, loc.sitename, unitTypeId, xgcal)
          println "MoveInCost returns ${moveInCostResult}"

          for(charge in moveInCostResult.chargeST) {
            println "Charge: ${charge.dump()}"
            totalMoveInCost += charge.dItemAmount
          }

          def pst = new PaymentST()
          pst.csCCFName = trans.billingAddress.firstName
          pst.csCCLName = trans.billingAddress.lastName
          pst.csCCNumber = trans.ccNum
          pst.csCCStreetAddress = trans.billingAddress.address1
          pst.csCCType = trans.cardType.display
          pst.csCCZip = trans.billingAddress.zipcode
          pst.csCity = trans.billingAddress.city
          pst.csCountry = trans.billingAddress.country.display
          pst.csCVV = trans.cvv2
          pst.csExpirationDate = trans.ccExpDate.format("MM-yyyyy")
          pst.csPaymentMethod = "CREDITCARD"
          pst.dPaymentAmount = trans.moveInCost

          def ust = new UserAccountST()
          ust.iCustomerID = 0
          ust.csLastname = trans.contactPrimary.lastName
          ust.csFirstName = trans.contactPrimary.firstName
          ust.csAddress = trans.contactPrimary.address1
          ust.csAddress2 = trans.contactPrimary.address2
          ust.csCity = trans.contactPrimary.city
          ust.csState = trans.contactPrimary.state.display
          ust.csZip = trans.contactPrimary.zipcode
          switch(trans.contactPrimary.phoneType) {
            case PhoneType.HOME:
              ust.csHomePhone = trans.contactPrimary.phone
              break
            case PhoneType.OFFICE:
              ust.csWorkPhone = trans.contactPrimary.phone
              break
            case PhoneType.MOBILE:
              ust.csCellphone = trans.contactPrimary.phone
              break
          }
          ust.csBillingFName = trans.billingAddress.firstName
          ust.csBillingLName = trans.billingAddress.lastName
          ust.csBillingAddress = trans.billingAddress.address1
          ust.csBillingCity = trans.billingAddress.city
          ust.csBillingState = trans.billingAddress.state.display
          ust.csBillingZip = trans.billingAddress.zipcode
          ust.csEmail = trans.contactPrimary.email

          def moveInResult = myProxy.addAccountMoveIn(loc.username, loc.password. loc.sitename, pst, ust, sUnitID, 0l)
        }

        // compare calculated cost vs. feed cost - send discrepancies
        if (!retVal || totalMoveInCost != trans.moveInCost) {
          try {

            def body = "Rental Transaction ID:${trans.id}\n\nQuikStor calculated total=${totalMoveInCost}\nStoritz calculated total=${trans.moveInCost}\n\nError Message: ${errorMessage}"
            emailService.sendTextEmail(
                    to: "notifications@storitz.com",
                    from: "no-reply@storitz.com",
                    subject: "QUIKSTOR - failed move-in",
                    body: body)

            } catch (Exception e) {
                log.error("${e}", e)
            }

        }
        return retVal
      }

    }

    private String buildMoveInParams(RentalTransaction trans, String unitID) {
      def unit = StorageUnit.get(trans.unitId)

      def writer = new StringWriter()
      def xml = new MarkupBuilder(writer)
      // build sMoveInParams
      xml.MoveInCostParams('xmlns:xsi':"http://www.w3.org/2001/XMLSchema-instance", 'xmlns:xsd':"http://www.w3.org/2001/XMLSchema") {
        tMoveingDate(trans.moveInDate.format('yyyy-MM-dd'))
        sUnitType(unit.unitTypeInfo)
        SetupFee(-1)
        SecDep(-1)
        MCH_LIST()
        INACC_LIST()
        INVENTORY_LIST()
        sUnitID(unitID)
      }
      println "Generated MoveInParams ${writer.toString()}"
      return writer.toString()
    }

    private String buildPaymentST(RentalTransaction trans) {
      def writer = new StringWriter()
      def xml = new MarkupBuilder(writer)
      // build sPaymentST
      xml.PaymentInfo('xmlns:xsi':"http://www.w3.org/2001/XMLSchema-instance", 'xmlns:xsd':"http://www.w3.org/2001/XMLSchema") {
        dPaymentAmount(trans.moveInCost)
        sCCType(trans.cardType.display)
        sCCNumber(trans.ccNum)
        sExpirationDate(trans.ccExpDate.format("MM-yyyy"))
        sCCstreetAddress(trans.billingAddress.address1)
        sCCZip(trans.billingAddress.zipcode)
        iCheckNo(0)
        sCity(trans.billingAddress.city)
        sState(trans.billingAddress.state.display)
        sCCFName(trans.billingAddress.firstName)
        sCCLName(trans.billingAddress.lastName)
        sProcessor("Storitz")
        sPaymentMethod("CREDITCARD")
        bSaveToken(true)
      }
      return writer.toString()
    }

    private String buildTenantParams(RentalTransaction trans) {
      def writer = new StringWriter()
      def xml = new MarkupBuilder(writer)
      // build sTenantParams
      xml.TenantInfo4MoveIn('xmlns:xsi':"http://www.w3.org/2001/XMLSchema-instance", 'xmlns:xsd':"http://www.w3.org/2001/XMLSchema") {
        dIndividualLateFee(0)
        dtExpectedMoveOut("0001-01-01T00:00:00")
        dtCreditCardExpDate(trans.ccExpDate.format("yyyy-MM-dd"))
        dsMoveInDate(trans.moveInDate.format("yyyy-MM-dd"))
        iCustomerID(0)
        sLastname(trans.contactPrimary.lastName)
        sFirstName(trans.contactPrimary.firstName)
        sAddress(trans.contactPrimary.address1)
        sCity(trans.contactPrimary.city)
        sState(trans.contactPrimary.state.display)
        sZip(trans.contactPrimary.zipcode)
        sHomePhone(trans.contactPrimary.phone)
      }
      return writer.toString()
    }

}
