package com.example.datnandroidquanlynhahangkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThanhToanBinding;

import java.text.DecimalFormat;

public class ThanhToanActivity extends AppCompatActivity {
private Long tienThoi;
private int tienDua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThanhToanBinding thanhToanBinding=ActivityThanhToanBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences=getSharedPreferences("PHIEUXUAT",MODE_PRIVATE);
        thanhToanBinding.tvTendata.setText(sharedPreferences.getString("TENKH",""));

        thanhToanBinding.toolbarThanhtoan.icBack.setVisibility(View.GONE);

        DecimalFormat decimalFormat=new DecimalFormat("#,##0");
        thanhToanBinding.etThanhtoan.setText(String.valueOf(decimalFormat.format(sharedPreferences.getLong("TIENTHANHTOAN",0L)) )+" đồng" );


        thanhToanBinding.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThanhToanActivity.this,Fragment_dsLichSu.class);
                startActivity(intent);
            }
        });
        thanhToanBinding.etDua.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//// tính tiền thừa khi khác đưa dư
                Long a=Long.parseLong(charSequence.toString());
                Long chage=a-sharedPreferences.getLong("TIENTHANHTOAN",0L);
               thanhToanBinding.tvThoinew.setText(String.valueOf(decimalFormat.format(chage))+" đồng");

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        setContentView(thanhToanBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}