package com.example.datnandroidquanlynhahangkhachsan.model.phieunhan;

import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;

import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;
import com.example.Nhannandroidquanlynhahangkhachsan.model.phieunhan.IPhieuNhanModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhieuNhanModel implements IPhieuNhanModel {
    APIService service;
    private ErrorMessageDTO errorKiemTra;

    @Override
    public void LayDanhSachPhieuNhan(DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO, IOnLayDanhSachPhieuNhanFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO token) {
                //Lay token thanh cong => goi api lay du lieu

                service.apiServiceRetrofit.layDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO).enqueue(new Callback<ResponseDTO<List<PhieuNhanDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<PhieuNhanDTO>>> call, Response<ResponseDTO<List<PhieuNhanDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getNhana() de lay ra du lieu o truong Nhana
                        List<PhieuNhanDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<PhieuNhanDTO>>> call, Throwable t) {
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