package com.labkom.gradle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_barang;
    ArrayList<barang> list_barang = new ArrayList<>();
    barang_adapter br_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_barang = findViewById(R.id.rv_barang);
        br_adapter = new barang_adapter(MainActivity.this,list_barang);

        prepareData();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv_barang.setLayoutManager(mLayoutManager);
        rv_barang.setAdapter(br_adapter);
        br_adapter.notifyDataSetChanged();
    }

    private void prepareData(){
        barang br = new barang();
        br.setKode("1231232");
        br.setNama("Nivea Men");
        br.setHarga(12000);
        br.setGambar(R.drawable.adidas);
        list_barang.add(br);

        br = new barang();
        br.setKode("1231232");
        br.setNama("Nivea Men");
        br.setHarga(12000);
        br.setGambar(R.drawable.adidas);
        list_barang.add(br);

        br = new barang();
        br.setKode("1231232");
        br.setNama("Nivea Men");
        br.setHarga(12000);
        br.setGambar(R.drawable.adidas);

        list_barang.add(br);

        br = new barang();
        br.setKode("1231232");
        br.setNama("Nivea Men");
        br.setHarga(12000);
        br.setGambar(R.drawable.adidas);


        list_barang.add(br);

        br = new barang();
        br.setKode("1231232");
        br.setNama("Nivea Men");
        br.setHarga(12000);
        br.setGambar(R.drawable.adidas);
        list_barang.add(br);
    }
}
