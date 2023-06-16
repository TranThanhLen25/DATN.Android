package com.example.datnandroidquanlynhahangkhachsan.ui.phieudat;

import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;

import java.util.List;

public interface DsPhieuDatPhongContract {
    interface View {
        // //lấy danh sách phiếu đặt phòng
        void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list);

        void onLayDanhSachPhieuDatError(String error);

        //thêm phiếu đặt phòng
        void onThemPhieuDatPhongSuccess();

        void onThemPhieuDatPhongError(String error);

        //thêm phiếu đặt phòng chi tiết
        void onThemPhieuDatPhongChiTietSuccess();

        void onThemPhieuDatPhongChiTietError(String error);

        //lấy phiếu đặt phòng chi tiết
        void onLayPhieuDatPhongChiTietSuccess(List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOList);

        void onLayPhieuDatPhongChiTietError(String error);



        //thêm phiếu đặt bàn
        void onThemPhieuDatBanSuccess();

        void onThemPhieuDatBanError(String error);

        //lấy phiếu đặt bàn chi tiết
        void onLayPhieuDatBanChiTietSuccess(List<PhieuDatBanChiTietDTO> phieuDatPhongChiTietDTOList);

        void onLayPhieuDatBanChiTietError(String error);

        //cập nhật phiếu đặt
        void onCapNhatPhieuDatSuccess();

        void onCapNhatPhieuDatError(String error);
    }

    interface Presenter {
        //void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLoc);

        void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO);

        void ThemPhieuDatPhong(DatPhongDTO datPhongDTO);

        void ThemPhieuDatPhongChiTiet(PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO);
        void LayPhieuDatPhongChiTiet(PhieuDatDTO phieuDatDTO);

        void ThemPhieuDatBan(DatBanDTO datBanDTO);
        void LayPhieuDatBanChiTiet(PhieuDatDTO phieuDatDTO);
        void CapNhatPhieuDat(PhieuDatDTO phieuDatDTO);
    }
}
