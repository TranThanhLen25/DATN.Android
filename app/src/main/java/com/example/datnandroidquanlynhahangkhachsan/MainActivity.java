package com.example.datnandroidquanlynhahangkhachsan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding .inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Fragment_dsPhong());
     binding.bottomNavigationView.setOnItemSelectedListener(item->{
         switch (item.getItemId()){
             case  R.id.nav_danhsach:
                 replaceFragment(new Fragment_dsPhong());
                 break;
             case R.id.nav_datphong:
                 replaceFragment(new Fragment_dsPhieuDatPhong());
                 break;
             case R.id.nav_nhanphong:
                 replaceFragment(new Fragment_dsPhieuNhanPhong());
                 break;
             case R.id.nav_lichsu:
                 replaceFragment(new Fragment_dsLichSu());
                 break;
         }
         return true;
     });
    }
private void replaceFragment(Fragment fragment)
{
    FragmentManager fragmentManager= getSupportFragmentManager();
    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.frame_layout,fragment);
    fragmentTransaction.commit();
}
}