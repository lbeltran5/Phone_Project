package enums;

public enum DisplayTypeEnum {
    LCD("LCD Display"),
    OLED("OLED Display"),
    AMOLED("AMOLED Display");

    private final String description;

    // Constructor
    DisplayTypeEnum(String description) {
        this.description = description;
    }

    // Getter method
    public String getDescription() {
        return description;
    }

    // Static method
    public static void showContent(DisplayTypeEnum displayType) {
        System.out.println("Displaying content on " + displayType.description);
    }

    public static void adjustBrightness(DisplayTypeEnum displayType, int level) {
        System.out.println("Adjusting brightness to level " + level + " on " + displayType.description);
    }
}
