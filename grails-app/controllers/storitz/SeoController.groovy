package storitz

import com.storitz.Metro
import com.storitz.MetroEntry
import com.storitz.SiteImage

class SeoController {

    def imageService
    def fileUploadService

    def state = {
      def searchState = storitz.constants.State.getEnumFromId(params.state)

      def metroList = Metro.findAllByState(searchState, [sort:"city", order:"asc"])
      def metroEntryList = MetroEntry.findAllByState(searchState, [sort:"city", order:"asc"]).unique (new MetroEntryComparator())

      [state:searchState, metroList:metroList, metroEntryList: metroEntryList]
    }

    def imageRename = {
      for(img in SiteImage.list()) {
        def ext = '.' + img.src().tokenize('.')[-1]
        def newName = "Storitz-${img.site.city}-${img.site.state.display}-${img.site.title}-self storage units-${img.imgOrder}${ext}"
        if (!img.isLogo) {
          println "Source: ${request.getRealPath(img.src())} Destination: ${img.basename + newName}"
          def file = new File(request.getRealPath(img.src()))
          file.renameTo(new File(request.getRealPath(img.basename + newName)))
          println "Source mid: ${request.getRealPath(img.midOld())} Destination: ${img.basename + 'mid-' + newName}"
          file = new File(request.getRealPath(img.midOld()))
          file.renameTo(new File(request.getRealPath(img.basename + 'mid-' + newName)))
          println "Source thumbnail: ${request.getRealPath(img.thumbnailOld())} Destination: ${img.basename + 'thumb-'  + newName}"
          file = new File(request.getRealPath(img.thumbnailOld()))
          file.renameTo(new File(request.getRealPath(img.basename + 'thumb-' + newName)))
          img.fileLocation = newName
        } else {
          println "Source: ${request.getRealPath(img.src())} Destination: ${img.basename + 'logo-' + newName}"
          def file = new File(request.getRealPath(img.src()))
          file.renameTo(new File(request.getRealPath(img.basename + 'logo-' + newName)))
          img.fileLocation = 'logo-' + newName
        }
        img.save(flush:true)
      }
    }

    def imageRescale = {
      for(img in SiteImage.list()) {
        if (!img.isLogo) {
          def file = new File(request.getRealPath(img.basename + img.fileLocation))

          if (file.exists() && file.length() > 0) {
            def tempFile = File.createTempFile("imageRescale", ".tmp")
            org.apache.commons.io.FileUtils.copyFile(file, tempFile)

            def filePath = fileUploadService.getFilePath('/images/site', img.fileLocation, img.site.id)
            def filePathMid = fileUploadService.getFilePath('/images/site', 'mid-' + img.fileLocation, img.site.id)
            def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb-' + img.fileLocation, img.site.id)

            imageService.scaleExistingImages(tempFile, img.site.id, filePath, filePathMid, filePathThumb)
          }
        }
      }
    }
}
