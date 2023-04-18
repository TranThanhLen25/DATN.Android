package com.example.datnandroidquanlynhahangkhachsan.entities;

public class LoaiPhongDTO {
    public int loaiPhongId;
    public String maLoaiPhong;
    public  String tenLoaiPhong;
    public int soNguoiToiDa;

    public int donGia;

    public LoaiPhongDTO(int loaiPhongId, String maLoaiPhong, String tenLoaiPhong, int soNguoiToiDa, int donGia) {
        this.loaiPhongId = loaiPhongId;
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.soNguoiToiDa = soNguoiToiDa;
        this.donGia = donGia;
    }

    public LoaiPhongDTO() {
    }

    public int getLoaiPhongId() {
        return loaiPhongId;
    }

    public void setLoaiPhongId(int loaiPhongId) {
        this.loaiPhongId = loaiPhongId;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public LoaiPhongDTO(String tenLoaiPhong) {

        this.tenLoaiPhong = tenLoaiPhong;

    }

    @Override
    public String toString() {
        return tenLoaiPhong ;
    }
}
