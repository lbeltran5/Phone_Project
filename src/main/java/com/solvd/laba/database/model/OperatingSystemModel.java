package com.solvd.laba.database.model;

public class OperatingSystemModel {
    private int osId;
    private String operatingSysName;

    // Constructors, getters, and setters
    public OperatingSystemModel(int osId, String operatingSysName) {
        this.osId = osId;
        this.operatingSysName = operatingSysName;
    }

    public int getOsId() {
        return osId;
    }

    public String getOperatingSysName() {
        return operatingSysName;
    }

    public void setOsId(int osId) {
        this.osId = osId;
    }

    public void setOperatingSysName(String operatingSysName) {
        this.operatingSysName = operatingSysName;
    }
}
