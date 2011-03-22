package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for TRAN_FIU_DATA complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_FIU_DATA">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_FIU_DATAColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="POST_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ABBREVIATED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORG_NUMBER_XREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POST_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SOURCE_REF" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SOURCE_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CLASS_REF" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SITE_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GL_MAP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DR" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CR" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="INT_FLAG" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="INT_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UPDATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="BATCH_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_FIU_DATA", propOrder = {
        "postid",
        "orgid",
        "siteid",
        "abbreviatedname",
        "orgnumberxref",
        "postdate",
        "sourceref",
        "sourcevalue",
        "gl",
        "classref",
        "sitedesc",
        "glmap",
        "dr",
        "cr",
        "intflag",
        "intvalue",
        "updated",
        "updatedby",
        "batchid",
        "createdby"
})
public class TRANFIUDATA
        extends BaseEntityOfCollectionTRANFIUDATAColumnIndexes {

    @XmlElement(name = "POST_ID")
    protected long postid;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "ABBREVIATED_NAME")
    protected String abbreviatedname;
    @XmlElement(name = "ORG_NUMBER_XREF")
    protected String orgnumberxref;
    @XmlElement(name = "POST_DATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar postdate;
    @XmlElement(name = "SOURCE_REF")
    protected int sourceref;
    @XmlElement(name = "SOURCE_VALUE")
    protected String sourcevalue;
    @XmlElement(name = "GL")
    protected int gl;
    @XmlElement(name = "CLASS_REF")
    protected int classref;
    @XmlElement(name = "SITE_DESC")
    protected String sitedesc;
    @XmlElement(name = "GL_MAP")
    protected String glmap;
    @XmlElement(name = "DR", required = true)
    protected BigDecimal dr;
    @XmlElement(name = "CR", required = true)
    protected BigDecimal cr;
    @XmlElement(name = "INT_FLAG")
    protected int intflag;
    @XmlElement(name = "INT_VALUE")
    protected String intvalue;
    @XmlElement(name = "UPDATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updated;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "BATCH_ID")
    protected long batchid;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;

    /**
     * Gets the value of the postid property.
     */
    public long getPOSTID() {
        return postid;
    }

    /**
     * Sets the value of the postid property.
     */
    public void setPOSTID(long value) {
        this.postid = value;
    }

    /**
     * Gets the value of the orgid property.
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

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
     * Gets the value of the abbreviatedname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getABBREVIATEDNAME() {
        return abbreviatedname;
    }

    /**
     * Sets the value of the abbreviatedname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setABBREVIATEDNAME(String value) {
        this.abbreviatedname = value;
    }

    /**
     * Gets the value of the orgnumberxref property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getORGNUMBERXREF() {
        return orgnumberxref;
    }

    /**
     * Sets the value of the orgnumberxref property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setORGNUMBERXREF(String value) {
        this.orgnumberxref = value;
    }

    /**
     * Gets the value of the postdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getPOSTDATE() {
        return postdate;
    }

    /**
     * Sets the value of the postdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setPOSTDATE(XMLGregorianCalendar value) {
        this.postdate = value;
    }

    /**
     * Gets the value of the sourceref property.
     */
    public int getSOURCEREF() {
        return sourceref;
    }

    /**
     * Sets the value of the sourceref property.
     */
    public void setSOURCEREF(int value) {
        this.sourceref = value;
    }

    /**
     * Gets the value of the sourcevalue property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSOURCEVALUE() {
        return sourcevalue;
    }

    /**
     * Sets the value of the sourcevalue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSOURCEVALUE(String value) {
        this.sourcevalue = value;
    }

    /**
     * Gets the value of the gl property.
     */
    public int getGL() {
        return gl;
    }

    /**
     * Sets the value of the gl property.
     */
    public void setGL(int value) {
        this.gl = value;
    }

    /**
     * Gets the value of the classref property.
     */
    public int getCLASSREF() {
        return classref;
    }

    /**
     * Sets the value of the classref property.
     */
    public void setCLASSREF(int value) {
        this.classref = value;
    }

    /**
     * Gets the value of the sitedesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSITEDESC() {
        return sitedesc;
    }

    /**
     * Sets the value of the sitedesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSITEDESC(String value) {
        this.sitedesc = value;
    }

    /**
     * Gets the value of the glmap property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGLMAP() {
        return glmap;
    }

    /**
     * Sets the value of the glmap property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGLMAP(String value) {
        this.glmap = value;
    }

    /**
     * Gets the value of the dr property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDR() {
        return dr;
    }

    /**
     * Sets the value of the dr property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDR(BigDecimal value) {
        this.dr = value;
    }

    /**
     * Gets the value of the cr property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getCR() {
        return cr;
    }

    /**
     * Sets the value of the cr property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setCR(BigDecimal value) {
        this.cr = value;
    }

    /**
     * Gets the value of the intflag property.
     */
    public int getINTFLAG() {
        return intflag;
    }

    /**
     * Sets the value of the intflag property.
     */
    public void setINTFLAG(int value) {
        this.intflag = value;
    }

    /**
     * Gets the value of the intvalue property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getINTVALUE() {
        return intvalue;
    }

    /**
     * Sets the value of the intvalue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setINTVALUE(String value) {
        this.intvalue = value;
    }

    /**
     * Gets the value of the updated property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getUPDATED() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setUPDATED(XMLGregorianCalendar value) {
        this.updated = value;
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
     * Gets the value of the batchid property.
     */
    public long getBATCHID() {
        return batchid;
    }

    /**
     * Sets the value of the batchid property.
     */
    public void setBATCHID(long value) {
        this.batchid = value;
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

}
