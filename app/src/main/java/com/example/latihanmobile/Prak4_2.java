package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Prak4_2 extends AppCompatActivity {
    ViewPagerAdapter ViewPagerAdapter;
    private ViewPager2 ViewPager2;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak42);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ViewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        FragmentManager fm = getSupportFragmentManager();
        ViewPagerAdapter = new ViewPagerAdapter(fm, getLifecycle());
        ViewPagerAdapter.add(new Prak4Frag1(),"Page 1");
        ViewPagerAdapter.add(new Prak4Frag2(),"Page 2");
        ViewPagerAdapter.add(new Prak4Frag3(),"Page 3");
        ViewPager2.setAdapter(ViewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, ViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(""+ViewPagerAdapter.getPageTitle(position));
            }
        }).attach();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Prak4_2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}