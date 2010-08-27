import storitz.spring.CustomPropertyEditorRegistrar
import org.springframework.security.web.util.AntUrlPathMatcher
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource
import org.springframework.security.web.access.channel.SecureChannelProcessor
import org.springframework.security.web.access.channel.InsecureChannelProcessor
import org.springframework.security.web.access.channel.ChannelProcessingFilter
import org.springframework.security.web.access.channel.ChannelDecisionManagerImpl
import grails.util.*
import org.apache.activemq.xbean.XBeanBrokerService
import org.apache.activemq.broker.TransportConnector
import org.apache.activemq.spring.ActiveMQConnectionFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.connection.SingleConnectionFactory

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
      println "Starting production ActiveMQ 61619"
      jmsBroker(XBeanBrokerService) {
			useJmx = 'false'
			persistent = 'false'
			transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61619'))]
      }

      connectionFactory(ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61617"
      }

      jmsTemplate(JmsTemplate) {
          connectionFactory =  { SingleConnectionFactory cf ->
              targetConnectionFactory = ref('connectionFactory')
          }
      }
      jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61619"
      }
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
        bean.destroyMethod = "stop"
        connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
          brokerURL = "vm://localhost:61619"
        }
      }
      break

    case "development":
      println "Starting development ActiveMQ 61617"
      jmsBroker(XBeanBrokerService) {
			useJmx = 'false'
			persistent = 'false'
			transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61617'))]
      }

      connectionFactory(ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61617"
      }

      jmsTemplate(JmsTemplate) {
          connectionFactory =  { SingleConnectionFactory cf ->
              targetConnectionFactory = ref('connectionFactory')
          }
      }
      jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61617"
      }
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
        bean.destroyMethod = "stop"
        connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
          brokerURL = "vm://localhost:61617"
        }
      }
      break

    case "test":
      println "Starting test ActiveMQ 61618"
      jmsBroker(XBeanBrokerService) {
            useJmx = 'false'
            persistent = 'false'
            transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61618'))]
      }

      connectionFactory(ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61618"
      }

      jmsTemplate(JmsTemplate) {
          connectionFactory =  { SingleConnectionFactory cf ->
              targetConnectionFactory = ref('connectionFactory')
          }
      }
      jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61618"
      }
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
        bean.destroyMethod = "stop"
        connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
            brokerURL = "vm://localhost:61618"
        }
      }
      break
  }
}
