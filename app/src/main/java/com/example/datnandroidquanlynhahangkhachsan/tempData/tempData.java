package com.example.datnandroidquanlynhahangkhachsan.tempData;

import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class tempData {
    public static Date day = Calendar.getInstance().getTime();
    //danh sách hàng hóa đang chọn trong menu
    public static List<Integer> lsDichVu;
    public static PhongDTO doiPhong;
    public static BanDTO doiBan;
    public static DatPhongDTO datPhongDTO;
    public static DatBanDTO datBanDTO;
    public static PhieuDatDTO phieuDatDTO;
    //public static PhieuDatDTO phieuDatDTO1 = new PhieuDatDTO(1L,"1",day,1,1,day,day,"abc",1L,"abc");
    public static List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOList;
    public static KhachHangDTO tempDatakhachHangDTO;
    public static List<Integer> soLuongPhongDaDats;

    public static List<KhachHangDTO> khachHangDTOList;
    public static boolean Check = false;
    public static boolean CheckChucNang = false;
    public static boolean checkDoiPhong = false;
    public static boolean checkDoiBan = false;
}
