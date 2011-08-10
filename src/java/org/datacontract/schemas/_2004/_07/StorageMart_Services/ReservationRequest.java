/**
 * ReservationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.StorageMart_Services;

public class ReservationRequest  implements java.io.Serializable {
    private java.lang.String customer_Email_Address;

    private java.lang.String customer_First_Name;

    private java.lang.String customer_Last_Name;

    private java.lang.String customer_Phone;

    private java.lang.String facility_Id;

    private java.lang.String move_In_Date;

    private java.lang.Double quoted_Price;

    private java.lang.Integer unit_Id;

    public ReservationRequest() {
    }

    public ReservationRequest(
           java.lang.String customer_Email_Address,
           java.lang.String customer_First_Name,
           java.lang.String customer_Last_Name,
           java.lang.String customer_Phone,
           java.lang.String facility_Id,
           java.lang.String move_In_Date,
           java.lang.Double quoted_Price,
           java.lang.Integer unit_Id) {
           this.customer_Email_Address = customer_Email_Address;
           this.customer_First_Name = customer_First_Name;
           this.customer_Last_Name = customer_Last_Name;
           this.customer_Phone = customer_Phone;
           this.facility_Id = facility_Id;
           this.move_In_Date = move_In_Date;
           this.quoted_Price = quoted_Price;
           this.unit_Id = unit_Id;
    }


    /**
     * Gets the customer_Email_Address value for this ReservationRequest.
     * 
     * @return customer_Email_Address
     */
    public java.lang.String getCustomer_Email_Address() {
        return customer_Email_Address;
    }


    /**
     * Sets the customer_Email_Address value for this ReservationRequest.
     * 
     * @param customer_Email_Address
     */
    public void setCustomer_Email_Address(java.lang.String customer_Email_Address) {
        this.customer_Email_Address = customer_Email_Address;
    }


    /**
     * Gets the customer_First_Name value for this ReservationRequest.
     * 
     * @return customer_First_Name
     */
    public java.lang.String getCustomer_First_Name() {
        return customer_First_Name;
    }


    /**
     * Sets the customer_First_Name value for this ReservationRequest.
     * 
     * @param customer_First_Name
     */
    public void setCustomer_First_Name(java.lang.String customer_First_Name) {
        this.customer_First_Name = customer_First_Name;
    }


    /**
     * Gets the customer_Last_Name value for this ReservationRequest.
     * 
     * @return customer_Last_Name
     */
    public java.lang.String getCustomer_Last_Name() {
        return customer_Last_Name;
    }


    /**
     * Sets the customer_Last_Name value for this ReservationRequest.
     * 
     * @param customer_Last_Name
     */
    public void setCustomer_Last_Name(java.lang.String customer_Last_Name) {
        this.customer_Last_Name = customer_Last_Name;
    }


    /**
     * Gets the customer_Phone value for this ReservationRequest.
     * 
     * @return customer_Phone
     */
    public java.lang.String getCustomer_Phone() {
        return customer_Phone;
    }


    /**
     * Sets the customer_Phone value for this ReservationRequest.
     * 
     * @param customer_Phone
     */
    public void setCustomer_Phone(java.lang.String customer_Phone) {
        this.customer_Phone = customer_Phone;
    }


    /**
     * Gets the facility_Id value for this ReservationRequest.
     * 
     * @return facility_Id
     */
    public java.lang.String getFacility_Id() {
        return facility_Id;
    }


    /**
     * Sets the facility_Id value for this ReservationRequest.
     * 
     * @param facility_Id
     */
    public void setFacility_Id(java.lang.String facility_Id) {
        this.facility_Id = facility_Id;
    }


    /**
     * Gets the move_In_Date value for this ReservationRequest.
     * 
     * @return move_In_Date
     */
    public java.lang.String getMove_In_Date() {
        return move_In_Date;
    }


    /**
     * Sets the move_In_Date value for this ReservationRequest.
     * 
     * @param move_In_Date
     */
    public void setMove_In_Date(java.lang.String move_In_Date) {
        this.move_In_Date = move_In_Date;
    }


    /**
     * Gets the quoted_Price value for this ReservationRequest.
     * 
     * @return quoted_Price
     */
    public java.lang.Double getQuoted_Price() {
        return quoted_Price;
    }


    /**
     * Sets the quoted_Price value for this ReservationRequest.
     * 
     * @param quoted_Price
     */
    public void setQuoted_Price(java.lang.Double quoted_Price) {
        this.quoted_Price = quoted_Price;
    }


    /**
     * Gets the unit_Id value for this ReservationRequest.
     * 
     * @return unit_Id
     */
    public java.lang.Integer getUnit_Id() {
        return unit_Id;
    }


    /**
     * Sets the unit_Id value for this ReservationRequest.
     * 
     * @param unit_Id
     */
    public void setUnit_Id(java.lang.Integer unit_Id) {
        this.unit_Id = unit_Id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReservationRequest)) return false;
        ReservationRequest other = (ReservationRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_Email_Address==null && other.getCustomer_Email_Address()==null) || 
             (this.customer_Email_Address!=null &&
              this.customer_Email_Address.equals(other.getCustomer_Email_Address()))) &&
            ((this.customer_First_Name==null && other.getCustomer_First_Name()==null) || 
             (this.customer_First_Name!=null &&
              this.customer_First_Name.equals(other.getCustomer_First_Name()))) &&
            ((this.customer_Last_Name==null && other.getCustomer_Last_Name()==null) || 
             (this.customer_Last_Name!=null &&
              this.customer_Last_Name.equals(other.getCustomer_Last_Name()))) &&
            ((this.customer_Phone==null && other.getCustomer_Phone()==null) || 
             (this.customer_Phone!=null &&
              this.customer_Phone.equals(other.getCustomer_Phone()))) &&
            ((this.facility_Id==null && other.getFacility_Id()==null) || 
             (this.facility_Id!=null &&
              this.facility_Id.equals(other.getFacility_Id()))) &&
            ((this.move_In_Date==null && other.getMove_In_Date()==null) || 
             (this.move_In_Date!=null &&
              this.move_In_Date.equals(other.getMove_In_Date()))) &&
            ((this.quoted_Price==null && other.getQuoted_Price()==null) || 
             (this.quoted_Price!=null &&
              this.quoted_Price.equals(other.getQuoted_Price()))) &&
            ((this.unit_Id==null && other.getUnit_Id()==null) || 
             (this.unit_Id!=null &&
              this.unit_Id.equals(other.getUnit_Id())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCustomer_Email_Address() != null) {
            _hashCode += getCustomer_Email_Address().hashCode();
        }
        if (getCustomer_First_Name() != null) {
            _hashCode += getCustomer_First_Name().hashCode();
        }
        if (getCustomer_Last_Name() != null) {
            _hashCode += getCustomer_Last_Name().hashCode();
        }
        if (getCustomer_Phone() != null) {
            _hashCode += getCustomer_Phone().hashCode();
        }
        if (getFacility_Id() != null) {
            _hashCode += getFacility_Id().hashCode();
        }
        if (getMove_In_Date() != null) {
            _hashCode += getMove_In_Date().hashCode();
        }
        if (getQuoted_Price() != null) {
            _hashCode += getQuoted_Price().hashCode();
        }
        if (getUnit_Id() != null) {
            _hashCode += getUnit_Id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReservationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "ReservationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_Email_Address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Customer_Email_Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_First_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Customer_First_Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_Last_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Customer_Last_Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_Phone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Customer_Phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("facility_Id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Facility_Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("move_In_Date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Move_In_Date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quoted_Price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Quoted_Price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unit_Id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Unit_Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
