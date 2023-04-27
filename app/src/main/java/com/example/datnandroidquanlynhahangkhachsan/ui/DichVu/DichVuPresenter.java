package com.example.datnandroidquanlynhahangkhachsan.ui.DichVu;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu.DichVuModel;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu.IDichVuModel;

import java.util.List;

public class DichVuPresenter implements DichVuContract.Presenter {
    private final DichVuContract.View view;
    DichVuModel dichVuModel;

    public DichVuPresenter(DichVuContract.View view) {
        this.view = view;
        dichVuModel = new DichVuModel();
    }


    @Override
    public void LayDanhSachDichVu(DichVuDTO dichVuDTO) {
        dichVuModel.LayDanhSachDichVu(dichVuDTO, new IDichVuModel.IOnLayDanhSachDichVuFinishedListener() {
            @Override
            public void onSuccess(List<DichVuDTO> listResult) {
                view.onLayDanhSachDichVuSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachDichVuError(error);
            }
        });
    }
}
