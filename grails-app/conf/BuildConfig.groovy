grails.project.dependency.resolution = {
  inherits( "global" )
  log "warn"
  repositories {
    grailsPlugins()
    grailsHome()
    // grailsCentral()
  }
  dependencies {
    runtime "org.apache.ant:ant:1.7.1"
    runtime "org.apache.ant:ant-launcher:1.7.1"
  }
}