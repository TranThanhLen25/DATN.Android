package com.example.datnandroidquanlynhahangkhachsan.entities.Ban;

public class BanDTO {
    private int banId;
    private int loaiBanId;
    private int trangThaiId;
    private String tenBan;

    public int getBanId() {
        return banId;
    }

    public void setBanId(int banId) {
        this.banId = banId;
    }

    public int getLoaiBanId() {
        return loaiBanId;
    }

    public void setLoaiBanId(int loaiBanId) {
        this.loaiBanId = loaiBanId;
    }

    public int getTrangThaiId() {
        return trangThaiId;
    }

    public void setTrangThaiId(int trangThaiId) {
        this.trangThaiId = trangThaiId;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }
}
