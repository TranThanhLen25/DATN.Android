package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;

import java.util.List;

public interface DsPhieuNhanPhongContract {
    interface View {
        //lấy danh sách phiếu nhận phòng
        void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list);

        void onLayDanhSachPhieuNhanError(String error);

        //thêm phiếu đặt phòng
        void onThemPhieuNhanPhongSuccess();

        void onThemPhieuNhanPhongError(String error);

        //thêm phiếu nhận bàn
        void onThemPhieuNhanBanSuccess();

        void onThemPhieuNhanBanError(String error);
    }

    interface Presenter {

        void LayDanhSachPhieuNhan(DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO);

        void ThemPhieuNhanPhong(NhanPhongDTO nhanPhongDTO);

        void ThemPhieuNhanBan(NhanBanDTO nhanBanDTO);
    }
}
