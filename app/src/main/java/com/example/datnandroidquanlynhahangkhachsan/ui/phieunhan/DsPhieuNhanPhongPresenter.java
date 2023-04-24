package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;


import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.PhieuNhanModel;
import com.example.Nhannandroidquanlynhahangkhachsan.model.phieunhan.IPhieuNhanModel;

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

//    @Override
//    public void ThemPhieuDatPhong(PhieuDatDTO phieuDatDTO) {
//        phieuDatModel.ThemPhieuDatPhong(phieuDatDTO, new IPhieuDatModel.IOnThemPhieuDatPhongFinishedListener() {
//            @Override
//            public void onSuccess() {
//                view.onThemPhieuDatPhongSuccess();
//            }
//
//            @Override
//            public void onError(String error) {
//                view.onThemPhieuDatPhongError(error);
//            }
//        });
//    }
}
