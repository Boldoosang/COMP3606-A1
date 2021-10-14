package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CompleteOrder extends AppCompatActivity {
    private ArrayList<String> currentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);

        currentCart = getIntent().getExtras().getStringArrayList("currentCart");
        displayCart(currentCart);
    }

    public void displayCart(ArrayList<String> currentCart){
        TextView orderDetails = (TextView)findViewById(R.id.currentOrderDetails);

        if(currentCart.isEmpty()){
            orderDetails.setText("Cart is empty!");
        } else {
            String fullOrder = "";
            for(String i: currentCart){
                fullOrder += i;
            }
            orderDetails.setText(fullOrder);
        }
    }

    public void onClickSendOrder(View view){
        if(currentCart.isEmpty()){
            Toast toast = Toast.makeText(this, "Unable to send order. Cart is empty.", 3);
            toast.show();
        } else {
            String fullOrder = "";
            for (String i : currentCart) {
                fullOrder += i;
            }
            Intent intent = new Intent().setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, fullOrder);
            intent.setType("text/plain");
            //intent.setPackage("com.whatsapp");
            startActivity(intent);
        }
    }
}