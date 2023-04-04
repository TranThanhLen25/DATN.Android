package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


// xử lý của bottom_nav
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragment = new  Fragment_dsPhong();
        replaceFragment(fragment);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_danhsach:
                    fragment = new  Fragment_dsPhong();
                    replaceFragment(fragment);
                    break;
                case R.id.nav_datphong:
                    fragment = new  Fragment_dsPhieuDatPhong();
                    replaceFragment(fragment);
                    break;
                case R.id.nav_trangchu:
                    Intent intent=new Intent(this,Toolbar_Drawer_Activity.class);
                    startActivity(intent);
                 break;

                case R.id.nav_nhanphong:
                    fragment = new  Fragment_dsPhieuNhanPhong();
                    replaceFragment(fragment);
                    break;
                case R.id.nav_lichsu:
                    fragment = new Fragment_dsLichSu();
                    replaceFragment(fragment);
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}


