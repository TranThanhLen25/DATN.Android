package com.example.datnandroidquanlynhahangkhachsan.ui.Ban;

import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;

import java.util.List;

public interface BanContract {
    interface View {
        ////lấy danh sách phòng
        void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan);

        void onLayDanhSachBanError(String error);

        void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list);

        void onLayDanhSachLoaiBanError(String error);

        void onCapNhatTrangThaiBanSuccess();

        void onCapNhatTrangThaiBanError(String error);
    }

    interface Presenter {


        void LayDanhSachBan();

        void LayDanhSachLoaiBan();

        void CapNhatTrangThaiBan(BanDTO banDTO);
    }
}
