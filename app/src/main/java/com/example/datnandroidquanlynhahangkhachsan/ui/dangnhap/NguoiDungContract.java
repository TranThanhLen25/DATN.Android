package com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;

import java.util.List;

public interface NguoiDungContract {

    interface View {
        void onLayNguoiDungSuccess(List<NguoiDungDTO> lsNguoiDung);

        void onLayNguoiDungError(String error);
    }

    interface Presenter {


        void LayNguoiDung();
    }
}
