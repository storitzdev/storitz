package storitz

import grails.plugins.springsecurity.Secured
import com.storitz.StorageSite
import com.storitz.SiteImage
import org.codehaus.groovy.grails.commons.ConfigurationHolder

import com.google.gdata.client.*
import com.google.gdata.client.photos.*
import com.google.gdata.data.*
import com.google.gdata.data.media.*
import com.google.gdata.data.photos.*
import com.google.gdata.util.ServiceException
import com.google.gdata.data.media.mediarss.MediaKeywords


class ImageController {
    def message

    @Secured(['ROLE_ADMIN'])
    def index = {
        redirect(action: "export", params: params, message: message)
    }

    @Secured(['ROLE_ADMIN'])
    def export = {
        message = ""
        if (params.imageServer) {
            def success = uploadImages(params.imageServer)
            if (success) {
                return [status: "Successfully uploaded images to ${params.imageServer}", message: message]
            }
            return [status: "Error uploading images to ${params.imageServer}", message: message]
        }
         return [status: "Select a service below", message: message]
    }

    /////////////////////////////////////////
    // PICASA ///////////////////////////////
    /////////////////////////////////////////

    def picasaUserName = "socialmedia@storitz.com"
    def picasaPassWord = "clickstoredone"
    def picasaFeedURL  = "https://picasaweb.google.com/data/feed/api/user/${picasaUserName}"
    def picasaRetryCount = 20 // number of times to retry inserting an image before giving up
    def maxAlbums = 0         // max number of albums to upload. Set to 0 for all albums

    def getPicasaWebService() {
        PicasawebService myService = new PicasawebService("Storitz")
        myService.setUserCredentials(picasaUserName, picasaPassWord)
        myService.setChunkedMediaUpload(1024 * 1024)
        return myService
    }

    def getPicasaAlbums(myService) {
        URL feedUrl = new URL("${picasaFeedURL}?kind=album")
        UserFeed myUserFeed = myService.getFeed(feedUrl, UserFeed.class)
        def albums = [:]
        for (AlbumEntry myAlbum : myUserFeed.getAlbumEntries()) {
            albums[myAlbum.getTitle().getPlainText()] = myAlbum
        }
        return albums
    }

    def deletePicasaAlbums(myService) {
        URL feedUrl = new URL("${picasaFeedURL}?kind=album")
        UserFeed myUserFeed = myService.getFeed(feedUrl, UserFeed.class)
        for (AlbumEntry myAlbum : myUserFeed.getAlbumEntries()) {
            myAlbum.delete()
        }
    }


    def getPicasaPhotosForAlbum (myAlbum) {
        AlbumFeed feed = myAlbum.getFeed(PhotoData.KIND);
        def allPhotos = [:]
        for(PhotoEntry photo : feed.getPhotoEntries()) {
            allPhotos[photo.getTitle().getPlainText()] = photo
        }
        return allPhotos
    }

    def addPicasaAlbum(myService,albumName,albumDescription) {
        AlbumEntry myAlbum = new AlbumEntry()
        myAlbum.setTitle(new PlainTextConstruct(albumName))
        myAlbum.setDescription(new PlainTextConstruct(albumDescription))
        myAlbum.setAccess("public")
        URL url = new URL(picasaFeedURL)
        AlbumEntry insertedEntry = myService.insert(url, myAlbum)
        return insertedEntry
    }

    def getPicasaAlbumId (myAlbum) {
        def albumURL = myAlbum.htmlLink.href.toString()
        def albumIdMatch = albumURL =~ /https:\/\/picasaweb.google.com\/[0-9]+\/(.*)\?authkey=.*/
        if (albumIdMatch.getCount()) {
            return albumIdMatch[0][1]
        }

        def albumIdMatch2 = albumURL =~ /https:\/\/picasaweb.google.com\/[0-9]+\/(.*)/
        if (albumIdMatch2.getCount()) {
            return albumIdMatch2[0][1]
        }

        return null
    }

    def getPicasaPhotoId (myPhoto) {
        def photoURL = myPhoto.htmlLink.href.toString()
        def photoIdmatch = photoURL =~ /https:\/\/picasaweb.google.com\/[0-9]+\/(.*)\?authkey=.*/
        if (photoIdmatch.getCount()) {
            return photoIdmatch[0][1]
        }
        return null
    }


