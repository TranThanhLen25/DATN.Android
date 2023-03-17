package com.example.datnandroidquanlynhahangkhachsan.model;

public class HangHoa {
    private int HangHoaID;
    private String MaHangHoa;
    private String TenHangHoa;
    private float DonGia;
    private String TrangThai;
    private String NhomHangHoa;

    public HangHoa(int hangHoaID, String maHangHoa, String tenHangHoa, float donGia, String trangThai, String nhomHangHoa) {
        HangHoaID = hangHoaID;
        MaHangHoa = maHangHoa;
        TenHangHoa = tenHangHoa;
        DonGia = donGia;
        TrangThai = trangThai;
        NhomHangHoa = nhomHangHoa;
    }

    public int getHangHoaID() {
        return HangHoaID;
    }

    public void setHangHoaID(int hangHoaID) {
        HangHoaID = hangHoaID;
    }

    public String getMaHangHoa() {
        return MaHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        MaHangHoa = maHangHoa;
    }

    public String getTenHangHoa() {
        return TenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        TenHangHoa = tenHangHoa;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float donGia) {
        DonGia = donGia;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public String getNhomHangHoa() {
        return NhomHangHoa;
    }

    public void setNhomHangHoa(String nhomHangHoa) {
        NhomHangHoa = nhomHangHoa;
    }
}