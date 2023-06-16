package com.solvd.laba.database.model;

import javax.xml.bind.annotation.*;
import java.util.Date;


@XmlRootElement(name = "Brand")
@XmlAccessorType(XmlAccessType.FIELD)
public class BrandModel {
    @XmlElement(name = "Id")
    private int brandId;

    @XmlElement(name = "Name")
    private String brandName;

    @XmlElement(name = "Date")
    @XmlSchemaType(name = "date")
    private Date creationDate;


    public BrandModel(int brandId, String brandName, Date creationDate) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.creationDate = creationDate;
    }

    // Getters and setters
    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Date getBrandFoundationDate() {
        return creationDate;
    }

    public void setBrandFoundationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "BrandModel{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }

}
