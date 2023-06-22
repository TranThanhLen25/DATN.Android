package com.example.datnandroidquanlynhahangkhachsan.model.Ban;




import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;

import java.util.List;

public interface BanIModel {
    void LayDanhSachBan(IOnLayDanhSachBanFinishedListener listener);

    void LayDanhSachLoaiBan(IOnLayDanhSachLoaiBanFinishedListener listener);

    interface IOnLayDanhSachBanFinishedListener {
        void onSuccess(List<BanDTO> listResult);

        void onError(String error);


    }

    interface IOnLayDanhSachLoaiBanFinishedListener {
        void onSuccess(List<LoaiBanDTO> listResult);

        void onError(String error);


    }

    void CapNhatTrangThaiBan(BanDTO BanDTO, BanIModel.IOnCapNhatTrangThaiBanFinishedListener listener);

    interface IOnCapNhatTrangThaiBanFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
