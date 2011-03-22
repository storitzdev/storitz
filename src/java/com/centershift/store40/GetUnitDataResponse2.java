package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetUnitData_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetUnitData_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfAPPL_RENTAL_OBJECTS_DETAIL" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUnitData_Response", propOrder = {
        "details"
})
public class GetUnitDataResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfAPPLRENTALOBJECTSDETAIL details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfAPPLRENTALOBJECTSDETAIL }
     */
    public ArrayOfAPPLRENTALOBJECTSDETAIL getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAPPLRENTALOBJECTSDETAIL }
     */
    public void setDetails(ArrayOfAPPLRENTALOBJECTSDETAIL value) {
        this.details = value;
    }

}
