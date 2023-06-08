package com.example.datnandroidquanlynhahangkhachsan.entities.phieudat;

import java.util.Date;

public class PhieuDatBanChiTietDTO {
    private Long PhieuDatBanChiTietId;
    private Long PhieuDatId;
    private int BanId;
    private int SoNguoi;
    private Date ThoiGianNhanDuKien;
    private String TrangThai;

    public PhieuDatBanChiTietDTO() {
    }

    public PhieuDatBanChiTietDTO(Long phieuDatId, int banId, int soNguoi, Date thoiGianNhanDuKien, String trangThai) {
        PhieuDatId = phieuDatId;
        BanId = banId;
        SoNguoi = soNguoi;
        ThoiGianNhanDuKien = thoiGianNhanDuKien;
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

    public Date getThoiGianNhanDuKien() {
        return ThoiGianNhanDuKien;
    }

    public void setThoiGianNhanDuKien(Date thoiGianNhanDuKien) {
        ThoiGianNhanDuKien = thoiGianNhanDuKien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
