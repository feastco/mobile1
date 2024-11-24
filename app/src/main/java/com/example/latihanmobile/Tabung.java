package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tabung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tabung);
        Button btnProses = (Button) findViewById(R.id.button);
        TextView editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        TextView editTextNumber2 = (EditText) findViewById(R.id.editTextNumber2);
        TextView editTextVolume = (EditText) findViewById(R.id.editTextHasilVolume);
        TextView editTextLuas = (EditText) findViewById(R.id.editTextHasilLuas);
        TextView editTextKeliling = (EditText) findViewById(R.id.editTextHasilKeliling);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Luas, Volume, angka1, r, angka2;
                angka1 = Double.parseDouble(editTextNumber.getText().toString());
                angka2 = Double.parseDouble(editTextNumber2.getText().toString());
                r = 0.5*angka1;
                Luas = 2*3.14*r*(r+angka2);
                Volume = 3.14*(r*r)*angka2;
                double Keliling;
                Keliling = 2*3.14*r;
                editTextKeliling.setText("" + Keliling);
                editTextVolume.setText("" + Volume);
                editTextLuas.setText("" + Luas);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Tabung.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}