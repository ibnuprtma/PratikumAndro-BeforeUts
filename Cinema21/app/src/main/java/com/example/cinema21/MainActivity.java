package com.example.cinema21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.pahlawanListView);
        listView.setAdapter(adapter);

        prepare();

        addItem();
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.movie_name);
        dataDescription = getResources().getStringArray(R.array.movie_description);
        dataPhoto = getResources().obtainTypedArray(R.array.movie_photo);
    }

    private void addItem(){
        movies = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setDescription(dataDescription[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

}
