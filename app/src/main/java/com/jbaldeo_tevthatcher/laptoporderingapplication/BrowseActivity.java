package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {
    ArrayList<Laptop> currentCart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        //currentCart = savedInstanceState.getStringArrayList("currentCart");
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putStringArrayList("currentCart", currentCart);
    }

//    protected void onPause(Bundle savedInstanceState) {
//        super.onPause();
//        savedInstanceState.putStringArrayList("currentCart", currentCart);
//    }
//
//    protected void onResume(Bundle savedInstanceState) {
//        super.onResume();
//        currentCart = savedInstanceState.getStringArrayList("currentCart");
//    }
//
//    protected void onStop(Bundle savedInstanceState) {
//        super.onStop();
//
//    }
//
//    protected void onStart(Bundle savedInstanceState) {
//        super.onStart();
//
//    }

    public void onClickAddToCartSchool(View view){
        SchoolLaptop schoolLaptop = new SchoolLaptop();

        CheckBox touchScreenButton = (CheckBox)findViewById(R.id.schoolLaptop_TouchScreenCheckbox);
        if(touchScreenButton.isChecked()){
            schoolLaptop.setTouchScreen(true);
        } else {
            schoolLaptop.setTouchScreen(false);
        }

        CheckBox webcamButton = (CheckBox)findViewById(R.id.schoolLaptop_WebcamCheckbox);
        if(webcamButton.isChecked()){
            schoolLaptop.setWebcam(true);
        } else {
            schoolLaptop.setWebcam(false);
        }

        RadioGroup RAMConfig = (RadioGroup)findViewById(R.id.schoolRAMOptionsRadioGroup);
        RadioButton selectedRAMButton = (RadioButton)findViewById(RAMConfig.getCheckedRadioButtonId());

        String RAMStringSchool = selectedRAMButton.getText().toString();

        if(RAMStringSchool.contains("6 GB RAM")){
            schoolLaptop.setRam("6 GB RAM");
        } else {
            schoolLaptop.setRam("8 GB RAM");
        }

        Switch warrantySwitch = (Switch)findViewById(R.id.schoolLaptop_extWarranty);
        if(warrantySwitch.isChecked()){
            schoolLaptop.setWarranty(true);
        } else {
            schoolLaptop.setWarranty(false);
        }

        Switch wirelessMouseSwitch = (Switch)findViewById(R.id.schoolLaptop_mouse);
        if(wirelessMouseSwitch.isChecked()){
            schoolLaptop.setWirelessMouse(true);
        } else {
            schoolLaptop.setWirelessMouse(false);
        }

        Toast toast = Toast.makeText(this, "School Laptop added to cart.", 3);
        toast.show();

        currentCart.add(schoolLaptop);
        System.out.println(schoolLaptop.toString());
    }


    public void onClickAddToCartWork(View view){
        WorkLaptop workLaptop = new WorkLaptop();

        CheckBox touchScreenButton = (CheckBox)findViewById(R.id.workLaptop_TouchScreenCheckbox);
        if(touchScreenButton.isChecked()){
            workLaptop.setTouchScreen(true);
        } else {
            workLaptop.setTouchScreen(false);
        }

        CheckBox webcamButton = (CheckBox)findViewById(R.id.workLaptop_WebcamCheckbox);
        if(webcamButton.isChecked()){
            workLaptop.setWebcam(true);
        } else {
            workLaptop.setWebcam(false);
        }

        CheckBox FingerprintScannerButton = (CheckBox)findViewById(R.id.workLaptop_FPSCheckbox);
        if(FingerprintScannerButton.isChecked()){
            workLaptop.setFingerprintScanner(true);
        } else {
            workLaptop.setFingerprintScanner(false);
        }

        RadioGroup RAMConfig = (RadioGroup)findViewById(R.id.workRAMOptionsRadioGroup);
        RadioButton selectedRAMButton = (RadioButton)findViewById(RAMConfig.getCheckedRadioButtonId());
        String RAMStringSchool = selectedRAMButton.getText().toString();

        if(RAMStringSchool.contains("8 GB RAM")){
            workLaptop.setRam("8 GB RAM");
        } else {
            workLaptop.setRam("12 GB RAM");
        }

        Switch warrantySwitch = (Switch)findViewById(R.id.workLaptop_extWarranty);
        if(warrantySwitch.isChecked()){
            workLaptop.setWarranty(true);
        } else {
            workLaptop.setWarranty(false);
        }

        Switch wirelessMouseSwitch = (Switch)findViewById(R.id.workLaptop_mouse);
        if(wirelessMouseSwitch.isChecked()){
            workLaptop.setWirelessMouse(true);
        } else {
            workLaptop.setWirelessMouse(false);
        }

        Toast toast = Toast.makeText(this, "Work Laptop added to cart.", 3);
        toast.show();

        System.out.println(workLaptop.toString());
        currentCart.add(workLaptop);
    }


    public void onClickAddToCartGaming(View view){
        GamingLaptop gamingLaptop = new GamingLaptop();

        CheckBox webcamButton = (CheckBox)findViewById(R.id.gamingLaptop_WebcamCheckbox);
        if(webcamButton.isChecked()){
            gamingLaptop.setWebcam(true);
        } else {
            gamingLaptop.setWebcam(false);
        }

        CheckBox UHDButton = (CheckBox)findViewById(R.id.gamingLaptop_4KCheckbox);
        if(UHDButton.isChecked()){
            gamingLaptop.setUHDDisplay(true);
        } else {
            gamingLaptop.setUHDDisplay(false);
        }

        RadioGroup RAMConfig = (RadioGroup)findViewById(R.id.gamingRAMOptionsRadioGroup);
        RadioButton selectedRAMButton = (RadioButton)findViewById(RAMConfig.getCheckedRadioButtonId());
        String RAMStringSchool = selectedRAMButton.getText().toString();

        if(RAMStringSchool.contains("16 GB RAM")){
            gamingLaptop.setRam("16 GB RAM");
        } else {
            gamingLaptop.setRam("24 GB RAM");
        }

        Switch warrantySwitch = (Switch)findViewById(R.id.gamingLaptop_extWarranty);
        if(warrantySwitch.isChecked()){
            gamingLaptop.setWarranty(true);
        } else {
            gamingLaptop.setWarranty(false);
        }

        Switch wirelessMouseSwitch = (Switch)findViewById(R.id.gamingLaptop_mouse);
        if(wirelessMouseSwitch.isChecked()){
            gamingLaptop.setWirelessMouse(true);
        } else {
            gamingLaptop.setWirelessMouse(false);
        }

        Switch coolingPadSwitch = (Switch)findViewById(R.id.gamingLaptop_coolingPad);
        if(coolingPadSwitch.isChecked()){
            gamingLaptop.setCoolingPad(true);
        } else {
            gamingLaptop.setCoolingPad(false);
        }

        Toast toast = Toast.makeText(this, "Gaming Laptop added to cart.", 3);
        toast.show();

        System.out.println(gamingLaptop.getRam());
        System.out.println(gamingLaptop.toString());
        currentCart.add(gamingLaptop);
    }

    public void onClickCompleteOrder(View view){
        Order order = new Order (currentCart);
        Intent intent = new Intent(BrowseActivity.this, CompleteOrder.class);
        intent.putExtra("order", order);
        startActivity(intent);
        order.laptopOrders.clear();
    }

    public void onClickDisplayOrders(View view){
        Intent intent = new Intent(BrowseActivity.this, DisplayOrders.class);
        startActivity(intent);
    }

    public void onClickClearCart(View view){
        currentCart.clear();
        Toast toast = Toast.makeText(this, "Cart has been cleared.", 3);
        toast.show();
    }
}