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

public class Latihan1 extends AppCompatActivity {
    int jml = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latihan1);
        Button btnTekan = (Button) findViewById(R.id.btnTekan);
        Button btnReset = (Button) findViewById(R.id.btnReset);
        TextView tvTekan = (TextView) findViewById(R.id.tvTekan);
        btnTekan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jml = jml + 1;
                tvTekan.setText("Ditekan : "+jml+" kali");
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jml = 0;
                tvTekan.setText("Ditekan : 0 kali");
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
                Intent intent = new Intent(Latihan1.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}