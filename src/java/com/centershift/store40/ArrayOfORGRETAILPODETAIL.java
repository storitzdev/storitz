
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfORG_RETAIL_PO_DETAIL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfORG_RETAIL_PO_DETAIL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_RETAIL_PO_DETAIL" type="{http://www.centershift.com/STORE40/}ORG_RETAIL_PO_DETAIL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfORG_RETAIL_PO_DETAIL", propOrder = {
    "orgretailpodetail"
})
public class ArrayOfORGRETAILPODETAIL {

    @XmlElement(name = "ORG_RETAIL_PO_DETAIL", nillable = true)
    protected List<ORGRETAILPODETAIL> orgretailpodetail;

    /**
     * Gets the value of the orgretailpodetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgretailpodetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getORGRETAILPODETAIL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ORGRETAILPODETAIL }
     * 
     * 
     */
    public List<ORGRETAILPODETAIL> getORGRETAILPODETAIL() {
        if (orgretailpodetail == null) {
            orgretailpodetail = new ArrayList<ORGRETAILPODETAIL>();
        }
        return this.orgretailpodetail;
    }

}
