package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    static String[] datajdl;
    static String[] datatahun;
    static String[] datadesc;
    static String[] datapendapatan;
    static TypedArray datagambar;
    static filmAdapter adapter;
    static ArrayList<Film> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new filmAdapter(this);
        ListView listView = findViewById(R.id.movielist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        prepare();
        addItem();


    }
    private void prepare() {
        datajdl = getResources().getStringArray(R.array.judul_film);
        datadesc = getResources().getStringArray(R.array.film_description);
        datatahun = getResources().getStringArray(R.array.tahun_pro);
        datapendapatan = getResources().getStringArray(R.array.pendapatan);
        datagambar = getResources().obtainTypedArray(R.array.poster_film);

    }

    static void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < datajdl.length; i++) {
            Film movs = new Film();
            movs.setPoster(datagambar.getResourceId(i, -1));
            movs.setJudul(datajdl[i]);
            movs.setDesc(datadesc[i]);
            movs.setTahun(datatahun[i]);
            movs.setTahun(datapendapatan[i]);
            movies.add(movs);
        }
        adapter.setMovie(movies);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, detailMovie.class);

        intent.putExtra("poster", Integer.toString(position));
        intent.putExtra("judul", datajdl[position]);
        intent.putExtra("desc",datadesc[position]);
        intent.putExtra("tahun", datatahun[position]);
        intent.putExtra("pendapatan", datapendapatan[position]);

        startActivity(intent);
    }
}
