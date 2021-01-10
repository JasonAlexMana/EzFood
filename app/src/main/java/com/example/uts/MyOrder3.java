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

public class MyOrder3 extends AppCompatActivity {
    public String Biscuits="0", Chocolates="0", Icecream="0", Fruits="0";
    public int saldos = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order3);
        Intent intent = getIntent();
        TextView Biscuitss = findViewById(R.id.Biscuits);
        TextView Chocolatess = findViewById(R.id.Chocolates_Chocolates);
        TextView Icecreams = findViewById(R.id.Icecream);
        TextView Fruitss = findViewById(R.id.Fruits_);
        TextView totals = findViewById(R.id.total);
        Biscuits = intent.getStringExtra("Biscuits");
        Chocolates = intent.getStringExtra("Chocolates");
        Icecream = intent.getStringExtra("Icecream");
        Fruits = intent.getStringExtra("Fruits");
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
        if(Biscuits != null){
            total = total + Integer.parseInt(Biscuits);
            Biscuitss.setText("Biscuits\n" + intent.getStringExtra("Biscuits") + " x Rp 123");
        }else{
            Biscuitss.setText("Biscuits\n0 x Rp 123");
        }
        if(Chocolates != null){
            total = total + Integer.parseInt(Chocolates);
            Chocolatess.setText("Chocolates Chocolates\n" + intent.getStringExtra("Chocolates") + " x Rp 123");
        }else{
            Chocolatess.setText("Chocolates Chocolates\n0 x Rp 123");
        }
        if(Icecream != null){
            total = total + Integer.parseInt(Icecream);
            Icecreams.setText("Icecream\n" + intent.getStringExtra("Icecream") + " x Rp 123");
        }else{
            Icecreams.setText("Icecream\n0 x Rp 123");
        }
        if(Fruits != null){
            total = total + Integer.parseInt(Fruits);
            Fruitss.setText("Fruits \n" + intent.getStringExtra("Fruits") + " x Rp 123");
        }else{
            Fruitss.setText("Fruits \n0 x Rp 123");
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
            Intent intent = new Intent(this, OrderComplete3.class);
            intent.putExtra("Biscuits", this.Biscuits);
            intent.putExtra("Chocolates", this.Chocolates);
            intent.putExtra("Icecream", this.Icecream);
            intent.putExtra("Fruits", this.Fruits);
            startActivity(intent);
        }
    }
    public void onClickHapus1(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("Biscuits", "0");
        intent.putExtra("Chocolates", this.Chocolates);
        intent.putExtra("Icecream", this.Icecream);
        intent.putExtra("Fruits", this.Fruits);
        startActivity(intent);
    }
    public void onClickHapus2(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("Biscuits", this.Biscuits);
        intent.putExtra("Chocolates", "0");
        intent.putExtra("Icecream", this.Icecream);
        intent.putExtra("Fruits", this.Fruits);
        startActivity(intent);
    }
    public void onClickHapus3(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("Biscuits", this.Biscuits);
        intent.putExtra("Chocolates", this.Chocolates);
        intent.putExtra("Icecream", "0");
        intent.putExtra("Fruits", this.Fruits);
        startActivity(intent);
    }
    public void onClickHapus4(View view) {
        Intent intent = new Intent(this, MyOrder3.class);
        intent.putExtra("Biscuits", this.Biscuits);
        intent.putExtra("Chocolates", this.Chocolates);
        intent.putExtra("Icecream", this.Icecream);
        intent.putExtra("Fruits", "0");
        startActivity(intent);
    }
    private static void updateWallet(SQLiteDatabase dbs, int saldos, int totals) {
        ContentValues walletValues = new ContentValues();
        walletValues.put("NOMINAL", (saldos - totals));
        dbs.update("WALLET", walletValues,"NAME = ?", new String[] {"user1"} );
    }
}
