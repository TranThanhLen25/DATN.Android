package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;

import java.util.List;

public interface DsPhieuNhanPhongContract {
    interface View {
        //lấy danh sách phiếu nhận phòng
        void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list);

        void onLayDanhSachPhieuNhanError(String error);

        //thêm phiếu đặt phòng
//        void onThemPhieuDatPhongSuccess();
//
//        void onThemPhieuDatPhongError(String error);
    }

    interface Presenter {

        void LayDanhSachPhieuNhan(DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO);


//        void ThemPhieuDatPhong(PhieuDatDTO phieuDatDTO);
    }
}
