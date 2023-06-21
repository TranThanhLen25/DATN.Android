package com.example.datnandroidquanlynhahangkhachsan.ui.goiMon;

import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.ListGoiMonDTO;

import java.util.List;

public interface goiMonContract {
    interface View {
        //lấy danh sách gọi món kèm theo điều kiện lọc
        void onLayDanhSachGoiMonSuccess(List<GoiMonDTO> list);

        void onLayDanhSachGoiMonError(String error);

        //thêm xóa sửa go món
        void onCapNhatGoiMonSuccess();

        void onCapNhatGoiMonError(String error);

        void onCapNhatGMSuccess();

        void onCapNhatGMError(String error);
    }

    interface Presenter {
        void LayDanhSachGoiMon(GoiMonDTO goiMonDTO);

        void CapNhatGoiMon(ListGoiMonDTO listGoiMonDTO);

        void CapNhatGM(GoiMonDTO goiMonDTO);
    }
}
