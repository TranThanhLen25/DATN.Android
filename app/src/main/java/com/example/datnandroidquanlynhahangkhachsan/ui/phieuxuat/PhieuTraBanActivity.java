package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuTraBanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuTraBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuNhan;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;

import java.util.ArrayList;
import java.util.List;

public class PhieuTraBanActivity extends AppCompatActivity
//        implements DichVuContract.View, HangHoaContract.View
       {
private List<DichVuDTO>lsDichVu;
private List<HangHoaDTO> lsHangHoa;
private Context context;
private RecyclerView rccvDv;
private List<PhieuNhanDTO> lsPhieuNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhieuTraBanBinding phieuTraBanBinding=ActivityPhieuTraBanBinding.inflate(getLayoutInflater());
        setContentView(phieuTraBanBinding.getRoot());
        SharedPreferences sharedPreferences=getSharedPreferences("GET_BANID",MODE_PRIVATE);

        phieuTraBanBinding.tvBanData.setText(sharedPreferences.getString("TENBAN",""));
        phieuTraBanBinding.tvHotenPtp.setText(sharedPreferences.getString("TEN",""));
        phieuTraBanBinding.tvSdtptp.setText(sharedPreferences.getString("SDT",""));
        phieuTraBanBinding.tvCccdPtp.setText(sharedPreferences.getString("CCCD",""));
        phieuTraBanBinding.tvNgaynhan.setText(sharedPreferences.getString("NGAYLAP",""));
//lsDichVu=new ArrayList<>();
//lsHangHoa=new ArrayList<>();

//        //// lay DV
//        DichVuPresenter dichVuPresenter = new DichVuPresenter(this);
//        DichVuDTO dichVuDTO = new DichVuDTO();
//        dichVuDTO.setPhieuNhanID(sharedPreferences.getLong("PNID", 0L));
//        dichVuDTO.setPhongID(phongid);
//        dichVuDTO.setGhiChu("");
//        dichVuDTO.setTrangThai("thanh");
//        dichVuPresenter.LayDvPn(dichVuDTO);

        ///lay hanghoa
//        HangHoaPresenter hangHoaPresenter = new HangHoaPresenter(this);
//        hangHoaPresenter.LayDanhSachHangHoa2("");



//         rccvDv=phieuTraBanBinding.rscvSudung;
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        rccvDv.setLayoutManager(linearLayoutManager);


    }
    //lấy danh sách dịch vụ kèm theo điều kiện lọc
//    @Override
//   public void onLayDanhSachDichVuSuccess(List<DichVuDTO> list){
//        lsDichVu=list;
//        PhieuTraBanAdapter phieuTraBanAdapter=new PhieuTraBanAdapter(this);
//        phieuTraBanAdapter.setData(lsDichVu,lsHangHoa,context);
//        rccvDv.setAdapter(phieuTraBanAdapter);
//    }
//
//    @Override
//    public void onLayDanhSachDichVuError(String error){}
//
//    //thêm dịch vụ
//    @Override
//    public void onthemDichVuSuccess(){}
//
//    @Override
//    public void onthemDichVuError(String error){}
//
//    //cập nhật điều kiện lọc
//    @Override
//    public void oncapNhatDichVuSuccess(){}
//
//    @Override
//    public void oncapNhatDichVuError(String error){}
//    /// lay dv theo Pn
//
//    @Override
//    public void onLayDvPnSuccess(List<DichVuDTO> list){}
//
//    @Override
//    public void onLayDvPnError(String error){}
//
//    @Override
//    public void onCapNhatDVSuccess(){}
//
//    @Override
//    public void onCapNhatDVError(String error){}
//
//    @Override
//    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list){
//        lsHangHoa=list;
//        PhieuTraBanAdapter phieuTraBanAdapter=new PhieuTraBanAdapter(this);
//        phieuTraBanAdapter.setData(lsDichVu,lsHangHoa,context);
//        rccvDv.setAdapter(phieuTraBanAdapter);
//    }
//
//    @Override
//    public void onLayDanhSachHangHoaError(String error){}
}