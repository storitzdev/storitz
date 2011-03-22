package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfACT_ACCOUNTS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfACT_ACCOUNTS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ACT_ACCOUNTS" type="{http://www.centershift.com/STORE40/}ACT_ACCOUNTS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfACT_ACCOUNTS", propOrder = {
        "actaccounts"
})
public class ArrayOfACTACCOUNTS {

    @XmlElement(name = "ACT_ACCOUNTS", nillable = true)
    protected List<ACTACCOUNTS> actaccounts;

    /**
     * Gets the value of the actaccounts property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actaccounts property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getACTACCOUNTS().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link ACTACCOUNTS }
     */
    public List<ACTACCOUNTS> getACTACCOUNTS() {
        if (actaccounts == null) {
            actaccounts = new ArrayList<ACTACCOUNTS>();
        }
        return this.actaccounts;
    }

}
