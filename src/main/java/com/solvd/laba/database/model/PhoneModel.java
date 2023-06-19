package com.solvd.laba.database.model;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "Phone")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("phone")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneModel {
    @XmlElement(name = "Id")
    @JsonProperty("phoneId")
    private int phoneId;

    @XmlElement(name = "BrandId")
    @JsonProperty("brandId")
    private int brandId;

    @JsonProperty("osId")
    @XmlElement(name = "OperatingSystemId")
    private int osId;

    @JsonProperty("phoneName")
    @XmlElement(name = "Name")
    private String phoneModel;

    @JsonIgnore
    @XmlElement(name = "Price")
    private double price;

    @XmlElement(name = "Feature")
    @XmlElementWrapper(name = "Features")
    @XmlSchemaType(name = "Features")
    @JsonProperty("features")
    private List<String> features;

    public PhoneModel() {
    }

    public PhoneModel(int phoneId, int brandId, int osId, String phoneModel, double price) {
        this.phoneId = phoneId;
        this.brandId = brandId;
        this.osId = osId;
        this.phoneModel = phoneModel;
        this.price = price;
    }

    // Getters and setters
    @JsonProperty("PhoneId")
    public int getPhoneId() {
        return phoneId;
    }

    @JsonProperty("PhoneId")
    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    @JsonProperty("BrandId")
    public int getBrandId() {
        return brandId;
    }

    @JsonProperty("BrandId")
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @JsonProperty("OsId")
    public int getOsId() {
        return osId;
    }

    @JsonProperty("OsId")
    public void setOsId(int osId) {
        this.osId = osId;
    }

    @JsonProperty("PhoneName")
    public String getPhoneModel() {
        return phoneModel;
    }

    @JsonProperty("PhoneName")
    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    @JsonIgnore
    public double getPrice() {
        return price;
    }

    @JsonIgnore
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("Features")
    public List<String> getFeatures() {
        return features;
    }

    @JsonProperty("Features")
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
