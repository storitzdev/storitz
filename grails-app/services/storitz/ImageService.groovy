package storitz

import com.storitz.SiteImage
import org.grails.plugins.imagetools.ImageTool
import com.storitz.StorageSite
import com.storitz.Feed
import org.springframework.web.multipart.commons.CommonsMultipartFile

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
    siteImg.isCover = imgOrder == 0
    siteImg.basename = '/images/site' + fileUploadService.getWebIdPath(siteId)
    siteImg.fileLocation = file.name
    siteImg.site = storageSiteInstance
    siteImg.imgOrder = ++imgOrder
    storageSiteInstance.addToImages(siteImg)


  }

  def deleteImage(StorageSite site, SiteImage siteImage) {
    def deleteList = [ fileUploadService.getFilePath('/images/site', siteImage.fileLocation, site.id), fileUploadService.getFilePath('/images/site', 'mid-' + siteImage.fileLocation, site.id), fileUploadService.getFilePath('/images/site', 'thumb-' + siteImage.fileLocation, site.id) ]

    deleteList.each{
      def file = new File(it)
      println "Delete image ${it}"
      file.delete()
    }

    site.removeFromImages(siteImage)
    siteImage.delete()
    site.save(flush: true)

  }

  def feedLogo(org.springframework.web.multipart.commons.CommonsMultipartFile logoFile, Long feedId) {
    Feed feed = Feed.get(feedId)

    def random = new Random()
    def srcFile
    def fileLocation = 'logo_' + random.nextInt(100000) + '.jpg'
    def ext = '.' + logoFile.originalFilename.tokenize('.')[-1]

    if (logoFile.size > 0 && fileUploadService.moveFile(logoFile, '/images/upload', 'tmp_' + fileLocation, feedId)) {
      def filePath = fileUploadService.getFilePath('/images/upload', fileLocation, feedId)
      def tmpPath = fileUploadService.getFilePath('/images/upload', 'tmp_' + fileLocation, feedId)
      def dstFile = new File(fileUploadService.getFilePath('/images/upload', '', feedId))
      dstFile.mkdirs()
      def imageTool = new ImageTool()
      imageTool.load(tmpPath)
      srcFile = new File(filePath)
      if (imageTool.getWidth() != 250 && imageTool.getHeight() != 100) {
        imageTool.thumbnailSpecial(250, 100, 3, 1)
        imageTool.writeResult(filePath, "JPEG")
      } else {
        org.apache.commons.io.FileUtils.copyFile(new File(tmpPath), srcFile)
      }

      def tmpFile = new File(tmpPath)

      for (site in feed.sites) {
        if (site.logo == null) {
          site.logo = new SiteImage()
        }

        def newName = "logo-Storitz-${site.city}-${site.state.display}-${site.title}-self storage units-0${ext}"
        site.logo.isLogo = true
        site.logo.hasThumbnail = false
        site.logo.isCover = false
        site.logo.basename = '/images/site' + fileUploadService.getWebIdPath(site.id)
        site.logo.fileLocation = newName
        site.logo.site = site
        site.logo.imgOrder = 0;
        def targetDir = new File(site.logo.basename)
        targetDir.mkdirs()
        println "Copying logo for site ${site.title} - ${srcFile} to ${fileUploadService.getAbsolutePath(site.logo.basename,site.logo.fileLocation)}"
        org.apache.commons.io.FileUtils.copyFile(srcFile, new File(fileUploadService.getAbsolutePath(site.logo.basename, site.logo.fileLocation)))
      }
      if (srcFile) {
        srcFile.delete()
      }
      if (tmpFile) {
        tmpFile.delete()
      }
    }
  }
}
