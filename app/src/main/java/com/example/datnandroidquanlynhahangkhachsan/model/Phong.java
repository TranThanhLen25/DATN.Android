package com.example.datnandroidquanlynhahangkhachsan.model;

public class Phong {
    private int PhongID;
    private int LoaiPhongID;
    private int TrangThaiID;

    private int SoPhong;
    private int Tang;

    public int getPhongID() {
        return PhongID;
    }

    public void setPhongID(int phongID) {
        PhongID = phongID;
    }

    public int getLoaiPhongID() {
        return LoaiPhongID;
    }

    public void setLoaiPhongID(int loaiPhongID) {
        LoaiPhongID = loaiPhongID;
    }

    public int getTrangThaiID() {
        return TrangThaiID;
    }

    public void setTrangThaiID(int trangThaiID) {
        TrangThaiID = trangThaiID;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(int soPhong) {
        SoPhong = soPhong;
    }

    public int getTang() {
        return Tang;
    }

    public void setTang(int tang) {
        Tang = tang;
    }

    public Phong(int loaiPhongID,int soPhong, int tang) {

        LoaiPhongID = loaiPhongID;

        SoPhong = soPhong;
        Tang = tang;
    }
}
