package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfPRINT_LEASE_DOCS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfPRINT_LEASE_DOCS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PRINT_LEASE_DOCS" type="{http://www.centershift.com/STORE40/}PRINT_LEASE_DOCS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPRINT_LEASE_DOCS", propOrder = {
        "printleasedocs"
})
public class ArrayOfPRINTLEASEDOCS {

    @XmlElement(name = "PRINT_LEASE_DOCS", nillable = true)
    protected List<PRINTLEASEDOCS> printleasedocs;

    /**
     * Gets the value of the printleasedocs property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the printleasedocs property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPRINTLEASEDOCS().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link PRINTLEASEDOCS }
     */
    public List<PRINTLEASEDOCS> getPRINTLEASEDOCS() {
        if (printleasedocs == null) {
            printleasedocs = new ArrayList<PRINTLEASEDOCS>();
        }
        return this.printleasedocs;
    }

}
