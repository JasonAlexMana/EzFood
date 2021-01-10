package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

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

        Button DeleteAir = (Button) findViewById(R.id.DeleteAirMineral);
        Button DeleteApel = (Button) findViewById(R.id.DeleteJusApel);
        Button DeleteMangga = (Button) findViewById(R.id.DeleteJusMangga);
        Button DeleteAlpukat = (Button) findViewById(R.id.DeleteJusAlpukat);

        if(DataHolder.getAirMineral() > 0) {
            AirMineralQty.setVisibility(View.VISIBLE);
            DeleteAir.setVisibility(View.VISIBLE);
        }
        if(DataHolder.getJusApel() > 0) {
            JusApelQty.setVisibility(View.VISIBLE);
            DeleteApel.setVisibility(View.VISIBLE);
        }
        if(DataHolder.getJusMangga() > 0) {
            JusManggaQty.setVisibility(View.VISIBLE);
            DeleteMangga.setVisibility(View.VISIBLE);
        }
        if(DataHolder.getJusAlpukat() > 0) {
            JusAlpukatQty.setVisibility(View.VISIBLE);
            DeleteAlpukat.setVisibility(View.VISIBLE);
        }

    }
    public void onClickDeleteAir (View view) {
        TextView AirMineralQty = (TextView) findViewById(R.id.AirMineralTotal);
        Button DeleteAir = (Button) findViewById(R.id.DeleteAirMineral);
        DataHolder.setAirMineral(0);
        AirMineralQty.setVisibility(View.GONE);
        DeleteAir.setVisibility(View.GONE);
        TextView TotalQty = (TextView) findViewById(R.id.TotalBar);
        TotalQty.setText("Total: Rp. " + DataHolder.getTotal() + ",-\n");
    }

    public void onClickDeleteApel (View view) {
        TextView JusApelQty = (TextView) findViewById(R.id.JusApelTotal);
        Button DeleteApel = (Button) findViewById(R.id.DeleteJusApel);
        DataHolder.setJusApel(0);
        JusApelQty.setVisibility(View.GONE);
        DeleteApel.setVisibility(View.GONE);
        TextView TotalQty = (TextView) findViewById(R.id.TotalBar);
        TotalQty.setText("Total: Rp. " + DataHolder.getTotal() + ",-\n");
    }

    public void onClickDeleteMangga (View view) {
        TextView JusManggaQty = (TextView) findViewById(R.id.JusManggaTotal);
        Button DeleteMangga = (Button) findViewById(R.id.DeleteJusMangga);
        DataHolder.setJusMangga(0);
        JusManggaQty.setVisibility(View.GONE);
        DeleteMangga.setVisibility(View.GONE);
        TextView TotalQty = (TextView) findViewById(R.id.TotalBar);
        TotalQty.setText("Total: Rp. " + DataHolder.getTotal() + ",-\n");
    }

    public void onClickDeleteAlpukat (View view) {
        TextView JusAlpukatQty = (TextView) findViewById(R.id.JusAlpukatTotal);
        Button DeleteAlpukat = (Button) findViewById(R.id.DeleteJusAlpukat);
        DataHolder.setJusAlpukat(0);
        JusAlpukatQty.setVisibility(View.GONE);
        DeleteAlpukat.setVisibility(View.GONE);
        TextView TotalQty = (TextView) findViewById(R.id.TotalBar);
        TotalQty.setText("Total: Rp. " + DataHolder.getTotal() + ",-\n");
    }
    public void onClickButtonDrinks (View view) {
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }
    public void onClickOrderComplete (View view) {
        Intent intent = new Intent(this, OrderComplete.class);
        startActivity(intent);
    }

}
