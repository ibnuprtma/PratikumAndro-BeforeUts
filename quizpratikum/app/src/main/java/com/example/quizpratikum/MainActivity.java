package com.example.quizpratikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnsoal1, btnsoal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void soal1Click(View view) {
        Intent intent = new Intent(MainActivity.this, Soal1Activity.class);
        startActivity(intent);
        finish();
    }

    public void soal2Click(View view) {
        Intent intent = new Intent(MainActivity.this, Soal2Activity.class);
        startActivity(intent);
        finish();
    }
}
