package com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap;

import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.KhachHang.IKhachHangModel;


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

    void CapNhatNguoiDung(NguoiDungDTO NguoiDungDTO, INguoiDungModel.IOnCapNhatNguoiDungFinishedListener listener);

    interface IOnCapNhatNguoiDungFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void themNguoiDung(NguoiDungDTO nguoiDungDTO, INguoiDungModel.IOnThemNguoiDungFinishedListener listener);

    interface IOnThemNguoiDungFinishedListener {
        void onSuccess();

        void onError(String error);
    }

}
