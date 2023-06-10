package com.solvd.laba.database.model;


public class PhoneModel {
    private int phoneId;
    private int brandId;
    private int osId;
    private String phoneModel;
    private double price;

    public PhoneModel(int phoneId, int brandId, int osId, String phoneModel, double price) {
        this.phoneId = phoneId;
        this.brandId = brandId;
        this.osId = osId;
        this.phoneModel = phoneModel;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "PhoneModel{" +
                "phoneId=" + phoneId +
                ", brandId=" + brandId +
                ", osId=" + osId +
                ", phoneModel='" + phoneModel + '\'' +
                ", price=" + price +
                '}';
    }
}