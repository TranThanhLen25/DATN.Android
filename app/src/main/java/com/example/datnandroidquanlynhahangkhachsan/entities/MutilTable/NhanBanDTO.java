package com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NhanBanDTO {
    @SerializedName("phieuNhanDTO")
    PhieuNhanDTO phieuNhanDTO;
    @SerializedName("phieuNhanBanChiTietDTOs")
    List<PhieuNhanBanChiTietDTO> phieuNhanBanChiTietDTOs;
    @SerializedName("khachHang")
    KhachHangDTO khachHang;

    public NhanBanDTO() {
    }

    public NhanBanDTO(PhieuNhanDTO phieuNhanDTO, List<PhieuNhanBanChiTietDTO> phieuNhanBanChiTietDTOs, KhachHangDTO khachHang) {
        this.phieuNhanDTO = phieuNhanDTO;
        this.phieuNhanBanChiTietDTOs = phieuNhanBanChiTietDTOs;
        this.khachHang = khachHang;
    }

    public PhieuNhanDTO getPhieuNhanDTO() {
        return phieuNhanDTO;
    }

    public void setPhieuNhanDTO(PhieuNhanDTO phieuNhanDTO) {
        this.phieuNhanDTO = phieuNhanDTO;
    }

    public List<PhieuNhanBanChiTietDTO> getPhieuNhanBanChiTietDTOs() {
        return phieuNhanBanChiTietDTOs;
    }

    public void setPhieuNhanBanChiTietDTOs(List<PhieuNhanBanChiTietDTO> phieuNhanBanChiTietDTOs) {
        this.phieuNhanBanChiTietDTOs = phieuNhanBanChiTietDTOs;
    }

    public KhachHangDTO getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHangDTO khachHang) {
        this.khachHang = khachHang;
    }
}
