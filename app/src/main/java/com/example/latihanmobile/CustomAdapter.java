package com.example.latihanmobile;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    private String[] localeDataset;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        public ViewHolder(View view){
            super(view);
            textView = (TextView) view.findViewById(R.id.textViewRow);
        }
        public TextView getTextView(){return textView;}
    }
    public CustomAdapter(String[] dataset) {localeDataset= dataset;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position){
        viewHolder.getTextView().setText(localeDataset[position]);
    }

    @Override
    public int getItemCount(){return localeDataset.length;}
}
