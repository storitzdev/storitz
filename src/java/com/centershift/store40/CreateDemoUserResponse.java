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
 *         &lt;element name="CreateDemoUserResult" type="{http://www.centershift.com/STORE40/}CreateDemoUser_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "createDemoUserResult"
})
@XmlRootElement(name = "CreateDemoUserResponse")
public class CreateDemoUserResponse {

    @XmlElement(name = "CreateDemoUserResult", required = true)
    protected CreateDemoUserResponse2 createDemoUserResult;

    /**
     * Gets the value of the createDemoUserResult property.
     *
     * @return possible object is
     *         {@link CreateDemoUserResponse2 }
     */
    public CreateDemoUserResponse2 getCreateDemoUserResult() {
        return createDemoUserResult;
    }

    /**
     * Sets the value of the createDemoUserResult property.
     *
     * @param value allowed object is
     *              {@link CreateDemoUserResponse2 }
     */
    public void setCreateDemoUserResult(CreateDemoUserResponse2 value) {
        this.createDemoUserResult = value;
    }

}
