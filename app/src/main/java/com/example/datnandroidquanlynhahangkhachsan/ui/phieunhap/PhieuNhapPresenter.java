//package com.example.Nhapnandroidquanlynhahangkhachsan.ui.phieunhap;
//import com.example.Nhapnandroidquanlynhahangkhachsan.ui.phieunhap.PhieuNhapContract;
//import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapChiTietDTO;
//import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapDTO;
//
//
//import java.util.List;
//
//public class PhieuNhapPresenter implements PhieuNhapContract.Presenter {
//    private final PhieuNhapContract.View view;
//    PhieuNhapModel phieuNhapModel;
//
//    public PhieuNhapPresenter(PhieuNhapContract.View view) {
//        this.view = view;
//        this.phieuNhapModel = new PhieuNhapModel();
//    }
//
//
////    @Override
////    public void LayDanhSachPhieuNhap(DieuKienLocPhieuNhapDTO dieuKienLocPhieuNhapDTO) {
////        phieuNhapModel.LayDanhSachPhieuNhap(dieuKienLocPhieuNhapDTO, new IPhieuNhapModel.IOnLayDanhSachPhieuNhapFinishedListener() {
////            @Override
////            public void onSuccess(List<PhieuNhapDTO> listResult) {
////                view.onLayDanhSachPhieuNhapSuccess(listResult);
////            }
////
////            @Override
////            public void onError(String error) {
////                view.onLayDanhSachPhieuNhapError(error);
////            }
////        });
////    }
//
//    @Override
//    public void ThemPhieuNhap(PhieuNhapDTO phieuNhapDTO) {
//        phieuNhapModel.ThemPhieuNhap(phieuNhapDTO, new IPhieuNhapModel.IOnThemPhieuNhapFinishedListener() {
//            @Override
//            public void onSuccess() {
//                view.onThemPhieuNhapSuccess();
//            }
//
//            @Override
//            public void onError(String error) {
//                view.onThemPhieuNhapError(error);
//            }
//        });
//    }
//
//    @Override
//    public void ThemPhieuNhapChiTiet(PhieuNhapChiTietDTO phieuNhapChiTietDTO) {
//        phieuNhapModel.ThemPhieuNhapChiTiet(phieuNhapChiTietDTO, new IPhieuNhapModel.IOnThemPhieuNhapChiTietFinishedListener() {
//            @Override
//            public void onSuccess() {
//                view.onThemPhieuNhapChiTietSuccess();
//            }
//
//            @Override
//            public void onError(String error) {
//                view.onThemPhieuNhapChiTietError(error);
//            }
//        });
//    }
//}
