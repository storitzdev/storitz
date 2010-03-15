import grails.converters.JSON

class StorageSiteController {

  def detail = {

    def site = StorageSite.get(params.id)

    def sizeList = site.units.collect{ it.unitsize }.unique()
    sizeList.add(StorageSize.get(1))
    sizeList.sort{ it.width * it.length }

    [ sizeList: sizeList, site : site, title: site.title ]
  }

  def detailUnits = {

    def site = StorageSite.get(params.id)
    
    if (!params.searchSize) {
      render(status: 200, contentType: "application/json", text: "{ \"units\": null }")
      return
    }

    def zeroPrice = new BigDecimal(0)
    def unitsizeId = Long.parseLong(params.searchSize)
    def intResult = site.units.findAll { it.price > zeroPrice && it.unitsize.id == unitsizeId && it.isInterior }.min{ it.price } as StorageUnit[]
    def driveupResult = site.units.findAll { it.price > zeroPrice && it.unitsize.id == unitsizeId && it.isDriveup }.min{ it.price } as StorageUnit[]
    def upperResult = site.units.findAll { it.price > zeroPrice && it.unitsize.id == unitsizeId && it.isUpper }.min{ it.price } as StorageUnit[]
    def tempcontrolledResult = site.units.findAll { it.price > zeroPrice && it.unitsize.id == unitsizeId && it.isTempControlled }.min{ it.price } as StorageUnit[]
    render(status: 200, contentType: "application/json", text: "{ \"units\": { \"interior\": ${intResult as JSON}, \"driveup\": ${driveupResult as JSON}, \"upper\": ${upperResult as JSON}, \"tempcontrolled\": ${tempcontrolledResult as JSON} } }")
  }
}
