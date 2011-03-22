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
 *         &lt;element name="AddAccountMoveInSpecialResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "addAccountMoveInSpecialResult"
})
@XmlRootElement(name = "AddAccountMoveInSpecialResponse")
public class AddAccountMoveInSpecialResponse {

    @XmlElement(name = "AddAccountMoveInSpecialResult")
    protected String addAccountMoveInSpecialResult;

    /**
     * Gets the value of the addAccountMoveInSpecialResult property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAddAccountMoveInSpecialResult() {
        return addAccountMoveInSpecialResult;
    }

    /**
     * Sets the value of the addAccountMoveInSpecialResult property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddAccountMoveInSpecialResult(String value) {
        this.addAccountMoveInSpecialResult = value;
    }

}
