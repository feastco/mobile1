package com.example.latihanmobile;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    Button btnSimpan, btnKeluar;
    ImageButton btnEdit, btnHapus;
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
                String nim = etNim.getText().toString();
                String nama = etNama.getText().toString();
                double ipk = Double.parseDouble(etIpk.getText().toString());
                // Periksa apakah data dengan nim yang sama sudah ada
                Cursor cursor = db.getDataByNim(nim);
                if (cursor != null && cursor.moveToFirst()) {
                    // Data sudah ada, jalankan updateData()
                    boolean isUpdated = db.updateData(nim, nama, ipk);
                    if (isUpdated) {
                        view_mahasiswa();
                        kosong();
                        Toast.makeText(Prak7_2.this, "Data berhasil diperbarui", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Prak7_2.this, "Data gagal diperbarui", Toast.LENGTH_SHORT).show();
                    }
                    cursor.close();
                } else {
                    // Data belum ada, jalankan insertData()
                    boolean isInsert = db.insertData(nim, nama, ipk);
                    if (isInsert) {
                        view_mahasiswa();
                        kosong();
                        Toast.makeText(Prak7_2.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Prak7_2.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
                    }
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

    public void editData(String nim) {
        Cursor cursor = db.getDataByNim(nim);
        if (cursor != null && cursor.moveToFirst()) { // Periksa apakah cursor valid dan tidak kosong
            try {
                etNim.setText(cursor.getString(cursor.getColumnIndexOrThrow("nim")));
                etNama.setText(cursor.getString(cursor.getColumnIndexOrThrow("nama")));
                etIpk.setText(cursor.getString(cursor.getColumnIndexOrThrow("ipk")));
            } finally {
                cursor.close(); // Tutup cursor setelah selesai digunakan
            }
        } else {
            // Handle kasus jika data tidak ditemukan
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
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