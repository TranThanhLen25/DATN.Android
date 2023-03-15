package com.example.datnandroidquanlynhahangkhachsan.model;

import java.util.Date;

public class KhachHang {
    private long KhachHangID;
    private String cccd;
    private String sdt;
    private String TenKhachHang;
    private String LoaiKhachHang;
    private Date NgaySinh;
    private String GioiTinh;
    private String QueQuan;
    private String NoiThuongTru;

    public KhachHang(long khachHangID, String cccd, String sdt, String tenKhachHang, String loaiKhachHang, Date ngaySinh, String gioiTinh, String queQuan, String noiThuongTru) {
        KhachHangID = khachHangID;
        this.cccd = cccd;
        this.sdt = sdt;
        TenKhachHang = tenKhachHang;
        LoaiKhachHang = loaiKhachHang;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        QueQuan = queQuan;
        NoiThuongTru = noiThuongTru;
    }

    public long getKhachHangID() {
        return KhachHangID;
    }

    public void setKhachHangID(long khachHangID) {
        KhachHangID = khachHangID;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        TenKhachHang = tenKhachHang;
    }

    public String getLoaiKhachHang() {
        return LoaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        LoaiKhachHang = loaiKhachHang;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public String getNoiThuongTru() {
        return NoiThuongTru;
    }

    public void setNoiThuongTru(String noiThuongTru) {
        NoiThuongTru = noiThuongTru;
    }
}
