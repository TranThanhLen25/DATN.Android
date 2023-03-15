package com.example.datnandroidquanlynhahangkhachsan.model;

import java.sql.Timestamp;

public class PhieuDat {
    private Long PhieuDatID;
    private String SoChungTu;
    private Timestamp NgayLap;
    private int NguoiDungID;
    private int LoaiPhieuID;
    private Timestamp ThoiGianNhanDuKien;
    private Timestamp ThoiGianTraDuKien;
    private String GhiChu;
    private Long KhachHangID;
    private String TrangThai;

    public PhieuDat(Long phieuDatID, String soChungTu, Timestamp ngayLap, int nguoiDungID, int loaiPhieuID, Timestamp thoiGianNhanDuKien, Timestamp thoiGianTraDuKien, String ghiChu, Long khachHangID, String trangThai) {
        PhieuDatID = phieuDatID;
        SoChungTu = soChungTu;
        NgayLap = ngayLap;
        NguoiDungID = nguoiDungID;
        LoaiPhieuID = loaiPhieuID;
        ThoiGianNhanDuKien = thoiGianNhanDuKien;
        ThoiGianTraDuKien = thoiGianTraDuKien;
        GhiChu = ghiChu;
        KhachHangID = khachHangID;
        TrangThai = trangThai;
    }

    public PhieuDat(int i, String soChungTu, String s, int nguoiDungID, int loaiPhieuID, String s1, String s2, String abc, int i1, String đang_đặt) {
    }

    public Long getPhieuDatID() {
        return PhieuDatID;
    }

    public void setPhieuDatID(Long phieuDatID) {
        PhieuDatID = phieuDatID;
    }

    public String getSoChungTu() {
        return SoChungTu;
    }

    public void setSoChungTu(String soChungTu) {
        SoChungTu = soChungTu;
    }

    public Timestamp getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Timestamp ngayLap) {
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

    public Timestamp getThoiGianNhanDuKien() {
        return ThoiGianNhanDuKien;
    }

    public void setThoiGianNhanDuKien(Timestamp thoiGianNhanDuKien) {
        ThoiGianNhanDuKien = thoiGianNhanDuKien;
    }

    public Timestamp getThoiGianTraDuKien() {
        return ThoiGianTraDuKien;
    }

    public void setThoiGianTraDuKien(Timestamp thoiGianTraDuKien) {
        ThoiGianTraDuKien = thoiGianTraDuKien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public Long getKhachHangID() {
        return KhachHangID;
    }

    public void setKhachHangID(Long khachHangID) {
        KhachHangID = khachHangID;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
