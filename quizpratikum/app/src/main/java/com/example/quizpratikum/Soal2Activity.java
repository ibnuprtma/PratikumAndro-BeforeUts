package com.example.quizpratikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Soal2Activity extends AppCompatActivity {

    EditText input_angka, input_huruf;
    Button btnhasil;
    public String[] huruf = {"a", "b", "c", "d", "e", "f", "g","h", "i", "j", "k", "l","m", "n", "o", "p", "q", "r", "s","t","u", "v", "w","x","y","z"};
    public String hasil, txtangka;
    public int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal2);
        initView();

    }

    public void initView(){
        input_angka = (EditText) findViewById(R.id.input_angka);
        input_huruf = (EditText) findViewById(R.id.input_huruf);
        btnhasil = (Button) findViewById(R.id.btnhasil);
    }


    public void hasilClick(View view) {

        txtangka = input_angka.getText().toString();
        int angkanya = Integer.parseInt(txtangka);

        for(int i=0;i<huruf.length; i++){
            if (huruf[i] == input_huruf.getText().toString()){
                this.b = i + angkanya;
                for (int j=0;j<huruf.length; i++){
                    if(j == b){
                        this.hasil =  String.valueOf(huruf[j]);
                    }
                }
            }
        }

        Bundle bundle = new Bundle();
        bundle.putString("hasil", hasil);

        Intent intent = new Intent(Soal2Activity.this, Hasil2Activity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
        finish();
    }
}
