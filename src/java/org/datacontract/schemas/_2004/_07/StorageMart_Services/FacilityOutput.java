/**
 * FacilityOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.StorageMart_Services;

public class FacilityOutput  implements java.io.Serializable {
    private org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput[] access_Hours;

    private java.lang.String address;

    private java.lang.Double admin_Fee;

    private java.lang.String city;

    private java.lang.String description;

    private java.lang.String facility_Id;

    private java.lang.Boolean has_24_Hour_Access;

    private java.lang.Boolean has_Electronic_Gate_Access;

    private java.lang.Boolean has_Free_Truck_Rental;

    private java.lang.Boolean has_Handcarts;

    private java.lang.Boolean has_Loading_Dock;

    private java.lang.Boolean has_Surveillance_Cameras;

    private java.lang.Boolean has_Truck_Rental;

    private java.lang.String[] image_Urls;

    private java.lang.Boolean is_Fenced_And_Lighted;

    private java.lang.Double loading_Dock_Size;

    private java.lang.String[] manager_Email_Address;

    private java.lang.String name;

    private org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput[] office_Hours;

    private java.lang.String phone;

    private java.lang.String promotion;

    private java.lang.String promotionLongFormText;

    private java.lang.String state;

    private java.lang.String zip;

    public FacilityOutput() {
    }

    public FacilityOutput(
           org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput[] access_Hours,
           java.lang.String address,
           java.lang.Double admin_Fee,
           java.lang.String city,
           java.lang.String description,
           java.lang.String facility_Id,
           java.lang.Boolean has_24_Hour_Access,
           java.lang.Boolean has_Electronic_Gate_Access,
           java.lang.Boolean has_Free_Truck_Rental,
           java.lang.Boolean has_Handcarts,
           java.lang.Boolean has_Loading_Dock,
           java.lang.Boolean has_Surveillance_Cameras,
           java.lang.Boolean has_Truck_Rental,
           java.lang.String[] image_Urls,
           java.lang.Boolean is_Fenced_And_Lighted,
           java.lang.Double loading_Dock_Size,
           java.lang.String[] manager_Email_Address,
           java.lang.String name,
           org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput[] office_Hours,
           java.lang.String phone,
           java.lang.String promotion,
           java.lang.String promotionLongFormText,
           java.lang.String state,
           java.lang.String zip) {
           this.access_Hours = access_Hours;
           this.address = address;
           this.admin_Fee = admin_Fee;
           this.city = city;
           this.description = description;
           this.facility_Id = facility_Id;
           this.has_24_Hour_Access = has_24_Hour_Access;
           this.has_Electronic_Gate_Access = has_Electronic_Gate_Access;
           this.has_Free_Truck_Rental = has_Free_Truck_Rental;
           this.has_Handcarts = has_Handcarts;
           this.has_Loading_Dock = has_Loading_Dock;
           this.has_Surveillance_Cameras = has_Surveillance_Cameras;
           this.has_Truck_Rental = has_Truck_Rental;
           this.image_Urls = image_Urls;
           this.is_Fenced_And_Lighted = is_Fenced_And_Lighted;
           this.loading_Dock_Size = loading_Dock_Size;
           this.manager_Email_Address = manager_Email_Address;
           this.name = name;
           this.office_Hours = office_Hours;
           this.phone = phone;
           this.promotion = promotion;
           this.promotionLongFormText = promotionLongFormText;
           this.state = state;
           this.zip = zip;
    }


    /**
     * Gets the access_Hours value for this FacilityOutput.
     * 
     * @return access_Hours
     */
    public org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput[] getAccess_Hours() {
        return access_Hours;
    }


    /**
     * Sets the access_Hours value for this FacilityOutput.
     * 
     * @param access_Hours
     */
    public void setAccess_Hours(org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput[] access_Hours) {
        this.access_Hours = access_Hours;
    }


    /**
     * Gets the address value for this FacilityOutput.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this FacilityOutput.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the admin_Fee value for this FacilityOutput.
     * 
     * @return admin_Fee
     */
    public java.lang.Double getAdmin_Fee() {
        return admin_Fee;
    }


    /**
     * Sets the admin_Fee value for this FacilityOutput.
     * 
     * @param admin_Fee
     */
    public void setAdmin_Fee(java.lang.Double admin_Fee) {
        this.admin_Fee = admin_Fee;
    }


    /**
     * Gets the city value for this FacilityOutput.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return city;
    }


    /**
     * Sets the city value for this FacilityOutput.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the description value for this FacilityOutput.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this FacilityOutput.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the facility_Id value for this FacilityOutput.
     * 
     * @return facility_Id
     */
    public java.lang.String getFacility_Id() {
        return facility_Id;
    }


    /**
     * Sets the facility_Id value for this FacilityOutput.
     * 
     * @param facility_Id
     */
    public void setFacility_Id(java.lang.String facility_Id) {
        this.facility_Id = facility_Id;
    }


    /**
     * Gets the has_24_Hour_Access value for this FacilityOutput.
     * 
     * @return has_24_Hour_Access
     */
    public java.lang.Boolean getHas_24_Hour_Access() {
        return has_24_Hour_Access;
    }


    /**
     * Sets the has_24_Hour_Access value for this FacilityOutput.
     * 
     * @param has_24_Hour_Access
     */
    public void setHas_24_Hour_Access(java.lang.Boolean has_24_Hour_Access) {
        this.has_24_Hour_Access = has_24_Hour_Access;
    }


    /**
     * Gets the has_Electronic_Gate_Access value for this FacilityOutput.
     * 
     * @return has_Electronic_Gate_Access
     */
    public java.lang.Boolean getHas_Electronic_Gate_Access() {
        return has_Electronic_Gate_Access;
    }


    /**
     * Sets the has_Electronic_Gate_Access value for this FacilityOutput.
     * 
     * @param has_Electronic_Gate_Access
     */
    public void setHas_Electronic_Gate_Access(java.lang.Boolean has_Electronic_Gate_Access) {
        this.has_Electronic_Gate_Access = has_Electronic_Gate_Access;
    }


    /**
     * Gets the has_Free_Truck_Rental value for this FacilityOutput.
     * 
     * @return has_Free_Truck_Rental
     */
    public java.lang.Boolean getHas_Free_Truck_Rental() {
        return has_Free_Truck_Rental;
    }


    /**
     * Sets the has_Free_Truck_Rental value for this FacilityOutput.
     * 
     * @param has_Free_Truck_Rental
     */
    public void setHas_Free_Truck_Rental(java.lang.Boolean has_Free_Truck_Rental) {
        this.has_Free_Truck_Rental = has_Free_Truck_Rental;
    }


    /**
     * Gets the has_Handcarts value for this FacilityOutput.
     * 
     * @return has_Handcarts
     */
    public java.lang.Boolean getHas_Handcarts() {
        return has_Handcarts;
    }


    /**
     * Sets the has_Handcarts value for this FacilityOutput.
     * 
     * @param has_Handcarts
     */
    public void setHas_Handcarts(java.lang.Boolean has_Handcarts) {
        this.has_Handcarts = has_Handcarts;
    }


    /**
     * Gets the has_Loading_Dock value for this FacilityOutput.
     * 
     * @return has_Loading_Dock
     */
    public java.lang.Boolean getHas_Loading_Dock() {
        return has_Loading_Dock;
    }


    /**
     * Sets the has_Loading_Dock value for this FacilityOutput.
     * 
     * @param has_Loading_Dock
     */
    public void setHas_Loading_Dock(java.lang.Boolean has_Loading_Dock) {
        this.has_Loading_Dock = has_Loading_Dock;
    }


    /**
     * Gets the has_Surveillance_Cameras value for this FacilityOutput.
     * 
     * @return has_Surveillance_Cameras
     */
    public java.lang.Boolean getHas_Surveillance_Cameras() {
        return has_Surveillance_Cameras;
    }


    /**
     * Sets the has_Surveillance_Cameras value for this FacilityOutput.
     * 
     * @param has_Surveillance_Cameras
     */
    public void setHas_Surveillance_Cameras(java.lang.Boolean has_Surveillance_Cameras) {
        this.has_Surveillance_Cameras = has_Surveillance_Cameras;
    }


    /**
     * Gets the has_Truck_Rental value for this FacilityOutput.
     * 
     * @return has_Truck_Rental
     */
    public java.lang.Boolean getHas_Truck_Rental() {
        return has_Truck_Rental;
    }


    /**
     * Sets the has_Truck_Rental value for this FacilityOutput.
     * 
     * @param has_Truck_Rental
     */
    public void setHas_Truck_Rental(java.lang.Boolean has_Truck_Rental) {
        this.has_Truck_Rental = has_Truck_Rental;
    }


    /**
     * Gets the image_Urls value for this FacilityOutput.
     * 
     * @return image_Urls
     */
    public java.lang.String[] getImage_Urls() {
        return image_Urls;
    }


    /**
     * Sets the image_Urls value for this FacilityOutput.
     * 
     * @param image_Urls
     */
    public void setImage_Urls(java.lang.String[] image_Urls) {
        this.image_Urls = image_Urls;
    }


    /**
     * Gets the is_Fenced_And_Lighted value for this FacilityOutput.
     * 
     * @return is_Fenced_And_Lighted
     */
    public java.lang.Boolean getIs_Fenced_And_Lighted() {
        return is_Fenced_And_Lighted;
    }


    /**
     * Sets the is_Fenced_And_Lighted value for this FacilityOutput.
     * 
     * @param is_Fenced_And_Lighted
     */
    public void setIs_Fenced_And_Lighted(java.lang.Boolean is_Fenced_And_Lighted) {
        this.is_Fenced_And_Lighted = is_Fenced_And_Lighted;
    }


    /**
     * Gets the loading_Dock_Size value for this FacilityOutput.
     * 
     * @return loading_Dock_Size
     */
    public java.lang.Double getLoading_Dock_Size() {
        return loading_Dock_Size;
    }


    /**
     * Sets the loading_Dock_Size value for this FacilityOutput.
     * 
     * @param loading_Dock_Size
     */
    public void setLoading_Dock_Size(java.lang.Double loading_Dock_Size) {
        this.loading_Dock_Size = loading_Dock_Size;
    }


    /**
     * Gets the manager_Email_Address value for this FacilityOutput.
     * 
     * @return manager_Email_Address
     */
    public java.lang.String[] getManager_Email_Address() {
        return manager_Email_Address;
    }


    /**
     * Sets the manager_Email_Address value for this FacilityOutput.
     * 
     * @param manager_Email_Address
     */
    public void setManager_Email_Address(java.lang.String[] manager_Email_Address) {
        this.manager_Email_Address = manager_Email_Address;
    }


    /**
     * Gets the name value for this FacilityOutput.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this FacilityOutput.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the office_Hours value for this FacilityOutput.
     * 
     * @return office_Hours
     */
    public org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput[] getOffice_Hours() {
        return office_Hours;
    }


    /**
     * Sets the office_Hours value for this FacilityOutput.
     * 
     * @param office_Hours
     */
    public void setOffice_Hours(org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput[] office_Hours) {
        this.office_Hours = office_Hours;
    }


    /**
     * Gets the phone value for this FacilityOutput.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this FacilityOutput.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the promotion value for this FacilityOutput.
     * 
     * @return promotion
     */
    public java.lang.String getPromotion() {
        return promotion;
    }


    /**
     * Sets the promotion value for this FacilityOutput.
     * 
     * @param promotion
     */
    public void setPromotion(java.lang.String promotion) {
        this.promotion = promotion;
    }


    /**
     * Gets the promotionLongFormText value for this FacilityOutput.
     * 
     * @return promotionLongFormText
     */
    public java.lang.String getPromotionLongFormText() {
        return promotionLongFormText;
    }


    /**
     * Sets the promotionLongFormText value for this FacilityOutput.
     * 
     * @param promotionLongFormText
     */
    public void setPromotionLongFormText(java.lang.String promotionLongFormText) {
        this.promotionLongFormText = promotionLongFormText;
    }


    /**
     * Gets the state value for this FacilityOutput.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this FacilityOutput.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the zip value for this FacilityOutput.
     * 
     * @return zip
     */
    public java.lang.String getZip() {
        return zip;
    }


    /**
     * Sets the zip value for this FacilityOutput.
     * 
     * @param zip
     */
    public void setZip(java.lang.String zip) {
        this.zip = zip;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FacilityOutput)) return false;
        FacilityOutput other = (FacilityOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.access_Hours==null && other.getAccess_Hours()==null) || 
             (this.access_Hours!=null &&
              java.util.Arrays.equals(this.access_Hours, other.getAccess_Hours()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.admin_Fee==null && other.getAdmin_Fee()==null) || 
             (this.admin_Fee!=null &&
              this.admin_Fee.equals(other.getAdmin_Fee()))) &&
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.facility_Id==null && other.getFacility_Id()==null) || 
             (this.facility_Id!=null &&
              this.facility_Id.equals(other.getFacility_Id()))) &&
            ((this.has_24_Hour_Access==null && other.getHas_24_Hour_Access()==null) || 
             (this.has_24_Hour_Access!=null &&
              this.has_24_Hour_Access.equals(other.getHas_24_Hour_Access()))) &&
            ((this.has_Electronic_Gate_Access==null && other.getHas_Electronic_Gate_Access()==null) || 
             (this.has_Electronic_Gate_Access!=null &&
              this.has_Electronic_Gate_Access.equals(other.getHas_Electronic_Gate_Access()))) &&
            ((this.has_Free_Truck_Rental==null && other.getHas_Free_Truck_Rental()==null) || 
             (this.has_Free_Truck_Rental!=null &&
              this.has_Free_Truck_Rental.equals(other.getHas_Free_Truck_Rental()))) &&
            ((this.has_Handcarts==null && other.getHas_Handcarts()==null) || 
             (this.has_Handcarts!=null &&
              this.has_Handcarts.equals(other.getHas_Handcarts()))) &&
            ((this.has_Loading_Dock==null && other.getHas_Loading_Dock()==null) || 
             (this.has_Loading_Dock!=null &&
              this.has_Loading_Dock.equals(other.getHas_Loading_Dock()))) &&
            ((this.has_Surveillance_Cameras==null && other.getHas_Surveillance_Cameras()==null) || 
             (this.has_Surveillance_Cameras!=null &&
              this.has_Surveillance_Cameras.equals(other.getHas_Surveillance_Cameras()))) &&
            ((this.has_Truck_Rental==null && other.getHas_Truck_Rental()==null) || 
             (this.has_Truck_Rental!=null &&
              this.has_Truck_Rental.equals(other.getHas_Truck_Rental()))) &&
            ((this.image_Urls==null && other.getImage_Urls()==null) || 
             (this.image_Urls!=null &&
              java.util.Arrays.equals(this.image_Urls, other.getImage_Urls()))) &&
            ((this.is_Fenced_And_Lighted==null && other.getIs_Fenced_And_Lighted()==null) || 
             (this.is_Fenced_And_Lighted!=null &&
              this.is_Fenced_And_Lighted.equals(other.getIs_Fenced_And_Lighted()))) &&
            ((this.loading_Dock_Size==null && other.getLoading_Dock_Size()==null) || 
             (this.loading_Dock_Size!=null &&
              this.loading_Dock_Size.equals(other.getLoading_Dock_Size()))) &&
            ((this.manager_Email_Address==null && other.getManager_Email_Address()==null) || 
             (this.manager_Email_Address!=null &&
              java.util.Arrays.equals(this.manager_Email_Address, other.getManager_Email_Address()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.office_Hours==null && other.getOffice_Hours()==null) || 
             (this.office_Hours!=null &&
              java.util.Arrays.equals(this.office_Hours, other.getOffice_Hours()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.promotion==null && other.getPromotion()==null) || 
             (this.promotion!=null &&
              this.promotion.equals(other.getPromotion()))) &&
            ((this.promotionLongFormText==null && other.getPromotionLongFormText()==null) || 
             (this.promotionLongFormText!=null &&
              this.promotionLongFormText.equals(other.getPromotionLongFormText()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.zip==null && other.getZip()==null) || 
             (this.zip!=null &&
              this.zip.equals(other.getZip())));
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
        if (getAccess_Hours() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccess_Hours());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccess_Hours(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getAdmin_Fee() != null) {
            _hashCode += getAdmin_Fee().hashCode();
        }
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getFacility_Id() != null) {
            _hashCode += getFacility_Id().hashCode();
        }
        if (getHas_24_Hour_Access() != null) {
            _hashCode += getHas_24_Hour_Access().hashCode();
        }
        if (getHas_Electronic_Gate_Access() != null) {
            _hashCode += getHas_Electronic_Gate_Access().hashCode();
        }
        if (getHas_Free_Truck_Rental() != null) {
            _hashCode += getHas_Free_Truck_Rental().hashCode();
        }
        if (getHas_Handcarts() != null) {
            _hashCode += getHas_Handcarts().hashCode();
        }
        if (getHas_Loading_Dock() != null) {
            _hashCode += getHas_Loading_Dock().hashCode();
        }
        if (getHas_Surveillance_Cameras() != null) {
            _hashCode += getHas_Surveillance_Cameras().hashCode();
        }
        if (getHas_Truck_Rental() != null) {
            _hashCode += getHas_Truck_Rental().hashCode();
        }
        if (getImage_Urls() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getImage_Urls());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getImage_Urls(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIs_Fenced_And_Lighted() != null) {
            _hashCode += getIs_Fenced_And_Lighted().hashCode();
        }
        if (getLoading_Dock_Size() != null) {
            _hashCode += getLoading_Dock_Size().hashCode();
        }
        if (getManager_Email_Address() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getManager_Email_Address());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getManager_Email_Address(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOffice_Hours() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOffice_Hours());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOffice_Hours(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getPromotion() != null) {
            _hashCode += getPromotion().hashCode();
        }
        if (getPromotionLongFormText() != null) {
            _hashCode += getPromotionLongFormText().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getZip() != null) {
            _hashCode += getZip().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FacilityOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "FacilityOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("access_Hours");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Access_Hours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "FacilityHoursOutput"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "FacilityHoursOutput"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("admin_Fee");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Admin_Fee"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "City"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Description"));
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
        elemField.setFieldName("has_24_Hour_Access");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Has_24_Hour_Access"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("has_Electronic_Gate_Access");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Has_Electronic_Gate_Access"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("has_Free_Truck_Rental");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Has_Free_Truck_Rental"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("has_Handcarts");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Has_Handcarts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("has_Loading_Dock");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Has_Loading_Dock"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("has_Surveillance_Cameras");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Has_Surveillance_Cameras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("has_Truck_Rental");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Has_Truck_Rental"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("image_Urls");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Image_Urls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_Fenced_And_Lighted");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Is_Fenced_And_Lighted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loading_Dock_Size");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Loading_Dock_Size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("manager_Email_Address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Manager_Email_Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("office_Hours");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Office_Hours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "FacilityHoursOutput"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "FacilityHoursOutput"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promotion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Promotion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("promotionLongFormText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "PromotionLongFormText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "State"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zip");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/StorageMart_Services", "Zip"));
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
