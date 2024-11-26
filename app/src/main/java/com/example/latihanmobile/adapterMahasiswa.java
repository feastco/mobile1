package com.example.latihanmobile;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.annotation.SuppressLint;

public class adapterMahasiswa extends SimpleCursorAdapter{
    Context mContex, appconte;
    int layout;
    Cursor cursor;
    private final LayoutInflater inflater;
    ImageButton btnHapus, btnUpdate;
    TextView tvNim, tvNama, tvIpk;
    dbMahasiswa db;
    Prak7_2 main;

    public adapterMahasiswa(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        this.layout = layout;
        this.mContex = context;
        this.cursor = c;
        this.inflater = LayoutInflater.from(context);
        main = new Prak7_2();
        db = new dbMahasiswa(context);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return inflater.inflate(layout, parent, false);
    }

    private static Prak7_2 instance;

    public static Prak7_2 getInstance() {
        if (instance == null) {
            instance = new Prak7_2();
        }
        return instance;
    }

    public void bindView(View view, final Context context, Cursor cursor){
        super.bindView(view, context, cursor);
        final String nim = cursor.getString(1);
        btnHapus = (ImageButton) view.findViewById(R.id.btnHapus);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.deleteData(nim);
                main.getInstance().view_mahasiswa();
            }
        });
        btnUpdate = (ImageButton) view.findViewById(R.id.btnEdit);
        final String xnim = cursor.getString(cursor.getColumnIndexOrThrow("nim")); // Deklarasikan nim sebagai final
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                main.getInstance().editData(xnim); // Gunakan nim yang telah dideklarasikan
            }
        });
    }
}
