package com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan;

import java.util.Date;

public class PhieuNhanDTO {

    private Long phieuNhanId;
    private String soChungTu;
    private Date ngayLap;
    private int nguoiDungId;
    private int loaiPhieuId;
    private Date ngayTra;
    private Long khachHangId;
    private String ghiChu;
    private String trangThai;


    public PhieuNhanDTO(String soChungTu, Date ngayLap, int nguoiDungId, int loaiPhieuId, Date ngayTra, Long khachHangId, String ghiChu, String trangThai) {
        this.soChungTu = soChungTu;
        this.ngayLap = ngayLap;
        this.nguoiDungId = nguoiDungId;
        this.loaiPhieuId = loaiPhieuId;
        this.ngayTra = ngayTra;
        this.khachHangId = khachHangId;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public PhieuNhanDTO() {
    }

    public Long getPhieuNhanId() {
        return phieuNhanId;
    }

    public void setPhieuNhanId(Long phieuNhanId) {
        this.phieuNhanId = phieuNhanId;
    }

    public String getSoChungTu() {
        return soChungTu;
    }

    public void setSoChungTu(String soChungTu) {
        this.soChungTu = soChungTu;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(int nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }

    public int getLoaiPhieuId() {
        return loaiPhieuId;
    }

    public void setLoaiPhieuId(int loaiPhieuId) {
        this.loaiPhieuId = loaiPhieuId;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Long getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(Long khachHangId) {
        this.khachHangId = khachHangId;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

