package storitz

import com.storitz.Feed
import com.storitz.SiteImage
import com.storitz.StorageSite
import org.apache.commons.io.FileUtils
import org.apache.sanselan.SanselanConstants
import org.apache.sanselan.common.byteSources.ByteSource
import org.apache.sanselan.common.byteSources.ByteSourceFile
import org.apache.sanselan.formats.jpeg.JpegImageParser
import org.apache.sanselan.formats.jpeg.JpegPhotoshopMetadata
import org.apache.sanselan.formats.jpeg.iptc.IPTCConstants
import org.apache.sanselan.formats.jpeg.iptc.IPTCRecord
import org.apache.sanselan.formats.jpeg.iptc.JpegIptcRewriter
import org.apache.sanselan.formats.jpeg.iptc.PhotoshopApp13Data
import org.grails.plugins.imagetools.ImageTool

class ImageService {

  def fileUploadService = new FileUploadService()

  boolean transactional = false

  def scaleImages(file, siteId, imgOrder, filePath, filePathMid, filePathThumb, storageSiteInstance) {
    if (!file.exists()) {
      return
    }
    scaleExistingImages(file, siteId, filePath, filePathMid, filePathThumb)
    def siteImg = new SiteImage()
    siteImg.isLogo = false
    siteImg.hasThumbnail = true
    siteImg.isCover = imgOrder == 0
    siteImg.basename = '/images/site' + fileUploadService.getWebIdPath(siteId)
    siteImg.fileLocation = file.name
    siteImg.site = storageSiteInstance
    siteImg.imgOrder = imgOrder
    storageSiteInstance.addToImages(siteImg)
  }

  def scaleExistingImages(file, siteId, filePath, filePathMid, filePathThumb) {
    if (!file.exists()) {
      return
    }
    def imageTool = new ImageTool()
    imageTool.load(file.canonicalPath)
    imageTool.saveOriginal()
    imageTool.thumbnailSpecial(600, 400, 2, 1)
    def dstFile = new File(fileUploadService.getFilePath('/images/site', '', siteId))
    dstFile.mkdirs()
    imageTool.writeResult(filePath, "JPEG")
    imageTool.restoreOriginal()
    imageTool.thumbnailSpecial(320, 240, 2, 1)
    imageTool.writeResult(filePathMid, "JPEG")
    imageTool.restoreOriginal()
    imageTool.thumbnailSpecial(60, 40, 2, 2)
    imageTool.writeResult(filePathThumb, "JPEG")
    file.delete()
  }

  def deleteImage(StorageSite site, SiteImage siteImage) {
    def deleteList = [fileUploadService.getFilePath('/images/site', siteImage.fileLocation, site.id), fileUploadService.getFilePath('/images/site', 'mid-' + siteImage.fileLocation, site.id), fileUploadService.getFilePath('/images/site', 'thumb-' + siteImage.fileLocation, site.id)]

    deleteList.each {
      def file = new File(it)
      log.info "Delete image ${it}"
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
        log.info "Copying logo for site ${site.title} - ${srcFile} to ${fileUploadService.getAbsolutePath(site.logo.basename, site.logo.fileLocation)}"
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

  def iptcTagImage(imageFile, site, imgOrder, imgType) {

    if (imageFile.exists()) {
      ByteSource byteSource = new ByteSourceFile(imageFile);
      Map params = new HashMap();
      params.put(SanselanConstants.PARAM_KEY_READ_THUMBNAILS, Boolean.TRUE);
      JpegPhotoshopMetadata metadata
      try {
        metadata = new JpegImageParser().getPhotoshopMetadata(byteSource, params);
      } catch (Exception E) {
        log.info "This file ${imageFile.canonicalPath} is not a JPEG"
        return
      }
      List newBlocks = new ArrayList()
      List newRecords = new ArrayList()

      newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_CAPTION_ABSTRACT, "Find, compare and rent self storage units and mini storage near you.  Storitz guarantees that you will get the best deal.  It's the smartest way to shop for self storage anywhere in the U.S. http://storitz.com"))
      newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_WRITER_EDITOR, "Storitz"))
      newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_BYLINE, "Storitz"))
      newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_CITY, "${site.city}, ${site.state.display}" as String))
      switch (imgType) {
        case 'LOGO':
          newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_OBJECT_NAME, "Logo for ${site.title}" as String))
          break

        case 'MID':
          newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_OBJECT_NAME, "Storitz ${site.title} mid size image ${imgOrder}" as String))
          break

        case 'THUMB':
          newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_OBJECT_NAME, "Storitz ${site.title} thumbnail image ${imgOrder}" as String))
          break

        case 'FULL':
          newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_OBJECT_NAME, "Storitz ${site.title} image ${imgOrder}" as String))
          break
      }
      newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_KEYWORDS, "${site.city}, ${site.state.display} Self Storage Storage unit self storage units storage units moving storage units for rent cheap storage units storage unit rental self storage self storage facility self storage facilities air conditioned storage units self storage rental public self storage security self storage find selfstorage self storage companies Mini storage mini self storage" as String))
      newRecords.add(new IPTCRecord(IPTCConstants.IPTC_TYPE_COPYRIGHT_NOTICE, "Storitz"))

      if (metadata) {
        boolean keepOldIptcNonTextValues = true;
        if (keepOldIptcNonTextValues) {
          newBlocks.addAll(metadata.photoshopApp13Data.getNonIptcBlocks());
        }
        boolean keepOldIptcTextValues = true;
        if (keepOldIptcTextValues) {
          List oldRecords = metadata.photoshopApp13Data.getRecords();

          for (int j = 0; j < oldRecords.size(); j++) {
            IPTCRecord record = (IPTCRecord) oldRecords.get(j);
            if (record.iptcType.type != IPTCConstants.IPTC_TYPE_CITY.type
                    && record.iptcType.type != IPTCConstants.IPTC_TYPE_CAPTION_ABSTRACT.type && record.iptcType.type != IPTCConstants.IPTC_TYPE_WRITER_EDITOR.type
                    && record.iptcType.type != IPTCConstants.IPTC_TYPE_BYLINE.type && record.iptcType.type != IPTCConstants.IPTC_TYPE_OBJECT_NAME.type
                    && record.iptcType.type != IPTCConstants.IPTC_TYPE_KEYWORDS.type && record.iptcType.type != IPTCConstants.IPTC_TYPE_COPYRIGHT_NOTICE.type)
              newRecords.add(record);
          }
        }
      }
      PhotoshopApp13Data newData = new PhotoshopApp13Data(newRecords, newBlocks);

      File updated = File.createTempFile(imageFile.getName() + ".iptc.update.", ".jpg");
      OutputStream os = null;
      try {
        os = new FileOutputStream(updated);
        os = new BufferedOutputStream(os);
        new JpegIptcRewriter().writeIPTC(byteSource, os, newData);
      } finally {
        os.close();
        os = null;
      }
      imageFile.delete()
      FileUtils.copyFile(updated, imageFile)
      updated.delete()
    }
  }
}
