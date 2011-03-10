
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTenantLetterList_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTenantLetterList_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TntLtrCol" type="{http://www.centershift.com/STORE40/}ArrayOfPOST_LTR_TNT_INFO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTenantLetterList_Response", propOrder = {
    "tntLtrCol"
})
public class GetTenantLetterListResponse2 {

    @XmlElement(name = "TntLtrCol")
    protected ArrayOfPOSTLTRTNTINFO tntLtrCol;

    /**
     * Gets the value of the tntLtrCol property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPOSTLTRTNTINFO }
     *     
     */
    public ArrayOfPOSTLTRTNTINFO getTntLtrCol() {
        return tntLtrCol;
    }

    /**
     * Sets the value of the tntLtrCol property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPOSTLTRTNTINFO }
     *     
     */
    public void setTntLtrCol(ArrayOfPOSTLTRTNTINFO value) {
        this.tntLtrCol = value;
    }

}
