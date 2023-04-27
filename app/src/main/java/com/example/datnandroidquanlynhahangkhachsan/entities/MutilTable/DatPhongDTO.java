package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;

import java.util.List;

public class DatPhongDTO {
    private PhieuDatDTO phieuDatDTO;
    private List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOS;

    public DatPhongDTO(PhieuDatDTO phieuDatDTO, List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOS) {
        this.phieuDatDTO = phieuDatDTO;
        this.phieuDatPhongChiTietDTOS = phieuDatPhongChiTietDTOS;
    }

    public PhieuDatDTO getPhieuDatDTO() {
        return phieuDatDTO;
    }

    public void setPhieuDatDTO(PhieuDatDTO phieuDatDTO) {
        this.phieuDatDTO = phieuDatDTO;
    }

    public List<PhieuDatPhongChiTietDTO> getPhieuDatPhongChiTietDTOS() {
        return phieuDatPhongChiTietDTOS;
    }

    public void setPhieuDatPhongChiTietDTOS(List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOS) {
        this.phieuDatPhongChiTietDTOS = phieuDatPhongChiTietDTOS;
    }
}
