package com.example.latihanmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataMahasiswaAdapter91 extends RecyclerView.Adapter<DataMahasiswaAdapter91.ViewHolder> {
    private Context context;
    private List<DataMahasiswa91> results;

    public DataMahasiswaAdapter91(Context context, List<DataMahasiswa91> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public DataMahasiswaAdapter91.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mahasiswa91, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataMahasiswaAdapter91.ViewHolder holder, int position) {
        DataMahasiswa91 result = results.get(position);
        holder.tvNim.setText(result.getNim());
        holder.tvNama.setText(result.getNama());
        holder.tvTelp.setText(result.getTelp());
        holder.tvEmail.setText(result.getEmail());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNim, tvNama, tvTelp, tvEmail;
        public ConstraintLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvNim = (TextView) itemView.findViewById(R.id.tvNim);
            this.tvNama = (TextView) itemView.findViewById(R.id.tvNama);
            this.tvTelp = (TextView) itemView.findViewById(R.id.tvTelp);
            this.tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            layout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout);
        }
    }
}
