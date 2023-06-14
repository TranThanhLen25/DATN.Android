package com.example.datnandroidquanlynhahangkhachsan.model.goiMon;

import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.ListGoiMonDTO;

import java.util.List;

public interface IGoiMonModel {
    void LayDanhSachGoiMon(GoiMonDTO goiMonDTO, IGoiMonModel.IOnLayDanhSachGoiMonFinishedListener listener);

    interface IOnLayDanhSachGoiMonFinishedListener {
        void onSuccess(List<GoiMonDTO> listResult);

        void onError(String error);
    }

    void themGoiMon(ListGoiMonDTO listGoiMonDTO, IGoiMonModel.IOnthemDichVuFinishedListener listener);

    interface IOnthemDichVuFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void capNhatGoiMon(ListGoiMonDTO listGoiMonDTO, IGoiMonModel.IOncapNhatDichVuFinishedListener listener);

    interface IOncapNhatDichVuFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
