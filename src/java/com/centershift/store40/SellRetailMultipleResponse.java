package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SellRetailMultiple_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SellRetailMultiple_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SalesResults" type="{http://www.centershift.com/STORE40/}ArrayOfMultiRetailSalesResults" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRetailMultiple_Response", propOrder = {
        "salesResults"
})
public class SellRetailMultipleResponse {

    @XmlElement(name = "SalesResults")
    protected ArrayOfMultiRetailSalesResults salesResults;

    /**
     * Gets the value of the salesResults property.
     *
     * @return possible object is
     *         {@link ArrayOfMultiRetailSalesResults }
     */
    public ArrayOfMultiRetailSalesResults getSalesResults() {
        return salesResults;
    }

    /**
     * Sets the value of the salesResults property.
     *
     * @param value allowed object is
     *              {@link ArrayOfMultiRetailSalesResults }
     */
    public void setSalesResults(ArrayOfMultiRetailSalesResults value) {
        this.salesResults = value;
    }

}
