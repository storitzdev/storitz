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
 *         &lt;element name="SetTenantInfoExResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "setTenantInfoExResult"
})
@XmlRootElement(name = "SetTenantInfoExResponse")
public class SetTenantInfoExResponse {

    @XmlElement(name = "SetTenantInfoExResult")
    protected int setTenantInfoExResult;

    /**
     * Gets the value of the setTenantInfoExResult property.
     */
    public int getSetTenantInfoExResult() {
        return setTenantInfoExResult;
    }

    /**
     * Sets the value of the setTenantInfoExResult property.
     */
    public void setSetTenantInfoExResult(int value) {
        this.setTenantInfoExResult = value;
    }

}
