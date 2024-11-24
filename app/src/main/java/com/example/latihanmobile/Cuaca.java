package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cuaca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuaca);
        ImageView img = (ImageView) findViewById(R.id.imageView);
        RadioGroup group = (RadioGroup) findViewById(R.id.Radiogroup);
        TextView tx = (TextView) findViewById(R.id.tvInfo);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i == R.id.cerah) {
                    img.setImageDrawable(getResources().getDrawable(R.drawable.cerah));
                    tx.setText("Cuaca Hari Ini : Cerah");
                } else if (i == R.id.mendung) {
                    img.setImageDrawable(getResources().getDrawable(R.drawable.mendung));
                    tx.setText("Cuaca Hari Ini : Mendung");
                } else if (i == R.id.berawan) {
                    img.setImageDrawable(getResources().getDrawable(R.drawable.berawan));
                    tx.setText("Cuaca Hari Ini : Berawan");
                } else if (i == R.id.hujan) {
                    img.setImageDrawable(getResources().getDrawable(R.drawable.hujan));
                    tx.setText("Cuaca Hari Ini : Hujan");
                }
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
                Intent intent = new Intent(Cuaca.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}