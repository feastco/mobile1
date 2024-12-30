package com.example.latihanmobile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class LoadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;

    public LoadImage(ImageView imageView){
        this.imageView=imageView;
    }

    protected Bitmap doInBackground(String... strings){
        Bitmap bitmap=null;
        try{
            bitmap= BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap){
        if (bitmap!=null){
            imageView.setImageBitmap(bitmap);
        }
    }
}
