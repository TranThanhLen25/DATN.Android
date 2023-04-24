package com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;


import com.example.datnandroidquanlynhahangkhachsan.model.KhachHang.IKhachHangModel;
import com.example.datnandroidquanlynhahangkhachsan.model.KhachHang.KhachHangModel;


import java.util.List;

public class KhachHangPresenter implements KhachHangContract.Presenter {
    private final KhachHangContract.View view;
    KhachHangModel khachHangModel;

    public KhachHangPresenter(KhachHangContract.View view) {
        this.view = view;
        this.khachHangModel = new KhachHangModel();
    }

    @Override
    public void ThemKhachHang(KhachHangDTO khachHangDTO) {
        khachHangModel.themKhachHang(khachHangDTO, new IKhachHangModel.IOnThemKhachHangFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemKhachHangSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemKhachHangError(error);
            }
        });
    }

    @Override
    public void LayDanhSachKhachHang(DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO) {
        khachHangModel.LayDanhSachKhachHang(dieuKienLocKhachHangDTO, new IKhachHangModel.IOnLayDanhSachKhachHangFinishedListener() {
            @Override
            public void onSuccess(List<KhachHangDTO> listResult) {
                view.onLayDanhSachKhachHangSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachKhachHangError(error);
            }
        });
    }
}
