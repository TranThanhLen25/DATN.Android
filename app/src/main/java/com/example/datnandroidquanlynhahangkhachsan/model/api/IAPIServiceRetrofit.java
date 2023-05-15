package com.example.datnandroidquanlynhahangkhachsan.model.api;


import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.ListDichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DieuKienLocHangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.ResponseInfo;
import com.example.datnandroidquanlynhahangkhachsan.entities.api.ResponseDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;

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

    @POST("/api/PhieuNhan/danhsach-PhieuNhan?")
    Call<ResponseDTO<List<PhieuNhanDTO>>> layDanhSachPhieuNhan(@Body DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO);


    @POST("/api/KhachHang/lay-KhachHang?")
    Call<ResponseDTO<List<KhachHangDTO>>> layDanhSachKhachHang(@Body DieuKienLocKhachHangDTO dieuKienLocKhachHang);



    @POST("/api/PhieuDat/them-PhieuDat")
    Call<ResponseInfo> ThemPhieuDatPhong(@Body DatPhongDTO datPhongDTO);

    @POST("/api/PhieuDatPhongChiTiet/them-PhieuDatPhongChiTiet")
    Call<ResponseInfo> ThemPhieuDatPhongChiTiet(@Body PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO);


    //   lấy danh sách phòng với bảng tạm mới bên api_bên android chỉ cần thêm trường dữ liệu vào PhongDTO
    //    @POST("/api/Phong/danhsach-phong-proc")
    //    Call<ResponseDTO<List<PhongDTO>>> layDanhSachPhong();

    ///lấy danh sách phòng

    @POST("/api/Phong/danhsach-Phong")
    Call<ResponseDTO<List<PhongDTO>>> layDanhSachPhong();

    ///lấy danh sách loại phòng
    @POST("/api/LoaiPhong/danhsach-LoaiPhong")
    Call<ResponseDTO<List<LoaiPhongDTO>>> layLoaiPhong();


    ///lấy danh sach theo id loại phòng_và trạng thái phòng( trống hay có người ...)
    ///biến trong query phải trùng với biến trong api
    @POST("/api/Phong/danhsach-phongthuong1g?")
    Call<ResponseDTO<List<PhongDTO>>> layDanhSachPhong1g(@Query("id") int id, @Query("trangThaiId") int trangThaiId);

    ///đăng nhập
//    @POST("/api/NguoiDung/laynguoidung?")
//    Call<ResponseDTO<List<NguoiDungDTO>>> layNguoiDung(@Query("username") String username, @Query("password") String password);


    @POST("/api/KhachHang/Them-KhachHang")
    Call<ResponseInfo> themKhachHang(@Body KhachHangDTO khachHangDTO);




    @POST("/api/PhieuNhap/them-phieunhap")
    Call<ResponseInfo> ThemPhieuNhapPhong(@Body PhieuNhapDTO phieuNhapDTO);

    @POST("api/PhieuNhapChiTiet/Them-PNCT")
    Call<ResponseInfo> ThemPhieuNhapChiTiet(@Body PhieuNhapChiTietDTO phieuNhapChiTietDTO);


    @POST("/api/NguoiDung/danhsach-NguoiDung")
    Call<ResponseDTO<List<NguoiDungDTO>>> layNguoiDung();

    @GET("/api/NguoiDung/timNguoiDung?")
    Call<ResponseDTO<List<NguoiDungDTO>>> layNguoiDungID(@Query("nguoiDung") int nguoiDung);

    @POST("/api/Phong/CapNhat-Phong")
    Call<ResponseInfo> capNhatTrangThaiPhong(@Body PhongDTO phongDTO);


    @POST("/api/NguoiDung/CapNhat-NguoiDung")
    Call<ResponseInfo> capNhatNguoiDung(@Body NguoiDungDTO nguoiDungDTO);

    @POST("/api/PhieuXuat/danhsach-PhieuXuat?")
    Call<ResponseDTO<List<PhieuXuatDTO>>>   layPhieuXuat(@Body DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO);


    @POST("/api/PhieuNhanPhongChiTiet/capnhat-PhieuNhanPhongChiTiet")
    Call<ResponseInfo> capNhatPhieuNhanPhongChiTiet(@Body PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO);




    @POST("/api/PhieuNhanPhongChiTiet/danhsach-PhieuNhanPhongChiTiet?")
    Call<ResponseDTO<List<PhieuNhanPhongChiTietDTO>>>   layPhieuNhanPhongChiTiet(@Body DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO);



    @POST("/api/hanghoa/danhsach-GoiMon")
    Call<ResponseDTO<List<GoiMonDTO>>> layDanhSachGoiMon(@Body GoiMonDTO goiMonDTO);

    @POST("/api/hanghoa/danhsach-dichvu")
    Call<ResponseDTO<List<DichVuDTO>>> layDanhSachDichVu(@Body DichVuDTO dichVuDTO);

    @POST("/api/hanghoa/them-dichvu")
    Call<ResponseInfo> themDichVu(@Body ListDichVuDTO listDichVuDTO);

    @POST("/api/hanghoa/capnhat-dichvu")
    Call<ResponseInfo> capNhatDichVu(@Body ListDichVuDTO listDichVuDTO);

}
