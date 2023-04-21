package com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;

import java.util.List;

public class NguoiDungPresenter implements NguoiDungContract.Presenter {
    private final NguoiDungContract.View view;
    NguoiDungModel nguoiDungModel;

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
    @Override
    public void LayNguoiDungID(int nguoiDung) {
        nguoiDungModel.LayNguoiDungID(nguoiDung,new INguoiDungModel.IOnLayNguoiDungIDFinishedListener() {
            @Override
            public void onSuccess(List<NguoiDungDTO> listResult) {
                view.onLayNguoiDungIDSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayNguoiDungIDError(error);
            }
        });
    }
}
