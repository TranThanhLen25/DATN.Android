package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;


import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.XuatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu.IDichVuModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.IPhieuXuatModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.PhieuXuatModel;

import java.util.List;

public class PhieuXuatPresenter implements PhieuXuatConTract.Presenter{
    private final PhieuXuatConTract.View view;
    PhieuXuatModel phieuXuatModel;

    public PhieuXuatPresenter(PhieuXuatConTract.View view) {
        this.view = view;
        this.phieuXuatModel = new PhieuXuatModel();
    }


    @Override
    public void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO) {
        phieuXuatModel.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO, new IPhieuXuatModel.IOnLayDanhSachPhieuXuatFinishedListener() {
            @Override
            public void onSuccess(List<PhieuXuatDTO> listResult) {
                view.onLayDanhSachPhieuXuatSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhieuXuatError(error);
            }
        });
    }

    @Override
    public void LayDanhSachPhieuXuatChiTiet(DieuKienLocPhieuXuatChiTietDTO dieuKienLocPhieuXuatChiTietDTO) {
        phieuXuatModel.LayDanhSachPhieuXuatChiTiet(dieuKienLocPhieuXuatChiTietDTO, new IPhieuXuatModel.IOnLayDanhSachPhieuXuatChiTietFinishedListener() {
            @Override
            public void onSuccess(List<PhieuXuatChiTietDTO> listResult) {
                view.onLayDanhSachPhieuXuatChiTietSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhieuXuatChiTietError(error);
            }
        });
    }

    @Override
    public void ThemPhieuXuat(XuatPhongDTO xuatPhongDTO) {
        phieuXuatModel.ThemPhieuXuat(xuatPhongDTO, new IPhieuXuatModel.IOnThemPhieuXuatFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemPhieuXuatSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemPhieuXuatError(error);
            }
        });
    }

    @Override
    public void ThemPhieuXuatChiTiet(PhieuXuatChiTietDTO phieuXuatChiTietDTO) {
        phieuXuatModel.ThemPhieuXuatChiTiet(phieuXuatChiTietDTO, new IPhieuXuatModel.IOnThemPhieuXuatChiTietFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemPhieuXuatChiTietSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemPhieuXuatChiTietError(error);
            }
        });
    }
    @Override
    public void CapNhatPX(PhieuXuatDTO phieuXuatDTO) {
        phieuXuatModel.CapNhatPX(phieuXuatDTO, new IPhieuXuatModel.IOnCapNhatPXFinishedListener() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(String error) {

            }
        });
    }

}
