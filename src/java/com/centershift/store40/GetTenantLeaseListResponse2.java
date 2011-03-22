package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTenantLeaseList_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="getTenantLeaseList_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TntLeaseCol" type="{http://www.centershift.com/STORE40/}ArrayOfPOST_LEASE_TNT_INFO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTenantLeaseList_Response", propOrder = {
        "tntLeaseCol"
})
public class GetTenantLeaseListResponse2 {

    @XmlElement(name = "TntLeaseCol")
    protected ArrayOfPOSTLEASETNTINFO tntLeaseCol;

    /**
     * Gets the value of the tntLeaseCol property.
     *
     * @return possible object is
     *         {@link ArrayOfPOSTLEASETNTINFO }
     */
    public ArrayOfPOSTLEASETNTINFO getTntLeaseCol() {
        return tntLeaseCol;
    }

    /**
     * Sets the value of the tntLeaseCol property.
     *
     * @param value allowed object is
     *              {@link ArrayOfPOSTLEASETNTINFO }
     */
    public void setTntLeaseCol(ArrayOfPOSTLEASETNTINFO value) {
        this.tntLeaseCol = value;
    }

}
