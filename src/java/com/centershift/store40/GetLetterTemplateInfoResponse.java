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
 *         &lt;element name="getLetterTemplateInfoResult" type="{http://www.centershift.com/STORE40/}getLtrTemplateInfo_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getLetterTemplateInfoResult"
})
@XmlRootElement(name = "getLetterTemplateInfoResponse")
public class GetLetterTemplateInfoResponse {

    @XmlElement(required = true)
    protected GetLtrTemplateInfoResponse getLetterTemplateInfoResult;

    /**
     * Gets the value of the getLetterTemplateInfoResult property.
     *
     * @return possible object is
     *         {@link GetLtrTemplateInfoResponse }
     */
    public GetLtrTemplateInfoResponse getGetLetterTemplateInfoResult() {
        return getLetterTemplateInfoResult;
    }

    /**
     * Sets the value of the getLetterTemplateInfoResult property.
     *
     * @param value allowed object is
     *              {@link GetLtrTemplateInfoResponse }
     */
    public void setGetLetterTemplateInfoResult(GetLtrTemplateInfoResponse value) {
        this.getLetterTemplateInfoResult = value;
    }

}
