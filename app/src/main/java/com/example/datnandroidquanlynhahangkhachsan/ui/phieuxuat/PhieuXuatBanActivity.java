package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThanhToan.ThanhToanActivity;
import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuXuatBanChiTietAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityPhieuXuatBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.XuatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThanhToan.ThanhToanTatCaBanActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.goiMon.goiMonContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.goiMon.goiMonPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietPresenter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PhieuXuatBanActivity extends AppCompatActivity implements PhieuXuatConTract.View, BanContract.View, PhieuNhanPhongChiTietContract.View, DsPhieuNhanPhongContract.View, HangHoaContract.View, goiMonContract.View {

    private List<PhieuXuatChiTietDTO> lsPhieuXuatCT;
    private List<BanDTO> lsBan;
    private List<GoiMonDTO> lsGoiMon;
    private List<HangHoaDTO> lsHangHoa;
    private List<PhieuXuatDTO> lsPhieuXuat;
    private List<PhieuNhanBanChiTietDTO> lsPhieuNhanCT;

    private List <LoaiBanDTO>lsLoaiBan;
    private Context context;

    private PhieuNhanDTO phieuNhanDTO;
    private RecyclerView recyclerView;
    DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    long tienDV;


    // lấy ngày hiện tại
    Date date = Calendar.getInstance().getTime();

    // Định dạng ngày hiển thị ra
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private PhieuXuatDTO tamPhieuXuatDTO;

    private List<PhieuXuatChiTietDTO> tamlsPhieuXuatChiTiet;

    private XuatPhongDTO xuatPhongDTO;
    private int temp = 0;

    private long PN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhieuXuatBanBinding phieuXuatBinding = ActivityPhieuXuatBanBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        SharedPreferences sharedPreferences1 = getSharedPreferences("GET_BANID", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();



        lsPhieuXuatCT = new ArrayList<>();
        lsPhieuNhanCT = new ArrayList<>();
        lsPhieuXuat = new ArrayList<>();
        tamlsPhieuXuatChiTiet = new ArrayList<>();
        lsHangHoa = new ArrayList<>();
        lsBan = new ArrayList<>();
        lsLoaiBan=new ArrayList<>();

        phieuNhanDTO = new PhieuNhanDTO();

        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);

        phieuXuatBinding.toolbarPhieutraphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();
                /// xóa dữ liệu bàn

                editor1.clear();
                editor1.apply();
                onBackPressed();
            }
        });
        String ten = sharedPreferences.getString("TEN", "");
        String cccd = sharedPreferences.getString("CCCD", "");
        String sdt = sharedPreferences.getString("SDT", "");
        String sct = sharedPreferences.getString("SCT", "");
        String ngay = sharedPreferences.getString("NGAYLAP", "");
        Long pxid = sharedPreferences.getLong("PXID", 0L);
        Long pnid = sharedPreferences.getLong("PNID", 0L);


        //// tính tổng tiền
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");



        phieuXuatBinding.etCccdPhieutraphong.setText(cccd);
        phieuXuatBinding.etHotenPhieutraphong.setText(ten);
        phieuXuatBinding.tvSdtptp.setText(sdt);
        phieuXuatBinding.tvSctData.setText(sct);
        phieuXuatBinding.tvNgaynhan.setText(ngay);


        /// lay ban
        BanPresenter banPresenter=new BanPresenter(this);
        banPresenter.LayDanhSachBan();

        // lay loại bàn
        banPresenter.LayDanhSachLoaiBan();




        ///lấy danh sach phiếu xuất ct
        PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatChiTietDTO dieuKienLocPhieuXuatChiTietDTO = new DieuKienLocPhieuXuatChiTietDTO();
        dieuKienLocPhieuXuatChiTietDTO.setPhieuXuatId(pxid);
        phieuXuatPresenter.LayDanhSachPhieuXuatChiTiet(dieuKienLocPhieuXuatChiTietDTO);

        //// lấy phiếu xuất khi đã có phiếu xuất r
        DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
        dieuKienLocPhieuXuatDTO.setPhieuXuatId(sharedPreferences.getLong("PXID", 0L));
        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);


        ////lấy danh sach phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanBanChiTietDTO dieuKienLocPhieuNhanBanChiTietDTO = new DieuKienLocPhieuNhanBanChiTietDTO();
        dieuKienLocPhieuNhanBanChiTietDTO.setPhieuNhanId(pnid);
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanBanChiTiet(dieuKienLocPhieuNhanBanChiTietDTO);

        ///

        ///lay hang hoa

        HangHoaPresenter hangHoaPresenter = new HangHoaPresenter(this);
        hangHoaPresenter.LayDanhSachHangHoa2("");

        /// lay Gọi món
        goiMonPresenter goiMonPresenter = new goiMonPresenter(this);
        GoiMonDTO goiMonDTO = new GoiMonDTO();
        goiMonDTO.setTrangThai("thanh");
        goiMonDTO.setGhiChu("");
        goiMonPresenter.LayDanhSachGoiMon(goiMonDTO);

        recyclerView = phieuXuatBinding.rscvSudung;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        PhieuXuatDTO phieuXuatDTO = new PhieuXuatDTO();
        PhieuNhanBanChiTietDTO phieuNhanBanChiTietDTO = new PhieuNhanBanChiTietDTO();
        BanDTO banDTO = new BanDTO();
        Date date = Calendar.getInstance().getTime();


        phieuXuatBinding.btnTraPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(PhieuXuatBanActivity.this, ThanhToanTatCaBanActivity.class);

                startActivity(intent);

            }
        });
        setContentView(phieuXuatBinding.getRoot());

    }

    @Override
    protected void onResume() {
        super.onResume();
        lsPhieuNhanCT = new ArrayList<>();
        lsGoiMon=new ArrayList<>();
    }


    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
        lsPhieuXuat = list;
        PhieuXuatBanChiTietAdapter phieuXuatBanChiTietAdapter = new PhieuXuatBanChiTietAdapter(this);
        phieuXuatBanChiTietAdapter.setData(this,lsLoaiBan, lsGoiMon, lsHangHoa, lsPhieuXuatCT, lsPhieuNhanCT, lsBan);
        recyclerView.setAdapter(phieuXuatBanChiTietAdapter);


        Button button=(Button) findViewById(R.id.btn_traPhong);
        TextView textView=findViewById(R.id.tv_tongdathanhtoan);
        DecimalFormat decimalFormat=new DecimalFormat("#,##0"+" đồng");
        for (int i=0;i<lsPhieuXuat.size();i++)
        {
            if (lsPhieuXuat.get(i).getTrangthai()==2)
            {
                button.setVisibility(View.GONE);
                textView.setText(String.valueOf(decimalFormat.format(lsPhieuXuat.get(i).getTongThanhTien())));
            }
        }

    }
    //lấy danh sách gọi món kèm theo điều kiện lọc
    @Override
    public void onLayDanhSachGoiMonSuccess(List<GoiMonDTO> list) {
        lsGoiMon = list;
        PhieuXuatBanChiTietAdapter phieuXuatBanChiTietAdapter = new PhieuXuatBanChiTietAdapter(this);
        phieuXuatBanChiTietAdapter.setData(this,lsLoaiBan, lsGoiMon, lsHangHoa, lsPhieuXuatCT, lsPhieuNhanCT, lsBan);
        recyclerView.setAdapter(phieuXuatBanChiTietAdapter);

        SharedPreferences sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        for (int i = 0; i < lsPhieuNhanCT.size(); i++) {
            for (int t = 0; t < lsGoiMon.size(); t++) {
                if ((lsGoiMon.get(t).getTrangThai().equals("chưa thanh toán") &&
                        lsPhieuNhanCT.get(i).getBanId() == lsGoiMon.get(t).getBanId()
                        && lsPhieuNhanCT.get(i).getTrangThai() == 4)
                        || (lsGoiMon.get(t).getTrangThai().equals("chờ thanh toán") &&
                        lsPhieuNhanCT.get(i).getBanId() == lsGoiMon.get(t).getBanId()
                        && lsPhieuNhanCT.get(i).getPhieuNhanId() == lsGoiMon.get(t).getPhieuNhanId())

                ) {
                    for (int p = 0; p < lsHangHoa.size(); p++) {
                        if (lsHangHoa.get(p).getHangHoaId() == lsGoiMon.get(t).getHangHoaId()) {
                            tienDV = tienDV + (lsHangHoa.get(p).getDonGia() * lsGoiMon.get(t).getSoLuong());
                        }
                    }

                }
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        TextView tvTong = findViewById(R.id.tv_tongPXB);
        tvTong.setText(String.valueOf(decimalFormat.format(tienDV)));
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("TT_DV", tienDV);
        editor.commit();


    }
    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
        lsPhieuXuatCT = list;
        PhieuXuatBanChiTietAdapter phieuXuatBanChiTietAdapter = new PhieuXuatBanChiTietAdapter(this);
        phieuXuatBanChiTietAdapter.setData(this,lsLoaiBan, lsGoiMon, lsHangHoa, lsPhieuXuatCT, lsPhieuNhanCT, lsBan);
        recyclerView.setAdapter(phieuXuatBanChiTietAdapter);


    }

    ////lấy danh sách phòng
    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
        lsBan = lsDanhSachBan;
        PhieuXuatBanChiTietAdapter phieuXuatBanChiTietAdapter = new PhieuXuatBanChiTietAdapter(this);
        phieuXuatBanChiTietAdapter.setData(this,lsLoaiBan, lsGoiMon, lsHangHoa, lsPhieuXuatCT, lsPhieuNhanCT, lsBan);
        recyclerView.setAdapter(phieuXuatBanChiTietAdapter);


    }

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietSuccess(List<PhieuNhanBanChiTietDTO> list) {
        lsPhieuNhanCT = list;
        PhieuXuatBanChiTietAdapter phieuXuatBanChiTietAdapter = new PhieuXuatBanChiTietAdapter(this);
        phieuXuatBanChiTietAdapter.setData(this,lsLoaiBan, lsGoiMon, lsHangHoa, lsPhieuXuatCT, lsPhieuNhanCT, lsBan);
        recyclerView.setAdapter(phieuXuatBanChiTietAdapter);


    }


    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {
        lsLoaiBan=list;
        PhieuXuatBanChiTietAdapter phieuXuatBanChiTietAdapter = new PhieuXuatBanChiTietAdapter(this);
        phieuXuatBanChiTietAdapter.setData(this,lsLoaiBan, lsGoiMon, lsHangHoa, lsPhieuXuatCT, lsPhieuNhanCT, lsBan);
        recyclerView.setAdapter(phieuXuatBanChiTietAdapter);

    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        lsHangHoa=list;
        PhieuXuatBanChiTietAdapter phieuXuatBanChiTietAdapter = new PhieuXuatBanChiTietAdapter(this);
        phieuXuatBanChiTietAdapter.setData(this,lsLoaiBan, lsGoiMon, lsHangHoa, lsPhieuXuatCT, lsPhieuNhanCT, lsBan);
        recyclerView.setAdapter(phieuXuatBanChiTietAdapter);

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
    public void onLayDanhSachPhieuXuatError(String error) {
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
    public void onLayDanhSachBanError(String error) {
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

    }

    @Override
    public void onDoiBanError(String error) {

    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {

    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietError(String error) {
    }


    @Override
    public void onLayDanhSachPhieuNhanBanChiTietError(String error) {
    }

    @Override
    public void onCapNhatPhieuNhanBanChiTietSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanBanChiTietError(String error) {
    }

    //lấy danh sách phiếu nhận phòng
    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
    }

    @Override
    public void onLayDanhSachPhieuNhanError(String error) {
    }

    //thêm phiếu đặt phòng
    @Override
    public void onThemPhieuNhanPhongSuccess() {
    }

    @Override
    public void onThemPhieuNhanPhongError(String error) {
    }

    //thêm phiếu nhận bàn
    @Override
    public void onThemPhieuNhanBanSuccess() {
    }

    @Override
    public void onThemPhieuNhanBanError(String error) {
    }

    @Override
    public void onCapNhatPhieuNhanSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanError(String error) {
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


    @Override
    public void onLayDanhSachGoiMonError(String error) {
    }

    //thêm xóa sửa go món
    @Override
    public void onCapNhatGoiMonSuccess() {
    }

    @Override
    public void onCapNhatGoiMonError(String error) {
    }

    @Override
    public void onCapNhatGMSuccess() {

    }

    @Override
    public void onCapNhatGMError(String error) {
    }


}