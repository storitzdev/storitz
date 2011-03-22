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
 *         &lt;element name="VoidMoveInResult" type="{http://www.centershift.com/STORE40/}VoidMoveIn_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "voidMoveInResult"
})
@XmlRootElement(name = "VoidMoveInResponse")
public class VoidMoveInResponse {

    @XmlElement(name = "VoidMoveInResult", required = true)
    protected VoidMoveInResponse2 voidMoveInResult;

    /**
     * Gets the value of the voidMoveInResult property.
     *
     * @return possible object is
     *         {@link VoidMoveInResponse2 }
     */
    public VoidMoveInResponse2 getVoidMoveInResult() {
        return voidMoveInResult;
    }

    /**
     * Sets the value of the voidMoveInResult property.
     *
     * @param value allowed object is
     *              {@link VoidMoveInResponse2 }
     */
    public void setVoidMoveInResult(VoidMoveInResponse2 value) {
        this.voidMoveInResult = value;
    }

}
