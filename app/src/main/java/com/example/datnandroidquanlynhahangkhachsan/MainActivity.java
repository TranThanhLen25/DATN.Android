package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.MenuAdapter;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rscvDichVu;
    private List<DichVu> lsdichvu;
    private MenuAdapter menuAdapter;
    //ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietphong);
        ///recyclerview
        rscvDichVu = findViewById(R.id.rscv_dichvu);
        lsdichvu = new ArrayList<>();
        DichVu dv1 = new DichVu("dv1", "1", "1", "1");
        DichVu dv2 = new DichVu("dv2", "2", "2", "2");
        DichVu dv3 = new DichVu("dv3", "3", "3", "3");
        DichVu dv4 = new DichVu("dv4", "4", "4", "4");
        lsdichvu.add(dv1);
        lsdichvu.add(dv2);
        lsdichvu.add(dv3);
        lsdichvu.add(dv4);
        menuAdapter = new MenuAdapter(lsdichvu);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        rscvDichVu.setLayoutManager(LinearLayoutManager);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rscvDichVu.addItemDecoration(decoration);
        rscvDichVu.setAdapter(menuAdapter);

// xử lý của bottom_nav
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        replaceFragment(new Fragment_dsPhong());
//        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.nav_danhsach:
//                    replaceFragment(new Fragment_dsPhong());
//                    break;
//                case R.id.nav_datphong:
//                    replaceFragment(new Fragment_dsPhieuDatPhong());
//                    break;
//                case R.id.nav_nhanphong:
//                    replaceFragment(new Fragment_dsPhieuNhanPhong());
//                    break;
//                case R.id.nav_lichsu:
//                    replaceFragment(new Fragment_dsLichSu());
//                    break;
//            }
//            return true;
//        });
//    }
//
//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_layout, fragment);
//        fragmentTransaction.commit();
    }
}


