package com.example.datnandroidquanlynhahangkhachsan.ui.chonphong;

import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;


import java.util.List;

public interface LoaiPhongContract {

    interface View {
        void onLayLoaiPhongSuccess(List<LoaiPhongDTO> lsLoaiPhong);

        void onLayLoaiPhongError(String error);
    }

    interface Presenter {


        void LayLoaiPhong();
    }
}
