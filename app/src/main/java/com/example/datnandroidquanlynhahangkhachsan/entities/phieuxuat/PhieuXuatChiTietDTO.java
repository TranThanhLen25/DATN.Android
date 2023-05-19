package com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat;

public class PhieuXuatChiTietDTO {

    private long phieuXuatChiTietId;
    private long phieuXuatId;
    private int hangHoaId;
    private int soLuong;
    private int donGia;
    private int thanhTien;
    private String donViTinh;
    private String ghiChu;

    private long phieuNhanPhongChiTietId;
    private long phieuNhanBanChitietId;

    public PhieuXuatChiTietDTO(long phieuXuatChiTietId, long phieuXuatId, int hangHoaId, int soLuong, int donGia, int thanhTien, String donViTinh, String ghiChu, long phieuNhanPhongChiTietId, long phieuNhanBanChitietId) {
        this.phieuXuatChiTietId = phieuXuatChiTietId;
        this.phieuXuatId = phieuXuatId;
        this.hangHoaId = hangHoaId;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.donViTinh = donViTinh;
        this.ghiChu = ghiChu;
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
        this.phieuNhanBanChitietId = phieuNhanBanChitietId;
    }

    public long getPhieuXuatChiTietId() {
        return phieuXuatChiTietId;
    }

    public void setPhieuXuatChiTietId(long phieuXuatChiTietId) {
        this.phieuXuatChiTietId = phieuXuatChiTietId;
    }

    public long getPhieuXuatId() {
        return phieuXuatId;
    }

    public void setPhieuXuatId(long phieuXuatId) {
        this.phieuXuatId = phieuXuatId;
    }

    public int getHangHoaId() {
        return hangHoaId;
    }

    public void setHangHoaId(int hangHoaId) {
        this.hangHoaId = hangHoaId;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public long getPhieuNhanPhongChiTietId() {
        return phieuNhanPhongChiTietId;
    }

    public void setPhieuNhanPhongChiTietId(long phieuNhanPhongChiTietId) {
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
    }

    public long getPhieuNhanBanChitietId() {
        return phieuNhanBanChitietId;
    }

    public void setPhieuNhanBanChitietId(long phieuNhanBanChitietId) {
        this.phieuNhanBanChitietId = phieuNhanBanChitietId;
    }
}
