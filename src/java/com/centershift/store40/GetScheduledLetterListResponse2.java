package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getScheduledLetterList_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="getScheduledLetterList_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TntSchedLtrsCol" type="{http://www.centershift.com/STORE40/}ArrayOfPOST_SCHEDULE_LTR_TNT_INFO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getScheduledLetterList_Response", propOrder = {
        "tntSchedLtrsCol"
})
public class GetScheduledLetterListResponse2 {

    @XmlElement(name = "TntSchedLtrsCol")
    protected ArrayOfPOSTSCHEDULELTRTNTINFO tntSchedLtrsCol;

    /**
     * Gets the value of the tntSchedLtrsCol property.
     *
     * @return possible object is
     *         {@link ArrayOfPOSTSCHEDULELTRTNTINFO }
     */
    public ArrayOfPOSTSCHEDULELTRTNTINFO getTntSchedLtrsCol() {
        return tntSchedLtrsCol;
    }

    /**
     * Sets the value of the tntSchedLtrsCol property.
     *
     * @param value allowed object is
     *              {@link ArrayOfPOSTSCHEDULELTRTNTINFO }
     */
    public void setTntSchedLtrsCol(ArrayOfPOSTSCHEDULELTRTNTINFO value) {
        this.tntSchedLtrsCol = value;
    }

}
