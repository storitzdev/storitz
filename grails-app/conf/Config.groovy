// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [html: ['text/html', 'application/xhtml+xml'],
        xml: ['text/xml', 'application/xml'],
        text: 'text/plain',
        js: 'text/javascript',
        rss: 'application/rss+xml',
        atom: 'application/atom+xml',
        css: 'text/css',
        csv: 'text/csv',
        all: '*/*',
        pdf: 'application/pdf',
        rtf: 'application/rtf',
        excel: 'application/vnd.ms-excel',
        ods: 'application/vnd.oasis.opendocument.spreadsheet',
        json: ['application/json', 'text/json'],
        form: 'application/x-www-form-urlencoded',
        multipartForm: 'multipart/form-data'
]
// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"


grails.converters.encoding = "UTF-8"
grails.converters.xml.pretty.print = true
grails.converters.json.pretty.print = true
grails.converters.json.default.deep = true
grails.converters.xml.default.deep = true
grails.converters.default.circular.reference.behaviour = "INSERT_NULL"

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true

// set per-environment serverURL stem for creating absolute links
environments {
  production {
    grails.serverURL = "http://www.storitz.com"
    grails.serverRoot = "/home/deploy/tomcat-current/www.storitz.com/ROOT"
    security.httpsPort = 443
    grails.plugins.springsecurity.controllerAnnotations.staticRules = [
            '/weblog/**': ['ROLE_USER'],
    ]
    storitz.nacha.dir = '/home/deploy/tomcat-current/www.storitz.com/nacha'
    storitz.nacha.fileId = '7878782339'
    storitz.nacha.companyId = '1272912549'
    storitz.google.signatureRequired = true
  }
  next {
    grails.serverURL = "http://next.storitz.com"
    grails.serverRoot = "/usr/share/tomcat6/webapps/ROOT" // DOES THIS MATTER?
    security.httpsPort = 443
    grails.plugins.springsecurity.controllerAnnotations.staticRules = [
            '/weblog/**': ['ROLE_USER'],
    ]
    storitz.google.signatureRequired = true
    storitz.rentals.sandboxMode = true
  }
  // For production_script, the given port is unimportant, as long as it does not conflict with the actual port value.
  // We'll also turn off the public server url and set the Google signatureRequired to false.
  production_script {
    grails.serverURL = "http://www.storitz.com:18080"
    security.httpsPort = 443
    grails.plugins.springsecurity.controllerAnnotations.staticRules = [
            '/weblog/**': ['ROLE_USER'],
    ]
    storitz.nacha.dir = '/home/deploy/tomcat-current/www.storitz.com/nacha'
    storitz.nacha.fileId = '7878782339'
    storitz.nacha.companyId = '1272912549'
    storitz.google.signatureRequired = false
  }
  preview {
    grails.serverURL = "http://preview.storitz.com"
    grails.serverRoot = "/home/deploy/tomcat-current/preview.storitz.com/ROOT"
    security.httpsPort = 443
    grails.plugins.springsecurity.controllerAnnotations.staticRules = [
            '/home/**': ['ROLE_USER', 'ROLE_ADMIN'],
            '/STMap/**': ['ROLE_USER', 'ROLE_ADMIN'],
            '/storageSite/**': ['ROLE_USER', 'ROLE_ADMIN']
    ]
    storitz.google.signatureRequired = true
    storitz.rentals.sandboxMode = true
  }
  // For preview_script, the given port is unimportant, as long as it does not conflict with the actual port value.
  // We'll also turn off the public server url and set the Google signatureRequired to false.
  preview_script {
    grails.serverURL = "http://preview.storitz.com:18080"
    security.httpsPort = 443
    grails.plugins.springsecurity.controllerAnnotations.staticRules = [
            '/home/**': ['ROLE_USER', 'ROLE_ADMIN'],
            '/STMap/**': ['ROLE_USER', 'ROLE_ADMIN'],
            '/storageSite/**': ['ROLE_USER', 'ROLE_ADMIN']
    ]
    storitz.google.signatureRequired = false
  }
  development {
    grails.serverURL = "http://localhost:8080/${appName}"
    grails.serverRoot = "/home/jason/Projects/storitz/web-app"
    security.httpsPort = 8443
    storitz.nacha.dir = 'c:/temp/nacha'
    storitz.nacha.fileId = '1234567890'
    storitz.nacha.companyId = '0123456789'
    uiperformance.enabled = false
    storitz.google.signatureRequired = false
    storitz.rentals.sandboxMode = true
  }
  // For development_script, the given port is unimportant, as long as it does not conflict with the actual port value
  development_script {
    grails.serverURL = "http://localhost:18080/${appName}"
    security.httpsPort = 8443
    storitz.nacha.dir = 'c:/temp/nacha'
    storitz.nacha.fileId = '1234567890'
    storitz.nacha.companyId = '0123456789'
    uiperformance.enabled = false
    storitz.google.signatureRequired = false
  }
  test {
    grails.serverURL = "http://localhost:8080/${appName}"
    grails.serverRoot = "/home/deploy/tomcat-current/test.storitz.com/ROOT"
    security.httpsPort = 8443
    storitz.nacha.dir = 'c:/temp/nacha'
    storitz.nacha.fileId = '1234567890'
    storitz.nacha.companyId = '0123456789'
    uiperformance.enabled = false
    storitz.google.signatureRequired = true
  }
  // For test_script, the given port is unimportant, as long as it does not conflict with the actual port value
  test_script {
    grails.serverURL = "http://test.storitz.com:18080/${appName}"
    security.httpsPort = 8443
    storitz.nacha.dir = 'c:/temp/nacha'
    storitz.nacha.fileId = '1234567890'
    storitz.nacha.companyId = '0123456789'
    uiperformance.enabled = false
    storitz.google.signatureRequired = false
  }

}

