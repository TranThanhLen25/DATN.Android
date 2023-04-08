package com.example.datnandroidquanlynhahangkhachsan.entities;


import com.example.datnandroidquanlynhahangkhachsan.model.hanghoa.HangHoaModel;
import com.example.datnandroidquanlynhahangkhachsan.model.hanghoa.IHangHoaModel;

import java.util.List;

public class PhongDTO {
    private int phongId;
    private int loaiPhongId;
    private int trangThaiId;
    private int soPhong;
    private int tang;
    private  int donGia;
    private String tenLoaiPhong;
    private String maLoaiPhong;

    public int getPhongId() {
        return phongId;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public int getLoaiPhongId() {
        return loaiPhongId;
    }

    public void setLoaiPhongId(int loaiPhongId) {
        this.loaiPhongId = loaiPhongId;
    }

    public int getTrangThaiId() {
        return trangThaiId;
    }

    public void setTrangThaiId(int trangThaiId) {
        this.trangThaiId = trangThaiId;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }


    public PhongDTO(int phongId, int loaiPhongId, int trangThaiId, int soPhong, int tang, int donGia, String tenLoaiPhong, String maLoaiPhong) {
        this.phongId = phongId;
        this.loaiPhongId = loaiPhongId;
        this.trangThaiId = trangThaiId;
        this.soPhong = soPhong;
        this.tang = tang;
        this.donGia = donGia;
        this.tenLoaiPhong = tenLoaiPhong;
        this.maLoaiPhong = maLoaiPhong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public PhongDTO(int soPhong) {
        this.soPhong = soPhong;
    }
}
