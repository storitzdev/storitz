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

  switch (GrailsUtil.environment) {
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
        connectionFactory = { SingleConnectionFactory cf ->
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

    // for production_script the actual ports do not matter, as long as they don't conflict with the real values
    case "production_script":
      println "Starting production_script ActiveMQ 61719"
      jmsBroker(XBeanBrokerService) {
        useJmx = 'false'
        persistent = 'false'
        transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61719'))]
      }

      connectionFactory(ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61717"
      }

      jmsTemplate(JmsTemplate) {
        connectionFactory = { SingleConnectionFactory cf ->
          targetConnectionFactory = ref('connectionFactory')
        }
      }
      jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61719"
      }
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
        bean.destroyMethod = "stop"
        connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
          brokerURL = "vm://localhost:61719"
        }
      }
      break

    case "next":
      println "Starting 'next' ActiveMQ 61620"
      jmsBroker(XBeanBrokerService) {
        useJmx = 'false'
        persistent = 'false'
        transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61620'))]
      }

      connectionFactory(ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61617"
      }

      jmsTemplate(JmsTemplate) {
        connectionFactory = { SingleConnectionFactory cf ->
          targetConnectionFactory = ref('connectionFactory')
        }
      }
      jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61620"
      }
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
        bean.destroyMethod = "stop"
        connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
          brokerURL = "vm://localhost:61620"
        }
      }
      break

    case "next_script":
      println "Starting 'next_script' ActiveMQ 61621"
      jmsBroker(XBeanBrokerService) {
        useJmx = 'false'
        persistent = 'false'
        transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61621'))]
      }

      connectionFactory(ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61617"
      }

      jmsTemplate(JmsTemplate) {
        connectionFactory = { SingleConnectionFactory cf ->
          targetConnectionFactory = ref('connectionFactory')
        }
      }
      jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61621"
      }
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
        bean.destroyMethod = "stop"
        connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
          brokerURL = "vm://localhost:61621"
        }
      }
      break

    case "preview":
      println "Starting preview ActiveMQ 61610"
      jmsBroker(XBeanBrokerService) {
        useJmx = 'false'
        persistent = 'false'
        transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61610'))]
      }

      connectionFactory(ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61617"
      }

      jmsTemplate(JmsTemplate) {
        connectionFactory = { SingleConnectionFactory cf ->
          targetConnectionFactory = ref('connectionFactory')
        }
      }
      jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = "vm://localhost:61610"
      }
      jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
        bean.destroyMethod = "stop"
        connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
          brokerURL = "vm://localhost:61610"
        }
      }
      break

      // for preview_script the actual ports do not matter, as long as they don't conflict with the real values
      case "preview_script":
        println "Starting preview_script ActiveMQ 61710"
        jmsBroker(XBeanBrokerService) {
          useJmx = 'false'
          persistent = 'false'
          transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61710'))]
        }

        connectionFactory(ActiveMQConnectionFactory) {
          brokerURL = "vm://localhost:61717"
        }

        jmsTemplate(JmsTemplate) {
          connectionFactory = { SingleConnectionFactory cf ->
            targetConnectionFactory = ref('connectionFactory')
          }
        }
        jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
          brokerURL = "vm://localhost:61710"
        }
        jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
          bean.destroyMethod = "stop"
          connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
            brokerURL = "vm://localhost:61710"
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
        connectionFactory = { SingleConnectionFactory cf ->
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

      // for development_script the actual ports do not matter, as long as they don't conflict with the real values
      case "development_script":
        println "Starting development_script ActiveMQ 61717"
        jmsBroker(XBeanBrokerService) {
          useJmx = 'false'
          persistent = 'false'
          transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61717'))]
        }

        connectionFactory(ActiveMQConnectionFactory) {
          brokerURL = "vm://localhost:61717"
        }

        jmsTemplate(JmsTemplate) {
          connectionFactory = { SingleConnectionFactory cf ->
            targetConnectionFactory = ref('connectionFactory')
          }
        }
        jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
          brokerURL = "vm://localhost:61717"
        }
        jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
          bean.destroyMethod = "stop"
          connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
            brokerURL = "vm://localhost:61717"
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
        connectionFactory = { SingleConnectionFactory cf ->
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

      // for test_script the actual ports do not matter, as long as they don't conflict with the real values
      case "test_script":
        println "Starting test_script ActiveMQ 61718"
        jmsBroker(XBeanBrokerService) {
          useJmx = 'false'
          persistent = 'false'
          transportConnectors = [new TransportConnector(uri: new URI('tcp://localhost:61718'))]
        }

        connectionFactory(ActiveMQConnectionFactory) {
          brokerURL = "vm://localhost:61718"
        }

        jmsTemplate(JmsTemplate) {
          connectionFactory = { SingleConnectionFactory cf ->
            targetConnectionFactory = ref('connectionFactory')
          }
        }
        jmsFactory(org.apache.activemq.ActiveMQConnectionFactory) {
          brokerURL = "vm://localhost:61718"
        }
        jmsConnectionFactory(org.apache.activemq.pool.PooledConnectionFactory) { bean ->
          bean.destroyMethod = "stop"
          connectionFactory = { org.apache.activemq.ActiveMQConnectionFactory cf ->
            brokerURL = "vm://localhost:61718"
          }
        }
        break
  }
}
