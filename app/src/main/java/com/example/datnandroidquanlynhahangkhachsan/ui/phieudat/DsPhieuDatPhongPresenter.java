package com.example.datnandroidquanlynhahangkhachsan.ui.phieudat;

import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.hanghoa.IHangHoaModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieudat.IPhieuDatModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieudat.PhieuDatModel;

import java.util.List;

public class DsPhieuDatPhongPresenter implements DsPhieuDatPhongContract.Presenter {
    private final DsPhieuDatPhongContract.View view;
    PhieuDatModel phieuDatModel;

    public DsPhieuDatPhongPresenter(DsPhieuDatPhongContract.View view) {
        this.view = view;
        this.phieuDatModel = new PhieuDatModel();
    }


    @Override
    public void LayDanhSachPhieuDat(int LoaiPhieu) {
        phieuDatModel.LayDanhSachPhieuDat(LoaiPhieu, new IPhieuDatModel.IOnLayDanhSachPhieuDatFinishedListener() {
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
