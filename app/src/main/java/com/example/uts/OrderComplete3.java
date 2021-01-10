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

public class OrderComplete3 extends AppCompatActivity {
    public String Biscuits="0", Chocolates="0", Icecream="0", Fruits="0", snackType;
    public int sBiscuits = 0, sChocolates = 0, sIcecream = 0, sFruits = 0, saldos = 0, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete3);
        Intent intent = getIntent();
        TextView Biscuitss = findViewById(R.id.Biscuits);
        TextView Chocolatess = findViewById(R.id.Chocolates_Chocolates);
        TextView Icecreams = findViewById(R.id.Icecream);
        TextView Fruitss = findViewById(R.id.Fruits);
        TextView totals = findViewById(R.id.total);
        Biscuits = intent.getStringExtra("Biscuits");
        Chocolates = intent.getStringExtra("Chocolates");
        Icecream = intent.getStringExtra("Icecream");
        Fruits = intent.getStringExtra("Fruits");
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
                "TYPE = ?", new String[] {"Snack"}, null, null, null
        );
        cursor.moveToFirst();
        sBiscuits = cursor.getInt(0);
        cursor.moveToNext();
        sChocolates = cursor.getInt(0);
        cursor.moveToNext();
        sIcecream = cursor.getInt(0);
        cursor.moveToNext();
        sFruits = cursor.getInt(0);
        cursor.close();
        db.close();
        SQLiteOpenHelper DatabaseHelperk = new DatabaseHelper(this);
        SQLiteDatabase dbs = DatabaseHelperk.getWritableDatabase();
        int updateds = 0;
        if(Biscuits!=null){
            total = total + Integer.parseInt(Biscuits);
            Biscuitss.setText("Biscuits\n" + intent.getStringExtra("Biscuits") + " x Rp 123");
            updateSnacks(dbs, "Biscuits", sBiscuits, Integer.parseInt(Biscuits));
            updateds = 1;
        }else{
            Biscuits = "0";
            Biscuitss.setText("Biscuits\n0 x Rp 123");
        }
        if(Chocolates != null){
            total = total + Integer.parseInt(Chocolates);
            Chocolatess.setText("Chocolates Chocolates\n" + intent.getStringExtra("Chocolates") + " x Rp 123");
            updateSnacks(dbs, "Chocolates Chocolates", sChocolates, Integer.parseInt(Chocolates));
            updateds = 1;
        }else{
            Chocolates = "0";
            Chocolatess.setText("Chocolates Chocolates\n0 x Rp 123");
        }
        if(Icecream != null){
            total = total + Integer.parseInt(Icecream);
            Icecreams.setText("Icecream\n" + intent.getStringExtra("Icecream") + " x Rp 123");
            updateSnacks(dbs, "Icecream", sIcecream, Integer.parseInt(Icecream));
            updateds = 1;
        }else{
            Icecream = "0";
            Icecreams.setText("Icecream\n0 x Rp 123");
        }
        if(Fruits != null){
            total = total + Integer.parseInt(Fruits);
            Fruitss.setText("Fruits \n" + intent.getStringExtra("Fruits") + " x Rp 123");
            updateSnacks(dbs, "Fruits ", sFruits, Integer.parseInt(Fruits));
            updateds = 1;
        }else{
            Fruits = "0";
            Fruitss.setText("Fruits \n0 x Rp 123");
        }
        if(updateds == 1){
            insertHistory(dbs, "Snack", "Biscuits", 123, Integer.parseInt(Biscuits), "Chocolates Chocolates", 123, Integer.parseInt(Chocolates), "Icecream", 123, Integer.parseInt(Icecream), "Fruits ", 123, Integer.parseInt(Fruits), "dummy");
        }
        dbs.close();
        total = total * 123;
        totals.setText("Total: Rp. " + total + ",00");
    }
    public void onClickMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private static void updateSnacks(SQLiteDatabase dbs, String name, int stock, int quantity) {
        ContentValues snackValues = new ContentValues();
        snackValues.put("STOCK", (stock - quantity));
        dbs.update("PRODUK", snackValues,"NAME = ?", new String[] {name});
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