    boolean uploadImagesToPicasa() {
        def myService =  getPicasaWebService()
        // testing only
        //deletePicasaAlbums(myService)
        def myAlbums = getPicasaAlbums (myService)
        def myImages = collectAllImages()
        return uploadImagesToPicasaActual(myService, myAlbums, myImages)
    }

    boolean uploadImagesToPicasaActual(myService, myAlbums, myImages) {
        StringBuffer bigOlBuf = new StringBuffer(10240)
        Iterator i = myImages.iterator()
        def imageCount = myImages.size()
        def oldSiteName = "old"
        def newSite = ""
        def siteCount = 0
        def updatedSiteCount = 0
        def updatedImageCount = 0
        while (i.hasNext()) {
            Map<String,String> imageMap = i.next()

            // count the sites
            def newSiteName = imageMap.get('site')
            def newSiteDescription = imageMap.get('description')
            def currentAlbum = myAlbums[newSiteName];
            if (newSiteName != oldSiteName) {
                bigOlBuf.append("\nSITE: ${newSiteName}\n")

                // Create the site album if it does not already exist
                if (!currentAlbum) {
                    bigOlBuf.append("*** Album does not exist for site. Creating... ***\n")
                    currentAlbum = addPicasaAlbum(myService,newSiteName,newSiteDescription)
                    myAlbums[newSiteName] = currentAlbum
                    updatedSiteCount++
                }

                siteCount++
            }
            oldSiteName = newSiteName

            def myPhotos = getPicasaPhotosForAlbum (currentAlbum) ?: [:]
            PhotoEntry currentPhoto = myPhotos[imageMap.get('file')]

            // image is new. Add it.
            if (!currentPhoto) {
              try {
                    def albumId = getPicasaAlbumId (currentAlbum)
                    if (!albumId) {
                        def albumLink = currentAlbum.htmlLink.href.toString()
                        bigOlBuf.append("   !!! Could not determine album id from album ${albumLink}")
                        continue
                    }

                    PhotoEntry returnedPhoto = addPicasaPhoto (albumId, bigOlBuf, imageMap, myService, 0)
                    updatedImageCount++
                } catch (ServiceException e) {
                    def errmsg = e.toString().replaceAll("\n"," ")
                    bigOlBuf.append("   !!! ERROR: ${errmsg} !!!\n")
                }
           }

        }
        message = "Sites (processed/created): (${siteCount}/${updatedSiteCount})\nImages (processed/created): (${imageCount}/${updatedImageCount})\n" + bigOlBuf.toString()
        return true
    }

    def addPicasaPhoto(albumId, bigOlBuf, imageMap, myService, count) {
        def currentPhoto = new PhotoEntry()

        def photoFile = imageMap.get('file')
        def photoCaption = imageMap.get('caption')
        if (!photoCaption || photoCaption == 'null') {
            photoCaption = imageMap.get('file').replaceAll(".[Jj][Pp][Gg]","").replaceAll("-"," ")
        }
        currentPhoto.setTitle(new PlainTextConstruct(photoFile))
        currentPhoto.setDescription(new PlainTextConstruct(photoCaption))
        currentPhoto.setClient("Storitz");
        String imageTags = imageMap.get('tags')
        if (imageTags && imageTags != 'null') {
            MediaKeywords myTags = new MediaKeywords();
            String [] keyWords = imageTags.split(",")
            for (int i = 0; i < keyWords.length; i++) {
                myTags.addKeyword(keyWords[i]);
            }
            currentPhoto.setKeywords(myTags);
        }
        MediaFileSource myMedia = new MediaFileSource(new File(imageMap.get('image')), "image/jpeg");
        currentPhoto.setMediaSource(myMedia);

        try {
            PhotoEntry newPhotoEntry = myService.insert(new URL("${picasaFeedURL}/album/${albumId}"), currentPhoto);
            //bigOlBuf.append("IMAGE(${count}): ${imageMap.get('image')}, CAPTION: ${photoCaption}, TAGS: ${imageMap.get('tags')}\n")
            bigOlBuf.append("IMAGE(${count}): ${photoCaption}\n")
            return newPhotoEntry
        } catch (ServiceException e) {
            // Google servers get overloaded and throw annoying exceptions.
            // Keep trying until we get it right, or until we time out.
            if (count < picasaRetryCount) {
                 return addPicasaPhoto (albumId, bigOlBuf, imageMap, myService, count+1)
            }
            throw e
        }
        return null
    }

