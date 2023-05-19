package com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat;



import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.KhachHang.IKhachHangModel;

import java.util.List;

public interface IPhieuXuatModel {
    void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO, IPhieuXuatModel.IOnLayDanhSachPhieuXuatFinishedListener listener);

    interface IOnLayDanhSachPhieuXuatFinishedListener {
        void onSuccess(List<PhieuXuatDTO> listResult);

        void onError(String error);
    }


    void ThemPhieuXuat(PhieuXuatDTO phieuXuatDTO, IOnThemPhieuXuatFinishedListener listener);
    interface IOnThemPhieuXuatFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void LayDanhSachPhieuXuatChiTiet(DieuKienLocPhieuXuatChiTietDTO dieuKienLocPhieuXuatChiTietDTO, IPhieuXuatModel.IOnLayDanhSachPhieuXuatChiTietFinishedListener listener);

    interface IOnLayDanhSachPhieuXuatChiTietFinishedListener {
        void onSuccess(List<PhieuXuatChiTietDTO> listResult);

        void onError(String error);
    }
}
