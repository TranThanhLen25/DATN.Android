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
    private float donGia;

    @SerializedName("trangThai")
    private String trangThai;

    @SerializedName("nhomHangHoa")
    private String nhomHangHoa;

    public HangHoaDTO(int hangHoaId, String maHangHoa, String tenHangHoa, float donGia, String trangThai, String nhomHangHoa) {
        this.hangHoaId = hangHoaId;
        this.maHangHoa = maHangHoa;
        this.tenHangHoa = tenHangHoa;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.nhomHangHoa = nhomHangHoa;
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

    public float getDonGia() {
        return donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getNhomHangHoa() {
        return nhomHangHoa;
    }
}
