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
 *         &lt;element name="AddAccountMoveInResult" type="{http://tempuri.org/}NewAccountResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "addAccountMoveInResult"
})
@XmlRootElement(name = "AddAccountMoveInResponse")
public class AddAccountMoveInResponse {

    @XmlElement(name = "AddAccountMoveInResult", required = true)
    protected NewAccountResult addAccountMoveInResult;

    /**
     * Gets the value of the addAccountMoveInResult property.
     *
     * @return possible object is
     *         {@link NewAccountResult }
     */
    public NewAccountResult getAddAccountMoveInResult() {
        return addAccountMoveInResult;
    }

    /**
     * Sets the value of the addAccountMoveInResult property.
     *
     * @param value allowed object is
     *              {@link NewAccountResult }
     */
    public void setAddAccountMoveInResult(NewAccountResult value) {
        this.addAccountMoveInResult = value;
    }

}
