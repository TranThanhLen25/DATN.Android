package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;


import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.XuatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;

import java.util.List;

public interface PhieuXuatConTract {
    interface View {
        void onThemPhieuXuatSuccess();

        void onThemPhieuXuatError(String error);

        void onThemPhieuXuatChiTietSuccess();

        void onThemPhieuXuatChiTietError(String error);


        void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list);

        void onLayDanhSachPhieuXuatError(String error);

        void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list);

        void onLayDanhSachPhieuXuatChiTietError(String error);

        void onCapNhatPXSuccess();

        void onCapNhatPXError(String error);


    }

    interface Presenter {
        void ThemPhieuXuat(XuatPhongDTO xuatPhongDTO);

        void ThemPhieuXuatChiTiet(PhieuXuatChiTietDTO phieuXuatChiTietDTO);
        void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO);

        void LayDanhSachPhieuXuatChiTiet(DieuKienLocPhieuXuatChiTietDTO dieuKienLocPhieuXuatChiTietDTO);

        void  CapNhatPX(PhieuXuatDTO phieuXuatDTO);


    }
}
