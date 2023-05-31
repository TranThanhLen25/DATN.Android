package com.example.datnandroidquanlynhahangkhachsan.entities;

import java.util.Date;

public class GoiMonDTO {
    private long GoiMonID;
    private int PhongID;
    private int BanID;
    private int HangHoaId;
    private long PhieuNhanID;
    private float SoLuong;
    private float DonGia;
    private float ThanhTien;
    private String GhiChu;
    private  String TrangThai;
    private Date ThoiGian;

    public GoiMonDTO(int phongID, int banID, int hangHoaId, long phieuNhanID, float soLuong, float donGia, float thanhTien, String ghiChu, String trangThai, Date thoiGian) {
        PhongID = phongID;
        BanID = banID;
        HangHoaId = hangHoaId;
        PhieuNhanID = phieuNhanID;
        SoLuong = soLuong;
        DonGia = donGia;
        ThanhTien = thanhTien;
        GhiChu = ghiChu;
        TrangThai = trangThai;
        ThoiGian = thoiGian;
    }

    public GoiMonDTO() {
    }

    public long getGoiMonID() {
        return GoiMonID;
    }

    public void setGoiMonID(long goiMonID) {
        GoiMonID = goiMonID;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int phongID) {
        PhongID = phongID;
    }

    public int getBanID() {
        return BanID;
    }

    public void setBanID(int banID) {
        BanID = banID;
    }

    public int getHangHoaId() {
        return HangHoaId;
    }

    public void setHangHoaId(int hangHoaId) {
        HangHoaId = hangHoaId;
    }

    public long getPhieuNhanID() {
        return PhieuNhanID;
    }

    public void setPhieuNhanID(long phieuNhanID) {
        PhieuNhanID = phieuNhanID;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float soLuong) {
        SoLuong = soLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float donGia) {
        DonGia = donGia;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float thanhTien) {
        ThanhTien = thanhTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        ThoiGian = thoiGian;
    }
}
