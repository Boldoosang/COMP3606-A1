package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class CompleteOrder extends AppCompatActivity {
    public static String EXTRA_COMPLETE_ORDER_DETAILS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);
    }
}