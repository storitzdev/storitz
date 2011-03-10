
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateSiteTask_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateSiteTask_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaskID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateSiteTask_Response", propOrder = {
    "taskID"
})
public class CreateSiteTaskResponse2 {

    @XmlElement(name = "TaskID")
    protected long taskID;

    /**
     * Gets the value of the taskID property.
     * 
     */
    public long getTaskID() {
        return taskID;
    }

    /**
     * Sets the value of the taskID property.
     * 
     */
    public void setTaskID(long value) {
        this.taskID = value;
    }

}
