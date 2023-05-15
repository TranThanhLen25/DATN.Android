package com.example.datnandroidquanlynhahangkhachsan.entities.DichVu;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DichVuDTO {
    @SerializedName("dichVuId")
    private long DichVuID;
    @SerializedName("phongId")
    private int PhongID;
    @SerializedName("hangHoaId")
    private int HangHoaId;
    @SerializedName("phieuNhanId")
    private long PhieuNhanID;
    @SerializedName("soLuong")
    private int SoLuong;
    @SerializedName("donGia")
    private int DonGia;
    @SerializedName("thanhTien")
    private int ThanhTien;
    @SerializedName("ghiChu")
    private String GhiChu;
    @SerializedName("trangThai")
    private String TrangThai;
    @SerializedName("thoiGian")
    private Date ThoiGian;

    public DichVuDTO(int phongID, int hangHoaId, int soLuong) {
        PhongID = phongID;
        HangHoaId = hangHoaId;
        SoLuong = soLuong;
    }

    public DichVuDTO() {
    }

    public long getDichVuID() {
        return DichVuID;
    }

    public void setDichVuID(long dichVuID) {
        DichVuID = dichVuID;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int phongID) {
        PhongID = phongID;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        DonGia = donGia;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int thanhTien) {
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
