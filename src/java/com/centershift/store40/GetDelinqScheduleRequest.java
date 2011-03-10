
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetDelinqSchedule_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDelinqSchedule_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDelinqSchedule_Request", propOrder = {
    "orgID"
})
public class GetDelinqScheduleRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;

    /**
     * Gets the value of the orgID property.
     * 
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

}
