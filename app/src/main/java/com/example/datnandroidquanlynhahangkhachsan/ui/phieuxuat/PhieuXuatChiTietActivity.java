package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.adapter.DanhSachPXCTAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuXuatChiTietBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PhieuXuatChiTietActivity extends AppCompatActivity implements PhieuXuatConTract.View, HangHoaContract.View {
    private List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet;
    private List<HangHoaDTO> lsHangHoa;
    private Context context;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhieuXuatChiTietBinding phieuXuatChiTietBinding = ActivityPhieuXuatChiTietBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        /////gán giá trị vào textview
        DecimalFormat decimalFormat = new DecimalFormat("#,##0" + " đồng");
        phieuXuatChiTietBinding.tvGiaPtp.setText(String.valueOf(decimalFormat.format(sharedPreferences.getInt("GIA", 0))));
        phieuXuatChiTietBinding.tvHotenPtp.setText(sharedPreferences.getString("TEN", ""));
        phieuXuatChiTietBinding.tvSdtptp.setText(sharedPreferences.getString("SDT", ""));
        phieuXuatChiTietBinding.tvCccdPtp.setText(sharedPreferences.getString("CCCD", ""));
        phieuXuatChiTietBinding.tvPhongData.setText(String.valueOf(sharedPreferences.getInt("SOPHONG", 0)));
        phieuXuatChiTietBinding.tvSongaythue.setText(String.valueOf(sharedPreferences.getLong("SONGAY", 0)));
        phieuXuatChiTietBinding.tvNgaynhan.setText(sharedPreferences.getString("NGAYVAO", ""));
        phieuXuatChiTietBinding.tvNgaytra.setText(sharedPreferences.getString("NGAYRA", ""));
        phieuXuatChiTietBinding.tvGiaPtp.setText(String.valueOf(decimalFormat.format(sharedPreferences.getInt("GIA", 0))));

        phieuXuatChiTietBinding.toolbarPhieutraphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        setContentView(phieuXuatChiTietBinding.getRoot());

        lsPhieuXuatChiTiet = new ArrayList<>();
        lsHangHoa = new ArrayList<>();

        /// lay PXCT
        PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatChiTietDTO dieuKienLocPhieuXuatChiTietDTO = new DieuKienLocPhieuXuatChiTietDTO();
        dieuKienLocPhieuXuatChiTietDTO.setPhieuNhanPhongChiTietId(sharedPreferences.getLong("PNPCT", 0L));
        phieuXuatPresenter.LayDanhSachPhieuXuatChiTiet(dieuKienLocPhieuXuatChiTietDTO);
        /// lay Hang hoa
        ///lay hanghoa
        HangHoaPresenter hangHoaPresenter = new HangHoaPresenter(this);
        hangHoaPresenter.LayDanhSachHangHoa2("");


        recyclerView = phieuXuatChiTietBinding.rscvSudung;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void onThemPhieuXuatSuccess() {
    }

    @Override
    public void onThemPhieuXuatError(String error) {
    }

    @Override
    public void onThemPhieuXuatChiTietSuccess() {
    }

    @Override
    public void onThemPhieuXuatChiTietError(String error) {
    }


    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
    }

    @Override
    public void onLayDanhSachPhieuXuatError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
        lsPhieuXuatChiTiet = list;
        DanhSachPXCTAdapter danhSachPXCTAdapter = new DanhSachPXCTAdapter(this);
        danhSachPXCTAdapter.setData(lsHangHoa, context, lsPhieuXuatChiTiet);
        recyclerView.setAdapter(danhSachPXCTAdapter);
        SharedPreferences sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        TextView tvTong=findViewById(R.id.tv_tongTien_pxct);
        double a=0.0d;
        for (int i=0;i<lsPhieuXuatChiTiet.size();i++)
        {
            a=a+lsPhieuXuatChiTiet.get(i).getThanhTien();
        }
        DecimalFormat decimalFormat=new DecimalFormat("#,##0"+" đồng");
        tvTong.setText(String.valueOf(decimalFormat.format(sharedPreferences.getLong("SONGAY",0)*sharedPreferences.getInt("GIA",0)+a)));




    }

    @Override
    public void onLayDanhSachPhieuXuatChiTietError(String error) {
    }

    @Override
    public void onCapNhatPXSuccess() {
    }

    @Override
    public void onCapNhatPXError(String error) {
    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {

        lsHangHoa = list;
        DanhSachPXCTAdapter danhSachPXCTAdapter = new DanhSachPXCTAdapter(this);
        danhSachPXCTAdapter.setData(lsHangHoa, context, lsPhieuXuatChiTiet);
        recyclerView.setAdapter(danhSachPXCTAdapter);
    }

    @Override
    public void onLayDanhSachHangHoaError(String error) {
    }

    @Override
    public void onThemHangHoaSuccess() {

    }

    @Override
    public void onThemHangHoaError(String error) {

    }

    @Override
    public void onXoaHangHoaSuccess() {

    }

    @Override
    public void onXoaHangHoaError(String error) {

    }

    @Override
    public void onCapNhatHangHoaSuccess() {

    }

    @Override
    public void onCapNhatHangHoaError(String error) {

    }

}