package com.example.datnandroidquanlynhahangkhachsan.ui.Menu;


import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;

import java.util.List;

public interface MenuDichVuContract {
    interface View {
        void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list);

        void onLayDanhSachHangHoaError(String error);
    }

    interface Presenter {
        ////void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc);




        
        void LayDanhSachHangHoa2(String NhomHangHoa);
    }
}
