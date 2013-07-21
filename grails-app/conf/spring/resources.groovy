import com.maxmind.geoip.LookupService
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import storitz.spring.CustomPropertyEditorRegistrar
import org.springframework.security.web.util.AntUrlPathMatcher
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource
import org.springframework.security.web.access.channel.SecureChannelProcessor
import org.springframework.security.web.access.channel.InsecureChannelProcessor
import org.springframework.security.web.access.channel.ChannelProcessingFilter
import org.springframework.security.web.access.channel.ChannelDecisionManagerImpl

// Place your Spring DSL code here
beans = {

  customPropertyEditorRegistrar(CustomPropertyEditorRegistrar)

  // SPRING SECURITY (CHANNEL SECURITY)
  channelDecisionManager(ChannelDecisionManagerImpl) {
    channelProcessors = [new SecureChannelProcessor(),
            new InsecureChannelProcessor()]
  }
  securityMetadataSource(DefaultFilterInvocationSecurityMetadataSource,
          new AntUrlPathMatcher(),
          ChannelConfig.getChannelConfig()) {
    stripQueryStringFromUrls = true
  }

  channelProcessingFilter(ChannelProcessingFilter) {
    channelDecisionManager = ref("channelDecisionManager")
    securityMetadataSource = ref("securityMetadataSource")
  }

  lookupService(LookupService, new File(ConfigurationHolder.config.storitz.geoip.file as String), LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE)

  jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
    bean.destroyMethod = "stop"
    connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
      brokerURL = "vm://localhost:61617"
    }
  }
}
