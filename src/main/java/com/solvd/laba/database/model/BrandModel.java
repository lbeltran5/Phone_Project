package com.solvd.laba.database.model;

import javax.xml.bind.annotation.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.*;

@JsonRootName("phone")
@XmlRootElement(name = "Brand")
@XmlAccessorType(XmlAccessType.FIELD)
public class BrandModel {
    @XmlElement(name = "Id")
    @JsonProperty("brandId")
    private int brandId;

    @XmlElement(name = "Name")
    @JsonProperty("brandName")
    private String brandName;

    @XmlElement(name = "Date")
    @XmlSchemaType(name = "Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("brandFoundationDate") // Add this annotation to map the JSON property "Date" to the "brandFoundationDate" field
    private Date brandFoundationDate;

    public BrandModel() {
    }

    public BrandModel(int brandId, String brandName, Date brandFoundationDate) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandFoundationDate = brandFoundationDate;
    }

    // Getters and setters
    @JsonProperty("BrandId")
    public int getBrandId() {
        return brandId;
    }

    @JsonProperty("BrandId")
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @JsonProperty("BrandName")
    public String getBrandName() {
        return brandName;
    }

    @JsonProperty("BrandName")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("Date")
    public Date getBrandFoundationDate() {
        return brandFoundationDate;
    }

    @JsonProperty("Date")
    public void setBrandFoundationDate(Date brandFoundationDate) {
        this.brandFoundationDate = brandFoundationDate;
    }

    @Override
    public String toString() {
        return "BrandModel{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }

}
