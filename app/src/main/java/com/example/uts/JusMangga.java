package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class JusMangga extends AppCompatActivity {
    EditText ManggaQty;

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
        setContentView(R.layout.activity_jus_mangga);

        ManggaQty = (EditText) findViewById(R.id.JusManggaNumber);
        ManggaQty.setText(Integer.toString(DataHolder.getJusMangga()));
    }
    public void onClickButtonDrinks (View view) {
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }
    public void onClickButtonManggaInc(View view) {
        int Mangga = DataHolder.getJusMangga() + 1;
        DataHolder.setJusMangga(Mangga);
        ManggaQty.setText(Integer.toString(Mangga));
    }

    public void onClickButtonManggaDec(View view) {
        int Mangga = DataHolder.getJusMangga() - 1;
        if(Mangga < 0) {
            Mangga = 0;
        }
        DataHolder.setJusMangga(Mangga);
        ManggaQty.setText(Integer.toString(Mangga));
    }
    public void onClickMyOrder(View view) {
        ManggaQty = (EditText) findViewById(R.id.JusManggaNumber);

        try {
            int n = 0;
            if (isNumeric(String.valueOf(ManggaQty.getEditableText())) == true) {
                n = Integer.parseInt(String.valueOf(ManggaQty.getEditableText()));
            }
            DataHolder.setJusMangga(n);
        }
        catch (Exception e) {
            int n = 0;
            DataHolder.setJusMangga(n);
        }
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }
}
