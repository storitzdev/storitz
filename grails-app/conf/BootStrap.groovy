import com.storitz.StorageSize
import com.storitz.User
import com.storitz.Role
import com.storitz.UserRole
import com.storitz.NotificationType
import com.storitz.StorageSite
import com.storitz.SEMLocation
import storitz.constants.State
import com.storitz.Commission
import storitz.constants.CommissionSourceType
import storitz.constants.CommissionType

class BootStrap {

  def springSecurityService

  def init = { servletContext ->

    //org.hsqldb.util.DatabaseManager.main()
       
    // create system ROLES
    def roleUser = Role.findByAuthority('ROLE_USER')
    if (!roleUser) {
      roleUser = new Role( authority: 'ROLE_USER', description: 'Authenticated User').save(flush: true)
    }
    def roleAdmin = Role.findByAuthority('ROLE_ADMIN')
    if (!roleAdmin) {
      roleAdmin = new Role( authority: 'ROLE_ADMIN', description: 'Admin user').save(flush: true)
    }
    def roleManager = Role.findByAuthority('ROLE_MANAGER')
    if (!roleManager) {
      roleManager = new Role( authority: 'ROLE_MANAGER', description: 'Site Manager').save(flush: true)
    }
    def roleCallCenter = Role.findByAuthority('ROLE_CALLCENTER')
    if (!roleCallCenter) {
      roleCallCenter = new Role( authority: 'ROLE_CALLCENTER', description: 'Call Center').save(flush: true)
    }
    def roleCallCenterAdmin = Role.findByAuthority('ROLE_CALLCENTER_ADMIN')
    if (!roleCallCenterAdmin) {
      roleCallCenterAdmin = new Role( authority: 'ROLE_CALLCENTER_ADMIN', description: 'Call Center Administrator').save(flush: true)
    }

    // create system NOTIFICATION types
    def ntSiteManager = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
    if (!ntSiteManager) {
      new NotificationType(notificationType:'NOTIFICATION_SITE_MANAGER', description:'Site Manager').save(flush: true)
    }
    def ntDistrictManager = NotificationType.findByNotificationType('NOTIFICATION_DISTRICT_MANAGER')
    if (!ntDistrictManager) {
      new NotificationType(notificationType:'NOTIFICATION_DISTRICT_MANAGER', description:'District Manager').save(flush: true)
    }
    def ntOperationsManager = NotificationType.findByNotificationType('NOTIFICATION_OPERATIONS_MANAGER')
    if (!ntOperationsManager) {
      new NotificationType(notificationType:'NOTIFICATION_OPERATIONS_MANAGER', description:'Operations Manager').save(flush: true)
    }
    def ntAccounting = NotificationType.findByNotificationType('NOTIFICATION_ACCOUNTING')
    if (!ntAccounting) {
      new NotificationType(notificationType:'NOTIFICATION_ACCOUNTING', description:'Accounting').save(flush: true)
    }


    if (!User.findByUsername('admin')) {
      def admin = new User( username:'admin', password:springSecurityService.encodePassword('WWCharter'), userRealName:'Administrator', enabled:true, email:'mamster@wnx.com', accountExpired: false, accountLocked: false, passwordExpired: false)
      admin.save(flush: true)
      UserRole.create(admin, roleUser, true)
      UserRole.create(admin, roleManager, true)
      UserRole.create(admin, roleAdmin, true)
    }
       
    if (!User.findByUsername('operator')) {
      def operator = new User( username:'operator', password:springSecurityService.encodePassword('WWCharter'), userRealName:'Operator', enabled:true, email:'mamster@wnx.com', accountExpired: false, accountLocked: false, passwordExpired: false)
      operator.save(flush: true)
      UserRole.create(operator, roleCallCenter, true)
    }

    if (StorageSize.list().size() == 0) {
      new StorageSize( description:'Chose the size you need', width: 0, length: 0).save();
      new StorageSize( description:'5 x 5', width: 5, length: 5).save();
      new StorageSize( description:'5 x 10', width: 5, length: 10).save();
      new StorageSize( description:'7 x 10', width: 7, length: 10).save();
      new StorageSize( description:'10 x 10', width: 10, length: 10).save();
      new StorageSize( description:'10 x 15', width: 10, length: 15).save();
      new StorageSize( description:'10 x 20', width: 10, length: 20).save();
      new StorageSize( description:'10 x 25', width: 10, length: 25).save();
      new StorageSize( description:'10 x 30', width: 10, length: 30).save();
    }

    if (Commission.count() == 0) {
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.FIXED, lowerBound: 0.0, upperBound: 40.0, amount: 15.0).save()
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.FIXED, lowerBound: 40.0, upperBound: 80.0, amount: 25.0).save()
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.FIXED, lowerBound: 80.0, upperBound: 100.0, amount: 40.0).save()
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.FIXED, lowerBound: 100.0, upperBound: 150.0, amount: 60.0).save()
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.PERCENTAGE, lowerBound: 150.0, upperBound: 175.0, amount: 45.0).save()
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.PERCENTAGE, lowerBound: 175.0, upperBound: 200.0, amount: 35.0).save()
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.PERCENTAGE, lowerBound: 200.0, upperBound: 300.0, amount: 25.0).save()
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.PERCENTAGE, lowerBound: 300.0, upperBound: 500.0, amount: 20.0).save()
      new Commission(commissionSource:CommissionSourceType.WEBSITE, commissionType:CommissionType.PERCENTAGE, lowerBound: 500.0, upperBound: 99999.0, amount: 15.0).save()
    }

    //StorageSite.executeUpdate("update StorageSite s set s.disabled = false where s.disabled is null")
    //StorageSite.executeUpdate("update StorageSite s set s.noInsuranceWaiver = false where s.noInsuranceWaiver is null")
    //StorageSite.executeUpdate("update StorageSite s set s.deposit = 0 where s.deposit is null")
       
    // setup all the location codes
    if (SEMLocation.count() < 104) {
      new SEMLocation(locationId:1,  city:'Anaheim Hills', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:2,  city:'Arcadia', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:3,  city:'Bell Gardens', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:4,  city:'Burbank', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:5,  city:'Calabasas', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:6,  city:'Camarillo', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:7,  city:'Carlsbad', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:8,  city:'Carson', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:9,  city:'Cerritos', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:10, city:'Chatsworth', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:11, city:'Chula Vista', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:12, city:'Claremont', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:13, city:'Commerce', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:14, city:'Compton', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:15, city:'Corona', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:16, city:'Costa Mesa', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:17, city:'Covina', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:18, city:'Cypress', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:19, city:'Duarte', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:20, city:'El Cajon', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:21, city:'El Monte', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:22, city:'El Segundo', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:23, city:'Encinitas', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:24, city:'Escondido', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:25, city:'Fallbrook', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:26, city:'Fontana', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:27, city:'Gardena', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:28, city:'Glendale', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:29, city:'Glendora', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:30, city:'Harbor City', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:31, city:'Hawaiian Gardens', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:32, city:'Hawthorne', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:33, city:'Hollywood', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:34, city:'Huntington Beach', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:35, city:'Indio', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:36, city:'Inglewood', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:37, city:'Irvine', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:38, city:'Irwindale', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:39, city:'La Crescenta', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:40, city:'La Puente', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:41, city:'La Quinta', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:42, city:'La Verne', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:43, city:'Laguna Hills', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:44, city:'Laguna Niguel', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:45, city:'Lancaster', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:46, city:'Long Beach', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:47, city:'Los Alamitos', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:48, city:'Los Angeles', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:49, city:'Marina del Rey', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:50, city:'Mission Hills', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:51, city:'Mission Viejo', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:52, city:'Montclair', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:53, city:'Montrose', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:54, city:'Moreno Valley', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:55, city:'National City', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:56, city:'Newbury Park', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:57, city:'North Hollywood', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:58, city:'Norwalk', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:59, city:'Oceanside', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:60, city:'Ontario', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:61, city:'Orange', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:62, city:'Oxnard', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:63, city:'Pacoima', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:64, city:'Palm Desert', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:65, city:'Palm Springs', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:66, city:'Palmdale', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:67, city:'Panorama City', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:68, city:'Paramount', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:69, city:'Pico Rivera', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:70, city:'Pomona', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:71, city:'Poway', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:72, city:'Rancho Cucamonga', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:73, city:'Rancho Dominguez', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:74, city:'Rancho Santa Margarita', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:75, city:'Redlands', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:76, city:'Redondo Beach', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:77, city:'Riverside', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:78, city:'Salinas', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:79, city:'San Bernardino', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:80, city:'San Diego', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:81, city:'Santa Ana', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:82, city:'Santa Clara', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:83, city:'Santa Fe Springs', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:84, city:'Santa Monica', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:85, city:'Sherman Oaks', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:86, city:'Simi Valley', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:87, city:'Solana Beach', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:88, city:'Spring Valley', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:89, city:'Stanton', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:90, city:'Studio City', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:91, city:'Sunland', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:92, city:'Sylmar', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:93, city:'Temecula', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:94, city:'Thousand Oaks', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:95, city:'Torrance', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:96, city:'Tustin', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:97, city:'Venice', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:98, city:'Ventura', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:99, city:'Victorville', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:100, city:'Walnut', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:101, city:'West Hollywood', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:102, city:'Westminster', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:103, city:'Whittier', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
      new SEMLocation(locationId:104, city:'Woodland Hills', state:State.CALIFORNIA, created: new Date(), updated: new Date()).save()
    }
  }
     
  def destroy = {
  }
}
