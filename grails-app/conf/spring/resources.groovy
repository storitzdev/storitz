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
  def port1 = 61619
  def port2 = 61617

  switch (GrailsUtil.environment) {
    case "production_script":
      port1 = 61719
      port2 = 61717
      break
    case "next":
      port1 = 61620
      port2 = 61621
      break
    case "next_script":
      port1 = 61622
      port2 = 61623
      break
    case "preview":
      port1 = 61624
      port2 = 61625
      break
    case "preview_script":
      port1 = 61626
      port2 = 61627
      break
    case "beta":
      port1 = 61628
      port2 = 61629
      break
    case "beta_script":
      port1 = 61630
      port2 = 61631
      break
    case "development":
      port1 = 61632
      port2 = 61633
      break
    case "development_script":
      port1 = 61634
      port2 = 61635
      break
    case "test":
      port1 = 61636
      port2 = 61637
      break
    case "test_script":
      port1 = 61638
      port2 = 61639
      break
  }

  println "Starting ActiveMQ service for ${GrailsUtil.environment} on ports ${port1}, ${port2}"
  jmsBroker(XBeanBrokerService) {
    useJmx = 'false'
    persistent = 'false'
    transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:${port1}'))]
  }

  connectionFactory(ActiveMQConnectionFactory) {
    brokerURL = "vm://localhost:${port2}"
  }

  jmsTemplate(JmsTemplate) {
    connectionFactory = { SingleConnectionFactory cf ->
      targetConnectionFactory = ref('connectionFactory')
    }
  }
  jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
    brokerURL = "vm://localhost:${port1}"
  }
  jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
    bean.destroyMethod = "stop"
    connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
      brokerURL = "vm://localhost:${port1}"
    }
  }
}
