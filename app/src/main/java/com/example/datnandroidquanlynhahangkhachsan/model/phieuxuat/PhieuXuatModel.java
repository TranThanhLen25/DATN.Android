package com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat;


import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;


import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhieuXuatModel implements IPhieuXuatModel{
    APIService service;
    private ErrorMessageDTO errorKiemTra;

    @Override
    public void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO, IOnLayDanhSachPhieuXuatFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO token) {
                //Lay token thanh cong => goi api lay du lieu

                service.apiServiceRetrofit.layPhieuXuat(dieuKienLocPhieuXuatDTO).enqueue(new Callback<ResponseDTO<List<PhieuXuatDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<PhieuXuatDTO>>> call, Response<ResponseDTO<List<PhieuXuatDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getNhana() de lay ra du lieu o truong Nhana
                        List<PhieuXuatDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<PhieuXuatDTO>>> call, Throwable t) {
                        listener.onError(t.getMessage());
                    }
                });
            }

            @Override
            public void onError(String error) {
                //Lay token loi => thong bao loi
                listener.onError(error);
            }
        });
    }

}
