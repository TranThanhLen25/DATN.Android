package com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat;

import com.google.gson.annotations.SerializedName;

public class PhieuXuatChiTietDTO {


    @SerializedName("phieuXuatChiTietId")
    private long phieuXuatChiTietId;

    @SerializedName("phieuXuatId")
    private long phieuXuatId;

    @SerializedName("hangHoaId")
    private int hangHoaId;

    @SerializedName("soLuong")
    private double soLuong;

    @SerializedName("donGia")
    private double donGia;

    @SerializedName("thanhTien")
    private double thanhTien;

    @SerializedName("donViTinh")
    private String donViTinh;

    @SerializedName("ghiChu")
    private String ghiChu;

    @SerializedName("phieuNhanPhongChiTietId")
    private long phieuNhanPhongChiTietId;

    @SerializedName("phieuNhanBanChiTietId")
    private long phieuNhanBanChiTietId;

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

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
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

    public long getPhieuNhanBanChiTietId() {
        return phieuNhanBanChiTietId;
    }

    public void setPhieuNhanBanChiTietId(long phieuNhanBanChiTietId) {
        this.phieuNhanBanChiTietId = phieuNhanBanChiTietId;
    }

    public PhieuXuatChiTietDTO(long phieuXuatId, int hangHoaId, double soLuong, double donGia, double thanhTien, String donViTinh, String ghiChu, long phieuNhanPhongChiTietId) {
        this.phieuXuatId = phieuXuatId;
        this.hangHoaId = hangHoaId;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.donViTinh = donViTinh;
        this.ghiChu = ghiChu;
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;

    }

    public PhieuXuatChiTietDTO(int hangHoaId, double soLuong, double donGia, double thanhTien, String donViTinh, String ghiChu, long phieuNhanPhongChiTietId) {
        this.hangHoaId = hangHoaId;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.donViTinh = donViTinh;
        this.ghiChu = ghiChu;
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
    }

    public PhieuXuatChiTietDTO(int hangHoaId, double soLuong, double donGia, double thanhTien, String donViTinh, String ghiChu, long phieuNhanPhongChiTietId, long phieuNhanBanChiTietId) {
        this.hangHoaId = hangHoaId;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.donViTinh = donViTinh;
        this.ghiChu = ghiChu;
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
        this.phieuNhanBanChiTietId = phieuNhanBanChiTietId;
    }

    public PhieuXuatChiTietDTO(long phieuXuatId, int hangHoaId, double soLuong, double donGia, double thanhTien, String donViTinh, String ghiChu, long phieuNhanPhongChiTietId, long phieuNhanBanChiTietId) {
        this.phieuXuatId = phieuXuatId;
        this.hangHoaId = hangHoaId;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.donViTinh = donViTinh;
        this.ghiChu = ghiChu;
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
        this.phieuNhanBanChiTietId = phieuNhanBanChiTietId;
    }
}
