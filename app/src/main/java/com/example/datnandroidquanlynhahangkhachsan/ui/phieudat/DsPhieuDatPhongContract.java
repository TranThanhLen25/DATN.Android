package com.example.datnandroidquanlynhahangkhachsan.ui.phieudat;

import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuDatDTO;

import java.util.List;

public interface DsPhieuDatPhongContract {
    interface View {
        //lấy danh sách phiếu đặt phòng
        void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list);

        void onLayDanhSachPhieuDatError(String error);

        //thêm phiếu đặt phòng
        void onThemPhieuDatPhongSuccess();

        void onThemPhieuDatPhongError(String error);
    }

    interface Presenter {
        //void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLoc);

        void LayDanhSachPhieuDat(int LoaiPhieu);

        void ThemPhieuDatPhong(PhieuDatDTO phieuDatDTO);
    }
}
