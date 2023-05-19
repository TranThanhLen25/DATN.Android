package com.example.datnandroidquanlynhahangkhachsan.model.DichVu;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.ListDichVuDTO;

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
    ///

    void capNhatDichVu(ListDichVuDTO listDichVuDTO, IDichVuModel.IOncapNhatDichVuFinishedListener listener);

    interface IOncapNhatDichVuFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
