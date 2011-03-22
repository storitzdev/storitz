package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfACCT_CONTACT_PHONES complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfACCT_CONTACT_PHONES">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACCT_CONTACT_PHONES" type="{http://www.centershift.com/STORE40/}ACCT_CONTACT_PHONES" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfACCT_CONTACT_PHONES", propOrder = {
        "acctcontactphones"
})
public class ArrayOfACCTCONTACTPHONES {

    @XmlElement(name = "ACCT_CONTACT_PHONES", nillable = true)
    protected List<ACCTCONTACTPHONES> acctcontactphones;

    /**
     * Gets the value of the acctcontactphones property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acctcontactphones property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getACCTCONTACTPHONES().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ACCTCONTACTPHONES }
     */
    public List<ACCTCONTACTPHONES> getACCTCONTACTPHONES() {
        if (acctcontactphones == null) {
            acctcontactphones = new ArrayList<ACCTCONTACTPHONES>();
        }
        return this.acctcontactphones;
    }

}
