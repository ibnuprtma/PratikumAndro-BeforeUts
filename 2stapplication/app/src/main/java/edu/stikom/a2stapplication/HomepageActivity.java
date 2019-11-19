package edu.stikom.a2stapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomepageActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        result = (TextView) findViewById(R.id.txtResult);

        Intent i = getIntent();
        result.setText(i.getStringExtra("user")+ "\n" + i.getStringExtra("pass"));
    }
}
