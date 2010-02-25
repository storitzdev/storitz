class StorageSiteController {

  def detail = {

    def site = StorageSite.get(params.id)

    def sizeList = site.units.collect{ it.unitsize }.unique().sort()

    [ sizeList: sizeList, site : site, title: site.title ]
  }
}
