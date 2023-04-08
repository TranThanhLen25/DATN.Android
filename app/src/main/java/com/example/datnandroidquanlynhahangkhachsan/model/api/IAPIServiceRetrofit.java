package com.example.datnandroidquanlynhahangkhachsan.model.api;


import com.example.datnandroidquanlynhahangkhachsan.entities.DieuKienLocHangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;

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
    Call<ResponseDTO<List<PhieuDatDTO>>> LayDanhSachPhieuDat(@Body DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO);

    @POST("/api/PhieuDat/them-PhieuDat")
    Call<ResponseInfo> ThemPhieuDatPhong(@Body PhieuDatDTO phieuDatDTO);

    @POST("/api/PhieuDatPhongChiTiet/them-PhieuDatPhongChiTiet")
    Call<ResponseInfo> ThemPhieuDatPhongChiTiet(@Body PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO);

    @POST("/api/Phong/danhsach-phong-proc")
    Call<ResponseDTO<List<PhongDTO>>> layDanhSachPhong();
//
//    @POST("/api/Phong/danhsach-Phong")
//    Call<ResponseDTO<List<PhongDTO>>> layDanhSachPhong();

    ///lấy danh sách loại phòng
    @POST("/api/LoaiPhong/danhsach-LoaiPhong")
    Call<ResponseDTO<List<LoaiPhongDTO>>> layLoaiPhong();


    ///lấy danh sach theo loại phòng
    ///biến trong query phải trùng với biến trong api
    @POST("/api/Phong/danhsach-phongthuong1g?")
    Call<ResponseDTO<List<PhongDTO>>> layDanhSachPhong1g(@Query("id") int id);


}
