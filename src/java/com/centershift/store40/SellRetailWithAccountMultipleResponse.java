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
 *         &lt;element name="SellRetailWithAccountMultipleResult" type="{http://www.centershift.com/STORE40/}SellRetailMultiple_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sellRetailWithAccountMultipleResult"
})
@XmlRootElement(name = "SellRetailWithAccountMultipleResponse")
public class SellRetailWithAccountMultipleResponse {

    @XmlElement(name = "SellRetailWithAccountMultipleResult", required = true)
    protected SellRetailMultipleResponse sellRetailWithAccountMultipleResult;

    /**
     * Gets the value of the sellRetailWithAccountMultipleResult property.
     *
     * @return possible object is
     *         {@link SellRetailMultipleResponse }
     */
    public SellRetailMultipleResponse getSellRetailWithAccountMultipleResult() {
        return sellRetailWithAccountMultipleResult;
    }

    /**
     * Sets the value of the sellRetailWithAccountMultipleResult property.
     *
     * @param value allowed object is
     *              {@link SellRetailMultipleResponse }
     */
    public void setSellRetailWithAccountMultipleResult(SellRetailMultipleResponse value) {
        this.sellRetailWithAccountMultipleResult = value;
    }

}
