package com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;

public interface KhachHangContract {
    interface View {
        void onThemKhachHangSuccess();

        void onThemKhachHangError(String error);
    }

    interface Presenter {
        void ThemKhachHang(KhachHangDTO khachHangDTO);
    }
}
