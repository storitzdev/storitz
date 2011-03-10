
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEntryItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEntryItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntryItem" type="{http://www.centershift.com/STORE40/}EntryItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEntryItem", propOrder = {
    "entryItem"
})
public class ArrayOfEntryItem {

    @XmlElement(name = "EntryItem", nillable = true)
    protected List<EntryItem> entryItem;

    /**
     * Gets the value of the entryItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryItem }
     * 
     * 
     */
    public List<EntryItem> getEntryItem() {
        if (entryItem == null) {
            entryItem = new ArrayList<EntryItem>();
        }
        return this.entryItem;
    }

}
