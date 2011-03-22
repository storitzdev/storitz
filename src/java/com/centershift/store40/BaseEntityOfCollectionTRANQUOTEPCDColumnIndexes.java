package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for BaseEntityOfCollectionTRAN_QUOTE_PCDColumnIndexes complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="BaseEntityOfCollectionTRAN_QUOTE_PCDColumnIndexes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Transaction" type="{http://www.centershift.com/STORE40/}FrameworkTransaction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseEntityOfCollectionTRAN_QUOTE_PCDColumnIndexes", propOrder = {
        "transaction"
})
@XmlSeeAlso({
        TRANQUOTEPCD.class
})
public abstract class BaseEntityOfCollectionTRANQUOTEPCDColumnIndexes {

    @XmlElement(name = "Transaction")
    protected FrameworkTransaction transaction;

    /**
     * Gets the value of the transaction property.
     *
     * @return possible object is
     *         {@link FrameworkTransaction }
     */
    public FrameworkTransaction getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     *
     * @param value allowed object is
     *              {@link FrameworkTransaction }
     */
    public void setTransaction(FrameworkTransaction value) {
        this.transaction = value;
    }

}
