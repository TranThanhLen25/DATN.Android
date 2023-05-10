package com.example.datnandroidquanlynhahangkhachsan.ui.phieudat;

import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;

import java.util.List;

public interface DsPhieuDatPhongContract {
    interface View {
        //lấy danh sách phiếu đặt phòng
        void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list);

        void onLayDanhSachPhieuDatError(String error);

        //thêm phiếu đặt phòng
        void onThemPhieuDatPhongSuccess();

        void onThemPhieuDatPhongError(String error);

        //thêm phiếu đặt phòng chi tiết
        void onThemPhieuDatPhongChiTietSuccess();

        void onThemPhieuDatPhongChiTietError(String error);
    }

    interface Presenter {
        //void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLoc);

        void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO);

        void ThemPhieuDatPhong(DatPhongDTO datPhongDTO);

        void ThemPhieuDatPhongChiTiet(PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO);
    }
}
