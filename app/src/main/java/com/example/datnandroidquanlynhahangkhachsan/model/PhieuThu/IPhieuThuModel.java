package com.example.datnandroidquanlynhahangkhachsan.model.PhieuThu;

import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.IPhieuNhanModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phong.IPhongModel;

import java.util.List;

public interface IPhieuThuModel {

    void LayDanhSachPhieuThu(IPhieuThuModel.IOnLayDanhSachPhieuThuFinishedListener listener);

    interface IOnLayDanhSachPhieuThuFinishedListener {
        void onSuccess(List<PhieuThuDTO> listResult);

        void onError(String error);
    }

    void ThemPhieuThu(PhieuThuDTO phieuThuDTO,IOnThemPhieuThuFinishedListener listener);

    interface IOnThemPhieuThuFinishedListener {
        void onSuccess();

        void onError(String error);
    }
}
