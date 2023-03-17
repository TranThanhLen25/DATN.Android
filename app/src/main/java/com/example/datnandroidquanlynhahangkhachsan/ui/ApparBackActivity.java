package com.example.datnandroidquanlynhahangkhachsan.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsLichSu;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhieuDatPhong;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhieuNhanPhong;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhong;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_trangchu;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityMainBinding;

public class ApparBackActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appar_back);


    }
}