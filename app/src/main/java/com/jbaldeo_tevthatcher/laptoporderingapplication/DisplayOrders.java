package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DisplayOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_orders);
        try {
            doThing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doThing() throws Exception{

        getOrders();
    }

    private void getOrders() throws Exception{
        File f = new File (getApplicationContext().getFilesDir(), "order.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Order> orders = (ArrayList<Order>) ois.readObject();

        for(Order o: orders){
            System.out.println(orders.toString());
        }
    }
}