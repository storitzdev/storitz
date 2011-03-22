package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for RENTAL_SERVICES complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RENTAL_SERVICES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionRENTAL_SERVICESColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBJ_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PARENT_RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SERVICE_TYPE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ITEM_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EMAIL_CC" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="START_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="END_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RENTAL_SERVICES", propOrder = {
        "icon",
        "objtype",
        "objectid",
        "rentalid",
        "parentrentalid",
        "servicetype",
        "itemname",
        "amount",
        "emailcc",
        "startdate",
        "enddate",
        "ptd",
        "ltd",
        "status",
        "updatedby",
        "createdby"
})
public class RENTALSERVICES
        extends BaseEntityOfCollectionRENTALSERVICESColumnIndexes {

    @XmlElement(name = "ICON")
    protected String icon;
    @XmlElement(name = "OBJ_TYPE")
    protected String objtype;
    @XmlElement(name = "OBJECT_ID", required = true, type = Long.class, nillable = true)
    protected Long objectid;
    @XmlElement(name = "RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long rentalid;
    @XmlElement(name = "PARENT_RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long parentrentalid;
    @XmlElement(name = "SERVICE_TYPE", required = true, nillable = true)
    protected BigDecimal servicetype;
    @XmlElement(name = "ITEM_NAME")
    protected String itemname;
    @XmlElement(name = "AMOUNT", required = true, nillable = true)
    protected BigDecimal amount;
    @XmlElement(name = "EMAIL_CC", required = true, type = Boolean.class, nillable = true)
    protected Boolean emailcc;
    @XmlElement(name = "START_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startdate;
    @XmlElement(name = "END_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enddate;
    @XmlElement(name = "PTD", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ptd;
    @XmlElement(name = "LTD", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ltd;
    @XmlElement(name = "STATUS", required = true, type = Integer.class, nillable = true)
    protected Integer status;
    @XmlElement(name = "UPDATED_BY", required = true, type = Long.class, nillable = true)
    protected Long updatedby;
    @XmlElement(name = "CREATED_BY", required = true, type = Long.class, nillable = true)
    protected Long createdby;

    /**
     * Gets the value of the icon property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getICON() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setICON(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the objtype property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOBJTYPE() {
        return objtype;
    }

    /**
     * Sets the value of the objtype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOBJTYPE(String value) {
        this.objtype = value;
    }

    /**
     * Gets the value of the objectid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getOBJECTID() {
        return objectid;
    }

    /**
     * Sets the value of the objectid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setOBJECTID(Long value) {
        this.objectid = value;
    }

    /**
     * Gets the value of the rentalid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRENTALID(Long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the parentrentalid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getPARENTRENTALID() {
        return parentrentalid;
    }

    /**
     * Sets the value of the parentrentalid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setPARENTRENTALID(Long value) {
        this.parentrentalid = value;
    }

    /**
     * Gets the value of the servicetype property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getSERVICETYPE() {
        return servicetype;
    }

    /**
     * Sets the value of the servicetype property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setSERVICETYPE(BigDecimal value) {
        this.servicetype = value;
    }

    /**
     * Gets the value of the itemname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getITEMNAME() {
        return itemname;
    }

    /**
     * Sets the value of the itemname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setITEMNAME(String value) {
        this.itemname = value;
    }

    /**
     * Gets the value of the amount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getAMOUNT() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setAMOUNT(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the emailcc property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isEMAILCC() {
        return emailcc;
    }

    /**
     * Sets the value of the emailcc property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setEMAILCC(Boolean value) {
        this.emailcc = value;
    }

    /**
     * Gets the value of the startdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getSTARTDATE() {
        return startdate;
    }

    /**
     * Sets the value of the startdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setSTARTDATE(XMLGregorianCalendar value) {
        this.startdate = value;
    }

    /**
     * Gets the value of the enddate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getENDDATE() {
        return enddate;
    }

    /**
     * Sets the value of the enddate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setENDDATE(XMLGregorianCalendar value) {
        this.enddate = value;
    }

    /**
     * Gets the value of the ptd property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getPTD() {
        return ptd;
    }

    /**
     * Sets the value of the ptd property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setPTD(XMLGregorianCalendar value) {
        this.ptd = value;
    }

    /**
     * Gets the value of the ltd property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLTD() {
        return ltd;
    }

    /**
     * Sets the value of the ltd property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLTD(XMLGregorianCalendar value) {
        this.ltd = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setSTATUS(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the updatedby property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setUPDATEDBY(Long value) {
        this.updatedby = value;
    }

    /**
     * Gets the value of the createdby property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setCREATEDBY(Long value) {
        this.createdby = value;
    }

}
