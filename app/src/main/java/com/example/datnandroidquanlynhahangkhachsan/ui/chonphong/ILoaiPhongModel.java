package com.example.datnandroidquanlynhahangkhachsan.ui.chonphong;

import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;


import java.util.List;

public interface ILoaiPhongModel {
    void LayLoaiPhong(ILoaiPhongModel.IOnLayLoaiPhongFinishedListener listener);

    interface IOnLayLoaiPhongFinishedListener {
        void onSuccess(List<LoaiPhongDTO> listResult);

        void onError(String error);
    }


}