    /////////////////////////////////////////
    // FLICKR //////////////////////////////
    /////////////////////////////////////////

    boolean uploadImagesToFlickR() {
        return false
    }

    /////////////////////////////////////////
    // Photo Bucket /////////////////////////
    /////////////////////////////////////////

    boolean uploadImagesToPhotoBucket() {
        return false
    }

    /////////////////////////////////////////
    // FaceBook /////////////////////////////
    /////////////////////////////////////////

    boolean uploadImagesToFaceBook() {
        return false
    }

    /////////////////////////////////////////
    // General Methods //////////////////////
    /////////////////////////////////////////

    boolean uploadImages(imageServer) {
        if (imageServer == "Picasa") {
            return uploadImagesToPicasa()
        }
        if (imageServer == "FlickR") {
            return uploadImagesToFlickR()
        }
        if (imageServer == "PhotoBucket") {
            return uploadImagesToPhotoBucket()
        }
        if (imageServer == "FaceBook") {
            return uploadImagesToFaceBook()
        }
        return false
    }

    def dumpAlbums (myAlbums) {
        StringBuffer buf = new StringBuffer()
        for (HashMap.Entry<String,AlbumEntry> e: myAlbums) {
            buf.append("Album: ${e.key}")
        }
       return buf.toString()
    }

    //allImages type: ArrayList<Map<String,String>>
    def dumpImages (myImages) {
        StringBuffer bigOlBuf = new StringBuffer(10240)
        Iterator i = myImages.iterator()
        def imageCount = myImages.size()
        def oldSiteName = "old"
        def newSite = ""
        def siteCount = 0
        while (i.hasNext()) {
            Map<String,String> imageMap = i.next()

            // count the sites
            def newSiteName = imageMap.get('site')
            if (newSiteName != oldSiteName) {
                siteCount++
                bigOlBuf.append("\nSITE: ${newSiteName}\n")
            }
            oldSiteName = newSiteName

            bigOlBuf.append("IMAGE: ${imageMap.get('image')}, CAPTION: ${imageMap.get('caption')}, TAGS: ${imageMap.get('tags')}\n")
        }
        return "Number Sites: ${siteCount}\nNumber Images: ${imageCount}\n" + bigOlBuf.toString()
    }

     ArrayList<Map<String,String>> collectAllImages() {
        List retVal = new ArrayList<Map<String,String>>()
        String server = ConfigurationHolder.config.grails.serverRoot

        def allImages = StorageSite.findAll().collect { site -> site.images }
        Iterator i = allImages.iterator()
        def count = 0
        while (i.hasNext()) {
            if ((maxAlbums > 0) && (count++ >= maxAlbums)) {
                break
            }
            Set<SiteImage> imageSet = i.next()
            for (SiteImage image: imageSet) {
                String siteName = image.site.title
                String basename = image.getBasename()
                String fileloc = image.fileLocation

                // Fist time image tagging
                if (!image.tags || image.tags == "" || image.tags == "null") {
                    String siteCity = image.site.city
                    String siteTitle = image.site.title
                    String siteZip = image.site.zipcode
                    def newTags = "${siteCity} Self Storage, ${siteCity} Storage Units, ${siteCity} Mini Storage, ${siteTitle} Self Storage, ${siteTitle} Storage Units, ${siteTitle} Mini Storage, ${siteZip} Self Storage, ${siteZip} Storage Units, ${siteZip} Mini Storage"
                    image.tags = newTags
                    image.save()
                }


                if (fileloc.startsWith("logo-")) {
                    continue // no need to capture logo files
                }

                String caption = image.getCaption()
                String description = image.site.description?.replaceAll("<[^>]*>","")?.replaceAll("&nbsp;","")
                String tags = image.getTags()
                Map imageMap = new HashMap<String,String>()
                imageMap.put("site", "${siteName}")                              // albumName
                imageMap.put("image", "${server}${basename}${fileloc}")          // physical disk file location
                imageMap.put("caption", "${caption}")                            // album image description
                imageMap.put("file", "${fileloc}")                               // album image name
                imageMap.put("description", "${description}")                    // album description
                imageMap.put("tags", "${tags}")                                  // album tags
                retVal.push(imageMap)
             }
        }
        return retVal
    }
}
