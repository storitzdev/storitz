package storitz

import grails.converters.JSON
import grails.plugins.springsecurity.Secured
import java.text.NumberFormat
import javax.servlet.http.Cookie
import org.grails.plugins.imagetools.ImageTool
import storitz.constants.SearchType
import storitz.constants.UnitType
import com.storitz.*
import com.storitz.service.CostTotals
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

import com.storitz.yelp.Yelp
import com.storitz.yelp.YelpReview
import java.text.SimpleDateFormat

class StorageSiteController extends BaseTransactionController implements ApplicationContextAware {

  ApplicationContext applicationContext
  def authenticateService
  def feedService
  def geocodeService
  def fileUploadService
  def markupSanitizerService
  def costService
  def springSecurityService
  def imageService
  def mapService
  def offerFilterService

  static allowedMethods = [save: "POST", update: "POST", delete: "POST", addCaptionAndTag: "POST"]

  def index = {
    redirect(action: "list", params: params)
  }

  @Secured(['ROLE_USER'])
  def list = {
    def username = springSecurityService.principal.username
    def user = User.findByUsername(username as String)

    def results
    def count

    if (UserRole.userHasRole(user, 'ROLE_ADMIN')) {
      if (params.sitename) {
        def q = "%${params.sitename}%"
        def max = Math.min(params.max ? params.int('max') : 10, 100)
        def offset = params.offset ? params.int('offset') : 0
        count = StorageSite.countByTitleLike(q)
        results = StorageSite.findAllByTitleLike(q, [max: max, sort: "title", offset: offset])
      } else {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        results = StorageSite.listOrderByTitle(params)
        count = StorageSite.count()
      }
    } else {
      def max = Math.min(params.max ? params.int('max') : 10, 100)
      def offset = params.offset ? params.int('offset') : 0
      if (params.sitename) {
        results = SiteUser.findAllByUser(user).collect { it.site }.findAll { it.title =~ /${params.sitename}/ }.sort { it.title }
      } else {
        results = SiteUser.findAllByUser(user).collect { it.site }.sort { it.title }
      }
      count = results.size()
      results = results.subList(offset, offset + max < count ? offset + max : count)
    }
    return [storageSiteInstanceList: results, storageSiteInstanceTotal: count]
  }

  @Secured(['ROLE_USER', 'ROLE_MANAGER', 'ROLE_ADMIN'])
  def autocompleteSite = {

    def username = springSecurityService.principal.username
    def user = User.findByUsername(username as String)
    println "Username ${username} hasrole admin: ${UserRole.userHasRole(user, 'ROLE_ADMIN')}"
    params.sort = 'title'
    def results
    if (UserRole.userHasRole(user, 'ROLE_ADMIN')) {
      results = StorageSite.findAllByTitleIlike(params.term + '%', params).collect {it.title}
    } else {
      results = SiteUser.findAllByUser(user).collect { it.site }.findAll { it.title ==~ /(?i).*${params.term}.*/ }.collect {it.title}.sort()
    }
    render(status: 200, contentType: "application/json", text: results as JSON)
  }

  def create = {
    def storageSiteInstance = new StorageSite()
    storageSiteInstance.properties = params
    return [storageSiteInstance: storageSiteInstance]
  }

  def save = {
    def storageSiteInstance = new StorageSite(params)
    if (storageSiteInstance.description) {
      storageSiteInstance.description = storageSiteInstance.description.encodeAsSanitizedMarkup()
    }
    if (storageSiteInstance.save(flush: true)) {
      flash.message = "${message(code: 'default.created.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), storageSiteInstance.id])}"
      redirect(action: "show", id: storageSiteInstance.id)
    }
    else {
      render(view: "create", model: [storageSiteInstance: storageSiteInstance])
    }
  }

