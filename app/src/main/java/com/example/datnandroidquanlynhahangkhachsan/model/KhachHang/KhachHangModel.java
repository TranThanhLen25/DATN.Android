package com.example.datnandroidquanlynhahangkhachsan.model.KhachHang;

import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KhachHangModel implements IKhachHangModel {
    APIService service;
    ErrorMessageDTO errorKiemTra;
    @Override
    public void themKhachHang(KhachHangDTO khachHangDTO, IOnThemKhachHangFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.themKhachHang(khachHangDTO).enqueue(new Callback<ResponseInfo>() {
                    @Override
                    public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
                        if (response.body() != null) {
                            listener.onSuccess();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseInfo> call, Throwable t) {
                        listener.onError(t.getMessage());
                    }
                });
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }
        });
    }

@Override
    public void LayDanhSachKhachHang(DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO, IKhachHangModel.IOnLayDanhSachKhachHangFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO token) {
                //Lay token thanh cong => goi api lay du lieu

                service.apiServiceRetrofit.layDanhSachKhachHang(dieuKienLocKhachHangDTO).enqueue(new Callback<ResponseDTO<List<KhachHangDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<KhachHangDTO>>> call, Response<ResponseDTO<List<KhachHangDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getNhana() de lay ra du lieu o truong Nhana
                        List<KhachHangDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<KhachHangDTO>>> call, Throwable t) {
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
