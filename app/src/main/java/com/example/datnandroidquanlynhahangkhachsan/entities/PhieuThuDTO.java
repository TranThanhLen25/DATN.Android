package com.example.datnandroidquanlynhahangkhachsan.entities;

import java.util.Date;

public class PhieuThuDTO {
     private int phieuThuId;
     private String soChungTu;
     private Date ngayLap;
     private float soTienCanThanhToan;
     private float soTienKhachDua;
     private float soTienTraLaiKhach;
     private String phuongThucThanhToan;
     private String soTk;
     private long phieuNhanId;
     private String ghiChu;

     public PhieuThuDTO(String soChungTu, Date ngayLap, float soTienCanThanhToan, float soTienKhachDua, float soTienTraLaiKhach, String phuongThucThanhToan, String soTk, long phieuNhanId, String ghiChu) {
          this.soChungTu = soChungTu;
          this.ngayLap = ngayLap;
          this.soTienCanThanhToan = soTienCanThanhToan;
          this.soTienKhachDua = soTienKhachDua;
          this.soTienTraLaiKhach = soTienTraLaiKhach;
          this.phuongThucThanhToan = phuongThucThanhToan;
          this.soTk = soTk;
          this.phieuNhanId = phieuNhanId;
          this.ghiChu = ghiChu;
     }


     public int getPhieuThuId() {
          return phieuThuId;
     }

     public void setPhieuThuId(int phieuThuId) {
          this.phieuThuId = phieuThuId;
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

     public float getSoTienCanThanhToan() {
          return soTienCanThanhToan;
     }

     public void setSoTienCanThanhToan(float soTienCanThanhToan) {
          this.soTienCanThanhToan = soTienCanThanhToan;
     }

     public float getSoTienKhachDua() {
          return soTienKhachDua;
     }

     public void setSoTienKhachDua(float soTienKhachDua) {
          this.soTienKhachDua = soTienKhachDua;
     }

     public float getSoTienTraLaiKhach() {
          return soTienTraLaiKhach;
     }

     public void setSoTienTraLaiKhach(float soTienTraLaiKhach) {
          this.soTienTraLaiKhach = soTienTraLaiKhach;
     }

     public String getPhuongThucThanhToan() {
          return phuongThucThanhToan;
     }

     public void setPhuongThucThanhToan(String phuongThucThanhToan) {
          this.phuongThucThanhToan = phuongThucThanhToan;
     }

     public String getSoTk() {
          return soTk;
     }

     public void setSoTk(String soTk) {
          this.soTk = soTk;
     }

     public long getPhieuNhanId() {
          return phieuNhanId;
     }

     public void setPhieuNhanId(long phieuNhanId) {
          this.phieuNhanId = phieuNhanId;
     }

     public String getGhiChu() {
          return ghiChu;
     }

     public void setGhiChu(String ghiChu) {
          this.ghiChu = ghiChu;
     }
}
