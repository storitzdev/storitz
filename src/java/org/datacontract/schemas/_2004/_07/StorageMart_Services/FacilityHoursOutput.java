/**
 * FacilityHoursOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.StorageMart_Services;

public class FacilityHoursOutput  implements java.io.Serializable {
    private java.lang.String closed;

    private java.lang.String day;

    private java.lang.Boolean is_24_Hours;

    private java.lang.Boolean is_Closed;

    private java.lang.String open;

    public FacilityHoursOutput() {
    }

    public FacilityHoursOutput(
           java.lang.String closed,
           java.lang.String day,
           java.lang.Boolean is_24_Hours,
           java.lang.Boolean is_Closed,
           java.lang.String open) {
           this.closed = closed;
           this.day = day;
           this.is_24_Hours = is_24_Hours;
           this.is_Closed = is_Closed;
           this.open = open;
    }


    /**
     * Gets the closed value for this FacilityHoursOutput.
     * 
     * @return closed
     */
    public java.lang.String getClosed() {
        return closed;
    }


    /**
     * Sets the closed value for this FacilityHoursOutput.
     * 
     * @param closed
     */
    public void setClosed(java.lang.String closed) {
        this.closed = closed;
    }


    /**
     * Gets the day value for this FacilityHoursOutput.
     * 
     * @return day
     */
    public java.lang.String getDay() {
        return day;
    }


    /**
     * Sets the day value for this FacilityHoursOutput.
     * 
     * @param day
     */
    public void setDay(java.lang.String day) {
        this.day = day;
    }


    /**
     * Gets the is_24_Hours value for this FacilityHoursOutput.
     * 
     * @return is_24_Hours
     */
    public java.lang.Boolean getIs_24_Hours() {
        return is_24_Hours;
    }


    /**
     * Sets the is_24_Hours value for this FacilityHoursOutput.
     * 
     * @param is_24_Hours
     */
    public void setIs_24_Hours(java.lang.Boolean is_24_Hours) {
        this.is_24_Hours = is_24_Hours;
    }


    /**
     * Gets the is_Closed value for this FacilityHoursOutput.
     * 
     * @return is_Closed
     */
    public java.lang.Boolean getIs_Closed() {
        return is_Closed;
    }


    /**
     * Sets the is_Closed value for this FacilityHoursOutput.
     * 
     * @param is_Closed
     */
    public void setIs_Closed(java.lang.Boolean is_Closed) {
        this.is_Closed = is_Closed;
    }


    /**
     * Gets the open value for this FacilityHoursOutput.
     * 
     * @return open
     */
    public java.lang.String getOpen() {
        return open;
    }


    /**
     * Sets the open value for this FacilityHoursOutput.
     * 
     * @param open
     */
    public void setOpen(java.lang.String open) {
        this.open = open;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FacilityHoursOutput)) return false;
        FacilityHoursOutput other = (FacilityHoursOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.closed==null && other.getClosed()==null) || 
             (this.closed!=null &&
              this.closed.equals(other.getClosed()))) &&
            ((this.day==null && other.getDay()==null) || 
             (this.day!=null &&
              this.day.equals(other.getDay()))) &&
            ((this.is_24_Hours==null && other.getIs_24_Hours()==null) || 
             (this.is_24_Hours!=null &&
              this.is_24_Hours.equals(other.getIs_24_Hours()))) &&
            ((this.is_Closed==null && other.getIs_Closed()==null) || 
             (this.is_Closed!=null &&
              this.is_Closed.equals(other.getIs_Closed()))) &&
            ((this.open==null && other.getOpen()==null) || 
             (this.open!=null &&
              this.open.equals(other.getOpen())));
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
        if (getClosed() != null) {
            _hashCode += getClosed().hashCode();
        }
        if (getDay() != null) {
            _hashCode += getDay().hashCode();
        }
        if (getIs_24_Hours() != null) {
            _hashCode += getIs_24_Hours().hashCode();
        }
        if (getIs_Closed() != null) {
            _hashCode += getIs_Closed().hashCode();
        }
        if (getOpen() != null) {
            _hashCode += getOpen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FacilityHoursOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "FacilityHoursOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("closed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Closed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("day");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Day"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_24_Hours");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Is_24_Hours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_Closed");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Is_Closed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("open");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Open"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
