package com.jbaldeo_tevthatcher.laptoporderingapplication;

public class SchoolLaptop extends Laptop{
    private Boolean touchScreen;
    private static double basePrice = 3000.00;

    public SchoolLaptop() {
        super("Intel i3 8100H Quad Core Processor", "256GB SSD", "Windows 11 Home", basePrice);
    }

    public Boolean getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public String getCustomizationOptions(){
        String wantTouchscreen = "No";
        String wantWebcam = "No";
        if(getTouchScreen())
            wantTouchscreen = "Yes";

        if(getWebcam())
            wantWebcam = "Yes";

        return "CUSTOMIZATION OPTIONS:\nTouchscreen: " + wantTouchscreen + "\nWebcam: " + wantWebcam + "\n";
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

    public void calculateFinalPrice(){
        double touchscreenPrice = 0.00, webcamPrice = 0.00, RAMPrice = 0.00, warrantyPrice = 0.00, mousePrice = 0.00;
        if(getTouchScreen())
            touchscreenPrice = 500.00;
        if(getWebcam())
            webcamPrice = 300.00;
        if(getRam().equals("8 GB RAM"))
            RAMPrice = 200.00;
        if(getWarranty())
            warrantyPrice = 350.00;
        if(getWirelessMouse())
            mousePrice = 100.00;

        setFinalPrice(basePrice+ touchscreenPrice + webcamPrice + RAMPrice + warrantyPrice + mousePrice);
    }

    @Override
    public String toString(){
        return "SCHOOL LAPTOP\nProcessor: " + getProcessor() + "\nStorage: " + getStorage() + "\nOperating System: " + getOs() + "\nMemory: " + getRam() + "\n" + getCustomizationOptions() + getAdditionalOptions()+ "FINAL PRICE: $" + getFinalPrice()+ "\n\n";
    }
}
