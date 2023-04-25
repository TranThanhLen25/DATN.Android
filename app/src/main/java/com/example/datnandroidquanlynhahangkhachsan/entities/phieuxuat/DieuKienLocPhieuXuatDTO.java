package com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat;

public class DieuKienLocPhieuXuatDTO {
    public int trangthai;
    public long phieuXuatId;
    public long khachHangId;
    public String soChungTu;

    public DieuKienLocPhieuXuatDTO() {
    }

    public DieuKienLocPhieuXuatDTO(int trangthai, long phieuXuatId, long khachHangId, String soChungTu) {
        this.trangthai = trangthai;
        this.phieuXuatId = phieuXuatId;
        this.khachHangId = khachHangId;
        this.soChungTu = soChungTu;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public long getPhieuXuatId() {
        return phieuXuatId;
    }

    public void setPhieuXuatId(long phieuXuatId) {
        this.phieuXuatId = phieuXuatId;
    }

    public long getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(long khachHangId) {
        this.khachHangId = khachHangId;
    }

    public String getSoChungTu() {
        return soChungTu;
    }

    public void setSoChungTu(String soChungTu) {
        this.soChungTu = soChungTu;
    }
}
