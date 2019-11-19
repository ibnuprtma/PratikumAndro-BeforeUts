package com.example.quizpratikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Hasil1Activity extends AppCompatActivity {


    EditText txtkode_barang, harga_jual, txtnama_barang;
    String txtkode, txtnama;
    double txthargajual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil1);

        txtkode_barang = (EditText) findViewById(R.id.txtkode_barang);
        harga_jual = (EditText) findViewById(R.id.harga_jual);
        txtnama_barang = (EditText) findViewById(R.id.txtnama_barang);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        txtkode = bundle.getString("kodebarang");
        txtnama = bundle.getString("namabarang");
        txthargajual = bundle.getDouble("hargajual");


        txtkode_barang.setText(txtkode);
        txtnama_barang.setText(txtnama);
        harga_jual.setText(String.valueOf(txthargajual));
    }
}
