package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;

import java.util.List;


public interface PhieuNhanPhongChiTietContract {

    interface View {
            void onCapNhatPhieuNhanPhongChiTietSuccess();

            void onCapNhatPhieuNhanPhongChiTietError(String error);

            void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list);

            void onLayDanhSachPhieuNhanPhongChiTietError(String error);

    }
    interface Presenter {
        void CapNhatPhieuNhanPhongChiTiet(PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO);
        void LayDanhSachPhieuNhanPhongChiTiet(DieuKienLocPhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO);
    }
}
