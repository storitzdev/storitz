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
import grails.converters.JSON
import com.storitz.SiteLink
import com.storitz.SiteUser
import com.storitz.CenterShift
import storitz.CustomDomainMarshaller
import storitz.constants.UnitType
import com.storitz.UnitTypeLookup
import grails.util.Environment

class BootStrap {

  def springSecurityService

  def init = { servletContext ->

    println "Starting hsqldb"
    if(Environment.current == Environment.DEVELOPMENT){
      String[] databaseManagerOptions = ['--url', 'jdbc:hsqldb:mem:devDB', '--noexit'];
      org.hsqldb.util.DatabaseManagerSwing.main(databaseManagerOptions)
    }

    JSON.registerObjectMarshaller(new CustomDomainMarshaller())

    println "Regitstering Custom Marshallers"

    JSON.registerObjectMarshaller StorageSite, {

      println "Using the registered StorageSite Marshaller"

      def returnArray = [:]
      // skip units - refresh will get those
      returnArray['specialOffers'] = it.specialOffers
      returnArray['images'] = it.images
      // skip site users
      returnArray['insurances'] = it.insurances
      // skip visits
      returnArray['securityItems'] = it.securityItems
      returnArray['convenienceItems'] = it.convenienceItems
      returnArray['amenityItems'] = it.amenityItems
      returnArray['title'] = it.title
      returnArray['description'] = it.description
      returnArray['logo'] = it.logo
      returnArray['lat'] = it.lat
      returnArray['lng'] = it.lng
      returnArray['address'] = it.address
      returnArray['address2'] = it.address2
      returnArray['city'] = it.city
      returnArray['state'] = it.state
      returnArray['zipcode'] = it.url
      returnArray['url'] = it.url
      returnArray['phone'] = it.phone
      returnArray['source'] = it.source
      returnArray['sourceId'] = it.sourceId
      returnArray['sourceLoc'] = it.sourceLoc
      returnArray['requiresInsurance'] = it.requiresInsurance
      returnArray['noInsuranceWaiver'] = it.noInsuranceWaiver
      returnArray['boxesAvailable'] = it.boxesAvailable
      returnArray['freeTruck'] = it.freeTruck
      returnArray['isGate'] = it.isGate
      returnArray['isKeypad'] = it.isKeypad
      returnArray['isCamera'] = it.isCamera
      returnArray['isUnitAlarmed'] = it.isManagerOnsite
      returnArray['hasElevator'] = it.hasElevator
      returnArray['adminFee'] = it.adminFee
      returnArray['lockFee'] = it.lockFee
      returnArray['deposit'] = it.deposit
      returnArray['prorateStart'] = it.prorateStart
      returnArray['prorateCutoff'] = it.prorateCutoff
      returnArray['prorateSecondMonth'] = it.prorateSecondMonth
      returnArray['openWeekday'] = it.openWeekday
      returnArray['openSaturday'] = it.openSaturday
      returnArray['openSunday'] = it.openSunday
      returnArray['startWeekday'] = it.startWeekday
      returnArray['endWeekday'] = it.endWeekday
      returnArray['startSaturday'] = it.startSaturday
      returnArray['endSaturday'] = it.endSaturday
      returnArray['startSunday'] = it.startSunday
      returnArray['endSunday'] = it.endSunday
      returnArray['startGate'] = it.startGate
      returnArray['endGate'] = it.endGate
      returnArray['startSundayGate'] = it.startSundayGate
      returnArray['endSundayGate'] = it.endSundayGate
      returnArray['taxRateRental'] = it.taxRateRental
      returnArray['taxRateInsurance'] = it.taxRateInsurance
      returnArray['useProrating'] = it.useProrating
      // skip feed
      returnArray['disabled'] = it.disabled
      returnArray['bankAccount'] = it.bankAccount
      returnArray['rentalAgreement'] = it.rentalAgreement
      returnArray['lastChange'] = it.lastChange

      return returnArray
    }

    JSON.registerObjectMarshaller SiteLink, {
      println "Using the registered SiteLink Marshaller"

      def returnArray = [:]
      returnArray['corpCode'] = it.feedType
      returnArray['userName'] = it.userName
      returnArray['password'] = it.operatorName
      returnArray['feedType'] = it.feedType
      returnArray['manager'] = it.manager
      returnArray['operatorName'] = it.operatorName
      returnArray['sites'] = it.sites

      return returnArray

    }

    JSON.registerObjectMarshaller CenterShift, {
      println "Using the registered CenterShift Marshaller"

      def returnArray = [:]
      returnArray['cshiftVersion'] = it.cshiftVersion
      returnArray['userName'] = it.userName
      returnArray['pin'] = it.pin
      returnArray['location'] = it.location
      returnArray['orgId'] = it.orgId
      returnArray['feedType'] = it.feedType
      returnArray['manager'] = it.manager
      returnArray['operatorName'] = it.operatorName
      returnArray['sites'] = it.sites

      return returnArray

    }

    JSON.registerObjectMarshaller User, {

      println "Using the registered User Marshaller"

      def returnArray = [:]
      returnArray['notificationTypes'] = it.notificationTypes
      returnArray['username'] = it.username
      returnArray['password'] = it.password
      returnArray['email'] = it.email
      returnArray['userRealName'] = it.userRealName
      returnArray['description'] = it.description
      returnArray['enabled'] = it.enabled
      returnArray['accountExpired'] = it.accountExpired
      returnArray['accountLocked'] = it.accountLocked
      returnArray['passwordExpired'] = it.passwordExpired
      returnArray['manager'] = it.manager

      return returnArray
    }

    JSON.registerObjectMarshaller SiteUser, {
      println "Using the registered SiteUser Marshaller"

      def returnArray = [:]
      returnArray['user'] = it.user.username
      returnArray['site'] = it.site.title

      return returnArray
      
    }

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
      admin.manager = admin;
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

    // Unit Description types from vendors
    println "Starting unit type lookup creation"
    setupUnitTypes1()
    setupUnitTypes2()
    println "All Unit type lookups are done"
  }
     
