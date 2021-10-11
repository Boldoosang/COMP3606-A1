package com.jbaldeo_tevthatcher.laptoporderingapplication;

import java.util.ArrayList;

public class Order {
    ArrayList<Laptop> laptopOrders;

    public Order() {
        laptopOrders = new ArrayList<Laptop>();
    }

    public ArrayList<Laptop> getLaptopOrders() {
        return laptopOrders;
    }

    public void setLaptopOrders(ArrayList<Laptop> laptopOrders) {
        this.laptopOrders = laptopOrders;
    }

}
