package com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat;

import com.google.gson.annotations.SerializedName;

public class DieuKienLocPhieuXuatChiTietDTO {

    private long phieuXuatId;

    private long phieuNhanPhongChiTietId;


    private long phieuNhanBanChiTietId;

    public DieuKienLocPhieuXuatChiTietDTO() {
    }

    public long getPhieuXuatId() {
        return phieuXuatId;
    }

    public void setPhieuXuatId(long phieuXuatId) {
        this.phieuXuatId = phieuXuatId;
    }

    public long getPhieuNhanPhongChiTietId() {
        return phieuNhanPhongChiTietId;
    }

    public void setPhieuNhanPhongChiTietId(long phieuNhanPhongChiTietId) {
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
    }

    public long getPhieuNhanBanChiTietId() {
        return phieuNhanBanChiTietId;
    }

    public void setPhieuNhanBanChiTietId(long phieuNhanBanChiTietId) {
        this.phieuNhanBanChiTietId = phieuNhanBanChiTietId;
    }
}
