package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfSOA_ACT_INFO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfSOA_ACT_INFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOA_ACT_INFO" type="{http://www.centershift.com/STORE40/}SOA_ACT_INFO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSOA_ACT_INFO", propOrder = {
        "soaactinfo"
})
public class ArrayOfSOAACTINFO {

    @XmlElement(name = "SOA_ACT_INFO", nillable = true)
    protected List<SOAACTINFO> soaactinfo;

    /**
     * Gets the value of the soaactinfo property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soaactinfo property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOAACTINFO().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SOAACTINFO }
     */
    public List<SOAACTINFO> getSOAACTINFO() {
        if (soaactinfo == null) {
            soaactinfo = new ArrayList<SOAACTINFO>();
        }
        return this.soaactinfo;
    }

}
