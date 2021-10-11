package com.jbaldeo_tevthatcher.laptoporderingapplication;

import java.util.ArrayList;

public class WorkLaptop {
    private String processor;
    private String ram;
    private String storage;
    private String os;
    private ArrayList<String> features;
    private Boolean warranty;
    private Boolean wirelessMouse;

    public WorkLaptop() {
        processor = "intel i5 8300H Quad Core Processor";
        storage = "512GB SSD";
        os = "Windows 11 Pro";
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public ArrayList<String> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<String> features) {
        this.features = features;
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
}
