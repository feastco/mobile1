package com.example.latihanmobile;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Prak8_1 extends AppCompatActivity {
    TextView tv1, tv2;
    Button btn1, btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak81);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            tv1.setText("");
            prosesTanpaAsyncTask();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText("");
                prosesDenganAsyncTask();
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Prak8_1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void prosesTanpaAsyncTask() {
        for (int i = 0; i <= 100000; i++) {
            tv1.setText(""+i);
        }
    }

    void prosesDenganAsyncTask() {
        new ulang().execute(100000);
    }

    class ulang extends AsyncTask<Integer,Integer,Integer>{
        @Override
        protected Integer doInBackground(Integer... integers) {
            int n = integers[0];
            for (int i = 0; i <= n; i++) {
                tv2.setText("" + i);
            }
            return null;
        }
    }
}