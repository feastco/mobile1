package com.example.latihanmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbPerpustakaan extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="perpus.db";
    public static final String TABLE_NAME="tb_pinjam";
    public static final String ID="_id";
    public static final String KODE_PINJAM="kode_pinjam";
    public static final String NISN="nisn";
    public static final String NAMA="nama";
    public static final String KELAS="kelas";
    public static final String JURUSAN="jurusan";
    public static final String JUDUL="judul";
    public static final String DATEIN="datein";
    public static final String DATEOUT="dateout";
    public dbPerpustakaan(@Nullable Context context){
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("create table if not exists "+
                TABLE_NAME+"(_id integer primary key autoincrement," +
                "kode_pinjam text, nisn text, nama text, kelas text, jurusan text, judul text, datein text, dateout text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String kode_pinjam, String nisn, String nama, String kelas, String jurusan, String judul, String datein, String dateout){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(KODE_PINJAM,kode_pinjam);
        content.put(NISN,nisn);
        content.put(NAMA,nama);
        content.put(KELAS,kelas);
        content.put(JURUSAN,jurusan);
        content.put(JUDUL,judul);
        content.put(DATEIN,datein);
        content.put(DATEOUT,dateout);
        long result = db.insert(TABLE_NAME,null,content);
        if(result==1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Cursor getDataByKode(String kodePinjam) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE kode_pinjam=?", new String[]{kodePinjam});
    }
    public boolean updateData(String kode_pinjam, String nisn, String nama, String kelas, String jurusan, String judul, String datein, String dateout){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(KODE_PINJAM,kode_pinjam);
        content.put(NISN,nisn);
        content.put(NAMA,nama);
        content.put(KELAS,kelas);
        content.put(JURUSAN,jurusan);
        content.put(JUDUL,judul);
        content.put(DATEIN,datein);
        content.put(DATEOUT,dateout);
        long result = db.update(TABLE_NAME,content,"kode_pinjam=?",new String[]{kode_pinjam});
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public boolean deleteData(String kode_pinjam) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.i("Info Delete", "Hapus Kode Data: " + kode_pinjam);
        int result = db.delete(TABLE_NAME, "kode_pinjam=?", new String[]{kode_pinjam});
        return result > 0; // Returns true if delete is successful
    }
}
