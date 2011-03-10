
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSOA_UNIT_FEATURES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSOA_UNIT_FEATURES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOA_UNIT_FEATURES" type="{http://www.centershift.com/STORE40/}SOA_UNIT_FEATURES" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSOA_UNIT_FEATURES", propOrder = {
    "soaunitfeatures"
})
public class ArrayOfSOAUNITFEATURES {

    @XmlElement(name = "SOA_UNIT_FEATURES", nillable = true)
    protected List<SOAUNITFEATURES> soaunitfeatures;

    /**
     * Gets the value of the soaunitfeatures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soaunitfeatures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOAUNITFEATURES().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SOAUNITFEATURES }
     * 
     * 
     */
    public List<SOAUNITFEATURES> getSOAUNITFEATURES() {
        if (soaunitfeatures == null) {
            soaunitfeatures = new ArrayList<SOAUNITFEATURES>();
        }
        return this.soaunitfeatures;
    }

}
