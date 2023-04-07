package com.example.datnandroidquanlynhahangkhachsan.entities.phieudat;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PhieuDatDTO {
    @SerializedName("phieuDatId")
    private Long PhieuDatID;
    @SerializedName("soChungtu")
    private String SoChungTu;
    @SerializedName("ngayLap")
    private Date NgayLap;
    @SerializedName("nguoiDungId")
    private int NguoiDungID;
    @SerializedName("loaiPhieuId")
    private int LoaiPhieuID;
    @SerializedName("thoiGianNhanDuKien")
    private Date ThoiGianNhanDuKien;
    @SerializedName("thoiGianTraDuKien")
    private Date ThoiGianTraDuKien;
    @SerializedName("ghiChu")
    private String GhiChu;
    @SerializedName("khachHangId")
    private Long KhachHangID;
    @SerializedName("trangThai")
    private String TrangThai;

    public PhieuDatDTO(String soChungTu, Date ngayLap, int nguoiDungID, int loaiPhieuID, Date thoiGianNhanDuKien, Date thoiGianTraDuKien, String ghiChu, Long khachHangID, String trangThai) {
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

    public Long getPhieuDatID() {
        return PhieuDatID;
    }

    public String getSoChungTu() {
        return SoChungTu;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public int getNguoiDungID() {
        return NguoiDungID;
    }

    public int getLoaiPhieuID() {
        return LoaiPhieuID;
    }

    public Date getThoiGianNhanDuKien() {
        return ThoiGianNhanDuKien;
    }

    public Date getThoiGianTraDuKien() {
        return ThoiGianTraDuKien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public Long getKhachHangID() {
        return KhachHangID;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setPhieuDatID(Long phieuDatID) {
        PhieuDatID = phieuDatID;
    }

    public void setSoChungTu(String soChungTu) {
        SoChungTu = soChungTu;
    }

    public void setNgayLap(Date ngayLap) {
        NgayLap = ngayLap;
    }

    public void setNguoiDungID(int nguoiDungID) {
        NguoiDungID = nguoiDungID;
    }

    public void setLoaiPhieuID(int loaiPhieuID) {
        LoaiPhieuID = loaiPhieuID;
    }

    public void setThoiGianNhanDuKien(Date thoiGianNhanDuKien) {
        ThoiGianNhanDuKien = thoiGianNhanDuKien;
    }

    public void setThoiGianTraDuKien(Date thoiGianTraDuKien) {
        ThoiGianTraDuKien = thoiGianTraDuKien;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public void setKhachHangID(Long khachHangID) {
        KhachHangID = khachHangID;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
