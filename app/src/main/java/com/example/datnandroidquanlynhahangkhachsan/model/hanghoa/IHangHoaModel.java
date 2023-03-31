package com.example.datnandroidquanlynhahangkhachsan.model.hanghoa;




import com.example.datnandroidquanlynhahangkhachsan.entities.DieuKienLocHangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;

import java.util.List;

public interface IHangHoaModel {
    void LayDanhSachHangHoa(DieuKienLocHangHoaDTO dieuKienLoc, IOnLayDanhSachHangHoaFinishedListener listener);

    interface IOnLayDanhSachHangHoaFinishedListener {
        void onSuccess(List<HangHoaDTO> listResult);

        void onError(String error);
    }

    void LayDanhSachHangHoa2(IOnLayDanhSachHangHoa2FinishedListener listener);

    interface IOnLayDanhSachHangHoa2FinishedListener {
        void onSuccess(List<HangHoaDTO> listResult);

        void onError(String error);
    }
}
