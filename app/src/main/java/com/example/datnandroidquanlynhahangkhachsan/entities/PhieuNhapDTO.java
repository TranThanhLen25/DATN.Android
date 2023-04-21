package com.example.datnandroidquanlynhahangkhachsan.entities;

import java.util.Date;

public class PhieuNhapDTO {
    private int phieuNhapId;
    private String soChungtu;
    private Date ngayLap;
    private long nguoiDungId;
    private int khachHangId;
    private String ghiChu;

    public PhieuNhapDTO(int phieuNhapId, String soChungtu, Date ngayLap, long nguoiDungId, int khachHangId, String ghiChu) {
        this.phieuNhapId = phieuNhapId;
        this.soChungtu = soChungtu;
        this.ngayLap = ngayLap;
        this.nguoiDungId = nguoiDungId;
        this.khachHangId = khachHangId;
        this.ghiChu = ghiChu;
    }

    public int getPhieuNhapId() {
        return phieuNhapId;
    }

    public void setPhieuNhapId(int phieuNhapId) {
        this.phieuNhapId = phieuNhapId;
    }

    public String getSoChungtu() {
        return soChungtu;
    }

    public void setSoChungtu(String soChungtu) {
        this.soChungtu = soChungtu;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public long getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(long nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }

    public int getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(int khachHangId) {
        this.khachHangId = khachHangId;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
