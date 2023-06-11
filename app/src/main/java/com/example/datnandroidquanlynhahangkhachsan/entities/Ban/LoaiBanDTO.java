package com.example.datnandroidquanlynhahangkhachsan.entities.Ban;

import com.google.gson.annotations.SerializedName;

public class LoaiBanDTO {
    @SerializedName("loaiBanId")
    private int loaiBanId;
    @SerializedName("tenLoaiBan")
    private String tenLoaiBan;
    @SerializedName("soNguoiToiDa")
    private int soNguoiToiDa;

    public int getLoaiBanId() {
        return loaiBanId;
    }

    public void setLoaiBanId(int loaiBanId) {
        this.loaiBanId = loaiBanId;
    }

    public String getTenLoaiBan() {
        return tenLoaiBan;
    }

    public void setTenLoaiBan(String tenLoaiBan) {
        this.tenLoaiBan = tenLoaiBan;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }
}
