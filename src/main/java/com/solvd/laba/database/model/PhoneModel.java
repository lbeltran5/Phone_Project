package com.solvd.laba.database.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneModel {
    @XmlElement(name = "Id")
    private int phoneId;

    @XmlElement(name = "BrandId")
    private int brandId;

    @XmlElement(name = "OperatingSystemId")
    private int osId;

    @XmlElement(name = "Name")
    private String phoneModel;

    @XmlElement(name = "Price")
    private double price;

    @XmlElement(name = "Feature")
    @XmlElementWrapper(name = "Features")
    @XmlSchemaType(name = "feature")
    private List<String> features;

    public PhoneModel(int phoneId, int brandId, int osId, String phoneModel, double price) {
        this.phoneId = phoneId;
        this.brandId = brandId;
        this.osId = osId;
        this.phoneModel = phoneModel;
        this.price = price;
    }

    // Getters and setters
    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getOsId() {
        return osId;
    }

    public void setOsId(int osId) {
        this.osId = osId;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "PhoneModel{" +
                "phoneId=" + phoneId +
                ", brandId=" + brandId +
                ", osId=" + osId +
                ", phoneModel='" + phoneModel + '\'' +
                ", price=" + price +
                ", features=" + features +
                '}';
    }
}
