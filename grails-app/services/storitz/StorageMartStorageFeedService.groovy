package storitz

import com.storitz.Feed
import com.storitz.StorageSite
import com.storitz.RentalTransaction
import org.tempuri.BasicHttpBinding_IAvailabilityDataStub
import org.datacontract.schemas._2004._07.StorageMart_Services.Credentials
import org.datacontract.schemas._2004._07.StorageMart_Services.FacilityOutput
import org.datacontract.schemas._2004._07.StorageMart_Services.UnitTypeOutput
import org.datacontract.schemas._2004._07.StorageMart_Services.ReservationRequest
import org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput

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
  boolean testLoadFacilitiesAndUnits () {
    Credentials creds = new Credentials(this.passWord,this.userName); // yes, password/username
    BasicHttpBinding_IAvailabilityDataStub stub = new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    FacilityOutput [] output = stub.loadFacilities(creds);
    for (FacilityOutput o : output) {
      println "FACILITY: ${o.toString()}"
      println "   ID: ${o.facility_Id}"
      println "   NAME: ${o.name}"
      println "   DESC: ${o.description}"
      println "   PROMO: ${o.promotion}"
      println "   PROMO (LONG): ${o.promotionLongFormText}"
      for (int i = 0; i < o.image_Urls.size(); i++) {
        def image = o.image_Urls[i]
        println "   IMG[${i}]: ${image}"
      }
      println "   ADDRESS: ${o.address}"
      println "   CITY: ${o.city}"
      println "   STATE: ${o.state}"
      println "   ZIP: ${o.zip}"
      println "   PHONE: ${o.phone}"
      for (int i = 0; i < o.office_Hours.size(); i++) {
        FacilityHoursOutput hours = o.office_Hours[i]
        def daily_hrs = "${hours.open} - ${hours.closed}"
        println "   OFFICE[${i}] : ${hours.day} (${hours.is_Closed ? 'closed' : 'open'}), \t${hours.is_24_Hours ? '24 hour' : daily_hrs}"
      }
      for (int i = 0; i < o.access_Hours.size(); i++) {
        FacilityHoursOutput hours = o.access_Hours[i]
        def daily_hrs = "${hours.open} - ${hours.closed}"
        println "   ACCESS[${i}] : ${hours.day} (${hours.is_Closed ? 'closed' : 'open'}), \t${hours.is_24_Hours ? '24 hour' : daily_hrs}"
      }
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
      for (int i = 0; i < o.manager_Email_Address.size(); i++) {
        def email = o.manager_Email_Address[i]
        println "   MANAGER EMAIL[${i}]: ${email}"
      }

      try {
        testLoadUnitTypesByFacility (o.facility_Id)
      }
      catch (Throwable t) {
        println "ERROR!!! FACILITY ID=${o.facility_Id}"
        t.printStackTrace(System.err)
      }

    }
    return true
  }

  boolean testLoadUnitTypesByFacility (String facilityID) {
    Credentials creds = new Credentials(this.passWord,this.userName); // yes, password/username
    BasicHttpBinding_IAvailabilityDataStub stub = new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    UnitTypeOutput[] output = stub.loadUnitTypesByFacility(creds, facilityID)
    for (UnitTypeOutput o : output) {
      println "   UNIT: ${o.toString()}"
      println "      can_Store_Vehicle:${o.can_Store_Vehicle}"
      println "      discount_Price:${o.discount_Price}"
      println "      door_Height:${o.door_Height}"
      println "      door_Type:${o.door_Type}"
      println "      door_Width:${o.door_Width}"
      println "      electricity:${o.electricity}"
      println "      floor:${o.floor}"
      println "      has_Alarm:${o.has_Alarm}"
      println "      has_Drive_Up_Access:${o.has_Drive_Up_Access}"
      println "      has_Outdoor_Access:${o.has_Outdoor_Access}"
      println "      height:${o.height}"
      println "      is_Climate_Controlled:${o.is_Climate_Controlled}"
      println "      is_Covered_Parking_Spot:${o.is_Covered_Parking_Spot}"
      println "      is_Humidity_Controlled:${o.is_Humidity_Controlled}"
      println "      length:${o.length}"
      println "      price:${o.price}"
      println "      promotion:${o.promotion}"
      println "      promotionLongFormText:${o.promotionLongFormText}"
      println "      quantity_Available:${o.quantity_Available}"
      println "      type:${o.type}"
      println "      unit_Type_Id:${o.unit_Type_Id}"
      println "      width:${o.width}"
    }
    return false
  }

  boolean testAddReservation () {
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
