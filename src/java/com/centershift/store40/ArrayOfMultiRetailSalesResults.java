
package com.centershift.store40;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMultiRetailSalesResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMultiRetailSalesResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MultiRetailSalesResults" type="{http://www.centershift.com/STORE40/}MultiRetailSalesResults" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMultiRetailSalesResults", propOrder = {
    "multiRetailSalesResults"
})
public class ArrayOfMultiRetailSalesResults {

    @XmlElement(name = "MultiRetailSalesResults", nillable = true)
    protected List<MultiRetailSalesResults> multiRetailSalesResults;

    /**
     * Gets the value of the multiRetailSalesResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multiRetailSalesResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultiRetailSalesResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultiRetailSalesResults }
     * 
     * 
     */
    public List<MultiRetailSalesResults> getMultiRetailSalesResults() {
        if (multiRetailSalesResults == null) {
            multiRetailSalesResults = new ArrayList<MultiRetailSalesResults>();
        }
        return this.multiRetailSalesResults;
    }

}
