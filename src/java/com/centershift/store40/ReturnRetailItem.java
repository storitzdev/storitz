package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnRetailItem complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ReturnRetailItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RetailObjectID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ReturnReason" type="{http://www.centershift.com/STORE40/}RetailReturnReasons"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnRetailItem", propOrder = {
        "retailObjectID",
        "quantity",
        "returnReason"
})
public class ReturnRetailItem {

    @XmlElement(name = "RetailObjectID")
    protected long retailObjectID;
    @XmlElement(name = "Quantity")
    protected int quantity;
    @XmlElement(name = "ReturnReason", required = true)
    protected RetailReturnReasons returnReason;

    /**
     * Gets the value of the retailObjectID property.
     */
    public long getRetailObjectID() {
        return retailObjectID;
    }

    /**
     * Sets the value of the retailObjectID property.
     */
    public void setRetailObjectID(long value) {
        this.retailObjectID = value;
    }

    /**
     * Gets the value of the quantity property.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the returnReason property.
     *
     * @return possible object is
     *         {@link RetailReturnReasons }
     */
    public RetailReturnReasons getReturnReason() {
        return returnReason;
    }

    /**
     * Sets the value of the returnReason property.
     *
     * @param value allowed object is
     *              {@link RetailReturnReasons }
     */
    public void setReturnReason(RetailReturnReasons value) {
        this.returnReason = value;
    }

}
