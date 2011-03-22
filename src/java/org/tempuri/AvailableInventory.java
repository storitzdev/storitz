package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for AvailableInventory complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AvailableInventory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="csItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iStock" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailableInventory", propOrder = {
        "itemId",
        "csItem",
        "iStock",
        "dPrice"
})
public class AvailableInventory {

    protected int itemId;
    protected String csItem;
    protected int iStock;
    @XmlElement(required = true)
    protected BigDecimal dPrice;

    /**
     * Gets the value of the itemId property.
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     */
    public void setItemId(int value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the csItem property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCsItem() {
        return csItem;
    }

    /**
     * Sets the value of the csItem property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCsItem(String value) {
        this.csItem = value;
    }

    /**
     * Gets the value of the iStock property.
     */
    public int getIStock() {
        return iStock;
    }

    /**
     * Sets the value of the iStock property.
     */
    public void setIStock(int value) {
        this.iStock = value;
    }

    /**
     * Gets the value of the dPrice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDPrice() {
        return dPrice;
    }

    /**
     * Sets the value of the dPrice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDPrice(BigDecimal value) {
        this.dPrice = value;
    }

}
