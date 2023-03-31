package com.example.datnandroidquanlynhahangkhachsan.fragmentMenu;


import com.example.datnandroidquanlynhahangkhachsan.entities.DieuKienLocHangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;

import java.util.List;

public interface MenuDichVuContract {
    interface View {
        void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list);

        void onLayDanhSachHangHoaError(String error);
    }

    interface Presenter {
        //void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc);

        void LayDanhSachHangHoa2();
    }
}
