package storitz

import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.codehaus.groovy.grails.commons.GrailsDomainClassProperty
import org.springframework.util.StringUtils

//NOTE: this class is merely a way of contributing the code within it.  Ideally, smartDeepCopyDomainObject would be implemented instead as a
// dynamically injected clone() method onto GORM objects.
/* @author David Smiley, dsmiley@mitre.org */
class BeanUtils {
   /**
    * Does a deep clone of a domain object, recursively deep-cloning references but only those relationships
    * "owned" by the referent.  Those not owned simply have their reference copied.
    * @param subject the domain object to be cloned
    * @param target the target domain object which will receive subject's properties. Optional and if null
    *  will be a new copy of subject's class.
    * @return returns target
    */
   static Object smartDeepCopyDomainObject(subject, target=null) {
      assert subject != null
      def gdc = ApplicationHolder.application.getDomainClass(subject.class.name)
      def persistentProperties = findPersistentProperties(gdc)
      if (target == null) {
         target = subject.class.newInstance()
      } else if (target.class != subject.class){
         def tPPNames = findPersistentProperties(ApplicationHolder.application.getDomainClass(target.class.name)).name
         persistentProperties = persistentProperties.findAll { tPPNames.contains it.name }
      }

      for ( GrailsDomainClassProperty prop in persistentProperties) {
         def curVal = subject[prop.name]
         if (curVal == null)
            continue; //nothing to do
         def newVal = null
         if (prop.association) {
            //create toMany collection/map
            if (SortedSet.isAssignableFrom(prop.type)) {
               newVal = new TreeSet();
            } else if (Set.isAssignableFrom(prop.type)) {
               newVal = new HashSet();
            } else if (Map.isAssignableFrom(prop.type)) {
               throw new IllegalStateException("maps aren't supported")
            } else if (List.isAssignableFrom(prop.type)) {
               newVal = new ArrayList()
            } else if (Collection.isAssignableFrom(prop.type)) {
               throw new IllegalStateException("don't know how to support: ${prop.type}")
            }
            boolean toMany = (newVal != null)

            Closure mover;
            if (prop.owningSide)
               mover = { subj -> smartDeepCopyDomainObject(subj) }
            else
               mover = { subj -> subj }
            if (toMany)
               curVal.each { newVal.add( mover(it) ) }
            else
               newVal = mover(curVal)
         } else {
            newVal = curVal
         }
         //do it
         target[prop.name] = newVal
      }
      return target
   }

   //Shouldn't have to do this! http://jira.codehaus.org/browse/GRAILS-3531
   static List findPersistentProperties(GrailsDomainClass gdc) {
      def persistentProperties = new ArrayList(gdc.persistentProperties as List)
      def transientNames = new HashSet()
      while (true) {
         transientNames.addAll(gdc.getPropertyValue( "transients", List ))
         if (gdc.isRoot())
            break;
         gdc = ApplicationHolder.application.getDomainClass(gdc.clazz.superclass.name)
      }
      return persistentProperties.findAll{ ! transientNames.contains(it.name) }
   }

  /*
 * Clones a domain object and recursively clones children, clearing ids and
 * attaching children to their new parents. Ownership relationships (indicated
 * by GORM belongsTo keyword) cause "copy as new" (a recursive deep clone),
 * but associations without ownership are shallow copied by reference.
 */
  static deepClone(domainInstanceToClone){

    //Our target instance for the instance we want to clone
    def newDomainInstance = domainInstanceToClone.getClass().newInstance()

    //Returns a DefaultGrailsDomainClass (as interface GrailsDomainClass) for inspecting properties
    def domainClass = ApplicationHolder.application.getDomainClass(newDomainInstance.getClass().name)

    domainClass?.persistentProperties.each{prop ->
        if(prop.association){
            if(prop.owningSide){
                //we have to deep clone owned associations
                if(prop.oneToOne){
                    if (domainInstanceToClone."${prop.name}") {
                      def newAssociationInstance = deepClone(domainInstanceToClone."${prop.name}")
                      newDomainInstance."${prop.name}" = newAssociationInstance
                    }
                }
                else{
                    domainInstanceToClone."${prop.name}".each{ associationInstance ->
                        def newAssociationInstance = deepClone(associationInstance)
                        newDomainInstance."addTo${StringUtils.capitalize(prop.name)}"(newAssociationInstance)
                    }
                }
            }
            else{
                if(!prop.bidirectional){
                    //If the association isn't owned or the owner, then we can just do a  shallow copy of the reference.
                    newDomainInstance."${prop.name}" = domainInstanceToClone."${prop.name}"
                }
                else {
                  println "Skipping prop ${prop.name} - prop info = ${prop.dump()}"
                }
            }
        }
        else{
            //If the property isn't an association then simply copy the value
            newDomainInstance."${prop.name}" = domainInstanceToClone."${prop.name}"
        }
    }

    return newDomainInstance
  }
}
