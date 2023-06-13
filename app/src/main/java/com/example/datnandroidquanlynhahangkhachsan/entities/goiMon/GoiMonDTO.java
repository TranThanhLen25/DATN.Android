package com.example.datnandroidquanlynhahangkhachsan.entities.goiMon;

import java.util.Date;

public class GoiMonDTO {
    private long goiMonId;
    private int banId;
    private int hangHoaId;
    private long phieuNhanId;
    private int soLuong;
    private int donGia;
    private int thanhTien;
    private String ghiChu;
    private String trangThai;
    private Date thoiGian;

    public GoiMonDTO() {
    }

    public GoiMonDTO(int banId, int hangHoaId, long phieuNhanId, int soLuong, int donGia, int thanhTien, String ghiChu, String trangThai, Date thoiGian) {
        this.banId = banId;
        this.hangHoaId = hangHoaId;
        this.phieuNhanId = phieuNhanId;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.thoiGian = thoiGian;
    }

    public long getGoiMonId() {
        return goiMonId;
    }

    public void setGoiMonId(long goiMonId) {
        this.goiMonId = goiMonId;
    }

    public int getBanId() {
        return banId;
    }

    public void setBanId(int banId) {
        this.banId = banId;
    }

    public int getHangHoaId() {
        return hangHoaId;
    }

    public void setHangHoaId(int hangHoaId) {
        this.hangHoaId = hangHoaId;
    }

    public long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
}
