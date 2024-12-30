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

public class DataProdukAdapter extends RecyclerView.Adapter<DataProdukAdapter.ViewHolder>{
    DataProduk[] listdata;
    public ImageView image;

    public DataProdukAdapter(DataProduk[] listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_latihan81, parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataProduk myListData = listdata[position];
        Log.i("List Data", "List Data :"+listdata[position].getMerk());
        holder.tvMerk.setText(listdata[position].getMerk());
        holder.tvHarga.setText(listdata[position].getHarga());
        LoadImage loadImage = new LoadImage(holder.imgFoto);
        loadImage.execute(listdata[position].getFoto());
    }

    @Override
    public int getItemCount(){return listdata.length;}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvMerk, tvHarga;
        public ImageView imgFoto;
        public ConstraintLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvMerk = (TextView) itemView.findViewById(R.id.tvMerk);
            this.tvHarga = (TextView) itemView.findViewById(R.id.tvHarga);
            this.imgFoto = (ImageView) itemView.findViewById(R.id.imageView);
            layout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout);
        }
    }
}
