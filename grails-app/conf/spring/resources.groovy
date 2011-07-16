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

  // default ports for production
  def activeMQport1 = 61619
  def activeMQport2 = 61617

  switch (GrailsUtil.environment) {
    case "production_script":
      activeMQport1 = 61719
      activeMQport2 = 61717
      break
    case "next":
      activeMQport1 = 61620
      activeMQport2 = 61621
      break
    case "next_script":
      activeMQport1 = 61622
      activeMQport2 = 61623
      break
    case "preview":
      activeMQport1 = 61624
      activeMQport2 = 61625
      break
    case "preview_script":
      activeMQport1 = 61626
      activeMQport2 = 61627
      break
    case "beta":
      activeMQport1 = 61628
      activeMQport2 = 61629
      break
    case "beta_script":
      activeMQport1 = 61630
      activeMQport2 = 61631
      break
    case "development":
      activeMQport1 = 61632
      activeMQport2 = 61633
      break
    case "development_script":
      activeMQport1 = 61634
      activeMQport2 = 61635
      break
    case "test":
      activeMQport1 = 61636
      activeMQport2 = 61637
      break
    case "test_script":
      activeMQport1 = 61638
      activeMQport2 = 61639
      break
  }

  println "Starting ActiveMQ service for ${GrailsUtil.environment} on ports ${activeMQport1}, ${activeMQport2}"
  jmsBroker(XBeanBrokerService) {
    useJmx = 'false'
    persistent = 'false'
    transportConnectors = [new TransportConnector(uri: new URI("tcp://localhost:${activeMQport1}"))]
  }

  connectionFactory(ActiveMQConnectionFactory) {
    brokerURL = "vm://localhost:${activeMQport2}"
  }

  jmsTemplate(JmsTemplate) {
    connectionFactory = { SingleConnectionFactory cf ->
      targetConnectionFactory = ref('connectionFactory')
    }
  }
  jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
    brokerURL = "vm://localhost:${activeMQport1}"
  }
  jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
    bean.destroyMethod = "stop"
    connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
      brokerURL = "vm://localhost:${activeMQport1}"
    }
  }
}
