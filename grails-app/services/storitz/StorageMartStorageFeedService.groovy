package storitz

import com.storitz.Feed
import com.storitz.StorageSite
import com.storitz.RentalTransaction
import org.tempuri.BasicHttpBinding_IAvailabilityDataStub
import org.datacontract.schemas._2004._07.StorageMart_Services.Credentials
import org.datacontract.schemas._2004._07.StorageMart_Services.FacilityOutput
import org.datacontract.schemas._2004._07.StorageMart_Services.UnitTypeOutput
import org.datacontract.schemas._2004._07.StorageMart_Services.ReservationRequest

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
    Credentials creds = new Credentials(this.passWord,this.userName); // yes, password/username
    BasicHttpBinding_IAvailabilityDataStub stub = new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    FacilityOutput [] output = stub.loadFacilities(creds);
    for (FacilityOutput o : output) {
      println "FACILITY: ${o.toString()}"
      println "   ID: ${o.facility_Id}"
      println "   NAME: ${o.name}"
      println "   DESC: ${o.description}"
      println "   PROMO: ${o.promotion}"
      println "   IMG: ${o.image_Urls}"
      println "   CITY: ${o.city}"
      println "   STATE: ${o.state}"
      println "   ZIP: ${o.zip}"
      println "   PHONE: ${o.phone}"
      println "   OFFICE: ${o.office_Hours}"
      println "   ACCESS: ${o.access_Hours}"
      println "   TRUCK: ${o.has_Truck_Rental}"
      println "   FREE TRUCK: ${o.has_Free_Truck_Rental}"
      println "   DOCK: ${o.has_Loading_Dock}"
      println "   DOCK SZ: ${o.loading_Dock_Size}"
      println "   ELECTRONIC GATE: ${o.has_Electronic_Gate_Access}"
      println "   CAMERA: ${o.has_Surveillance_Cameras}"
      println "   FENCED: ${o.is_Fenced_And_Lighted}"
      println "   24 HR: ${o.has_24_Hour_Access}"
      println "   HARDCART: ${o.has_Handcarts}"
      println "   FEE: ${o.admin_Fee}"
      println "   MANAGER EMAIL: ${o.manager_Email_Address}"
    }
    return false
  }

  boolean loadUnitTypesByFacility (String facilityID) {
    Credentials creds = new Credentials(this.passWord,this.userName); // yes, password/username
    BasicHttpBinding_IAvailabilityDataStub stub = new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    UnitTypeOutput[] output = stub.loadUnitTypesByFacility(creds, facilityID)
    for (UnitTypeOutput o : output) {
      println "UNIT: ${o.toString()}"
    }
    return false
  }

  boolean addReservation () {
    ReservationRequest request = new ReservationRequest(
        "jmeade@storitz.com"  // java.lang.String customer_Email_Address
        ,"Testy"              // java.lang.String customer_First_Name
        ,"McTest"             // java.lang.String customer_Last_Name
        ,"310-444-5550"       // java.lang.String customer_Phone
        ,"FAC1"               // java.lang.String facility_Id
        ,"2011-10-01"         // java.lang.String move_In_Date
        ,19.99                // java.lang.Double quoted_Price
        ,1                    // java.lang.Integer unit_Id
    );
    Credentials creds = new Credentials(this.passWord,this.userName); // yes, password/username
    BasicHttpBinding_IAvailabilityDataStub stub = new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    Integer confID = stub.addReservation (creds, request);
    println "CONFIRMATION: ${confID}"
    return false
  }

}
