package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.LoaiPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuDatBanChiTietAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuDatBanChiTietBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuDatBanChiTietActivity extends AppCompatActivity implements KhachHangContract.View, BanContract.View {

    private RecyclerView recyclerView;
    ActivityPhieuDatBanChiTietBinding activityPhieuDatBanChiTietBinding;
    private List<LoaiPhongDTO> loaiPhongDTOList;
    private LoaiPhongPresenter loaiPhongPresenter;
    private LoaiPhongAdapter loaiPhongAdapter;
    private AppUtils appUtils;
    private PhieuDatBanChiTietAdapter phieuDatBanChiTietAdapter;

    private List<BanDTO> banDTOList;
    private List<LoaiBanDTO> loaiBanDTOList;
    private BanPresenter banPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPhieuDatBanChiTietBinding = ActivityPhieuDatBanChiTietBinding.inflate(getLayoutInflater());
        setContentView(activityPhieuDatBanChiTietBinding.getRoot());

        banPresenter = new BanPresenter(this);
        banPresenter.LayDanhSachBan();
        banPresenter.LayDanhSachLoaiBan();


        activityPhieuDatBanChiTietBinding.toolbarPnct.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.datBanDTO = new DatBanDTO();
                tempData.tempDatakhachHangDTO = new KhachHangDTO();
                onBackPressed();
            }
        });

        SetDuLieu();
        NhanBan();
    }

    private void SetDuLieu() {
        activityPhieuDatBanChiTietBinding.tvSctPnct.setText(String.valueOf(tempData.datBanDTO.getPhieuDatDTO().getSoChungTu()));
        activityPhieuDatBanChiTietBinding.tvHotenPnct.setText(String.valueOf(tempData.tempDatakhachHangDTO.getTenKhachHang()));
        String checkSDT = "0";
        if (tempData.tempDatakhachHangDTO.getCccd() != null) {
            activityPhieuDatBanChiTietBinding.tvCccdPnct.setText(String.valueOf(tempData.tempDatakhachHangDTO.getCccd()));
        } else {
            activityPhieuDatBanChiTietBinding.tvCccdPnct.setText("không có");
        }
        activityPhieuDatBanChiTietBinding.tvSdtPnct.setText(String.valueOf(tempData.tempDatakhachHangDTO.getSdt()));
        String thoiGianNhanPhong = appUtils.formatDateToString(tempData.datBanDTO.getPhieuDatDTO().getThoiGianNhanDuKien(), "dd/MM/yyyy HH:mm");
        activityPhieuDatBanChiTietBinding.tvNhan.setText(String.valueOf("Ngày Nhận:"));
        activityPhieuDatBanChiTietBinding.tvNgaynhanPnct.setText(String.valueOf(thoiGianNhanPhong));

        recyclerView = activityPhieuDatBanChiTietBinding.rscvPnct;
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LinearLayoutManager);

        phieuDatBanChiTietAdapter = new PhieuDatBanChiTietAdapter(this);
        // phieuDatBanChiTietAdapter.setData(tempData.datBanDTO.getPhieuDatBanChiTiets());
        phieuDatBanChiTietAdapter.setData(tempData.datBanDTO.getPhieuDatBanChiTiets(), banDTOList, loaiBanDTOList);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        try {
            Thread.sleep(400);
            recyclerView.setAdapter(phieuDatBanChiTietAdapter);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void NhanBan() {
        activityPhieuDatBanChiTietBinding.btnPnct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhieuDatBanChiTietActivity.this, activityThemPhieuNhanBan.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onThemKhachHangSuccess() {

    }

    @Override
    public void onThemKhachHangError(String error) {

    }

    @Override
    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {

    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {

    }

    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
        banDTOList = lsDanhSachBan;
    }

    @Override
    public void onLayDanhSachBanError(String error) {

    }

    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {
        loaiBanDTOList = list;
    }

    @Override
    public void onLayDanhSachLoaiBanError(String error) {

    }
}