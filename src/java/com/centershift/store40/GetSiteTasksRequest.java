package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GetSiteTasks_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetSiteTasks_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaskID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Type" type="{http://www.centershift.com/STORE40/}eTaskType"/>
 *         &lt;element name="Source" type="{http://www.centershift.com/STORE40/}eTaskSource"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TaskDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSiteTasks_Request", propOrder = {
        "taskID",
        "type",
        "source",
        "siteID",
        "taskDate"
})
public class GetSiteTasksRequest {

    @XmlElement(name = "TaskID", required = true, type = Long.class, nillable = true)
    protected Long taskID;
    @XmlElement(name = "Type", required = true, nillable = true)
    protected ETaskType type;
    @XmlElement(name = "Source", required = true, nillable = true)
    protected ETaskSource source;
    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "TaskDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar taskDate;

    /**
     * Gets the value of the taskID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getTaskID() {
        return taskID;
    }

    /**
     * Sets the value of the taskID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setTaskID(Long value) {
        this.taskID = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     *         {@link ETaskType }
     */
    public ETaskType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link ETaskType }
     */
    public void setType(ETaskType value) {
        this.type = value;
    }

    /**
     * Gets the value of the source property.
     *
     * @return possible object is
     *         {@link ETaskSource }
     */
    public ETaskSource getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value allowed object is
     *              {@link ETaskSource }
     */
    public void setSource(ETaskSource value) {
        this.source = value;
    }

    /**
     * Gets the value of the siteID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSiteID(Long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the taskDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTaskDate() {
        return taskDate;
    }

    /**
     * Sets the value of the taskDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setTaskDate(XMLGregorianCalendar value) {
        this.taskDate = value;
    }

}
