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
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietPresenter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhieuXuatActivity extends AppCompatActivity implements PhieuXuatConTract.View, PhongContract.View, PhieuNhanPhongChiTietContract.View, LoaiPhongContract.View {

    private List<PhieuXuatChiTietDTO> lsPhieuXuatCT;
    private List<PhongDTO> lsPhong;
    private List<LoaiPhongDTO> loaiPhong;
    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanCT;
    private Context context;
    private RecyclerView recyclerView;

    DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    ///đếm ngày
    LocalDate vao;
    LocalDate ra;
    /// dùng để format đúng định dạng
    private String Nhan;

    private String Tra;
    ///gán ngày trong CSDL vào
    private Date NGAYNHAN;
    private Date NGAYTRA;

    private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    long Ngay = 0;
    private Float tongTien;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhieuXuatBinding phieuXuatBinding = ActivityPhieuXuatBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("PHIEUXUAT", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        lsPhieuXuatCT = new ArrayList<>();
        lsPhieuNhanCT = new ArrayList<>();
        lsPhong = new ArrayList<>();
        loaiPhong = new ArrayList<>();
        /// lấy loại phòng
        LoaiPhongPresenter loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();
        //// lấy phòng
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
        Long pnid = sharedPreferences.getLong("PNID", 0L);
        //// tính tổng tiền
        DecimalFormat decimalFormat=new DecimalFormat("#,##0");
        phieuXuatBinding.tvTong.setText(String.valueOf(decimalFormat.format(sharedPreferences.getFloat("TONGTIEN", 0f)) ));

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
        dieuKienLocPhieuNhanPhongChiTietDTO.setPhieuNhanId(pnid);
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);

        ///

        recyclerView = phieuXuatBinding.rscvSudung;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        setContentView(phieuXuatBinding.getRoot());

    }


    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
        lsPhieuXuatCT = list;
        PhieuXuatChiTietAdapter phieuXuatChiTietAdapter = new PhieuXuatChiTietAdapter(this);
        phieuXuatChiTietAdapter.setData(this, lsPhieuXuatCT, lsPhieuNhanCT, lsPhong, loaiPhong);
        recyclerView.setAdapter(phieuXuatChiTietAdapter);

    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {
        lsPhieuNhanCT = list;
        for (int i = 0; i < lsPhieuNhanCT.size(); i++) {
            NGAYNHAN = lsPhieuNhanCT.get(i).getThoiGianNhanPhong();
            NGAYTRA = lsPhieuNhanCT.get(i).getThoiGianTraPhong();
            Nhan = format.format(NGAYNHAN);
            Tra = format.format(NGAYTRA);
            vao = LocalDate.parse(Nhan, fm);
            ra = LocalDate.parse(Tra, fm);
            Ngay = Ngay + (ra.toEpochDay() - vao.toEpochDay());
        }
        PhieuXuatChiTietAdapter phieuXuatChiTietAdapter = new PhieuXuatChiTietAdapter(this);
        phieuXuatChiTietAdapter.setData(this, lsPhieuXuatCT, lsPhieuNhanCT, lsPhong, loaiPhong);
        recyclerView.setAdapter(phieuXuatChiTietAdapter);


    }

    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong) {
        lsPhong = lsDanhSachPhong;
        PhieuXuatChiTietAdapter phieuXuatChiTietAdapter = new PhieuXuatChiTietAdapter(this);
        phieuXuatChiTietAdapter.setData(this, lsPhieuXuatCT, lsPhieuNhanCT, lsPhong, loaiPhong);
        recyclerView.setAdapter(phieuXuatChiTietAdapter);


    }

    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> lsLoaiPhong) {
        loaiPhong = lsLoaiPhong;
        PhieuXuatChiTietAdapter phieuXuatChiTietAdapter = new PhieuXuatChiTietAdapter(this);
        phieuXuatChiTietAdapter.setData(this, lsPhieuXuatCT, lsPhieuNhanCT, lsPhong, loaiPhong);
        recyclerView.setAdapter(phieuXuatChiTietAdapter);

    }

    @Override
    public void onLayLoaiPhongError(String error) {
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

    @Override
    public void onThemPhieuXuatChiTietSuccess() {
    }

    @Override
    public void onThemPhieuXuatChiTietError(String error) {
    }


}