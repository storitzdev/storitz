package storitz

import com.storitz.SiteImage
import org.grails.plugins.imagetools.ImageTool

class ImageService {

  def fileUploadService

    boolean transactional = false

    def scaleImages(file, siteId, imgOrder, filePath, filePathMid, filePathThumb, storageSiteInstance) {
      def imageTool = new ImageTool()
      imageTool.load(file.canonicalPath)
      imageTool.saveOriginal()
      imageTool.thumbnailSpecial(600, 400, 2, 1)
      def dstFile = new File(fileUploadService.getFilePath('/images/site', '', siteId))
      dstFile.mkdirs()
      imageTool.writeResult(filePath, "JPEG")
      imageTool.restoreOriginal()
      imageTool.thumbnailSpecial (320, 240, 2, 1)
      imageTool.writeResult(filePathMid, "JPEG")
      imageTool.restoreOriginal()
      imageTool.thumbnailSpecial (60, 40, 2, 2)
      imageTool.writeResult(filePathThumb, "JPEG")
      file.delete()
      def siteImg = new SiteImage()
      siteImg.isLogo = false
      siteImg.hasThumbnail = true
      siteImg.isCover = false
      siteImg.basename = '/images/site' + fileUploadService.getWebIdPath(siteId)
      siteImg.fileLocation = file.name
      siteImg.site = storageSiteInstance
      siteImg.imgOrder = ++imgOrder
      storageSiteInstance.addToImages(siteImg)


    }
}
