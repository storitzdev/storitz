package com.storitz

class Video {

    static constraints = {
      caption(size:2..4000)
      tags(nullable:true, size: 1..512)
      site(nullable:true)
      stillImage(nullable:true)
    }

    Date releaseDate
    String title
    String caption
    String tags
    StorageSite site
    String fileLocation
    String stillImage
}
