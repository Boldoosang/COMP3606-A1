package com.jbaldeo_tevthatcher.laptoporderingapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    ArrayList<Laptop> laptopOrders;

    public Order(ArrayList<Laptop> currentCart) {
        laptopOrders = new ArrayList<Laptop>();
        laptopOrders = currentCart;
    }

    public ArrayList<Laptop> getLaptopOrders() {
        return laptopOrders;
    }

    public double calcTotalOrder(){
        double totalOrder = 0;
        for(Laptop i: laptopOrders){
            totalOrder+= i.getFinalPrice();
        }
        return totalOrder;
    }

    public String toString(){
        String orderString = "";
        for(Laptop i: laptopOrders){
            orderString += i.toString();
        }
        orderString += "\n ORDER TOTAL: $" + calcTotalOrder();
        return orderString;
    }

    public Boolean isEmpty(){
        if(laptopOrders.isEmpty())
            return true;
        else
            return false;
    }
}
