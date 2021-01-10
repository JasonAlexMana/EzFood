package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class Foods extends AppCompatActivity {
    public String Pizza="0", Burger="0", Hotdog="0", Pasta="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        Intent intent = getIntent();
        Pizza = intent.getStringExtra("Pizza");
        Burger = intent.getStringExtra("Burger");
        Hotdog = intent.getStringExtra("Hotdog");
        Pasta = intent.getStringExtra("pasta");
    }
    public void onClickMyOrder2(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("Pizza", this.Pizza);
        intent.putExtra("Burger", this.Burger);
        intent.putExtra("Hotdog", this.Hotdog);
        intent.putExtra("Pasta", this.Pasta);
        startActivity(intent);
    }
    public void onClickPizza(View view) {
        Intent intent = new Intent(this, Order2.class);
        intent.putExtra("foods", "Pizza\nRp 123");
        intent.putExtra("Pizza", this.Pizza);
        intent.putExtra("Burger", this.Burger);
        intent.putExtra("Hotdog", this.Hotdog);
        intent.putExtra("Pasta", this.Pasta);
        startActivity(intent);
    }
    public void onClickBurger(View view) {
        Intent intent = new Intent(this, Order2.class);
        intent.putExtra("foods", "Burger\nRp 123");
        intent.putExtra("Pizza", this.Pizza);
        intent.putExtra("Burger", this.Burger);
        intent.putExtra("Hotdog", this.Hotdog);
        intent.putExtra("Pasta", this.Pasta);
        startActivity(intent);
    }
    public void onClickHotdog(View view) {
        Intent intent = new Intent(this, Order2.class);
        intent.putExtra("foods", "Hotdog\nRp 123");
        intent.putExtra("Pizza", this.Pizza);
        intent.putExtra("Burger", this.Burger);
        intent.putExtra("Hotdog", this.Hotdog);
        intent.putExtra("Pasta", this.Pasta);
        startActivity(intent);
    }
    public void onClickPasta(View view) {
        Intent intent = new Intent(this, Order2.class);
        intent.putExtra("foods", "Pasta\nRp 123");
        intent.putExtra("Pizza", this.Pizza);
        intent.putExtra("Burger", this.Burger);
        intent.putExtra("Hotdog", this.Hotdog);
        intent.putExtra("Pasta", this.Pasta);
        startActivity(intent);
    }
}
