package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CreateSiteTask_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CreateSiteTask_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Body" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Type" type="{http://www.centershift.com/STORE40/}eTaskType"/>
 *         &lt;element name="Source" type="{http://www.centershift.com/STORE40/}eTaskSource"/>
 *         &lt;element name="Priority" type="{http://www.centershift.com/STORE40/}eTaskPriority"/>
 *         &lt;element name="RefType" type="{http://www.centershift.com/STORE40/}eTaskRefType"/>
 *         &lt;element name="Ref" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RecurTask" type="{http://www.centershift.com/STORE40/}RecurTaskData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateSiteTask_Request", propOrder = {
        "header",
        "body",
        "siteID",
        "dueDate",
        "type",
        "source",
        "priority",
        "refType",
        "ref",
        "recurTask"
})
public class CreateSiteTaskRequest {

    @XmlElement(name = "Header")
    protected String header;
    @XmlElement(name = "Body")
    protected String body;
    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "DueDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dueDate;
    @XmlElement(name = "Type", required = true, nillable = true)
    protected ETaskType type;
    @XmlElement(name = "Source", required = true, nillable = true)
    protected ETaskSource source;
    @XmlElement(name = "Priority", required = true, nillable = true)
    protected ETaskPriority priority;
    @XmlElement(name = "RefType", required = true, nillable = true)
    protected ETaskRefType refType;
    @XmlElement(name = "Ref", required = true, type = Long.class, nillable = true)
    protected Long ref;
    @XmlElement(name = "RecurTask")
    protected RecurTaskData recurTask;

    /**
     * Gets the value of the header property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHeader(String value) {
        this.header = value;
    }

    /**
     * Gets the value of the body property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBody(String value) {
        this.body = value;
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
     * Gets the value of the dueDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
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
     * Gets the value of the priority property.
     *
     * @return possible object is
     *         {@link ETaskPriority }
     */
    public ETaskPriority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     *
     * @param value allowed object is
     *              {@link ETaskPriority }
     */
    public void setPriority(ETaskPriority value) {
        this.priority = value;
    }

    /**
     * Gets the value of the refType property.
     *
     * @return possible object is
     *         {@link ETaskRefType }
     */
    public ETaskRefType getRefType() {
        return refType;
    }

    /**
     * Sets the value of the refType property.
     *
     * @param value allowed object is
     *              {@link ETaskRefType }
     */
    public void setRefType(ETaskRefType value) {
        this.refType = value;
    }

    /**
     * Gets the value of the ref property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRef(Long value) {
        this.ref = value;
    }

    /**
     * Gets the value of the recurTask property.
     *
     * @return possible object is
     *         {@link RecurTaskData }
     */
    public RecurTaskData getRecurTask() {
        return recurTask;
    }

    /**
     * Sets the value of the recurTask property.
     *
     * @param value allowed object is
     *              {@link RecurTaskData }
     */
    public void setRecurTask(RecurTaskData value) {
        this.recurTask = value;
    }

}
