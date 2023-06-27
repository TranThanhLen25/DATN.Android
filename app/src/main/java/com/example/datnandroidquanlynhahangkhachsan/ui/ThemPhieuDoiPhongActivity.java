package com.example.datnandroidquanlynhahangkhachsan.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieudoiphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DoiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonphong.ChonPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;

import java.util.ArrayList;
import java.util.List;

public class ThemPhieuDoiPhongActivity extends AppCompatActivity implements PhongContract.View {

    ActivityPhieudoiphongBinding phieudoiphongBinding;
    private PhongPresenter phongPresenter;
    private DoiPhongDTO doiPhongDTO;
    private SharedPreferences sharedPreferences;
    private List<PhongDTO> phongDTOList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        phieudoiphongBinding = ActivityPhieudoiphongBinding.inflate(getLayoutInflater());
        phieudoiphongBinding.toolbarPhieudoiphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.checkDoiPhong = false;
                tempData.doiPhong=null;
                onBackPressed();
            }
        });
        setContentView(phieudoiphongBinding.getRoot());
        phongPresenter = new PhongPresenter(this);
        doiPhongDTO = new DoiPhongDTO();
        phongPresenter.LayDanhSachPhong();

        sharedPreferences = getSharedPreferences("PHONG", MODE_PRIVATE);
        phieudoiphongBinding.tvDoiphongDataVitribandau.setText(String.valueOf(sharedPreferences.getInt("SOPHONG", 0)));
        phieudoiphongBinding.imgbtnDoiphongChonphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.checkDoiPhong = true;
                Intent intent = new Intent(ThemPhieuDoiPhongActivity.this, ChonPhongActivity.class);
                startActivity(intent);
            }
        });
        phieudoiphongBinding.btnDoiphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(phieudoiphongBinding.etLydo.getText()).length() < 1
                        || tempData.doiPhong==null) {
                    Toast.makeText(ThemPhieuDoiPhongActivity.this, "vui lòng chọn phòng để đổi và điền đầy đủ thông tin", Toast.LENGTH_LONG).show();
                } else {
                    PhongDTO viTriBanDau=new PhongDTO();
                    for (int i=0;i<phongDTOList.size();i++){
                        if (sharedPreferences.getInt("PHONGID", 0)==phongDTOList.get(i).getPhongId()){
                            viTriBanDau=phongDTOList.get(i);
                        }
                    }
                    PhongDTO viTriDoi = tempData.doiPhong;
                    doiPhongDTO.setViTriBanDau(viTriBanDau);
                    doiPhongDTO.setViTriDoi(viTriDoi);
                    doiPhongDTO.setLyDoDoi(String.valueOf(phieudoiphongBinding.etLydo.getText()));
                    doiPhongDTO.setGhiChu(String.valueOf(phieudoiphongBinding.etGhichu.getText()));
                    phongPresenter.DoiPhong(doiPhongDTO);
                    tempData.checkDoiPhong = false;
                    tempData.doiPhong=null;
                    onBackPressed();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (tempData.doiPhong!=null){
            phieudoiphongBinding.tvDoiphongDataVitridoi.setText(String.valueOf(tempData.doiPhong.getSoPhong()));
        }
        else {
            phieudoiphongBinding.tvDoiphongDataVitridoi.setText(String.valueOf(""));
        }
    }

    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong) {
        phongDTOList=lsDanhSachPhong;
    }

    @Override
    public void onLayDanhSachPhongError(String error) {

    }

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
    public void onDoiPhongSuccess() {
        Toast.makeText(ThemPhieuDoiPhongActivity.this, "đổi phòng thành công", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDoiPhongError(String error) {
        Toast.makeText(ThemPhieuDoiPhongActivity.this, "đổi phòng thất bại", Toast.LENGTH_LONG).show();

    }
}