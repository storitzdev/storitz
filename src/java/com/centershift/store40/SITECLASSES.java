package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SITE_CLASSES complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SITE_CLASSES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSITE_CLASSESColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CLASS_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_CLASS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CLASS_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACCT_CATEGORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="APPL_RENTAL_OBJECTS_DETAIL_Occupiable" type="{http://www.centershift.com/STORE40/}ArrayOfAPPL_RENTAL_OBJECTS_DETAIL" minOccurs="0"/>
 *         &lt;element name="APPL_RENTAL_OBJECTS_DETAIL_NonOccupiable" type="{http://www.centershift.com/STORE40/}ArrayOfAPPL_RENTAL_OBJECTS_DETAIL" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SITE_CLASSES", propOrder = {
        "siteid",
        "classdesc",
        "icon",
        "siteclassid",
        "classtype",
        "acctcategory",
        "applrentalobjectsdetailOccupiable",
        "applrentalobjectsdetailNonOccupiable"
})
public class SITECLASSES
        extends BaseEntityOfCollectionSITECLASSESColumnIndexes {

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "CLASS_DESC")
    protected String classdesc;
    @XmlElement(name = "ICON")
    protected String icon;
    @XmlElement(name = "SITE_CLASS_ID")
    protected long siteclassid;
    @XmlElement(name = "CLASS_TYPE")
    protected int classtype;
    @XmlElement(name = "ACCT_CATEGORY")
    protected String acctcategory;
    @XmlElement(name = "APPL_RENTAL_OBJECTS_DETAIL_Occupiable")
    protected ArrayOfAPPLRENTALOBJECTSDETAIL applrentalobjectsdetailOccupiable;
    @XmlElement(name = "APPL_RENTAL_OBJECTS_DETAIL_NonOccupiable")
    protected ArrayOfAPPLRENTALOBJECTSDETAIL applrentalobjectsdetailNonOccupiable;

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
     * Gets the value of the classdesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCLASSDESC() {
        return classdesc;
    }

    /**
     * Sets the value of the classdesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCLASSDESC(String value) {
        this.classdesc = value;
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

    /**
     * Gets the value of the siteclassid property.
     */
    public long getSITECLASSID() {
        return siteclassid;
    }

    /**
     * Sets the value of the siteclassid property.
     */
    public void setSITECLASSID(long value) {
        this.siteclassid = value;
    }

    /**
     * Gets the value of the classtype property.
     */
    public int getCLASSTYPE() {
        return classtype;
    }

    /**
     * Sets the value of the classtype property.
     */
    public void setCLASSTYPE(int value) {
        this.classtype = value;
    }

    /**
     * Gets the value of the acctcategory property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCTCATEGORY() {
        return acctcategory;
    }

    /**
     * Sets the value of the acctcategory property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCTCATEGORY(String value) {
        this.acctcategory = value;
    }

    /**
     * Gets the value of the applrentalobjectsdetailOccupiable property.
     *
     * @return possible object is
     *         {@link ArrayOfAPPLRENTALOBJECTSDETAIL }
     */
    public ArrayOfAPPLRENTALOBJECTSDETAIL getAPPLRENTALOBJECTSDETAILOccupiable() {
        return applrentalobjectsdetailOccupiable;
    }

    /**
     * Sets the value of the applrentalobjectsdetailOccupiable property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAPPLRENTALOBJECTSDETAIL }
     */
    public void setAPPLRENTALOBJECTSDETAILOccupiable(ArrayOfAPPLRENTALOBJECTSDETAIL value) {
        this.applrentalobjectsdetailOccupiable = value;
    }

    /**
     * Gets the value of the applrentalobjectsdetailNonOccupiable property.
     *
     * @return possible object is
     *         {@link ArrayOfAPPLRENTALOBJECTSDETAIL }
     */
    public ArrayOfAPPLRENTALOBJECTSDETAIL getAPPLRENTALOBJECTSDETAILNonOccupiable() {
        return applrentalobjectsdetailNonOccupiable;
    }

    /**
     * Sets the value of the applrentalobjectsdetailNonOccupiable property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAPPLRENTALOBJECTSDETAIL }
     */
    public void setAPPLRENTALOBJECTSDETAILNonOccupiable(ArrayOfAPPLRENTALOBJECTSDETAIL value) {
        this.applrentalobjectsdetailNonOccupiable = value;
    }

}
