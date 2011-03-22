package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeeWaiveVoidStats complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="FeeWaiveVoidStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reqWaiveReason" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="limitWaives" type="{http://www.centershift.com/STORE40/}waiveLimit"/>
 *         &lt;element name="maxWaives" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usedWaives" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeeWaiveVoidStats", propOrder = {
        "reqWaiveReason",
        "limitWaives",
        "maxWaives",
        "usedWaives"
})
public class FeeWaiveVoidStats {

    protected boolean reqWaiveReason;
    @XmlElement(required = true)
    protected WaiveLimit limitWaives;
    protected int maxWaives;
    protected String usedWaives;

    /**
     * Gets the value of the reqWaiveReason property.
     */
    public boolean isReqWaiveReason() {
        return reqWaiveReason;
    }

    /**
     * Sets the value of the reqWaiveReason property.
     */
    public void setReqWaiveReason(boolean value) {
        this.reqWaiveReason = value;
    }

    /**
     * Gets the value of the limitWaives property.
     *
     * @return possible object is
     *         {@link WaiveLimit }
     */
    public WaiveLimit getLimitWaives() {
        return limitWaives;
    }

    /**
     * Sets the value of the limitWaives property.
     *
     * @param value allowed object is
     *              {@link WaiveLimit }
     */
    public void setLimitWaives(WaiveLimit value) {
        this.limitWaives = value;
    }

    /**
     * Gets the value of the maxWaives property.
     */
    public int getMaxWaives() {
        return maxWaives;
    }

    /**
     * Sets the value of the maxWaives property.
     */
    public void setMaxWaives(int value) {
        this.maxWaives = value;
    }

    /**
     * Gets the value of the usedWaives property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUsedWaives() {
        return usedWaives;
    }

    /**
     * Sets the value of the usedWaives property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUsedWaives(String value) {
        this.usedWaives = value;
    }

}
