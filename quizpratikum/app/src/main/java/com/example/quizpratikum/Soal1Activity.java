package com.example.quizpratikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Soal1Activity extends AppCompatActivity {

    EditText kode_barang, harga_beli, nama_barang;
    Button btnsimpan;
    public double harga_jual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal1);
        initView();
    }

    public void initView(){
        kode_barang = (EditText) findViewById(R.id.kode_barang);
        nama_barang = (EditText) findViewById(R.id.nama_barang);
        harga_beli = (EditText) findViewById(R.id.harga_beli);
        btnsimpan = (Button) findViewById(R.id.btnsimpan);
    }

    public void simpanClick(View view) {

        String txthargabeli = harga_beli.getText().toString();
        int hargabeli = Integer.parseInt(txthargabeli);

        this.harga_jual = hargabeli + 0.15*hargabeli;

        Bundle bundle = new Bundle();
        bundle.putString("kodebarang", kode_barang.toString());
        bundle.putString("namabarang", nama_barang.toString());
        bundle.putDouble("hargajual", harga_jual);

        Intent intent = new Intent(Soal1Activity.this, Hasil1Activity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
        finish();
    }
}
