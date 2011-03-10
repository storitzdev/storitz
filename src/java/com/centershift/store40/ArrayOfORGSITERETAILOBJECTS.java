
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfORG_SITE_RETAIL_OBJECTS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfORG_SITE_RETAIL_OBJECTS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_SITE_RETAIL_OBJECTS" type="{http://www.centershift.com/STORE40/}ORG_SITE_RETAIL_OBJECTS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_SITE_RETAIL_OBJECTS", propOrder = {
    "orgsiteretailobjects"
})
public class ArrayOfORGSITERETAILOBJECTS {

    @XmlElement(name = "ORG_SITE_RETAIL_OBJECTS", nillable = true)
    protected List<ORGSITERETAILOBJECTS> orgsiteretailobjects;

    /**
     * Gets the value of the orgsiteretailobjects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgsiteretailobjects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGSITERETAILOBJECTS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGSITERETAILOBJECTS }
     * 
     * 
     */
    public List<ORGSITERETAILOBJECTS> getORGSITERETAILOBJECTS() {
        if (orgsiteretailobjects == null) {
            orgsiteretailobjects = new ArrayList<ORGSITERETAILOBJECTS>();
        }
        return this.orgsiteretailobjects;
    }

}
