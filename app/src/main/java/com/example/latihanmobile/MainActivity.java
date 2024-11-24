    package com.example.latihanmobile;

    import android.annotation.SuppressLint;
    import android.os.Bundle;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentTransaction;

    import com.example.latihanmobile.databinding.ActivityMainBinding;

    public class MainActivity extends AppCompatActivity {
        ActivityMainBinding binding;
        @SuppressLint("NonConstantResourceId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            getSupportActionBar().hide();
            replaceFragment(new Home());
            binding.bottomNavigationView.setOnItemSelectedListener(item -> {
                if (item.getItemId() == R.id.home) {
                    replaceFragment(new Home());
                } else if (item.getItemId() == R.id.profile) {
                    replaceFragment(new Identitas());
                }else{
                    replaceFragment(new Home());
                }
                return true;
            });
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        public void replaceFragment(Fragment fragment) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
            fragmentTransaction.commit();
        }
    }