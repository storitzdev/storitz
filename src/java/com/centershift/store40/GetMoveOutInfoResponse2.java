package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMoveOutInfo_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetMoveOutInfo_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MoveOutInfo" type="{http://www.centershift.com/STORE40/}MoveOutInfo" minOccurs="0"/>
 *         &lt;element name="RefundTypes" type="{http://www.centershift.com/STORE40/}ArrayOfRefundTypes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMoveOutInfo_Response", propOrder = {
        "moveOutInfo",
        "refundTypes"
})
public class GetMoveOutInfoResponse2 {

    @XmlElement(name = "MoveOutInfo")
    protected MoveOutInfo moveOutInfo;
    @XmlElement(name = "RefundTypes")
    protected ArrayOfRefundTypes refundTypes;

    /**
     * Gets the value of the moveOutInfo property.
     *
     * @return possible object is
     *         {@link MoveOutInfo }
     */
    public MoveOutInfo getMoveOutInfo() {
        return moveOutInfo;
    }

    /**
     * Sets the value of the moveOutInfo property.
     *
     * @param value allowed object is
     *              {@link MoveOutInfo }
     */
    public void setMoveOutInfo(MoveOutInfo value) {
        this.moveOutInfo = value;
    }

    /**
     * Gets the value of the refundTypes property.
     *
     * @return possible object is
     *         {@link ArrayOfRefundTypes }
     */
    public ArrayOfRefundTypes getRefundTypes() {
        return refundTypes;
    }

    /**
     * Sets the value of the refundTypes property.
     *
     * @param value allowed object is
     *              {@link ArrayOfRefundTypes }
     */
    public void setRefundTypes(ArrayOfRefundTypes value) {
        this.refundTypes = value;
    }

}
