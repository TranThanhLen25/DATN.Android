package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;

public interface PhieuXuatChiTietContract {

    interface View {
        void onCapNhatPhieuXuatChiTietSuccess();

        void onCapNhatPhieuXuatChiTietError(String error);

    }
    interface Presenter {
        void CapNhatPhieuXuatChiTiet(PhieuXuatChiTietDTO phieuXuatChiTietDTO);
    }
}
