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
 *         &lt;element name="SellRetailWithAccountResult" type="{http://www.centershift.com/STORE40/}SellRetailWithAccount_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sellRetailWithAccountResult"
})
@XmlRootElement(name = "SellRetailWithAccountResponse")
public class SellRetailWithAccountResponse {

    @XmlElement(name = "SellRetailWithAccountResult", required = true)
    protected SellRetailWithAccountResponse2 sellRetailWithAccountResult;

    /**
     * Gets the value of the sellRetailWithAccountResult property.
     *
     * @return possible object is
     *         {@link SellRetailWithAccountResponse2 }
     */
    public SellRetailWithAccountResponse2 getSellRetailWithAccountResult() {
        return sellRetailWithAccountResult;
    }

    /**
     * Sets the value of the sellRetailWithAccountResult property.
     *
     * @param value allowed object is
     *              {@link SellRetailWithAccountResponse2 }
     */
    public void setSellRetailWithAccountResult(SellRetailWithAccountResponse2 value) {
        this.sellRetailWithAccountResult = value;
    }

}
