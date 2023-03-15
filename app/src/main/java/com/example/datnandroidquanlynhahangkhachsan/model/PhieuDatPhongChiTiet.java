package com.example.datnandroidquanlynhahangkhachsan.model;

public class PhieuDatPhongChiTiet {
    private Long PhieuDatPhongChiTietID;
    private Long PhieuDatID;
    private int PhongID;
    private int SoNguoi;

    public PhieuDatPhongChiTiet(Long phieuDatPhongChiTietID, Long phieuDatID, int phongID, int soNguoi) {
        PhieuDatPhongChiTietID = phieuDatPhongChiTietID;
        PhieuDatID = phieuDatID;
        PhongID = phongID;
        SoNguoi = soNguoi;
    }

    public Long getPhieuDatPhongChiTietID() {
        return PhieuDatPhongChiTietID;
    }

    public void setPhieuDatPhongChiTietID(Long phieuDatPhongChiTietID) {
        PhieuDatPhongChiTietID = phieuDatPhongChiTietID;
    }

    public Long getPhieuDatID() {
        return PhieuDatID;
    }

    public void setPhieuDatID(Long phieuDatID) {
        PhieuDatID = phieuDatID;
    }

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int phongID) {
        PhongID = phongID;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        SoNguoi = soNguoi;
    }
}
