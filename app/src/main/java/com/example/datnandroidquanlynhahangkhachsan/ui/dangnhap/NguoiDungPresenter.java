package com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;

import com.example.datnandroidquanlynhahangkhachsan.model.KhachHang.IKhachHangModel;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    @Override
    public void CapNhatNguoiDung(NguoiDungDTO NguoiDungDTO) {
        nguoiDungModel.CapNhatNguoiDung(NguoiDungDTO, new INguoiDungModel.IOnCapNhatNguoiDungFinishedListener() {
            @Override
            public void onSuccess() {
                view.onCapNhatNguoiDungSuccess();
            }

            @Override
            public void onError(String error) {
                view.onCapNhatNguoiDungError(error);
            }
        });
    }

    @Override
    public void ThemNguoiDung(NguoiDungDTO nguoiDungDTO) {
        nguoiDungModel.themNguoiDung(nguoiDungDTO, new INguoiDungModel.IOnThemNguoiDungFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemNguoiDungSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemNguoiDungError(error);
            }
        });
    }

}
