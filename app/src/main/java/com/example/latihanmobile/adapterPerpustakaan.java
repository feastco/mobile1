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

public class adapterPerpustakaan extends SimpleCursorAdapter {
    Context mContex, appconte;
    int layout;
    Cursor cursor;
    private final LayoutInflater inflater;
    ImageButton btnHapus;
    TextView tvKodePinjam, tvNISN, tvNama, tvKelas, tvJurusan, tvJudul, tvDatein, tvDateoutk;
    dbPerpustakaan db;
    Latihan7_2 main;

    public adapterPerpustakaan(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        this.layout = layout;
        this.mContex = context;
        this.cursor = c;
        this.inflater = LayoutInflater.from(context);
        main = new Latihan7_2();
        db = new dbPerpustakaan(context);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return inflater.inflate(layout, parent, false);
    }

    private static Latihan7_2 instance;

    public static Latihan7_2 getInstance() {
        if (instance == null) {
            instance = new Latihan7_2();
        }
        return instance;
    }

    public void bindView(View view, final Context context, Cursor cursor){
        super.bindView(view, context, cursor);
        final String kode_pinjam = cursor.getString(1);
        btnHapus = (ImageButton) view.findViewById(R.id.btnHapus);
        btnHapus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.deleteData(kode_pinjam);
                main.getInstance().view_perpustakaan();
            }
        });
    }
}
