package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

import com.google.gson.annotations.SerializedName;

public class DieuKienLocPhieuNhanBanChiTietDTO {


    private Long phieuNhanBanChiTietId;

    private Long phieuNhanId;

    private int banId;

    public Long getPhieuNhanBanChiTietId() {
        return phieuNhanBanChiTietId;
    }

    public void setPhieuNhanBanChiTietId(Long phieuNhanBanChiTietId) {
        this.phieuNhanBanChiTietId = phieuNhanBanChiTietId;
    }

    public Long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(Long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public int getBanId() {
        return banId;
    }

    public void setBanId(int banId) {
        this.banId = banId;
    }

    public DieuKienLocPhieuNhanBanChiTietDTO() {
    }
}
