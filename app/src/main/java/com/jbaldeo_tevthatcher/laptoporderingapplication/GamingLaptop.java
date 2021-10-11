package com.jbaldeo_tevthatcher.laptoporderingapplication;

import java.util.ArrayList;

public class GamingLaptop extends Laptop{
    private Boolean UHDDisplay;
    private Boolean coolingPad;

    public GamingLaptop() {
        super("intel i7 8750H Hexacore Processor", "1TB SSD", "Windows 11 Home");
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
}
