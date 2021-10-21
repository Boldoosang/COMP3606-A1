package com.jbaldeo_tevthatcher.laptoporderingapplication;

import android.os.Parcelable;

import java.io.Serializable;

public abstract class Laptop implements Serializable{

    private String ram;
    private String processor;
    private String storage;
    private String os;
    private double basePrice;
    private double finalPrice;
    private Boolean warranty;
    private Boolean wirelessMouse;
    private Boolean webcam;

    public Laptop(String processor, String storage, String os, double basePrice) {
        this.processor = processor;
        this.storage = storage;
        this.os = os;
        this.basePrice = basePrice;
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

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

}
