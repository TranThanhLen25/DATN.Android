package com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;

import java.util.List;

public interface NguoiDungContract {

    interface View {
        /// lấy danh sách người dùng
        void onLayNguoiDungSuccess(List<NguoiDungDTO> lsNguoiDung);

        void onLayNguoiDungError(String error);

        /// lấy người dùng theo id
        void onLayNguoiDungIDSuccess(List<NguoiDungDTO> lsNguoiDungID);

        void onLayNguoiDungIDError(String error);

        void onCapNhatNguoiDungSuccess();

        void onCapNhatNguoiDungError(String error);


        void onThemNguoiDungSuccess();

        void onThemNguoiDungError(String error);
    }

    interface Presenter {
        void LayNguoiDung();

        void LayNguoiDungID(int nguoiDung);

        void CapNhatNguoiDung(NguoiDungDTO NguoiDungDTO);

        void ThemNguoiDung(NguoiDungDTO nguoiDungDTO);

    }}
