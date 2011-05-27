package com.storitz

class Video {

  static constraints = {
    caption(size: 2..10000)
    tags(nullable: true, size: 1..512)
    site(nullable: true)
    useYouTube(nullable: true)
    youTubeId(nullable: true)
    fileLocation(nullable: true, validator: { fileLoc, vid ->
        return fileLoc || vid.useYouTube
    })
    stillImage(nullable: true)
  }

  Date releaseDate
  String title
  String caption
  String tags
  StorageSite site
  String fileLocation
  Boolean useYouTube
  String youTubeId
  String stillImage
}

/*
Note: alter table video modify column file_location varchar(255) null
 */
