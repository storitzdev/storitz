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
 *         &lt;element name="CreateOrUpdatePasswordResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "createOrUpdatePasswordResult"
})
@XmlRootElement(name = "CreateOrUpdatePasswordResponse")
public class CreateOrUpdatePasswordResponse {

    @XmlElement(name = "CreateOrUpdatePasswordResult")
    protected boolean createOrUpdatePasswordResult;

    /**
     * Gets the value of the createOrUpdatePasswordResult property.
     */
    public boolean isCreateOrUpdatePasswordResult() {
        return createOrUpdatePasswordResult;
    }

    /**
     * Sets the value of the createOrUpdatePasswordResult property.
     */
    public void setCreateOrUpdatePasswordResult(boolean value) {
        this.createOrUpdatePasswordResult = value;
    }

}
