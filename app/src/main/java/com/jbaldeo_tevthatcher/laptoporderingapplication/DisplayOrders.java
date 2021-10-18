package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

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
            getOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void getOrders() throws Exception{
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.pastOrderLinearLayout);
        File f = new File (getApplicationContext().getFilesDir(), "order.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Order> orders = (ArrayList<Order>) ois.readObject();

        String pastOrderString = "";

        for(Order o: orders){
            TextView label = new TextView(this);
            label.setText("ORDER NUMBER: " + (orders.indexOf(o) + 1) + "\n");
            label.setTypeface(null, Typeface.BOLD);
            label.setTextColor(Color.BLACK);
            label.setGravity(Gravity.CENTER);
            label.setTextSize(2,18);

            linearLayout.addView(label);

            TextView pastOrders = new TextView(this);
            pastOrders.setText(o.toString() + "\n");
            linearLayout.addView(pastOrders);

            TextView total = new TextView(this);
            total.setText("ORDER TOTAL: $" + o.calcTotalOrder() + "\n");
            total.setTypeface(null, Typeface.BOLD);
            total.setTextColor(Color.BLACK);
            total.setGravity(Gravity.CENTER);
            total.setTextSize(2,18);

            linearLayout.addView(total);
        }
    }
}