package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for ORG_SITE_RETAIL_OBJECTS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_SITE_RETAIL_OBJECTS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_SITE_RETAIL_OBJECTSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="RETAIL_CLASS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RETAIL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TAX_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="QTY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="REORDER_QTY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="REORDER_AT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LAST_INV_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_RETAIL_ADJ_LOG" type="{http://www.centershift.com/STORE40/}ArrayOfORG_RETAIL_ADJ_LOG" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_SITE_RETAIL_OBJECTS", propOrder = {
        "retailclassid",
        "retailid",
        "taxgroupid",
        "siteprice",
        "qty",
        "reorderqty",
        "reorderat",
        "lastinvdate",
        "active",
        "createdby",
        "updatedby",
        "orgretailadjlog"
})
public class ORGSITERETAILOBJECTS
        extends BaseEntityOfCollectionORGSITERETAILOBJECTSColumnIndexes {

    @XmlElement(name = "RETAIL_CLASS_ID")
    protected long retailclassid;
    @XmlElement(name = "RETAIL_ID")
    protected long retailid;
    @XmlElement(name = "TAX_GROUP_ID", required = true, type = Long.class, nillable = true)
    protected Long taxgroupid;
    @XmlElement(name = "SITE_PRICE", required = true, nillable = true)
    protected BigDecimal siteprice;
    @XmlElement(name = "QTY", required = true, type = Integer.class, nillable = true)
    protected Integer qty;
    @XmlElement(name = "REORDER_QTY", required = true, type = Integer.class, nillable = true)
    protected Integer reorderqty;
    @XmlElement(name = "REORDER_AT", required = true, type = Integer.class, nillable = true)
    protected Integer reorderat;
    @XmlElement(name = "LAST_INV_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastinvdate;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "ORG_RETAIL_ADJ_LOG")
    protected ArrayOfORGRETAILADJLOG orgretailadjlog;

    /**
     * Gets the value of the retailclassid property.
     */
    public long getRETAILCLASSID() {
        return retailclassid;
    }

    /**
     * Sets the value of the retailclassid property.
     */
    public void setRETAILCLASSID(long value) {
        this.retailclassid = value;
    }

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
     * Gets the value of the taxgroupid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getTAXGROUPID() {
        return taxgroupid;
    }

    /**
     * Sets the value of the taxgroupid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setTAXGROUPID(Long value) {
        this.taxgroupid = value;
    }

    /**
     * Gets the value of the siteprice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getSITEPRICE() {
        return siteprice;
    }

    /**
     * Sets the value of the siteprice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setSITEPRICE(BigDecimal value) {
        this.siteprice = value;
    }

    /**
     * Gets the value of the qty property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getQTY() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setQTY(Integer value) {
        this.qty = value;
    }

    /**
     * Gets the value of the reorderqty property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getREORDERQTY() {
        return reorderqty;
    }

    /**
     * Sets the value of the reorderqty property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setREORDERQTY(Integer value) {
        this.reorderqty = value;
    }

    /**
     * Gets the value of the reorderat property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getREORDERAT() {
        return reorderat;
    }

    /**
     * Sets the value of the reorderat property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setREORDERAT(Integer value) {
        this.reorderat = value;
    }

    /**
     * Gets the value of the lastinvdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLASTINVDATE() {
        return lastinvdate;
    }

    /**
     * Sets the value of the lastinvdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLASTINVDATE(XMLGregorianCalendar value) {
        this.lastinvdate = value;
    }

    /**
     * Gets the value of the active property.
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     */
    public void setACTIVE(boolean value) {
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

    /**
     * Gets the value of the orgretailadjlog property.
     *
     * @return possible object is
     *         {@link ArrayOfORGRETAILADJLOG }
     */
    public ArrayOfORGRETAILADJLOG getORGRETAILADJLOG() {
        return orgretailadjlog;
    }

    /**
     * Sets the value of the orgretailadjlog property.
     *
     * @param value allowed object is
     *              {@link ArrayOfORGRETAILADJLOG }
     */
    public void setORGRETAILADJLOG(ArrayOfORGRETAILADJLOG value) {
        this.orgretailadjlog = value;
    }

}
