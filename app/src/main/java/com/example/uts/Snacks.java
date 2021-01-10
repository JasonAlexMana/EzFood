package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class Snacks extends AppCompatActivity {
    public String Biscuits="0", Chocolates="0", Icecream="0", Fruits="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
        Intent intent = getIntent();
        Biscuits = intent.getStringExtra("Biscuits");
        Chocolates = intent.getStringExtra("Chocolates");
        Icecream = intent.getStringExtra("Icecream");
        Fruits = intent.getStringExtra("Fruits");
    }
    public void onClickMyOrder3(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("Biscuits", this.Biscuits);
        intent.putExtra("Chocolates", this.Chocolates);
        intent.putExtra("Icecream", this.Icecream);
        intent.putExtra("Fruits", this.Fruits);
        startActivity(intent);
    }
    public void onClickBiscuits(View view) {
        Intent intent = new Intent(this, Order3.class);
        intent.putExtra("snacks", "Biscuits\nRp 123");
        intent.putExtra("Biscuits", this.Biscuits);
        intent.putExtra("Chocolates", this.Chocolates);
        intent.putExtra("Icecream", this.Icecream);
        intent.putExtra("Fruits", this.Fruits);
        startActivity(intent);
    }
    public void onClickChocolates(View view) {
        Intent intent = new Intent(this, Order3.class);
        intent.putExtra("snacks", "Chocolates Chocolates\nRp 123");
        intent.putExtra("Biscuits", this.Biscuits);
        intent.putExtra("Chocolates", this.Chocolates);
        intent.putExtra("Icecream", this.Icecream);
        intent.putExtra("Fruits", this.Fruits);
        startActivity(intent);
    }
    public void onClickIcecream(View view) {
        Intent intent = new Intent(this, Order3.class);
        intent.putExtra("snacks", "Icecream\nRp 123");
        intent.putExtra("Biscuits", this.Biscuits);
        intent.putExtra("Chocolates", this.Chocolates);
        intent.putExtra("Icecream", this.Icecream);
        intent.putExtra("Fruits", this.Fruits);
        startActivity(intent);
    }
    public void onClickFruits(View view) {
        Intent intent = new Intent(this, Order3.class);
        intent.putExtra("snacks", "Fruits \nRp 123");
        intent.putExtra("Biscuits", this.Biscuits);
        intent.putExtra("Chocolates", this.Chocolates);
        intent.putExtra("Icecream", this.Icecream);
        intent.putExtra("Fruits", this.Fruits);
        startActivity(intent);
    }
}