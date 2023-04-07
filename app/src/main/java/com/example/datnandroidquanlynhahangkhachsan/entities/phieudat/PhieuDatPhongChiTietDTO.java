package com.example.datnandroidquanlynhahangkhachsan.entities.phieudat;

import com.google.gson.annotations.SerializedName;

public class PhieuDatPhongChiTietDTO {
    @SerializedName("phieuDatPhongChiTietId")
    public long PhieuDatPhongChiTietId;
    @SerializedName("phieuDatId")
    public long PhieuDatId;
    @SerializedName("phongId")
    public int PhongId;
    @SerializedName("soNguoi")
    public int SoNguoi;

    public PhieuDatPhongChiTietDTO(long phieuDatId, int phongId, int soNguoi) {
        PhieuDatId = phieuDatId;
        PhongId = phongId;
        SoNguoi = soNguoi;
    }

    public long getPhieuDatPhongChiTietId() {
        return PhieuDatPhongChiTietId;
    }

    public long getPhieuDatId() {
        return PhieuDatId;
    }

    public int getPhongId() {
        return PhongId;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }
}
