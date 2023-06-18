package com.example.datnandroidquanlynhahangkhachsan.ui.chonBan;

import android.content.Context;
import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.ChonBanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChonBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;

import java.util.ArrayList;
import java.util.List;

public class activity_chon_ban extends AppCompatActivity implements BanContract.View, LoaiPhongContract.View {

    private List<BanDTO> lsBan;

    private List<LoaiBanDTO> lsLoaiBan;
    private RecyclerView rscv;
    private ActivityChonBanBinding chonBanBinding;
    private ChonBanAdapter chonBanAdapter;
    private Spinner spinner;
    private BanPresenter banPresenter;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chonBanBinding = ActivityChonBanBinding.inflate(getLayoutInflater());

        //lấy loại bàn
        lsLoaiBan = new ArrayList<>();
        banPresenter = new BanPresenter(this);
        banPresenter.LayDanhSachLoaiBan();


        //lấy bàn
        lsBan = new ArrayList<>();
        rscv = chonBanBinding.rscvChonban;
        banPresenter.LayDanhSachBan();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        rscv.setLayoutManager(gridLayoutManager);

        chonBanBinding.incluChonban.icBack.setOnClickListener(view -> onBackPressed());
        setContentView(chonBanBinding.getRoot());
    }

    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
        lsBan = lsDanhSachBan;
        chonBanAdapter = new ChonBanAdapter(this);
        chonBanAdapter.setData(lsBan, lsLoaiBan, context);
        rscv.setAdapter(chonBanAdapter);
    }

    @Override
    public void onLayDanhSachBanError(String error) {

    }

    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {
        lsLoaiBan = list;
        chonBanAdapter = new ChonBanAdapter(this);
        chonBanAdapter.setData(lsBan, lsLoaiBan, context);
        rscv.setAdapter(chonBanAdapter);
    }

    @Override
    public void onLayDanhSachLoaiBanError(String error) {

    }

    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> lsLoaiPhong) {

    }

    @Override
    public void onLayLoaiPhongError(String error) {

    }
}