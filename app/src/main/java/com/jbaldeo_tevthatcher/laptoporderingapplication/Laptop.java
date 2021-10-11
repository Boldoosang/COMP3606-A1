package com.jbaldeo_tevthatcher.laptoporderingapplication;

public abstract class Laptop {
    private String ram;
    private String processor;
    private String storage;
    private String os;
    private Boolean warranty;
    private Boolean wirelessMouse;
    private Boolean webcam;

    public Laptop(String processor, String storage, String os) {
        this.processor = processor;
        this.storage = storage;
        this.os = os;
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

    public void setWarranty(Boolean warranty) {
        this.warranty = warranty;
    }

    public Boolean getWirelessMouse() {
        return wirelessMouse;
    }

    public void setWirelessMouse(Boolean wirelessMouse) {
        this.wirelessMouse = wirelessMouse;
    }

    public Boolean getWebcam() {
        return webcam;
    }

    public void setWebcam(Boolean webcam) {
        this.webcam = webcam;
    }

    public String getProcessor() {
        return processor;
    }

    public String getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "ram='" + ram + '\'' +
                ", processor='" + processor + '\'' +
                ", storage='" + storage + '\'' +
                ", os='" + os + '\'' +
                ", warranty=" + warranty +
                ", wirelessMouse=" + wirelessMouse +
                ", webcam=" + webcam +
                '}';
    }
}
