package com.example.uts_pteguh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    TextView totaltrans, debit, kredit, saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Intent intent = getIntent();
        this.setTitle("Report");
        totaltrans = findViewById(R.id.txtInputTrans);
        debit = findViewById(R.id.txtInputDebit);
        kredit = findViewById(R.id.txtInputKredit);
        saldo = findViewById(R.id.txtSaldoAkhir);

        totaltrans.setText(String.valueOf(intent.getIntExtra("trans",0)));
        debit.setText("Rp." + String.valueOf(intent.getIntExtra("debit",0))+".00,-");
        kredit.setText("Rp." + String.valueOf(intent.getIntExtra("kredit",0))+".00,-");
        saldo.setText("Rp." + String.valueOf(intent.getIntExtra("total",0))+".00,-");
    }
}
