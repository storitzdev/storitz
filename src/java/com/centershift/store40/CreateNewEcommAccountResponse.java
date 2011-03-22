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
 *         &lt;element name="CreateNewEcommAccountResult" type="{http://www.centershift.com/STORE40/}CreateNewEcommAccount_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "createNewEcommAccountResult"
})
@XmlRootElement(name = "CreateNewEcommAccountResponse")
public class CreateNewEcommAccountResponse {

    @XmlElement(name = "CreateNewEcommAccountResult", required = true)
    protected CreateNewEcommAccountResponse2 createNewEcommAccountResult;

    /**
     * Gets the value of the createNewEcommAccountResult property.
     *
     * @return possible object is
     *         {@link CreateNewEcommAccountResponse2 }
     */
    public CreateNewEcommAccountResponse2 getCreateNewEcommAccountResult() {
        return createNewEcommAccountResult;
    }

    /**
     * Sets the value of the createNewEcommAccountResult property.
     *
     * @param value allowed object is
     *              {@link CreateNewEcommAccountResponse2 }
     */
    public void setCreateNewEcommAccountResult(CreateNewEcommAccountResponse2 value) {
        this.createNewEcommAccountResult = value;
    }

}
