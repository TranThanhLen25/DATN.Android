package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;


import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.IPhieuNhanModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.PhieuNhanModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.IPhieuXuatModel;

import java.util.List;

public class DsPhieuNhanPhongPresenter implements DsPhieuNhanPhongContract.Presenter {
    private final DsPhieuNhanPhongContract.View view;
    PhieuNhanModel phieuNhanModel;

    public DsPhieuNhanPhongPresenter(DsPhieuNhanPhongContract.View view) {
        this.view = view;
        this.phieuNhanModel = new PhieuNhanModel();
    }


    @Override
    public void LayDanhSachPhieuNhan(DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO) {
        phieuNhanModel.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO, new IPhieuNhanModel.IOnLayDanhSachPhieuNhanFinishedListener() {
            @Override
            public void onSuccess(List<PhieuNhanDTO> listResult) {
                view.onLayDanhSachPhieuNhanSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhieuNhanError(error);
            }
        });
    }

    @Override
    public void ThemPhieuNhanPhong(NhanPhongDTO nhanPhongDTO) {
        phieuNhanModel.ThemPhieuNhanPhong(nhanPhongDTO, new IPhieuNhanModel.IOnThemPhieuNhanPhongFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemPhieuNhanPhongSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemPhieuNhanPhongError(error);
            }
        });
    }

    @Override
    public void ThemPhieuNhanBan(NhanBanDTO nhanBanDTO) {
        phieuNhanModel.ThemPhieuNhanBan(nhanBanDTO, new IPhieuNhanModel.IOnThemPhieuNhanBanFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemPhieuNhanBanSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemPhieuNhanBanError(error);
            }
        });
    }

    @Override
    public void CapNhatPhieuNhan(PhieuNhanDTO phieuNhanDTO) {
        phieuNhanModel.CapNhatPhieuNhan(phieuNhanDTO, new IPhieuNhanModel.IOnCapNhatPhieuNhanFinishedListener() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(String error) {

            }
        });
    }
}
