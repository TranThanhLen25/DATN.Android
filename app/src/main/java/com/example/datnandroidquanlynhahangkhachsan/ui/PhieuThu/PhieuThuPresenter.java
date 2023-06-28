package com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu;

import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuThu.IPhieuThuModel;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuThu.PhieuThuModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.IPhieuNhanModel;

import java.util.List;

public class PhieuThuPresenter implements PhieuThuContract.Presenter {

    private final PhieuThuContract.View view;
    PhieuThuModel phieuThuModel;

    public PhieuThuPresenter(PhieuThuContract.View view) {
        this.view = view;
        this.phieuThuModel = new PhieuThuModel();
    }

    @Override
    public void LayDanhSachPhieuThu() {
        phieuThuModel.LayDanhSachPhieuThu(new IPhieuThuModel.IOnLayDanhSachPhieuThuFinishedListener() {
            @Override
            public void onSuccess(List<PhieuThuDTO> listResult) {
                view.onLayDanhSachPhieuThuSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhieuThuError(error);
            }
        });
    }

    @Override
    public void ThemPhieuThu(PhieuThuDTO phieuThuDTO) {
        phieuThuModel.ThemPhieuThu(phieuThuDTO, new IPhieuThuModel.IOnThemPhieuThuFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemPhieuThuSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemPhieuThuError(error);
            }
        });
    }


}
