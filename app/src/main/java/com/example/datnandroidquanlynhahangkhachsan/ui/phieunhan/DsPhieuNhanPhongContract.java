package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;

import java.util.List;

public interface DsPhieuNhanPhongContract {
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

        void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO);

        void ThemPhieuDatPhong(PhieuDatDTO phieuDatDTO);
    }
}
