package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for retailReturn complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="retailReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tnxId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="siteId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="acctId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="item" type="{http://www.centershift.com/STORE40/}item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retailReturn", propOrder = {
        "tnxId",
        "siteId",
        "acctId",
        "date",
        "personId",
        "item"
})
public class RetailReturn {

    protected long tnxId;
    protected long siteId;
    protected long acctId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected long personId;
    protected List<Item> item;

    /**
     * Gets the value of the tnxId property.
     */
    public long getTnxId() {
        return tnxId;
    }

    /**
     * Sets the value of the tnxId property.
     */
    public void setTnxId(long value) {
        this.tnxId = value;
    }

    /**
     * Gets the value of the siteId property.
     */
    public long getSiteId() {
        return siteId;
    }

    /**
     * Sets the value of the siteId property.
     */
    public void setSiteId(long value) {
        this.siteId = value;
    }

    /**
     * Gets the value of the acctId property.
     */
    public long getAcctId() {
        return acctId;
    }

    /**
     * Sets the value of the acctId property.
     */
    public void setAcctId(long value) {
        this.acctId = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the personId property.
     */
    public long getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     */
    public void setPersonId(long value) {
        this.personId = value;
    }

    /**
     * Gets the value of the item property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

}
