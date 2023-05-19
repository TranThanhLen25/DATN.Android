package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuXuatChiTietAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuXuatBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietPresenter;

import java.util.ArrayList;
import java.util.List;

public class PhieuXuatActivity extends AppCompatActivity implements PhieuXuatConTract.View, PhongContract.View, PhieuNhanPhongChiTietContract.View {

    private List<PhieuXuatChiTietDTO> lsPhieuXuatCT;
    private List<PhongDTO> lsPhong;
    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanCT;
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhieuXuatBinding phieuXuatBinding = ActivityPhieuXuatBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("PHIEUXUAT", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        lsPhieuXuatCT = new ArrayList<>();
        lsPhieuNhanCT = new ArrayList<>();
        lsPhong = new ArrayList<>();
        PhongPresenter phongPresenter = new PhongPresenter(this);
        phongPresenter.LayDanhSachPhong();


        phieuXuatBinding.toolbarPhieutraphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();
                onBackPressed();
            }
        });


        String ten = sharedPreferences.getString("TENKH", "");
        String cccd = sharedPreferences.getString("CCCD", "");
        String sdt = sharedPreferences.getString("SDT", "");
        String sct = sharedPreferences.getString("SCT", "");
        String ngay = sharedPreferences.getString("NGAYLAP", "");
        Long pxid = sharedPreferences.getLong("PXID", 0L);


        phieuXuatBinding.etCccdPhieutraphong.setText(cccd);
        phieuXuatBinding.etHotenPhieutraphong.setText(ten);
        phieuXuatBinding.tvSdtptp.setText(sdt);
        phieuXuatBinding.tvSctData.setText(sct);
        phieuXuatBinding.tvNgaynhan.setText(ngay);
        ///lấy danh sach phiếu xuất ct
        PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatChiTietDTO dieuKienLocPhieuXuatChiTietDTO = new DieuKienLocPhieuXuatChiTietDTO();
        dieuKienLocPhieuXuatChiTietDTO.setPhieuXuatId(pxid);
        phieuXuatPresenter.LayDanhSachPhieuXuatChiTiet(dieuKienLocPhieuXuatChiTietDTO);
        ////lấy danh sach phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);

        recyclerView = phieuXuatBinding.rscvSudung;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        setContentView(phieuXuatBinding.getRoot());

    }


    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
        lsPhieuXuatCT = list;
        PhieuXuatChiTietAdapter phieuXuatChiTietAdapter = new PhieuXuatChiTietAdapter(this);
        phieuXuatChiTietAdapter.setData(this, lsPhieuXuatCT, lsPhieuNhanCT, lsPhong);
        recyclerView.setAdapter(phieuXuatChiTietAdapter);
    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {
        lsPhieuNhanCT = list;
        PhieuXuatChiTietAdapter phieuXuatChiTietAdapter = new PhieuXuatChiTietAdapter(this);
        phieuXuatChiTietAdapter.setData(this, lsPhieuXuatCT, lsPhieuNhanCT, lsPhong);
        recyclerView.setAdapter(phieuXuatChiTietAdapter);


    }
    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong) {
        lsPhong = lsDanhSachPhong;
        PhieuXuatChiTietAdapter phieuXuatChiTietAdapter = new PhieuXuatChiTietAdapter(this);
        phieuXuatChiTietAdapter.setData(this, lsPhieuXuatCT, lsPhieuNhanCT, lsPhong);
        recyclerView.setAdapter(phieuXuatChiTietAdapter);


    }
    @Override
    public void onCapNhatPhieuNhanPhongChiTietSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietError(String error) {
    }

    @Override
    public void onLayDanhSachPhongError(String error) {
    }

    //////////lấy danh sách theo loại phòng
    @Override
    public void onLayDanhSachPhong1gSuccess(List<PhongDTO> lsDanhSachPhong1g) {
    }

    @Override
    public void onLayDanhSachPhong1gError(String error) {
    }

    @Override
    public void onCapNhatTrangThaiPhongSuccess() {
    }

    @Override
    public void onCapNhatTrangThaiPhongError(String error) {
    }

    @Override
    public void onThemPhieuXuatSuccess() {
    }

    @Override
    public void onThemPhieuXuatError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
    }

    @Override
    public void onLayDanhSachPhieuXuatError(String error) {
    }


    @Override
    public void onLayDanhSachPhieuXuatChiTietError(String error) {
    }


}