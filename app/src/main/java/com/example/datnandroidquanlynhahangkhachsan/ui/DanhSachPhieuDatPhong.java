package com.example.datnandroidquanlynhahangkhachsan.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuDatPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.model.KhachHang;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuDat;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuDatPhongChiTiet;
import com.example.datnandroidquanlynhahangkhachsan.model.Phong;

import java.util.ArrayList;
import java.util.List;

public class DanhSachPhieuDatPhong extends AppCompatActivity {
    private RecyclerView rscvPhieuDatPhong;
    private List<PhieuDat> lsPhieuDat;
    private List<PhieuDatPhongChiTiet> lsPhieuDatPhongChiTiet;
    private List<Phong> lsPhong;
    private List<KhachHang> lsKhachHang;
    private PhieuDatPhongAdapter phieuDatPhongAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phong);
        rscvPhieuDatPhong = findViewById(R.id.rscv_dsphieudatphong);
        lsPhieuDat = new ArrayList<>();
        PhieuDat pd1 = new PhieuDat( "dv1",  "1",  "1" , "1",'1', "2002/10/04", "05/10/2002", "abc",'1', "Đang đặt");
        lsPhieuDat.add(pd1);
        phieuDatPhongAdapter = new PhieuDatPhongAdapter(lsPhieuDat);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        rscvPhieuDatPhong.setLayoutManager(LinearLayoutManager);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rscvPhieuDatPhong.addItemDecoration(decoration);
        rscvPhieuDatPhong.setAdapter(phieuDatPhongAdapter);
    }
}
