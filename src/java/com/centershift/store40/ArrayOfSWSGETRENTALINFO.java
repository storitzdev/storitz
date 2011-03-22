package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfSWS_GET_RENTAL_INFO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfSWS_GET_RENTAL_INFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SWS_GET_RENTAL_INFO" type="{http://www.centershift.com/STORE40/}SWS_GET_RENTAL_INFO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSWS_GET_RENTAL_INFO", propOrder = {
        "swsgetrentalinfo"
})
public class ArrayOfSWSGETRENTALINFO {

    @XmlElement(name = "SWS_GET_RENTAL_INFO", nillable = true)
    protected List<SWSGETRENTALINFO> swsgetrentalinfo;

    /**
     * Gets the value of the swsgetrentalinfo property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the swsgetrentalinfo property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSWSGETRENTALINFO().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SWSGETRENTALINFO }
     */
    public List<SWSGETRENTALINFO> getSWSGETRENTALINFO() {
        if (swsgetrentalinfo == null) {
            swsgetrentalinfo = new ArrayList<SWSGETRENTALINFO>();
        }
        return this.swsgetrentalinfo;
    }

}
