package storitz

import com.storitz.StorageSize

class HomeController {

    def index = {
      [ sizeList: StorageSize.list(params), title:"Click. Store. Done."]
    }
}
