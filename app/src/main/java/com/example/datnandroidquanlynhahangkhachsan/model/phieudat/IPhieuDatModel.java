package com.example.datnandroidquanlynhahangkhachsan.model.phieudat;

import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuDatDTO;

import java.util.List;

public interface IPhieuDatModel {
    void LayDanhSachPhieuDat(int LoaiPhieu, IPhieuDatModel.IOnLayDanhSachPhieuDatFinishedListener listener);

    interface IOnLayDanhSachPhieuDatFinishedListener {
        void onSuccess(List<PhieuDatDTO> listResult);

        void onError(String error);
    }

    void ThemPhieuDatPhong(PhieuDatDTO phieuDatDTO, IPhieuDatModel.IOnThemPhieuDatPhongFinishedListener listener);

    interface IOnThemPhieuDatPhongFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
