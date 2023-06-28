package com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu;

import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;

import java.util.List;

public interface PhieuThuContract {
    interface View{
        void onLayDanhSachPhieuThuSuccess(List<PhieuThuDTO> list);

        void onLayDanhSachPhieuThuError(String error);

        //thêm phiếu đặt phòng
        void onThemPhieuThuSuccess();

        void onThemPhieuThuError(String error);
    }
    interface Presenter
    {
        void LayDanhSachPhieuThu();
        void ThemPhieuThu(PhieuThuDTO phieuThuDTO);
    }
}
