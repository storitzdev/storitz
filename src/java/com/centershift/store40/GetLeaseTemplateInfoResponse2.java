package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getLeaseTemplateInfo_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="getLeaseTemplateInfo_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LeaseDocCol" type="{http://www.centershift.com/STORE40/}ArrayOfPOST_LEASE_TEMPLATE_INFO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLeaseTemplateInfo_Response", propOrder = {
        "leaseDocCol"
})
public class GetLeaseTemplateInfoResponse2 {

    @XmlElement(name = "LeaseDocCol")
    protected ArrayOfPOSTLEASETEMPLATEINFO leaseDocCol;

    /**
     * Gets the value of the leaseDocCol property.
     *
     * @return possible object is
     *         {@link ArrayOfPOSTLEASETEMPLATEINFO }
     */
    public ArrayOfPOSTLEASETEMPLATEINFO getLeaseDocCol() {
        return leaseDocCol;
    }

    /**
     * Sets the value of the leaseDocCol property.
     *
     * @param value allowed object is
     *              {@link ArrayOfPOSTLEASETEMPLATEINFO }
     */
    public void setLeaseDocCol(ArrayOfPOSTLEASETEMPLATEINFO value) {
        this.leaseDocCol = value;
    }

}
