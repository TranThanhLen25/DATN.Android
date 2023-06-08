package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.ThanhToanActivity;
import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuXuatChiTietAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuXuatBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuPresenter;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PhieuXuatActivity extends AppCompatActivity implements PhieuXuatConTract.View, PhongContract.View, PhieuNhanPhongChiTietContract.View, LoaiPhongContract.View, DichVuContract.View {

    private List<PhieuXuatChiTietDTO> lsPhieuXuatCT;
    private List<PhongDTO> lsPhong;
    private List<LoaiPhongDTO> loaiPhong;
    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanCT;
    private Context context;

    private List<DichVuDTO> lsDichVu;
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
    long tongTienNgay;
    long tienDV;
    long tongAll;
    private Float tongTien;


    // lấy ngày hiện tại
    Date date = Calendar.getInstance().getTime();

    // Định dạng ngày hiển thị ra
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String today = formatter.format(date);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhieuXuatBinding phieuXuatBinding = ActivityPhieuXuatBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("PHIEUXUAT", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        lsPhieuXuatCT = new ArrayList<>();

        lsPhong = new ArrayList<>();
        loaiPhong = new ArrayList<>();
        lsDichVu = new ArrayList<>();
        lsPhieuNhanCT = new ArrayList<>();
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
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        phieuXuatBinding.tvTong.setText(String.valueOf(decimalFormat.format(sharedPreferences.getFloat("TONGTIEN", 0f))));

        phieuXuatBinding.etCccdPhieutraphong.setText(cccd);
        phieuXuatBinding.etHotenPhieutraphong.setText(ten);
        phieuXuatBinding.tvSdtptp.setText(sdt);
        phieuXuatBinding.tvSctData.setText(sct);
        phieuXuatBinding.tvNgaynhan.setText(ngay);

        ///lay Dv
        DichVuPresenter dichVuPresenter = new DichVuPresenter(this);
        DichVuDTO dichVuDTO = new DichVuDTO();
        dichVuDTO.setPhieuNhanID(sharedPreferences.getLong("PNID", 0L));
        dichVuPresenter.LayDvPn(dichVuDTO);

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

        phieuXuatBinding.btnTraPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhieuXuatActivity.this, ThanhToanActivity.class);
                startActivity(intent);
            }
        });
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
        PhieuXuatChiTietAdapter phieuXuatChiTietAdapter = new PhieuXuatChiTietAdapter(this);
        phieuXuatChiTietAdapter.setData(this, lsPhieuXuatCT, lsPhieuNhanCT, lsPhong, loaiPhong);
        recyclerView.setAdapter(phieuXuatChiTietAdapter);

        for (int t=0;t<lsDichVu.size();t++)
        {
            for(int i=0;i<lsPhieuNhanCT.size();i++)
            {
                if (lsPhieuNhanCT.get(i).getTrangThai()!=2)
                {
                    tienDV = tienDV + (lsDichVu.get(t).getDonGia() * lsDichVu.get(t).getSoLuong());
                }
                else
                {
                    tienDV=0L;
                }
            }

        }

        for (int i = 0; i < lsPhieuNhanCT.size(); i++) {
            if (lsPhieuNhanCT.get(i).getTrangThai()==2&&lsPhieuNhanCT.get(i).getTrangThai()==1) {
                NGAYNHAN = lsPhieuNhanCT.get(i).getThoiGianNhanPhong();
                NGAYTRA = lsPhieuNhanCT.get(i).getThoiGianTraPhong();
                Nhan = format.format(NGAYNHAN);

                Tra = format.format(NGAYTRA);
                vao = LocalDate.parse(Nhan, fm);
                ra = LocalDate.parse(Tra, fm);
                Ngay = ra.toEpochDay() - vao.toEpochDay();

                for (int a = 0; a < lsPhong.size(); a++) {

                    if (lsPhieuNhanCT.get(i).getPhongId() == lsPhong.get(a).getPhongId()) {

                        for (int f = 0; f < loaiPhong.size(); f++) {

                            if (lsPhong.get(a).getLoaiPhongId() == loaiPhong.get(f).getLoaiPhongId()) {
                                tongTienNgay = tongTienNgay + Ngay * loaiPhong.get(f).getDonGia();
                            }
                        }
                    }
                }

            }
            if(lsPhieuNhanCT.get(i).getTrangThai()==4)
            {
                NGAYNHAN = lsPhieuNhanCT.get(i).getThoiGianNhanPhong();
                NGAYTRA = date;
                Nhan = format.format(NGAYNHAN);

                Tra = format.format(NGAYTRA);
                vao = LocalDate.parse(Nhan, fm);
                ra = LocalDate.parse(Tra, fm);
                Ngay = ra.toEpochDay() - vao.toEpochDay();

                for (int a = 0; a < lsPhong.size(); a++) {

                    if (lsPhieuNhanCT.get(i).getPhongId() == lsPhong.get(a).getPhongId()) {

                        for (int f = 0; f < loaiPhong.size(); f++) {

                            if (lsPhong.get(a).getLoaiPhongId() == loaiPhong.get(f).getLoaiPhongId()) {
                                tongTienNgay = tongTienNgay + Ngay * loaiPhong.get(f).getDonGia();
                            }
                        }
                    }
                }

            }


        }

        tongAll = tienDV + tongTienNgay;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        TextView tvTong = findViewById(R.id.tv_tong);
        tvTong.setText(String.valueOf(decimalFormat.format(tongAll)));
        SharedPreferences sharedPreferences = getSharedPreferences("PHIEUXUAT", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putLong("TIENTHANHTOAN", tongAll);
        editor.commit();


    }

    @Override
    public void onLayDvPnSuccess(List<DichVuDTO> list) {
        lsDichVu = list;



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
    public void onLayDanhSachDichVuSuccess(List<DichVuDTO> list) {


    }

    @Override
    public void onLayDanhSachDichVuError(String error) {
    }

    //thêm dịch vụ
    @Override
    public void onthemDichVuSuccess() {
    }

    @Override
    public void onthemDichVuError(String error) {
    }

    //cập nhật điều kiện lọc
    @Override
    public void oncapNhatDichVuSuccess() {
    }

    @Override
    public void oncapNhatDichVuError(String error) {
    }
    /// lay dv theo Pn


    @Override
    public void onLayDvPnError(String error) {

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

    @Override
    public void onCapNhatDVSuccess() {
    }

    @Override
    public void onCapNhatDVError(String error) {
    }

}