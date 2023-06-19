package com.solvd.laba.database.model;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

@JsonRootName("phone")
@XmlRootElement(name = "OperatingSystem")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperatingSystemModel {
    @XmlElement(name = "Id")
    @JsonProperty("osId")
    private int osId;

    @JsonProperty("osName")
    @XmlElement(name = "Name")
    private String operatingSysName;

    public OperatingSystemModel() {
    }

    // Constructors, getters, and setters
    public OperatingSystemModel(int osId, String operatingSysName) {
        this.osId = osId;
        this.operatingSysName = operatingSysName;
    }

    @JsonProperty("OsId")
    public int getOsId() {
        return osId;
    }

    @JsonProperty("OsName")
    public String getOperatingSysName() {
        return operatingSysName;
    }

    @JsonProperty("OsId")
    public void setOsId(int osId) {
        this.osId = osId;
    }

    @JsonProperty("OsName")
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

