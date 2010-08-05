package storitz

import groovyx.net.ws.WSClient


class CShiftService {

    boolean transactional = false

  def serviceMethod() {

      proxy = new WSClient("https://slc.centershift.com/Sandbox40/SWS.asmx?WSDL", this.class.classLoader)
      proxy.initialize();
    }
}
