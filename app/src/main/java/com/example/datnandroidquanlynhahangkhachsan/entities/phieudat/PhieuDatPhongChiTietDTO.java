package com.example.datnandroidquanlynhahangkhachsan.entities.phieudat;

import com.google.gson.annotations.SerializedName;

public class PhieuDatPhongChiTietDTO {
    @SerializedName("phieuDatPhongChiTietId")
    public long PhieuDatPhongChiTietId;
    @SerializedName("phieuDatId")
    public long PhieuDatId;
    @SerializedName("loaiPhongId")
    public int LoaiPhongId;
    @SerializedName("soLuong")
    public int SoLuong;

    public PhieuDatPhongChiTietDTO(long phieuDatId, int loaiPhongId, int soLuong) {
        PhieuDatId = phieuDatId;
        LoaiPhongId = loaiPhongId;
        SoLuong = soLuong;
    }

    public long getPhieuDatPhongChiTietId() {
        return PhieuDatPhongChiTietId;
    }

    public void setPhieuDatPhongChiTietId(long phieuDatPhongChiTietId) {
        PhieuDatPhongChiTietId = phieuDatPhongChiTietId;
    }

    public long getPhieuDatId() {
        return PhieuDatId;
    }

    public void setPhieuDatId(long phieuDatId) {
        PhieuDatId = phieuDatId;
    }

    public int getLoaiPhongId() {
        return LoaiPhongId;
    }

    public void setLoaiPhongId(int loaiPhongId) {
        LoaiPhongId = loaiPhongId;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
