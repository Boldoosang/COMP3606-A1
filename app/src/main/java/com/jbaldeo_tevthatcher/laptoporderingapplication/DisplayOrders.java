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

    ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_orders);
        try {
            orders = getOrders();
            displayOrders(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * The life cycle methods, such as onStart, onPause, onResume, onStop and onRestart, did not require any modification
     * as the application would have only changed state when interacting with the user. Furthermore, once this state was derived
     * it would remain static. Additionally, when the app is created or rebuilt via the onCreate method, it retrieves information
     * from the file which would then be used to display the order to the screen. Hence, it does not require the refinement of any lifecycle
     * methods as the state of the screen, as well as the information on the screen, would be retained when rotating, answering a call
     * and switching between tasks.
     * */

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }

    private ArrayList<Order> getOrders() throws Exception{

        File f = new File (getApplicationContext().getFilesDir(), "order.bin");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Order> orders = (ArrayList<Order>) ois.readObject();

        return orders;
    }

    private void displayOrders(ArrayList<Order> orders){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.pastOrderLinearLayout);
        double cumulativeTotal = 0;

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
            pastOrders.setTextColor(Color.BLACK);
            linearLayout.addView(pastOrders);

            cumulativeTotal += o.calcTotalOrder();
        }
        TextView total = new TextView(this);
        total.setText("GRAND TOTAL: $" + cumulativeTotal + "\n");
        total.setTypeface(null, Typeface.BOLD);
        total.setTextColor(Color.BLACK);
        total.setGravity(Gravity.CENTER);
        total.setTextSize(2,18);

        linearLayout.addView(total);
    }
}