package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slMouseSwitchListener();
        slWarrantySwitchListener();
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
            System.out.println("webcam");
    }

    public void slRamClicked(View view) {
        RadioButton radioButton = ((RadioButton) view);
        boolean checked = radioButton.isChecked();

        switch(view.getId()){
            case R.id.school6GBRAM:
                if(checked)
                    System.out.println("6GB RAM");
                break;
            case R.id.school8GBRAM:
                if(checked)
                    System.out.println("8GB RAM");
        }
    }

    public void slWarrantySwitchListener() {
        Switch warrantySwitch = (Switch) findViewById(R.id.schoolLaptop_extWarranty);
        warrantySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    System.out.println("Warranty selected");
                } else {
                    // The toggle is disabled
                    System.out.println("Warranty not selected");
                }
            }
        });
    }

    public void slMouseSwitchListener() {
        CompoundButton mouseSwitch = (Switch) findViewById(R.id.schoolLaptop_mouse);
        mouseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    System.out.println("Mouse selected");
                } else {
                    // The toggle is disabled
                    System.out.println("Mouse not selected");
                }
            }
        });
    }
}