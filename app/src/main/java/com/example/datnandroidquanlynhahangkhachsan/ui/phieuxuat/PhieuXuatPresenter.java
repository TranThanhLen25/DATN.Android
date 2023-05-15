package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;


import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.PhieuXuatModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.IPhieuXuatModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.PhieuXuatModel;


import java.util.List;

public class PhieuXuatPresenter implements PhieuXuatConTract.Presenter{
    private final PhieuXuatConTract.View view;
    PhieuXuatModel phieuXuatModel;

    public PhieuXuatPresenter(PhieuXuatConTract.View view) {
        this.view = view;
        this.phieuXuatModel = new PhieuXuatModel();
    }


    @Override
    public void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO) {
        phieuXuatModel.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO, new IPhieuXuatModel.IOnLayDanhSachPhieuXuatFinishedListener() {
            @Override
            public void onSuccess(List<PhieuXuatDTO> listResult) {
                view.onLayDanhSachPhieuXuatSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhieuXuatError(error);
            }
        });
    }

}