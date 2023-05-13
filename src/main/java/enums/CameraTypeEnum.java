package enums;

public enum CameraTypeEnum {
    FRONT("Front Camera"),
    REAR("Rear Camera"),
    DUAL("Dual Camera");

    private final String description;

    // Constructor
    CameraTypeEnum(String description) {
        this.description = description;
    }

    // Getter method
    public String getDescription(){
        return  description;
    }

    // Static method
    public static void takePhoto(CameraTypeEnum cameraType){
        System.out.println("Taking photos using " + cameraType.description);
    }

    public static void recordVideo(CameraTypeEnum cameraType) {
        System.out.println("Recording a video using " + cameraType.description);
    }
}
