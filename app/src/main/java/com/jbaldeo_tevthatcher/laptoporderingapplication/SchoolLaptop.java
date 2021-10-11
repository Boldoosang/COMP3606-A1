package com.jbaldeo_tevthatcher.laptoporderingapplication;

public class SchoolLaptop {
    private String processor;
    private String ram;
    private String storage;
    private String os;
    private Boolean touchScreen;
    private Boolean webcam;
    private Boolean warranty;
    private Boolean wirelessMouse;

    public SchoolLaptop() {
        processor = "intel i3 8100H Quad Core Processor";
        storage = "256GB SSD";
        os = "Windows 11 Home";
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public Boolean getWarranty() {
        return warranty;
    }

    public Boolean getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public Boolean getWebcam() {
        return webcam;
    }

    public void setWebcam(Boolean webcam) {
        this.webcam = webcam;
    }

    public void setWarranty(Boolean warranty) {
        this.warranty = warranty;
    }

    public Boolean getWirelessMouse() {
        return wirelessMouse;
    }

    public void setWirelessMouse(Boolean wirelessMouse) {
        this.wirelessMouse = wirelessMouse;
    }
}
