import com.storitz.StorageSize
import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class StorageSizeController {

  def scaffold = StorageSize
}
