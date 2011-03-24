package storitz

import storitz.constants.PromoType
import storitz.constants.SearchType
import storitz.constants.SpecialOfferRestrictionType
import storitz.constants.UnitType
import com.storitz.*

class ExrsService extends CShiftService {

  def emailService

  static String baseUrl = "http://www.extraspace.com"

  // unit availability

  def updateUnits(StorageSite site, SiteStats stats, PrintWriter writer) {
    println "Opening page: ${baseUrl + site.url}"
    def siteHtml = new URL(baseUrl + site.url).text
    // build list of valid ids
    def idList = []
    def idMatcher = siteHtml =~ /ctl00_mContent_UnitList_ctl(\d+)_Dimensions/
    if (idMatcher.getCount()) {
      idMatcher.each {
        idList.add(it[1])
      }
    }

    def needSave = false
    for (unitId in idList) {
      def dimensionsMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_Dimensions" value="(.+?)"/
      def dimensions
      if (dimensionsMatch.getCount()) {
        dimensions = dimensionsMatch[0][1]
      }

      def attributesMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_UnitAttributesCode" value="(\d+)"/
      def attributes
      if (attributesMatch.getCount()) {
        attributes = attributesMatch[0][1]
      }

      def descriptionMatch = siteHtml =~ /id="ctl00_[m|Main]Content_UnitList_ctl${unitId}_FeatureString" value="(.+?)"/
      def typeName
      if (descriptionMatch.getCount()) {
        typeName = descriptionMatch[0][1]
      }

      def priceMatch = siteHtml =~ /id="ctl00_[m|Main]Content_UnitList_ctl${unitId}_StreetRate" value="(\d+)"/
      BigDecimal price
      if (priceMatch.getCount()) {
        price = new BigDecimal(priceMatch[0][1])
      }

      def pushRateMatch = siteHtml =~ /id="ctl00_[m|Main]Content_UnitList_ctl${unitId}_WebsiteRate" value="(\d+)"/
      BigDecimal pushRate
      if (pushRateMatch.getCount()) {
        pushRate = new BigDecimal(pushRateMatch[0][1])
      }

      def reservationMatch = siteHtml =~ /id="ctl00_[m|Main]Content_UnitList_ctl${unitId}_ReservationDeposit" value="(.+?)"/
      def reservation
      if (reservationMatch.getCount()) {
        reservation = Integer.parseInt(reservationMatch[0][1])
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
          StorageUnit siteUnit = site.units.find { it.unitName == attributes && it.displaySize == displaySize}

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

          } else {
            siteUnit.unitCount = reservation > 0 ? 100 : 0
            siteUnit.totalUnits = 100
            siteUnit.pushRate = pushRate
            siteUnit.price = price
            siteUnit.taxRate = 0
            siteUnit.unitSizeInfo = dimensions
            siteUnit.unitTypeInfo = attributes
            stats.unitCount += 1

            println "Updating unit dimensions ${dimensions} price: ${price} push rate: ${pushRate}"
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
    }
    if (needSave) {
      site.save(flush: true)
    }
  }

  // promos

  def loadPromos(CenterShift feed, StorageSite site, PrintWriter writer) {
    println "Opening page: ${baseUrl + site.url}"
    def siteHtml = new URL(baseUrl + site.url).text
    // build list of valid ids
    def idList = []
    def idMatcher = siteHtml =~ /ctl00_mContent_UnitList_ctl(\d+)_Dimensions/
    if (idMatcher.getCount()) {
      idMatcher.each {
        idList.add(it[1])
      }
    }

    site.specialOffers.clear()

    def needSave = false
    for (unitId in idList) {
      def reservationMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_ReservationDeposit" value="(.+?)"/
      def reservation
      if (reservationMatch.getCount()) {
        reservation = Integer.parseInt(reservationMatch[0][1])
      }

      if (reservation > 0) {

        def dimensionsMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_Dimensions" value="(.+?)"/
        def dimensions
        if (dimensionsMatch.getCount()) {
          dimensions = dimensionsMatch[0][1]
        }

        def attributesMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_UnitAttributesCode" value="(\d+)"/
        def attributes
        if (attributesMatch.getCount()) {
          attributes = attributesMatch[0][1]
        }

        def promoNameMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_PromoName" value="(.+?)"/
        def promoName
        if (promoNameMatch.getCount()) {
          promoName = (promoNameMatch[0][1]).split(" - ")[-1]
        }

        def discountTypeMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_DiscountType" value="(.+?)"/
        def discountType
        if (discountTypeMatch.getCount()) {
          discountType = discountTypeMatch[0][1]
        }

        def discountPeriodMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_DiscountPeriods" value="(\d+)"/
        Integer discountPeriod
        if (discountPeriodMatch.getCount()) {
          discountPeriod = Integer.parseInt(discountPeriodMatch[0][1])
        }

        def discountMinMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_DiscountMin" value="(\d+)"/
        Integer discountMin
        if (discountMinMatch.getCount()) {
          discountMin = Integer.parseInt(discountMinMatch[0][1])
        }

        def discountMaxMatch = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_DiscountMax" value="(\d+)"/
        Integer discountMax
        if (discountMaxMatch.getCount()) {
          discountMax = Integer.parseInt(discountMaxMatch[0][1])
        }

        println "Found discount type=${discountType} name=${promoName} period=${discountPeriod} min=${discountMin} max=${discountMax}"

        SpecialOffer specialOffer = new SpecialOffer()
        specialOffer.concessionId = -999
        specialOffer.active = true
        specialOffer.featured = true
        specialOffer.waiveAdmin = false;
        specialOffer.description = promoName
        specialOffer.promoName = promoName
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
      }
    }
  }

  // check rented

  def checkRented(RentalTransaction rentalTransaction) {

    StorageSite site = rentalTransaction.site
    StorageUnit unit = StorageUnit.get(rentalTransaction.unitId)

    if (!unit) {
      return false
    }

    def siteHtml = new URL(baseUrl + site.url).text
    // build list of valid ids
    def idList = []
    def idMatcher = siteHtml =~ /id="ctl00_mContent_UnitList_ctl(\d+)_Dimensions" value="${unit.unitSizeInfo}"/
    if (idMatcher.getCount()) {
      for (idMatch in idMatcher) {
        def unitId = idMatch[1]
        def attributeMatcher = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_UnitAttributesCode" value="${unit.unitTypeInfo}"/
        if (attributeMatcher.getCount()) {
          def reservationMatcher = siteHtml =~ /id="ctl00_mContent_UnitList_ctl${unitId}_ReservationDeposit" value="(.+?)"/
          if (reservationMatcher.getCount()) {
            Integer reservationDeposit = Integer.parseInt(reservationMatcher[0][1])
            return (reservationDeposit >= 0)
          }
        }
      }
    }
    return false
  }

  // reserve/move-in

  def moveIn(RentalTransaction trans) {

    trans.idNumber = trans.bookingDate.format('yyyyddMM') + sprintf('%08d', trans.id)

    StorageUnit unit = StorageUnit.get(trans.unitId as Long)

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

    def body = buf.toString()
    String title = "Storitz - New EXRS reservation - id (${trans.idNumber})"

    emailService.sendTextEmail(
            to: 'exrs@storitz.com',
            from: 'no-reply@storitz.com',
            subject: title,
            body: body
    )

    trans.save(flush: true)

    return true
  }
}
