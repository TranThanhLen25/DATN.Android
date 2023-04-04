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

    public PhongDTO(int phongId, int loaiPhongId, int trangThaiId, int soPhong, int tang) {

        this.loaiPhongId = loaiPhongId;

        this.soPhong = soPhong;
        this.tang = tang;
    }
}
