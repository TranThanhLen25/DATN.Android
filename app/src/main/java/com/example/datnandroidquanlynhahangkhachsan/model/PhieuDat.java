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

    public PhieuDat(String phieuDatID, String soChungTu, String ngayLap, String nguoiDungID, int loaiPhieuID, String thoiGianNhanDuKien, String thoiGianTraDuKien, String ghiChu, char khachHangID, String trangThai) {
        PhieuDatID = Long.valueOf(phieuDatID);
        SoChungTu = soChungTu;
        NgayLap = Timestamp.valueOf(ngayLap);
        NguoiDungID = Integer.parseInt(nguoiDungID);
        LoaiPhieuID = loaiPhieuID;
        ThoiGianNhanDuKien = Timestamp.valueOf(thoiGianNhanDuKien);
        ThoiGianTraDuKien = Timestamp.valueOf(thoiGianTraDuKien);
        GhiChu = ghiChu;
        KhachHangID = Long.valueOf(khachHangID);
        TrangThai = trangThai;
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
