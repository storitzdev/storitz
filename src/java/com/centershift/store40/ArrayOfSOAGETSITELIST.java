package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfSOA_GET_SITE_LIST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfSOA_GET_SITE_LIST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOA_GET_SITE_LIST" type="{http://www.centershift.com/STORE40/}SOA_GET_SITE_LIST" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSOA_GET_SITE_LIST", propOrder = {
        "soagetsitelist"
})
public class ArrayOfSOAGETSITELIST {

    @XmlElement(name = "SOA_GET_SITE_LIST", nillable = true)
    protected List<SOAGETSITELIST> soagetsitelist;

    /**
     * Gets the value of the soagetsitelist property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the soagetsitelist property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSOAGETSITELIST().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SOAGETSITELIST }
     */
    public List<SOAGETSITELIST> getSOAGETSITELIST() {
        if (soagetsitelist == null) {
            soagetsitelist = new ArrayList<SOAGETSITELIST>();
        }
        return this.soagetsitelist;
    }

}
