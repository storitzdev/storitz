package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddUpdateMerchandiseItems_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AddUpdateMerchandiseItems_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MerchandiseData" type="{http://www.centershift.com/STORE40/}ArrayOfAddUpdateMerchandiseItemsData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddUpdateMerchandiseItems_Request", propOrder = {
        "orgID",
        "merchandiseData"
})
public class AddUpdateMerchandiseItemsRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "MerchandiseData")
    protected ArrayOfAddUpdateMerchandiseItemsData merchandiseData;

    /**
     * Gets the value of the orgID property.
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the merchandiseData property.
     *
     * @return possible object is
     *         {@link ArrayOfAddUpdateMerchandiseItemsData }
     */
    public ArrayOfAddUpdateMerchandiseItemsData getMerchandiseData() {
        return merchandiseData;
    }

    /**
     * Sets the value of the merchandiseData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAddUpdateMerchandiseItemsData }
     */
    public void setMerchandiseData(ArrayOfAddUpdateMerchandiseItemsData value) {
        this.merchandiseData = value;
    }

}
