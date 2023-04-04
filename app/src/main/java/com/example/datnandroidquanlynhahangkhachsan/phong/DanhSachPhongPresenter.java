package com.example.datnandroidquanlynhahangkhachsan.phong;


import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;



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
        danhSachPhongModel.LayDanhSachPhong(new IDanhSachPhongModel.IOnLayDanhSachPhongFinishedListener(){
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
}