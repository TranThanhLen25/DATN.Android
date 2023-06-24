package com.example.datnandroidquanlynhahangkhachsan.ui.Menu;


import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;

import java.util.List;

public interface HangHoaContract {
    interface View {
        void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list);

        void onLayDanhSachHangHoaError(String error);


        //thêm hàng hóa
        void onThemHangHoaSuccess();

        void onThemHangHoaError(String error);

        //xóa hàng hóa
        void onXoaHangHoaSuccess();

        void onXoaHangHoaError(String error);

        //cập nhật hàng hóa
        void onCapNhatHangHoaSuccess();

        void onCapNhatHangHoaError(String error);
    }

    interface Presenter {
        ////void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc);

        void LayDanhSachHangHoa2(String NhomHangHoa);
        void themHangHoa(HangHoaDTO hangHoaDTO);
        void xoaHangHoa(int hangHoaID);
        void capNhatHangHoa(HangHoaDTO hangHoaDTO);
    }
}
