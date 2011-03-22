package com.storitz

class SiteUser {

  StorageSite site
  User user

  static constraints = {
  }

  static SiteUser link(site, user) {
    def s = SiteUser.findBySiteAndUser(site, user)
    if (!s) {
      s = new SiteUser()
      s.user = user
      s.site = site
      site?.addToUsers(s)
      user?.addToSites(s)
      s.save(flush: true)
    }
    return s
  }

  static void unlink(site, user) {
    def s = SiteUser.findBySiteAndUser(site, user)
    if (s) {
      site?.removeFromUsers(s)
      user?.removeFromSites(s)
      s.delete(flush: true)
    }
  }

  static void removeAll(User user) {
    executeUpdate 'DELETE FROM SiteUser WHERE user=:user', [user: user]
  }

  static void removeAll(StorageSite site) {
    executeUpdate 'DELETE FROM SiteUser WHERE site=:site', [site: site]
  }

}
