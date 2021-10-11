package com.jbaldeo_tevthatcher.laptoporderingapplication;

import java.util.ArrayList;

public class WorkLaptop extends Laptop{
    private Boolean touchScreen;
    private Boolean fingerprintScanner;

    public WorkLaptop() {
        super("intel i5 8300H Quad Core Processor", "512GB SSD", "Windows 11 Pro");
    }

    public Boolean getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public Boolean getFingerprintScanner() {
        return fingerprintScanner;
    }

    public void setFingerprintScanner(Boolean fingerprintScanner) {
        this.fingerprintScanner = fingerprintScanner;
    }
}
