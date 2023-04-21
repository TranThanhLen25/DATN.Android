//package com.example.Nhapnandroidquanlynhahangkhachsan.ui.phieunhap;
//
//
//import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapChiTietDTO;
//import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapDTO;
//
//import java.util.List;
//
//public interface PhieuNhapContract {
//    interface View {
//        //lấy danh sách phiếu đặt phòng
//        void onLayDanhSachPhieuNhapSuccess(List<PhieuNhapDTO> list);
//
//        void onLayDanhSachPhieuNhapError(String error);
//
//        //thêm phiếu đặt phòng
//        void onThemPhieuNhapPhongSuccess();
//
//        void onThemPhieuNhapPhongError(String error);
//
//        //thêm phiếu đặt phòng chi tiết
//        void onThemPhieuNhapPhongChiTietSuccess();
//
//        void onThemPhieuNhapPhongChiTietError(String error);
//    }
//
//    interface Presenter {
//        //void LayDanhSachPhieuNhap(DieuKienLocPhieuNhapDTO dieuKienLoc);
//
////        void LayDanhSachPhieuNhap(DieuKienLocPhieuNhapDTO dieuKienLocPhieuNhapDTO);
//
//        void ThemPhieuNhap(PhieuNhapDTO phieuNhapDTO);
//
//        void ThemPhieuNhapChiTiet(PhieuNhapChiTietDTO phieuNhapPhongChiTietDTO);
//    }
//}
