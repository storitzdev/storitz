class UrlMappings {
    static mappings = {
//      "/self-storage/$city/$site_title/$id?" {
//         controller = "storagesite"
//         action = "detail"
//         constraints {
//           site_title(validator: { true })
//         }
//      }

      // Land on homepage searching for an address which may be "city, state" or "zip"
      "/find/self-storage/$city/$state?" {
         controller = "home"
         action = "index"

         address = { params.state ? (params.city + ', ' + params.state) : params.city }
//         address = { println ([params.city, params.state]) ; params.state ? (params.city + ', ' + params.state) : params.city }
      }

// Don't really need to use constraints to sort out city vs zip.
// Let search logic on home page deal with it.
//      "/self-storage/$address" {
//         controller = "home"
//         action = "index"
//
//         constraints {
//           address(matches : /\d+/)
//         }
//      }

      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      "/"(controller:"home", action:"index")
	  "500"(view:'/error')
	}
}
