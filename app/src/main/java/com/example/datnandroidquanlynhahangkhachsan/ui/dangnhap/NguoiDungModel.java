package com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap;

import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NguoiDungModel implements INguoiDungModel {

    APIService service;
    private ErrorMessageDTO errorKiemTra;


   @Override
    public void LayNguoiDung(IOnLayNguoiDungFinishedListener listener) {
        //Truoc khi goi api lay du lieu can phai dang nhap api de lay token
        //Sau khi co duoc token moi goi api lay du lieu
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO token) {
                //Lay token thanh cong => goi api lay du lieu

                service.apiServiceRetrofit.layNguoiDung().enqueue(new Callback<ResponseDTO<List<NguoiDungDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<NguoiDungDTO>>> call, Response<ResponseDTO<List<NguoiDungDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getData() de lay ra du lieu o truong data
                        List<NguoiDungDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<NguoiDungDTO>>> call, Throwable t) {
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



   @Override
    public void LayNguoiDungID(int nguoiDung,IOnLayNguoiDungIDFinishedListener listener) {

        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO token) {
                //Lay token thanh cong => goi api lay du lieu

                service.apiServiceRetrofit.layNguoiDungID(nguoiDung).enqueue(new Callback<ResponseDTO<List<NguoiDungDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<NguoiDungDTO>>> call, Response<ResponseDTO<List<NguoiDungDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getData() de lay ra du lieu o truong data
                        List<NguoiDungDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<NguoiDungDTO>>> call, Throwable t) {
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

    @Override
    public void CapNhatNguoiDung(NguoiDungDTO NguoiDungDTO, INguoiDungModel.IOnCapNhatNguoiDungFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.capNhatNguoiDung(NguoiDungDTO).enqueue(new Callback<ResponseInfo>() {
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
