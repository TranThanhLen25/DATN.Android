package com.example.datnandroidquanlynhahangkhachsan.model.DichVu;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.ListDichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phong.IPhongModel;

import java.util.List;

public interface IDichVuModel {

    void LayDanhSachDichVu(DichVuDTO dichVuDTO, IDichVuModel.IOnLayDanhSachDichVuFinishedListener listener);

    interface IOnLayDanhSachDichVuFinishedListener {
        void onSuccess(List<DichVuDTO> listResult);

        void onError(String error);
    }

    void themDichVu(ListDichVuDTO listDichVuDTO, IDichVuModel.IOnthemDichVuFinishedListener listener);

    interface IOnthemDichVuFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void capNhatDichVu(ListDichVuDTO listDichVuDTO, IDichVuModel.IOncapNhatDichVuFinishedListener listener);

    interface IOncapNhatDichVuFinishedListener {
        void onSuccess();

        void onError(String error);
    }
    void LayDvPn(DichVuDTO dichVuDTO, IDichVuModel.IOnLayDvPnFinishedListener listener);

    interface IOnLayDvPnFinishedListener {
        void onSuccess(List<DichVuDTO> listResult);

        void onError(String error);
    }

    void CapNhatDV(DichVuDTO dichVuDTO, IDichVuModel.IOnCapNhatDVFinishedListener listener);

    interface IOnCapNhatDVFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
