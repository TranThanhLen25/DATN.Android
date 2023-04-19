package com.example.datnandroidquanlynhahangkhachsan.model.loaiphong;

import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;


import java.util.List;

public interface ILoaiPhongModel {
    void LayLoaiPhong(ILoaiPhongModel.IOnLayLoaiPhongFinishedListener listener);

    interface IOnLayLoaiPhongFinishedListener {
        void onSuccess(List<LoaiPhongDTO> listResult);

        void onError(String error);
    }


}