// This should be true at least during development.
// Would have saved me time trying to figure out that my records weren't being saved and why. 
grails.gorm.failOnError = true

// log4j configuration

def logDirectory = '.' 
// per http://stackoverflow.com/questions/3171816/grails-app-will-not-deploy-on-tomcat-fail-application-could-not-be-started
def catalinaBase = System.properties.getProperty('catalina.base') 
if (!catalinaBase) catalinaBase = '.'   // just in case 
logDirectory = "${catalinaBase}/logs" 

log4j = {
  // Example of changing the log pattern for the default console
  // appender:
  //
  appenders {
    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    // per http://stackoverflow.com/questions/3171816/grails-app-will-not-deploy-on-tomcat-fail-application-could-not-be-started
    rollingFile name:'stdout', file:"${logDirectory}/${appName}.log".toString()
    rollingFile name:'stacktrace', file:"${logDirectory}/${appName}_stack.log".toString() 
  }
  root {
    info()
  }

  appender.stdout = "org.apache.log4j.ConsoleAppender"
  appender.'stdout.layout' = "org.apache.log4j.PatternLayout"
  appender.'stdout.layout.ConversionPattern' = '[%r] %c{2} %m%n'

  error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
          'org.codehaus.groovy.grails.web.pages', //  GSP
          'org.codehaus.groovy.grails.web.sitemesh', //  layouts
          'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
          'org.codehaus.groovy.grails.web.mapping', // URL mapping
          'org.codehaus.groovy.grails.commons', // core / classloading
          'org.codehaus.groovy.grails.plugins', // plugins
          'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
          'org.springframework',
          'org.hibernate',
          'org.apache.cxf'

  warn 'org.mortbay.log'

  info 'grails.app'

    // debug  'org.apache.axis'
}

//log4j.logger.org.springframework.security='off,stdout'
// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'com.storitz.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'com.storitz.UserRole'
grails.plugins.springsecurity.authority.className = 'com.storitz.Role'
grails.plugins.springsecurity.requestMap.className = 'com.storitz.RequestMap'
grails.plugins.springsecurity.securityConfigType = grails.plugins.springsecurity.SecurityConfigType.Annotation
grails.plugins.springsecurity.logout.afterLogoutUrl = "/logout.gsp"

grails.date.formats = ['dd-MM-yyyy', 'h:mma', 'MM/dd/yyyy', "yyyy-MM-dd'T'HH:mm:ss'Z'"]

// Mail configuration
grails.mail.host = "mx.storitz.com"
grails.mail.port = 587
grails.mail.username = "no-reply@storitz.com"
grails.mail.password = "ylper!0n"
grails.mail.props = ["mail.smtp.auth": "true",
        "mail.smtp.socketFactory.port": "587"]

// UI-performance configuration
uiperformance.bundles = [
        [type: 'js',
                name: 'all',
                files: ["jquery-1.4.2.min",
                        "jquery-ui-1.8.6.custom.min",
                        "jquery.cookie",
                        "placeholder",
                        "jquery.tools.min",
                        "application",
                        "jquery.validate.min",
                        "jwplayer"
                ]],
        [type: 'css',
                name: 'bundled',
                files: ["reset",
                        "buttons",
                        "application",
                        "jquery-ui-1.8.6.custom"
                ]]
]

uiperformance.exclusions = [
        "**/jwplayer/*",
        "**/logo_storitz.gif",
        "**/logo_storitz_small.gif",
        "**/storitz_logo*",
        "**/storitz-logo*",
        "**/storitz-footer*",
        "**/tagline_clickstoredone.gif",
        "**/plugins/**",
        "**/images/email/**",
        "**/images/themes/**"
]

uiperformance.keepOriginals = true // for use in by non-grails apps, e.g. wordpress
