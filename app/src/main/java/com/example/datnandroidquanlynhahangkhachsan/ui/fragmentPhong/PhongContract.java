package com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong;


import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DoiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;

import java.util.List;

public interface PhongContract {

    interface View {
        ////lấy danh sách phòng
        void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong);

        void onLayDanhSachPhongError(String error);

        //////////lấy danh sách theo loại phòng
        void onLayDanhSachPhong1gSuccess(List<PhongDTO> lsDanhSachPhong1g);

        void onLayDanhSachPhong1gError(String error);

        void onCapNhatTrangThaiPhongSuccess();

        void onCapNhatTrangThaiPhongError(String error);

        //đổi phòng
        void onDoiPhongSuccess();

        void onDoiPhongError(String error);
    }

    interface Presenter {


        void LayDanhSachPhong();

        void LayDanhSachPhong1g(int id, int trangThaiId);

        void CapNhatTrangThaiPhong(PhongDTO phongDTO);
        void DoiPhong(DoiPhongDTO doiPhongDTO);

    }
}
