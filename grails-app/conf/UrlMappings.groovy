class UrlMappings {
  static mappings = {

    "500"(view: '/error')
    "404"(view: '/notfound')
    "/help"(view: '/help')

    name state: "/self-storage/state/$state" {
      controller = "seo"
      action = "redirectState"
    }

    name state2: "/$state-self-storage" {
      controller = "seo"
      action = "state"
      constraints {
        state(matches: /[A-Z]{2}/)
      }
    }

    name siteLink: "/self-storage/$city/$state/$site_title/$id" {
      controller = "storageSite"
      action = "redirectSiteLink"
    }

    name siteLink2: "/self-storage-$site_title/$id" {
      controller = "storageSite"
      action = "detail"
    }

    name geo: "/self-storage/$city/$state/$zip" {
      controller = "home"
      action = "redirectGeo"
    }

    name geo2: "/$city-$state-zip-code-$zip-self-storage" {
      controller = "home"
      action = "index"
      zipSearch = true
      constraints {
        zip(matches: /\d{5}/)
        state(matches: /[A-Z]{2}/)
      }
    }

    name metro: "/self-storage/metro/$city/$state" {
      controller = "home"
      action = "redirectMetro"
    }

    name metro2: "/$city-$state-self-storage" {
      controller = "home"
      action = "index"
      constraints {
        city(validator: { return (it != 'state' && !(it ==~ /\d{5}-.+/))})
        state(matches: /[A-Z]{2}/)
      }
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
      constraints {
        date(validator: { return !(it ==~ /\d/)})
        title(validator: { return !(it ==~ /\d/)})
      }
    }

    "/sitemap"(controller: "siteMap")

    "/sitemapGeo"(controller: "siteMap", action: "geo")

    "/sitemapImages"(controller: "siteMap", action: "image")

    "/sitemapUrls"(controller: "siteMap", action: "url")

    "/sitemapCollege"(controller: "siteMap", action: "college")

    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }

    "/zzz"(controller: "home", action: "index")

    "/"(controller: "home", action: "index")

    "/college/$college"(controller: "home", action: "college")

    "/organizer"(controller: "organizerContest", action: "create")

  }
}
