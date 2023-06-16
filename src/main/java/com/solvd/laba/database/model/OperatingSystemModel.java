package com.solvd.laba.database.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "OperatingSystem")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperatingSystemModel {
    @XmlElement(name = "Id")
    private int osId;
    @XmlElement(name = "Name")
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

    @Override
    public String toString() {
        return "OperatingSystemModel{" +
                "osId=" + osId +
                ", operatingSysName='" + operatingSysName + '\'' +
                '}';
    }
}

