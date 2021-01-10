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

public class MyOrder2 extends AppCompatActivity {
    public String Pizza="0", Burger="0", Hotdog="0", Pasta="0";
    public int saldos = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order2);
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
        SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
        SQLiteDatabase db = DatabaseHelper.getReadableDatabase();
        Cursor cursor = db.query("WALLET",
                new String[] {"NOMINAL"},
                null, null, null, null, null
        );
        cursor.moveToFirst();
        saldos = cursor.getInt(0);
        cursor.close();
        db.close();
        TextView saldo = findViewById(R.id.teks_saldo);
        saldo.setText("Saldo: "+saldos+",00");
        if(Pizza != null){
            total = total + Integer.parseInt(Pizza);
            Pizzas.setText("Pizza\n" + intent.getStringExtra("Pizza") + " x Rp 123");
        }else{
            Pizzas.setText("Pizza\n0 x Rp 123");
        }
        if(Burger != null){
            total = total + Integer.parseInt(Burger);
            Burgers.setText("Burger\n" + intent.getStringExtra("Burger") + " x Rp 123");
        }else{
            Burgers.setText("Burger\n0 x Rp 123");
        }
        if(Hotdog != null){
            total = total + Integer.parseInt(Hotdog);
            Hotdogs.setText("Hotdog\n" + intent.getStringExtra("Hotdog") + " x Rp 123");
        }else{
            Hotdogs.setText("Hotdog\n0 x Rp 123");
        }
        if(Pasta != null){
            total = total + Integer.parseInt(Pasta);
            Pastas.setText("Pasta\n" + intent.getStringExtra("Pasta") + " x Rp 123");
        }else{
            Pastas.setText("Pasta\n0 x Rp 123");
        }
        total = total * 123;
        totals.setText("Total: Rp. " + total + ",00");
    }
    public void onClickPayNow(View view) {
        if(total <= saldos){
            SQLiteOpenHelper DatabaseHelper = new DatabaseHelper(this);
            SQLiteDatabase dbs = DatabaseHelper.getWritableDatabase();
            updateWallet(dbs, saldos, total);
            dbs.close();
            Intent intent = new Intent(this, OrderComplete2.class);
            intent.putExtra("Pizza", this.Pizza);
            intent.putExtra("Burger", this.Burger);
            intent.putExtra("Hotdog", this.Hotdog);
            intent.putExtra("Pasta", this.Pasta);
            startActivity(intent);
        }
    }
    public void onClickHapus1(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("Pizza", "0");
        intent.putExtra("Burger", this.Burger);
        intent.putExtra("Hotdog", this.Hotdog);
        intent.putExtra("Pasta", this.Pasta);
        startActivity(intent);
    }
    public void onClickHapus2(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("Pizza", this.Pizza);
        intent.putExtra("Burger", "0");
        intent.putExtra("Hotdog", this.Hotdog);
        intent.putExtra("Pasta", this.Pasta);
        startActivity(intent);
    }
    public void onClickHapus3(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("Pizza", this.Pizza);
        intent.putExtra("Burger", this.Burger);
        intent.putExtra("Hotdog", "0");
        intent.putExtra("Pasta", this.Pasta);
        startActivity(intent);
    }
    public void onClickHapus4(View view) {
        Intent intent = new Intent(this, MyOrder2.class);
        intent.putExtra("Pizza", this.Pizza);
        intent.putExtra("Burger", this.Burger);
        intent.putExtra("Hotdog", this.Hotdog);
        intent.putExtra("Pasta", "0");
        startActivity(intent);
    }
    private static void updateWallet(SQLiteDatabase dbs, int saldos, int totals) {
        ContentValues walletValues = new ContentValues();
        walletValues.put("NOMINAL", (saldos - totals));
        dbs.update("WALLET", walletValues,"NAME = ?", new String[] {"user1"} );
    }
}
