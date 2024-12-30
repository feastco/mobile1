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
        Button prak53 = (Button) findViewById(R.id.btnPrak5_3);
        prak53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak5_3.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak54 = (Button) findViewById(R.id.btnPrak5_4);
        prak54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak5_4.class);
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
        Button prak72 = (Button) findViewById(R.id.btnPrak7_2);
        prak72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak7_2.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak81 = (Button) findViewById(R.id.btnPrak8_1);
        prak81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak8_1.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak82 = (Button) findViewById(R.id.btnPrak8_2);
        prak82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak8_2.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak83 = (Button) findViewById(R.id.btnPrak8_3);
        prak83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak8_3.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak84 = (Button) findViewById(R.id.btnPrak8_4);
        prak84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak8_4.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak91 = (Button) findViewById(R.id.btnPrak9_1);
        prak91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak9_1.class);
                startActivity(intent);
                finish();
            }
        });
        Button prak101 = (Button) findViewById(R.id.btnPrak10_1);
        prak101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPraktikum.this, Prak10_1.class);
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