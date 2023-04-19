//package com.example.Nhapnandroidquanlynhahangkhachsan.ui.phieunhap;
//
//
//
//import com.example.datnandroidquanlynhahangkhachsan.entities.ErrorMessageDTO;
//import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapChiTietDTO;
//import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapDTO;
//import com.example.datnandroidquanlynhahangkhachsan.model.api.APIService;
//import com.example.Nhapnandroidquanlynhahangkhachsan.ui.phieunhap.IPhieuNhapModel;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class PhieuNhapModel implements IPhieuNhapModel {
//    APIService service;
//    private ErrorMessageDTO errorKiemTra;
//
//    @Override
//    public void LayDanhSachPhieuNhap( IPhieuNhapModel.IOnLayDanhSachPhieuNhapFinishedListener listener) {
//        service = new APIService();
//        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
//            @Override
//            public void onSuccess(ResponseTokenDTO token) {
//                //Lay token thanh cong => goi api lay du lieu
//
//                service.apiServiceRetrofit.LayDanhSachPhieuNhap().enqueue(new Callback<ResponseDTO<List<PhieuNhapDTO>>>() {
//                    @Override
//                    public void onResponse(Call<ResponseDTO<List<PhieuNhapDTO>>> call, Response<ResponseDTO<List<PhieuNhapDTO>>> response) {
//                        //lay loi api tra ve (neu co)
//                        errorKiemTra = service.getMessageResponse(response);
//                        if (errorKiemTra.getFlagException() || !errorKiemTra.getFlagSuccess()) {
//                            listener.onError(errorKiemTra.getErrorMessage());
//                            return;
//                        }
//
//                        //trong phan response (tra ve) cua api co body (noi dung)
//                        //Ma o day minh quy uoc la tra ve ResponseDTO
//                        //Sau do response.body().getNhapa() de lay ra du lieu o truong Nhapa
//                        List<PhieuNhapDTO> listResult = response.body().getNhapa();
//                        listener.onSuccess(listResult);
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseDTO<List<PhieuNhapDTO>>> call, Throwable t) {
//                        listener.onError(t.getMessage());
//                    }
//                });
//            }
//
//            @Override
//            public void onError(String error) {
//                //Lay token loi => thong bao loi
//                listener.onError(error);
//            }
//        });
//    }
//
//  @Override
//    public void ThemPhieuNhapPhong(PhieuNhapDTO PhieuNhapDTO, IPhieuNhapModel.IOnThemPhieuNhapFinishedListener listener) {
//        service = new APIService();
//        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
//            @Override
//            public void onSuccess(ResponseTokenDTO itemToken) {
//                service.apiServiceRetrofit.ThemPhieuNhap(PhieuNhapDTO).enqueue(new Callback<ResponseInfo>() {
//                    @Override
//                    public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
//                        if (response.body() != null) {
//                            listener.onSuccess();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseInfo> call, Throwable t) {
//                        listener.onError(t.getMessage());
//                    }
//                });
//            }
//
//            @Override
//            public void onError(String error) {
//                listener.onError(error);
//            }
//        });
//    }
//
//    @Override
//    public void ThemPhieuNhapChiTiet(PhieuNhapChiTietDTO phieuNhapChiTietDTO, IPhieuNhapModel.IOnThemPhieuNhapChiTietFinishedListener listener) {
//        service = new APIService();
//        service.getAccessToken(new IAPIServiceTokenRetrofit.IOnGetAccessTokenFinishedListener() {
//            @Override
//            public void onSuccess(ResponseTokenDTO itemToken) {
//                service.apiServiceRetrofit.ThemPhieuNhapChiTiet(phieuNhapChiTietDTO).enqueue(new Callback<ResponseInfo>() {
//                    @Override
//                    public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
//                        if (response.body() != null) {
//                            listener.onSuccess();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseInfo> call, Throwable t) {
//                        listener.onError(t.getMessage());
//                    }
//                });
//            }
//
//            @Override
//            public void onError(String error) {
//
//            }
//        });
//    }
//
//}
