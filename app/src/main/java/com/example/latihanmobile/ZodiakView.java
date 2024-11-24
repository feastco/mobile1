package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ZodiakView extends AppCompatActivity {
    private ViewPager viewPager;
    private ZodiacPagerAdapter pagerAdapter;
    private String[] zodiacSigns, zodiacDescriptions, zodiacKepribadian;
    private int[] zodiacImages;
    private String nama;
    private String zodiac; // Zodiak yang dikirim dari Zodiak.java
    private boolean viewAll;
    private Button btnNext, btnPrev;// Apakah melihat semua atau tidak

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiak_view);
        getSupportActionBar().hide();

        // Terima data dari Intent
        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        zodiac = intent.getStringExtra("zodiac");
        viewAll = intent.getBooleanExtra("viewAll", true); // Default value is true for viewAll

        // Inisialisasi data zodiak
        zodiacSigns = getResources().getStringArray(R.array.zodiac_signs);
        zodiacDescriptions = getResources().getStringArray(R.array.zodiac_descriptions);
        zodiacKepribadian = getResources().getStringArray(R.array.zodiac_kepribadian);
        zodiacImages = new int[]{
                R.drawable.aquarius, R.drawable.pisces, R.drawable.aries, R.drawable.taurus,
                R.drawable.gemini, R.drawable.cancer, R.drawable.leo, R.drawable.virgo,
                R.drawable.libra, R.drawable.scorpio, R.drawable.sagitarius, R.drawable.capricorn
        };

        // Inisialisasi ViewPager dan tombol navigasi
        viewPager = findViewById(R.id.viewPager);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);

        // Cek apakah harus menampilkan satu zodiak atau semua
        if (viewAll) {
            showAllZodiacs(); // Menampilkan semua zodiak
            // Setup tombol next dan prev
            setupButtonListeners();
        } else {
            showSingleZodiac(zodiac); // Menampilkan satu zodiak berdasarkan input
        }
    }

    // Menampilkan satu zodiak
    private void showSingleZodiac(String zodiac) {
        // Cari index dari zodiak yang sesuai
        int zodiacIndex = findZodiacIndex(zodiac);

        // Jika zodiak ditemukan, set adapter hanya dengan satu zodiak
        if (zodiacIndex != -1) {
            String xnama = nama;
            String[] singleZodiacSign = {zodiacSigns[zodiacIndex]};
            String[] singleZodiacDesc = {zodiacDescriptions[zodiacIndex]};
            String[] singleZodiacKep = {zodiacKepribadian[zodiacIndex]};
            int[] singleZodiacImage = {zodiacImages[zodiacIndex]};

            pagerAdapter = new ZodiacPagerAdapter(this, xnama, singleZodiacSign, singleZodiacDesc, singleZodiacKep, singleZodiacImage, false);
            viewPager.setAdapter(pagerAdapter);

            // Sembunyikan tombol next dan prev, karena hanya ada satu zodiak
            btnNext.setVisibility(View.GONE);
            btnPrev.setVisibility(View.GONE);

        } else {
            // Jika tidak ditemukan, tampilkan pesan error atau zodiak default
            Toast.makeText(this, "Zodiak tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    // Menampilkan semua zodiak
    private void showAllZodiacs() {
        pagerAdapter = new ZodiacPagerAdapter(this, nama, zodiacSigns, zodiacDescriptions, zodiacKepribadian, zodiacImages, true);
        viewPager.setAdapter(pagerAdapter);

        // Tampilkan tombol next dan prev
        btnNext.setVisibility(View.VISIBLE);
        btnPrev.setVisibility(View.VISIBLE);
    }

    // Metode untuk menemukan index zodiak berdasarkan nama
    private int findZodiacIndex(String zodiac) {
        for (int i = 0; i < zodiacSigns.length; i++) {
            if (zodiacSigns[i].equalsIgnoreCase(zodiac)) {
                return i;
            }
        }
        return -1; // Jika zodiak tidak ditemukan
    }
    // Setup tombol Next dan Prev untuk ViewPager
    private void setupButtonListeners() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextItem = viewPager.getCurrentItem() + 1;
                Log.d("ViewPager", "Item saat ini: " + viewPager.getCurrentItem() + ", Item berikutnya: " + nextItem);
                if (nextItem < pagerAdapter.getCount()) {
                    viewPager.setCurrentItem(nextItem);
                }
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int prevItem = viewPager.getCurrentItem() - 1;
                Log.d("ViewPager", "Item saat ini: " + viewPager.getCurrentItem() + ", Item sebelumnya: " + prevItem);
                if (prevItem >= 0) {
                    viewPager.setCurrentItem(prevItem);
                }
            }
        });
    }
}