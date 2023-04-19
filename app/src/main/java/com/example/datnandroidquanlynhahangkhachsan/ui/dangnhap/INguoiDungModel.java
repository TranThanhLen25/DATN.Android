package com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;

import java.util.List;

public interface INguoiDungModel {
    void LayNguoiDung(INguoiDungModel.IOnLayNguoiDungFinishedListener listener);

    interface IOnLayNguoiDungFinishedListener {
        void onSuccess(List<NguoiDungDTO> listResult);

        void onError(String error);
    }
    void LayNguoiDungID(int nguoiDung,INguoiDungModel.IOnLayNguoiDungIDFinishedListener listener);

    interface IOnLayNguoiDungIDFinishedListener {
        void onSuccess(List<NguoiDungDTO> listResult);

        void onError(String error);
    }


}
