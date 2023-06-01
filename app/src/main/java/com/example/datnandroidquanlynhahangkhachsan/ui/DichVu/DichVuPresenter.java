package com.example.datnandroidquanlynhahangkhachsan.ui.DichVu;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.ListDichVuDTO;
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
    @Override
    public void LayDvPn(DichVuDTO dichVuDTO) {
        dichVuModel.LayDvPn(dichVuDTO, new IDichVuModel.IOnLayDvPnFinishedListener() {
            @Override
            public void onSuccess(List<DichVuDTO> listResult) {
                view.onLayDvPnSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDvPnError(error);
            }
        });
    }
    @Override
    public void themDichVu(ListDichVuDTO listDichVuDTO) {
        dichVuModel.themDichVu(listDichVuDTO, new IDichVuModel.IOnthemDichVuFinishedListener() {
            @Override
            public void onSuccess() {
                view.onthemDichVuSuccess();
            }

            @Override
            public void onError(String error) {
                view.onthemDichVuError(error);
            }
        });
    }

    @Override
    public void capNhatDichVu(ListDichVuDTO listDichVuDTO) {
        dichVuModel.capNhatDichVu(listDichVuDTO, new IDichVuModel.IOncapNhatDichVuFinishedListener() {
            @Override
            public void onSuccess() {
                view.oncapNhatDichVuSuccess();
            }

            @Override
            public void onError(String error) {
                view.oncapNhatDichVuError(error);
            }
        });
    }
}
