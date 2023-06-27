package com.example.datnandroidquanlynhahangkhachsan.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuDoiBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DoiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonBan.activity_chon_ban;

import java.util.ArrayList;
import java.util.List;

public class PhieuDoiBanActivity extends AppCompatActivity implements BanContract.View {
    ActivityPhieuDoiBanBinding activityPhieuDoiBanBinding;
    private BanPresenter banPresenter;
    private DoiBanDTO doiBanDTO;
    private SharedPreferences sharedPreferences;
    private List<BanDTO> banDTOList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPhieuDoiBanBinding = ActivityPhieuDoiBanBinding.inflate(getLayoutInflater());
        setContentView(activityPhieuDoiBanBinding.getRoot());
        banPresenter = new BanPresenter(this);
        doiBanDTO = new DoiBanDTO();
        banPresenter.LayDanhSachBan();

        activityPhieuDoiBanBinding.toolbarPhieudoiphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.checkDoiBan = false;
                tempData.doiBan=null;
                onBackPressed();
            }
        });
        activityPhieuDoiBanBinding.imgbtnDoiphongChonphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.checkDoiBan = true;
                Intent intent = new Intent(PhieuDoiBanActivity.this, activity_chon_ban.class);
                startActivity(intent);
            }
        });


        ////gán thông tin vào textVIEW
        sharedPreferences = getSharedPreferences("CHITIETBAN", MODE_PRIVATE);
        activityPhieuDoiBanBinding.tvDoiphongDataVitribandau.setText(String.valueOf(sharedPreferences.getString("TENBAN", "")));


        activityPhieuDoiBanBinding.btnDoiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(activityPhieuDoiBanBinding.etHotenPhieunhanphong.getText()).length() < 1
                        || tempData.doiBan==null) {
                    Toast.makeText(PhieuDoiBanActivity.this, "vui lòng chọn phòng để đổi và điền đầy đủ thông tin", Toast.LENGTH_LONG).show();
                } else {
                    BanDTO viTriBanDau=new BanDTO();
                    for (int i=0;i<banDTOList.size();i++){
                        if (sharedPreferences.getInt("BANID", 0)==banDTOList.get(i).getBanId()){
                            viTriBanDau=banDTOList.get(i);
                        }
                    }
                    BanDTO viTriDoi = tempData.doiBan;
                    doiBanDTO.setViTriBanDau(viTriBanDau);
                    doiBanDTO.setViTriDoi(viTriDoi);
                    doiBanDTO.setLyDoDoi(String.valueOf(activityPhieuDoiBanBinding.etHotenPhieunhanphong.getText()));
                    doiBanDTO.setGhiChu(String.valueOf(activityPhieuDoiBanBinding.etCccdPhieunhanphong.getText()));
                    banPresenter.DoiBan(doiBanDTO);
                    tempData.checkDoiBan = false;
                    tempData.doiBan=null;
                    onBackPressed();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (tempData.doiBan!=null){
            activityPhieuDoiBanBinding.tvDoiphongDataVitridoi.setText(String.valueOf(tempData.doiBan.getTenBan()));
        }
        else {
            activityPhieuDoiBanBinding.tvDoiphongDataVitridoi.setText(String.valueOf(""));
        }
    }

    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
        banDTOList=lsDanhSachBan;
    }

    @Override
    public void onLayDanhSachBanError(String error) {

    }

    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {

    }

    @Override
    public void onLayDanhSachLoaiBanError(String error) {

    }

    @Override
    public void onCapNhatTrangThaiBanSuccess() {

    }

    @Override
    public void onCapNhatTrangThaiBanError(String error) {

    }

    @Override
    public void onDoiBanSuccess() {
        Toast.makeText(PhieuDoiBanActivity.this, "đổi bàn thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDoiBanError(String error) {
        Toast.makeText(PhieuDoiBanActivity.this, "đổi bàn thất bại", Toast.LENGTH_LONG).show();
    }
}