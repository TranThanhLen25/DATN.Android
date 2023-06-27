package com.example.datnandroidquanlynhahangkhachsan.model.phong;


import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DoiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;


import java.util.List;

public interface IPhongModel {


    void LayDanhSachPhong(IOnLayDanhSachPhongFinishedListener listener);

    interface IOnLayDanhSachPhongFinishedListener {
        void onSuccess(List<PhongDTO> listResult);

        void onError(String error);
    }


    void LayDanhSachPhong1g(int id,int trangThaiId, IPhongModel.IOnLayDanhSachPhong1gFinishedListener listener);

    interface IOnLayDanhSachPhong1gFinishedListener {
        void onSuccess(List<PhongDTO> listResult);

        void onError(String error);
    }

    void CapNhatTrangThaiPhong(PhongDTO phongDTO, IPhongModel.IOnCapNhatTrangThaiPhongFinishedListener listener);

    interface IOnCapNhatTrangThaiPhongFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void DoiPhong(DoiPhongDTO doiPhongDTO, IPhongModel.IOnDoiPhongFinishedListener listener);

    interface IOnDoiPhongFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
