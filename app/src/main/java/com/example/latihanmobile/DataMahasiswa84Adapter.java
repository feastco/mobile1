package com.example.latihanmobile;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class DataMahasiswa84Adapter extends RecyclerView.Adapter<DataMahasiswa84Adapter.ViewHolder> {
    DataMahasiswa84[] listdata;
    public ImageView image;

    public DataMahasiswa84Adapter(DataMahasiswa84[] listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_mahasiswa84, parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataMahasiswa84 myListData = listdata[position];
        Log.i("List Data", "List Data :"+listdata[position].getNim());
        holder.tvNim.setText(listdata[position].getNim());
        holder.tvNama.setText(listdata[position].getNama());
        LoadImage loadImage = new LoadImage(holder.imgFoto);
        loadImage.execute(listdata[position].getFoto());
    }

    @Override
    public int getItemCount(){return listdata.length;}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNim, tvNama;
        public ImageView imgFoto;
        public ConstraintLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvNim = (TextView) itemView.findViewById(R.id.tvNim);
            this.tvNama = (TextView) itemView.findViewById(R.id.tvNama);
            this.imgFoto = (ImageView) itemView.findViewById(R.id.imageView);
            layout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout);
        }
    }
}
