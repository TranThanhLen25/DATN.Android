package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuNhanPhongChiTietBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhanPhongChiTietActivity extends AppCompatActivity implements PhieuNhanPhongChiTietContract.View {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanCT;
private RecyclerView rccvPNCT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhieuNhanPhongChiTietBinding phieuNhanPhongChiTietBinding = ActivityPhieuNhanPhongChiTietBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("PHIEUNHAN", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        phieuNhanPhongChiTietBinding.tvHotenPnct.setText(sharedPreferences.getString("TEN", ""));
        phieuNhanPhongChiTietBinding.tvCccdPnct.setText(sharedPreferences.getString("CCCD", ""));
        phieuNhanPhongChiTietBinding.tvSdtPnct.setText((sharedPreferences.getString("SDT", "")));
        phieuNhanPhongChiTietBinding.tvNgaynhanPnct.setText(sharedPreferences.getString("NGAY", ""));
        phieuNhanPhongChiTietBinding.tvSctPnct.setText(sharedPreferences.getString("SCT", ""));

        lsPhieuNhanCT=new ArrayList<>();
        /// lấy danh sách phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
        dieuKienLocPhieuNhanPhongChiTietDTO.setPhieuNhanId(sharedPreferences.getLong("PNID",0L));
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);
        rccvPNCT=phieuNhanPhongChiTietBinding.rscvPnct;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rccvPNCT.setLayoutManager(linearLayoutManager);
        phieuNhanPhongChiTietBinding.toolbarPnct.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                onBackPressed();
            }
        });
        setContentView(phieuNhanPhongChiTietBinding.getRoot());
    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {
        lsPhieuNhanCT=list;

    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietError(String error) {
    }
}