package com.example.datnandroidquanlynhahangkhachsan.model;

public class DichVu {
    private String TenHangHoa;
    private String DonGia;
    private String SoLuong;
    private String ThanhTien;

    public String getTenHangHoa() {
        return TenHangHoa;
    }

    public String getDonGia() {
        return DonGia;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public String getThanhTien() {
        return ThanhTien;
    }


    public DichVu(String tenHangHoa, String donGia, String soLuong, String thanhTien) {
        TenHangHoa = tenHangHoa;
        DonGia = donGia;
        SoLuong = soLuong;
        ThanhTien = thanhTien;
    }
}
