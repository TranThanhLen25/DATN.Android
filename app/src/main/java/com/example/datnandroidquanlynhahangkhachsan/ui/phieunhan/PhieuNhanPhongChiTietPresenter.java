package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;


import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.IPhieuNhanPhongChiTietModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.PhieuNhanPhongChiTietModel;

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

        @Override
        public void LayDanhSachPhieuNhanBanChiTiet(DieuKienLocPhieuNhanBanChiTietDTO phieuNhanBanChiTietDTO) {
            phieuNhanPhongChiTietModel.LayDanhSachPhieuNhanBanChiTiet(phieuNhanBanChiTietDTO, new IPhieuNhanPhongChiTietModel.IOnLayDanhSachPhieuNhanBanChiTietFinishedListener() {
                @Override
                public void onSuccess(List<PhieuNhanBanChiTietDTO> listResult) {
                    view.onLayDanhSachPhieuNhanBanChiTietSuccess(listResult);
                }

                @Override
                public void onError(String error) {
                    view.onLayDanhSachPhieuNhanBanChiTietError(error);
                }
            });
        }

    @Override
    public void CapNhatPhieuNhanBanChiTiet(PhieuNhanBanChiTietDTO phieuNhanBanChiTietDTO) {
        phieuNhanPhongChiTietModel.CapNhatPhieuNhanBanChiTiet(phieuNhanBanChiTietDTO, new IPhieuNhanPhongChiTietModel.IOnCapNhatPhieuNhanBanChiTietFinishedListener() {
            @Override
            public void onSuccess() {
                view.onCapNhatPhieuNhanBanChiTietSuccess();
            }

            @Override
            public void onError(String error) {
                view.onCapNhatPhieuNhanBanChiTietError(error);
            }
        });
    }
}
