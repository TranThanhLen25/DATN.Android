package com.example.datnandroidquanlynhahangkhachsan.ui.chonphong;

import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.DanhSachPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.DanhSachPhongModel;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.IDanhSachPhongModel;

import java.util.List;

public class LoaiPhongPresenter implements LoaiPhongContract.Presenter{
    private final LoaiPhongContract.View view;
    LoaiPhongModel loaiPhongModel;

    public LoaiPhongPresenter(LoaiPhongContract.View view) {
        this.view = view;
        this.loaiPhongModel = new LoaiPhongModel();
    }

    @Override
    public void LayLoaiPhong() {
        loaiPhongModel.LayLoaiPhong(new ILoaiPhongModel.IOnLayLoaiPhongFinishedListener(){
            @Override
            public void onSuccess(List< LoaiPhongDTO > listResult) {
                view.onLayLoaiPhongSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayLoaiPhongError(error);
            }
        });
    }
}
