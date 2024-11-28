package com.example.latihanmobile;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Latihan7_2 extends AppCompatActivity {
    EditText etKodePinjam, etNISN, etNama, etJudul, etDatein, etDateout;
    Button btnSimpan, btnKeluar;
    ImageButton btnHapus;
    dbPerpustakaan db;
    ListView lvLihat;
    adapterPerpustakaan adapter;
    private static Latihan7_2 main;
    String Kelas, Jurusan;
    RadioGroup rgKelas, rgJurusan;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latihan72);
        getSupportActionBar().hide();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Latihan7_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        main = this;
        db = new dbPerpustakaan(this);
        etKodePinjam = (EditText) findViewById(R.id.etKdPinjam);
        etNISN = (EditText) findViewById(R.id.etNisn);
        etNama = (EditText) findViewById(R.id.etNama);
        rgKelas = (RadioGroup) findViewById(R.id.rgKelas);
        rgJurusan = (RadioGroup) findViewById(R.id.rgJurusan);
        etJudul = (EditText) findViewById(R.id.etJudul);
        etDatein = (EditText) findViewById(R.id.etDatein);
        etDateout = (EditText) findViewById(R.id.etDateout);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        lvLihat = (ListView) findViewById(R.id.lvLihat);
        calendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener dateInListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateCalendar(etDatein); // Update etDatein
            }
        };
        DatePickerDialog.OnDateSetListener dateOutListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateCalendar(etDateout); // Update etDateout
            }
        };
        etDatein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Latihan7_2.this, dateInListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etDateout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Latihan7_2.this, dateOutListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        rgKelas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup rgKelas, int i) {
                if (i == R.id.x) {
                    Kelas = "X";
                } else if (i == R.id.xi) {
                    Kelas = "XI";
                } else if (i == R.id.xii) {
                    Kelas = "XII";
                }
            }
        });
        rgJurusan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup rgJurusan, int i) {
                if (i == R.id.tkro) {
                    Jurusan = "TKRO";
                } else if (i == R.id.tkjt) {
                    Jurusan = "TKJT";
                } else if (i == R.id.te) {
                    Jurusan = "TE";
                }
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(etJudul.getText().toString().isEmpty()){
                    etJudul.setText("0");
                }
                String KodePinjam = etKodePinjam.getText().toString();
                String NISN = etNISN.getText().toString();
                String Nama = etNama.getText().toString();
                String xKelas = Kelas;
                String xJurusan = Jurusan;
                String Judul = etJudul.getText().toString();
                String Datein = etDatein.getText().toString();
                String Dateout = etDateout.getText().toString();
                // Periksa apakah data dengan nim yang sama sudah ada
                Cursor cursor = db.getDataByKode(KodePinjam);
                if (cursor != null && cursor.moveToFirst()) {
                    // Data sudah ada, jalankan updateData()
                    boolean isUpdated = db.updateData(KodePinjam, NISN, Nama, xKelas, xJurusan, Judul, Datein, Dateout);
                    if (isUpdated) {
                        view_perpustakaan();
                        kosong();
                        Toast.makeText(Latihan7_2.this, "Data berhasil diperbarui", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Latihan7_2.this, "Data gagal diperbarui", Toast.LENGTH_SHORT).show();
                    }
                    cursor.close();
                } else {
                    // Data belum ada, jalankan insertData()
                    boolean isInsert = db.insertData(KodePinjam, NISN, Nama, xKelas, xJurusan, Judul, Datein, Dateout);
                    if (isInsert) {
                        view_perpustakaan();
                        kosong();
                        Toast.makeText(Latihan7_2.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Latihan7_2.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Latihan7_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Latihan7_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        view_perpustakaan();
    }

    private void updateCalendar(android.widget.EditText editText) {
        String format = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        editText.setText(dateFormat.format(calendar.getTime()));
    }

    public void view_perpustakaan(){
        try {
            Cursor cur = db.getAllData();
            Log.i("Info", "Jumlah Data: " + cur.getColumnName(0));
            String[] column = new String[]{"_id", "kode_pinjam", "nisn", "nama", "kelas", "jurusan", "judul", "datein", "dateout"};
            int[] boundto = new int[]{0, R.id.tvKodePinjam, R.id.tvNISN, R.id.tvNama, R.id.tvKelas, R.id.tvJurusan, R.id.tvJudul, R.id.tvDatein, R.id.tvDateout};
            adapter = new adapterPerpustakaan(this, R.layout.list_latihan72, cur, column, boundto);
            lvLihat.setAdapter(adapter);
        }catch (Exception e){
            Log.e("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void editData(String KodePinjam) {
        Cursor cursor = db.getDataByKode(KodePinjam);
        if (cursor != null && cursor.moveToFirst()) { // Periksa apakah cursor valid dan tidak kosong
            try {
                etKodePinjam.setText(cursor.getString(cursor.getColumnIndexOrThrow("kode_pinjam")));
                etNISN.setText(cursor.getString(cursor.getColumnIndexOrThrow("nisn")));
                etNama.setText(cursor.getString(cursor.getColumnIndexOrThrow("nama")));
                int kelasId = cursor.getInt(cursor.getColumnIndexOrThrow("kelas"));
                rgKelas.check(kelasId);
                int jurusanId = cursor.getInt(cursor.getColumnIndexOrThrow("jurusan"));
                rgJurusan.check(jurusanId);
                etJudul.setText(cursor.getString(cursor.getColumnIndexOrThrow("judul")));
                etDatein.setText(cursor.getString(cursor.getColumnIndexOrThrow("datein")));
                etDateout.setText(cursor.getString(cursor.getColumnIndexOrThrow("dateout")));
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            } finally {
                cursor.close(); // Tutup cursor setelah selesai digunakan
            }
        } else {
            // Handle kasus jika data tidak ditemukan
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }


    public void kosong(){
        etKodePinjam.setText("");
        etNISN.setText("");
        etNama.setText("");
        etJudul.setText("");
        etDatein.setText("");
        etDateout.setText("");
        rgKelas.clearCheck();
        rgJurusan.clearCheck();
    }

    private static Latihan7_2 instance;
    public Latihan7_2 getInstance() {
        return main;
    }
}