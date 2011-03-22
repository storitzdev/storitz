package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfTRAN_RETAIL_SOLD complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfTRAN_RETAIL_SOLD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TRAN_RETAIL_SOLD" type="{http://www.centershift.com/STORE40/}TRAN_RETAIL_SOLD" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTRAN_RETAIL_SOLD", propOrder = {
        "tranretailsold"
})
public class ArrayOfTRANRETAILSOLD {

    @XmlElement(name = "TRAN_RETAIL_SOLD", nillable = true)
    protected List<TRANRETAILSOLD> tranretailsold;

    /**
     * Gets the value of the tranretailsold property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tranretailsold property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRANRETAILSOLD().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link TRANRETAILSOLD }
     */
    public List<TRANRETAILSOLD> getTRANRETAILSOLD() {
        if (tranretailsold == null) {
            tranretailsold = new ArrayList<TRANRETAILSOLD>();
        }
        return this.tranretailsold;
    }

}
