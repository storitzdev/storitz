package org.tempuri;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for Charge_ST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Charge_ST">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dItemAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dItemTax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="tEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Charge_ST", propOrder = {
        "itemDesc",
        "dItemAmount",
        "dItemTax",
        "tStartDate",
        "tEndDate"
})
public class ChargeST {

    @XmlElement(name = "ItemDesc")
    protected String itemDesc;
    @XmlElement(required = true)
    protected BigDecimal dItemAmount;
    @XmlElement(required = true)
    protected BigDecimal dItemTax;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tStartDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tEndDate;

    /**
     * Gets the value of the itemDesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * Sets the value of the itemDesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setItemDesc(String value) {
        this.itemDesc = value;
    }

    /**
     * Gets the value of the dItemAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDItemAmount() {
        return dItemAmount;
    }

    /**
     * Sets the value of the dItemAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDItemAmount(BigDecimal value) {
        this.dItemAmount = value;
    }

    /**
     * Gets the value of the dItemTax property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDItemTax() {
        return dItemTax;
    }

    /**
     * Sets the value of the dItemTax property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDItemTax(BigDecimal value) {
        this.dItemTax = value;
    }

    /**
     * Gets the value of the tStartDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTStartDate() {
        return tStartDate;
    }

    /**
     * Sets the value of the tStartDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setTStartDate(XMLGregorianCalendar value) {
        this.tStartDate = value;
    }

    /**
     * Gets the value of the tEndDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTEndDate() {
        return tEndDate;
    }

    /**
     * Sets the value of the tEndDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setTEndDate(XMLGregorianCalendar value) {
        this.tEndDate = value;
    }

}
