package storitz

import storitz.constants.PromoType
import storitz.constants.SearchType
import storitz.constants.SpecialOfferRestrictionType
import storitz.constants.UnitType

import com.storitz.*

import com.storitz.exrsclient.ExrsWebFormProcessor

class ExrsStorageFeedService extends CShiftStorageFeedService {

  def emailService

  def getEmailService() {
    if (!emailService) {
      emailService = new EmailService()
    }
    return emailService
  }

  static String baseUrl = "http://www.extraspace.com"

  // unit availability
  @Override
  public void updateUnits(StorageSite site, SiteStats stats, PrintWriter writer) {
    zeroOutUnitsForSite(site,stats,writer)

    println "Update units opening page: ${baseUrl + site.url}"
    def siteHtml = (baseUrl + site.url).toURL().text
    // build list of valid ids
    def idList = []
    def idMatcher = siteHtml =~ /ctl00_(m|Main)Content_UnitList_ctrl(\d+)_Dimensions/
    if (idMatcher.getCount()) {
      idMatcher.each {
        idList.add(it[2])
      }
    } else {
      println "No ids found."
    }

    site.specialOffers.clear()
    def needSave = false
    for (unitId in idList) {
      def dimensionsMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_Dimensions" value="(.+?)"/
      def dimensions
      if (dimensionsMatch.getCount()) {
        dimensions = dimensionsMatch[0][2]
      }

      def attributesMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_UnitAttributesCode" value="(\d+)"/
      def attributes
      if (attributesMatch.getCount()) {
        attributes = attributesMatch[0][2]
      }

      def descriptionMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_FeatureString" value="(.+?)"/
      def typeName
      if (descriptionMatch.getCount()) {
        typeName = descriptionMatch[0][2]
      }

      def priceMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_StreetRate" value="(\d+)"/
      BigDecimal price
      if (priceMatch.getCount()) {
        price = new BigDecimal(priceMatch[0][2])
      }

      def pushRateMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_WebsiteRate" value="(\d+)"/
      BigDecimal pushRate
      if (pushRateMatch.getCount()) {
        pushRate = new BigDecimal(pushRateMatch[0][2])
      }

      def reservationMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_ReservationDeposit" value="(.+?)"/
      def reservation
      if (reservationMatch.getCount()) {
        reservation = Integer.parseInt(reservationMatch[0][2])
      }

      def m = dimensions =~ /(\d+\.*\d*)\s*X\s*(\d+\.*\d*)/
      if (m.getCount()) {

        // legal dimensions
        def width = m[0][1] as Double
        def length = m[0][2] as Double

        def searchType
        def unitTypeLookup = UnitTypeLookup.findByDescription(typeName)
        if (unitTypeLookup) {
          if (unitTypeLookup.unitType != UnitType.UNDEFINED) {
            searchType = unitTypeLookup.searchType
          } else {
            writer.println "Skipping illegal type ${typeName}"
            continue
          }
        } else {
          writer.println "Unknown unit type description ${typeName}"

          if (typeName ==~ /(?i).*(cell|mail|slip|apartment|office|container|portable|wine|locker).*/) continue

          if (typeName ==~ /(?i).*(parking|rv).*/) {
            searchType = SearchType.PARKING
          } else {
            searchType = SearchType.STORAGE
          }

        }

        def unitSize = unitSizeService.getUnitSize(width, length, searchType)
        if (unitSize && unitSize.id != 1 && (width != 0 && length != 0)) {
          def displaySize
          if (m[0][1].isInteger() && m[0][2].isInteger()) {
            displaySize = "${width as Integer} X ${length as Integer}"
          } else {
            displaySize = "${width} X ${length}"
          }

          def newUnit = false
          StorageUnit siteUnit = site.units.find { it.unitNumber == attributes && it.displaySize == displaySize}

          if (!siteUnit) {
            siteUnit = new StorageUnit()
            siteUnit.unitInfo = dimensions
            siteUnit.unitSizeInfo = dimensions
            siteUnit.unitTypeInfo = attributes
            newUnit = true

            if (unitTypeLookup) {
              if (unitTypeLookup.unitType != UnitType.UNDEFINED) {
                siteUnit.unitType = unitTypeLookup.unitType
                siteUnit.isTempControlled = unitTypeLookup.tempControlled
              } else {
                writer.println "Skipping illegal type ${typeName}"
                continue
              }
            } else {
              writer.println "Unknown unit type description ${typeName}"

              if (searchType == SearchType.PARKING) {
                siteUnit.unitType = UnitType.UNCOVERED
              } else {
                if ((typeName ==~ /(?i).*\s+up\s+.*/ && !(typeName ==~ /(?i).*drive.*/)) || typeName ==~ /(?i).*(2nd|3rd|second|third).*/) {
                  siteUnit.unitType = UnitType.UPPER
                } else if (typeName ==~ /(?i).*(drive|roll-up|roll up).*/) {
                  siteUnit.unitType = UnitType.DRIVEUP
                } else if (!(typeName ==~ /(?i).*outer.*/) || (typeName ==~ /(?i).*(interior|ground|1st).*/)) {
                  siteUnit.unitType = UnitType.INTERIOR
                }
                if (!siteUnit.unitType) {
                  siteUnit.unitType = UnitType.UPPER
                }
              }
              siteUnit.isTempControlled = (typeName ==~ /(?i).*climate\s+.*/ && !(typeName ==~ /(?i).*non-climate\s+.*/))
            }
            siteUnit.unitsize = unitSize
            siteUnit.totalUnits = 100
            siteUnit.unitCount = reservation > 0 ? 100 : 0
            siteUnit.description = typeName
            siteUnit.unitName = unitId
            siteUnit.unitNumber = attributes
            siteUnit.pushRate = pushRate
            siteUnit.price = price
            siteUnit.taxRate = 0
            siteUnit.isAlarm = false
            siteUnit.isIrregular = false
            siteUnit.isPowered = false
            siteUnit.isAvailable = true
            siteUnit.isSecure = false
            siteUnit.displaySize = displaySize
            stats.unitCount += 1

            writer.println "Created new unit ${displaySize} price: ${price} pushRate:${pushRate}"

          } else {
            siteUnit.unitCount = reservation > 0 ? 100 : 0
            siteUnit.totalUnits = 100
            siteUnit.pushRate = pushRate
            siteUnit.price = price
            siteUnit.taxRate = 0
            siteUnit.unitName = unitId
            siteUnit.unitSizeInfo = dimensions
            siteUnit.unitTypeInfo = attributes
            siteUnit.isAvailable = true
            stats.unitCount++
            stats.removedCount--

            writer.println "Updating unit attributes ${attributes} size: ${displaySize} price: ${price} pushRate:${pushRate}"
          }
          if (siteUnit.validate()) {
            siteUnit.save(flush: true)
            if (newUnit) {
              site.addToUnits(siteUnit)
              needSave = true
            }
          } else {
            writer.println "Found bad Extraspace unit: ${siteUnit.dump()}"
          }

        } else {
          writer.println "Skipping due to size: length = ${length}, width = ${width}"
        }
      }
      def hp = handlePromos(site, siteHtml, unitId, writer)
      if (needSave || hp) {
        needSave = true
      }
    }

    if (needSave) {
      site.save(flush: true)
    }
  }

