package com.example.datnandroidquanlynhahangkhachsan.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityDanhsachmenuBinding;
import com.example.datnandroidquanlynhahangkhachsan.fragment_menu;

public class DanhSachMenuActivity extends AppCompatActivity {

    ActivityDanhsachmenuBinding danhsachmenuBinding;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        danhsachmenuBinding = ActivityDanhsachmenuBinding.inflate(getLayoutInflater());

        setContentView(danhsachmenuBinding.getRoot());
        fragment = new fragment_menu();
        replaceFragment(fragment);
        danhsachmenuBinding.incluMenu.icBack.setOnClickListener(view -> onBackPressed());

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_menu, fragment);
        fragmentTransaction.commit();
    }
}