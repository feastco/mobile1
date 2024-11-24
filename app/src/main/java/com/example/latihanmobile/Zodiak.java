package com.example.latihanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Zodiak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zodiak);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Zodiak.this, MainActivity.class);
                startActivity(intent);
            }
        });
        CalendarView calendarView = (CalendarView) findViewById(R.id.calenderView);
        Button btnCalender = (Button) findViewById(R.id.btnCalender);
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etDate = (EditText) findViewById(R.id.etDate);
        CardView cardV = (CardView) findViewById(R.id.cardV);
        btnCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardV.setVisibility(View.VISIBLE);
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String tanggal = dayOfMonth + "/" + (month + 1) + "/" + year;
                etDate.setText(tanggal);
                cardV.setVisibility(View.GONE);
            }
        });
        Button btnCek = (Button) findViewById(R.id.btnCek);
        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = etName.getText().toString();
                String Date = etDate.getText().toString();
                String zodiac = getZodiac(Date);

                // Pindah ke ZodiacView dengan data zodiak
                Intent intent = new Intent(Zodiak.this, ZodiakView.class);
                intent.putExtra("nama", Name);
                intent.putExtra("zodiac", zodiac);
                intent.putExtra("viewAll", false); // Kirim false untuk menunjukkan hanya zodiak tertentu
                startActivity(intent);
            }
        });
        Button btnViewAll = (Button) findViewById(R.id.btnViewAll);
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke ZodiacView dengan tanda untuk menampilkan semua zodiak
                Intent intent = new Intent(Zodiak.this, ZodiakView.class);
                intent.putExtra("viewAll", true); // Pass true to indicate showing all zodiacs
                startActivity(intent);
            }
        });
    }
        // Fungsi untuk mendapatkan zodiak berdasarkan tanggal lahir
        private String getZodiac(String birthdate) {
            // Misal, format tanggal: dd/MM/yyyy
            String[] dateParts = birthdate.split("/");
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);

            if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
                return "Aquarius";
            } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
                return "Pisces";
            } else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
                return "Aries";
            } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
                return "Taurus";
            } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
                return "Gemini";
            } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
                return "Cancer";
            } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
                return "Leo";
            } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
                return "Virgo";
            } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
                return "Libra";
            } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
                return "Scorpio";
            } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
                return "Sagittarius";
            } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
                return "Capricorn";
            } // Lanjutkan untuk semua zodiak...

            return "Unknown"; // Untuk tanggal yang tidak valid
        }
}