  def show = {
    def storageSiteInstance = StorageSite.get(params.id)
    if (!storageSiteInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), params.id])}"
      redirect(action: "list")
    }
    else {
      def visitCount = Visit.countBySite(storageSiteInstance)
      def contacts = SiteUser.findAllBySite(storageSiteInstance).collect { it.user }.sort { it.username }
      [storageSiteInstance: storageSiteInstance, visitCount: visitCount, contacts: contacts]
    }
  }

  def report = {
    def storageSiteInstance = StorageSite.get(params.id)
    if (!storageSiteInstance) {
      println "Failed to get site in report"
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), params.id])}"
      redirect(action: "list")
    }
    else {
      def visits = Visit.findAllBySite(storageSiteInstance)

      [storageSiteInstance: storageSiteInstance, visits: visits]
    }
  }

  @Secured(['ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGER'])
  def edit = {
    def storageSiteInstance = StorageSite.get(params.id)
    if (!storageSiteInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), params.id])}"
      redirect(action: "list")
    } else {
      def username = springSecurityService.principal.username
      def user = User.findByUsername(username as String)
      def rentalAgreementList
      if (!UserRole.userHasRole(user, 'ROLE_ADMIN')) {
        if (!SiteUser.findBySiteAndUser(storageSiteInstance, user)) {
          flash.message = "${message(code: 'default.no.permission.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), username])}"
          redirect(action: "list")
          return
        }
        rentalAgreementList = RentalAgreement.findAllByAgreementOwner(user)
      } else {
        rentalAgreementList = RentalAgreement.findAll()
      }
      def contacts = SiteUser.findAllBySite(storageSiteInstance).collect { it.user }.sort { it.username }
      [storageSiteInstance: storageSiteInstance, rentalAgreementList: rentalAgreementList, contacts: contacts]
    }
  }

  def update = {
    def storageSiteInstance = StorageSite.get(params.id)
    if (storageSiteInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (storageSiteInstance.version > version) {

          storageSiteInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'storageSite.label', default: 'com.storitz.StorageSite')] as Object[], "Another user has updated this com.storitz.StorageSite while you were editing")
          render(view: "edit", model: [storageSiteInstance: storageSiteInstance])
          return
        }
      }

      // FIXME? We're getting the string "null" (the "noSelection" g:select key) as the drop down list choice.
      // Perhaps the list should be populated differently.
      if (params.manager?.id && (params.manager.id != 'null')) {
        def manager = User.get(params.manager.id as Long)

        // JPW? Shouldn't this just consider the manager(s?) that is currently linked? 
        UserRole.getUsersByRoleName('ROLE_MANAGER').each {
          SiteUser.unlink(storageSiteInstance, it)
        }
        SiteUser.link(storageSiteInstance, manager)
      }

      if (params.rentalAgreement?.id && (params.rentalAgreement.id as Long) < 0) {
        storageSiteInstance.rentalAgreement = null
        params.remove('rentalAgreement.id')
      } else if (params.rentalAgreement?.id) {
        def rentalAgreement = RentalAgreement.get(params.rentalAgreement?.id)

        if (rentalAgreement) {
          storageSiteInstance.rentalAgreement = rentalAgreement
        } else {
          storageSiteInstance.rentalAgreement = null
        }
      }

      // clear all items
      for (item in storageSiteInstance.securityItems) {
        item.delete()
      }
      storageSiteInstance.securityItems.clear();

      for (item in storageSiteInstance.convenienceItems) {
        item.delete()
      }
      storageSiteInstance.convenienceItems.clear();

      for (item in storageSiteInstance.amenityItems) {
        item.delete()
      }
      storageSiteInstance.amenityItems.clear()

      for (param in params.keySet()) {
        if (param.startsWith('securityItem_')) {
          def bullet = new Bullet()
          bullet.bullet = params[param]
          storageSiteInstance.securityItems.add(bullet);
        } else if (param.startsWith('convenienceItem_')) {
          def bullet = new Bullet()
          bullet.bullet = params[param]
          storageSiteInstance.convenienceItems.add(bullet);
        } else if (param.startsWith('amenityItem_')) {
          def bullet = new Bullet()
          bullet.bullet = params[param]
          storageSiteInstance.amenityItems.add(bullet);
        } else if (param.startsWith('caption_')) {
          def imgId = param.substring(8);
          def siteImage = SiteImage.get(imgId as Long)
          if (siteImage) {
            siteImage.caption = params[param]
          }
        } else if (param.startsWith('tags_')) {
          def imgId = param.substring(5);
          def siteImage = SiteImage.get(imgId as Long)
          if (siteImage) {
            siteImage.tags = params[param]
          }
        }

      }

      // sanitize description
      storageSiteInstance.description = params.description.encodeAsSanitizedMarkup()
      params.remove('description')
      def logoFile = request.getFile('logoFile')
      Integer siteId = Integer.parseInt(params.id)
      def random = new Random()
      def ext
      def newName
      if (logoFile.size > 0) {
        ext = '.' + logoFile.originalFilename.tokenize('.')[-1]
        newName = "logo-Storitz-${storageSiteInstance.city}-${storageSiteInstance.state.display}-${storageSiteInstance.title}-self storage units-0${ext}"
      }
      if (logoFile.size > 0 && fileUploadService.moveFile(logoFile, '/images/upload', newName, siteId)) {
        def tmpPath = fileUploadService.getFilePath('/images/upload', newName, siteId)
        def filePath = fileUploadService.getFilePath('/images/site', newName, siteId)
        def imageTool = new ImageTool()
        imageTool.load(tmpPath)
        def dstFile = new File(fileUploadService.getFilePath('/images/site', '', siteId))
        dstFile.mkdirs()
        if (imageTool.getWidth() != 250 || imageTool.getHeight() != 100) {
          imageTool.thumbnailSpecial(250, 100, 3, 1)
          imageTool.writeResult(filePath, "JPEG")
        } else {
          org.apache.commons.io.FileUtils.copyFile(new File(tmpPath), new File(filePath))
        }
        def tmpFile = new File(tmpPath)
        tmpFile.delete()
        imageService.iptcTagImage(new File(filePath), storageSiteInstance, 0, 'LOGO')
        if (storageSiteInstance.logo == null) {
          storageSiteInstance.logo = new SiteImage()
        }
        storageSiteInstance.logo.isLogo = true
        storageSiteInstance.logo.hasThumbnail = false
        storageSiteInstance.logo.isCover = false
        storageSiteInstance.logo.basename = '/images/site' + fileUploadService.getWebIdPath(siteId)
        storageSiteInstance.logo.fileLocation = newName
        storageSiteInstance.logo.site = storageSiteInstance
        storageSiteInstance.logo.imgOrder = 0;
      }

      def imgOrder = storageSiteInstance.images.collect { it.imgOrder }.max()
      if (!imgOrder) {
        imgOrder = 0;
      } else {
        imgOrder++
      }

      params.findAll { it.key ==~ /imageFile_(\d)+/}.each { img ->
        def imgFile = request.getFile(img.key)

        if (imgFile.size > 0 && imgFile.originalFilename.endsWith('zip')) {
          def tmpDir = File.createTempFile("imgzip", "dir")
          tmpDir.delete()
          tmpDir.mkdir()
          fileUploadService.moveFile(imgFile, '/images/upload', imgFile.originalFilename.encodeAsURL(), siteId)
          def tmpPath = fileUploadService.getFilePath('/images/upload', imgFile.originalFilename.encodeAsURL(), siteId)
          def ant = new AntBuilder();
          ant.unzip(src: tmpPath, dest: tmpDir, overwrite: "true") { mapper(type: "flatten")};
          println("unzipped into temp dir: ${tmpDir.canonicalPath}")
          tmpDir.eachFileMatch ~/(?i).*\.(png|jpg|gif|jpeg)/, { File file ->
            println "Processing file ${file.canonicalFile}"
            ext = '.' + file.canonicalFile.tokenize('.')[-1]
            newName = "Storitz-${storageSiteInstance.city}-${storageSiteInstance.state.display}-${storageSiteInstance.title}-self storage units-${imgOrder}${ext}"
            file.renameTo(new File(newName))
            def filePath = fileUploadService.getFilePath('/images/site', newName, siteId)
            def filePathMid = fileUploadService.getFilePath('/images/site', 'mid-' + newName, siteId)
            def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb-' + newName, siteId)
            imageService.scaleImages(file, siteId, imgOrder, filePath, filePathMid, filePathThumb, storageSiteInstance)
            imageService.iptcTagImage(new File(filePath), storageSiteInstance, imgOrder, 'FULL')
            imageService.iptcTagImage(new File(filePathMid), storageSiteInstance, imgOrder, 'MID')
            imageService.iptcTagImage(new File(filePathThumb), storageSiteInstance, imgOrder, 'THUMB')
            ++imgOrder
          }
          tmpDir.deleteDir()
        } else {
          if (imgFile.size > 0) {
            ext = '.' + imgFile.originalFilename.tokenize('.')[-1]
            newName = "Storitz-${storageSiteInstance.city}-${storageSiteInstance.state.display}-${storageSiteInstance.title}-self-storage-units-${imgOrder}${ext}"
          }
          if (imgFile.size > 0 && fileUploadService.moveFile(imgFile, '/images/upload', newName, siteId)) {
            def tmpPath = fileUploadService.getFilePath('/images/upload', newName, siteId)
            def filePath = fileUploadService.getFilePath('/images/site', newName, siteId)
            def filePathMid = fileUploadService.getFilePath('/images/site', 'mid-' + newName, siteId)
            def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb-' + newName, siteId)
            imageService.scaleImages(new File(tmpPath), siteId, imgOrder, filePath, filePathMid, filePathThumb, storageSiteInstance)
            imageService.iptcTagImage(new File(filePath), storageSiteInstance, imgOrder, 'FULL')
            imageService.iptcTagImage(new File(filePathMid), storageSiteInstance, imgOrder, 'MID')
            imageService.iptcTagImage(new File(filePathThumb), storageSiteInstance, imgOrder, 'THUMB')
            ++imgOrder
          }
        }
      }


      for (specialOffer in storageSiteInstance.specialOffers) {
        def offerString = "specialOffer_" + specialOffer.id
        def featuredOfferString = "featuredOffer_" + specialOffer.id
        def waiveAdminString = "waiveAdmin_" + specialOffer.id
        def promoNameString = "promoName_" + specialOffer.id
        def promoDescString = "promoDesc_" + specialOffer.id
        def offerTagsString = "offerTags_" + specialOffer.id

        if (params.getAt(offerString)) {
          specialOffer.active = true
        } else {
          specialOffer.active = false
        }

        if (params.getAt(featuredOfferString)) {
          specialOffer.featured = true
        } else {
          specialOffer.featured = false
        }

        if (params.getAt(waiveAdminString)) {
          specialOffer.waiveAdmin = true
        } else {
          specialOffer.waiveAdmin = false
        }

        if (params.getAt(promoNameString)) {
          specialOffer.promoName = params.getAt(promoNameString)
        }
        if (params.getAt(promoDescString)) {
          specialOffer.description = params.getAt(promoDescString)
        }
        specialOffer.tags.clear()
        if (params.getAt(offerTagsString)) {
            for (tagString in params.getAt(offerTagsString).split()) {
              def newTag = SpecialOfferTag.findByTag(tagString)
              if (!newTag) {
                newTag = new SpecialOfferTag()
                newTag.tag = tagString
                newTag.save(flush:true)
              }
              specialOffer.addToTags(newTag)
            }
        }
        specialOffer.save(flush:true)
      }
      for (ins in storageSiteInstance.insurances) {
        def insString = "insurance_" + ins.id
        if (params.getAt(insString)) {
          ins.active = true
        } else {
          ins.active = false
        }
        ins.save()
      }
      storageSiteInstance.properties = params
      storageSiteInstance.lastChange = new Date()
      if (storageSiteInstance.validate() && !storageSiteInstance.hasErrors() && storageSiteInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), storageSiteInstance.id])}"
        redirect(action: "show", id: storageSiteInstance.id)
      }
      else {
        render(view: "edit", model: [storageSiteInstance: storageSiteInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), params.id])}"
      redirect(action: "list")
    }
  }

  def refresh = {
    def storageSiteInstance = StorageSite.get(params.id)

    def writer = new PrintWriter(System.out)
    def stats = new storitz.SiteStats()
    feedService.updateSite(storageSiteInstance, stats, writer)
    flash.message = "${message(code: 'default.refreshed.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), storageSiteInstance.id])}"
    redirect(action: "show", id: storageSiteInstance.id)
  }

  def units = {
    def storageSiteInstance = StorageSite.get(params.id)

    def writer = new PrintWriter(System.out)
    def stats = new storitz.SiteStats()
    feedService.updateUnits(storageSiteInstance, stats, writer)
    flash.message = "${message(code: 'default.units.message', args: [stats.unitCount, stats.removedCount])}"
    writer.flush()
    redirect(action: "show", id: storageSiteInstance.id)
  }

  def delete = {
    def storageSiteInstance = StorageSite.get(params.id)
    if (storageSiteInstance) {
      try {
        SiteUser.removeAll(storageSiteInstance)
        storageSiteInstance.delete(flush: true)
        // delete all siteUser
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'storageSite.label', default: 'com.storitz.StorageSite'), params.id])}"
      redirect(action: "list")
    }
  }

  def deleteImage = {
    def site = StorageSite.get(params.id)
    def siteImage = SiteImage.get(params.siteImageId)
    imageService.deleteImage(site, siteImage)
    render(status: 200, contentType: "application/json", text: "{ \"siteImage\": ${params.siteImageId} }")
  }

  def removeContact = {
    def site = StorageSite.get(params.id)
    def user = User.get(params.userId)

    if (site && user) {
      SiteUser.unlink(site, user)
      render(status: 200, contentType: "application/json", text: "{ \"userId\": ${params.userId} }")
    }
  }

  def addContact = {
    def site = StorageSite.get(params.id)
    def user = User.findByEmail(params.email)

    if (site && user && !SiteUser.findBySiteAndUser(site, user)) {
      SiteUser.link(site, user)
      render(status: 200, contentType: "application/json", text: "{ \"userId\": ${user.id}, \"username\":\"${user.username}\", \"email\":\"${user.email}\", \"notificationTypes\":\"${User.showNotificationTypes(user)}\" }")
      return
    }
    render(status: 200, contentType: "application/json", text: "{ \"userId\": -1 }")
  }

  def defaultImage = {
    def site = StorageSite.get(params.id)
    def imgId = params.siteImageId as Long

    site.images.each {
      it.isCover = it.id == imgId
    }
    site.save(flush: true)
    render(status: 200, contentType: "application/json", text: "{ \"siteImage\": ${params.siteImageId} }")
  }

  def detail = {

    def rentalTransactionInstance
    if (params.rentalTransactionId) {
      rentalTransactionInstance = RentalTransaction.get(params.rentalTransactionId as Long)
    }
    StorageSite site = StorageSite.findById(params.id as Long)

    if (site == null) {
        StorageSite temp = StorageSite.findByTitleLike("%" + params.site_title.replaceAll("-","%") + "%")
        if (temp != null) {
            params.id = temp.id
//            TODO: figure out how to use this stupid stuff so we can use the named UrlMapping 'siteLink2'
//            def urlMappings = applicationContext.getBean("grailsUrlMappingsHolder")
//            UrlCreator mapping = urlMappings.getReverseMapping("StorageSite","detail",params)
//            def url = mapping.createURL(params, request.characterEncoding)
            def  url =  "${ConfigurationHolder.config.grails.serverURL}/self-storage-${params.site_title}/${params.id}"  //?promoId=${params.promoId}
            if (params.promoId) {
                url += "?promoId=${params.promoId}"
            }
            response.setHeader("Location", url)
            render(status:301) // short-circuits view rendering, otherwise grails will try to render details.gsp
            return false;
        }
        else { //else issue 404
            response.sendError(404);
        }
    }

    if (site.disabled && !params.adminView) {   //if site is disabled and you are not in adminview, redirect
      redirect(controller: "home", action: "index")
      return;
    }

    Yelp yelp = Yelp.newInstance(); //start the yelp request (local search)
    def request = yelp.search(site.lat, site.lng, "")
    def searchResponse = JSON.parse(request)
    def bizTotal = searchResponse.total
    def newResponse
    def review
    def reviewDates = [];

    if (bizTotal > 0) {   //do a business search
      def bizId = searchResponse.businesses[0].id
      def bizRequest = yelp.search(site.lat, site.lng, bizId)
      newResponse = JSON.parse(bizRequest)
      review = new YelpReview()
      review.reviewCount = newResponse.review_count
      review.id = newResponse.id
      review.starUrl = newResponse.rating_img_url
      review.bizUrl = newResponse.url
      review.reviews = newResponse.reviews
      for (int i=0; i < review.reviews.size(); i++) {
        def df = new SimpleDateFormat("MM/dd/yyyy")
        long milsec = review.reviews[i].time_created * 1000L
        def revTime = new Date(milsec)
        reviewDates[i] = df.format(revTime)
      }
    }

    // We're passing in bestUnit parameter now. If that's available then try to use it
    def bestUnit
    if (params.bestUnit) {
        bestUnit = StorageUnit.findById(params.bestUnit)
    }
    if (!bestUnit) {
      def units = site.units.findAll { it.unitsize.searchType == SearchType.STORAGE && it.unitCount > site.minInventory }
      bestUnit = units.min { it.bestUnitPrice }
    }

    if (!session?.shortSessionId) {
      session.shortSessionId = (10000 + (Math.random() * 89999)) as Integer
    }

    // preload required insurance
    def insurance = null;
    if (site.noInsuranceWaiver) {
      if (site.insurances.size() > 0) {
        insurance = site.insurances.findAll { it.active }.min { it.premium }
      } else {
        // TODO: Log SEVERE warning
      }
    }

    UnitType chosenUnitType = params.unitType ? UnitType.valueOf(params.unitType) : bestUnit?.unitType

    def video = Video.findBySite(site)
    def propertyOperatorList = StorageSite.findAllByFeed(site.feed).findAll { !it.disabled && it.id != site.id && it.state == site.state}

    def title = "${StoritzUtil.titleize(site.city)} Self Storage Units at ${site.title} - ${StoritzUtil.titleize(site.city)}, ${site.state.display} - ${site.zipcode}"
    def availableUnitList = site.units.findAll { it.unitsize.searchType == SearchType.STORAGE && it.unitCount > site.minInventory }
    def sortedUnitList = availableUnitList.sort { unit1, unit2 -> unit1.unitsize.width * unit1.unitsize.length <=> unit2.unitsize.width * unit2.unitsize.length ?: unit1.unitType.display <=> unit2.unitType.display ?: unit1.bestUnitPrice <=> unit2.bestUnitPrice }
    def availableUnits = [];
    String curSizeDescription = null;
    String curTypeDisplay = null;
    sortedUnitList.each { unit ->
      if (unit.unitsize.description != curSizeDescription || unit.unitType.display != curTypeDisplay) {
        curSizeDescription = unit.unitsize.description;
        curTypeDisplay = unit.unitType.display;
        def offer = null;
        def offers = offerFilterService.getValidFeaturedOffers(site, unit);
        if (offers != null && offers.size() > 0) {
          offer = offers[0];
        }
        availableUnits << [unit:unit, promo:offer]
      }
    }
    def moveInDate = new Date();
    def promo = params.promoId ? SpecialOffer.get(params.promoId as Long) : null;
    def promos = offerFilterService.getValidFeaturedOffers(site, bestUnit);
    promos.addAll(offerFilterService.getValidNonFeaturedOffers(site, bestUnit));
    def totals = costService.calculateTotals(site, bestUnit, promo, insurance, moveInDate);
    def xid = UUID.randomUUID().toString().toUpperCase()

    // If you change this, don't forget the smartCall action also uses this view!
    [rentalTransactionInstance: rentalTransactionInstance, site: site, title: title, review: review, bizTotal: bizTotal, reviewDates: reviewDates,
            shortSessionId: session.shortSessionId, chosenUnitType: chosenUnitType, monthlyRate: bestUnit?.price,
            pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), unitId: bestUnit?.id, searchSize: bestUnit?.unitsize?.id,
            promoId: params.promoId, insurance: insurance, video: video, propertyOperatorList: propertyOperatorList,
            moveInDate: moveInDate, unit: bestUnit, promo: promo, promos: promos, totals: totals, availableUnits: availableUnits, xid: xid]
  }

  def rentMePanel = {
    renderTransactionPanel("/storageSite/rentMePanel")
  }


  def yelpTest = {
      Yelp yelp = Yelp.newInstance();
      yelp.search(30.361471, -87.164326, "")

    def idList = StorageSite.getAll();
    def random = new Random();
    int max = idList.size();
    int counter = 0;
    def siteList = [ ];
    while (siteList.size() < 10) {
      int temp = random.nextInt(max+1);
      StorageSite site = idList[temp];
      if (site && !site.disabled) {
        siteList[counter] = site;
        counter+=1;
      }
      else {
        continue;
      }
    }
    return [siteList: siteList];
  }

  def directions = {
    StorageSite site = StorageSite.get(params.id)

    if (!site) {
      // TODO - handle missing site
    }

    def title = "Storitz - Driving Directions to ${site.title}"

    [site: site, title : title]
  }

  def getSmartCallDataForId(id) {
    RentalTransactionController.liveSessions[id]
  }

  def getRecentSmartCallData() {
    def calls = RentalTransactionController.liveSessions.entrySet().sort { -it.value.timestamp }
    if (calls.size() > 50) {
      calls = calls[0..49]
    }
    calls
  }

  @Secured(['ROLE_CALLCENTER'])
  def findCall = {
    [calls: recentSmartCallData]
  }

  @Secured(['ROLE_CALLCENTER'])
  def smartCall = {
    def callParams = getSmartCallDataForId(params.id)

    if (!callParams) {
//          flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'rentalTransaction.label', default: 'com.storitz.RentalTransaction'), params.id])}"
      redirect(action: "findCall")
    } else {

      def site
      def rentalTransaction
      if (callParams.page != 'payment') {
        site = StorageSite.get(callParams.site)
        callParams.rentalTransaction.site = site
        rentalTransaction = callParams.rentalTransaction
      } else {
        site = StorageSite.get(callParams.rentalTransaction.site.id)
        rentalTransaction = RentalTransaction.get(callParams.rentalTransaction.id)
      }

      //////////////////////////////////////////
      // >>> BEGIN match detail action code <<<

      SearchType searchType
      StorageSize unitSize = callParams.searchSize ? StorageSize.get(callParams.searchSize) : null
      if (unitSize) {
        searchType = unitSize.searchType
      } else {
        searchType = callParams.searchType ? SearchType.getEnumFromId(callParams.searchType) : SearchType.STORAGE
      }

      Collection sizeList = site.units.findAll { it.unitsize.searchType == searchType }.collect { it.unitsize }.unique()
      // output JSON for types
      Collection unitTypes = unitSize ? site.units.findAll { it.unitsize.id == unitSize.id}.collect { "{\"type\":\"${it.unitType}\",\"value\":\"${it.unitType.display}\"}" }.unique() : site.units.findAll { it.unitsize.searchType == searchType}.collect { "{\"type\":\"${it.unitType}\",\"value\":\"${it.unitType.display}\"}" }.unique()

      sizeList.sort { it.width * it.length }

      def bestUnit
      // if a size was chosen, use it, else get the "best" price
      if (params.unitType && unitSize) {
        bestUnit = site.units.findAll { it.unitType == params.unitType && it.unitsize.id == unitSize.id && it.unitCount > site.minInventory }.min { it.price }
        if (!bestUnit) {
          bestUnit = site.units.findAll { it.unitsize.id == unitSize.id && it.unitCount > site.minInventory }.min { it.price }
        }
      } else if (unitSize) {
        bestUnit = site.units.findAll { it.unitsize.id == unitSize.id && it.unitCount > site.minInventory }.min { it.price }
      } else {
        // TODO - decide on best price or best price for a given size
        bestUnit = site.units.findAll { it.unitsize.searchType == searchType && it.unitCount > site.minInventory }.min { it.price }
      }

      // >>> END match detail action code <<<
      //////////////////////////////////////////

      // TODO - pass new model params to this view

      UnitType chosenUnitType = callParams.unitType ? UnitType.valueOf(callParams.unitType) : bestUnit?.unitType

      def video = Video.findBySite(site)
      def propertyOperatorList = StorageSite.findAllByFeed(site.feed).findAll { !it.disabled && it.id != site.id && it.state == site.state}

      def title = "Best Price Guaranteed Self Storage for ${site.title} in ${site.city}, ${site.state.display} - Storitz"
      if (title.size() > 70) {
        title = "${site.title} in ${site.city}, ${site.state.display} - Storitz"
      }

      def model = [rentalTransactionInstance: rentalTransaction, sizeList: sizeList, unitTypes: unitTypes, site: site,
              title: title,
              shortSessionId: session.shortSessionId, id: site.id, chosenUnitType: chosenUnitType, monthlyRate: bestUnit?.price,
              pushRate: (site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price), unitId: bestUnit?.id, searchSize: bestUnit?.unitsize?.id, searchType: callParams.searchType,
              promoId: callParams.rentalTransaction?.promoId, insuranceId: callParams.rentalTransaction?.insuranceId, video: video, propertyOperatorList: propertyOperatorList]

      // We set the landing cookie so the operator looks like the renter would when the transaction is paid.
      params.landingCookie = callParams.landingCookie

      Cookie landingCookie = CookieCodec.bakeLandingCookie(params.landingCookie)

      response.addCookie(landingCookie)

      params.id = model.id
      params.size = model.searchSize
      params.address = model.address
      params.date = model.date

      render(view: (callParams.page == 'detail' ? '/storageSite/' : '/rentalTransaction/') + callParams.page, model: model)
    }
  }

  def detailTotals = {

    def moveInDate
    def unitType
    if (params.unitType) {
      unitType = (params.unitType instanceof UnitType ? params.unitType : UnitType.valueOf(params.unitType as String))
    }
    if (params.moveInDate && params.moveInDate instanceof Date) {
      moveInDate = params.moveInDate
    } else {
      if (params.moveInDate) {
        moveInDate = Date.parse('MM/dd/yy', params.moveInDate)
      } else {
        moveInDate = new Date()
      }
    }
    def site = StorageSite.get(params.id)
    if (!site) {
      render(status: 200, contentType: "application/json", text: "{ \"totals\": { \"unitTypes\":[  ], \"chosenInsurance\":\"\", \"chosenPromo\":\"\", \"monthlyRate\":0, \"pushRate\":0, \"unitId\":-1, \"chosenUnitType\":\"\", \"additionalFees\":0, \"premium\":0, \"durationMonths\":0, \"discountTotal\":0, \"totalMoveInCost\":0, \"tax\":0, \"extended\":0, \"paidThruDate\":\"\", \"deposit\":0} }}")
      return
    }

    SearchType searchType = params.searchType ? SearchType.getEnumFromId(params.searchType) : SearchType.STORAGE
    Collection unitTypes
    Collection sizeList
    StorageSize unitSize = params.searchSize ? StorageSize.get(params.searchSize) : null
    if (params.action == 'unitType') {
      unitTypes = site.units.collect { "{\"type\":\"${it.unitType}\",\"value\":\"${it.unitType.display}\"}" }.unique()
      sizeList = site.units.findAll { it.unitCount > site.minInventory && it.unitType == unitType }.collect { it.unitsize }.unique()
    } else {
      unitTypes = unitSize ? site.units.findAll { it.unitCount > 0 && it.unitsize.id == unitSize.id}.collect { "{\"type\":\"${it.unitType}\",\"value\":\"${it.unitType.display}\"}" }.unique() : site.units.findAll { it.unitCount > 0 && it.unitsize.searchType == searchType }.collect { "{\"type\":\"${it.unitType}\",\"value\":\"${it.unitType.display}\"}" }.unique()
      sizeList = site.units.findAll { it.unitCount > site.minInventory && it.unitsize.searchType == searchType }.collect { it.unitsize }.unique()
    }

    // output JSON for types

    sizeList.sort { it.width * it.length }

    StorageUnit bestUnit
    StorageUnit bestUnitPushRate
    // if a size was chosen, use it, else get the "best" price
    if (params.unitType && unitSize) {
      bestUnit = site.units.findAll { it.unitCount > site.minInventory && it.unitType == unitType && it.unitsize.id == unitSize.id }.min { it.price }
      bestUnitPushRate = site.units.findAll { it.unitCount > site.minInventory && it.unitType == unitType && it.unitsize.id == unitSize.id }.min { it.pushRate }

      // JM: 2011-05-12.
      // Almost always the push (street) rate will be less than or equal to the normal rate.
      // However, it is possible for the push rate to be greater than the normal rate.
      // If this is the case, defer to the normal rate.
      if (site.allowPushPrice && bestUnitPushRate) {
        if (!bestUnit || bestUnit.price > bestUnitPushRate.pushRate) {
          bestUnit = bestUnitPushRate
        }
      }

      if (!bestUnit) {
        if (params.action == 'unitType') {
          // find closest size
          def bestSize = site.units.findAll { it.unitType == unitType && it.unitCount > site.minInventory }.min { abs(it.unitsize.width * it.unitsize.length - unitSize.width * unitSize.length)}.unitsize.id
          bestUnit = site.units.findAll { it.unitType == unitType && it.unitsize.id == bestSize && it.unitCount > site.minInventory }.min { it.price }
        } else {
          bestUnit = site.units.findAll { it.unitsize.id == unitSize.id && it.unitCount > site.minInventory }.min { it.price }
        }
      }
    } else if (unitSize) {
      bestUnit = site.units.findAll { it.unitsize.id == unitSize.id && it.unitCount > site.minInventory }.min { it.price }
    } else {
      // TODO - decide on best price or best price for a given size
      bestUnit = site.units.findAll { it.unitCount > site.minInventory }.min { it.price }
    }
    if (!bestUnit) {
      println "Best Unit not found for site:${site.id} unitType:${params.unitType} unitSize:${unitSize}"
    }

    def specialOffers = offerFilterService.getValidNonFeaturedOffers(site, bestUnit)
    def featuredOffers = offerFilterService.getValidFeaturedOffers(site, bestUnit)

    def chosenPromo = ''
    SpecialOffer specialOffer
    Long chosenPromoId = (params.chosenPromoId ? params.long('chosenPromoId') : -999l)
    if (chosenPromoId > 0) {
      if (specialOffers.find {it.id == chosenPromoId} || featuredOffers.find {it.id == chosenPromoId}) {
        specialOffer = SpecialOffer.get(chosenPromoId)
        chosenPromo = specialOffer.promoName
      }
    }

    def premium = 0
    Insurance ins
    def chosenInsurance = ''
    if (params.insuranceId && (params.insuranceId as Long) > 0) {
      ins = Insurance.get(params.insuranceId as Long)
      if (ins) {
        premium = ins.premium
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US)
        NumberFormat pf = NumberFormat.getPercentInstance(Locale.US)

        chosenInsurance = "${nf.format(ins.premium)}/mo. Coverage: ${nf.format(ins.totalCoverage)} Theft: ${pf.format(ins.percentTheft)}"
      }
    }

    CostTotals totals = costService.calculateTotals(site, bestUnit, specialOffer, ins, moveInDate)

    JSON.use("default")
    render(status: 200, contentType: "application/json", text: "{ \"totals\": { \"unitTypes\":[ ${unitTypes.join(',')} ], \"sizeList\":${sizeList as JSON}, \"chosenInsurance\":\"${chosenInsurance}\", \"chosenPromo\":\"${chosenPromo}\", \"monthlyRate\":${bestUnit?.price}, \"pushRate\":${site.allowPushPrice ? bestUnit?.pushRate : bestUnit?.price }, \"unitId\":${bestUnit?.id}, \"chosenUnitType\":\"${bestUnit?.unitType}\", \"chosenUnitTypeDisplay\":\"${bestUnit?.unitType?.display}\", \"actualSize\":\"${bestUnit?.displaySize}\", \"additionalFees\":${totals.feesTotal}, \"premium\":${premium}, \"duration\":${totals.duration}, \"durationDays\":${totals.durationDays}, \"durationMonths\":${totals.durationMonths}, \"discountTotal\":${totals.discountTotal}, \"totalMoveInCost\":${totals.moveInTotal}, \"tax\":${totals.tax}, \"extended\":${totals.extended}, \"paidThruDate\":\"${totals.paidThruDateString}\", \"deposit\":${totals.deposit}, \"featuredOffers\": ${featuredOffers as JSON}, \"specialOffers\": ${specialOffers as JSON } } }")

  }

  def refreshInventory = {
    println "Refreshing inventory"
    storitz.UpdateInventoryJob.triggerNow([from: 'Admin']);
    flash.message = "Inventory/units refreshing now"
    redirect(controller: "admin", action: "index")
  }

  def refreshPromo = {
    def writer = new PrintWriter(System.out)
    def site = StorageSite.get(params.id as Long)
    if (site) {
      feedService.refreshPromos(site, writer)
    }
    flash.message = "Promos refreshed"
    redirect(action: "show", id: site.id)
  }

  def refreshPromos = {
    storitz.RefreshPromosJob.triggerNow([from: 'Admin']);
    flash.message = "Special Offers/Promotions refreshing now"
    redirect(controller: "admin", action: "index")
  }

  def refreshPhones = {
    storitz.RefreshPhoneJob.triggerNow([from: 'Admin']);
    flash.message = "Site Phone refreshing now"
    redirect(controller: "admin", action: "index")
  }

  def kml = {
    def site = StorageSite.get(params.id as Long)
    if (!site) {
      render(view: 'kmlEmpty')
      return
    }
    [site: site]
  }

  @Secured(['ROLE_ADMIN'])
  def updateGeo = {
    for (site in StorageSite.findAll()) {
      def address = site.getFullAddress()
      def geoResult = geocodeService.geocode(address)

      if (geoResult.Placemark) {
        site.lng = geoResult.Placemark[0].Point.coordinates[0]
        site.lat = geoResult.Placemark[0].Point.coordinates[1]
      } else {
        println "Could not find address ${address} for site: ${site.title}"
      }

      println "Updated site ${site.title} lat=${site.lat},lng=${site.lng}"
      site.save(flush: true)
    }
    flash.message = "Updated lat/lng."
    redirect(controller: "admin", action: "index")
  }

  def redirectSiteLink = {
    response.status = 301
    response.setHeader("Location", g.createLink(mapping: 'siteLink2', params: [site_title: params.site_title.replaceAll(' ', '-'), id: params.id]) as String)
    render("")
    return false
  }

}
