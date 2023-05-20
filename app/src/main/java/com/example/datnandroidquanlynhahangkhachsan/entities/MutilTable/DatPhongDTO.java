package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DatPhongDTO {
    @SerializedName("phieuDatDTO")
    private PhieuDatDTO phieuDatDTO;
    @SerializedName("phieuDatPhongChiTiets")
    private List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTiets;

    public DatPhongDTO(PhieuDatDTO phieuDatDTO, List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTiets) {
        this.phieuDatDTO = phieuDatDTO;
        this.phieuDatPhongChiTiets = phieuDatPhongChiTiets;
    }
//
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
}
