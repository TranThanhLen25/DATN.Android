package com.example.datnandroidquanlynhahangkhachsan.ui.DichVu;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;

import java.util.List;

public interface DichVuContract {
    interface View {
        void onLayDanhSachDichVuSuccess(List<DichVuDTO> list);

        void onLayDanhSachDichVuError(String error);
    }

    interface Presenter {
        //void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc);

        void LayDanhSachDichVu(DichVuDTO dichVuDTO);
    }
}
