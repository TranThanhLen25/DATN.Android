package com.example.datnandroidquanlynhahangkhachsan.model;

import java.util.Date;

public class PhieuNhan {
    private Long PhieuNhanID;
    private String SoChungTu;
    private Date NgayLap;
    private int NguoiDungID;
    private  int LoaiPhieuID;
    private Date NgayTra;
    private Long KhachHangID;
    private String GhiChu;
    private String TrangThai;

    public PhieuNhan(Long phieuNhanID, String soChungTu, Date ngayLap, int nguoiDungID, int loaiPhieuID, Date ngayTra, Long khachHangID, String ghiChu, String trangThai) {
        PhieuNhanID = phieuNhanID;
        SoChungTu = soChungTu;
        NgayLap = ngayLap;
        NguoiDungID = nguoiDungID;
        LoaiPhieuID = loaiPhieuID;
        NgayTra = ngayTra;
        KhachHangID = khachHangID;
        GhiChu = ghiChu;
        TrangThai = trangThai;
    }

    public Long getPhieuNhanID() {
        return PhieuNhanID;
    }

    public void setPhieuNhanID(Long phieuNhanID) {
        PhieuNhanID = phieuNhanID;
    }

    public String getSoChungTu() {
        return SoChungTu;
    }

    public void setSoChungTu(String soChungTu) {
        SoChungTu = soChungTu;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date ngayLap) {
        NgayLap = ngayLap;
    }

    public int getNguoiDungID() {
        return NguoiDungID;
    }

    public void setNguoiDungID(int nguoiDungID) {
        NguoiDungID = nguoiDungID;
    }

    public int getLoaiPhieuID() {
        return LoaiPhieuID;
    }

    public void setLoaiPhieuID(int loaiPhieuID) {
        LoaiPhieuID = loaiPhieuID;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date ngayTra) {
        NgayTra = ngayTra;
    }

    public Long getKhachHangID() {
        return KhachHangID;
    }

    public void setKhachHangID(Long khachHangID) {
        KhachHangID = khachHangID;
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
    }}

