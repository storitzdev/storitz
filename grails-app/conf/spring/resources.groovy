import storitz.spring.CustomPropertyEditorRegistrar
import org.springframework.security.web.util.AntUrlPathMatcher
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource
import org.springframework.security.web.access.channel.SecureChannelProcessor
import org.springframework.security.web.access.channel.InsecureChannelProcessor
import org.springframework.security.web.access.channel.ChannelProcessingFilter
import org.springframework.security.web.access.channel.ChannelDecisionManagerImpl
import grails.util.*

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

  switch(GrailsUtil.environment) {
    case "production":
      println "Starting production ActiveMQ 61616"
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory){bean ->
        bean.destroyMethod ="stop"
        connectionFactory(org.apache.activemq.ActiveMQConnectionFactory) {
            brokerURL = "vm:(production:(tcp://localhost:61616)?persistent=false)?marshal=false"
        }
      }
      break

    case "development":
      println "Starting development ActiveMQ 61617"
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory){bean ->
        bean.destroyMethod ="stop"
        connectionFactory(org.apache.activemq.ActiveMQConnectionFactory) {
            brokerURL = "vm:(development:(tcp://localhost:61617)?persistent=false)?marshal=false"
        }
      }
      break

    case "test":
      println "Starting test ActiveMQ 61618"
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory){bean ->
        bean.destroyMethod ="stop"
        connectionFactory(org.apache.activemq.ActiveMQConnectionFactory) {
            brokerURL = "vm:(test:(tcp://localhost:61618)?persistent=false)?marshal=false"
        }
      }
      break
  }
}
