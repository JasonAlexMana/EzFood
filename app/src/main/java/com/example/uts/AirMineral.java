package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AirMineral extends AppCompatActivity {
    EditText AirQty;

    private boolean isNumeric(String a) {
        for(int i = 0; i < a.length(); ++i) {
            if(a.charAt(i) < '0' || a.charAt(i) > '9') {
                System.out.println("INPUT MUST BE A NUMBER");
                return false;
            }
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_mineral);

        AirQty = (EditText) findViewById(R.id.AirMineralNumber);
        AirQty.setText(Integer.toString(DataHolder.getAirMineral()));
    }
    public void onClickButtonDrinks (View view) {
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }

    public void onClickButtonAirInc(View view) {
        int Air = DataHolder.getAirMineral() + 1;
        DataHolder.setAirMineral(Air);
        AirQty.setText(Integer.toString(Air));
    }

    public void onClickButtonAirDec(View view) {
        int Air = DataHolder.getAirMineral() - 1;
        if(Air < 0) {
            Air = 0;
        }
        DataHolder.setAirMineral(Air);
        AirQty.setText(Integer.toString(Air));
    }
    public void onClickMyOrder(View view) {
        AirQty = (EditText) findViewById(R.id.AirMineralNumber);

        try {
            int n = 0;
            if (isNumeric(String.valueOf(AirQty.getEditableText())) == true) {
                n = Integer.parseInt(String.valueOf(AirQty.getEditableText()));
            }
            DataHolder.setAirMineral(n);
        }
        catch (Exception e) {
            int n = 0;
            DataHolder.setAirMineral(n);
        }
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }

}
