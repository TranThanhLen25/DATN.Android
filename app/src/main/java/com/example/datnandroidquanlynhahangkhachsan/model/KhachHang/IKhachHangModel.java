package com.example.datnandroidquanlynhahangkhachsan.model.KhachHang;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;

import java.util.List;

public interface IKhachHangModel {
    void themKhachHang(KhachHangDTO khachHangDTO, IOnThemKhachHangFinishedListener listener);

    interface IOnThemKhachHangFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
