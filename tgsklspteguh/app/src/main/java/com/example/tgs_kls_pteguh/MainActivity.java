package com.example.tgs_kls_pteguh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private PahlawanAdapter adapter;
    private ArrayList<Pahlawan> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PahlawanAdapter(this);
        ListView listView = findViewById(R.id.pahlawanListView);
        listView.setAdapter(adapter);

        prepare();

        addItem();
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.pahlawan_name);
        dataDescription = getResources().getStringArray(R.array.pahlawan_description);
        dataPhoto = getResources().obtainTypedArray(R.array.pahlawan_photo);
    }

    private void addItem(){
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Pahlawan hero = new Pahlawan();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }

}
