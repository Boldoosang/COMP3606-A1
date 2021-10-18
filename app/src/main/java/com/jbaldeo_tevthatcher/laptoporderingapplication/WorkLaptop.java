package com.jbaldeo_tevthatcher.laptoporderingapplication;

import java.util.ArrayList;

public class WorkLaptop extends Laptop{
    private Boolean touchScreen;
    private Boolean fingerprintScanner;
    private static double basePrice = 5000.00;

    public WorkLaptop() {
        super("intel i5 8300H Quad Core Processor", "512GB SSD", "Windows 11 Pro", basePrice);
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

    public String getCustomizationOptions(){
        String wantTouchscreen = "No";
        String wantFingerprintScanner = "No";
        String wantWebcam = "No";

        if(getWebcam())
            wantWebcam = "Yes";
        if(getTouchScreen())
            wantTouchscreen = "Yes";
        if(getFingerprintScanner())
            wantFingerprintScanner = "Yes";

        return "CUSTOMIZATION OPTIONS:\nTouchscreen: " + wantTouchscreen + "\nWebcam: " + wantWebcam + "\nFingerprint Scanner: " + wantFingerprintScanner + "\n";
    }

    public String getAdditionalOptions(){
        String wantWirelessMouse = "No";
        String wantExtendedWarranty = "No";

        if(getWarranty())
            wantExtendedWarranty = "Yes";
        if(getWirelessMouse())
            wantWirelessMouse = "Yes";

        return "ADDITIONAL OPTIONS:\nExtended Warranty: " + wantExtendedWarranty + "\nWireless Mouse: " + wantWirelessMouse + "\n";
    }

    @Override
    public String toString(){
        return "WORK LAPTOP\nProcessor: " + getProcessor() + "\nStorage: " + getStorage() + "\nOperating System: " + getOs() + "\nMemory: " + getRam() + "\n" + getCustomizationOptions() + getAdditionalOptions()+ "FINAL PRICE: $" + getFinalPrice()+ "\n\n";
    }

    public void calculateFinalPrice(){
        double touchscreenPrice = 0.00, webcamPrice = 0.00, FPSPrice = 0.00, RAMPrice = 0.00, warrantyPrice = 0.00, mousePrice = 0.00;
        if(getTouchScreen())
            touchscreenPrice = 500.00;
        if(getWebcam())
            webcamPrice = 300.00;
        if(getFingerprintScanner())
            FPSPrice = 300.00;
        if(getRam().equals("12 GB RAM"))
            RAMPrice = 400.00;
        if(getWarranty())
            warrantyPrice = 350.00;
        if(getWirelessMouse())
            mousePrice = 100.00;

        setFinalPrice(basePrice+ touchscreenPrice + webcamPrice + FPSPrice + RAMPrice + warrantyPrice + mousePrice);
    }

}
