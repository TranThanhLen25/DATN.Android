package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PhieuNhanPhongChiTietDTO {

    @SerializedName("phieuNhanPhongChiTietId")
    private long phieuNhanPhongChiTietId;

    @SerializedName("phieuNhanId")
    private long phieuNhanId;
    @SerializedName("phongId")
    private int phongId;
    @SerializedName("soNguoi")
    private int soNguoi;
    @SerializedName("trangThai")
    private int trangThai;
    @SerializedName("thoiGianNhanPhong")
    private Date thoiGianNhanPhong;
    @SerializedName("thoiGianTraPhong")
    private Date thoiGianTraPhong;
    @SerializedName("donGia")
    private float donGia;

    public PhieuNhanPhongChiTietDTO() {
    }

    public PhieuNhanPhongChiTietDTO(int phongId, int soNguoi, int trangThai, Date thoiGianNhanPhong, Date thoiGianTraPhong, float donGia) {
        this.phongId = phongId;
        this.soNguoi = soNguoi;
        this.trangThai = trangThai;
        this.thoiGianNhanPhong = thoiGianNhanPhong;
        this.thoiGianTraPhong = thoiGianTraPhong;
        this.donGia = donGia;
    }

    public long getPhieuNhanPhongChiTietId() {
        return phieuNhanPhongChiTietId;
    }

    public void setPhieuNhanPhongChiTietId(long phieuNhanPhongChiTietId) {
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
    }

    public long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public int getPhongId() {
        return phongId;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGianNhanPhong() {
        return thoiGianNhanPhong;
    }

    public void setThoiGianNhanPhong(Date thoiGianNhanPhong) {
        this.thoiGianNhanPhong = thoiGianNhanPhong;
    }

    public Date getThoiGianTraPhong() {
        return thoiGianTraPhong;
    }

    public void setThoiGianTraPhong(Date thoiGianTraPhong) {
        this.thoiGianTraPhong = thoiGianTraPhong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
}
