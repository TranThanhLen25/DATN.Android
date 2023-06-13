package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

import com.google.gson.annotations.SerializedName;

public class DieuKienLocPhieuNhanBanChiTietDTO {

    private Long PhieuDatBanChiTietId;

    private Long phieuNhanId;

    private int BanId;


    public Long getPhieuDatBanChiTietId() {
        return PhieuDatBanChiTietId;
    }

    public void setPhieuDatBanChiTietId(Long phieuDatBanChiTietId) {
        PhieuDatBanChiTietId = phieuDatBanChiTietId;
    }

    public Long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(Long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public int getBanId() {
        return BanId;
    }

    public void setBanId(int banId) {
        BanId = banId;
    }
}
