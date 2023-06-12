package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PhieuNhanBanChiTietDTO {
    @SerializedName("phieuNhanBanChiTietId")
    private Long PhieuDatBanChiTietId;
    @SerializedName("phieuNhanId")
    private Long phieuNhanId;
    @SerializedName("banId")
    private int BanId;
    @SerializedName("soNguoi")
    private int SoNguoi;
    @SerializedName("thoiGianNhanBan")
    private Date ThoiGianNhanBan;
    @SerializedName("thoiGianTraBan")
    private Date ThoiGianTraBan;
    @SerializedName("trangThai")
    private int TrangThai;

    public PhieuNhanBanChiTietDTO() {
    }

    public Long getPhieuDatBanChiTietId() {
        return PhieuDatBanChiTietId;
    }

    public void setPhieuDatBanChiTietId(Long phieuDatBanChiTietId) {
        PhieuDatBanChiTietId = phieuDatBanChiTietId;
    }

    public Long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public int getBanId() {
        return BanId;
    }

    public void setBanId(int banId) {
        BanId = banId;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        SoNguoi = soNguoi;
    }

    public Date getThoiGianNhanBan() {
        return ThoiGianNhanBan;
    }

    public void setThoiGianNhanBan(Date thoiGianNhanBan) {
        ThoiGianNhanBan = thoiGianNhanBan;
    }

    public Date getThoiGianTraBan() {
        return ThoiGianTraBan;
    }

    public void setThoiGianTraBan(Date thoiGianTraBan) {
        ThoiGianTraBan = thoiGianTraBan;
    }

    public void setPhieuNhanId(Long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }
}
