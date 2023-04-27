package com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat;

import java.util.Date;

public class PhieuXuatChiTietDTO {

    private long phieuNhanPhongChiTietId;
    private long phieuNhanId;
    private int phongId;
    private int soNguoi;
    private int trangThai;
    private Date thoiGianNhanPhong;
    private Date thoiGianTraPhong;
    private float donGia;

    public long getPhieuNhanPhongChiTietId() {
        return phieuNhanPhongChiTietId;
    }

    public void setPhieuNhanPhongChiTietId(long phieuNhanPhongChiTietId) {
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
    }

    public long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public int getPhongId() {
        return phongId;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGianNhanPhong() {
        return thoiGianNhanPhong;
    }

    public void setThoiGianNhanPhong(Date thoiGianNhanPhong) {
        this.thoiGianNhanPhong = thoiGianNhanPhong;
    }

    public Date getThoiGianTraPhong() {
        return thoiGianTraPhong;
    }

    public void setThoiGianTraPhong(Date thoiGianTraPhong) {
        this.thoiGianTraPhong = thoiGianTraPhong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public PhieuXuatChiTietDTO(long phieuNhanPhongChiTietId, long phieuNhanId, int phongId, int soNguoi, int trangThai, Date thoiGianNhanPhong, Date thoiGianTraPhong, float donGia) {
        this.phieuNhanPhongChiTietId = phieuNhanPhongChiTietId;
        this.phieuNhanId = phieuNhanId;
        this.phongId = phongId;
        this.soNguoi = soNguoi;
        this.trangThai = trangThai;
        this.thoiGianNhanPhong = thoiGianNhanPhong;
        this.thoiGianTraPhong = thoiGianTraPhong;
        this.donGia = donGia;
    }
}
