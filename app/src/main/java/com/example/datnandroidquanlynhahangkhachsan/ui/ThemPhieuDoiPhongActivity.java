package com.example.datnandroidquanlynhahangkhachsan.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieudoiphongBinding;

public class ThemPhieuDoiPhongActivity extends AppCompatActivity {

ActivityPhieudoiphongBinding phieudoiphongBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        phieudoiphongBinding=ActivityPhieudoiphongBinding.inflate(getLayoutInflater());
        phieudoiphongBinding.toolbarPhieudoiphong.icBack.setOnClickListener(view -> onBackPressed()
        );
        setContentView(phieudoiphongBinding.getRoot());

    }
}