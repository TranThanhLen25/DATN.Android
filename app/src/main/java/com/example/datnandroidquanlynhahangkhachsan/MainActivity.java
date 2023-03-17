package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    private RecyclerView rscvDichVu;
//    private List<DichVu> lsdichvu;
//    private MenuAdapter menuAdapter;
    ActivityMainBinding binding;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chitietphong);
//        ///recyclerview
//        rscvDichVu = findViewById(R.id.rscv_dichvu);
//        lsdichvu = new ArrayList<>();
//        DichVu dv1 = new DichVu("dv1", "1", "1", "1");
//        DichVu dv2 = new DichVu("dv2", "2", "2", "2");
//        DichVu dv3 = new DichVu("dv3", "3", "3", "3");
//        DichVu dv4 = new DichVu("dv4", "4", "4", "4");
//        lsdichvu.add(dv1);
//        lsdichvu.add(dv2);
//        lsdichvu.add(dv3);
//        lsdichvu.add(dv4);
//        menuAdapter = new MenuAdapter(lsdichvu);
//        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
//        rscvDichVu.setLayoutManager(LinearLayoutManager);
//        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        rscvDichVu.addItemDecoration(decoration);
//        rscvDichVu.setAdapter(menuAdapter);

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


