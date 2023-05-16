package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;


import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;

import java.util.List;

public interface PhieuXuatConTract {
    interface View {
        void onThemPhieuXuatSuccess();

        void onThemPhieuXuatError(String error);

        void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list);

        void onLayDanhSachPhieuXuatError(String error);


    }

    interface Presenter {
        void ThemPhieuXuat(PhieuXuatDTO PhieuXuatDTO);

        void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO);

    }
}
