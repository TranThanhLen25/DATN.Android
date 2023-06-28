package com.example.datnandroidquanlynhahangkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChitietPhieuThuBinding;

public class Activity_Chitiet_PhieuThu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChitietPhieuThuBinding chitietPhieuThuBinding=ActivityChitietPhieuThuBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences=getSharedPreferences("TT_PHIEUTHU",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        chitietPhieuThuBinding.tvSochungtutt.setText(sharedPreferences.getString("SCT",""));
        chitietPhieuThuBinding.tvNgaylaptt.setText(sharedPreferences.getString("NGAY",""));
        chitietPhieuThuBinding.etDuatt.setText(sharedPreferences.getString("DUA",""));
        chitietPhieuThuBinding.etThanhtoantt.setText(sharedPreferences.getString("TIENNHAN",""));
        chitietPhieuThuBinding.tvThoinewtt.setText(sharedPreferences.getString("THOI",""));
        chitietPhieuThuBinding.etGhichutt.setText(sharedPreferences.getString("GHICHU",""));
        chitietPhieuThuBinding.toolbarThanhtoan.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                editor.clear();
                editor.apply();
            }
        });
        setContentView(chitietPhieuThuBinding.getRoot());
    }
}