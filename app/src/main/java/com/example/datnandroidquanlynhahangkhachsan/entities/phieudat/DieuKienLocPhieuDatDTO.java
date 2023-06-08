package com.example.datnandroidquanlynhahangkhachsan.entities.phieudat;

public class DieuKienLocPhieuDatDTO {
    public long phieuDatId;
    public String soChungTu;
    public int loaiPhieu;
    public long khachHangId;

    public String TrangThai;

    public DieuKienLocPhieuDatDTO(long phieuDatId, String soChungTu, int loaiPhieu, long khachHangId, String trangThai) {
        this.phieuDatId = phieuDatId;
        this.soChungTu = soChungTu;
        this.loaiPhieu = loaiPhieu;
        this.khachHangId = khachHangId;
        TrangThai = trangThai;
    }

    public DieuKienLocPhieuDatDTO() {
    }

    public long getPhieuDatId() {
        return phieuDatId;
    }

    public void setPhieuDatId(long phieuDatId) {
        this.phieuDatId = phieuDatId;
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