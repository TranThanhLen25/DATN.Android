package com.example.datnandroidquanlynhahangkhachsan.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_Phong;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PhieuTraPhongActivity extends AppCompatActivity implements PhieuNhanPhongChiTietContract.View, PhongContract.View {
    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanPhongChiTiet;

    private PhongDTO phongDTO;
    private long PNCTid;
    private PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO;
    // lấy ngày hiện tại
    private Date day = Calendar.getInstance().getTime();
    private int phongid;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThemphieutraphongBinding phieuTraPhongBinding = ActivityThemphieutraphongBinding.inflate(getLayoutInflater());
        phieuTraPhongBinding.toolbarPhieutraphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
            }
        });
        lsPhieuNhanPhongChiTiet = new ArrayList<>();

        /// cập nhật trạng thái phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        /// lấy list phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter layDanhSach = new PhieuNhanPhongChiTietPresenter(this);

        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();

        layDanhSach.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);

        /// cập nhật trạng thái phòng
        PhongPresenter phongPresenter = new PhongPresenter(this);


        phieuTraPhongBinding.btnTraPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phieuNhanPhongChiTietDTO = new PhieuNhanPhongChiTietDTO();
                phongDTO = new PhongDTO();
                phongDTO.setPhongId(phongid);
                phongDTO.setTrangThaiId(1);
                phieuNhanPhongChiTietDTO.setPhieuNhanPhongChiTietId(PNCTid);
                // 0:Đang thuê
                // 1:Trả phòng
                phieuNhanPhongChiTietDTO.setTrangThai(1);
                /// tự lấy ngày hiện tại
                phieuNhanPhongChiTietDTO.setThoiGianTraPhong(day);

                phongPresenter.CapNhatTrangThaiPhong(phongDTO);

                phieuNhanPhongChiTietPresenter.CapNhatPhieuNhanPhongChiTiet(phieuNhanPhongChiTietDTO);
                ///xóa id đã lưu
                sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
             onBackPressed();


            }
        });
        setContentView(phieuTraPhongBinding.getRoot());
    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietSuccess() {
        Toast.makeText(this, "dc r nhe", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietError(String error) {
        Toast.makeText(this, "dell nha", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {
        lsPhieuNhanPhongChiTiet = list;
        SharedPreferences sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        phongid = sharedPreferences.getInt("PHONGID", 0);
        /// lấy giá trị phongfid gán cho PNCT
        for (int i = 0; i < lsPhieuNhanPhongChiTiet.size(); i++) {
            if (lsPhieuNhanPhongChiTiet.get(i).getPhongId() == phongid) {
                PNCTid = Long.valueOf(lsPhieuNhanPhongChiTiet.get(i).getPhieuNhanPhongChiTietId());
            }
        }

        Toast.makeText(this, "lay danh sach ne", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietError(String error) {
    }

    @Override
    public void onCapNhatTrangThaiPhongSuccess() {
    }

    @Override
    public void onCapNhatTrangThaiPhongError(String error) {
    }

    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong) {
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

}