package storitz

import storitz.constants.CommissionType
import com.storitz.*
import storitz.service.StorageFeedServiceFactory
import com.storitz.service.CostTotals

class CostService {

  boolean transactional = false

  def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended) {
    def moveInCost = StorageFeedServiceFactory.getCostServiceInstance(site).calculateMoveInCost(site, unit, promo, ins, moveInDate, extended)
    return moveInCost
  }

  public CostTotals calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate) {
    CostTotals totals = StorageFeedServiceFactory.getCostServiceInstance(site).calculateTotals(site, unit, promo, ins, moveInDate)
    return totals;
  }

  def calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate, boolean allowExtension) {
    def paidThuDate = StorageFeedServiceFactory.getCostServiceInstance(site).calculatePaidThruDate(site, promo, moveInDate, allowExtension)
    return paidThuDate
  }

  def calculateCommission(BigDecimal monthly, Feed feed) {
    CommissionSchedule schedule = feed.commissionSchedule
    Commission ctype = schedule.entries.find { it.lowerBound < monthly && it.upperBound >= monthly}

    if (!ctype) return monthly * 0.25

    if (ctype.commissionType == CommissionType.PERCENTAGE) {
      return monthly * (ctype.amount / 100)
    }
    return ctype.amount
  }
}
