package com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat;

public class DieuKienLocPhieuXuatChiTietDTO {
    public long phieuXuatPhongChiTietId;
    public long phieuXuatId;

    public DieuKienLocPhieuXuatChiTietDTO() {
    }

    public DieuKienLocPhieuXuatChiTietDTO(long phieuXuatId) {
        this.phieuXuatId = phieuXuatId;
    }

    public long getPhieuXuatPhongChiTietId() {
        return phieuXuatPhongChiTietId;
    }

    public void setPhieuXuatPhongChiTietId(long phieuXuatPhongChiTietId) {
        this.phieuXuatPhongChiTietId = phieuXuatPhongChiTietId;
    }

    public long getPhieuXuatId() {
        return phieuXuatId;
    }

    public void setPhieuXuatId(long phieuXuatId) {
        this.phieuXuatId = phieuXuatId;
    }
}
