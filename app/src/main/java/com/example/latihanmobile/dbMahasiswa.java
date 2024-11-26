package com.example.latihanmobile;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbMahasiswa extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="mahasiswa.db";
    public static final String TABLE_NAME="tb_mahasiswa";
    public static final String ID="_id";
    public static final String NIM="nim";
    public static final String NAMA="nama";
    public static final String IPK="ipk";
    public dbMahasiswa(@Nullable Context context){
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("create table if not exists "+
                TABLE_NAME+"(_id integer primary key autoincrement," +
                "nim text, nama text, ipk double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String nim, String nama, Double ipk){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(NIM,nim);
        content.put(NAMA,nama);
        content.put(IPK,ipk);
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
    public Cursor getDataByNim(String nim) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE nim=?", new String[]{nim});
    }
    public boolean updateData(String nim, String nama, Double ipk){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(NAMA,nama);
        content.put(IPK,ipk);
        long result = db.update(TABLE_NAME,content,"nim=?",new String[]{nim});
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public boolean deleteData(String nim) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.i("Info Delete", "Hapus Nim: " + nim);
        int result = db.delete(TABLE_NAME, "nim=?", new String[]{nim});
        return false;
    }
}
