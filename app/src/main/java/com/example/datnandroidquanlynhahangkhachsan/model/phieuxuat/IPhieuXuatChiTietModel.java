package com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;

public interface IPhieuXuatChiTietModel {
    void CapNhatPhieuXuatChiTiet(PhieuXuatChiTietDTO phieuXuatChiTietDTO, IPhieuXuatChiTietModel.IOnCapNhatPhieuXuatChiTietFinishedListener listener);

    interface IOnCapNhatPhieuXuatChiTietFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
