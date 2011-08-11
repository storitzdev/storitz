package storitz

import com.storitz.Feed
import com.storitz.StorageSite
import com.storitz.RentalTransaction
import org.tempuri.BasicHttpBinding_IAvailabilityDataStub
import org.datacontract.schemas._2004._07.StorageMart_Services.Credentials
import org.datacontract.schemas._2004._07.StorageMart_Services.FacilityOutput

import java.net.URL
import javax.xml.rpc.Service

class StorageMartStorageFeedService extends BaseProviderStorageFeedService {

  static transactional = true

  private URL endpointURL
  private Service service
  private String userName
  private String passWord

  public StorageMartStorageFeedService (String userName, String passWord, String url) {
    this.userName = userName
    this.passWord = passWord
    this.endpointURL = new URL(url)
    this.service = new org.apache.axis.client.Service()
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

  ///// FEED SERVICE METHODS /////
  boolean loadFacilities () {
    Credentials creds = new Credentials(this.userName,this.passWord);
    BasicHttpBinding_IAvailabilityDataStub stub = new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    FacilityOutput [] output = stub.loadFacilities(creds);
    for (FacilityOutput o : output) {
      println o.toString()
    }
  }
}
