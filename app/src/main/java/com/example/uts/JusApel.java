package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class JusApel extends AppCompatActivity {
    EditText ApelQty;

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
        setContentView(R.layout.activity_jus_apel);

        ApelQty = (EditText) findViewById(R.id.JusApelNumber);
        ApelQty.setText(Integer.toString(DataHolder.getJusApel()));
    }
    public void onClickButtonDrinks (View view) {
        Intent intent = new Intent(this, Drinks.class);
        startActivity(intent);
    }

    public void onClickButtonApelInc(View view) {
        int Apel = DataHolder.getJusApel() + 1;
        DataHolder.setJusApel(Apel);
        ApelQty.setText(Integer.toString(Apel));
    }

    public void onClickButtonApelDec(View view) {
        int Apel = DataHolder.getJusApel() - 1;
        if(Apel < 0) {
            Apel = 0;
        }
        DataHolder.setJusApel(Apel);
        ApelQty.setText(Integer.toString(Apel));
    }
    public void onClickMyOrder(View view) {
        ApelQty = (EditText) findViewById(R.id.JusApelNumber);

        try {
            int n = 0;
            if (isNumeric(String.valueOf(ApelQty.getEditableText())) == true) {
                n = Integer.parseInt(String.valueOf(ApelQty.getEditableText()));
            }
            DataHolder.setJusApel(n);
        } catch (Exception e) {
            int n = 0;
            DataHolder.setJusApel(n);
        }
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }

}
