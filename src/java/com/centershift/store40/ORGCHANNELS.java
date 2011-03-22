package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_CHANNELS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_CHANNELS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_CHANNELSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CHANNEL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CHANNEL_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ORG_CHANNELS", propOrder = {
        "orgid",
        "channel",
        "channeldesc",
        "active",
        "createdby",
        "updatedby"
})
public class ORGCHANNELS
        extends BaseEntityOfCollectionORGCHANNELSColumnIndexes {

    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "CHANNEL")
    protected int channel;
    @XmlElement(name = "CHANNEL_DESC")
    protected String channeldesc;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

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
     * Gets the value of the channel property.
     */
    public int getCHANNEL() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     */
    public void setCHANNEL(int value) {
        this.channel = value;
    }

    /**
     * Gets the value of the channeldesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCHANNELDESC() {
        return channeldesc;
    }

    /**
     * Sets the value of the channeldesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCHANNELDESC(String value) {
        this.channeldesc = value;
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

}
