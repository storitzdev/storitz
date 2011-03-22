package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfSOA_SITE_ATTRIBUTES complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfSOA_SITE_ATTRIBUTES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOA_SITE_ATTRIBUTES" type="{http://www.centershift.com/STORE40/}SOA_SITE_ATTRIBUTES" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSOA_SITE_ATTRIBUTES", propOrder = {
        "soasiteattributes"
})
public class ArrayOfSOASITEATTRIBUTES {

    @XmlElement(name = "SOA_SITE_ATTRIBUTES", nillable = true)
    protected List<SOASITEATTRIBUTES> soasiteattributes;

    /**
     * Gets the value of the soasiteattributes property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soasiteattributes property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOASITEATTRIBUTES().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SOASITEATTRIBUTES }
     */
    public List<SOASITEATTRIBUTES> getSOASITEATTRIBUTES() {
        if (soasiteattributes == null) {
            soasiteattributes = new ArrayList<SOASITEATTRIBUTES>();
        }
        return this.soasiteattributes;
    }

}
