
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TenantData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TenantData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RefundAdress" type="{http://www.centershift.com/STORE40/}Address" minOccurs="0"/>
 *         &lt;element name="Phones" type="{http://www.centershift.com/STORE40/}Phone" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TenantData", propOrder = {
    "accountName",
    "accountNumber",
    "refundAdress",
    "phones"
})
public class TenantData {

    @XmlElement(name = "AccountName")
    protected String accountName;
    @XmlElement(name = "AccountNumber")
    protected long accountNumber;
    @XmlElement(name = "RefundAdress")
    protected Address refundAdress;
    @XmlElement(name = "Phones")
    protected List<Phone> phones;

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     */
    public void setAccountNumber(long value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the refundAdress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getRefundAdress() {
        return refundAdress;
    }

    /**
     * Sets the value of the refundAdress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setRefundAdress(Address value) {
        this.refundAdress = value;
    }

    /**
     * Gets the value of the phones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Phone }
     * 
     * 
     */
    public List<Phone> getPhones() {
        if (phones == null) {
            phones = new ArrayList<Phone>();
        }
        return this.phones;
    }

}
