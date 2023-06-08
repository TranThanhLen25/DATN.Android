package com.example.datnandroidquanlynhahangkhachsan.ui.DichVu;

import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.ListDichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;

import java.util.List;

public interface DichVuContract {
    interface View {
        //lấy danh sách dịch vụ kèm theo điều kiện lọc
        void onLayDanhSachDichVuSuccess(List<DichVuDTO> list);

        void onLayDanhSachDichVuError(String error);

        //thêm dịch vụ
        void onthemDichVuSuccess();

        void onthemDichVuError(String error);

        //cập nhật điều kiện lọc
        void oncapNhatDichVuSuccess();

        void oncapNhatDichVuError(String error);
        /// lay dv theo Pn

        void onLayDvPnSuccess(List<DichVuDTO> list);

        void onLayDvPnError(String error);

        void onCapNhatDVSuccess();

        void onCapNhatDVError(String error);
    }

    interface Presenter {
        //void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc);

        void LayDanhSachDichVu(DichVuDTO dichVuDTO);
        void LayDvPn(DichVuDTO dichVuDTO);


        void themDichVu(ListDichVuDTO listDichVuDTO);

        void capNhatDichVu(ListDichVuDTO listDichVuDTO);
        void CapNhatDV(DichVuDTO dichVuDTO);
    }
}
