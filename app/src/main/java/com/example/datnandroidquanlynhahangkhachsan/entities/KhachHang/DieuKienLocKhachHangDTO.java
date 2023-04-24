package com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang;

import com.google.gson.annotations.SerializedName;

public class DieuKienLocKhachHangDTO {
    @SerializedName("khachHangId")
    private long khachHangId;
    @SerializedName("cccd")
    private String cccd;
    @SerializedName("sdt")
    private String sdt;
    @SerializedName("tenKhachHang")
    private String tenKhachHang;

    public DieuKienLocKhachHangDTO(long khachHangId, String cccd, String sdt, String tenKhachHang) {
        this.khachHangId = khachHangId;
        this.cccd = cccd;
        this.sdt = sdt;
        this.tenKhachHang = tenKhachHang;
    }

    public DieuKienLocKhachHangDTO() {
    }

    public long getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(long khachHangId) {
        this.khachHangId = khachHangId;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
}
