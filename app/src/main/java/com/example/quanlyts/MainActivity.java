package com.example.quanlyts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnNV, btnAddNV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNV = (Button) findViewById(R.id.btnNhanVien);
        btnNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityNhanVien.class);
                startActivity(intent);
            }
        });

        btnAddNV = (Button) findViewById(R.id.btnAddNV);
        btnAddNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Nhan_Vien_Add.class);
                startActivity(intent);
            }
        });
    }
}
