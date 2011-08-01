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
}
