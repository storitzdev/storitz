package storitz

// CustomDomainMarshaller.groovy in src/groovy:
import grails.converters.JSON;
import org.codehaus.groovy.grails.web.converters.ConverterUtil;
import org.codehaus.groovy.grails.web.converters.exceptions.ConverterException;
import org.codehaus.groovy.grails.web.converters.marshaller.json.DeepDomainClassMarshaller
import org.codehaus.groovy.grails.web.json.JSONWriter;
import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl
import org.codehaus.groovy.grails.commons.GrailsDomainClassProperty
import org.codehaus.groovy.grails.support.proxy.DefaultProxyHandler
import org.codehaus.groovy.grails.support.proxy.ProxyHandler
import org.codehaus.groovy.grails.commons.GrailsClassUtils;

public class CustomDomainMarshaller extends DeepDomainClassMarshaller {

  static EXCLUDED = ['metaClass','class','id','version']

  ProxyHandler proxyHandler

  public CustomDomainMarshaller() {
    super(false, new DefaultProxyHandler())
    // It would be better if proxyHandler were exposed as protected rather than private
    proxyHandler = new DefaultProxyHandler()
  }

  public boolean supports(Object object) {
      return ConverterUtil.isDomainClass(object.getClass());
  }

  public void marshalObject(Object value, JSON json) throws ConverterException {
      JSONWriter writer = json.getWriter();
      value = proxyHandler.unwrapIfProxy(value);
      Class clazz = value.getClass();
      GrailsDomainClass domainClass = ConverterUtil.getDomainClass(clazz.getName());
      BeanWrapper beanWrapper = new BeanWrapperImpl(value);

      writer.object();
      GrailsDomainClassProperty[] properties = domainClass.getPersistentProperties();

      for (GrailsDomainClassProperty property : properties) {
        writer.key(property.getName());
        String name = property.getName();
        if(!EXCLUDED.contains(name)) {
          if (!property.isAssociation()) {
              // Write non-relation property
              Object val = beanWrapper.getPropertyValue(property.getName());
              json.convertAnother(val);
          } else {
              Object referenceObject = beanWrapper.getPropertyValue(property.getName());
              if (isRenderDomainClassRelations()) {
                  if (referenceObject == null) {
                      writer.value(null);
                  } else {
                      referenceObject = proxyHandler.unwrapIfProxy(referenceObject);
                      if (referenceObject instanceof SortedMap) {
                          referenceObject = new TreeMap((SortedMap) referenceObject);
                      } else if (referenceObject instanceof SortedSet) {
                          referenceObject = new TreeSet((SortedSet) referenceObject);
                      } else if (referenceObject instanceof Set) {
                          referenceObject = new HashSet((Set) referenceObject);
                      } else if (referenceObject instanceof Map) {
                          referenceObject = new HashMap((Map) referenceObject);
                      } else if (referenceObject instanceof Collection){
                          referenceObject = new ArrayList((Collection) referenceObject);
                      }
                      json.convertAnother(referenceObject);
                  }
              } else {
                  if (referenceObject == null) {
                      json.value(null);
                  } else {
                      GrailsDomainClass referencedDomainClass = property.getReferencedDomainClass();

                      // Embedded are now always fully rendered
                      if(referencedDomainClass == null || property.isEmbedded() || GrailsClassUtils.isJdk5Enum(property.getType())) {
                          json.convertAnother(referenceObject);
                      } else if (property.isOneToOne() || property.isManyToOne() || property.isEmbedded()) {
                          asShortObject(referenceObject, json, referencedDomainClass.getIdentifier(), referencedDomainClass);
                      } else {
                          GrailsDomainClassProperty referencedIdProperty = referencedDomainClass.getIdentifier();
                          String refPropertyName = referencedDomainClass.getPropertyName();
                          if (referenceObject instanceof Collection) {
                              Collection o = (Collection) referenceObject;
                              writer.array();
                              for (Object el : o) {
                                  asShortObject(el, json, referencedIdProperty, referencedDomainClass);
                              }
                              writer.endArray();

                          } else if (referenceObject instanceof Map) {
                              Map<Object, Object> map = (Map<Object, Object>) referenceObject;
                              for (Map.Entry<Object, Object> entry : map.entrySet()) {
                                  String key = String.valueOf(entry.getKey());
                                  Object o = entry.getValue();
                                  writer.object();
                                  writer.key(key);
                                  asShortObject(o, json, referencedIdProperty, referencedDomainClass);
                                  writer.endObject();
                              }
                          }
                      }
                  }
              }
          }
        }
      }
      writer.endObject();
  }
}