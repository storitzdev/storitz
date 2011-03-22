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
 *         &lt;element name="ProcessManualAutoPayResult" type="{http://www.centershift.com/STORE40/}ProcessManualAutoPay_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "processManualAutoPayResult"
})
@XmlRootElement(name = "ProcessManualAutoPayResponse")
public class ProcessManualAutoPayResponse {

    @XmlElement(name = "ProcessManualAutoPayResult", required = true)
    protected ProcessManualAutoPayResponse2 processManualAutoPayResult;

    /**
     * Gets the value of the processManualAutoPayResult property.
     *
     * @return possible object is
     *         {@link ProcessManualAutoPayResponse2 }
     */
    public ProcessManualAutoPayResponse2 getProcessManualAutoPayResult() {
        return processManualAutoPayResult;
    }

    /**
     * Sets the value of the processManualAutoPayResult property.
     *
     * @param value allowed object is
     *              {@link ProcessManualAutoPayResponse2 }
     */
    public void setProcessManualAutoPayResult(ProcessManualAutoPayResponse2 value) {
        this.processManualAutoPayResult = value;
    }

}
