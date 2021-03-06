package storitz

class WebUtilService {

  boolean transactional = false

  /** cache controls  */
  def nocache(response) {
    response.setHeader('Cache-Control', 'no-cache') // HTTP 1.1
    response.addDateHeader('Expires', 0)
    response.setDateHeader('max-age', 0)
    response.setIntHeader('Expires', -1) //prevents caching at the proxy server
    response.addHeader('cache-Control', 'private') //IE5.x only
  }


}