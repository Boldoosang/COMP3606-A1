package com.jbaldeo_tevthatcher.laptoporderingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {
    ArrayList<Laptop> currentCart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        if(savedInstanceState != null)
            currentCart = (ArrayList<Laptop>) savedInstanceState.getSerializable("currentCart");

        Order processingOrder = (Order) getIntent().getSerializableExtra("order");

        if(processingOrder != null){
            currentCart = processingOrder.getLaptopOrders();
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("currentCart", currentCart);
    }

    public void onClickAddToCartSchool(View view){
        SchoolLaptop schoolLaptop = new SchoolLaptop();

        CheckBox touchScreenButton = (CheckBox)findViewById(R.id.schoolLaptop_TouchScreenCheckbox);
        schoolLaptop.setTouchScreen(touchScreenButton.isChecked());


        CheckBox webcamButton = (CheckBox)findViewById(R.id.schoolLaptop_WebcamCheckbox);
        schoolLaptop.setWebcam(webcamButton.isChecked());


        RadioGroup RAMConfig = (RadioGroup)findViewById(R.id.schoolRAMOptionsRadioGroup);
        RadioButton selectedRAMButton = (RadioButton)findViewById(RAMConfig.getCheckedRadioButtonId());

        String RAMStringSchool = selectedRAMButton.getText().toString();

        if(RAMStringSchool.contains("6 GB RAM")){
            schoolLaptop.setRam("6 GB RAM");
        } else {
            schoolLaptop.setRam("8 GB RAM");
        }

        Switch warrantySwitch = (Switch)findViewById(R.id.schoolLaptop_extWarranty);
        schoolLaptop.setWarranty(warrantySwitch.isChecked());


        Switch wirelessMouseSwitch = (Switch)findViewById(R.id.schoolLaptop_mouse);
        schoolLaptop.setWirelessMouse(wirelessMouseSwitch.isChecked());


        Toast toast = Toast.makeText(this, "School Laptop added to cart.", Toast.LENGTH_SHORT);
        toast.show();

        schoolLaptop.calculateFinalPrice();

        currentCart.add(schoolLaptop);
    }


    public void onClickAddToCartWork(View view){
        WorkLaptop workLaptop = new WorkLaptop();

        CheckBox touchScreenButton = (CheckBox)findViewById(R.id.workLaptop_TouchScreenCheckbox);
        workLaptop.setTouchScreen(touchScreenButton.isChecked());

        CheckBox webcamButton = (CheckBox)findViewById(R.id.workLaptop_WebcamCheckbox);
        workLaptop.setWebcam(webcamButton.isChecked());

        CheckBox FingerprintScannerButton = (CheckBox)findViewById(R.id.workLaptop_FPSCheckbox);
        workLaptop.setFingerprintScanner(FingerprintScannerButton.isChecked());

        RadioGroup RAMConfig = (RadioGroup)findViewById(R.id.workRAMOptionsRadioGroup);
        RadioButton selectedRAMButton = (RadioButton)findViewById(RAMConfig.getCheckedRadioButtonId());
        String RAMStringSchool = selectedRAMButton.getText().toString();

        if(RAMStringSchool.contains("8 GB RAM")){
            workLaptop.setRam("8 GB RAM");
        } else {
            workLaptop.setRam("12 GB RAM");
        }

        Switch warrantySwitch = (Switch)findViewById(R.id.workLaptop_extWarranty);
        workLaptop.setWarranty(warrantySwitch.isChecked());

        Switch wirelessMouseSwitch = (Switch)findViewById(R.id.workLaptop_mouse);
        workLaptop.setWirelessMouse(wirelessMouseSwitch.isChecked());


        Toast toast = Toast.makeText(this, "Work Laptop added to cart.", Toast.LENGTH_SHORT);
        toast.show();

        workLaptop.calculateFinalPrice();

        currentCart.add(workLaptop);
    }


    public void onClickAddToCartGaming(View view){
        GamingLaptop gamingLaptop = new GamingLaptop();

        CheckBox webcamButton = (CheckBox)findViewById(R.id.gamingLaptop_WebcamCheckbox);
        gamingLaptop.setWebcam(webcamButton.isChecked());

        CheckBox UHDButton = (CheckBox)findViewById(R.id.gamingLaptop_4KCheckbox);
        gamingLaptop.setUHDDisplay(UHDButton.isChecked());

        RadioGroup RAMConfig = (RadioGroup)findViewById(R.id.gamingRAMOptionsRadioGroup);
        RadioButton selectedRAMButton = (RadioButton)findViewById(RAMConfig.getCheckedRadioButtonId());
        String RAMStringSchool = selectedRAMButton.getText().toString();

        if(RAMStringSchool.contains("16 GB RAM")){
            gamingLaptop.setRam("16 GB RAM");
        } else {
            gamingLaptop.setRam("24 GB RAM");
        }

        Switch warrantySwitch = (Switch)findViewById(R.id.gamingLaptop_extWarranty);
        gamingLaptop.setWarranty(warrantySwitch.isChecked());


        Switch wirelessMouseSwitch = (Switch)findViewById(R.id.gamingLaptop_mouse);
        gamingLaptop.setWirelessMouse(wirelessMouseSwitch.isChecked());

        Switch coolingPadSwitch = (Switch)findViewById(R.id.gamingLaptop_coolingPad);
        gamingLaptop.setCoolingPad(coolingPadSwitch.isChecked());


        Toast toast = Toast.makeText(this, "Gaming Laptop added to cart.", Toast.LENGTH_SHORT);
        toast.show();

        gamingLaptop.calculateFinalPrice();
        currentCart.add(gamingLaptop);
    }

    public void onClickCompleteOrder(View view){
        Order order = new Order (currentCart);
        Intent intent = new Intent(BrowseActivity.this, CompleteOrder.class);
        intent.putExtra("order", order);
        startActivity(intent);
    }

    public void onClickDisplayOrders(View view){
        Intent intent = new Intent(BrowseActivity.this, DisplayOrders.class);
        startActivity(intent);
    }

    public void onClickClearCart(View view){
        clearCart();
        Toast toast = Toast.makeText(this, "Cart has been cleared.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void clearCart(){
        currentCart.clear();
    }
}