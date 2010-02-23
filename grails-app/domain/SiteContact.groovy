class SiteContact {

    static belongsTo = [ site: StorageSite ]

    static constraints = {
    }

    String email
    String name
}
