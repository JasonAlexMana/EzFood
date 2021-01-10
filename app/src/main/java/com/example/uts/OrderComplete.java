package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        TextView TotalQty = (TextView) findViewById(R.id.TotalBar);
        TotalQty.setText("Total: Rp. " + DataHolder.getTotal() + ",-\n");
        TextView AirMineralQty = (TextView) findViewById(R.id.AirMineralTotal);
        AirMineralQty.setText("Air Mineral\nRp. " + DataHolder.getAirMineral() * 123 + ",-");
        TextView JusApelQty = (TextView) findViewById(R.id.JusApelTotal);
        JusApelQty.setText("Jus Apel\nRp. " + DataHolder.getJusApel() * 123 + ",-");
        TextView JusManggaQty = (TextView) findViewById(R.id.JusManggaTotal);
        JusManggaQty.setText("Jus Mangga\nRp. " + DataHolder.getJusMangga() * 123 + ",-");
        TextView JusAlpukatQty = (TextView) findViewById(R.id.JusAlpukatTotal);
        JusAlpukatQty.setText("Jus Alpukat\nRp. " + DataHolder.getJusAlpukat() * 123 + ",-");

        if(DataHolder.getAirMineral() > 0) {
            AirMineralQty.setVisibility(View.VISIBLE);
        }
        else {
            AirMineralQty.setVisibility(View.GONE);
        }
        if(DataHolder.getJusApel() > 0) {
            JusApelQty.setVisibility(View.VISIBLE);
        }
        else {
            JusApelQty.setVisibility(View.GONE);
        }
        if(DataHolder.getJusMangga() > 0) {
            JusManggaQty.setVisibility(View.VISIBLE);
        }
        else {
            JusManggaQty.setVisibility(View.GONE);
        }
        if(DataHolder.getJusAlpukat() > 0) {
            JusAlpukatQty.setVisibility(View.VISIBLE);
        }
        else {
            JusAlpukatQty.setVisibility(View.GONE);
        }

    }

    public void onClickDrinks (View view) {

        DataHolder.setAirMineral(0);
        DataHolder.setJusApel(0);
        DataHolder.setJusMangga(0);
        DataHolder.setJusAlpukat(0);

        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }
    }

