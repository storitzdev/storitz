package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfMakeReservation_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ArrayOfMakeReservation_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MakeReservation_Request" type="{http://www.centershift.com/STORE40/}MakeReservation_Request" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMakeReservation_Request", propOrder = {
        "makeReservationRequest"
})
public class ArrayOfMakeReservationRequest {

    @XmlElement(name = "MakeReservation_Request")
    protected List<MakeReservationRequest> makeReservationRequest;

    /**
     * Gets the value of the makeReservationRequest property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the makeReservationRequest property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMakeReservationRequest().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link MakeReservationRequest }
     */
    public List<MakeReservationRequest> getMakeReservationRequest() {
        if (makeReservationRequest == null) {
            makeReservationRequest = new ArrayList<MakeReservationRequest>();
        }
        return this.makeReservationRequest;
    }

}
