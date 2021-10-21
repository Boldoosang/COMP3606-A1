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
        File f = new File (getApplicationContext().getFilesDir(), "order.bin");
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

       pastOrders.add(order);

        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pastOrders);
    }

    public void onClickSendOrder(View view) throws Exception {
        if(order.isEmpty()){
            Toast toast = Toast.makeText(this, "Unable to send order. Cart is empty.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            saveOrder();
            String fullOrder = order.toString();


            order.laptopOrders.clear();
            Intent toBrowse = new Intent(CompleteOrder.this, BrowseActivity.class);
            toBrowse.putExtra("order", order);
            startActivity(toBrowse);

            Intent intent = new Intent().setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, fullOrder);
            intent.setType("text/plain");
            try {
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            } catch(Exception e){
                intent.setPackage(null);
                Toast toast = Toast.makeText(this, "Whatsapp not found. Defaulting to messenger.", Toast.LENGTH_SHORT);
                toast.show();
                startActivity(intent);
            }
            displayCart(order);
        }
    }
}