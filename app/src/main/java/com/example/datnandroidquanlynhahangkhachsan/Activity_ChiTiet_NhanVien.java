package com.example.datnandroidquanlynhahangkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChiTietNhanVienBinding;

public class Activity_ChiTiet_NhanVien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChiTietNhanVienBinding chiTietNhanVienBinding=ActivityChiTietNhanVienBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences=getSharedPreferences("TT_NHANVIEN",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        chiTietNhanVienBinding.cv.setText(sharedPreferences.getString("CV",""));
        chiTietNhanVienBinding.tvTendata.setText(sharedPreferences.getString("TEN",""));
        chiTietNhanVienBinding.tvCcdata.setText(sharedPreferences.getString("GT",""));
        chiTietNhanVienBinding.tvSodtdata.setText(sharedPreferences.getString("SDT",""));
        chiTietNhanVienBinding.tvGtdata.setText(sharedPreferences.getString("CCCD",""));
        chiTietNhanVienBinding.etTktt.setText(sharedPreferences.getString("TK",""));
        chiTietNhanVienBinding.etMktt.setText(sharedPreferences.getString("MK",""));
        chiTietNhanVienBinding.tvQqdata.setText(sharedPreferences.getString("DC",""));
        chiTietNhanVienBinding.toolbarTk.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                onBackPressed();
            }
        });



        setContentView(chiTietNhanVienBinding.getRoot());
    }
}