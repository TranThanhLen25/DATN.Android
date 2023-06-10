package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

import com.google.gson.annotations.SerializedName;

public class DieuKienLocPhieuNhanDTO {
    @SerializedName("phieuNhanId")
    public long phieuNhanId;
    @SerializedName("soChungTu")
    public String soChungTu;
    @SerializedName("loaiPhieuId")
    public int loaiPhieu;
    @SerializedName("khachHangId")
    public long khachHangId;

    @SerializedName("trangThai")
    public String trangThai;

    public DieuKienLocPhieuNhanDTO() {
    }

    public DieuKienLocPhieuNhanDTO(long phieuNhanId, String soChungTu, int loaiPhieu, long khachHangId, String trangThai) {
        this.phieuNhanId = phieuNhanId;
        this.soChungTu = soChungTu;
        this.loaiPhieu = loaiPhieu;
        this.khachHangId = khachHangId;
        this.trangThai = trangThai;
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
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        trangThai = trangThai;
    }
}
