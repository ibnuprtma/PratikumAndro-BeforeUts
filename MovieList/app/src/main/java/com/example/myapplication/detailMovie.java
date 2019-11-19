package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.myapplication.MainActivity.addItem;
import static com.example.myapplication.MainActivity.movies;


public class detailMovie extends AppCompatActivity {


    TextView judulDtl;
    TextView descDtl;
    TextView tahunDtl;
    TextView pendapatanDtl;
    ImageView posterDtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        this.setTitle(getIntent().getStringExtra("judul"));

        judulDtl = findViewById(R.id.judul_detail);
        descDtl = findViewById(R.id.dsc_detail);
        tahunDtl = findViewById(R.id.tahun_detail);
        pendapatanDtl = findViewById(R.id.pendapatan);
        posterDtl = findViewById(R.id.poster_detail);

        addItem();

        posterDtl.setImageResource(movies.get(Integer.parseInt(getIntent().getStringExtra("poster"))).getPoster());
        judulDtl.setText(getIntent().getStringExtra("judul"));
        descDtl.setText(getIntent().getStringExtra("desc"));
        tahunDtl.setText(getIntent().getStringExtra("tahun"));
        pendapatanDtl.setText(getIntent().getStringExtra("pendapatan"));

    }
}
