package com.example.datnandroidquanlynhahangkhachsan.ui.phieudat;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieudat.IPhieuDatModel;

import java.util.List;

public class DsPhieuDatPhongPresenter implements DsPhieuDatPhongContract.Presenter {
    private final DsPhieuDatPhongContract.View view;
    PhieuDatModel phieuDatModel;

    public DsPhieuDatPhongPresenter(DsPhieuDatPhongContract.View view) {
        this.view = view;
        this.phieuDatModel = new PhieuDatModel();
    }


    @Override
    public void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO) {
        phieuDatModel.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO, new IPhieuDatModel.IOnLayDanhSachPhieuDatFinishedListener() {
            @Override
            public void onSuccess(List<PhieuDatDTO> listResult) {
                view.onLayDanhSachPhieuDatSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhieuDatError(error);
            }
        });
    }

    @Override
    public void ThemPhieuDatPhong(PhieuDatDTO phieuDatDTO) {
        phieuDatModel.ThemPhieuDatPhong(phieuDatDTO, new IPhieuDatModel.IOnThemPhieuDatPhongFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemPhieuDatPhongSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemPhieuDatPhongError(error);
            }
        });
    }

    @Override
    public void ThemPhieuDatPhongChiTiet(PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO) {
        phieuDatModel.ThemPhieuDatPhongChiTiet(phieuDatPhongChiTietDTO, new IPhieuDatModel.IOnThemPhieuDatPhongChiTietFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemPhieuDatPhongChiTietSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemPhieuDatPhongChiTietError(error);
            }
        });
    }
}
