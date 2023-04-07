package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieudat.IPhieuDatModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieudat.PhieuDatModel;

import java.util.List;

public class DsPhieuNhanPhongPresenter implements DsPhieuNhanPhongContract.Presenter {
    private final DsPhieuNhanPhongContract.View view;
    PhieuDatModel phieuDatModel;

    public DsPhieuNhanPhongPresenter(DsPhieuNhanPhongContract.View view) {
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
}
