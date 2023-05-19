package com.example.datnandroidquanlynhahangkhachsan.ui.DichVu;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.ListDichVuDTO;

import java.util.List;

public interface DichVuContract {
    interface View {
        //lấy danh sách dịch vụ kèm theo điều kiện lọc
        //
        void onLayDanhSachDichVuSuccess(List<DichVuDTO> list);

        void onLayDanhSachDichVuError(String error);

        //thêm dịch vụ
        void onthemDichVuSuccess();

        void onthemDichVuError(String error);

        //cập nhật điều kiện lọc
        void oncapNhatDichVuSuccess();

        void oncapNhatDichVuError(String error);
    }

    interface Presenter {
        //void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc);

        void LayDanhSachDichVu(DichVuDTO dichVuDTO);

        void themDichVu(ListDichVuDTO listDichVuDTO);

        void capNhatDichVu(ListDichVuDTO listDichVuDTO);
    }
}
