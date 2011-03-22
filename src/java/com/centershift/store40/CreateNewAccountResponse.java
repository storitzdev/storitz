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
 *         &lt;element name="CreateNewAccountResult" type="{http://www.centershift.com/STORE40/}structCreateAccount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "createNewAccountResult"
})
@XmlRootElement(name = "CreateNewAccountResponse")
public class CreateNewAccountResponse {

    @XmlElement(name = "CreateNewAccountResult", required = true)
    protected StructCreateAccount createNewAccountResult;

    /**
     * Gets the value of the createNewAccountResult property.
     *
     * @return possible object is
     *         {@link StructCreateAccount }
     */
    public StructCreateAccount getCreateNewAccountResult() {
        return createNewAccountResult;
    }

    /**
     * Sets the value of the createNewAccountResult property.
     *
     * @param value allowed object is
     *              {@link StructCreateAccount }
     */
    public void setCreateNewAccountResult(StructCreateAccount value) {
        this.createNewAccountResult = value;
    }

}
