package com.example.datnandroidquanlynhahangkhachsan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.adapter.MenuAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChiTietPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityMainBinding;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu;

import java.util.ArrayList;
import java.util.List;

public class ChiTietPhongActivity extends AppCompatActivity {
    private RecyclerView rscvDichVu;
    private List<DichVu> lsdichvu;
    private MenuAdapter menuAdapter;
    private ActivityChiTietPhongBinding ChiTietPhongBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_chi_tiet_phong);

        ChiTietPhongBinding = ChiTietPhongBinding.inflate(getLayoutInflater());
        setContentView(ChiTietPhongBinding.getRoot());

        ChiTietPhongBinding.toolbarChitietphong.icBack.setOnClickListener(view -> onBackPressed());
        ChiTietPhongBinding.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChiTietPhongActivity.this,DanhSachMenuActivity.class);
                startActivity(intent);
            }
        });
        ChiTietPhongBinding.btnLuuChitietphong.setOnClickListener(view -> onBackPressed());

        rscvDichVu = findViewById(R.id.rscv_dichvu);
        lsdichvu = new ArrayList<>();
        DichVu dv1 = new DichVu( "dv1",  "1",  "1" , "1");
        DichVu dv2 = new DichVu( "dv2",  "2", "2", "2");
        DichVu dv3 = new DichVu( "dv3",  "3", "3", "3");
        DichVu dv4 = new DichVu( "dv4",  "4", "4", "4");
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
//ChiTietPhongBinding.imgListmenu.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        Intent intent= new Intent(ChiTietPhongActivity.this,ListMenuActivity.class );
//        startActivity(intent);
//    }
//});




    }
}