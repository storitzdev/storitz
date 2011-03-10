
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreateSiteTaskResult" type="{http://www.centershift.com/STORE40/}CreateSiteTask_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "createSiteTaskResult"
})
@XmlRootElement(name = "CreateSiteTaskResponse")
public class CreateSiteTaskResponse {

    @XmlElement(name = "CreateSiteTaskResult", required = true)
    protected CreateSiteTaskResponse2 createSiteTaskResult;

    /**
     * Gets the value of the createSiteTaskResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreateSiteTaskResponse2 }
     *     
     */
    public CreateSiteTaskResponse2 getCreateSiteTaskResult() {
        return createSiteTaskResult;
    }

    /**
     * Sets the value of the createSiteTaskResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateSiteTaskResponse2 }
     *     
     */
    public void setCreateSiteTaskResult(CreateSiteTaskResponse2 value) {
        this.createSiteTaskResult = value;
    }

}
