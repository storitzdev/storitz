package com.centershift.store40;

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
 *         &lt;element name="VoidTransactionResult" type="{http://www.centershift.com/STORE40/}VoidTransaction_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "voidTransactionResult"
})
@XmlRootElement(name = "VoidTransactionResponse")
public class VoidTransactionResponse {

    @XmlElement(name = "VoidTransactionResult", required = true)
    protected VoidTransactionResponse2 voidTransactionResult;

    /**
     * Gets the value of the voidTransactionResult property.
     *
     * @return possible object is
     *         {@link VoidTransactionResponse2 }
     */
    public VoidTransactionResponse2 getVoidTransactionResult() {
        return voidTransactionResult;
    }

    /**
     * Sets the value of the voidTransactionResult property.
     *
     * @param value allowed object is
     *              {@link VoidTransactionResponse2 }
     */
    public void setVoidTransactionResult(VoidTransactionResponse2 value) {
        this.voidTransactionResult = value;
    }

}
