package com.example.datnandroidquanlynhahangkhachsan.model.Ban;

import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;

import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DoiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BanModel implements BanIModel{
    APIService service;
    private ErrorMessageDTO errorKiemTra;
    @Override
    public void LayDanhSachBan(IOnLayDanhSachBanFinishedListener listener) {
        //Truoc khi goi api lay du lieu can phai dang nhap api de lay token
        //Sau khi co duoc token moi goi api lay du lieu
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO token) {
                //Lay token thanh cong => goi api lay du lieu

                service.apiServiceRetrofit.layDanhSachBan().enqueue(new Callback<ResponseDTO<List<BanDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<BanDTO>>> call, Response<ResponseDTO<List<BanDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getData() de lay ra du lieu o truong data
                        List<BanDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<BanDTO>>> call, Throwable t) {
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
    public void LayDanhSachLoaiBan(IOnLayDanhSachLoaiBanFinishedListener listener) {
        //Truoc khi goi api lay du lieu can phai dang nhap api de lay token
        //Sau khi co duoc token moi goi api lay du lieu
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO token) {
                //Lay token thanh cong => goi api lay du lieu

                service.apiServiceRetrofit.layDanhSachLoaiBan().enqueue(new Callback<ResponseDTO<List<LoaiBanDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<LoaiBanDTO>>> call, Response<ResponseDTO<List<LoaiBanDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getData() de lay ra du lieu o truong data
                        List<LoaiBanDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<LoaiBanDTO>>> call, Throwable t) {
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
    public void CapNhatTrangThaiBan(BanDTO BanDTO, BanIModel.IOnCapNhatTrangThaiBanFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.capNhatTrangThaiBan(BanDTO).enqueue(new Callback<ResponseInfo>() {
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

    @Override
    public void DoiBan(DoiBanDTO doiBanDTO, IOnDoiBanFinishedListener listener) {
        service=new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.doiBan(doiBanDTO).enqueue(new Callback<ResponseInfo>() {
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


}
