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
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuDatPhongChiTietBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.ThemPhieuNhanPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class PhieuDatPhongChiTietActivity extends AppCompatActivity implements LoaiPhongContract.View, KhachHangContract.View, DsPhieuDatPhongContract.View {
    private RecyclerView rcv_LoaiPhong;
    ActivityPhieuDatPhongChiTietBinding phieuDatPhongChiTietBinding;
    private List<LoaiPhongDTO> loaiPhongDTOList;
    private LoaiPhongPresenter loaiPhongPresenter;
    private LoaiPhongAdapter loaiPhongAdapter;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter;
    private AppUtils appUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        phieuDatPhongChiTietBinding = ActivityPhieuDatPhongChiTietBinding.inflate(getLayoutInflater());
        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
        phieuDatPhongChiTietBinding.toolbarPhieudatphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.datPhongDTO = new DatPhongDTO();
                tempData.tempDatakhachHangDTO = new KhachHangDTO();
                onBackPressed();
            }
        });
        setContentView(phieuDatPhongChiTietBinding.getRoot());
        //lấy loại phòng
        LayLoaiPhong();
        if (tempData.datPhongDTO != null) {
            SetDuLieu();
        }
        NhanPhong();

        phieuDatPhongChiTietBinding.btnHuydatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DiaLogHuyDatPhong();

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

                tempData.datPhongDTO.getPhieuDatDTO().setTrangThai("đã hủy");

                dsPhieuDatPhongPresenter.CapNhatPhieuDat(tempData.datPhongDTO.getPhieuDatDTO());
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

    private void NhanPhong() {
        phieuDatPhongChiTietBinding.btnThemphieunhanphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhieuDatPhongChiTietActivity.this, ThemPhieuNhanPhongActivity.class);
                startActivity(intent);
            }
        });
    }

    private void SetDuLieu() {
        phieuDatPhongChiTietBinding.tvSochungtuData.setText(String.valueOf(tempData.datPhongDTO.getPhieuDatDTO().getSoChungTu()));
        phieuDatPhongChiTietBinding.etHotenPhieudatphong.setText(String.valueOf(tempData.tempDatakhachHangDTO.getTenKhachHang()));
        String checkSDT = "0";
        if (tempData.tempDatakhachHangDTO.getCccd() != null) {
            phieuDatPhongChiTietBinding.etCccdPhieudatphong.setText(String.valueOf(tempData.tempDatakhachHangDTO.getCccd()));
        } else {
            phieuDatPhongChiTietBinding.etCccdPhieudatphong.setText("không có");
        }
        phieuDatPhongChiTietBinding.etSdtPhieudatphong.setText(String.valueOf(tempData.tempDatakhachHangDTO.getSdt()));
        String thoiGianNhanPhong = appUtils.formatDateToString(tempData.datPhongDTO.getPhieuDatDTO().getThoiGianNhanDuKien(), "dd/MM/yyyy HH:mm");
        phieuDatPhongChiTietBinding.etThoigiannhanPhieudatphong.setText(String.valueOf(thoiGianNhanPhong));
        if (tempData.datPhongDTO.getPhieuDatDTO().getThoiGianTraDuKien() != null) {
            String thoiGianTraPhong = appUtils.formatDateToString(tempData.datPhongDTO.getPhieuDatDTO().getThoiGianNhanDuKien(), "dd/MM/yyyy HH:mm");
            phieuDatPhongChiTietBinding.etThoigiantraPhieudatphong.setText(String.valueOf(thoiGianTraPhong));
        }
    }

    private void LayLoaiPhong() {
        //lấy danh sách loại phòng
        loaiPhongDTOList = new ArrayList<>();
        loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();

        //hiện loại phòng
        rcv_LoaiPhong = phieuDatPhongChiTietBinding.rscvDsloaiphong;
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        rcv_LoaiPhong.setLayoutManager(LinearLayoutManager);
    }

    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> lsLoaiPhong) {
        loaiPhongDTOList = lsLoaiPhong;
        loaiPhongAdapter = new LoaiPhongAdapter(this);
        loaiPhongAdapter.setData(this, loaiPhongDTOList);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_LoaiPhong.addItemDecoration(decoration);
        rcv_LoaiPhong.setAdapter(loaiPhongAdapter);

        //  Toast.makeText(this, "lấy loại phòng thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLayLoaiPhongError(String error) {

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
}