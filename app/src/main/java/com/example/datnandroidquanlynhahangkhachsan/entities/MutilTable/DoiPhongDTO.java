package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.google.gson.annotations.SerializedName;

public class DoiPhongDTO {
    @SerializedName("viTriBanDau")
    private PhongDTO viTriBanDau;
    @SerializedName("viTriDoi")
    private PhongDTO viTriDoi;
    @SerializedName("lyDoDoi")
    private String lyDoDoi;
    @SerializedName("ghiChu")
    private String ghiChu;

    public DoiPhongDTO() {
    }

    public DoiPhongDTO(PhongDTO viTriDoi, String lyDoDoi, String ghiChu) {
        this.viTriDoi = viTriDoi;
        this.lyDoDoi = lyDoDoi;
        this.ghiChu = ghiChu;
    }

    public PhongDTO getViTriBanDau() {
        return viTriBanDau;
    }

    public void setViTriBanDau(PhongDTO viTriBanDau) {
        this.viTriBanDau = viTriBanDau;
    }

    public PhongDTO getViTriDoi() {
        return viTriDoi;
    }

    public void setViTriDoi(PhongDTO viTriDoi) {
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
