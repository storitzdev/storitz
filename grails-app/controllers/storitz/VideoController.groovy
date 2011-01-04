package storitz

import com.storitz.PressRelease
import grails.plugins.springsecurity.Secured
import com.storitz.Video
import com.storitz.StorageSite

class VideoController {

    def fileUploadService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    @Secured(['ROLE_ADMIN'])
    def index = {
        redirect(action: "list", params: params)
    }

    @Secured(['ROLE_ADMIN'])
    def list = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
        params.sort = 'releaseDate'
        params.order = 'desc'
        [videoInstanceList: Video.list(params), videoInstanceTotal: Video.count()]
    }

    def video = {
        def videoInstance = Video.get(params.id)
        if (!videoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])}"
            // TODO - videoList
            redirect(action: "videoList")
        }
        else {
            [videoInstance: videoInstance]
        }
    }

    @Secured(['ROLE_ADMIN'])
    def create = {
        def videoInstance = new Video()
        videoInstance.properties = params
        return [videoInstance: videoInstance]
    }

    @Secured(['ROLE_ADMIN'])
    def save = {
        def site
        if (params.sitename) {
          site = StorageSite.findByTitle(params.sitename)
          params.remove('sitename')
        }
        def videoInstance = new Video(params)
        videoInstance.site = site
        def videoFile = request.getFile("videoFile_0")
        if (videoFile.size > 0 ) {
          if (site) {
            fileUploadService.moveFile(videoFile, '/video', videoFile.originalFilename, site.id)
            videoInstance.fileLocation = '/video' + fileUploadService.getWebIdPath(site.id) + videoFile.originalFilename
          } else {
            videoInstance.fileLocation = '/video/' + videoFile.originalFilename
            def destFile = new File(request.getRealPath(videoInstance.fileLocation))
            videoFile.transferTo(destFile)
          }
        } else {
          flash.message = "Missing Video file"
          render(view: "create", model: [videoInstance: videoInstance])
          return
        }
        def imageFile = request.getFile("imageFile_0")
        if (imageFile.size > 0 ) {
          def ext = '.' + imageFile.originalFilename.tokenize('.')[-1]
          if (site) {
            fileUploadService.moveFile(videoFile, '/video', imageFile.originalFilename, site.id)
            videoInstance.stillImage = '/video' + fileUploadService.getWebIdPath(site.id) + 'still-' + videoFile.originalFilename + ext
          } else {
            videoInstance.stillImage = '/video/still-' + videoFile.originalFilename + ext
            def destFile = new File(request.getRealPath(videoInstance.stillImage))
            imageFile.transferTo(destFile)
          }
        } else {
          flash.message = "Missing Still Image file"
          render(view: "create", model: [videoInstance: videoInstance])
          return
        }
        if (videoInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'video.label', default: 'Video'), videoInstance.id])}"
            redirect(action: "show", id: videoInstance.id)
        }
        else {
            render(view: "create", model: [videoInstance: videoInstance])
        }
    }

    @Secured(['ROLE_ADMIN'])
    def show = {
        def videoInstance = Video.get(params.id)
        if (!videoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])}"
            redirect(action: "list")
        }
        else {
            [videoInstance: videoInstance]
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit = {
        def videoInstance = Video.get(params.id)
        if (!videoInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pressRelease.label', default: 'Video'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [videoInstance: videoInstance]
        }
    }

    @Secured(['ROLE_ADMIN'])
    def update = {
        def videoInstance = Video.get(params.id)
        def site
        if (params.sitename) {
          site = StorageSite.findByTitle(params.sitename)
          videoInstance.site = site
        }
        if (videoInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (videoInstance.version > version) {
                    
                    videoInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'video.label', default: 'Video')] as Object[], "Another user has updated this Video while you were editing")
                    render(view: "edit", model: [videoInstance: videoInstance])
                    return
                }
            }
            videoInstance.properties = params
            site = videoInstance.site
            def videoFile = request.getFile("videoFile_0")
            if (videoFile?.size > 0 ) {
              File oldVideoFile = new File(request.getRealPath(videoInstance.fileLocation))
              if (oldVideoFile.exists()) {
                oldVideoFile.delete()
              }
              if (site) {
                fileUploadService.moveFile(videoFile, '/video', videoFile.originalFilename, site.id)
                videoInstance.fileLocation = '/video' + fileUploadService.getWebIdPath(site.id) + videoFile.originalFilename
              } else {
                videoInstance.fileLocation = '/video/' + videoFile.originalFilename
                def destFile = new File(request.getRealPath(videoInstance.fileLocation))
                videoFile.transferTo(destFile)
              }
            }
            def imageFile = request.getFile("imageFile_0")
            if (imageFile?.size > 0 ) {
              def ext = imageFile.originalFilename.tokenize('.')[-1]
              File oldImageFile = new File(request.getRealPath(videoInstance.stillImage))
              if (oldImageFile.exists()) {
                oldImageFile.delete()
              }
              if (site) {
                fileUploadService.moveFile(videoFile, '/video', imageFile.originalFilename, site.id)
                videoInstance.stillImage = '/video' + fileUploadService.getWebIdPath(site.id) + 'still-' + videoFile.originalFilename + ext
              } else {
                videoInstance.stillImage = '/video/still-' + videoFile.originalFilename + ext
                def destFile = new File(request.getRealPath(videoInstance.stillImage))
                imageFile.transferTo(destFile)
              }
            }
            if (!videoInstance.hasErrors() && videoInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'video.label', default: 'Video'), videoInstance.id])}"
                redirect(action: "show", id: videoInstance.id)
            }
            else {
                render(view: "edit", model: [videoInstance: videoInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])}"
            redirect(action: "list")
        }
    }

    @Secured(['ROLE_ADMIN'])
    def delete = {
        def videoInstance = Video.get(params.id)
        if (videoInstance) {
            try {
                File videoFile = new File(request.getRealPath(videoInstance.fileLocation))
                if (videoFile.exists()) {
                  videoFile.delete()
                }
                File imageFile = new File(request.getRealPath(videoInstance.stillImage))
                if (imageFile.exists()) {
                  imageFile.delete()
                }
                videoInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'video.label', default: 'Video'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'video.label', default: 'Video'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'video.label', default: 'Video'), params.id])}"
            redirect(action: "list")
        }
    }
}
