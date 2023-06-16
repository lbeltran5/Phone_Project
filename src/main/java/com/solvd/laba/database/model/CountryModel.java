package com.solvd.laba.database.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Country")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryModel {
    @XmlElement(name = "Id")
    private int countryId;

    @XmlElement(name = "Name")
    private String countryName;

    public CountryModel(int countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    // Getters and setters
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "CountryModel{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
