class StorageSiteController {

  def detail = {
    def site = StorageSite.get(params.id)

    [ sizeList: StorageSize.list(params), site : site, title: site.title ]
  }
}
