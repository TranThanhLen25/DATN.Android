package com.example.datnandroidquanlynhahangkhachsan.model.hanghoa;


import com.example.datnandroidquanlynhahangkhachsan.entities.DieuKienLocHangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;

import java.util.List;

public interface IHangHoaModel {
    void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc, IOnLayDanhSachHangHoaFinishedListener listener);
//
    interface IOnLayDanhSachHangHoaFinishedListener {
        void onSuccess(List<HangHoaDTO> listResult);

        void onError(String error);
    }

    void LayDanhSachHangHoa2(String NhomHangHoa, IOnLayDanhSachHangHoa2FinishedListener listener);

    interface IOnLayDanhSachHangHoa2FinishedListener {
        void onSuccess(List<HangHoaDTO> listResult);

        void onError(String error);
    }

    void themHangHoa(HangHoaDTO hangHoaDTO, IOnThemHangHoaFinishedListener listener);

    interface IOnThemHangHoaFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void xoaHangHoa(int hangHoaID, IOnXoaHangHoaFinishedListener listener);

    interface IOnXoaHangHoaFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
