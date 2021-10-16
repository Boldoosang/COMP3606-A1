package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CompleteOrder extends AppCompatActivity {
    //private ArrayList<Laptop> currentCart;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);

        order = (Order) getIntent().getSerializableExtra("order");
        displayCart(order);
    }

    public void displayCart(Order order){
        TextView orderDetails = (TextView)findViewById(R.id.currentOrderDetails);

        if(order.isEmpty()){
            orderDetails.setText("Cart is empty!");
        } else {
            String fullOrder = order.toString();
            orderDetails.setText(fullOrder);
        }
    }

    private File getStorageFile(){
        File f = new File (getApplicationContext().getFilesDir(), "order.txt");
        try{
            f.createNewFile();
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    private void saveOrder() throws Exception{
       ArrayList<Order> pastOrders;
       File f = getStorageFile();

       try {
           FileInputStream fis = new FileInputStream(f);
           ObjectInputStream ois = new ObjectInputStream(fis);
           pastOrders = (ArrayList<Order>) ois.readObject();
       }
       catch (Exception e){
           pastOrders = new ArrayList<Order>();
       }

       System.out.println(pastOrders);

       pastOrders.add(order);

        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pastOrders);
    }

    public void onClickSendOrder(View view) throws Exception {
        if(order.isEmpty()){
            Toast toast = Toast.makeText(this, "Unable to send order. Cart is empty.", 3);
            toast.show();
        } else {
            //saveOrder();
            String fullOrder = order.toString();

            Intent intent = new Intent().setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, fullOrder);
            intent.setType("text/plain");
            try {
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            } catch(Exception e){
                intent.setPackage(null);
                Toast toast = Toast.makeText(this, "Whatsapp not found. Defaulting to messenger.", 3);
                toast.show();
                startActivity(intent);
            }
        }
    }
}