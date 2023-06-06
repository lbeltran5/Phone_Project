package com.solvd.laba.enums;

public enum PhoneColorEnum {
    BLACK("Midnight Black"),
    WHITE("Smoke White"),
    GOLD("Gold Stone"),
    RED("Ruby Red");

    private final String colorName;

    // Constructor
    PhoneColorEnum(String colorName) {
        this.colorName = colorName;
    }

    // Getter method
    public String getColorName() {
        return colorName;
    }

    // Other methods
    public void printColorInfo() {
        System.out.println("Colors available in: " + colorName);
    }
}