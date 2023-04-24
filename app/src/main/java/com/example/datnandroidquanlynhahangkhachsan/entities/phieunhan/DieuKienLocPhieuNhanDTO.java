package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

public class DieuKienLocPhieuNhanDTO {
    public long phieuNhanId;
    public String soChungTu;
    public int loaiPhieu;
    public long khachHangId;

    public String TrangThai;

    public DieuKienLocPhieuNhanDTO() {
    }

    public DieuKienLocPhieuNhanDTO(long phieuNhanId, String soChungTu, int loaiPhieu, long khachHangId, String trangThai) {
        this.phieuNhanId = phieuNhanId;
        this.soChungTu = soChungTu;
        this.loaiPhieu = loaiPhieu;
        this.khachHangId = khachHangId;
        TrangThai = trangThai;
    }

    public long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public String getSoChungTu() {
        return soChungTu;
    }

    public void setSoChungTu(String soChungTu) {
        this.soChungTu = soChungTu;
    }

    public int getLoaiPhieu() {
        return loaiPhieu;
    }

    public void setLoaiPhieu(int loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }

    public long getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(long khachHangId) {
        this.khachHangId = khachHangId;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
