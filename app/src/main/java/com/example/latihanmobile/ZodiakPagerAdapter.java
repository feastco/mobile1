package com.example.latihanmobile;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

class ZodiacPagerAdapter extends PagerAdapter {
    private Context context;
    private String[] zodiacSigns, zodiacDescriptions, zodiacKepribadian;
    private int[] zodiacImages;
    private String nama;
    private boolean viewAll;

    // Constructor
    public ZodiacPagerAdapter(Context context, String nama, String[] zodiacSigns, String[] zodiacDescriptions, String[] zodiacKepribadian, int[] zodiacImages, boolean viewAll) {
        this.context = context;
        this.nama = nama;
        this.zodiacSigns = zodiacSigns;
        this.zodiacDescriptions = zodiacDescriptions;
        this.zodiacKepribadian = zodiacKepribadian;
        this.zodiacImages = zodiacImages;
        this.viewAll = viewAll;
    }

    @Override
    public int getCount() {
        return zodiacSigns.length; // Return the number of signs
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.from(context).inflate(R.layout.zodiak_slide, container, false);

        // Inisialisasi view yang ada di zodiak_slide.xml
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvZodiak = view.findViewById(R.id.tvZodiak);
        ImageView imageViewZodiac = view.findViewById(R.id.imageViewZodiac);
        TextView textViewDesc = view.findViewById(R.id.textViewDesc);
        TextView textViewKep = view.findViewById(R.id.textViewKep);
        LinearLayout zodiakInfoContainer = view.findViewById(R.id.zodiakInfoContainer);
        LinearLayout zodiakInfo = view.findViewById(R.id.zodiacInfo);
        TextView tvZodiak2 = view.findViewById(R.id.tvZodiak2);

        // Set konten ke tampilan
        if (viewAll==true) {
            zodiakInfoContainer.setVisibility(View.GONE);
            zodiakInfo.setVisibility(View.GONE);
            tvZodiak2.setText(zodiacSigns[position]);
        }else{
            tvZodiak.setText(zodiacSigns[position]);
            tvName.setText(nama);
            tvZodiak2.setVisibility(View.GONE);
        }
        textViewDesc.setText(zodiacDescriptions[position]);
        textViewKep.setText(zodiacKepribadian[position]);
        imageViewZodiac.setImageResource(zodiacImages[position]); // Set gambar zodiak

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
