package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetChannelList_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetChannelList_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetChannelList_Request", propOrder = {
        "orgId"
})
public class GetChannelListRequest {

    @XmlElement(name = "OrgId", required = true, type = Long.class, nillable = true)
    protected Long orgId;

    /**
     * Gets the value of the orgId property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setOrgId(Long value) {
        this.orgId = value;
    }

}
