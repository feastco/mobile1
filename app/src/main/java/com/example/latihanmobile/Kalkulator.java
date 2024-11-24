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

public class Kalkulator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnTambah = (Button) findViewById(R.id.buttonTambah);
        EditText editTextNumber1 = (EditText) findViewById(R.id.editTextNumber1);
        EditText editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        EditText editTextHasil = (EditText) findViewById(R.id.editTextHasil);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double hasil, angka1, angka2;
                angka1 = Double.parseDouble(editTextNumber1.getText().toString());
                angka2 = Double.parseDouble(editTextNumber2.getText().toString());
                hasil = angka1 + angka2;
                editTextHasil.setText("" + hasil);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Kalkulator.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}