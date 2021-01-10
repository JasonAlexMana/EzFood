package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderComplete2 extends AppCompatActivity {
    public String Pizza="0", Burger="0", Hotdog="0", Pasta="0";
    public int sPizza = 0, sAyam = 0, sNasi = 0, sPecel = 0, saldos = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete2);
        Intent intent = getIntent();
        TextView Pizzas = findViewById(R.id.Pizza);
        TextView Burgers = findViewById(R.id.Burger);
        TextView Hotdogs = findViewById(R.id.Hotdog);
        TextView Pastas = findViewById(R.id.Pasta);
        TextView totals = findViewById(R.id.total);
        Pizza = intent.getStringExtra("Pizza");
        Burger = intent.getStringExtra("Burger");
        Hotdog = intent.getStringExtra("Hotdog");
        Pasta = intent.getStringExtra("Pasta");
        SQLiteOpenHelper DatabaseHelpers = new DatabaseHelper(this);
        SQLiteDatabase dbz = DatabaseHelpers.getReadableDatabase();
        Cursor c = dbz.query("WALLET",
                new String[] {"NOMINAL"},
                null, null, null, null, null
        );
        c.moveToFirst();
        saldos = c.getInt(0);
        c.close();
        dbz.close();
        TextView saldo = findViewById(R.id.teks_saldo);
        saldo.setText("Saldo: "+saldos+",00");
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
        sPecel = cursor.getInt(0);
        cursor.close();
        db.close();
        SQLiteOpenHelper DatabaseHelperk = new DatabaseHelper(this);
        SQLiteDatabase dbs = DatabaseHelperk.getWritableDatabase();
        int updateds = 0;
        if(Pizza!=null){
            total = total + Integer.parseInt(Pizza);
            Pizzas.setText("Pizza\n" + intent.getStringExtra("Pizza") + " x Rp 123");
            updateFoods(dbs, "Pizza", sPizza, Integer.parseInt(Pizza));
            updateds = 1;
        }else{
            Pizza = "0";
            Pizzas.setText("Pizza\n0 x Rp 123");
        }
        if(Burger != null){
            total = total + Integer.parseInt(Burger);
            Burgers.setText("Burger\n" + intent.getStringExtra("Burger") + " x Rp 123");
            updateFoods(dbs, "Burger", sAyam, Integer.parseInt(Burger));
            updateds = 1;
        }else{
            Burger = "0";
            Burgers.setText("Burger\n0 x Rp 123");
        }
        if(Hotdog != null){
            total = total + Integer.parseInt(Hotdog);
            Hotdogs.setText("Hotdog\n" + intent.getStringExtra("Hotdog") + " x Rp 123");
            updateFoods(dbs, "Hotdog", sNasi, Integer.parseInt(Hotdog));
            updateds = 1;
        }else{
            Hotdog = "0";
            Hotdogs.setText("Hotdog\n0 x Rp 123");
        }
        if(Pasta != null){
            total = total + Integer.parseInt(Pasta);
            Pastas.setText("Pasta\n" + intent.getStringExtra("Pasta") + " x Rp 123");
            updateFoods(dbs, "Pasta", sPecel, Integer.parseInt(Pasta));
            updateds = 1;
        }else{
            Pasta = "0";
            Pastas.setText("Pasta\n0 x Rp 123");
        }
        if(updateds == 1){
            insertHistory(dbs, "Food", "Pizza", 123, Integer.parseInt(Pizza), "Burger", 123, Integer.parseInt(Burger), "Hotdog", 123, Integer.parseInt(Hotdog), "Pasta", 123, Integer.parseInt(Pasta), "dummy");
        }
        dbs.close();
        total = total * 123;
        totals.setText("Total: Rp. " + total + ",00");
    }
    public void onClickMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private static void updateFoods(SQLiteDatabase dbs, String name, int stock, int quantity) {
        ContentValues foodValues = new ContentValues();
        foodValues.put("STOCK", (stock - quantity));
        dbs.update("PRODUK", foodValues,"NAME = ?", new String[] {name});
    }
    private static void insertHistory(SQLiteDatabase db, String type, String name1, int price1, int quantity1, String name2, int price2, int quantity2, String name3, int price3, int quantity3, String name4, int price4, int quantity4, String address) {
        ContentValues historyValues = new ContentValues();
        historyValues.put("TYPE", type);
        historyValues.put("NAME1", name1);
        historyValues.put("PRICE1", price1);
        historyValues.put("QUANTITY1", quantity1);
        historyValues.put("NAME2", name2);
        historyValues.put("PRICE2", price2);
        historyValues.put("QUANTITY2", quantity2);
        historyValues.put("NAME3", name3);
        historyValues.put("PRICE3", price3);
        historyValues.put("QUANTITY3", quantity3);
        historyValues.put("NAME4", name4);
        historyValues.put("PRICE4", price4);
        historyValues.put("QUANTITY4", quantity4);
        historyValues.put("ADDRESS", address);
        db.insert("HISTORY", null, historyValues);
    }
}
