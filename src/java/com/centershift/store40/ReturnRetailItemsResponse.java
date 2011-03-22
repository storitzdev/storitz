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
 *         &lt;element name="ReturnRetailItemsResult" type="{http://www.centershift.com/STORE40/}ReturnRetailItems_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "returnRetailItemsResult"
})
@XmlRootElement(name = "ReturnRetailItemsResponse")
public class ReturnRetailItemsResponse {

    @XmlElement(name = "ReturnRetailItemsResult", required = true)
    protected ReturnRetailItemsResponse2 returnRetailItemsResult;

    /**
     * Gets the value of the returnRetailItemsResult property.
     *
     * @return possible object is
     *         {@link ReturnRetailItemsResponse2 }
     */
    public ReturnRetailItemsResponse2 getReturnRetailItemsResult() {
        return returnRetailItemsResult;
    }

    /**
     * Sets the value of the returnRetailItemsResult property.
     *
     * @param value allowed object is
     *              {@link ReturnRetailItemsResponse2 }
     */
    public void setReturnRetailItemsResult(ReturnRetailItemsResponse2 value) {
        this.returnRetailItemsResult = value;
    }

}
