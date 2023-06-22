package com.example.datnandroidquanlynhahangkhachsan.entities;

import com.google.gson.annotations.SerializedName;

public class NguoiDungDTO {


    @SerializedName("nguoiDungId")
    private int nguoiDungId;
    @SerializedName("tenNguoiDung")
    private String tenNguoiDung;
    @SerializedName("sdt")
    private String sdt;
    @SerializedName("cccd")
    private String cccd;
    @SerializedName("gioiTinh")
    private String gioiTinh;
    @SerializedName("diaChi")
    private String diaChi;
    @SerializedName("loaiTaiKhoan")
    private String loaiTaiKhoan;
    @SerializedName("taiKhoan")
    private String taiKhoan;
    @SerializedName("matKhau")
    private String matKhau;


    @SerializedName("trangThai")
    private int trangThai;

    public NguoiDungDTO() {
    }

    public NguoiDungDTO(int nguoiDungId, String tenNguoiDung,
                        String sdt, String cccd, String gioiTinh,
                        String diaChi, String loaiTaiKhoan,
                        String taiKhoan, String matKhau, int trangThai) {
        this.nguoiDungId = nguoiDungId;
        this.tenNguoiDung = tenNguoiDung;
        this.sdt = sdt;
        this.cccd = cccd;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public NguoiDungDTO(String tenNguoiDung, String sdt, String cccd, String gioiTinh, String diaChi, String loaiTaiKhoan, String taiKhoan, String matKhau, int trangThai) {
        this.tenNguoiDung = tenNguoiDung;
        this.sdt = sdt;
        this.cccd = cccd;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public NguoiDungDTO(String sdt, String diaChi) {
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public int getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(int nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

//    public NguoiDungDTO(String taiKhoan, String matKhau) {
//        this.taiKhoan = taiKhoan;
//        this.matKhau = matKhau;
//    }



}
