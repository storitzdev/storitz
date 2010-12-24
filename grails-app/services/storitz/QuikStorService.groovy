package storitz

import com.storitz.Insurance
import com.storitz.SpecialOffer
import com.storitz.StorageUnit
import com.storitz.StorageSite
import com.storitz.RentalTransaction
import com.storitz.QuikStor

class QuikStorService {

    static transactional = false

    def processLocations(QuikStor quikStor) {

    }
  
    def createSiteUsers(QuikStor quikStor) {

    }

    def createSiteTaxes(QuikStor quikStor) {

    }

    def updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

    }

    def updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {

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
