package com.example.latihanmobile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Prak8_2 extends AppCompatActivity {
    String url;
    Button btnDownload;
    TextView tvPath, tvSize;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak82);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        url = "https://repository.dinus.ac.id/docs/ajar/3._Edi_ANSI_Analisa_Sistem_.pdf";
        tvPath = (TextView) findViewById(R.id.tvPath);
        tvSize = (TextView) findViewById(R.id.tvSize);
        btnDownload = (Button) findViewById(R.id.button);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadFilesFromURL().execute(url);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Prak8_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Downloading files, Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setMax(100);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pDialog.setCancelable(true);
        pDialog.show();
        return pDialog;
    }

    class DownloadFilesFromURL extends AsyncTask<String,String,String>{
        protected void onPreExecute(){
            super.onPreExecute();
            showDialog(0);
            Log.i("Info Download", "PreExe DiJalankan");
        }
        @Override
        protected String doInBackground(String... strings) {
            int count;
            try {
                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();
                connection.connect();

                // Panjang file (dalam byte)
                int lengthOfFile = connection.getContentLength();

                // Perbarui informasi ukuran file
                runOnUiThread(() -> tvSize.setText("File Size: " + (lengthOfFile / 1024) + " KB"));

                // Lokasi penyimpanan file
                String downloadFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString() + "/fileMobile.pdf";
                runOnUiThread(() -> tvPath.setText("File Path: " + downloadFile));

                // Membuka stream
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                OutputStream output = new FileOutputStream(downloadFile);

                // Menyalin data
                byte[] data = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));
                    output.write(data, 0, count);
                }

                // Tutup stream
                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {
                Log.e("Error Download: ", e.getMessage());
            }
            return null;
        }


        protected void onProgressUpdate(String... progress){
            pDialog.setProgress(Integer.parseInt(progress[0]));
            Log.i("info Download", "Progress Update : "+progress[0]);
        }

        protected void onPostExecute(String file_url){
            dismissDialog(0);
            Toast.makeText(Prak8_2.this, "Proses Download Selesai", Toast.LENGTH_SHORT).show();
            Log.i("info Download", "on Post Execute");
        }
    }
}