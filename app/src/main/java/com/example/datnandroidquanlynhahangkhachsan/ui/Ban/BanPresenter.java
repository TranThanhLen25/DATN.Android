package com.example.datnandroidquanlynhahangkhachsan.ui.Ban;

import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.Ban.BanIModel;
import com.example.datnandroidquanlynhahangkhachsan.model.Ban.BanModel;


import java.util.List;

public class BanPresenter implements BanContract.Presenter {

    private final BanContract.View view;
    BanModel BanModel;

    public BanPresenter(BanContract.View view) {
        this.view = view;
        this.BanModel = new BanModel();
    }

    @Override
    public void LayDanhSachBan() {
        BanModel.LayDanhSachBan(new BanIModel.IOnLayDanhSachBanFinishedListener() {
            @Override
            public void onSuccess(List<BanDTO> listResult) {
                view.onLayDanhSachBanSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachBanError(error);
            }
        }

        );
    }
    @Override
    public void LayDanhSachLoaiBan() {
        BanModel.LayDanhSachLoaiBan(new BanIModel.IOnLayDanhSachLoaiBanFinishedListener() {
            @Override
            public void onSuccess(List<LoaiBanDTO> listResult) {
                view.onLayDanhSachLoaiBanSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachLoaiBanError(error);
            }
        }

        );
    }

}