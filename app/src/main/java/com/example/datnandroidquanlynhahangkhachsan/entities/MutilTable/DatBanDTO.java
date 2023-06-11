package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatBanDTO {

    @SerializedName("phieuDatDTO")
    private PhieuDatDTO phieuDatDTO;
    @SerializedName("phieuDatBanChiTiets")
    private List<PhieuDatBanChiTietDTO> phieuDatBanChiTiets;

    private KhachHangDTO khachHang;

    public DatBanDTO() {
    }

    public DatBanDTO(PhieuDatDTO phieuDatDTO, List<PhieuDatBanChiTietDTO> phieuDatBanChiTiets, KhachHangDTO khachHang) {
        this.phieuDatDTO = phieuDatDTO;
        this.phieuDatBanChiTiets = phieuDatBanChiTiets;
        this.khachHang = khachHang;
    }

    public DatBanDTO(PhieuDatDTO phieuDatDTO, List<PhieuDatBanChiTietDTO> phieuDatBanChiTiets) {
        this.phieuDatDTO = phieuDatDTO;
        this.phieuDatBanChiTiets = phieuDatBanChiTiets;
    }

    public PhieuDatDTO getPhieuDatDTO() {
        return phieuDatDTO;
    }

    public void setPhieuDatDTO(PhieuDatDTO phieuDatDTO) {
        this.phieuDatDTO = phieuDatDTO;
    }

    public List<PhieuDatBanChiTietDTO> getPhieuDatBanChiTiets() {
        return phieuDatBanChiTiets;
    }

    public void setPhieuDatBanChiTiets(List<PhieuDatBanChiTietDTO> phieuDatBanChiTiets) {
        this.phieuDatBanChiTiets = phieuDatBanChiTiets;
    }

    public KhachHangDTO getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHangDTO khachHang) {
        this.khachHang = khachHang;
    }
}
