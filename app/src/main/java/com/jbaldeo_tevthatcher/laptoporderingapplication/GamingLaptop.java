package com.jbaldeo_tevthatcher.laptoporderingapplication;

import android.os.Parcel;

import java.util.ArrayList;

public class GamingLaptop extends Laptop{
    private Boolean UHDDisplay;
    private Boolean coolingPad;
    private static double basePrice = 7000.00;

    public GamingLaptop() {
        super("intel i7 8750H Hexacore Processor", "1TB SSD", "Windows 11 Home", basePrice);
    }

    public Boolean getUHDDisplay() {
        return UHDDisplay;
    }

    public void setUHDDisplay(Boolean UHDDisplay) {
        this.UHDDisplay = UHDDisplay;
    }

    public Boolean getCoolingPad() {
        return coolingPad;
    }

    public void setCoolingPad(Boolean coolingPad) {
        this.coolingPad = coolingPad;
    }


    public String getCustomizationOptions(){
        String wantUHDDisplay = "No";
        String wantWebcam = "No";

        if(getWebcam())
            wantWebcam = "Yes";
        if(getUHDDisplay())
            wantUHDDisplay = "Yes";

        return "CUSTOMIZATION OPTIONS:\nWebcam: " + wantWebcam + "\n4K Display: " + wantUHDDisplay + "\n";
    }

    public String getAdditionalOptions(){
        String wantWirelessMouse = "No";
        String wantExtendedWarranty = "No";
        String wantCoolingPad = "No";

        if(getWarranty())
            wantExtendedWarranty = "Yes";
        if(getWirelessMouse())
            wantWirelessMouse = "Yes";
        if(getCoolingPad())
            wantCoolingPad = "Yes";

        return "ADDITIONAL OPTIONS:\nExtended Warranty: " + wantExtendedWarranty + "\nWireless Mouse: " + wantWirelessMouse + "\nCooling Pad: " + wantCoolingPad + "\n";
    }

    @Override
    public String toString(){
        return "GAMING LAPTOP\nProcessor: " + getProcessor() + "\nStorage: " + getStorage() + "\nOperating System: " + getOs() + "\nMemory: " + getRam() + "\n" + getCustomizationOptions() + getAdditionalOptions()+ "FINAL PRICE: $" + getFinalPrice()+ "\n\n";
    }

    public void calculateFinalPrice(){
        double webcamPrice = 0.00, UHDPrice = 0.00, RAMPrice = 0.00, warrantyPrice = 0.00, mousePrice = 0.00, coolerPrice = 0.00;
        if(getWebcam())
            webcamPrice = 300.00;
        if(getUHDDisplay())
            UHDPrice = 700.00;
        if(getRam().equals("24 GB RAM"))
            RAMPrice = 600.00;
        if(getWarranty())
            warrantyPrice = 350.00;
        if(getWirelessMouse())
            mousePrice = 100.00;
        if(getCoolingPad())
            coolerPrice = 200.00;

        setFinalPrice(basePrice+ webcamPrice + UHDPrice + RAMPrice + warrantyPrice + mousePrice + coolerPrice);
    }
}
