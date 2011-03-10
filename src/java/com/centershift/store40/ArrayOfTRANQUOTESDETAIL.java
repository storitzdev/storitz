
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTRAN_QUOTES_DETAIL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTRAN_QUOTES_DETAIL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TRAN_QUOTES_DETAIL" type="{http://www.centershift.com/STORE40/}TRAN_QUOTES_DETAIL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTRAN_QUOTES_DETAIL", propOrder = {
    "tranquotesdetail"
})
public class ArrayOfTRANQUOTESDETAIL {

    @XmlElement(name = "TRAN_QUOTES_DETAIL", nillable = true)
    protected List<TRANQUOTESDETAIL> tranquotesdetail;

    /**
     * Gets the value of the tranquotesdetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tranquotesdetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANQUOTESDETAIL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANQUOTESDETAIL }
     * 
     * 
     */
    public List<TRANQUOTESDETAIL> getTRANQUOTESDETAIL() {
        if (tranquotesdetail == null) {
            tranquotesdetail = new ArrayList<TRANQUOTESDETAIL>();
        }
        return this.tranquotesdetail;
    }

}
