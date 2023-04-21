package com.example.datnandroidquanlynhahangkhachsan.ui.chonphong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.datnandroidquanlynhahangkhachsan.adapter.ChonPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChonPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;

import java.util.ArrayList;
import java.util.List;


public class ChonPhongActivity extends AppCompatActivity implements PhongContract.View , LoaiPhongContract.View {
    private List<PhongDTO> lsphong;

    private List<LoaiPhongDTO> lsloaiPhong;
    private RecyclerView rscv;
    private ActivityChonPhongBinding chonPhongBinding;
    private ChonPhongAdapter chonPhongAdapter;
    private ArrayAdapter<LoaiPhongDTO> adapter;
    private Spinner spinner;
    private PhongPresenter danhSachPhongPresenter;
    private LoaiPhongPresenter loaiPhongPresenter;
    Context context = this;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chonPhongBinding = ActivityChonPhongBinding.inflate(getLayoutInflater());
        //lấy loại phòng
        lsloaiPhong = new ArrayList<>();
        loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();
        //lấy phòng
        lsphong = new ArrayList<>();
        rscv = chonPhongBinding.rscvChonphong;
        danhSachPhongPresenter = new PhongPresenter(ChonPhongActivity.this);
        danhSachPhongPresenter.LayDanhSachPhong();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        rscv.setLayoutManager(gridLayoutManager);
        setContentView(chonPhongBinding.getRoot());

        chonPhongBinding.incluChonphong.icBack.setOnClickListener(view -> onBackPressed());
    }

   @Override
    public void onLayDanhSachPhong1gSuccess(List<PhongDTO> list) {


    }
    @Override
    public void onLayDanhSachPhong1gError(String error) {
        Toast.makeText(this, "Lay du lieu that bai", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCapNhatTrangThaiPhongSuccess() {

    }

    @Override
    public void onCapNhatTrangThaiPhongError(String error) {

    }

    @Override
    public void onLayDanhSachPhongError(String error) {

    }
    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> list) {
        lsphong = list;
        chonPhongAdapter = new ChonPhongAdapter(this);
        chonPhongAdapter.setData(lsphong, lsloaiPhong, context);
        rscv.setAdapter(chonPhongAdapter);
    }
    //lấy danh sách loại phòng hiển thị và spinner
        @Override
        public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> list) {
            lsloaiPhong=list;
        }

        @Override
        public void onLayLoaiPhongError(String error) {
            Toast.makeText(this, "Lay du lieu that bai", Toast.LENGTH_LONG).show();
        }


}
