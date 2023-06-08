package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatPhongDTO {
    @SerializedName("phieuDatDTO")
    private PhieuDatDTO phieuDatDTO;
    @SerializedName("phieuDatPhongChiTiets")
    private List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTiets;

    private KhachHangDTO khachHang;

    public DatPhongDTO() {
    }

    public DatPhongDTO(PhieuDatDTO phieuDatDTO, List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTiets) {
        this.phieuDatDTO = phieuDatDTO;
        this.phieuDatPhongChiTiets = phieuDatPhongChiTiets;
    }

    public DatPhongDTO(PhieuDatDTO phieuDatDTO, List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTiets, KhachHangDTO khachHang) {
        this.phieuDatDTO = phieuDatDTO;
        this.phieuDatPhongChiTiets = phieuDatPhongChiTiets;
        this.khachHang = khachHang;
    }

    public PhieuDatDTO getPhieuDatDTO() {
        return phieuDatDTO;
    }

    public void setPhieuDatDTO(PhieuDatDTO phieuDatDTO) {
        this.phieuDatDTO = phieuDatDTO;
    }

    public List<PhieuDatPhongChiTietDTO> getPhieuDatPhongChiTiets() {
        return phieuDatPhongChiTiets;
    }

    public void setPhieuDatPhongChiTiets(List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTiets) {
        this.phieuDatPhongChiTiets = phieuDatPhongChiTiets;
    }

    public Boolean checkSoLuong() {
        if (phieuDatPhongChiTiets.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
