
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfACCT_CONTACT_ADDRESSES complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfACCT_CONTACT_ADDRESSES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACCT_CONTACT_ADDRESSES" type="{http://www.centershift.com/STORE40/}ACCT_CONTACT_ADDRESSES" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfACCT_CONTACT_ADDRESSES", propOrder = {
    "acctcontactaddresses"
})
public class ArrayOfACCTCONTACTADDRESSES {

    @XmlElement(name = "ACCT_CONTACT_ADDRESSES", nillable = true)
    protected List<ACCTCONTACTADDRESSES> acctcontactaddresses;

    /**
     * Gets the value of the acctcontactaddresses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acctcontactaddresses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getACCTCONTACTADDRESSES().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ACCTCONTACTADDRESSES }
     * 
     * 
     */
    public List<ACCTCONTACTADDRESSES> getACCTCONTACTADDRESSES() {
        if (acctcontactaddresses == null) {
            acctcontactaddresses = new ArrayList<ACCTCONTACTADDRESSES>();
        }
        return this.acctcontactaddresses;
    }

}
