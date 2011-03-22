package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tntLtrNum_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="tntLtrNum_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LtrNum" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tntLtrNum_Response", propOrder = {
        "ltrNum"
})
public class TntLtrNumResponse {

    @XmlElement(name = "LtrNum")
    protected long ltrNum;

    /**
     * Gets the value of the ltrNum property.
     */
    public long getLtrNum() {
        return ltrNum;
    }

    /**
     * Sets the value of the ltrNum property.
     */
    public void setLtrNum(long value) {
        this.ltrNum = value;
    }

}
