package com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong;


import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;

import java.util.List;

public interface DanhSachPhongContract {

    interface View {
        ////lấy danh sách phòng
        void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong);

        void onLayDanhSachPhongError(String error);

        //////////lấy danh sách theo loại phòng
        void onLayDanhSachPhong1gSuccess(List<PhongDTO> lsDanhSachPhong1g);

        void onLayDanhSachPhong1gError(String error);


    }

    interface Presenter {


        void LayDanhSachPhong();

        void LayDanhSachPhong1g(int id);

    }
}
