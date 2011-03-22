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
 *         &lt;element name="ProcessCustomerCCPaymentThreadResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "processCustomerCCPaymentThreadResult"
})
@XmlRootElement(name = "ProcessCustomerCCPaymentThreadResponse")
public class ProcessCustomerCCPaymentThreadResponse {

    @XmlElement(name = "ProcessCustomerCCPaymentThreadResult")
    protected String processCustomerCCPaymentThreadResult;

    /**
     * Gets the value of the processCustomerCCPaymentThreadResult property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getProcessCustomerCCPaymentThreadResult() {
        return processCustomerCCPaymentThreadResult;
    }

    /**
     * Sets the value of the processCustomerCCPaymentThreadResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProcessCustomerCCPaymentThreadResult(String value) {
        this.processCustomerCCPaymentThreadResult = value;
    }

}
