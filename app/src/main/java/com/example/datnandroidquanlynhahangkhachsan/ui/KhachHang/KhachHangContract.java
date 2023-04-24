package com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;

import java.util.List;

public interface KhachHangContract {
    interface View {
        void onThemKhachHangSuccess();

        void onThemKhachHangError(String error);


        void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list);

        void onLayDanhSachKhachHangError(String error);
    }

    interface Presenter {
        void ThemKhachHang(KhachHangDTO khachHangDTO);

        void LayDanhSachKhachHang(DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO);
    }
}
