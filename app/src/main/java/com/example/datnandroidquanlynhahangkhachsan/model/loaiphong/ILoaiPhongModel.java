package com.example.datnandroidquanlynhahangkhachsan.model.loaiphong;

import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;


import java.util.List;

public interface ILoaiPhongModel {
    void LayLoaiPhong(ILoaiPhongModel.IOnLayLoaiPhongFinishedListener listener);

    interface IOnLayLoaiPhongFinishedListener {
        void onSuccess(List<LoaiPhongDTO> listResult);

        void onError(String error);
    }
    void LayLoaiBan(ILoaiPhongModel.IOnLayLoaiBanFinishedListener listener);

    interface IOnLayLoaiBanFinishedListener {
        void onSuccess(List<LoaiBanDTO> listResult);

        void onError(String error);
    }

}
