import com.storitz.StorageSize
import com.storitz.User
import com.storitz.Role
import com.storitz.UserRole
import com.storitz.NotificationType
import com.storitz.StorageSite

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

       StorageSite.executeUpdate("update StorageSite s set s.disabled = false where s.disabled = :param", null)
       StorageSite.executeUpdate("update StorageSite s set s.deposit = 0 where s.deposit = :param", null)
     }

     def destroy = {
     }
}
