package org.tempuri;

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
 *         &lt;element name="SetTenantInfoResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "setTenantInfoResult"
})
@XmlRootElement(name = "SetTenantInfoResponse")
public class SetTenantInfoResponse {

    @XmlElement(name = "SetTenantInfoResult")
    protected boolean setTenantInfoResult;

    /**
     * Gets the value of the setTenantInfoResult property.
     */
    public boolean isSetTenantInfoResult() {
        return setTenantInfoResult;
    }

    /**
     * Sets the value of the setTenantInfoResult property.
     */
    public void setSetTenantInfoResult(boolean value) {
        this.setTenantInfoResult = value;
    }

}
