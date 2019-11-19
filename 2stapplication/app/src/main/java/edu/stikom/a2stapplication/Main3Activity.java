package edu.stikom.a2stapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    EditText kode, nama, harga;
    TextView hasil;
    Button print, color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        kode = (EditText) findViewById(R.id.kode);
        nama = (EditText) findViewById(R.id.nama);
        harga = (EditText) findViewById(R.id.harga);

        hasil = (TextView) findViewById(R.id.hasil);

        print = (Button) findViewById(R.id.print);
        color = (Button) findViewById(R.id.color);

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil.setText
                (
                    "kode  : " + kode.getText() + "\n" +
                    "nama  : " + nama.getText() + "\n" +
                    "harga : " + harga.getText() + "\n"
                );
            }
        });

        color.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.color:
                hasil.setTextColor(getResources().getColor(R.color.colorAccent));
            break;
        }
    }
}
