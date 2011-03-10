
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSOA_GET_ASSESSMENTS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSOA_GET_ASSESSMENTS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOA_GET_ASSESSMENTS" type="{http://www.centershift.com/STORE40/}SOA_GET_ASSESSMENTS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSOA_GET_ASSESSMENTS", propOrder = {
    "soagetassessments"
})
public class ArrayOfSOAGETASSESSMENTS {

    @XmlElement(name = "SOA_GET_ASSESSMENTS", nillable = true)
    protected List<SOAGETASSESSMENTS> soagetassessments;

    /**
     * Gets the value of the soagetassessments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soagetassessments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOAGETASSESSMENTS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SOAGETASSESSMENTS }
     * 
     * 
     */
    public List<SOAGETASSESSMENTS> getSOAGETASSESSMENTS() {
        if (soagetassessments == null) {
            soagetassessments = new ArrayList<SOAGETASSESSMENTS>();
        }
        return this.soagetassessments;
    }

}
