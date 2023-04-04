package com.example.datnandroidquanlynhahangkhachsan.phong;




import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;


import java.util.List;

public interface    IDanhSachPhongModel {




    void LayDanhSachPhong(IDanhSachPhongModel.IOnLayDanhSachPhongFinishedListener listener);

    interface IOnLayDanhSachPhongFinishedListener {
        void onSuccess(List<PhongDTO> listResult);

        void onError(String error);
    }
}
