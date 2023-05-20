package com.example.datnandroidquanlynhahangkhachsan.entities.DichVu;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//
public class ListDichVuDTO {


    //danh sách dịch vụ phân biệt để thêm vào csdl
    @SerializedName("dichVuDTOsBanDau")
    private List<DichVuDTO> listDichVuBanDau;
    @SerializedName("dichVuDTOsThem")
    private List<DichVuDTO> listDichVuThem;
    @SerializedName("dichVuDTOsCapNhat")
    private List<DichVuDTO> listDichVuCapNhat;


    public ListDichVuDTO(List<DichVuDTO> listDichVuCapNhat, List<DichVuDTO> listDichVuThem) {
        this.listDichVuCapNhat = listDichVuCapNhat;
        this.listDichVuThem = listDichVuThem;
    }

    public ListDichVuDTO(List<DichVuDTO> listDichVuCapNhat) {
        this.listDichVuCapNhat = listDichVuCapNhat;
    }

    public List<DichVuDTO> getListDichVuBanDau() {
        return listDichVuBanDau;
    }

    public void setListDichVuBanDau(List<DichVuDTO> listDichVuBanDau) {
        this.listDichVuBanDau = listDichVuBanDau;
    }

    public List<DichVuDTO> getListDichVuCapNhat() {
        return listDichVuCapNhat;
    }

    public void setListDichVuCapNhat(List<DichVuDTO> listDichVuCapNhat) {
        this.listDichVuCapNhat = listDichVuCapNhat;
    }

    public List<DichVuDTO> getListDichVuThem() {
        return listDichVuThem;
    }

    public void setListDichVuThem(List<DichVuDTO> listDichVuThem) {
        this.listDichVuThem = listDichVuThem;
    }

}