  def destroy = {
  }

  def setupUnitTypes1() {
    new UnitTypeLookup(id:1, description:"Climate Controlled Ground Level", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:2, description:"Lower Level Climate Controlled", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:3, description:"Upper", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:4, description:"2nd Floor Storage", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:5, description:"1st Floor Storage", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:6, description:"Drive Up Access", unitType:UnitType.DRIVEUP, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:7, description:"Interior Storage", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:8, description:"Upstairs", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:9, description:"Special, Upper Floor", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:10, description:"Climate Controlled Interior Unit", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:11, description:"Interior 1st floor Regular Storage- Premium", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:12, description:"Carports", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:13, description:"Interior Unit Second Floor", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:14, description:"Downstairs", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:15, description:"Interior Unit Ground Level", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:16, description:"Climate Controlled Upper Unit", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:17, description:"Upstairs Rollup Door", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:18, description:"Indoor Rollup Door", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:19, description:"Second Floor Climate Control", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:20, description:"1st Floor Interior", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:21, description:"Second Floor Non Climate Control", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:22, description:"RV", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:23, description:"Interior Climate Controlled", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:24, description:"Elevator - Climate Controlled", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:25, description:"Interior Unit", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:26, description:"Drive Up Interior", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:27, description:"Locker", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:28, description:"Ground Level Air Conditioned", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:29, description:"Ground Level", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:30, description:"Ground Climate Controlled", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:31, description:"Ground Level - NON Climate Controlled", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:32, description:"Locker Climate Controlled", unitType:UnitType.UNDEFINED, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:33, description:"Upper Air Conditioned", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:34, description:"Basement Interior Unit", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:35, description:"Mail Box", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:36, description:"Upper,ClimateControl", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:37, description:"1st Floor Climate Controlled", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:38, description:"Ground Level Interior", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:39, description:"Lower Level Interior", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:40, description:"Upper Level", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:41, description:"2nd Floor Interior", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:42, description:"3rd Floor Interior", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:43, description:"2nd Floor Slant", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:44, description:"Drive Up 24 Hour Access", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:45, description:"Climate 2nd Level", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:46, description:"Climate 3rd Level", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:47, description:"Interior Upper Unit", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:48, description:"High Door", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:49, description:"Recreational Vehicle", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:50, description:"Interior Unit Swing Door", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:51, description:"Drive Up Access Swing Door", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:52, description:"Double Door", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:53, description:"Climate Controlled Upstairs Interior", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:54, description:"Interior Unit Third Floor", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:55, description:"Interior, 1st floor climate controlled storage", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:56, description:"Interior, Climate Controlled", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:57, description:"Lower Level", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:58, description:"Upper Floor", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:59, description:"UnderStairs", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:60, description:"Lower", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:61, description:"5th Floor Upper Locker", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:62, description:"5th Floor Lower Locker", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:63, description:"Locker Upper", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:64, description:"Locker Lower", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:65, description:"1st Floor Lower Locker", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:66, description:"1st Floor Upper Locker", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:67, description:"Climate Controlled Swing Door", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:68, description:"Second Floor SS", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:69, description:"Third Floor S.S.", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:70, description:"First Floor S.S.", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:71, description:"Outside", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:72, description:"Double Door", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:73, description:"DRIVEWAY", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:74, description:"UPSTAIRS", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:75, description:"DOWN INSIDE", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:76, description:"DRIVEWAY INSIDE", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:77, description:"Parking	RV", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:78, description:"DRI. INS. (HALF)", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:79, description:"DOWN C/C", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:80, description:"UPSTAIRS (SP)", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:81, description:"C/C DOWN (HALF)", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:82, description:"OFFICE", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:83, description:"LLP (Lower Level", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:84, description:"LL (DOWN STAIRS)", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:85, description:"Double Door unit", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:86, description:"GH (GROUND HALLW", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:87, description:"DUI  (DRIVE UP I", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:88, description:"DU (DRIVE UP)", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:89, description:"ACW (Tall)", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:90, description:"ACW(Locker)", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:91, description:"DUD (DRIVE UP DO", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:92, description:"SW (Stairwell)", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:93, description:"Level 1", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:94, description:"Drive Up", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:95, description:"Level 2", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:96, description:"Mezzanine", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:97, description:"Mezzanine DD", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:98, description:"1st Floor S.S.", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:99, description:"2nd Floor S.S.", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:100, description:"3rd floor S.S.", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:101, description:"High Security S.", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:102, description:"3rd Floor S.S DD", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:103, description:"UP", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:104, description:"DOR-N DD", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:105, description:"DOWN", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:106, description:"DIR", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:107, description:"DOR", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:108, description:"DOR-N", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:109, description:"Self Storage UP", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:110, description:"Self Storage", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:111, description:"DD UP STAIRS", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:112, description:"SelfStorage Down", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:113, description:"RV Parking (P2)", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:114, description:"LPF", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:115, description:"RV Parking (P1)", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:116, description:"Third Floor", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:117, description:"First Floor", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:118, description:"Double Door 3rd", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:119, description:"Container", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:120, description:"Second Floor", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:121, description:"1ST FLOOR", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:122, description:"3RD FLOOR", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:123, description:"2ND FLOOR", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:124, description:"1ST FLOOR SP.", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:125, description:"3RD FLOOR SP", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:126, description:"2ND FLOOR SP", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:127, description:"3RD Floor DD", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:128, description:"Inside Roll Door", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:129, description:"Drive-Up 2Dr", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:130, description:"Drive-Up Roll Dr", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:131, description:"RV40", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:132, description:"3RD FLOOR A/C", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:133, description:"MAIN FLOOR", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:134, description:"10 ft. Ceiling", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:135, description:"Self Storage X", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:136, description:"14 ft. Ceiling", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:137, description:"ROLL UP", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:138, description:"BALCONY", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:139, description:"IS", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:140, description:"OR 9 ft", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:141, description:"OR", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:142, description:"CS", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:143, description:"COR", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:144, description:"OR 14 ft.", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:145, description:"2 Door COR", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:146, description:"OR 12 ft.", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:147, description:"Climate Climate", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:148, description:"Double Doors", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:149, description:"RV Ports", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:150, description:"RV (Uncovered)", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:151, description:"RV Port(D-Thru)", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:152, description:"HighElectronicDr", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:153, description:"High Doors", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:154, description:"High Drs(D-Thru)", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:155, description:"1st Floor Evap", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:156, description:"2nd Floor Evap", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:157, description:"Basement A/C", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:158, description:"Basement (A/C)", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:159, description:"2nd Floor (Evap)", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:160, description:"Main Floor (Evap", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:161, description:"Lockers", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:162, description:"Upper", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:163, description:"Hallway", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:164, description:"Lower", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:165, description:"SelfStorage 10ft", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:166, description:"Self Storage Ins", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:167, description:"Self Storage Out", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:168, description:"Walk In", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:169, description:"Vehicle Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:170, description:"Air Condition", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:171, description:"DriveUp Double D", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:172, description:"Converted Units", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:173, description:"Portables", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:174, description:"ALARMED/CLIMATE", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:175, description:"PF", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:176, description:"Climate Control", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:177, description:"RV 10x40's", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:178, description:"Self Storage Inside", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:179, description:"RV S.S. Indoor", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:180, description:"Drive Up Access", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:181, description:"Hallway Units", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:182, description:"Preferred Storag", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:183, description:"RV Covered", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:184, description:"2ND FLR", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:185, description:"1ST FLR", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:186, description:"3RD  FLR", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:187, description:"2ND FLR CLIMATE", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:188, description:"3RD FLR ODD", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:189, description:"2ND FLR ODD", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:190, description:"Hallway Self Sto", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:191, description:"INSIDE", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:192, description:"DRIVE UP-24 HR", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:193, description:"Upper Interior", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:194, description:"Ground Interior", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:195, description:"Exterior", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:196, description:"Drive Ups", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:197, description:"1st Floor C", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:198, description:"1st Floor B", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:199, description:"Locker", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:200, description:"1ST FLOOR INDOOR", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:201, description:"SECOND FLR CC", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:202, description:"Drive-Up", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:203, description:"Climate", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:204, description:"In Hallway Self", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:205, description:"Outside self sto", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:206, description:"New 2nd floor", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:207, description:"Old 1st floor", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:208, description:"Old 2nd Floor", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:209, description:"New 3rd floor", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:210, description:"New 1st floor", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:211, description:"Drive Up Storage", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:212, description:"1st floor inside", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:213, description:"2nd floor odd", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:214, description:"Down A/E", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:215, description:"Down B", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:216, description:"Drive-ups", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:217, description:"3rd Floor CC", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:218, description:"2nd Floor CC", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:219, description:"1st Floor CC", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:220, description:"Indoor 1st floor", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:221, description:"2 ND FLOOR", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:222, description:"2nd Floor Climate Control", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:223, description:"3rd Floor Non-Climate Control", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:224, description:"1st Floor Climate Control", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:225, description:"First Floor In", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:226, description:"Outside Units", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:227, description:"Drive-up Units", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:228, description:"Shelves", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:229, description:"In Angled", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:230, description:"Drive Up Angled", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:231, description:"Commercial", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:232, description:"Down-In", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:233, description:"CC 2nd floor", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:234, description:"1st Floor Air Conditioned", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:235, description:"2nd Floor Air Conditioned", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:236, description:"Drive-Up - Large Door", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:237, description:"1st Floor Hallway-NON Air Cond", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:238, description:"Locker - 2nd Floor Climate DN", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:239, description:"Locker - 1st Floor Climate DN", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:240, description:"Locker - 1st Floor Climate UP", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:241, description:"Locker - up", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:242, description:"Locker - down", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:243, description:"Second Floor CC", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:244, description:"DOWN-Inside", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:245, description:"UP-Temperature Controlled", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:246, description:"DOWN-Outside", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:247, description:"UP-Standard", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:248, description:"First Floor Inside", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:249, description:"Drive Up Tall", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:250, description:"Ground Climate Control", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:251, description:"Downstairs", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:252, description:"Outside Drive-Up", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:253, description:"Upstairs Climate Control", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:254, description:"Inside 1st Floor", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:255, description:"Inside Hallway", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:256, description:"Outside Drive Up", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:257, description:"Outside 24 Hour", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:258, description:"RV Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:259, description:"Locker-Downstairs", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:260, description:"Locker-Upstairs", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:261, description:"Parking 3000 SF", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:262, description:"Inside/Hallway", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:263, description:"Wide Double Door", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:264, description:"Wide Door", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:265, description:"Upstairs Climate", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:266, description:"Downstairs Climate", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:267, description:"Uncovered Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:268, description:"Climate Controlled", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:269, description:"Outside 10 FT Door", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:270, description:"Covered Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:271, description:"Inside 12 FT Door", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:272, description:"Inside 10FT Door", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:273, description:"Outside Swing Door", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:274, description:"Drive Through Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:275, description:"Upper Inside Hallway", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:276, description:"Lower Inside", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:277, description:"Upper Drive Up", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:278, description:"2nd Floor Climate", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:279, description:"1st Floor Climate", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:280, description:"Irregular Shaped", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:281, description:"Upper Climate Control", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:282, description:"Interior Elevator", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:283, description:"Lower Interior", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:284, description:"mailbox small", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:285, description:"Car Club", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:286, description:"mailbox medium", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:287, description:"Interior CC", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:288, description:"Futures Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:289, description:"Interior CD", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:290, description:"mailbox large", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:291, description:"Office Incubator with storage", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:292, description:"Drive Up Rv", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:293, description:"Exterior CC Driv", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:294, description:"CCO (Non 1st floor units)", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:295, description:"Mail Boxes", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:296, description:"CC (Climate Control)", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:297, description:"Offices", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:298, description:"CCO (non 1st floor)", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:299, description:"Mailbox, Small", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:300, description:"Indoor CC", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:301, description:"Mailbox, medium", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:302, description:"Mailbox, Large", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:303, description:"CCO (Second Floor)", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:304, description:"CC (First Floor)", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:305, description:"RV Parking CC", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:306, description:"Suites", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:307, description:"RV Parking NC", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:308, description:"CCO (Non - First Floor)", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:309, description:"NCC (Non Climate Contol)", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:310, description:"Post Office Box", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:311, description:"CD (Premium Access)", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:312, description:"UNRENTABLE UNIT", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:313, description:"MBSM", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:314, description:"MBLG", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:315, description:"OUTSIDE WET DU", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:316, description:"MBMD", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:317, description:"OUTSIDE DU", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:318, description:"OUTSIDE WET", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:319, description:"TEMP", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:320, description:"CC MINI", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:321, description:"OUTSIDE MINI", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:322, description:"CCDU", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:323, description:"PARK", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:324, description:"Mailboxes", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:325, description:"Semi Storage", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:326, description:"Mini", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:327, description:"Parking Spaces", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:328, description:"Non CC drive up", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:329, description:"Incubator Office", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:330, description:"Heated RVstorage", unitType:UnitType.UNDEFINED,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:331, description:"model", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:332, description:"Mailboxes-small", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:333, description:"Drive-up Non-cc", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:334, description:"Mailboxes-large", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:335, description:"Mailboxes-medium", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:336, description:"CC Drive Up", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:337, description:"Non Climate Exterior", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:338, description:"Non Climate Interior", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:339, description:"Wine", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:340, description:"Classic Car Bld", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:341, description:"Non CC Exterior w/elec", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:342, description:"Other Floors", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:343, description:"Basement", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:344, description:"Water Discount", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:345, description:"Climate Controlled (cc)", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:346, description:"Non Climate (nc)", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:347, description:"Premium (pr)", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:348, description:"(ncx) Non Climate Exterior", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:349, description:"(cc) Climate Controlled", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:350, description:"(nci) Non Climate Interior", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:351, description:"Climate Control Other", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:352, description:"Central Drive", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:353, description:"Climate Control Cement", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:354, description:"FLEX SPACE", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:355, description:"(nc) Non Climate Units", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:356, description:"(cd) Central Drive", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:357, description:"(cco) Climate Controlled other", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:358, description:"(du) Drive Up Units", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:359, description:"Climate Controlled Other", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:360, description:"Climate Contolled", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:361, description:"Non Climate", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:362, description:"(nc) Non Climate", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:363, description:"(nco) Non Climate Other", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:364, description:"(lk) Lockers", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:365, description:"Climate Conrolled", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:366, description:"(cc) Climate Conrolled", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:367, description:"CC", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:368, description:"CCO", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:369, description:"CD", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:370, description:"CCOO", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:371, description:"LCC", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:372, description:"(nccd) Non Climate Drive Up", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:373, description:"(cc) Climate Control", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:374, description:"(rv) Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:375, description:"Breezeway", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:376, description:"Ground Climate Controlled", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:377, description:"OUT", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:378, description:"IN", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:379, description:"MAIL BOX", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:380, description:"IN REPAIR", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:381, description:"COMPANY", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:382, description:"(ccd) Climate drive up", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:383, description:"(cco) Climate other", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:384, description:"(cc) Climate", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:385, description:"(ncx) Non Climate Drive up", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:386, description:"(hto) Heated Other", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:387, description:"(ht) Heated", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:388, description:"10x20 Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:389, description:"10x30 Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:390, description:"CDN-Climate Down Normal", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:391, description:"NON-Non-Climate Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:392, description:"NDN-Non-Climate Down Normal", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:393, description:"CDNM-Climate Down Normal", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:394, description:"CON-Climate Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:395, description:"NONM-Non-Climate Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:396, description:"NDNM-Non-Climate Down Normal", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:397, description:"NLN-Non-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:398, description:"NOP-Non-Climate Outside Premium", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:399, description:"CEN-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:400, description:"NSE-Non-Climate UP Economy", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:401, description:"NSNM-Non-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:402, description:"NSN-Non-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:403, description:"NONU-Non-Climate Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:404, description:"CENW-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:405, description:"CENM-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:406, description:"CBN-Climate Basement Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:407, description:"NEN-Non-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:408, description:"HEN-Heated UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:409, description:"HON-Heated Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:410, description:"HDN-Heated Down Normal", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:411, description:"HOP-Heated Outside Premium", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:412, description:"CENA-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:413, description:"CDX-Climate Down Locker", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:414, description:"NONA-Non-Climate Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:415, description:"NDNA-Non-Climate Down Normal", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:416, description:"NSX - Non-Climate UP Locker Unit", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:417, description:"NDX-Non-Climate Down Locker", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:418, description:"RAA-Retail", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:419, description:"CDY-Climate Down Ladder Unit", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:420, description:"NEX - Non-Climate UP Locker Unit", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:421, description:"CEE-Climate UP Economy", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:422, description:"AEN-Air-Cooled UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:423, description:"CLN-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:424, description:"CLE-Climate UP Economy", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:425, description:"NDZ-Non-Climate Down Ladder Unit", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:426, description:"NEY - Non-Climate UP Locker Unit", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:427, description:"NBN-Non-Climate Basement Normal", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:428, description:"NBP-Non-Climate Basement Premium", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:429, description:"NEEM-Non-Climate UP Economy", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:430, description:"HDX-Heated Down Locker", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:431, description:"NLE-Non Climate Up Economy (near lift)", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:432, description:"NENM-Non-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:433, description:"AENU-Air-Cooled UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:434, description:"AENM-Air-Cooled UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:435, description:"CDNU-Climate Down Normal", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:436, description:"NDE-Non-Climate Down Economy", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:437, description:"NONW-Non-Climate Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:438, description:"NDEM-Non-Climate Down Economy", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:439, description:"HENM-Heated UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:440, description:"HBN-Heated Basement Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:441, description:"NDP-Non-Climate Down Premium", unitType:UnitType.INTERIOR,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:442, description:"XAA-WareHouse", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:443, description:"CEX - Climate UP Locker Unit", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:444, description:"NEE-Non-Climate UP Economy", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:445, description:"NOE-Non-Climate Outside Economy", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:446, description:"CDE-Climate Down Economy", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:447, description:"HDE-Heated Down Economy", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:448, description:"BAA-Billboard", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:449, description:"WAA-WorkShop", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:450, description:"CSN-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:451, description:"NXN-Non-Climate Stacked Normal", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:452, description:"CLNM-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:453, description:"NLNM-Non-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:454, description:"NOEM-Non-Climate Outside Economy", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:455, description:"ADN-Air-Cooled Down Normal", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:456, description:"AON-Air-Cooled Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:457, description:"DDN-Dehumidified Down Normal", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:458, description:"CDP-Climate Down Premium", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:459, description:"HEY - Heated UP Locker Unit", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:460, description:"CDU-Climate Down U.Premium", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:461, description:"AEEU-Air-Cooled UP Economy", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:462, description:"CENU-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:463, description:"ADNM-Air-Cooled Down Normal", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:464, description:"HDP-Heated Down Premium", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:465, description:"NEP-Non-Climate UP Premium", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:466, description:"CSE-Climate UP Economy", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:467, description:"CEY - Climate UP Locker Unit", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:468, description:"CEP-Climate UP Premium", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:469, description:"NENU-Non-Climate UP Normal", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:470, description:"CSX - Climate UP Locker Unit", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:471, description:"CBNM-Climate Basement Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:472, description:"CDNA-Climate Down Normal", unitType:UnitType.INTERIOR,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:473, description:"Garage Unit", unitType:UnitType.DRIVEUP,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:474, description:"AONU-Air-Cooled Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:475, description:"AONM-Air-Cooled Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:476, description:"ASN-Air-Cooled UP Normal", unitType:UnitType.UPPER,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:477, description:"Self Storage", unitType:UnitType.UPPER,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:478, description:"CONM-Climate Outside Normal", unitType:UnitType.DRIVEUP,tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:479, description:"Parking", unitType:UnitType.UNDEFINED,tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:480, description:"Drive-up access climate controlled storage", unitType:UnitType.DRIVEUP, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:481, description:"Drive-up access regular storage", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:482, description:"Humidity Controlled", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:483, description:"Drive Up Access 2 Entry", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:484, description:"Climate Controlled Upper Premium", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:485, description:"Drive-up oversized access regular storage", unitType:UnitType.DRIVEUP, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:486, description:"Mailbox", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:487, description:"Cell Tower", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:488, description:"Cell Tower", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:489, description:"Container", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:490, description:"Small Mail Slot", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:491, description:"2nd Floor Climate Controlled - Phase 1", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:492, description:"2nd Floor Climate Controlled", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:493, description:"First Floor Bldg B", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:494, description:"EZ Wet Slip", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:495, description:"15x30", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:496, description:"Climate Controlled Upper Premium", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:497, description:"Climate Controlled - Premium", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:498, description:"Outside SSO", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:499, description:"RV Space - REG", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:500, description:"RV Space - LGE", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
  }


  def setupUnitTypes2() {
    new UnitTypeLookup(id:501, description:"Drive-up 24hr", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:502, description:"Outside SSO", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:503, description:"Small Door", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:504, description:"Non-Climate Inside", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:505, description:"2nd Floor- Inside", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:506, description:"1st Floor - Inside", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:507, description:"2nd Floor - Climate Control", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:508, description:"RV Canopy", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:509, description:"RV Parking Pull", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:510, description:"Self Storage-Out", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:511, description:"Shelving Unit", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:512, description:"Climate Control-2nd Floor", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:513, description:"RV-40", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:514, description:"Self Storage- 1st Floor Inside", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:515, description:"RV-30", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:516, description:"RV-25", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:517, description:"RV-35", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:518, description:"RV-50", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:519, description:"RV-15", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:520, description:"RV-13", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:521, description:"Canopy 40", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:522, description:"Canopy 25", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:523, description:"Self Storage - Inside", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:524, description:"SS-10X25-2Door", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:525, description:"Triangle Outside", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:526, description:"Interior Self St", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:527, description:"1st Floor-Inside", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:528, description:"Shelving Units", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:529, description:"Triangle  Inside", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:530, description:"RV/BOAT", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:531, description:"Locker - 4 ft tall", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:532, description:"Parking Gated", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:533, description:"RETAIL", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:534, description:"Storage Locker", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:535, description:"24 Hour Access", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:536, description:"Parking Uncovered", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:537, description:"Parking Drive Through", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:538, description:"Apartment", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:539, description:"Parking w/elec", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:540, description:"Parking (rv)", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:541, description:"(crv)Parking - Covered", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:542, description:"(rv) Parking out", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:543, description:"(cov) Indoor Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:544, description:"(crv) Parking Carport", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:545, description:"Parking Outside", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:546, description:"Upstairs Interior", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:547, description:"Container Outside", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:548, description:"Drive Up Access", unitType:UnitType.DRIVEUP, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:549, description:"RV Parking - Uncovered", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:550, description:"Air Conditioned", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:551, description:"Standard", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:552, description:"RV Parking - Covered", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:553, description:"Roll-Up", unitType:UnitType.UPPER, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:554, description:"Parking Space", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:555, description:"Parking Inside", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:556, description:"Parking Outside", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:557, description:"Lower, Climate Control", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:558, description:"Parking Type 1", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:559, description:"Portable Storage Vault", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:560, description:"Parking Type 2", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:561, description:"R-V Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:562, description:"Wine Storage", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:563, description:"Wine Storage Top", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:564, description:"Mailbox-Out", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:565, description:"Rectangle", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:566, description:"Triangle", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:567, description:"Interior", unitType:UnitType.INTERIOR, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:568, description:"PAA-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:569, description:"VAA-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:570, description:"OAA-OfficeSpace", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:571, description:"HEX - Heated UP Locker Unit", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:572, description:"CDXV - Climate DOWN Locker Unit Wine", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:573, description:"TAA-CellTower", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:574, description:"LAA-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:575, description:"Mailbox - Small", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:576, description:"VDA-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:577, description:"VAE-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:578, description:"CLNU-Climate UP Normal", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:579, description:"PAP-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:580, description:"OAP-OfficeSpace Premium", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:581, description:"OAE-OfficeSpace Economy", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:582, description:"ZAA - Apartment", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:583, description:"PAAU-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:584, description:"PAP-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:585, description:"HEEM-Heated UP Economy", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:586, description:"HDY-Heated DOWN Locker Unit", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:587, description:"Interior CC DU", unitType:UnitType.UPPER, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:588, description:"Refrigerated", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
    new UnitTypeLookup(id:589, description:"Mailbox (lg)", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:590, description:"PAE-Parking", unitType:UnitType.UNDEFINED, tempControlled:false).save(validate:false)
    new UnitTypeLookup(id:591, description:"CDNV-Climate Down Normal", unitType:UnitType.INTERIOR, tempControlled:true).save(validate:false)
  }


}
