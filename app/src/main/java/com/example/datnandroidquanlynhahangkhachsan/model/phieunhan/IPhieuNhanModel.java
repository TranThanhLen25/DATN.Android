package com.example.datnandroidquanlynhahangkhachsan.model.phieunhan;


import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieuxuat.IPhieuXuatModel;

import java.util.List;

public interface IPhieuNhanModel {

    void LayDanhSachPhieuNhan(DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO, IPhieuNhanModel.IOnLayDanhSachPhieuNhanFinishedListener listener);

    interface IOnLayDanhSachPhieuNhanFinishedListener {
        void onSuccess(List<PhieuNhanDTO> listResult);

        void onError(String error);
    }


    void ThemPhieuNhanPhong(NhanPhongDTO nhanPhongDTO, IPhieuNhanModel.IOnThemPhieuNhanPhongFinishedListener listener);

    interface IOnThemPhieuNhanPhongFinishedListener {
        void onSuccess();

        void onError(String error);
    }

    void ThemPhieuNhanBan(NhanBanDTO nhanBanDTO, IPhieuNhanModel.IOnThemPhieuNhanBanFinishedListener listener);

    interface IOnThemPhieuNhanBanFinishedListener {
        void onSuccess();

        void onError(String error);
    }
    void CapNhatPhieuNhan(PhieuNhanDTO phieuNhanDTO, IPhieuNhanModel.IOnCapNhatPhieuNhanFinishedListener listener);

    interface IOnCapNhatPhieuNhanFinishedListener {
        void onSuccess();

        void onError(String error);
    }

}
