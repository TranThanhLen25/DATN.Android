package com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong;


import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DoiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phong.PhongModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phong.IPhongModel;


import java.util.List;

public class PhongPresenter implements PhongContract.Presenter {

    private final PhongContract.View view;
    PhongModel phongModel;

    public PhongPresenter(PhongContract.View view) {
        this.view = view;
        this.phongModel = new PhongModel();
    }

    @Override
    public void LayDanhSachPhong() {
        phongModel.LayDanhSachPhong(new IPhongModel.IOnLayDanhSachPhongFinishedListener() {
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
    public void LayDanhSachPhong1g(int id, int trangThaiId) {
        phongModel.LayDanhSachPhong1g(id, trangThaiId, new IPhongModel.IOnLayDanhSachPhong1gFinishedListener() {
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

    @Override
    public void CapNhatTrangThaiPhong(PhongDTO phongDTO) {
        phongModel.CapNhatTrangThaiPhong(phongDTO, new IPhongModel.IOnCapNhatTrangThaiPhongFinishedListener() {
            @Override
            public void onSuccess() {
                view.onCapNhatTrangThaiPhongSuccess();
            }

            @Override
            public void onError(String error) {
                view.onCapNhatTrangThaiPhongError(error);
            }
        });
    }

    @Override
    public void DoiPhong(DoiPhongDTO doiPhongDTO) {
        phongModel.DoiPhong(doiPhongDTO, new IPhongModel.IOnDoiPhongFinishedListener() {
            @Override
            public void onSuccess() {
                view.onDoiPhongSuccess();
            }

            @Override
            public void onError(String error) {
                view.onDoiPhongError(error);
            }
        });
    }


}