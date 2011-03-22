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
 *         &lt;element name="AddUpdatePCDResult" type="{http://www.centershift.com/STORE40/}AddUpdatePCD_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "addUpdatePCDResult"
})
@XmlRootElement(name = "AddUpdatePCDResponse")
public class AddUpdatePCDResponse {

    @XmlElement(name = "AddUpdatePCDResult", required = true)
    protected AddUpdatePCDResponse2 addUpdatePCDResult;

    /**
     * Gets the value of the addUpdatePCDResult property.
     *
     * @return possible object is
     *         {@link AddUpdatePCDResponse2 }
     */
    public AddUpdatePCDResponse2 getAddUpdatePCDResult() {
        return addUpdatePCDResult;
    }

    /**
     * Sets the value of the addUpdatePCDResult property.
     *
     * @param value allowed object is
     *              {@link AddUpdatePCDResponse2 }
     */
    public void setAddUpdatePCDResult(AddUpdatePCDResponse2 value) {
        this.addUpdatePCDResult = value;
    }

}
