package storitz

import com.storitz.Feed
import com.storitz.StorageSite
import com.storitz.RentalTransaction

class StorageMartStorageFeedService extends BaseProviderStorageFeedService {

  static transactional = true
  String userName
  String passWord

  public StorageMartStorageFeedService (String userName, String passWord) {
    this.userName = userName
    this.passWord = passWord
  }

  @Override
  void refreshSites(Feed feed, String source, SiteStats stats, PrintWriter writer) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  void updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  void updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  void loadPromos(StorageSite storageSiteInstance, PrintWriter writer) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  void addSitePhone(StorageSite storageSiteInstance, PrintWriter writer) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  boolean isAvailable(RentalTransaction trans) {
    return false  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  loadInsurance(Feed feed, StorageSite site) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  boolean moveIn(RentalTransaction trans) {
    return false  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  boolean reserve(RentalTransaction trans) {
    return false  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  void init(StorageSite site) {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
