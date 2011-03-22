package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for item complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tranId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="retailObjectId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numberReturned" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="itemPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="returnCondition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
        "tranId",
        "retailObjectId",
        "numberReturned",
        "itemPrice",
        "returnCondition"
})
public class Item {

    protected long tranId;
    protected long retailObjectId;
    protected int numberReturned;
    @XmlElement(required = true)
    protected BigDecimal itemPrice;
    protected int returnCondition;

    /**
     * Gets the value of the tranId property.
     */
    public long getTranId() {
        return tranId;
    }

    /**
     * Sets the value of the tranId property.
     */
    public void setTranId(long value) {
        this.tranId = value;
    }

    /**
     * Gets the value of the retailObjectId property.
     */
    public long getRetailObjectId() {
        return retailObjectId;
    }

    /**
     * Sets the value of the retailObjectId property.
     */
    public void setRetailObjectId(long value) {
        this.retailObjectId = value;
    }

    /**
     * Gets the value of the numberReturned property.
     */
    public int getNumberReturned() {
        return numberReturned;
    }

    /**
     * Sets the value of the numberReturned property.
     */
    public void setNumberReturned(int value) {
        this.numberReturned = value;
    }

    /**
     * Gets the value of the itemPrice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    /**
     * Sets the value of the itemPrice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setItemPrice(BigDecimal value) {
        this.itemPrice = value;
    }

    /**
     * Gets the value of the returnCondition property.
     */
    public int getReturnCondition() {
        return returnCondition;
    }

    /**
     * Sets the value of the returnCondition property.
     */
    public void setReturnCondition(int value) {
        this.returnCondition = value;
    }

}
