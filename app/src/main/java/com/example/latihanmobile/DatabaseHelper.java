package com.example.latihanmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="kendaraan.db";
    public static final String TABLE_NAME="tb_kendaraan";
    public static final String ID="_id";
    public static final String NOPOL="nopol";
    public static final String MEREK="merek";
    public static final String TAHUN="tahun";
    public DatabaseHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("create table if not exists "+
                TABLE_NAME+"(_id integer primary key autoincrement," +
                "nopol text, merek text, tahun int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String nopol, String merek, Double tahun){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(NOPOL,nopol);
        content.put(MEREK,merek);
        content.put(TAHUN,tahun);
        long result = db.insert(TABLE_NAME,null,content);
        if(result==1){
            return false;
        }else{
            return true;
        }
    }
}
