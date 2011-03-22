package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfAVAIL_SITE_RETAIL_ITEMS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfAVAIL_SITE_RETAIL_ITEMS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AVAIL_SITE_RETAIL_ITEMS" type="{http://www.centershift.com/STORE40/}AVAIL_SITE_RETAIL_ITEMS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAVAIL_SITE_RETAIL_ITEMS", propOrder = {
        "availsiteretailitems"
})
public class ArrayOfAVAILSITERETAILITEMS {

    @XmlElement(name = "AVAIL_SITE_RETAIL_ITEMS", nillable = true)
    protected List<AVAILSITERETAILITEMS> availsiteretailitems;

    /**
     * Gets the value of the availsiteretailitems property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availsiteretailitems property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAVAILSITERETAILITEMS().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link AVAILSITERETAILITEMS }
     */
    public List<AVAILSITERETAILITEMS> getAVAILSITERETAILITEMS() {
        if (availsiteretailitems == null) {
            availsiteretailitems = new ArrayList<AVAILSITERETAILITEMS>();
        }
        return this.availsiteretailitems;
    }

}
