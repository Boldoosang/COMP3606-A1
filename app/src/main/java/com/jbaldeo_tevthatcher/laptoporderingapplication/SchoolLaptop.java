package com.jbaldeo_tevthatcher.laptoporderingapplication;

public class SchoolLaptop extends Laptop{
    private Boolean touchScreen;


    public SchoolLaptop() {
        super("intel i3 8100H Quad Core Processor", "256GB SSD", "Windows 11 Home");
    }

    public Boolean getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Boolean touchScreen) {
        this.touchScreen = touchScreen;
    }
}
