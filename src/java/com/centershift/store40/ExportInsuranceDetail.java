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
 *         &lt;element name="Request" type="{http://www.centershift.com/STORE40/}ExportInsuranceDetail_Request"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "request"
})
@XmlRootElement(name = "ExportInsuranceDetail")
public class ExportInsuranceDetail {

    @XmlElement(name = "Request", required = true)
    protected ExportInsuranceDetailRequest request;

    /**
     * Gets the value of the request property.
     *
     * @return possible object is
     *         {@link ExportInsuranceDetailRequest }
     */
    public ExportInsuranceDetailRequest getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     *
     * @param value allowed object is
     *              {@link ExportInsuranceDetailRequest }
     */
    public void setRequest(ExportInsuranceDetailRequest value) {
        this.request = value;
    }

}
