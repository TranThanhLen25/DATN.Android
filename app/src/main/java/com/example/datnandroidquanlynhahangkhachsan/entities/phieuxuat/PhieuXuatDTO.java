package com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat;

import java.util.Date;

public class PhieuXuatDTO {

    private long phieuXuatId;
    private long khachHangId;
    private String soChungTu;
    private long phieuNhanId;
    private Date ngayLap;
    private int nguoiDungId;
    private float tongThanhTien;
    private float phuThu;
    private float chietKhau;
    private int trangthai;
    private String ghiChu;

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

    public PhieuXuatDTO(long phieuXuatId, long khachHangId, String soChungTu, long phieuNhanId, Date ngayLap, int nguoiDungId, float tongThanhTien, float phuThu, float chietKhau, int trangthai, String ghiChu) {
        this.phieuXuatId = phieuXuatId;
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
}
