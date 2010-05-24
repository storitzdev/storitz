import grails.converters.JSON

class StorageSiteController {

  def siteLinkService
  def geocodeService
  def fileUploadService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    println "Storage Site count = " + StorageSite.count()
    def results = StorageSite.list(params)
    [storageSiteInstanceList: StorageSite.list(params), storageSiteInstanceTotal: StorageSite.count()]
  }

  def create = {
    def storageSiteInstance = new StorageSite()
    storageSiteInstance.properties = params
    return [storageSiteInstance: storageSiteInstance]
  }

  def save = {
    def storageSiteInstance = new StorageSite(params)

    // TODO handle logo

    if (storageSiteInstance.save(flush: true)) {
      flash.message = "${message(code: 'default.created.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), storageSiteInstance.id])}"
      redirect(action: "show", id: storageSiteInstance.id)
    }
    else {
      render(view: "create", model: [storageSiteInstance: storageSiteInstance])
    }
  }

  def show = {
    def storageSiteInstance = StorageSite.get(params.id)
    if (!storageSiteInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), params.id])}"
      redirect(action: "list")
    }
    else {
      [storageSiteInstance: storageSiteInstance]
    }
  }

  def edit = {
    def storageSiteInstance = StorageSite.get(params.id)
    if (!storageSiteInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), params.id])}"
      redirect(action: "list")
    }
    else {
      return [storageSiteInstance: storageSiteInstance]
    }
  }

  def update = {
    println "Update params:" + params.inspect()
    
    def storageSiteInstance = StorageSite.get(params.id)
    if (storageSiteInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (storageSiteInstance.version > version) {

          storageSiteInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'storageSite.label', default: 'StorageSite')] as Object[], "Another user has updated this StorageSite while you were editing")
          render(view: "edit", model: [storageSiteInstance: storageSiteInstance])
          return
        }
      }
      // TODO handle logo image file
      def logoFile = request.getFile('logoFile')
      Integer siteId = Integer.parseInt(params.id)
      def fileLocation = 'logo_' + params.id + '.jpg'
      if (logoFile.size > 0 && fileUploadService.moveFile(logoFile, '/images/upload', fileLocation, siteId)) {
        def tmpPath = fileUploadService.getFilePath('/images/upload', fileLocation, siteId)
        def filePath = fileUploadService.getFilePath('/images/site', fileLocation, siteId)
        println "Saving image to tmpPath: " + tmpPath
        def imageTool = new ImageTool()
        imageTool.load(tmpPath)
        imageTool.thumbnail(120)
        def dstFile = new File(fileUploadService.getFilePath('/images/site', '', siteId))
        dstFile.mkdirs()
        imageTool.writeResult(filePath, "JPEG")
        def tmpFile = new File(tmpPath)
        tmpFile.delete()
        if (storageSiteInstance.logo == null) {
          storageSiteInstance.logo = new SiteImage()
        }
        storageSiteInstance.logo.isLogo = true
        storageSiteInstance.logo.hasThumbnail = false
        storageSiteInstance.logo.isCover = false
        storageSiteInstance.logo.basename = '/images/site' + fileUploadService.getWebIdPath(siteId)
        storageSiteInstance.logo.fileLocation = fileLocation
        storageSiteInstance.logo.site = storageSiteInstance
      }

      params.findAll{ it.key ==~ /imageFile_(\d)+/}.each{ img->
        def imgFile = request.getFile(img.key)
        if (imgFile.size > 0 && fileUploadService.moveFile(imgFile, '/images/upload', imgFile.originalFilename, siteId)) {
          println "Uploading image file:" + imgFile.originalFilename + " size: " + imgFile.size
          def tmpPath = fileUploadService.getFilePath('/images/upload', imgFile.originalFilename, siteId)
          def filePath = fileUploadService.getFilePath('/images/site', imgFile.originalFilename, siteId)
          def filePathMid = fileUploadService.getFilePath('/images/site', 'mid_' + imgFile.originalFilename, siteId)
          def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb_' + imgFile.originalFilename, siteId)
          println "Saving image to tmpPath: " + tmpPath
          def imageTool = new ImageTool()
          imageTool.load(tmpPath)
          imageTool.saveOriginal()
          imageTool.thumbnail(600)
          def dstFile = new File(fileUploadService.getFilePath('/images/site', '', siteId))
          dstFile.mkdirs()
          imageTool.writeResult(filePath, "JPEG")
          imageTool.restoreOriginal()
          imageTool.thumbnail (320)
          imageTool.writeResult(filePathMid, "JPEG")
          imageTool.restoreOriginal()
          imageTool.thumbnail (60)
          imageTool.writeResult(filePathThumb, "JPEG")
          def tmpFile = new File(tmpPath)
          tmpFile.delete()
          def siteImg = new SiteImage()
          siteImg.isLogo = false
          siteImg.hasThumbnail = true
          siteImg.isCover = false
          siteImg.basename = '/images/site' + fileUploadService.getWebIdPath(siteId)
          siteImg.fileLocation = imgFile.originalFilename
          siteImg.site = storageSiteInstance
          storageSiteInstance.addToImages(siteImg)          
        }
      }


      for(specialOffer in storageSiteInstance.specialOffers) {
        def offerString = "specialOffer_" + specialOffer.id
        println("offerString is ${offerString}, params.offerString = " + params.getAt(offerString))
        if (params.getAt(offerString)) {
          specialOffer.active = true;
        } else {
          specialOffer.active = false;
        }
        specialOffer.save();
      }
      storageSiteInstance.properties = params
      if (!storageSiteInstance.hasErrors() && storageSiteInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), storageSiteInstance.id])}"
        redirect(action: "show", id: storageSiteInstance.id)
      }
      else {
        render(view: "edit", model: [storageSiteInstance: storageSiteInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), params.id])}"
      redirect(action: "list")
    }
  }

  def refresh = {
    def storageSiteInstance = StorageSite.get(params.id)

    if (storageSiteInstance.source == "SL") {
      def stats = new storagetech.SiteLinkStats()
      siteLinkService.updateSite(storageSiteInstance, stats, geocodeService)
      flash.message = "${message(code: 'default.refreshed.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), storageSiteInstance.id])}"
      redirect(action: "show", id: storageSiteInstance.id)
    }
  }

  def units = {
    def storageSiteInstance = StorageSite.get(params.id)

    if (storageSiteInstance.source == "SL") {
      def stats = new storagetech.SiteLinkStats()
      siteLinkService.updateUnits(storageSiteInstance, stats)
      flash.message = "${message(code: 'default.units.message', args: [stats.unitCount])}"
      redirect(action: "show", id: storageSiteInstance.id)
    }
  }

  def delete = {
    def storageSiteInstance = StorageSite.get(params.id)
    if (storageSiteInstance) {
      try {
        storageSiteInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'StorageSite'), params.id])}"
      redirect(action: "list")
    }
  }

  def deleteImage = {
    def site = StorageSite.get(params.id)

    def siteImage = SiteImage.get(params.siteImageId)

    def deleteList = [ fileUploadService.getFilePath('/images/site', siteImage.fileLocation, site.id), fileUploadService.getFilePath('/images/site', 'mid_' + siteImage.fileLocation, site.id), fileUploadService.getFilePath('/images/site', 'thumb_' + siteImage.fileLocation, site.id) ]

    deleteList.each{
      def file = new File(it)
      file.delete()
    }

    site.removeFromImages(siteImage)

    siteImage.delete()

    site.save(flush: true)

    redirect(action: "edit", id: params.id)
  }

  def detail = {

    def site = StorageSite.get(params.id)

    def sizeList = site.units.collect { it.unitsize }.unique()
    sizeList.add(StorageSize.get(1))
    sizeList.sort { it.width * it.length }

    [sizeList: sizeList, site: site, title: site.title]
  }

  def detailUnits = {

    def site = StorageSite.get(params.id)

    if (!params.searchSize) {
      render(status: 200, contentType: "application/json", text: "{ \"units\": null }")
      return
    }

    def zeroPrice = new BigDecimal(0)
    def unitsizeId = Long.parseLong(params.searchSize)
    def intResult = site.units.findAll { it.price > zeroPrice && it.unitsize.id == unitsizeId && it.isInterior }.min { it.price } as StorageUnit[]
    def driveupResult = site.units.findAll { it.price > zeroPrice && it.unitsize.id == unitsizeId && it.isDriveup }.min { it.price } as StorageUnit[]
    def upperResult = site.units.findAll { it.price > zeroPrice && it.unitsize.id == unitsizeId && it.isUpper }.min { it.price } as StorageUnit[]
    def tempcontrolledResult = site.units.findAll { it.price > zeroPrice && it.unitsize.id == unitsizeId && it.isTempControlled }.min { it.price } as StorageUnit[]
    render(status: 200, contentType: "application/json", text: "{ \"units\": { \"interior\": ${intResult as JSON}, \"driveup\": ${driveupResult as JSON}, \"upper\": ${upperResult as JSON}, \"tempcontrolled\": ${tempcontrolledResult as JSON} } }")
  }

}
