// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]
// The default codec used to encode data with ${}
grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"
grails.converters.encoding="UTF-8"

// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true

// set per-environment serverURL stem for creating absolute links
environments {
    production {
        grails.serverURL = "http://www.storitz.com"
        security.httpsPort = 443
    }
    preview {
        grails.serverURL = "http://preview.storitz.com"
        security.httpsPort = 8443
        grails.plugins.springsecurity.interceptUrlMap = [
           '/**':    ['ROLE_USER']
        ]
    }
    development {
        grails.serverURL = "http://localhost:8080/${appName}"
        security.httpsPort = 8443
    }
    test {
        grails.serverURL = "http://localhost:8080/${appName}"
        security.httpsPort = 8443
    }

}

// This should be true at least during development.
// Would have saved me time trying to figure out that my records weren't being saved and why. 
grails.gorm.failOnError = true

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
	       'org.codehaus.groovy.grails.web.pages', //  GSP
	       'org.codehaus.groovy.grails.web.sitemesh', //  layouts
	       'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
	       'org.codehaus.groovy.grails.web.mapping', // URL mapping
	       'org.codehaus.groovy.grails.commons', // core / classloading
	       'org.codehaus.groovy.grails.plugins', // plugins
	       'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
	       'org.springframework',
	       'org.hibernate'

    warn   'org.mortbay.log'

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
grails.plugins.springsecurity.interceptUrlMap = [
   '/weblog/**':    ['ROLE_ADMIN']
]

grails.date.formats = ['dd-MM-yyyy', 'h:mma']

// Mail configuration
grails.mail.host = "mail.storitz.com"
grails.mail.port = 587
grails.mail.username = "no-reply@storitz.com"
grails.mail.password = "ylper!0n"
grails.mail.props = ["mail.smtp.auth":"true",
      "mail.smtp.socketFactory.port": "587",
      "mail.smtp.socketFactory.class": "javax.net.ssl.SSLSocketFactory",
      "mail.smtp.socketFactory.fallback": "false",
      "mail.smtp.starttls.enable": "true"]
