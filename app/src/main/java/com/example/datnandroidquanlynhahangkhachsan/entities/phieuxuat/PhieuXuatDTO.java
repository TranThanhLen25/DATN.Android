package com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PhieuXuatDTO {
    @SerializedName("phieuXuatId")
    private long phieuXuatId;
    @SerializedName("khachHangId")
    private long khachHangId;
    @SerializedName("soChungTu")
    private String soChungTu;
    @SerializedName("phieuNhanId")
    private long phieuNhanId;
    @SerializedName("ngayLap")
    private Date ngayLap;
    @SerializedName("nguoiDungId")
    private int nguoiDungId;
    @SerializedName("tongThanhTien")
    private float tongThanhTien;
    @SerializedName("phuThu")
    private float phuThu;
    @SerializedName("chietKhau")
    private float chietKhau;
    @SerializedName("trangthai")
    private int trangthai;
    @SerializedName("ghiChu")
    private String ghiChu;

    public PhieuXuatDTO(long khachHangId, String soChungTu, long phieuNhanId, Date ngayLap, int nguoiDungId, float tongThanhTien, float phuThu, float chietKhau, int trangthai, String ghiChu) {
        this.khachHangId = khachHangId;
        this.soChungTu = soChungTu;
        this.phieuNhanId = phieuNhanId;
        this.ngayLap = ngayLap;
        this.nguoiDungId = nguoiDungId;
        this.tongThanhTien = tongThanhTien;
        this.phuThu = phuThu;
        this.chietKhau = chietKhau;
        this.trangthai = trangthai;
        this.ghiChu = ghiChu;
    }

    public PhieuXuatDTO() {
    }

    public long getPhieuXuatId() {
        return phieuXuatId;
    }

    public void setPhieuXuatId(long phieuXuatId) {
        this.phieuXuatId = phieuXuatId;
    }

    public long getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(long khachHangId) {
        this.khachHangId = khachHangId;
    }

    public String getSoChungTu() {
        return soChungTu;
    }

    public void setSoChungTu(String soChungTu) {
        this.soChungTu = soChungTu;
    }

    public long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(int nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }

    public float getTongThanhTien() {
        return tongThanhTien;
    }

    public void setTongThanhTien(float tongThanhTien) {
        this.tongThanhTien = tongThanhTien;
    }

    public float getPhuThu() {
        return phuThu;
    }

    public void setPhuThu(float phuThu) {
        this.phuThu = phuThu;
    }

    public float getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(float chietKhau) {
        this.chietKhau = chietKhau;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
