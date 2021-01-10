package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Drinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
    }
    public void onClickAirMineral(View view) {
        Intent intent = new Intent(this, AirMineral.class);
        startActivity(intent);
    }
    public void onClickJusApel(View view) {
        Intent intent = new Intent(this, JusApel.class);
        startActivity(intent);
    }
    public void onClickJusMangga(View view) {
        Intent intent = new Intent(this, JusMangga.class);
        startActivity(intent);
    }
    public void onClickJusAlpukat(View view) {
        Intent intent = new Intent(this, JusAlpukat.class);
        startActivity(intent);
    }
    public void onClickMyOrder(View view) {
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }


}
