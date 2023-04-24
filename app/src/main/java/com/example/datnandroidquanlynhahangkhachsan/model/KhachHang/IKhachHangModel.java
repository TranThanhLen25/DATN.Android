package com.example.datnandroidquanlynhahangkhachsan.model.KhachHang;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;


import java.util.List;

public interface IKhachHangModel {
    void themKhachHang(KhachHangDTO khachHangDTO, IOnThemKhachHangFinishedListener listener);

    interface IOnThemKhachHangFinishedListener {
        void onSuccess();

        void onError(String error);
    }
    void LayDanhSachKhachHang(DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO, IKhachHangModel.IOnLayDanhSachKhachHangFinishedListener listener);

    interface IOnLayDanhSachKhachHangFinishedListener {
        void onSuccess(List<KhachHangDTO> listResult);

        void onError(String error);
    }
}