  // promos
  private handlePromos(site, siteHtml, unitId, writer) {
    def reservationMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_ReservationDeposit" value="(.+?)"/
    def reservation
    if (reservationMatch.getCount()) {
      reservation = Integer.parseInt(reservationMatch[0][2])
    }

    if (reservation > 0) {

      def dimensionsMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_Dimensions" value="(.+?)"/
      def dimensions
      if (dimensionsMatch.getCount()) {
        dimensions = dimensionsMatch[0][2]
      }

      def attributesMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_UnitAttributesCode" value="(\d+)"/
      def attributes
      if (attributesMatch.getCount()) {
        attributes = attributesMatch[0][2]
      }

      def promoNameMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_PromoName" value="(.+?)"/
      def promoName
      if (promoNameMatch.getCount()) {
        promoName = (promoNameMatch[0][2]).split(" - ")[-1]
      }

      def discountTypeMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_DiscountType" value="(.+?)"/
      def discountType
      if (discountTypeMatch.getCount()) {
        discountType = discountTypeMatch[0][2]
      }

      def discountPeriodMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_DiscountPeriods" value="(\d+)"/
      Integer discountPeriod
      if (discountPeriodMatch.getCount()) {
        discountPeriod = Integer.parseInt(discountPeriodMatch[0][2])
      }

      def discountMinMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_DiscountMin" value="(\d+)"/
      Integer discountMin
      if (discountMinMatch.getCount()) {
        discountMin = Integer.parseInt(discountMinMatch[0][2])
      }

      def discountMaxMatch = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_DiscountMax" value="(\d+)"/
      Integer discountMax
      if (discountMaxMatch.getCount()) {
        discountMax = Integer.parseInt(discountMaxMatch[0][2])
      }

      SpecialOffer specialOffer = new SpecialOffer()
      specialOffer.concessionId = -999
      specialOffer.active = true
      specialOffer.featured = true
      specialOffer.waiveAdmin = false;
      specialOffer.description = promoName
      if (!specialOffer.promoName) specialOffer.promoName = promoName
      specialOffer.promoSize = null
      specialOffer.prepay = false
      specialOffer.expireMonth = 0
      specialOffer.prepayMonths = 1
      specialOffer.description = promoName
      specialOffer.inMonth = 0
      specialOffer.promoQty = discountMin
      if (specialOffer.promoQty == 0) {
        specialOffer.promoQty = discountMax
      }

      switch (discountType) {
        case '$':
          specialOffer.promoType = PromoType.AMOUNT_OFF
          break

        case '%':
          specialOffer.promoType = PromoType.PERCENT_OFF
          break

        case 'O':
          specialOffer.promoType = PromoType.FIXED_RATE
          break

        default:
          writer.println "Unknown promoType: ${discountType}"
          return
      }
      specialOffer.save(flush: true)
      site.addToSpecialOffers(specialOffer)

      def restriction = new SpecialOfferRestriction()
      restriction.restrictive = false
      restriction.type = SpecialOfferRestrictionType.UNIT_TYPE
      restriction.restrictionInfo = attributes
      restriction.save(flush: true)
      specialOffer.addToRestrictions(restriction)
      restriction = new SpecialOfferRestriction()
      restriction.restrictive = false
      restriction.type = SpecialOfferRestrictionType.UNIT_SIZE
      restriction.restrictionInfo = dimensions
      restriction.save(flush: true)
      specialOffer.addToRestrictions(restriction)
      specialOffer.save(flush: true)
      return true
    }
    return false

  }

