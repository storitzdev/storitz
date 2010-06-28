class BootStrap {

     def authenticateService

     def init = { servletContext ->
       
       def roleUser = new Role( authority: 'ROLE_USER', description: 'Authenticated User').save(flush: true)
       def roleAdmin = new Role( authority: 'ROLE_ADMIN', description: 'Admin user').save(flush: true)
       new Role( authority: 'ROLE_MANAGER', description: 'Site Manager').save(flush: true)

       def admin = new User( username:'admin', passwd:authenticateService.encodePassword('WWCharter'), userRealName:'Administrator', enabled:true, email:'mamster@wnx.com')
       if (roleAdmin) {
        roleAdmin.addToPeople(admin)
       }
       if (roleUser) {
        roleUser.addToPeople(admin)
       }
       admin.save(flush: true)

       if (StorageSize.list().size() == 0) {
         new StorageSize( description:'No size chosen', width: 0, length: 0).save();
         new StorageSize( description:'5 x 5', width: 5, length: 5).save();
         new StorageSize( description:'5 x 10', width: 5, length: 10).save();
         new StorageSize( description:'7 x 10', width: 7, length: 10).save();
         new StorageSize( description:'10 x 10', width: 10, length: 10).save();
         new StorageSize( description:'10 x 15', width: 10, length: 15).save();
         new StorageSize( description:'10 x 20', width: 10, length: 20).save();
         new StorageSize( description:'10 x 25', width: 10, length: 25).save();
         new StorageSize( description:'10 x 30', width: 10, length: 30).save();
       }
     }

     def destroy = {
     }
} 