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
 *         &lt;element name="TerminateServiceResult" type="{http://www.centershift.com/STORE40/}TerminateService_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "terminateServiceResult"
})
@XmlRootElement(name = "TerminateServiceResponse")
public class TerminateServiceResponse {

    @XmlElement(name = "TerminateServiceResult", required = true)
    protected TerminateServiceResponse2 terminateServiceResult;

    /**
     * Gets the value of the terminateServiceResult property.
     *
     * @return possible object is
     *         {@link TerminateServiceResponse2 }
     */
    public TerminateServiceResponse2 getTerminateServiceResult() {
        return terminateServiceResult;
    }

    /**
     * Sets the value of the terminateServiceResult property.
     *
     * @param value allowed object is
     *              {@link TerminateServiceResponse2 }
     */
    public void setTerminateServiceResult(TerminateServiceResponse2 value) {
        this.terminateServiceResult = value;
    }

}
