package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchBy_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SearchBy_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchType" type="{http://www.centershift.com/STORE40/}SearchTypes"/>
 *         &lt;element name="SearchTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchBy_Request", propOrder = {
        "searchType",
        "searchTerm",
        "siteID",
        "orgID"
})
public class SearchByRequest {

    @XmlElement(name = "SearchType", required = true)
    protected SearchTypes searchType;
    @XmlElement(name = "SearchTerm")
    protected String searchTerm;
    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "OrgID", required = true, type = Long.class, nillable = true)
    protected Long orgID;

    /**
     * Gets the value of the searchType property.
     *
     * @return possible object is
     *         {@link SearchTypes }
     */
    public SearchTypes getSearchType() {
        return searchType;
    }

    /**
     * Sets the value of the searchType property.
     *
     * @param value allowed object is
     *              {@link SearchTypes }
     */
    public void setSearchType(SearchTypes value) {
        this.searchType = value;
    }

    /**
     * Gets the value of the searchTerm property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * Sets the value of the searchTerm property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSearchTerm(String value) {
        this.searchTerm = value;
    }

    /**
     * Gets the value of the siteID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSiteID(Long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the orgID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setOrgID(Long value) {
        this.orgID = value;
    }

}
