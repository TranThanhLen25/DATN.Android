package com.example.datnandroidquanlynhahangkhachsan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThanhToanBinding;

import java.text.DecimalFormat;

public class ThanhToanActivity extends AppCompatActivity {
private Long tienThoi;
private int tienDua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThanhToanBinding thanhToanBinding = ActivityThanhToanBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        thanhToanBinding.tvTendata.setText(sharedPreferences.getString("TEN", ""));

        thanhToanBinding.toolbarThanhtoan.icBack.setVisibility(View.GONE);


        DecimalFormat decimalFormat = new DecimalFormat("#,##0");

        Long tienTT = sharedPreferences.getLong("TT_NGAY", 0L) + sharedPreferences.getLong("TT_DV", 0L);
        thanhToanBinding.etThanhtoan.setText(String.valueOf(decimalFormat.format(tienTT)) + " đồng");


        thanhToanBinding.etDua.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //// tính tiền thừa khi khác đưa dư
                Long a = Long.parseLong(charSequence.toString());
                Long chage = a - tienTT;
               thanhToanBinding.tvThoinew.setText(String.valueOf(decimalFormat.format(chage))+" đồng");

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        thanhToanBinding.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                onBackPressed();
                finish();


            }
        });

        setContentView(thanhToanBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}