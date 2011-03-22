package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_EXT_ATTRIBUTES complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_EXT_ATTRIBUTES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_EXT_ATTRIBUTESColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ATT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATT_DETAILS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_EXT_ATTRIBUTES", propOrder = {
        "siteid",
        "attname",
        "attdetails",
        "createdby",
        "updatedby"
})
public class ORGEXTATTRIBUTES
        extends BaseEntityOfCollectionORGEXTATTRIBUTESColumnIndexes {

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "ATT_NAME")
    protected String attname;
    @XmlElement(name = "ATT_DETAILS")
    protected String attdetails;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

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
     * Gets the value of the attname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getATTNAME() {
        return attname;
    }

    /**
     * Sets the value of the attname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setATTNAME(String value) {
        this.attname = value;
    }

    /**
     * Gets the value of the attdetails property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getATTDETAILS() {
        return attdetails;
    }

    /**
     * Sets the value of the attdetails property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setATTDETAILS(String value) {
        this.attdetails = value;
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
