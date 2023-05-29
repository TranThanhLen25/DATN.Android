package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;

import java.util.List;

public class NhanPhongDTO {
    private PhieuNhanDTO phieuNhanDTO;
    private List<PhieuNhanPhongChiTietDTO> phieuNhanPhongChiTietDTOs;

    private KhachHangDTO khachHang;

    public NhanPhongDTO(PhieuNhanDTO phieuNhanDTO, List<PhieuNhanPhongChiTietDTO> phieuNhanPhongChiTietDTOs, KhachHangDTO khachHang) {
        this.phieuNhanDTO = phieuNhanDTO;
        this.phieuNhanPhongChiTietDTOs = phieuNhanPhongChiTietDTOs;
        this.khachHang = khachHang;
    }

    public PhieuNhanDTO getPhieuNhanDTO() {
        return phieuNhanDTO;
    }

    public void setPhieuNhanDTO(PhieuNhanDTO phieuNhanDTO) {
        this.phieuNhanDTO = phieuNhanDTO;
    }

    public List<PhieuNhanPhongChiTietDTO> getPhieuNhanPhongChiTietDTOs() {
        return phieuNhanPhongChiTietDTOs;
    }

    public void setPhieuNhanPhongChiTietDTOs(List<PhieuNhanPhongChiTietDTO> phieuNhanPhongChiTietDTOs) {
        this.phieuNhanPhongChiTietDTOs = phieuNhanPhongChiTietDTOs;
    }

    public KhachHangDTO getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHangDTO khachHang) {
        this.khachHang = khachHang;
    }
}
