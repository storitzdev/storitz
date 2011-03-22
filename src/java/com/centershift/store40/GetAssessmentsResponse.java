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
 *         &lt;element name="GetAssessmentsResult" type="{http://www.centershift.com/STORE40/}GetAssessments_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAssessmentsResult"
})
@XmlRootElement(name = "GetAssessmentsResponse")
public class GetAssessmentsResponse {

    @XmlElement(name = "GetAssessmentsResult", required = true)
    protected GetAssessmentsResponse2 getAssessmentsResult;

    /**
     * Gets the value of the getAssessmentsResult property.
     *
     * @return possible object is
     *         {@link GetAssessmentsResponse2 }
     */
    public GetAssessmentsResponse2 getGetAssessmentsResult() {
        return getAssessmentsResult;
    }

    /**
     * Sets the value of the getAssessmentsResult property.
     *
     * @param value allowed object is
     *              {@link GetAssessmentsResponse2 }
     */
    public void setGetAssessmentsResult(GetAssessmentsResponse2 value) {
        this.getAssessmentsResult = value;
    }

}
