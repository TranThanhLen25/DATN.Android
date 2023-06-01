package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;

import java.util.List;

public class XuatPhongDTO {
    private PhieuXuatDTO phieuXuatDTO;
    private List<PhieuXuatChiTietDTO> phieuXuatChiTiets;

    public XuatPhongDTO(PhieuXuatDTO phieuXuatDTO, List<PhieuXuatChiTietDTO> phieuXuatChiTiets) {
        this.phieuXuatDTO = phieuXuatDTO;
        this.phieuXuatChiTiets = phieuXuatChiTiets;
    }

    public PhieuXuatDTO getPhieuXuatDTO() {
        return phieuXuatDTO;
    }

    public void setPhieuXuatDTO(PhieuXuatDTO phieuXuatDTO) {
        this.phieuXuatDTO = phieuXuatDTO;
    }

    public List<PhieuXuatChiTietDTO> getPhieuXuatChiTiets() {
        return phieuXuatChiTiets;
    }

    public void setPhieuXuatChiTiets(List<PhieuXuatChiTietDTO> phieuXuatChiTiets) {
        this.phieuXuatChiTiets = phieuXuatChiTiets;
    }
}
