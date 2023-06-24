package com.example.datnandroidquanlynhahangkhachsan.ui.Menu;


import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.hanghoa.HangHoaModel;
import com.example.datnandroidquanlynhahangkhachsan.model.hanghoa.IHangHoaModel;

import java.util.List;

public class HangHoaPresenter implements HangHoaContract.Presenter {

    private final HangHoaContract.View view;
    HangHoaModel hangHoaModel;

    public HangHoaPresenter(HangHoaContract.View view) {
        this.view = view;
        this.hangHoaModel = new HangHoaModel();
    }

//    @Override
//    public void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc) {
//        hangHoaModel.LayDanhSachHangHoa(dieuKienLoc, new IHangHoaModel.IOnLayDanhSachHangHoaFinishedListener() {
//            @Override
//            public void onSuccess(List<HangHoaDTO> listResult) {
//                view.onLayDanhSachHangHoaSuccess(listResult);
//            }
//
//            @Override
//            public void onError(String error) {
//                view.onLayDanhSachHangHoaError(error);
//            }
//        });
//   }

    @Override
    public void LayDanhSachHangHoa2(String NhomHangHoa) {
        hangHoaModel.LayDanhSachHangHoa2(NhomHangHoa, new IHangHoaModel.IOnLayDanhSachHangHoa2FinishedListener() {
            @Override
            public void onSuccess(List<HangHoaDTO> listResult) {
                view.onLayDanhSachHangHoaSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachHangHoaError(error);
            }
        });
    }

    @Override
    public void themHangHoa(HangHoaDTO hangHoaDTO) {
        hangHoaModel.themHangHoa(hangHoaDTO, new IHangHoaModel.IOnThemHangHoaFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemHangHoaSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemHangHoaError(error);
            }
        });
    }

    @Override
    public void xoaHangHoa(int hangHoaID) {
        hangHoaModel.xoaHangHoa(hangHoaID, new IHangHoaModel.IOnXoaHangHoaFinishedListener() {
            @Override
            public void onSuccess() {
                view.onXoaHangHoaSuccess();
            }

            @Override
            public void onError(String error) {
                view.onXoaHangHoaError(error);
            }
        });
    }

    @Override
    public void capNhatHangHoa(HangHoaDTO hangHoaDTO) {
        hangHoaModel.capNhatHangHoa(hangHoaDTO, new IHangHoaModel.IOnCapNhatHangHoaFinishedListener() {
            @Override
            public void onSuccess() {
                view.onCapNhatHangHoaSuccess();
            }

            @Override
            public void onError(String error) {
                view.onCapNhatHangHoaError(error);
            }
        });
    }
}
