package com.example.datnandroidquanlynhahangkhachsan.ui.goiMon;

import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
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
}
