package com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong;




import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;


import java.util.List;

public interface    IDanhSachPhongModel {




    void LayDanhSachPhong(IOnLayDanhSachPhongFinishedListener listener);

    interface IOnLayDanhSachPhongFinishedListener {
        void onSuccess(List<PhongDTO> listResult);

        void onError(String error);
    }
}