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
 *         &lt;element name="getReceiptTemplateInfoResult" type="{http://www.centershift.com/STORE40/}getLtrTemplateInfo_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getReceiptTemplateInfoResult"
})
@XmlRootElement(name = "getReceiptTemplateInfoResponse")
public class GetReceiptTemplateInfoResponse {

    @XmlElement(required = true)
    protected GetLtrTemplateInfoResponse getReceiptTemplateInfoResult;

    /**
     * Gets the value of the getReceiptTemplateInfoResult property.
     *
     * @return possible object is
     *         {@link GetLtrTemplateInfoResponse }
     */
    public GetLtrTemplateInfoResponse getGetReceiptTemplateInfoResult() {
        return getReceiptTemplateInfoResult;
    }

    /**
     * Sets the value of the getReceiptTemplateInfoResult property.
     *
     * @param value allowed object is
     *              {@link GetLtrTemplateInfoResponse }
     */
    public void setGetReceiptTemplateInfoResult(GetLtrTemplateInfoResponse value) {
        this.getReceiptTemplateInfoResult = value;
    }

}
