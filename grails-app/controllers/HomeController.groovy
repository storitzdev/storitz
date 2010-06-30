import com.storitz.StorageSize

class HomeController {

    def index = {
      [ sizeList: StorageSize.list(params), title:"Your Personal Storage Solution"]
    }
}
