package com.example.datnandroidquanlynhahangkhachsan.entities;

public class PhieuNhapChiTietDTO {

    private int phieuNhapChiTietId;
    private int phieuNhapId;
    private int khoId;
    private int tenMatHang;
    private int soLuong;
    private int gia;
    private int thanhTien;
    private String donViTinh;
    private int hangHoaId ;
    private String ghiChu;

    public PhieuNhapChiTietDTO(int phieuNhapChiTietId, int phieuNhapId, int khoId, int tenMatHang, int soLuong, int gia, int thanhTien, String donViTinh, int hangHoaId, String ghiChu) {

        this.phieuNhapChiTietId = phieuNhapChiTietId;
        this.phieuNhapId = phieuNhapId;
        this.khoId = khoId;
        this.tenMatHang = tenMatHang;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = thanhTien;
        this.donViTinh = donViTinh;
        this.hangHoaId = hangHoaId;
        this.ghiChu = ghiChu;
    }

    public int getPhieuNhapChiTietId() {
        return phieuNhapChiTietId;
    }

    public void setPhieuNhapChiTietId(int phieuNhapChiTietId) {
        this.phieuNhapChiTietId = phieuNhapChiTietId;
    }

    public int getPhieuNhapId() {
        return phieuNhapId;
    }

    public void setPhieuNhapId(int phieuNhapId) {
        this.phieuNhapId = phieuNhapId;
    }

    public int getKhoId() {
        return khoId;
    }

    public void setKhoId(int khoId) {
        this.khoId = khoId;
    }

    public int getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(int tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
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

    public int getHangHoaId() {
        return hangHoaId;
    }

    public void setHangHoaId(int hangHoaId) {
        this.hangHoaId = hangHoaId;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
