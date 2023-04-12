package com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class KhachHangDTO {
    @SerializedName("khachHangId")
    private long khachHangId;
    @SerializedName("cccd")
    private String cccd;
    @SerializedName("sdt")
    private String sdt;
    @SerializedName("tenKhachHang")
    private String tenKhachHang;
    @SerializedName("loaiKhachHang")
    private String loaiKhachHang;
    @SerializedName("ngaySinh")
    private Date ngaySinh;
    @SerializedName("gioiTinh")
    private String gioiTinh;
    @SerializedName("queQuan")
    private String queQuan;
    @SerializedName("noiThuongTru")
    private String noiThuongTru;


    public KhachHangDTO(String cccd, String sdt, String tenKhachHang, Date ngaySinh, String gioiTinh, String noiThuongTru) {
        this.cccd = cccd;
        this.sdt = sdt;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noiThuongTru = noiThuongTru;
    }

    public KhachHangDTO() {

    }

    public long getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(long khachHangId) {
        this.khachHangId = khachHangId;
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
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNoiThuongTru() {
        return noiThuongTru;
    }

    public void setNoiThuongTru(String noiThuongTru) {
        this.noiThuongTru = noiThuongTru;
    }
}
