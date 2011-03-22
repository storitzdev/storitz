package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for ORG_RETAIL_BULK complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_RETAIL_BULK">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_RETAIL_BULKColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="RETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MIN_THRESHOLD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DISC_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DISC_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_RETAIL_BULK", propOrder = {
        "retailid",
        "minthreshold",
        "disctype",
        "discamt",
        "active",
        "createdby",
        "updatedby"
})
public class ORGRETAILBULK
        extends BaseEntityOfCollectionORGRETAILBULKColumnIndexes {

    @XmlElement(name = "RETAIL_ID")
    protected long retailid;
    @XmlElement(name = "MIN_THRESHOLD", required = true, type = Integer.class, nillable = true)
    protected Integer minthreshold;
    @XmlElement(name = "DISC_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer disctype;
    @XmlElement(name = "DISC_AMT", required = true, nillable = true)
    protected BigDecimal discamt;
    @XmlElement(name = "ACTIVE", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

    /**
     * Gets the value of the retailid property.
     */
    public long getRETAILID() {
        return retailid;
    }

    /**
     * Sets the value of the retailid property.
     */
    public void setRETAILID(long value) {
        this.retailid = value;
    }

    /**
     * Gets the value of the minthreshold property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMINTHRESHOLD() {
        return minthreshold;
    }

    /**
     * Sets the value of the minthreshold property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMINTHRESHOLD(Integer value) {
        this.minthreshold = value;
    }

    /**
     * Gets the value of the disctype property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getDISCTYPE() {
        return disctype;
    }

    /**
     * Sets the value of the disctype property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDISCTYPE(Integer value) {
        this.disctype = value;
    }

    /**
     * Gets the value of the discamt property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDISCAMT() {
        return discamt;
    }

    /**
     * Sets the value of the discamt property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDISCAMT(BigDecimal value) {
        this.discamt = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setACTIVE(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the createdby property.
     */
    public long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     */
    public void setCREATEDBY(long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the updatedby property.
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
    }

}
