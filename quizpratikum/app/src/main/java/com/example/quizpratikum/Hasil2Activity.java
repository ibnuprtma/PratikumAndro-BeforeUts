package com.example.quizpratikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Hasil2Activity extends AppCompatActivity {

    TextView hasil;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil2);

        hasil = (TextView) findViewById(R.id.hasil);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        a = bundle.getString("hasil");

        hasil.setText(String.valueOf(a));
    }
}
