package com.example.datnandroidquanlynhahangkhachsan;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

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
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuDatBanChiTietActivity extends AppCompatActivity implements KhachHangContract.View, BanContract.View, DsPhieuDatPhongContract.View {

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
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPhieuDatBanChiTietBinding = ActivityPhieuDatBanChiTietBinding.inflate(getLayoutInflater());
        setContentView(activityPhieuDatBanChiTietBinding.getRoot());
        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);

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
        if (tempData.datBanDTO!=null){
            SetDuLieu();
        }
        NhanBan();

        activityPhieuDatBanChiTietBinding.btnHuydatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tempData.datBanDTO != null) {

                    DiaLogHuyDatPhong();

//                    tempData.datBanDTO.getPhieuDatDTO().setTrangThai("đã hủy");
//
//                    dsPhieuDatPhongPresenter.CapNhatPhieuDat(tempData.datBanDTO.getPhieuDatDTO());
//                    onBackPressed();
                }
            }
        });
    }

    private void DiaLogHuyDatPhong() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_huy_dat_phong);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        TextView btnYes = dialog.findViewById(R.id.btn_yes);
        TextView btnNo = dialog.findViewById(R.id.btn_no);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tempData.datBanDTO.getPhieuDatDTO().setTrangThai("đã hủy");

                dsPhieuDatPhongPresenter.CapNhatPhieuDat(tempData.datBanDTO.getPhieuDatDTO());
                dialog.dismiss();
                onBackPressed();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();


            }
        });


        dialog.show();


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

    @Override
    public void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list) {

    }

    @Override
    public void onLayDanhSachPhieuDatError(String error) {

    }

    @Override
    public void onThemPhieuDatPhongSuccess() {

    }

    @Override
    public void onThemPhieuDatPhongError(String error) {

    }

    @Override
    public void onThemPhieuDatPhongChiTietSuccess() {

    }

    @Override
    public void onThemPhieuDatPhongChiTietError(String error) {

    }

    @Override
    public void onLayPhieuDatPhongChiTietSuccess(List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOList) {

    }

    @Override
    public void onLayPhieuDatPhongChiTietError(String error) {

    }

    @Override
    public void onThemPhieuDatBanSuccess() {

    }

    @Override
    public void onThemPhieuDatBanError(String error) {

    }

    @Override
    public void onLayPhieuDatBanChiTietSuccess(List<PhieuDatBanChiTietDTO> phieuDatPhongChiTietDTOList) {

    }

    @Override
    public void onLayPhieuDatBanChiTietError(String error) {

    }

    @Override
    public void onCapNhatPhieuDatSuccess() {

    }

    @Override
    public void onCapNhatPhieuDatError(String error) {

    }

    @Override
    public void onCapNhatTrangThaiBanSuccess(){}

    @Override
    public void onCapNhatTrangThaiBanError(String error){}

    @Override
    public void onDoiBanSuccess() {

    }

    @Override
    public void onDoiBanError(String error) {

    }
}