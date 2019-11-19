package com.example.uts_pteguh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView txtDate;
    Spinner spnOpt;
    EditText edDesc, edNominal, edDate;
    TransactionAdapter transactionAdapter;
    String SpinnerOption;

    int NominalDebit, NominalKredit ;

    ArrayList<Transaction> results = new ArrayList<>();
    ArrayList<Transaction> reports = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recTransaction);
        spnOpt = findViewById(R.id.spnOpt);
        edDesc = findViewById(R.id.edDesc);
        edDate = findViewById(R.id.edDate);
        edNominal = findViewById(R.id.edNominal);

        transactionAdapter = new TransactionAdapter(MainActivity.this, results);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(transactionAdapter);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load();
            }
        });

        findViewById(R.id.btnReport).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Report();
            }
        });
    }

    public void load(){
        SpinnerOption = spnOpt.getSelectedItem().toString();
        Transaction transaction = new Transaction();
        transaction.setOption(SpinnerOption);
        transaction.setNominal(Integer.parseInt(edNominal.getText().toString()));
        transaction.setDescription(edDesc.getText().toString());
        transaction.setDate(edDate.getText().toString());
        results.add(transaction);
        transactionAdapter = new TransactionAdapter(MainActivity.this, results);
        recyclerView.setAdapter(transactionAdapter);
    }

    public void Report(){
        int total = 0;
        NominalDebit = 0;
        NominalKredit = 0;
        for (int i = 0; i < results.size();i++){
            Transaction transaction = results.get(i);
            if(transaction.getOption().equals("Debit")){
                NominalDebit += transaction.getNominal();
            } else if(transaction.getOption().equals("Kredit")){
                NominalKredit += transaction.getNominal();
            }
        }

        total = NominalDebit - NominalKredit;
        Intent intent = new Intent(MainActivity.this, ReportActivity.class);
        intent.putExtra("trans",results.size());
        intent.putExtra("debit", NominalDebit);
        intent.putExtra("kredit", NominalKredit);
        intent.putExtra("total", total);
        startActivity(intent);
    }
}
