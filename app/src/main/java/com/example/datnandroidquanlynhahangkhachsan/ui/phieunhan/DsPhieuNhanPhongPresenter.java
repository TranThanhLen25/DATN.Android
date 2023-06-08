package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

<<<<<<< HEAD

import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.IPhieuNhanModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieunhan.PhieuNhanModel;
=======
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.phieudat.IPhieuDatModel;
import com.example.datnandroidquanlynhahangkhachsan.model.phieudat.PhieuDatModel;
>>>>>>> parent of b9bf688 (đã xong menu(thêm xóa sửa))

import java.util.List;

public class DsPhieuNhanPhongPresenter implements DsPhieuNhanPhongContract.Presenter {
    private final DsPhieuNhanPhongContract.View view;
    PhieuDatModel phieuDatModel;

    public DsPhieuNhanPhongPresenter(DsPhieuNhanPhongContract.View view) {
        this.view = view;
        this.phieuDatModel = new PhieuDatModel();
    }


    @Override
    public void LayDanhSachPhieuDat(DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO) {
        phieuDatModel.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO, new IPhieuDatModel.IOnLayDanhSachPhieuDatFinishedListener() {
            @Override
            public void onSuccess(List<PhieuDatDTO> listResult) {
                view.onLayDanhSachPhieuDatSuccess(listResult);
            }

            @Override
            public void onError(String error) {
                view.onLayDanhSachPhieuDatError(error);
            }
        });
    }

    @Override
<<<<<<< HEAD
    public void ThemPhieuNhanPhong(NhanPhongDTO nhanPhongDTO) {
        phieuNhanModel.ThemPhieuNhanPhong(nhanPhongDTO, new IPhieuNhanModel.IOnThemPhieuNhanPhongFinishedListener() {
            @Override
            public void onSuccess() {
                view.onThemPhieuNhanPhongSuccess();
            }

            @Override
            public void onError(String error) {
                view.onThemPhieuNhanPhongError(error);
            }
        });
    }

//    @Override
//    public void ThemPhieuDatPhong(PhieuDatDTO phieuDatDTO) {
=======
    public void ThemPhieuDatPhong(PhieuDatDTO phieuDatDTO) {
>>>>>>> parent of b9bf688 (đã xong menu(thêm xóa sửa))
//        phieuDatModel.ThemPhieuDatPhong(phieuDatDTO, new IPhieuDatModel.IOnThemPhieuDatPhongFinishedListener() {
//            @Override
//            public void onSuccess() {
//                view.onThemPhieuDatPhongSuccess();
//            }
//
//            @Override
//            public void onError(String error) {
//                view.onThemPhieuDatPhongError(error);
//            }
//        });
<<<<<<< HEAD
//    }
=======
    }
>>>>>>> parent of b9bf688 (đã xong menu(thêm xóa sửa))
}
