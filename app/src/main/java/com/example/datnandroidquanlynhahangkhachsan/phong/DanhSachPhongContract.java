package com.example.datnandroidquanlynhahangkhachsan.phong;


import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;

import java.util.List;

public interface DanhSachPhongContract {

    interface View {
        void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong);

        void onLayDanhSachPhongError(String error);
    }

    interface Presenter {
        //void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc);

        void LayDanhSachPhong();
    }
}
