n// Add ant task capabilities
grails.project.dependency.resolution = {
  inherits("global")
  log "warn"
  repositories {
    inherits true // Whether to inherit repository definitions from plugins

    grailsPlugins()
    grailsHome()
    grailsCentral()

    mavenLocal()
    mavenCentral()

    mavenRepo "http://snapshots.repository.codehaus.org"
    mavenRepo "http://repository.codehaus.org"
    mavenRepo "http://download.java.net/maven/2/"
    mavenRepo "http://repo.grails.org/grails/plugins"
  }
  dependencies {
    runtime "org.apache.ant:ant:1.7.1"
    runtime "org.apache.ant:ant-launcher:1.7.1"
    runtime "org.springframework:org.springframework.test:3.0.5.RELEASE"

  }

  plugins {
    compile ":hibernate:$grailsVersion"
    build ":tomcat:$grailsVersion"
    compile ":authorize-net:0.12"
    compile ":csv:0.1"
    compile ":cxf:0.7.0"
    compile ":fckeditor:0.9.5"
    compile ":jms:0.5.2"
    compile ":jquery:1.4.2.5"
    compile ":jquery-ui:1.8.2.4"
    compile ":mail:0.9"
    compile ":quartz:0.4.2"
    compile ":rest:0.3"
    compile ":sanitizer:0.3"
    compile ":spring-security-core:1.1.3"
    compile ":ui-performance:1.2.2"
    compile ":dynamic-jasper:0.6"
  }
}
//grails.plugin.location.'image-tools' = "http://blog.labrat.info/wp-content/uploads/2011/01/grails-image-tools-1.0.5.zip"

