
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfACCT_LETTERS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfACCT_LETTERS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACCT_LETTERS" type="{http://www.centershift.com/STORE40/}ACCT_LETTERS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfACCT_LETTERS", propOrder = {
    "acctletters"
})
public class ArrayOfACCTLETTERS {

    @XmlElement(name = "ACCT_LETTERS", nillable = true)
    protected List<ACCTLETTERS> acctletters;

    /**
     * Gets the value of the acctletters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acctletters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getACCTLETTERS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ACCTLETTERS }
     * 
     * 
     */
    public List<ACCTLETTERS> getACCTLETTERS() {
        if (acctletters == null) {
            acctletters = new ArrayList<ACCTLETTERS>();
        }
        return this.acctletters;
    }

}
