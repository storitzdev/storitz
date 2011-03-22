package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAvailableDiscounts_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetAvailableDiscounts_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfAPPL_BEST_PCD" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAvailableDiscounts_Response", propOrder = {
        "details"
})
public class GetAvailableDiscountsResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfAPPLBESTPCD details;

    /**
     * Gets the value of the details property.
     *
     * @return possible object is
     *         {@link ArrayOfAPPLBESTPCD }
     */
    public ArrayOfAPPLBESTPCD getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAPPLBESTPCD }
     */
    public void setDetails(ArrayOfAPPLBESTPCD value) {
        this.details = value;
    }

}
