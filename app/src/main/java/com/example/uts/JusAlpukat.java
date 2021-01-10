package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class JusAlpukat extends AppCompatActivity {
    EditText AlpukatQty;

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
        setContentView(R.layout.activity_jus_alpukat);

        AlpukatQty = (EditText) findViewById(R.id.JusAlpukatNumber);
        AlpukatQty.setText(Integer.toString(DataHolder.getJusAlpukat()));
    }
    public void onClickButtonDrinks (View view) {
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }
    public void onClickButtonAlpukatInc(View view) {
        int Alpukat = DataHolder.getJusAlpukat() + 1;
        DataHolder.setJusAlpukat(Alpukat);
        AlpukatQty.setText(Integer.toString(Alpukat));
    }

    public void onClickButtonAlpukatDec(View view) {
        int Alpukat = DataHolder.getJusAlpukat() - 1;
        if(Alpukat < 0) {
            Alpukat = 0;
        }
        DataHolder.setJusAlpukat(Alpukat);
        AlpukatQty.setText(Integer.toString(Alpukat));
    }
    public void onClickMyOrder(View view) {
        AlpukatQty = (EditText) findViewById(R.id.JusAlpukatNumber);

        try {
            int n = 0;
            if (isNumeric(String.valueOf(AlpukatQty.getEditableText())) == true) {
                n = Integer.parseInt(String.valueOf(AlpukatQty.getEditableText()));
            }
            DataHolder.setJusAlpukat(n);
        }
        catch (Exception e) {
            int n = 0;
            DataHolder.setJusAlpukat(n);
        }
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }
}
