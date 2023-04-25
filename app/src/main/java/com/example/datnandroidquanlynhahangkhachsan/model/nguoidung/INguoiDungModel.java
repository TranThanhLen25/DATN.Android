package com.example.datnandroidquanlynhahangkhachsan.model.nguoidung;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phong.IPhongModel;

public interface INguoiDungModel {
    void CapNhatNguoiDung(NguoiDungDTO nguoiDungDTO, IPhongModel.IOnCapNhatNguoiDungFinishedListener listener);

    interface IOnCapNhatNguoiDungFinishedListener {
        void onSuccess(NguoiDungDTO nguoiDungDTO);

        void onError(String error);
    }
}
