package com.example.datnandroidquanlynhahangkhachsan.model.DichVu;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.hanghoa.IHangHoaModel;

import java.util.List;

public interface IDichVuModel {

    void LayDanhSachDichVu(DichVuDTO dichVuDTO, IDichVuModel.IOnLayDanhSachDichVuFinishedListener listener);

    interface IOnLayDanhSachDichVuFinishedListener {
        void onSuccess(List<DichVuDTO> listResult);

        void onError(String error);
    }

    void themDichVu(DichVuDTO dichVuDTO, IDichVuModel.IOnthemDichVuFinishedListener listener);

    interface IOnthemDichVuFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
