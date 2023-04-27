package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.IPhieuXuatChiTietModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.PhieuXuatChiTietModel;

public class PhieuXuatChiTietPresenter implements PhieuXuatChiTietContract.Presenter{
    private final PhieuXuatChiTietContract.View view;
    PhieuXuatChiTietModel phieuXuatChiTietModel;

    public PhieuXuatChiTietPresenter(PhieuXuatChiTietContract.View view) {
        this.view = view;
        this.phieuXuatChiTietModel = new PhieuXuatChiTietModel();
    }
    @Override
    public void CapNhatPhieuXuatChiTiet(PhieuXuatChiTietDTO phieuXuatChiTietDTO) {
        phieuXuatChiTietModel.CapNhatPhieuXuatChiTiet(phieuXuatChiTietDTO, new IPhieuXuatChiTietModel.IOnCapNhatPhieuXuatChiTietFinishedListener() {
            @Override
            public void onSuccess() {
                view.onCapNhatPhieuXuatChiTietSuccess();
            }

            @Override
            public void onError(String error) {
                view.onCapNhatPhieuXuatChiTietError(error);
            }
        });
    }
}
