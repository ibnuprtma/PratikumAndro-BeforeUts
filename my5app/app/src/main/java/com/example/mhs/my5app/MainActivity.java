package com.example.mhs.my5app;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    Button btnpesan, btntelp, btncamera;
    EditText telp, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();

        btntelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telp.getText().toString()));

                if (Build.VERSION.SDK_INT >= 23){
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE},1000);
                    }else{
                        startActivity(i);
                    }
                }else{
                    startActivity(i);
                }
            }
        });

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent("android.media.action.IMAGE_CAPTURE");

                if (Build.VERSION.SDK_INT >= 23){
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA},1000);
                    }else{
                        startActivity(i);
                    }
                }else{
                    startActivity(i);
                }
            }
        });

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SmsManager sms = SmsManager.getDefault();

                if (Build.VERSION.SDK_INT >= 23){
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.SEND_SMS}, 1000 );
                    }else{
                        sms.sendTextMessage(telp.getText().toString(), null, text.getText().toString(), null, null);
                        Toast.makeText(MainActivity.this, "Message Sent to:" +telp.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    sms.sendTextMessage(telp.getText().toString(), null, text.getText().toString(), null, null);
                    Toast.makeText(MainActivity.this, "Message Sent to:" +telp.getText().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void init(){
        btnpesan = findViewById(R.id.btnpesan);
        btntelp = findViewById(R.id.btntelp);
        btncamera = findViewById(R.id.btncamera);
        telp = findViewById(R.id.telp);
        text = findViewById(R.id.text);
    }
}
