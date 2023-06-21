package com.example.datnandroidquanlynhahangkhachsan.model.phieunhan;


import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;

import java.util.List;

public interface IPhieuNhanPhongChiTietModel {
    void CapNhatPhieuNhanPhongChiTiet(PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO, IPhieuNhanPhongChiTietModel.IOnCapNhatPhieuNhanPhongChiTietFinishedListener listener);

    interface IOnCapNhatPhieuNhanPhongChiTietFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void LayDanhSachPhieuNhanPhongChiTiet(DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTiet, IPhieuNhanPhongChiTietModel.IOnLayDanhSachPhieuNhanPhongChiTietFinishedListener listener);

    interface IOnLayDanhSachPhieuNhanPhongChiTietFinishedListener {
        void onSuccess(List<PhieuNhanPhongChiTietDTO> listResult);

        void onError(String error);
    }

    void LayDanhSachPhieuNhanBanChiTiet(DieuKienLocPhieuNhanBanChiTietDTO dieuKienLocPhieuNhanBanChiTiet, IPhieuNhanPhongChiTietModel.IOnLayDanhSachPhieuNhanBanChiTietFinishedListener listener);

    interface IOnLayDanhSachPhieuNhanBanChiTietFinishedListener {
        void onSuccess(List<PhieuNhanBanChiTietDTO> listResult);

        void onError(String error);
    }

    void CapNhatPhieuNhanBanChiTiet(PhieuNhanBanChiTietDTO phieuNhanBanChiTietDTO, IPhieuNhanPhongChiTietModel.IOnCapNhatPhieuNhanBanChiTietFinishedListener listener);

    interface IOnCapNhatPhieuNhanBanChiTietFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
