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

public class Prak8_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prak84);
        getSupportActionBar().hide();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Prak8_4.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DataMahasiswa84[] mylistData = new DataMahasiswa84[]{
                new DataMahasiswa84("A22.2021.00001", "Anisa Rahmawati", "https://lh3.googleusercontent.com/a-/ALV-UjVMjgdb4vkRSurJT_1oGIk5YAbHJYZYg0tcINHfwhcCSNvE-yDDT5FDmcpyBH9POKuogfwC3ADu2sHbLRh681Ghyboy-l8bsogu3rvSTK5PQnYrFLbCl_yv0FqT3qkQoZ3VhqeqWvAkPf_WDESsQygLKCzdMMx2vQdN7pLtIk790W84KhSu7INzlP-GPWNhX0fwnD8dUZiJphyujXqydN8L9ZEf90hoEThJ5MLwUQmkGF8iHIYPJFMpXFEMsHTIEqLr8AwRzpuHWPNHSDqnPKrzD2Xpt-LwA5ex5d5o8bkthpllEk0kwUaveqJVhn7xSgoyeSQga8C3Y6SuFQVHZuf4VtGN5BN6rGt9dYH_1Ufv_Srh6sTWN8EiitgcH5xgr2Y0UWal_0BTWK6PbceCb_y39OJh8CEFpStm5PzySwvGKW1lm54pyCsv4qMVtBCjHqH_nQShd3zvhHXHrpPCjCGTJkyExj3eLU9FpwdQofO2MUkD1ZaZJP4ZdhZ4fK_rwbXbqNrZOobvG0O8N5yBGDytNREVuhCCpCs0viU6ZEml-lgIfBuOpi0I6CtTdYQiad6EzMmG6l59F1KSKnQTdNzNHGoWmb2fRbzRgcR1lXCh_qa0uLZ_mJ3Q203RKySCRMwTCwNMhQ2lexdKkCmeofEiLeoqpQD9VxDX2IO_HQlqMnly6EMiS4zIJ2X-EqBRUJ64YrCaHJzyHrLZg-Wo7OceNBmkiivOeIh5L_EUcFQWEgn4sYn8CzpLtcrDc7obl0cUjVhZFoGsX2Ffe5R6DMQK4ojs0OomQq5_d8PYFJQQz-CShJO-wSAyfsPZPCSoDEz5Ke3pcZoWcryAB4be2HAmJMKLAAQEcQ63n1QOvbrWTpY-y2PzYYLiU-nf-KhSvAmf2eXuPjWfI7Z3N9XFOctqGzUDabLBHoBkPxpuHbOWdP11OgT95yNZC82xepBIH4QaqtL0BPLtCWKdaSZvWn4=s288-c-no"),
                new DataMahasiswa84("A22.2021.00002", "Mikel Johan", "https://lh3.googleusercontent.com/a-/ALV-UjVMjgdb4vkRSurJT_1oGIk5YAbHJYZYg0tcINHfwhcCSNvE-yDDT5FDmcpyBH9POKuogfwC3ADu2sHbLRh681Ghyboy-l8bsogu3rvSTK5PQnYrFLbCl_yv0FqT3qkQoZ3VhqeqWvAkPf_WDESsQygLKCzdMMx2vQdN7pLtIk790W84KhSu7INzlP-GPWNhX0fwnD8dUZiJphyujXqydN8L9ZEf90hoEThJ5MLwUQmkGF8iHIYPJFMpXFEMsHTIEqLr8AwRzpuHWPNHSDqnPKrzD2Xpt-LwA5ex5d5o8bkthpllEk0kwUaveqJVhn7xSgoyeSQga8C3Y6SuFQVHZuf4VtGN5BN6rGt9dYH_1Ufv_Srh6sTWN8EiitgcH5xgr2Y0UWal_0BTWK6PbceCb_y39OJh8CEFpStm5PzySwvGKW1lm54pyCsv4qMVtBCjHqH_nQShd3zvhHXHrpPCjCGTJkyExj3eLU9FpwdQofO2MUkD1ZaZJP4ZdhZ4fK_rwbXbqNrZOobvG0O8N5yBGDytNREVuhCCpCs0viU6ZEml-lgIfBuOpi0I6CtTdYQiad6EzMmG6l59F1KSKnQTdNzNHGoWmb2fRbzRgcR1lXCh_qa0uLZ_mJ3Q203RKySCRMwTCwNMhQ2lexdKkCmeofEiLeoqpQD9VxDX2IO_HQlqMnly6EMiS4zIJ2X-EqBRUJ64YrCaHJzyHrLZg-Wo7OceNBmkiivOeIh5L_EUcFQWEgn4sYn8CzpLtcrDc7obl0cUjVhZFoGsX2Ffe5R6DMQK4ojs0OomQq5_d8PYFJQQz-CShJO-wSAyfsPZPCSoDEz5Ke3pcZoWcryAB4be2HAmJMKLAAQEcQ63n1QOvbrWTpY-y2PzYYLiU-nf-KhSvAmf2eXuPjWfI7Z3N9XFOctqGzUDabLBHoBkPxpuHbOWdP11OgT95yNZC82xepBIH4QaqtL0BPLtCWKdaSZvWn4=s288-c-no"),
                new DataMahasiswa84("A22.2021.00003", "Aditya Santoso", "https://lh3.googleusercontent.com/a-/ALV-UjVMjgdb4vkRSurJT_1oGIk5YAbHJYZYg0tcINHfwhcCSNvE-yDDT5FDmcpyBH9POKuogfwC3ADu2sHbLRh681Ghyboy-l8bsogu3rvSTK5PQnYrFLbCl_yv0FqT3qkQoZ3VhqeqWvAkPf_WDESsQygLKCzdMMx2vQdN7pLtIk790W84KhSu7INzlP-GPWNhX0fwnD8dUZiJphyujXqydN8L9ZEf90hoEThJ5MLwUQmkGF8iHIYPJFMpXFEMsHTIEqLr8AwRzpuHWPNHSDqnPKrzD2Xpt-LwA5ex5d5o8bkthpllEk0kwUaveqJVhn7xSgoyeSQga8C3Y6SuFQVHZuf4VtGN5BN6rGt9dYH_1Ufv_Srh6sTWN8EiitgcH5xgr2Y0UWal_0BTWK6PbceCb_y39OJh8CEFpStm5PzySwvGKW1lm54pyCsv4qMVtBCjHqH_nQShd3zvhHXHrpPCjCGTJkyExj3eLU9FpwdQofO2MUkD1ZaZJP4ZdhZ4fK_rwbXbqNrZOobvG0O8N5yBGDytNREVuhCCpCs0viU6ZEml-lgIfBuOpi0I6CtTdYQiad6EzMmG6l59F1KSKnQTdNzNHGoWmb2fRbzRgcR1lXCh_qa0uLZ_mJ3Q203RKySCRMwTCwNMhQ2lexdKkCmeofEiLeoqpQD9VxDX2IO_HQlqMnly6EMiS4zIJ2X-EqBRUJ64YrCaHJzyHrLZg-Wo7OceNBmkiivOeIh5L_EUcFQWEgn4sYn8CzpLtcrDc7obl0cUjVhZFoGsX2Ffe5R6DMQK4ojs0OomQq5_d8PYFJQQz-CShJO-wSAyfsPZPCSoDEz5Ke3pcZoWcryAB4be2HAmJMKLAAQEcQ63n1QOvbrWTpY-y2PzYYLiU-nf-KhSvAmf2eXuPjWfI7Z3N9XFOctqGzUDabLBHoBkPxpuHbOWdP11OgT95yNZC82xepBIH4QaqtL0BPLtCWKdaSZvWn4=s288-c-no"),
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        DataMahasiswa84Adapter adapter = new DataMahasiswa84Adapter(mylistData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(adapter);
    }
}