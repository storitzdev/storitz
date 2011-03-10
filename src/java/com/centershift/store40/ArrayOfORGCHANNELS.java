
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfORG_CHANNELS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfORG_CHANNELS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_CHANNELS" type="{http://www.centershift.com/STORE40/}ORG_CHANNELS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_CHANNELS", propOrder = {
    "orgchannels"
})
public class ArrayOfORGCHANNELS {

    @XmlElement(name = "ORG_CHANNELS", nillable = true)
    protected List<ORGCHANNELS> orgchannels;

    /**
     * Gets the value of the orgchannels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgchannels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGCHANNELS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGCHANNELS }
     * 
     * 
     */
    public List<ORGCHANNELS> getORGCHANNELS() {
        if (orgchannels == null) {
            orgchannels = new ArrayList<ORGCHANNELS>();
        }
        return this.orgchannels;
    }

}
