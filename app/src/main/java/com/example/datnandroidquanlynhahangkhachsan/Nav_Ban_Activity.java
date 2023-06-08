package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityNavBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.ui.DangNhapActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.Fragment_dsPhieuDatPhong;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.Fragment_dsPhieuNhanPhong;


public class Nav_Ban_Activity extends AppCompatActivity {
    ActivityNavBanBinding binding;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// xử lý của bottom_nav
        binding = ActivityNavBanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragment = new Fragment_danhSachBan();
        replaceFragment(fragment);

        binding.bottomNavigationViewban.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_danhsachban:
                    fragment = new Fragment_danhSachBan();
                    replaceFragment(fragment);
                    break;
                case R.id.nav_datban:
                    fragment = new Fragment_danhSachPhieuDatBan();
                    replaceFragment(fragment);
                    break;
                case R.id.nav_trangchu:
                    Intent intent=new Intent(this,Toolbar_Drawer_Activity.class);
                    startActivity(intent);
                    break;

                case R.id.nav_nhanban:
                    fragment = new Fragment_danhSachPhieuNhanBan();
                    replaceFragment(fragment);
                    break;
                case R.id.nav_lichsuban:
                    fragment = new Fragment_danhSachLichSuBan();
                    replaceFragment(fragment);
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layoutban, fragment);
        fragmentTransaction.commit();
    }



}
