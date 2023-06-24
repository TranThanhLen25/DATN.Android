package com.example.datnandroidquanlynhahangkhachsan.entities;

import com.google.gson.annotations.SerializedName;

public class HangHoaDTO {
    @SerializedName("hangHoaId")
    private int hangHoaId;

    @SerializedName("maHangHoa")
    private String maHangHoa;

    @SerializedName("tenHangHoa")
    private String tenHangHoa;

    @SerializedName("donGia")
    private int donGia;

    @SerializedName("trangThai")
    private String trangThai;

    @SerializedName("nhomHangHoa")
    private String nhomHangHoa;

    public HangHoaDTO(int hangHoaId, String maHangHoa, String tenHangHoa, int donGia, String trangThai, String nhomHangHoa) {
        this.hangHoaId = hangHoaId;
        this.maHangHoa = maHangHoa;
        this.tenHangHoa = tenHangHoa;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.nhomHangHoa = nhomHangHoa;
    }
//
    public HangHoaDTO() {

    }

    public int getHangHoaId() {
        return hangHoaId;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public int getDonGia() {
        return donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getNhomHangHoa() {
        return nhomHangHoa;
    }

    public void setHangHoaId(int hangHoaId) {
        this.hangHoaId = hangHoaId;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setNhomHangHoa(String nhomHangHoa) {
        this.nhomHangHoa = nhomHangHoa;
    }
}
