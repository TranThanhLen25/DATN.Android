package com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat;


import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhieuXuatChiTietModel implements IPhieuXuatChiTietModel {
    APIService service;
    private ErrorMessageDTO errorKiemTra;



    @Override
    public void CapNhatPhieuXuatChiTiet(PhieuXuatChiTietDTO phieuXuatChiTietDTO, IOnCapNhatPhieuXuatChiTietFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.capNhatPhieuXuatChiTiet(phieuXuatChiTietDTO).enqueue(new Callback<ResponseInfo>() {
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
