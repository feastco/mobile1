package com.example.latihanmobile;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        Button btnKeluar = (Button) findViewById(R.id.btnKeluar);
        String username = getIntent().getStringExtra("username");
        tvWelcome.setText("Selamat Datang "+username);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginView.this,Form.class);
                startActivity(intent);
                finish();
            }
        });
        ImageButton ibCamera = (ImageButton) findViewById(R.id.ibCamera);
        ibCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openCamera(); }
        });
        ImageButton ibCall = (ImageButton) findViewById(R.id.ibCall);
        ibCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openPhone("089501785164"); }
        });
        ImageButton ivWeb = (ImageButton) findViewById(R.id.ivWeb);
        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openWeb("umrmaulana.my.id"); }
        });
        ImageButton ivGithub = (ImageButton) findViewById(R.id.ivGithub);
        ivGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openWeb("github.com/umrmaulana"); }
        });
        ImageButton ivIg = (ImageButton) findViewById(R.id.ivIg);
        ivIg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openWeb("www.instagram.com/umrmaulana/"); }
        });
        ImageButton ivFb = (ImageButton) findViewById(R.id.ivFb);
        ivFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openWeb("www.facebook.com/umrmaulana3"); }
        });
    }
    void openCamera() {
        Intent openCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(openCamera);
    }
    void openPhone(String vno) {
        String no = vno;
        Intent openPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+no));
        startActivity(openPhone);
    }
    void openWeb(String vurl) {
        String url = vurl;
        Intent openWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+url));
        startActivity(openWeb);
    }
}