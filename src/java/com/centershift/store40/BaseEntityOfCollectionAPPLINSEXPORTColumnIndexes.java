package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for BaseEntityOfCollectionAPPL_INS_EXPORTColumnIndexes complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="BaseEntityOfCollectionAPPL_INS_EXPORTColumnIndexes">
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
@XmlType(name = "BaseEntityOfCollectionAPPL_INS_EXPORTColumnIndexes", propOrder = {
        "transaction"
})
@XmlSeeAlso({
        APPLINSEXPORT.class
})
public abstract class BaseEntityOfCollectionAPPLINSEXPORTColumnIndexes {

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
