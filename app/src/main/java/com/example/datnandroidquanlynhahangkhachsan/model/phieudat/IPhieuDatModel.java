package com.example.datnandroidquanlynhahangkhachsan.model.phieudat;

import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;

import java.util.List;

public interface IPhieuDatModel {
    void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO, IPhieuDatModel.IOnLayDanhSachPhieuDatFinishedListener listener);

    interface IOnLayDanhSachPhieuDatFinishedListener {
        void onSuccess(List<PhieuDatDTO> listResult);

        void onError(String error);
    }

    void ThemPhieuDatPhong(DatPhongDTO datPhongDTO, IPhieuDatModel.IOnThemPhieuDatPhongFinishedListener listener);

    interface IOnThemPhieuDatPhongFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void ThemPhieuDatPhongChiTiet(PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO, IPhieuDatModel.IOnThemPhieuDatPhongChiTietFinishedListener listener);

    interface IOnThemPhieuDatPhongChiTietFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
