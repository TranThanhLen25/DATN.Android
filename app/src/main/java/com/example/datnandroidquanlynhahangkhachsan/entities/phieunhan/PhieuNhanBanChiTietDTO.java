package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PhieuNhanBanChiTietDTO {
    @SerializedName("phieuDatBanChiTietId")
    private Long PhieuDatBanChiTietId;
    @SerializedName("phieuDatId")
    private Long PhieuDatId;
    @SerializedName("banId")
    private int BanId;
    @SerializedName("soNguoi")
    private int SoNguoi;
    @SerializedName("thoiGianNhanBan")
    private Date ThoiGianNhanBan;
    @SerializedName("thoiGianTraBan")
    private Date ThoiGianTraBan;
    @SerializedName("trangThai")
    private String TrangThai;

    public PhieuNhanBanChiTietDTO() {
    }

    public PhieuNhanBanChiTietDTO(Long phieuDatId, int banId, int soNguoi, Date thoiGianNhanBan, Date thoiGianTraBan, String trangThai) {
        PhieuDatId = phieuDatId;
        BanId = banId;
        SoNguoi = soNguoi;
        ThoiGianNhanBan = thoiGianNhanBan;
        ThoiGianTraBan = thoiGianTraBan;
        TrangThai = trangThai;
    }

    public Long getPhieuDatBanChiTietId() {
        return PhieuDatBanChiTietId;
    }

    public void setPhieuDatBanChiTietId(Long phieuDatBanChiTietId) {
        PhieuDatBanChiTietId = phieuDatBanChiTietId;
    }

    public Long getPhieuDatId() {
        return PhieuDatId;
    }

    public void setPhieuDatId(Long phieuDatId) {
        PhieuDatId = phieuDatId;
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

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
