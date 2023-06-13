package com.example.datnandroidquanlynhahangkhachsan.ui.goiMon;

import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;

import java.util.List;

public interface goiMonContract {
    interface View {
        //lấy danh sách dịch vụ kèm theo điều kiện lọc
        void onLayDanhSachGoiMonSuccess(List<GoiMonDTO> list);

        void onLayDanhSachGoiMonError(String error);
    }
    interface Presenter {
        void LayDanhSachGoiMon(GoiMonDTO goiMonDTO);
    }
}
