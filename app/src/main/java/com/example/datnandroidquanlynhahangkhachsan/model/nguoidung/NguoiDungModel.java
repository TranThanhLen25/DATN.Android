package com.example.datnandroidquanlynhahangkhachsan.model.nguoidung;

import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;
import com.example.datnandroidquanlynhahangkhachsan.model.phong.IPhongModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NguoiDungModel implements INguoiDungModel {
    APIService service;
    private ErrorMessageDTO errorKiemTra;
    @Override
    public void CapNhatNguoiDung(NguoiDungDTO nguoiDungDTO, IPhongModel.IOnCapNhatNguoiDungFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.capNhatNguoiDung(nguoiDungDTO).enqueue(new Callback<ResponseInfo>() {
                    @Override
                    public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseInfo> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onError(String error) {

            }
        });
    }
}
