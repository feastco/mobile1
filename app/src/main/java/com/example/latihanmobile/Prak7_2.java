package com.example.latihanmobile;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Prak7_2 extends AppCompatActivity {
    EditText etNim, etNama, etIpk;
    Button btnSimpan, btnKeluar, btnHapus;;
    dbMahasiswa db;
    ListView lvLihat;
    adapterMahasiswa adapter;
    private static Prak7_2 main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak72);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        main = this;
        db = new dbMahasiswa(this);
        etNim = (EditText) findViewById(R.id.etNim);
        etNama = (EditText) findViewById(R.id.etNama);
        etIpk = (EditText) findViewById(R.id.etIpk);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        lvLihat = (ListView) findViewById(R.id.lvLihat);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(etIpk.getText().toString().isEmpty()){
                    etIpk.setText("0");
                }
                boolean isInsert = db.insertData(etNim.getText().toString(),
                        etNama.getText().toString(),
                        Double.parseDouble(etIpk.getText().toString()));
                if(isInsert==true){
                    view_mahasiswa();
                    kosong();
                    Toast.makeText(Prak7_2.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Prak7_2.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Prak7_2.this, MainActivity.class);
                startActivity(intent);
            }
            });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Prak7_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        view_mahasiswa();
    }

    public void view_mahasiswa(){
        try {
            Cursor cur = db.getAllData();
            Log.i("Info", "Jumlah Data: " + cur.getColumnName(0));
            String[] column = new String[]{"_id", "nim", "nama", "ipk"};
            int[] boundto = new int[]{0, R.id.tvNim, R.id.tvNama, R.id.tvIpk};
            adapter = new adapterMahasiswa(this, R.layout.list_mahasiswa, cur, column, boundto);
            lvLihat.setAdapter(adapter);
        }catch (Exception e){
            Log.e("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void kosong(){
        etNim.setText("");
        etNama.setText("");
        etIpk.setText("");
        etNim.requestFocus();
    }

    private static Prak7_2 instance;
    public Prak7_2 getInstance() {
        return main;
    }
}