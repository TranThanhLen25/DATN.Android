package com.example.datnandroidquanlynhahangkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuDatPhongChiTietBinding;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieudatphongBinding;

public class PhieuDatPhongChiTietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhieuDatPhongChiTietBinding phieuDatPhongChiTietBinding= ActivityPhieuDatPhongChiTietBinding.inflate(getLayoutInflater());
        phieuDatPhongChiTietBinding.toolbarPhieudatphong.icBack.setOnClickListener(view -> onBackPressed());
        setContentView(phieuDatPhongChiTietBinding.getRoot());
    }
}