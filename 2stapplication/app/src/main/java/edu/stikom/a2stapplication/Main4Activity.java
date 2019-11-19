package edu.stikom.a2stapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    Button btnBundle, btnPrimitive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btnBundle = (Button) findViewById(R.id.btnBundle);
        btnPrimitive = (Button) findViewById(R.id.btnPrimitive);

        btnPrimitive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), PrimitiveActivity.class);
                startActivity(i);
            }
        });

        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), BundleActivity.class);
                startActivity(i);
            }
        });
    }
}
