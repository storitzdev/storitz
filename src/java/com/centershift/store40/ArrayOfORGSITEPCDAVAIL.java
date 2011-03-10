
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfORG_SITE_PCD_AVAIL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfORG_SITE_PCD_AVAIL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_SITE_PCD_AVAIL" type="{http://www.centershift.com/STORE40/}ORG_SITE_PCD_AVAIL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_SITE_PCD_AVAIL", propOrder = {
    "orgsitepcdavail"
})
public class ArrayOfORGSITEPCDAVAIL {

    @XmlElement(name = "ORG_SITE_PCD_AVAIL", nillable = true)
    protected List<ORGSITEPCDAVAIL> orgsitepcdavail;

    /**
     * Gets the value of the orgsitepcdavail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgsitepcdavail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGSITEPCDAVAIL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGSITEPCDAVAIL }
     * 
     * 
     */
    public List<ORGSITEPCDAVAIL> getORGSITEPCDAVAIL() {
        if (orgsitepcdavail == null) {
            orgsitepcdavail = new ArrayList<ORGSITEPCDAVAIL>();
        }
        return this.orgsitepcdavail;
    }

}
