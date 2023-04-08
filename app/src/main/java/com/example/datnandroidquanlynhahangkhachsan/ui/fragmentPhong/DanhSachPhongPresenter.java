package com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong;


import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.hanghoa.IHangHoaModel;


import java.util.List;

public class DanhSachPhongPresenter implements DanhSachPhongContract.Presenter {

    private final DanhSachPhongContract.View view;
    DanhSachPhongModel danhSachPhongModel;

    public DanhSachPhongPresenter(DanhSachPhongContract.View view) {
        this.view = view;
        this.danhSachPhongModel = new DanhSachPhongModel();
    }

    @Override
    public void LayDanhSachPhong() {
        danhSachPhongModel.LayDanhSachPhong(new IDanhSachPhongModel.IOnLayDanhSachPhongFinishedListener() {
            @Override
            public void onSuccess(List<PhongDTO> listResult) {
                view.onLayDanhSachPhongSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhongError(error);
            }
        });
    }

    @Override
    public void LayDanhSachPhong1g(int id,int trangThaiId) {
        danhSachPhongModel.LayDanhSachPhong1g(id,trangThaiId,new IDanhSachPhongModel.IOnLayDanhSachPhong1gFinishedListener() {
            @Override
            public void onSuccess(List<PhongDTO> listResult) {
                view.onLayDanhSachPhong1gSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhong1gError(error);
            }
        });
    }


}