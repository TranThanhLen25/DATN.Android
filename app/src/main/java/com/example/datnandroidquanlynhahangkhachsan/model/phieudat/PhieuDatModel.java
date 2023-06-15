package com.example.datnandroidquanlynhahangkhachsan.model.phieudat;

import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseTokenDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
import com.example.datnandroidquanlynhahangkhachsan.model.api.IAPIServiceTokenRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhieuDatModel implements IPhieuDatModel {
    APIService service;
    private ErrorMessageDTO errorKiemTra;

    @Override
    public void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO, IOnLayDanhSachPhieuDatFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO token) {
                //Lay token thanh cong => goi api lay du lieu

                service.apiServiceRetrofit.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO).enqueue(new Callback<ResponseDTO<List<PhieuDatDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<PhieuDatDTO>>> call, Response<ResponseDTO<List<PhieuDatDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getData() de lay ra du lieu o truong data
                        List<PhieuDatDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<PhieuDatDTO>>> call, Throwable t) {
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

    //
    @Override
    public void ThemPhieuDatPhong(DatPhongDTO datPhongDTO, IOnThemPhieuDatPhongFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.ThemPhieuDatPhong(datPhongDTO).enqueue(new Callback<ResponseInfo>() {
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
    public void ThemPhieuDatPhongChiTiet(PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO, IOnThemPhieuDatPhongChiTietFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.ThemPhieuDatPhongChiTiet(phieuDatPhongChiTietDTO).enqueue(new Callback<ResponseInfo>() {
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
//Lay token loi => thong bao loi
                listener.onError(error);
            }
        });
    }

    @Override
    public void LayPhieuDatPhongChiTiet(PhieuDatDTO phieuDatDTO, IOnLayPhieuDatPhongChiTietFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.layPhieuDatPhongChiTiet(phieuDatDTO).enqueue(new Callback<ResponseDTO<List<PhieuDatPhongChiTietDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<PhieuDatPhongChiTietDTO>>> call, Response<ResponseDTO<List<PhieuDatPhongChiTietDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getData() de lay ra du lieu o truong data
                        List<PhieuDatPhongChiTietDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<PhieuDatPhongChiTietDTO>>> call, Throwable t) {
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
    public void ThemPhieuDatBan(DatBanDTO datBanDTO, IOnThemPhieuDatBanFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.ThemPhieuDatBan(datBanDTO).enqueue(new Callback<ResponseInfo>() {
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
    public void LayPhieuDatBanChiTiet(PhieuDatDTO phieuDatDTO, IOnLayPhieuDatBanChiTietFinishedListener listener) {
        service = new APIService();
        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
            @Override
            public void onSuccess(ResponseTokenDTO itemToken) {
                service.apiServiceRetrofit.layPhieuDatBanChiTiet(phieuDatDTO).enqueue(new Callback<ResponseDTO<List<PhieuDatBanChiTietDTO>>>() {
                    @Override
                    public void onResponse(Call<ResponseDTO<List<PhieuDatBanChiTietDTO>>> call, Response<ResponseDTO<List<PhieuDatBanChiTietDTO>>> response) {
                        //lay loi api tra ve (neu co)
                        errorKiemTra = service.getMessageResponse(response);
                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
                            listener.onError(errorKiemTra.getErrorMessage());
                            return;
                        }

                        //trong phan response (tra ve) cua api co body (noi dung)
                        //Ma o day minh quy uoc la tra ve ResponseDTO
                        //Sau do response.body().getData() de lay ra du lieu o truong data
                        List<PhieuDatBanChiTietDTO> listResult = response.body().getData();
                        listener.onSuccess(listResult);
                    }

                    @Override
                    public void onFailure(Call<ResponseDTO<List<PhieuDatBanChiTietDTO>>> call, Throwable t) {
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
