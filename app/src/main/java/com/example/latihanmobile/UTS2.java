package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UTS2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_uts2);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText etPokok = findViewById(R.id.etPokok);
        EditText etSuku = findViewById(R.id.etSuku);
        EditText etJangka = findViewById(R.id.editJangka);
        EditText etHasil = findViewById(R.id.etHasil);
        Button btnHitung = findViewById(R.id.btnHitung);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double angsuran, pokok, suku, jangka, bunga, hasil;
                pokok = Double.parseDouble(etPokok.getText().toString());
                jangka = Double.parseDouble(etJangka.getText().toString());
                suku = Double.parseDouble(etSuku.getText().toString());
                angsuran = pokok/jangka;
                bunga = (pokok*(suku/100)*(jangka/12))/jangka;
                hasil = angsuran+bunga;
                etHasil.setText("" + hasil);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(UTS2.this, UTS_A22202302996.class);
                startActivity(intent);
            }
        });
    }
}