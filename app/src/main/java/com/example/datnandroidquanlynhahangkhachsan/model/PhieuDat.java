package com.example.datnandroidquanlynhahangkhachsan.model;

import java.util.Date;

public class PhieuDat {
    private Long PhieuDatID;
    private String SoChungTu;
    private Date NgayLap;
    private int NguoiDungID;
    private int LoaiPhieuID;
    private Date ThoiGianNhanDuKien;
    private Date ThoiGianTraDuKien;
    private String GhiChu;
    private Long KhachHangID;
    private String TrangThai;

    public PhieuDat(Long phieuDatID, String soChungTu, Date ngayLap, int nguoiDungID, int loaiPhieuID, Date thoiGianNhanDuKien, Date thoiGianTraDuKien, String ghiChu, Long khachHangID, String trangThai) {
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

    public Date getThoiGianNhanDuKien() {
        return ThoiGianNhanDuKien;
    }

    public void setThoiGianNhanDuKien(Date thoiGianNhanDuKien) {
        ThoiGianNhanDuKien = thoiGianNhanDuKien;
    }

    public Date getThoiGianTraDuKien() {
        return ThoiGianTraDuKien;
    }

    public void setThoiGianTraDuKien(Date thoiGianTraDuKien) {
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
