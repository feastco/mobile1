package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Latihan8_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_latihan81);
        getSupportActionBar().hide();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Latihan8_1.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DataProduk[] mylistData = new DataProduk[]{
                new DataProduk("Apple iPhone 13 128GB, Starlight", "Rp. 8.999.000,00", "https://down-id.img.susercontent.com/file/c9f9c2cfd364b5bf5eade5584931ac7e.webp"),
                new DataProduk("Apple iPhone 13 128GB, Midnight","Rp. 8.999.000,00","https://down-id.img.susercontent.com/file/0c3e5a657b79c68ab51a77d2770268d7@resize_w450_nl.webp"),
                new DataProduk("Apple iPhone 12 128 GB","Rp. 8.413.911,00","https://down-id.img.susercontent.com/file/id-11134207-7r98r-lvyvq1u79l4e85@resize_w450_nl.webp"),
                new DataProduk("Samsung Galaxy A55 5G 12/256GB - Awesome Navy","Rp. 6.899.000,00","https://down-id.img.susercontent.com/file/id-11134201-7ras8-m2w5q9xxs5xb3f.webp"),
                new DataProduk("Samsung Galaxy A55 5G 8/256GB - Awesome Ice Blue","Rp. 6.499.000,00","https://down-id.img.susercontent.com/file/id-11134201-7rask-m2w5qiokzq3939.webp"),
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        DataProdukAdapter adapter = new DataProdukAdapter(mylistData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
    }
}