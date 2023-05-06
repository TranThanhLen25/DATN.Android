package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

public class DieuKienLocPhieuNhanPhongChiTietDTO {
    public long phieuNhanPhongChiTietId;
    public long phieuNhanId;
    public int phongId;

    public DieuKienLocPhieuNhanPhongChiTietDTO(long phieuNhanPhongChiTietId, long phieuNhanId, int phongId) {
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
        this.phieuNhanId = phieuNhanId;
        this.phongId = phongId;
    }

    public DieuKienLocPhieuNhanPhongChiTietDTO() {
    }

    public long getPhieuNhanPhongChiTietId() {
        return phieuNhanPhongChiTietId;
    }

    public void setPhieuNhanPhongChiTietId(long phieuNhanPhongChiTietId) {
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
    }

    public long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public int getPhongId() {
        return phongId;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }
}
