import org.codehaus.groovy.grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class StorageSizeController {

  def scaffold = StorageSize
}
