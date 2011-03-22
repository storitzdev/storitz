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
 *         &lt;element name="IsPartialPaymentAllowedResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "isPartialPaymentAllowedResult"
})
@XmlRootElement(name = "IsPartialPaymentAllowedResponse")
public class IsPartialPaymentAllowedResponse {

    @XmlElement(name = "IsPartialPaymentAllowedResult")
    protected boolean isPartialPaymentAllowedResult;

    /**
     * Gets the value of the isPartialPaymentAllowedResult property.
     */
    public boolean isIsPartialPaymentAllowedResult() {
        return isPartialPaymentAllowedResult;
    }

    /**
     * Sets the value of the isPartialPaymentAllowedResult property.
     */
    public void setIsPartialPaymentAllowedResult(boolean value) {
        this.isPartialPaymentAllowedResult = value;
    }

}
