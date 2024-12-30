package com.example.latihanmobile;

import android.app.ProgressDialog;
import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.loader.content.AsyncTaskLoader;

import java.io.InputStream;
import java.net.URL;

public class Prak8_3 extends AppCompatActivity {
    ProgressDialog progress;
    ImageView image;
    Button button;
    TextView etUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak83);
        getSupportActionBar().hide();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Prak8_3.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etUrl = (TextView) findViewById(R.id.etUrl);
        image = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadImage().execute(etUrl.getText().toString());
            }
        });
    }

    public class LoadImage extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings){
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
            } catch (Exception e){
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPreExecute(){
            progress = new ProgressDialog(Prak8_3.this);
            progress.setMessage("Sedang Proses...");
            progress.show();
        }
        protected void onPostExecute(Bitmap bitmap){
            if(bitmap!=null){
                image.setImageBitmap(bitmap);
                progress.dismiss();
                Toast.makeText(Prak8_3.this,"Sukses Menampilkan Gambar", Toast.LENGTH_SHORT).show();
            }else {
                progress.dismiss();
                Toast.makeText(Prak8_3.this,"Ada Kesalahan",Toast.LENGTH_SHORT).show();
            }
        }
    }
}