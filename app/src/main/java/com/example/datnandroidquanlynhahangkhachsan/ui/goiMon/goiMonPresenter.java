package com.example.datnandroidquanlynhahangkhachsan.ui.goiMon;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.ListGoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu.IDichVuModel;
import com.example.datnandroidquanlynhahangkhachsan.model.goiMon.GoiMonModel;
import com.example.datnandroidquanlynhahangkhachsan.model.goiMon.IGoiMonModel;

import java.util.List;

public class goiMonPresenter implements goiMonContract.Presenter {
    private final goiMonContract.View view;
    GoiMonModel goiMonModel;

    public goiMonPresenter(goiMonContract.View view) {
        this.view = view;
        this.goiMonModel = new GoiMonModel();
    }

    @Override
    public void LayDanhSachGoiMon(GoiMonDTO goiMonDTO) {
        goiMonModel.LayDanhSachGoiMon(goiMonDTO, new IGoiMonModel.IOnLayDanhSachGoiMonFinishedListener() {
            @Override
            public void onSuccess(List<GoiMonDTO> listResult) {
                view.onLayDanhSachGoiMonSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachGoiMonError(error);
            }
        });
    }

    @Override
    public void CapNhatGoiMon(ListGoiMonDTO listGoiMonDTO) {
        goiMonModel.capNhatGoiMon(listGoiMonDTO, new IGoiMonModel.IOncapNhatDichVuFinishedListener() {
            @Override
            public void onSuccess() {
                view.onCapNhatGoiMonSuccess();
            }

            @Override
            public void onError(String error) {
                view.onCapNhatGoiMonError(error);
            }
        });
    }

    @Override
    public void CapNhatGM(GoiMonDTO goiMonDTO) {
        goiMonModel.CapNhatGM(goiMonDTO, new IGoiMonModel.IOnCapNhatGMFinishedListener() {
            @Override
            public void onSuccess() {
                view.onCapNhatGMSuccess();
            }

            @Override
            public void onError(String error) {
                view.onCapNhatGMError(error);
            }
        });
    }
}
