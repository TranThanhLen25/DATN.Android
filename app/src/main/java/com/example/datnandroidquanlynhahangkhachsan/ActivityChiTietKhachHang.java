package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChiTietKhachHangBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

public class ActivityChiTietKhachHang extends AppCompatActivity {
    private ActivityChiTietKhachHangBinding activityChiTietKhachHangBinding;
    private AppUtils appUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityChiTietKhachHangBinding = ActivityChiTietKhachHangBinding.inflate(getLayoutInflater());
        setContentView(activityChiTietKhachHangBinding.getRoot());
        activityChiTietKhachHangBinding.tvSctPnct.setText(tempData.tempDatakhachHangDTO.getTenKhachHang());
        activityChiTietKhachHangBinding.tvHotenPnct.setText(tempData.tempDatakhachHangDTO.getSdt());
        activityChiTietKhachHangBinding.tvCccdPnct.setText(tempData.tempDatakhachHangDTO.getCccd());

        if (tempData.tempDatakhachHangDTO.getNoiThuongTru()!=null){
            activityChiTietKhachHangBinding.tvSdtPnct.setText(tempData.tempDatakhachHangDTO.getNoiThuongTru());
        }
        if (tempData.tempDatakhachHangDTO.getGioiTinh()!=null){
            activityChiTietKhachHangBinding.tvNgaynhanPnct.setText(tempData.tempDatakhachHangDTO.getGioiTinh());
        }
        if (tempData.tempDatakhachHangDTO.getNgaySinh()!=null){
            String NgaySinh = appUtils.formatDateToString(tempData.tempDatakhachHangDTO.getNgaySinh(), "dd/MM/yyyy");
            activityChiTietKhachHangBinding.tvNgaysinhdata.setText(NgaySinh);
        }
        activityChiTietKhachHangBinding.toolbarPnct.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.tempDatakhachHangDTO=new KhachHangDTO();
                onBackPressed();
            }
        });
    }
}