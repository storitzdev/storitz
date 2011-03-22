package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TRAN_QUOTE_NOTES_DETAIL complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_QUOTE_NOTES_DETAIL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_QUOTE_NOTES_DETAILColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="QUOTE_NOTE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="QUOTE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="QUOTE_NOTES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CREATED_BY_FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY_LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_QUOTE_NOTES_DETAIL", propOrder = {
        "quotenoteid",
        "quoteid",
        "quotenotes",
        "createdby",
        "createdbyfirstname",
        "createdbylastname",
        "updatedby"
})
public class TRANQUOTENOTESDETAIL
        extends BaseEntityOfCollectionTRANQUOTENOTESDETAILColumnIndexes {

    @XmlElement(name = "QUOTE_NOTE_ID")
    protected long quotenoteid;
    @XmlElement(name = "QUOTE_ID")
    protected long quoteid;
    @XmlElement(name = "QUOTE_NOTES")
    protected String quotenotes;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "CREATED_BY_FIRST_NAME")
    protected String createdbyfirstname;
    @XmlElement(name = "CREATED_BY_LAST_NAME")
    protected String createdbylastname;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

    /**
     * Gets the value of the quotenoteid property.
     */
    public long getQUOTENOTEID() {
        return quotenoteid;
    }

    /**
     * Sets the value of the quotenoteid property.
     */
    public void setQUOTENOTEID(long value) {
        this.quotenoteid = value;
    }

    /**
     * Gets the value of the quoteid property.
     */
    public long getQUOTEID() {
        return quoteid;
    }

    /**
     * Sets the value of the quoteid property.
     */
    public void setQUOTEID(long value) {
        this.quoteid = value;
    }

    /**
     * Gets the value of the quotenotes property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getQUOTENOTES() {
        return quotenotes;
    }

    /**
     * Sets the value of the quotenotes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQUOTENOTES(String value) {
        this.quotenotes = value;
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
     * Gets the value of the createdbyfirstname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCREATEDBYFIRSTNAME() {
        return createdbyfirstname;
    }

    /**
     * Sets the value of the createdbyfirstname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCREATEDBYFIRSTNAME(String value) {
        this.createdbyfirstname = value;
    }

    /**
     * Gets the value of the createdbylastname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCREATEDBYLASTNAME() {
        return createdbylastname;
    }

    /**
     * Sets the value of the createdbylastname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCREATEDBYLASTNAME(String value) {
        this.createdbylastname = value;
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
