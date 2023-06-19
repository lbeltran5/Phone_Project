package com.solvd.laba.jaxb;

import com.fasterxml.jackson.annotation.*;
import com.solvd.laba.database.model.*;


import javax.xml.bind.annotation.*;
import java.util.List;

@JsonRootName("phone")
@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneData {
    @XmlElementWrapper(name = "Brands")
    @XmlElement(name = "Brand")
    @JsonProperty("Brands")
    private List<BrandModel> brands;

    @XmlElementWrapper(name = "Countries")
    @XmlElement(name = "Country")
    @JsonProperty("Countries")
    private List<CountryModel> countries;

    @XmlElementWrapper(name = "OperatingSystems")
    @XmlElement(name = "OperatingSystem")
    @JsonProperty("OperatingSystems")
    private List<OperatingSystemModel> operatingSystems;

    @XmlElementWrapper(name = "Phones")
    @XmlElement(name = "Phone")
    @JsonProperty("Phones")
    private List<PhoneModel> phones;


    public List<PhoneModel> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneModel> phones) {
        this.phones = phones;
    }

    public List<BrandModel> getBrands() {
        return brands;
    }

    public void setBrands(List<BrandModel> brands) {
        this.brands = brands;
    }

    public List<CountryModel> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryModel> countries) {
        this.countries = countries;
    }

    public List<OperatingSystemModel> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(List<OperatingSystemModel> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }


    public BrandModel getBrandById(int brandId) {
        for (BrandModel brand : brands) {
            if (brand.getBrandId() == brandId) {
                return brand;
            }
        }
        return null;
    }

    public CountryModel getCountryById(int countryId) {
        List<CountryModel> countries = this.getCountries();
        for (CountryModel country : countries) {
            if (country.getCountryId() == countryId) {
                return country;
            }
        }
        return null; // Country not found
    }

    public OperatingSystemModel getOperatingSystemById(int osId) {
        for (OperatingSystemModel os : operatingSystems) {
            if (os.getOsId() == osId) {
                return os;
            }
        }
        return null;
    }

}
