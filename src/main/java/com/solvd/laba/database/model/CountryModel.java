package com.solvd.laba.database.model;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

@JsonRootName("phone")
@XmlRootElement(name = "Country")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryModel {
    @XmlElement(name = "Id")
    @JsonProperty("countryId")
    private int countryId;

    @XmlElement(name = "Name")
    @JsonProperty("countryName")
    private String countryName;

    public CountryModel() {
    }

    public CountryModel(int countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    // Getters and setters
    @JsonProperty("CountryId")
    public int getCountryId() {
        return countryId;
    }

    @JsonProperty("CountryId")
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("CountryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("CountryName")
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
