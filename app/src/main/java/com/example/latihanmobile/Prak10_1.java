package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Prak10_1 extends AppCompatActivity {
    public static final String URL = "https://qgis.umrmaulana.my.id/webservice/";
    EditText etNim, etNama, etEmail, etTelp;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak101);
        getSupportActionBar().hide();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Prak10_1.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNim = (EditText) findViewById(R.id.etNim);
        etNama = (EditText) findViewById(R.id.etNama);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etTelp = (EditText) findViewById(R.id.etTelp);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RegisterAPI api = retrofit.create(RegisterAPI.class);
                Call<ResponseBody> simpanMahasiswa = api.insert_mahasiswa(
                        etNim.getText().toString(),
                        etNama.getText().toString(),
                        etEmail.getText().toString(),
                        etTelp.getText().toString()
                );
                simpanMahasiswa.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try{
                            JSONObject json = new JSONObject(response.body().string());
                            Log.i("Info Simpan", json.get("pesan").toString());
                            if(json.get("kode").equals("1")){
                                etNim.setText("");
                                etNama.setText("");
                                etEmail.setText("");
                                etTelp.setText("");
                            }
                            Toast.makeText(getApplicationContext(),json.get("pesan").toString(),Toast.LENGTH_LONG).show();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}