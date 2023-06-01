package com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat;


import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.XuatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;

import java.util.List;

public interface IPhieuXuatModel {
    void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO, IPhieuXuatModel.IOnLayDanhSachPhieuXuatFinishedListener listener);

    interface IOnLayDanhSachPhieuXuatFinishedListener {
        void onSuccess(List<PhieuXuatDTO> listResult);

        void onError(String error);
    }


    void ThemPhieuXuat(XuatPhongDTO xuatPhongDTO, IOnThemPhieuXuatFinishedListener listener);

    interface IOnThemPhieuXuatFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void ThemPhieuXuatChiTiet(PhieuXuatChiTietDTO phieuXuatChiTietDTO, IOnThemPhieuXuatChiTietFinishedListener listener);

    interface IOnThemPhieuXuatChiTietFinishedListener {
        void onSuccess();

        void onError(String error);
    }


    void LayDanhSachPhieuXuatChiTiet(DieuKienLocPhieuXuatChiTietDTO dieuKienLocPhieuXuatChiTietDTO, IPhieuXuatModel.IOnLayDanhSachPhieuXuatChiTietFinishedListener listener);

    interface IOnLayDanhSachPhieuXuatChiTietFinishedListener {
        void onSuccess(List<PhieuXuatChiTietDTO> listResult);

        void onError(String error);
    }





}