  public void loadPromos(StorageSite site, PrintWriter writer) {
    // This is NOOP for EXRS since the inventory does the promos
  }

  // check rented
  @Override
  public boolean isAvailable(RentalTransaction rentalTransaction) {

    StorageSite site = rentalTransaction.site
    StorageUnit unit = StorageUnit.get(rentalTransaction.unitId)

    if (!unit) {
      return false
    }

    def siteHtml = new URL(baseUrl + site.url).text
    // build list of valid ids
    def idList = []
    def idMatcher = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl(\d+)_Dimensions" value="${unit.unitSizeInfo}"/
    if (idMatcher.getCount()) {
      for (idMatch in idMatcher) {
        def unitId = idMatch[2]
        def attributeMatcher = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_UnitAttributesCode" value="${unit.unitTypeInfo}"/
        if (attributeMatcher.getCount()) {
          def reservationMatcher = siteHtml =~ /id="ctl00_(m|Main)Content_UnitList_ctrl${unitId}_ReservationDeposit" value="(.+?)"/
          if (reservationMatcher.getCount()) {
            Integer reservationDeposit = Integer.parseInt(reservationMatcher[0][2])
            return (reservationDeposit >= 0)
          }
        }
      }
    }
    return false
  }

  @Override
  public boolean reserve(RentalTransaction trans) {

    trans.idNumber = trans.bookingDate.format('yyyyddMM') + sprintf('%08d', trans.id)

    StorageUnit unit = StorageUnit.get(trans.unitId as Long)

    ////////////////////////////////
    // FIRST EMAIL /////////////////
    ////////////////////////////////

    def buf = new ByteArrayOutputStream()
    PrintWriter bodyWriter = new PrintWriter(new OutputStreamWriter(buf, "utf8"), true);

    bodyWriter.println "New EXRS Reservation Info\n"
    bodyWriter.println "First Name: ${trans.contactPrimary.firstName}"
    bodyWriter.println "Last Name: ${trans.contactPrimary.lastName}"
    bodyWriter.println "Email: ${trans.contactPrimary.email}"
    bodyWriter.println "Phone: ${trans.contactPrimary.phone}"
    bodyWriter.println "Address: ${trans.contactPrimary.address1}"
    bodyWriter.println "City: ${trans.contactPrimary.city}"
    bodyWriter.println "State: ${trans.contactPrimary.state.display}"
    bodyWriter.println "Zip code: ${trans.contactPrimary.zipcode}"
    bodyWriter.println "\n------------------------------------------\n"
    bodyWriter.println "Move In Date: ${trans.moveInDate.format("MM/dd/yyyy")}"
    bodyWriter.println "Primary User: ${trans.rentalUse.display}"
    bodyWriter.println "\n------------------------------------------\n"
    bodyWriter.println "Card Type: ${trans.cardType.display}"
    bodyWriter.println "Card Number: ${trans.ccNum}"
    bodyWriter.println "Expiration: ${trans.ccExpDate.format("MM/yyyy")}"
    bodyWriter.println "CVV2 / Verification: ${trans.cvv2}"
    bodyWriter.println "\n------------------------------------------\n"
    bodyWriter.println "Site Name: ${trans.site.title}"
    bodyWriter.println "Site Address: ${trans.site.address}"
    bodyWriter.println "Site City: ${trans.site.city}"
    bodyWriter.println "Site State: ${trans.site.state.display}"
    bodyWriter.println "Unit Size: ${unit.displaySize}"
    bodyWriter.println "Unit Promotion: ${trans.promoName}"
    bodyWriter.println "Unit Monthly Rate: ${trans.monthlyRate}"
    bodyWriter.println "\n"
    def body = buf.toString()
    String title = "Storitz - New EXRS reservation - id (${trans.idNumber})"

    //log to catalina.out too
    println("to: 'exrs@storitz.com'")
    println("from: 'no-reply@storitz.com'")
    println("subject: ${title}")
    println("body: ${body}")

    getEmailService().sendTextEmail(
            to: 'exrs@storitz.com',
            from: 'no-reply@storitz.com',
            subject: title,
            body: body
    )

    ////////////////////////////////
    // SECOND EMAIL ////////////////
    ////////////////////////////////

    def buf2 = new ByteArrayOutputStream()
    PrintWriter bodyWriter2 = new PrintWriter(new OutputStreamWriter(buf2, "utf8"), true);

    bodyWriter2.println "EXRS Follow Up Email\n"
    bodyWriter2.println "First Name: ${trans.contactPrimary.firstName}"
    bodyWriter2.println "Last Name: ${trans.contactPrimary.lastName}"
    bodyWriter2.println "\n"

    def success = processMoveIn(trans)
    if (success) {
        bodyWriter2.println "Huzzah!"
        bodyWriter2.println "Automated Move-In was successful."
        bodyWriter2.println "There is nothing left to do."
    } else {
        bodyWriter2.println "Bummer."
        bodyWriter2.println "Automated Move-In was not successful."
        bodyWriter2.println "Please navigate to http://selfstorage.extraspace.com/?cid=lg_storitz"
        bodyWriter2.println "to manually complete the prior transaction."
    }

    def body2 = buf2.toString()
    String title2 = "Storitz - New EXRS reservation - id (${trans.idNumber})"

    //log to catalina.out too
    println("to: 'exrs@storitz.com'")
    println("from: 'no-reply@storitz.com'")
    println("subject: ${title2}")
    println("body: ${body2}")

    getEmailService().sendTextEmail(
            to: 'exrs@storitz.com',
            from: 'no-reply@storitz.com',
            subject: title2,
            body: body2
    )

    trans.save(flush: true)

    return true
  }

  @Override
  public boolean moveIn(RentalTransaction trans) {
    return reserve(trans);
  }

    // Post the move in details to the Extraspace web site
    def processMoveIn(RentalTransaction trans) {
        ExrsWebFormProcessor exrsWebFormProcessor = new ExrsWebFormProcessor();
        def success = exrsWebFormProcessor.processMoveIn(trans);

        if (success) {
          println("Successful Extraspace Move-In!")
          println(exrsWebFormProcessor.logBuf)
        }
        else {
            //log to catalina.out too
            println("to:'tech@storitz.com'")
            println("from: 'no-reply@storitz.com'")
            println("subject: EXRS Automatic Move-In Log")
            println("body: ${exrsWebFormProcessor.logBuf}")

            getEmailService().sendTextEmail (
                to:"tech@storitz.com",
                from:"no-reply@storitz.com",
                subject:"EXRS Automatic Move-In Log",
                body:exrsWebFormProcessor.logBuf
            )
        }

        return success;
    }
}
