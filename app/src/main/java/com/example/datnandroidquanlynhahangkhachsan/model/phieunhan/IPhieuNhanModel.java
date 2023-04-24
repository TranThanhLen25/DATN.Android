package com.example.Nhannandroidquanlynhahangkhachsan.model.phieunhan;


import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;


import java.util.List;

public interface IPhieuNhanModel {

    void LayDanhSachPhieuNhan(DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO, IPhieuNhanModel.IOnLayDanhSachPhieuNhanFinishedListener listener);

    interface IOnLayDanhSachPhieuNhanFinishedListener {
        void onSuccess(List<PhieuNhanDTO> listResult);

        void onError(String error);
    }
}
