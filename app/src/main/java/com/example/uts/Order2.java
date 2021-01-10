package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Order2 extends AppCompatActivity {
    public String Pizza="0", Burger="0", Hotdog="0", Pasta="0", foodType;
    public int sPizza = 0, sAyam = 0, sNasi = 0, sPasta = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);
        Intent intent = getIntent();
        TextView orderan = findViewById(R.id.teks_orderan);
        orderan.setText(intent.getStringExtra("foods"));
        foodType = intent.getStringExtra("foods");
        Pizza = intent.getStringExtra("Pizza");
        Burger = intent.getStringExtra("Burger");
        Hotdog = intent.getStringExtra("Hotdog");
        Pasta = intent.getStringExtra("Pasta");
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("PRODUK",
                new String[] {"STOCK"},
                "TYPE = ?", new String[] {"Food"}, null, null, null
        );
        cursor.moveToFirst();
        sPizza = cursor.getInt(0);
        cursor.moveToNext();
        sAyam = cursor.getInt(0);
        cursor.moveToNext();
        sNasi = cursor.getInt(0);
        cursor.moveToNext();
        sPasta = cursor.getInt(0);
        cursor.close();
        db.close();
        TextView stocks = findViewById(R.id.teks_stock);
        if(foodType.equals("Pizza\nRp 123")){
            stocks.setText("Stock: "+sPizza);
        }else if(foodType.equals("Burger\nRp 123")){
            stocks.setText("Stock: "+sAyam);
        }else if(foodType.equals("Hotdog\nRp 123")){
            stocks.setText("Stock: "+sNasi);
        }else if(foodType.equals("Pasta \nRp 123")){
            stocks.setText("Stock: "+sPasta);
        }
    }
    public void onClickOrderMore(View view) {
        int lanjut = 0;
        EditText editText = findViewById(R.id.editText);
        if(foodType.equals("Pizza\nRp 123")){
            this.Pizza = editText.getText().toString();
            if(this.Pizza.equals("")){
                this.Pizza = "0";
            }
            if(Integer.parseInt(this.Pizza) <= sPizza){
                lanjut = 1;
            }
        }else if(foodType.equals("Burger\nRp 123")){
            this.Burger = editText.getText().toString();
            if(this.Burger.equals("")){
                this.Burger = "0";
            }
            if(Integer.parseInt(this.Burger) <= sAyam){
                lanjut = 1;
            }
        }else if(foodType.equals("Hotdog\nRp 123")){
            this.Hotdog = editText.getText().toString();
            if(this.Hotdog.equals("")){
                this.Hotdog = "0";
            }
            if(Integer.parseInt(this.Hotdog) <= sNasi){
                lanjut = 1;
            }
        }else if(foodType.equals("Pasta \nRp 123")){
            this.Pasta = editText.getText().toString();
            if(this.Pasta.equals("")){
                this.Pasta = "0";
            }
            if(Integer.parseInt(this.Pasta) <= sPasta){
                lanjut = 1;
            }
        }
        if(lanjut == 1){
            Intent intent = new Intent(this, Foods.class);
            intent.putExtra("Pizza", this.Pizza);
            intent.putExtra("Burger", this.Burger);
            intent.putExtra("Hotdog", this.Hotdog);
            intent.putExtra("Pasta", this.Pasta);
            startActivity(intent);
        }
    }
    public void onClickMyOrder2(View view) {
        int lanjut = 0;
        EditText editText = findViewById(R.id.editText);
        if(foodType.equals("Pizza\nRp 123")){
            this.Pizza = editText.getText().toString();
            if(this.Pizza.equals("")){
                this.Pizza = "0";
            }
            if(Integer.parseInt(this.Pizza) <= sPizza){
                lanjut = 1;
            }
        }else if(foodType.equals("Burger\nRp 123")){
            this.Burger = editText.getText().toString();
            if(this.Burger.equals("")){
                this.Burger = "0";
            }
            if(Integer.parseInt(this.Burger) <= sAyam){
                lanjut = 1;
            }
        }else if(foodType.equals("Hotdog\nRp 123")){
            this.Hotdog = editText.getText().toString();
            if(this.Hotdog.equals("")){
                this.Hotdog = "0";
            }
            if(Integer.parseInt(this.Hotdog) <= sNasi){
                lanjut = 1;
            }
        }else if(foodType.equals("Pasta \nRp 123")){
            this.Pasta = editText.getText().toString();
            if(this.Pasta.equals("")){
                this.Pasta = "0";
            }
            if(Integer.parseInt(this.Pasta) <= sPasta){
                lanjut = 1;
            }
        }
        if(lanjut == 1){
            Intent intent = new Intent(this, MyOrder2.class);
            intent.putExtra("Pizza", this.Pizza);
            intent.putExtra("Burger", this.Burger);
            intent.putExtra("Hotdog", this.Hotdog);
            intent.putExtra("Pasta", this.Pasta);
            startActivity(intent);
        }
    }
}
