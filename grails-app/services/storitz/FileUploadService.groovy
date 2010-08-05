package storitz

import org.springframework.context.*

class FileUploadService implements ApplicationContextAware {

    ApplicationContext applicationContext

    boolean transactional = false
  
  def moveFile(file, folderRelativePath, fileName, objectId) {
        try {
            File filePath = new File(getAbsolutePath(folderRelativePath + getIdPath(objectId), fileName))
            filePath.mkdirs()
            file.transferTo(filePath)
            return true
         }catch(Exception exception){
             log.error "File move error, ${exception}"
         }
        return false
  }

  private String getAbsolutePath(folderPath, fileName){
        "${applicationContext.getResource(folderPath).getFile()}${File.separatorChar}${fileName}"
  }

  public String getIdPath(id) {
    return File.separator + String.valueOf((int)((id % 100) / 10)) + File.separator + String.valueOf(id % 10) + File.separator
  }

  public String getWebIdPath(id) {
    return '/' + String.valueOf((int)((id % 100) / 10)) + '/' + String.valueOf(id % 10) + '/'
  }

  public String getFilePath(folderRelativePath, fileName, objectId) {
    getAbsolutePath(folderRelativePath + getIdPath(objectId), fileName)  
  }
}
