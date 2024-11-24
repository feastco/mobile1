package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuLatihan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_latihan);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button tabung = (Button) findViewById(R.id.btnTabung);
        tabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLatihan.this, Tabung.class);
                startActivity(intent);
                finish();
            }
        });
        Button cuaca = (Button) findViewById(R.id.btnCuaca);
        cuaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLatihan.this, Cuaca.class);
                startActivity(intent);
                finish();
            }
        });
        Button zodiak = (Button) findViewById(R.id.btnZodiak);
        zodiak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLatihan.this, Zodiak.class);
                startActivity(intent);
                finish();
            }
        });
        Button zodiakview = (Button) findViewById(R.id.btnZodiakView);
        zodiakview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLatihan.this, Zodiak.class);
                startActivity(intent);
                finish();
            }
        });
        Button Latihan51 = (Button) findViewById(R.id.btnLatihan51);
        Latihan51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLatihan.this, Latihan5_1.class);
                startActivity(intent);
                finish();
            }
        });
        Button Latihan52 = (Button) findViewById(R.id.btnLatihan52);
        Latihan52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLatihan.this, Latihan52.class);
                startActivity(intent);
                finish();
            }
        });
        Button quit = (Button) findViewById(R.id.btnExit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuLatihan.this, MainActivity.class);
                startActivity(intent);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(MenuLatihan.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}