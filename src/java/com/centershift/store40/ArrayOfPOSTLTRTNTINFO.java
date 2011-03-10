
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPOST_LTR_TNT_INFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPOST_LTR_TNT_INFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POST_LTR_TNT_INFO" type="{http://www.centershift.com/STORE40/}POST_LTR_TNT_INFO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPOST_LTR_TNT_INFO", propOrder = {
    "postltrtntinfo"
})
public class ArrayOfPOSTLTRTNTINFO {

    @XmlElement(name = "POST_LTR_TNT_INFO", nillable = true)
    protected List<POSTLTRTNTINFO> postltrtntinfo;

    /**
     * Gets the value of the postltrtntinfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the postltrtntinfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPOSTLTRTNTINFO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POSTLTRTNTINFO }
     * 
     * 
     */
    public List<POSTLTRTNTINFO> getPOSTLTRTNTINFO() {
        if (postltrtntinfo == null) {
            postltrtntinfo = new ArrayList<POSTLTRTNTINFO>();
        }
        return this.postltrtntinfo;
    }

}
