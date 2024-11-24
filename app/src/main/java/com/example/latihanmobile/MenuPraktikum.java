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

public class MenuPraktikum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_praktikum);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button latihan1 = (Button) findViewById(R.id.btnLatihan1);
        latihan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Latihan1.class);
                startActivity(intent);
                finish();
            }
        });
        Button latihan2 = (Button) findViewById(R.id.btnLatihan2);
        latihan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Latihan2.class);
                startActivity(intent);
                finish();
            }
        });
        Button kalkulator = (Button) findViewById(R.id.btnKalkulator);
        kalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Kalkulator.class);
                startActivity(intent);
                finish();
            }
        });
        Button form = (Button) findViewById(R.id.btnForm);
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Form.class);
                startActivity(intent);
                finish();
            }
        });
        Button LoginView = (Button) findViewById(R.id.btnLoginView);
        LoginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, LoginView.class);
                startActivity(intent);
                finish();
            }
        });
        Button fragment = (Button) findViewById(R.id.btnFragment);
        fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Fragment.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak4 = (Button) findViewById(R.id.btnPrak4_3);
        prak4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak4_2.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak51 = (Button) findViewById(R.id.btnPrak5_1);
        prak51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak5_1.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak52 = (Button) findViewById(R.id.btnPrak5_2);
        prak52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak5_2.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak63 = (Button) findViewById(R.id.btnPrak6_3);
        prak63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, RecycleView.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak64 = (Button) findViewById(R.id.btnPrak6_4);
        prak64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, RecycleViewMultiItem.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak71 = (Button) findViewById(R.id.btnPrak7_1);
        prak71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Praktikum7_1_SQLite.class);
                startActivity(intent);
                finish();
            }
        });
        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(MenuPraktikum.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}