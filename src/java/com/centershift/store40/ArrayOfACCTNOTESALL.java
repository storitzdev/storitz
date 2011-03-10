
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfACCT_NOTES_ALL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfACCT_NOTES_ALL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACCT_NOTES_ALL" type="{http://www.centershift.com/STORE40/}ACCT_NOTES_ALL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfACCT_NOTES_ALL", propOrder = {
    "acctnotesall"
})
public class ArrayOfACCTNOTESALL {

    @XmlElement(name = "ACCT_NOTES_ALL", nillable = true)
    protected List<ACCTNOTESALL> acctnotesall;

    /**
     * Gets the value of the acctnotesall property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acctnotesall property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getACCTNOTESALL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ACCTNOTESALL }
     * 
     * 
     */
    public List<ACCTNOTESALL> getACCTNOTESALL() {
        if (acctnotesall == null) {
            acctnotesall = new ArrayList<ACCTNOTESALL>();
        }
        return this.acctnotesall;
    }

}
