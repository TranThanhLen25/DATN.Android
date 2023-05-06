package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;


import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;

import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.IPhieuNhanPhongChiTietModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.PhieuNhanPhongChiTietModel;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;

import java.util.List;

public class PhieuNhanPhongChiTietPresenter implements PhieuNhanPhongChiTietContract.Presenter{
    private final PhieuNhanPhongChiTietContract.View view;
    PhieuNhanPhongChiTietModel phieuNhanPhongChiTietModel;

    public PhieuNhanPhongChiTietPresenter(PhieuNhanPhongChiTietContract.View view) {
        this.view = view;
        this.phieuNhanPhongChiTietModel = new PhieuNhanPhongChiTietModel();
    }
    @Override
    public void CapNhatPhieuNhanPhongChiTiet(PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO) {
        phieuNhanPhongChiTietModel.CapNhatPhieuNhanPhongChiTiet(phieuNhanPhongChiTietDTO, new IPhieuNhanPhongChiTietModel.IOnCapNhatPhieuNhanPhongChiTietFinishedListener() {
            @Override
            public void onSuccess() {
                view.onCapNhatPhieuNhanPhongChiTietSuccess();
            }

            @Override
            public void onError(String error) {
                view.onCapNhatPhieuNhanPhongChiTietError(error);
            }
        });
    }

    @Override
    public void LayDanhSachPhieuNhanPhongChiTiet(DieuKienLocPhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO) {
        phieuNhanPhongChiTietModel.LayDanhSachPhieuNhanPhongChiTiet(phieuNhanPhongChiTietDTO, new IPhieuNhanPhongChiTietModel.IOnLayDanhSachPhieuNhanPhongChiTietFinishedListener() {
            @Override
            public void onSuccess(List<PhieuNhanPhongChiTietDTO> listResult) {
                view.onLayDanhSachPhieuNhanPhongChiTietSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhieuNhanPhongChiTietError(error);
            }
        });
    }
}
