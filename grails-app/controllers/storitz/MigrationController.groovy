package storitz

import grails.converters.JSON
import com.storitz.StorageSite
import com.storitz.Feed
import storitz.constants.FeedType
import com.storitz.SiteLink
import com.storitz.CenterShift

class MigrationController {

  def index = { }

  def owner = {
    def myFeed = Feed.get(params.id as Long)

    if (myFeed) {
      def sites = StorageSite.findAllByFeed(myFeed)
      if (myFeed.feedType == FeedType.SITELINK) {
        SiteLink f = myFeed as SiteLink
        render(status: 200, contentType: "application/json", text: "{ \"sites\": ${sites as JSON} }")
      } else if (myFeed.feedType == FeedType.CENTERSHIFT) {
        CenterShift f = myFeed as CenterShift
        render(status: 200, contentType: "application/json", text: "{ \"sites\": ${sites as JSON} }")
      }
    }
  }

  def site = {
    def site = StorageSite.get(params.id as Long)
    render(status: 200, contentType: "application/json", text: "{ \"site\": ${site as JSON} }")
  }

  def consume = {
    def urlString = 'http://preview.storitz.com/migration/owner/' + params.id
    if (params.url) {
      urlString = params.url
    }

    println "URL = ${urlString}"

    def url = new URL(urlString)
    def conn = url.openConnection()
    if (conn.responseCode == 200) {
      def sites = JSON.parse(conn.content.text)
      for (s in sites) {
        def  site = new StorageSite(s)
        println "Retrieved site: ${site.title} id = ${site.id}"
      }
    } else {
      println "Bad connection got response ${conn.responseCode}"
    }
    render(status: 200, text: "Done!")
  }

  private getSite(StorageSite it) {
    def returnArray = [:]
    returnArray['units'] = it.units
    returnArray['specialOffers'] = it.specialOffers
    returnArray['images'] = it.images
    // skip site users
    returnArray['insurances'] = it.insurances
    // skip visits
    returnArray['securityItems'] = it.securityItems
    returnArray['convenienceItems'] = it.convenienceItems
    returnArray['amenityItems'] = it.amenityItems
    returnArray['title'] = it.title
    returnArray['description'] = it.description
    returnArray['logo'] = it.logo
    returnArray['lat'] = it.lat
    returnArray['lng'] = it.specialOffers
    returnArray['address'] = it.address
    returnArray['address2'] = it.address2
    returnArray['city'] = it.city
    returnArray['state'] = it.state
    returnArray['zipcode'] = it.url
    returnArray['url'] = it.url
    returnArray['phone'] = it.phone
    returnArray['source'] = it.source
    returnArray['sourceId'] = it.sourceId
    returnArray['sourceLoc'] = it.sourceLoc
    returnArray['requiresInsurance'] = it.requiresInsurance
    returnArray['noInsuranceWaiver'] = it.noInsuranceWaiver
    returnArray['boxesAvailable'] = it.boxesAvailable
    returnArray['freeTruck'] = it.freeTruck
    returnArray['isGate'] = it.isGate
    returnArray['isKeypad'] = it.isKeypad
    returnArray['isCamera'] = it.isCamera
    returnArray['isUnitAlarmed'] = it.isManagerOnsite
    returnArray['hasElevator'] = it.hasElevator
    returnArray['adminFee'] = it.adminFee
    returnArray['lockFee'] = it.lockFee
    returnArray['deposit'] = it.deposit
    returnArray['prorateStart'] = it.prorateStart
    returnArray['prorateCutoff'] = it.prorateCutoff
    returnArray['prorateSecondMonth'] = it.prorateSecondMonth
    returnArray['openWeekday'] = it.openWeekday
    returnArray['openSaturday'] = it.openSaturday
    returnArray['openSunday'] = it.openSunday
    returnArray['startWeekday'] = it.startWeekday
    returnArray['endWeekday'] = it.endWeekday
    returnArray['startSaturday'] = it.startSaturday
    returnArray['endSaturday'] = it.endSaturday
    returnArray['startSunday'] = it.startSunday
    returnArray['endSunday'] = it.endSunday
    returnArray['startGate'] = it.startGate
    returnArray['endGate'] = it.endGate
    returnArray['startSundayGate'] = it.startSundayGate
    returnArray['endSundayGate'] = it.endSundayGate
    returnArray['taxRateRental'] = it.taxRateRental
    returnArray['taxRateInsurance'] = it.taxRateInsurance
    returnArray['useProrating'] = it.useProrating
    // skip feed
    returnArray['lastUpdate'] = it.lastUpdate
    returnArray['disabled'] = it.disabled
    returnArray['bankAccount'] = it.bankAccount
    returnArray['rentalAgreement'] = it.rentalAgreement
    returnArray['lastChange'] = it.lastChange

    return returnArray

  }
}
