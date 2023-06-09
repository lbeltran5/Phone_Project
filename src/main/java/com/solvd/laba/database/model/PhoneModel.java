package com.solvd.laba.database.model;

public class PhoneModel {
    private final int phoneId;
    private int brandId;
    private int osId;
    private String phoneModel;
    private double price;
    private String countryId;
    private int processorId;

    public PhoneModel(int phoneId, int brandId, int osId, String phoneModel, double price, String countryId, int processorId) {
        this.phoneId = phoneId;
        this.brandId = brandId;
        this.osId = osId;
        this.phoneModel = phoneModel;
        this.price = price;
        this.countryId = countryId;
        this.processorId = processorId;
    }

    public int getPhoneId() {
        return phoneId;
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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public int getProcessorId() {
        return processorId;
    }

    public void setProcessorId(int processorId) {
        this.processorId = processorId;
    }

    @Override
    public String toString() {
        return "PhoneModel{" +
                "phoneId=" + phoneId +
                ", brandId=" + brandId +
                ", osId=" + osId +
                ", phoneModel='" + phoneModel + '\'' +
                ", price=" + price +
                ", countryId='" + countryId + '\'' +
                ", processorId=" + processorId +
                '}';
    }
}
