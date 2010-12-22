class UrlMappings {
    static mappings = {

    "500"(view:'/error')
    "404"(view:'/notfound')
    "/help"(view:'/help')

     name siteLink: "/self-storage/$city/$state/$site_title/$id" {
        controller = "storageSite"
        action = "detail"
     }

     name geo: "/self-storage/$city/$state/$zip" {
       controller = "home"
       action = "index"
     }

     name state: "/self-storage/state/$state" {
       controller = "seo"
       action = "state"
     }

     name metro: "/self-storage/metro/$city/$state" {
       controller = "home"
       action = "index"
     }

     "/xxx/$id" {
        controller = "storageSite"
        action = "detail"
     }

      // Land on homepage searching for an address which may be "city, state" or "zip"
      "/find/self-storage/$city/$state?" {
         controller = "home"
         action = "index"

         address = { params.state ? (params.city + ', ' + params.state) : params.city }
//         address = { println ([params.city, params.state]) ; params.state ? (params.city + ', ' + params.state) : params.city }
      }

      name release: "/press-release/$date/$title/$id" {
        controller = "pressRelease"
        action = "release"
      }

      name video: "/video/$date/$title/$id" {
        controller = "video"
        action = "video"
      }

      "/sitemap" (controller:"siteMap")

      "/sitemapGeo" (controller:"siteMap", action:"geo")

      "/sitemapImages" (controller:"siteMap", action:"image")

      "/sitemapUrls" (controller:"siteMap", action:"url")

      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }

      "/zzz" (controller:"home", action:"index")

      "/" (controller:"home", action:"index")

	}
}
