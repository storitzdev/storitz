package storitz

import com.storitz.StorageSize

class HomeController {

    def index = {
      [ sizeList: StorageSize.list(params), title:"Storitz online self storage rental. Click. Store. Done."]
    }
}
