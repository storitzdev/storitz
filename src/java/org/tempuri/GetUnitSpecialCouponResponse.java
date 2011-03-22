package org.tempuri;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetUnitSpecialCouponResult" type="{http://tempuri.org/}ArrayOfAnyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getUnitSpecialCouponResult"
})
@XmlRootElement(name = "GetUnitSpecialCouponResponse")
public class GetUnitSpecialCouponResponse {

    @XmlElement(name = "GetUnitSpecialCouponResult")
    protected ArrayOfAnyType getUnitSpecialCouponResult;

    /**
     * Gets the value of the getUnitSpecialCouponResult property.
     *
     * @return possible object is
     *         {@link ArrayOfAnyType }
     */
    public ArrayOfAnyType getGetUnitSpecialCouponResult() {
        return getUnitSpecialCouponResult;
    }

    /**
     * Sets the value of the getUnitSpecialCouponResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAnyType }
     */
    public void setGetUnitSpecialCouponResult(ArrayOfAnyType value) {
        this.getUnitSpecialCouponResult = value;
    }

}
