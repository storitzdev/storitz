package com.centershift.store40;

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
 *         &lt;element name="LookupUser_Request" type="{http://www.centershift.com/STORE40/}LookupUser_Request"/>
 *         &lt;element name="Request" type="{http://www.centershift.com/STORE40/}Rules_Request"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "lookupUserRequest",
        "request"
})
@XmlRootElement(name = "GetSiteRuleValue")
public class GetSiteRuleValue {

    @XmlElement(name = "LookupUser_Request", required = true)
    protected LookupUserRequest lookupUserRequest;
    @XmlElement(name = "Request", required = true)
    protected RulesRequest request;

    /**
     * Gets the value of the lookupUserRequest property.
     *
     * @return possible object is
     *         {@link LookupUserRequest }
     */
    public LookupUserRequest getLookupUserRequest() {
        return lookupUserRequest;
    }

    /**
     * Sets the value of the lookupUserRequest property.
     *
     * @param value allowed object is
     *              {@link LookupUserRequest }
     */
    public void setLookupUserRequest(LookupUserRequest value) {
        this.lookupUserRequest = value;
    }

    /**
     * Gets the value of the request property.
     *
     * @return possible object is
     *         {@link RulesRequest }
     */
    public RulesRequest getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     *
     * @param value allowed object is
     *              {@link RulesRequest }
     */
    public void setRequest(RulesRequest value) {
        this.request = value;
    }

}
