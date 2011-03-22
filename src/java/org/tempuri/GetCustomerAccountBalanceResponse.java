package org.tempuri;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCustomerAccountBalanceResult" type="{http://tempuri.org/}ArrayOfGetCustomerAccountBalance_ST" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getCustomerAccountBalanceResult"
})
@XmlRootElement(name = "GetCustomerAccountBalanceResponse")
public class GetCustomerAccountBalanceResponse {

    @XmlElement(name = "GetCustomerAccountBalanceResult")
    protected ArrayOfGetCustomerAccountBalanceST getCustomerAccountBalanceResult;

    /**
     * Gets the value of the getCustomerAccountBalanceResult property.
     *
     * @return possible object is
     *         {@link ArrayOfGetCustomerAccountBalanceST }
     */
    public ArrayOfGetCustomerAccountBalanceST getGetCustomerAccountBalanceResult() {
        return getCustomerAccountBalanceResult;
    }

    /**
     * Sets the value of the getCustomerAccountBalanceResult property.
     *
     * @param value allowed object is
     *              {@link ArrayOfGetCustomerAccountBalanceST }
     */
    public void setGetCustomerAccountBalanceResult(ArrayOfGetCustomerAccountBalanceST value) {
        this.getCustomerAccountBalanceResult = value;
    }

}
