package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for ORG_SERVICE_SITE_OFFERINGS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_SERVICE_SITE_OFFERINGS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_SERVICE_SITE_OFFERINGSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CLASS_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SERVICE_OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LEASE_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TANGIBLE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SERVICE_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SERVICE_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICE_FULL_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICE_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TAX_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OBJECTS_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SERVICE_CAT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ITEM_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BARCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LOOKUP_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REF_TYPE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_SERVICE_SITE_OFFERINGS", propOrder = {
        "siteid",
        "classactive",
        "serviceobjectid",
        "leasegroupid",
        "tangible",
        "servicetype",
        "servicetypeval",
        "servicename",
        "servicefullname",
        "servicedesc",
        "price",
        "taxgroupid",
        "objectsactive",
        "servicecatid",
        "itemno",
        "barcode",
        "status",
        "lookupvalue",
        "meaning",
        "reftype",
        "icon"
})
public class ORGSERVICESITEOFFERINGS
        extends BaseEntityOfCollectionORGSERVICESITEOFFERINGSColumnIndexes {

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "CLASS_ACTIVE")
    protected boolean classactive;
    @XmlElement(name = "SERVICE_OBJECT_ID")
    protected long serviceobjectid;
    @XmlElement(name = "LEASE_GROUP_ID", required = true, type = Long.class, nillable = true)
    protected Long leasegroupid;
    @XmlElement(name = "TANGIBLE")
    protected boolean tangible;
    @XmlElement(name = "SERVICE_TYPE")
    protected int servicetype;
    @XmlElement(name = "SERVICE_TYPE_VAL")
    protected String servicetypeval;
    @XmlElement(name = "SERVICE_NAME")
    protected String servicename;
    @XmlElement(name = "SERVICE_FULL_NAME")
    protected String servicefullname;
    @XmlElement(name = "SERVICE_DESC")
    protected String servicedesc;
    @XmlElement(name = "PRICE", required = true)
    protected BigDecimal price;
    @XmlElement(name = "TAX_GROUP_ID", required = true, type = Long.class, nillable = true)
    protected Long taxgroupid;
    @XmlElement(name = "OBJECTS_ACTIVE")
    protected boolean objectsactive;
    @XmlElement(name = "SERVICE_CAT_ID", required = true, type = Long.class, nillable = true)
    protected Long servicecatid;
    @XmlElement(name = "ITEM_NO")
    protected String itemno;
    @XmlElement(name = "BARCODE")
    protected String barcode;
    @XmlElement(name = "STATUS", required = true, type = Integer.class, nillable = true)
    protected Integer status;
    @XmlElement(name = "LOOKUP_VALUE")
    protected String lookupvalue;
    @XmlElement(name = "MEANING")
    protected String meaning;
    @XmlElement(name = "REF_TYPE", required = true, nillable = true)
    protected BigDecimal reftype;
    @XmlElement(name = "ICON")
    protected String icon;

    /**
     * Gets the value of the siteid property.
     */
    public long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     */
    public void setSITEID(long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the classactive property.
     */
    public boolean isCLASSACTIVE() {
        return classactive;
    }

    /**
     * Sets the value of the classactive property.
     */
    public void setCLASSACTIVE(boolean value) {
        this.classactive = value;
    }

    /**
     * Gets the value of the serviceobjectid property.
     */
    public long getSERVICEOBJECTID() {
        return serviceobjectid;
    }

    /**
     * Sets the value of the serviceobjectid property.
     */
    public void setSERVICEOBJECTID(long value) {
        this.serviceobjectid = value;
    }

    /**
     * Gets the value of the leasegroupid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getLEASEGROUPID() {
        return leasegroupid;
    }

    /**
     * Sets the value of the leasegroupid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setLEASEGROUPID(Long value) {
        this.leasegroupid = value;
    }

    /**
     * Gets the value of the tangible property.
     */
    public boolean isTANGIBLE() {
        return tangible;
    }

    /**
     * Sets the value of the tangible property.
     */
    public void setTANGIBLE(boolean value) {
        this.tangible = value;
    }

    /**
     * Gets the value of the servicetype property.
     */
    public int getSERVICETYPE() {
        return servicetype;
    }

    /**
     * Sets the value of the servicetype property.
     */
    public void setSERVICETYPE(int value) {
        this.servicetype = value;
    }

    /**
     * Gets the value of the servicetypeval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSERVICETYPEVAL() {
        return servicetypeval;
    }

    /**
     * Sets the value of the servicetypeval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSERVICETYPEVAL(String value) {
        this.servicetypeval = value;
    }

    /**
     * Gets the value of the servicename property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSERVICENAME() {
        return servicename;
    }

    /**
     * Sets the value of the servicename property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSERVICENAME(String value) {
        this.servicename = value;
    }

    /**
     * Gets the value of the servicefullname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSERVICEFULLNAME() {
        return servicefullname;
    }

    /**
     * Sets the value of the servicefullname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSERVICEFULLNAME(String value) {
        this.servicefullname = value;
    }

    /**
     * Gets the value of the servicedesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSERVICEDESC() {
        return servicedesc;
    }

    /**
     * Sets the value of the servicedesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSERVICEDESC(String value) {
        this.servicedesc = value;
    }

    /**
     * Gets the value of the price property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPRICE() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPRICE(BigDecimal value) {
        this.price = value;
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
     * Gets the value of the objectsactive property.
     */
    public boolean isOBJECTSACTIVE() {
        return objectsactive;
    }

    /**
     * Sets the value of the objectsactive property.
     */
    public void setOBJECTSACTIVE(boolean value) {
        this.objectsactive = value;
    }

    /**
     * Gets the value of the servicecatid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSERVICECATID() {
        return servicecatid;
    }

    /**
     * Sets the value of the servicecatid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSERVICECATID(Long value) {
        this.servicecatid = value;
    }

    /**
     * Gets the value of the itemno property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getITEMNO() {
        return itemno;
    }

    /**
     * Sets the value of the itemno property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setITEMNO(String value) {
        this.itemno = value;
    }

    /**
     * Gets the value of the barcode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getBARCODE() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBARCODE(String value) {
        this.barcode = value;
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
     * Gets the value of the lookupvalue property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLOOKUPVALUE() {
        return lookupvalue;
    }

    /**
     * Sets the value of the lookupvalue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLOOKUPVALUE(String value) {
        this.lookupvalue = value;
    }

    /**
     * Gets the value of the meaning property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMEANING() {
        return meaning;
    }

    /**
     * Sets the value of the meaning property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMEANING(String value) {
        this.meaning = value;
    }

    /**
     * Gets the value of the reftype property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getREFTYPE() {
        return reftype;
    }

    /**
     * Sets the value of the reftype property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setREFTYPE(BigDecimal value) {
        this.reftype = value;
    }

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

}
