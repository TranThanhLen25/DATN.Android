package com.example.datnandroidquanlynhahangkhachsan.model.api;


import com.example.datnandroidquanlynhahangkhachsan.entities.DieuKienLocHangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IAPIServiceRetrofit {

    @GET("/api/hanghoa/danhsach-hanghoa")
    Call<ResponseDTO<List<HangHoaDTO>>> layDanhSachHangHoa(@Body DieuKienLocHangHoaDTO dieuKienLoc);

    @GET("/api/hanghoa/danhsach-hanghoa?")
    Call<ResponseDTO<List<HangHoaDTO>>> layDanhSachHangHoa2(@Query("NhomHangHoa") String NhomHangHoa);

    @POST("/api/PhieuDat/danhsach-PhieuDat?")
    Call<ResponseDTO<List<PhieuDatDTO>>> LayDanhSachPhieuDat(@Query("LoaiPhieu") int LoaiPhieu);

    @POST("/api/PhieuDat/them-PhieuDat")
    Call<ResponseInfo> ThemPhieuDatPhong(@Body PhieuDatDTO phieuDatDTO);

    @POST("/api/Phong/danhsach-Phong")
    Call<ResponseDTO<List<PhongDTO>>> layDanhSachPhong();

}
