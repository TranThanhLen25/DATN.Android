package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;



import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;

import java.util.List;

public interface PhieuXuatConTract {
    interface View {
  
        void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list);

        void onLayDanhSachPhieuXuatError(String error);

       
    }

    interface Presenter {

        void LayDanhSachPhieuXuat(DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO);
        
    }
}
