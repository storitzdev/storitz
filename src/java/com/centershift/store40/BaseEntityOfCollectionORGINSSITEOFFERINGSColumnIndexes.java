package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for BaseEntityOfCollectionORG_INS_SITE_OFFERINGSColumnIndexes complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="BaseEntityOfCollectionORG_INS_SITE_OFFERINGSColumnIndexes">
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
@XmlType(name = "BaseEntityOfCollectionORG_INS_SITE_OFFERINGSColumnIndexes", propOrder = {
        "transaction"
})
@XmlSeeAlso({
        ORGINSSITEOFFERINGS.class
})
public abstract class BaseEntityOfCollectionORGINSSITEOFFERINGSColumnIndexes {

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
