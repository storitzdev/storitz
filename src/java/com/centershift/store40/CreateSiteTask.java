
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
 *         &lt;element name="LookupUser_Request" type="{http://www.centershift.com/STORE40/}LookupUser_Request"/>
 *         &lt;element name="CreateSiteTaskReq" type="{http://www.centershift.com/STORE40/}CreateSiteTask_Request"/>
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
    "lookupUserRequest",
    "createSiteTaskReq"
})
@XmlRootElement(name = "CreateSiteTask")
public class CreateSiteTask {

    @XmlElement(name = "LookupUser_Request", required = true)
    protected LookupUserRequest lookupUserRequest;
    @XmlElement(name = "CreateSiteTaskReq", required = true)
    protected CreateSiteTaskRequest createSiteTaskReq;

    /**
     * Gets the value of the lookupUserRequest property.
     * 
     * @return
     *     possible object is
     *     {@link LookupUserRequest }
     *     
     */
    public LookupUserRequest getLookupUserRequest() {
        return lookupUserRequest;
    }

    /**
     * Sets the value of the lookupUserRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookupUserRequest }
     *     
     */
    public void setLookupUserRequest(LookupUserRequest value) {
        this.lookupUserRequest = value;
    }

    /**
     * Gets the value of the createSiteTaskReq property.
     * 
     * @return
     *     possible object is
     *     {@link CreateSiteTaskRequest }
     *     
     */
    public CreateSiteTaskRequest getCreateSiteTaskReq() {
        return createSiteTaskReq;
    }

    /**
     * Sets the value of the createSiteTaskReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateSiteTaskRequest }
     *     
     */
    public void setCreateSiteTaskReq(CreateSiteTaskRequest value) {
        this.createSiteTaskReq = value;
    }

}
