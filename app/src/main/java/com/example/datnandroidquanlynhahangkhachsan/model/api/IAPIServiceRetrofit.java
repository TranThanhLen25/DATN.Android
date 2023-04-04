package com.example.datnandroidquanlynhahangkhachsan.model.api;




import com.example.datnandroidquanlynhahangkhachsan.entities.DieuKienLocHangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
<<<<<<< HEAD
import retrofit2.http.POST;
=======
import retrofit2.http.Query;
>>>>>>> develop

public interface IAPIServiceRetrofit {

    @GET("/api/hanghoa/danhsach-hanghoa")
    Call<ResponseDTO<List<HangHoaDTO>>> layDanhSachHangHoa(@Body DieuKienLocHangHoaDTO dieuKienLoc);

<<<<<<< HEAD
    @GET("/api/hanghoa/danhsach-hanghoa")
    Call<ResponseDTO<List<HangHoaDTO>>> layDanhSachHangHoa2();

    @POST("/api/Phong/danhsach-Phong")
    Call<ResponseDTO<List<PhongDTO>>> layDanhSachPhong();
=======
    @GET("/api/hanghoa/danhsach-hanghoa?")
    Call<ResponseDTO<List<HangHoaDTO>>> layDanhSachHangHoa2(@Query("NhomHangHoa") String NhomHangHoa);
>>>>>>> develop
}
