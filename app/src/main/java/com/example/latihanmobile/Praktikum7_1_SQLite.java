package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Praktikum7_1_SQLite extends AppCompatActivity {
    EditText etNopol, etMerek, etTahun;
    Button btnSimpan;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_praktikum71_sqlite);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        db = new DatabaseHelper(this);
        etNopol = findViewById(R.id.etNopol);
        etMerek = findViewById(R.id.etMerek);
        etTahun = findViewById(R.id.etTahun);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsert = db.insertData(etNopol.getText().toString(),
                        etMerek.getText().toString(),
                        Double.parseDouble(etTahun.getText().toString()));
                if(isInsert==true){
                    Toast.makeText(Praktikum7_1_SQLite.this, "Data Tersimpan",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Praktikum7_1_SQLite.this, "Data Gagal Tersimpan",
                            Toast.LENGTH_SHORT).show();
                }
                etNopol.setText("");
                etMerek.setText("");
                etTahun.setText("");
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Praktikum7_1_SQLite.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}