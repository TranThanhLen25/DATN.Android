package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;

public class DoiBanDTO {
    private BanDTO viTriBanDau;
    private BanDTO viTriDoi;
    private String lyDoDoi;
    private String ghiChu;

    public DoiBanDTO(BanDTO viTriBanDau, BanDTO viTriDoi, String lyDoDoi, String ghiChu) {
        this.viTriBanDau = viTriBanDau;
        this.viTriDoi = viTriDoi;
        this.lyDoDoi = lyDoDoi;
        this.ghiChu = ghiChu;
    }

    public DoiBanDTO() {
    }

    public BanDTO getViTriBanDau() {
        return viTriBanDau;
    }

    public void setViTriBanDau(BanDTO viTriBanDau) {
        this.viTriBanDau = viTriBanDau;
    }

    public BanDTO getViTriDoi() {
        return viTriDoi;
    }

    public void setViTriDoi(BanDTO viTriDoi) {
        this.viTriDoi = viTriDoi;
    }

    public String getLyDoDoi() {
        return lyDoDoi;
    }

    public void setLyDoDoi(String lyDoDoi) {
        this.lyDoDoi = lyDoDoi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
