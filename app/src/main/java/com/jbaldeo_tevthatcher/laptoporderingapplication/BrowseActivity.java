package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;

public class BrowseActivity extends AppCompatActivity {
    Laptop schoolLaptop;
    Laptop workLaptop;
    Laptop gamingLaptop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        schoolLaptop = new SchoolLaptop();
        slMouseSwitchListener();
        slWarrantySwitchListener();
    }

    public void onClickCompleteOrder(View view){
        Intent intent = new Intent(BrowseActivity.this, CompleteOrder.class);
        intent.putExtra(CompleteOrder.EXTRA_COMPLETE_ORDER_DETAILS, "test");
        startActivity(intent);
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }

    public void slTouchScreenCheckbox(View view) {
        CheckBox touchScreen = ((CheckBox) view);
        boolean checked = touchScreen.isChecked();

        if(checked)
            System.out.println("touchscreen");
    }

    public void slWebcamCheckbox(View view) {
        CheckBox webcam = ((CheckBox) view);
        boolean checked = webcam.isChecked();

        if(checked)
            schoolLaptop.setWebcam(true);
        else
            schoolLaptop.setWebcam(false);
    }

    public void slRamClicked(View view) {
        RadioButton radioButton = ((RadioButton) view);
        boolean checked = radioButton.isChecked();

        switch(view.getId()){
            case R.id.school6GBRAM:
                if(checked)
                    schoolLaptop.setRam("6GB RAM");
                    System.out.println(schoolLaptop.toString());
                break;
            case R.id.school8GBRAM:
                if(checked)
                    schoolLaptop.setRam("8GB RAM");
        }
    }

    public void slWarrantySwitchListener() {
        Switch warrantySwitch = (Switch) findViewById(R.id.schoolLaptop_extWarranty);
        warrantySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    schoolLaptop.setWarranty(true);
                } else {
                    // The toggle is disabled
                    schoolLaptop.setWarranty(false);
                }
            }
        });
    }

    public void slMouseSwitchListener() {
        CompoundButton mouseSwitch = (Switch) findViewById(R.id.schoolLaptop_mouse);
        mouseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    schoolLaptop.setWirelessMouse(true);
                } else {
                    schoolLaptop.setWirelessMouse(false);
                }
            }
        });
    }

    public void addSchoolLaptopCart(View view){

    }
}