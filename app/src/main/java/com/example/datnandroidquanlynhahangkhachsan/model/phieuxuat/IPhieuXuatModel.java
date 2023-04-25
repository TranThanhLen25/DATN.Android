package com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat;



import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;

import java.util.List;

public interface IPhieuXuatModel {
    void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO, IPhieuXuatModel.IOnLayDanhSachPhieuXuatFinishedListener listener);

    interface IOnLayDanhSachPhieuXuatFinishedListener {
        void onSuccess(List<PhieuXuatDTO> listResult);

        void onError(String error);
    }
}
