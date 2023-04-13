package com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;

import java.util.List;

public class NguoiDungPresenter implements NguoiDungContract.Presenter {
    private final NguoiDungContract.View view;
    private NguoiDungModel nguoiDungModel;

    public NguoiDungPresenter(NguoiDungContract.View view) {
        this.view = view;
        this.nguoiDungModel = new NguoiDungModel();
    }

    @Override
    public void LayNguoiDung() {
        nguoiDungModel.LayNguoiDung(new INguoiDungModel.IOnLayNguoiDungFinishedListener() {
            @Override
            public void onSuccess(List<NguoiDungDTO> listResult) {
                view.onLayNguoiDungSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayNguoiDungError(error);
            }
        });
    }
}
