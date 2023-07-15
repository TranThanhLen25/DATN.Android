package com.example.datnandroidquanlynhahangkhachsan.ui.ThanhToan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.Toolbar_Drawer_Activity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThanhToanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.XuatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu.PhieuThuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu.PhieuThuPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.goiMon.goiMonContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.goiMon.goiMonPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatConTract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatPresenter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThanhToanBanActivity extends AppCompatActivity implements PhieuThuContract.View, HangHoaContract.View, goiMonContract.View, BanContract.View, DsPhieuNhanPhongContract.View, PhieuNhanPhongChiTietContract.View, PhieuXuatConTract.View, KhachHangContract.View {
    private List<GoiMonDTO> lsGoiMon;
    private List<HangHoaDTO> lsHangHoa;
    private Context context;
    private RecyclerView rccvDv;
    private List<PhieuNhanDTO> lsPhieuNhan;

    private List<PhieuXuatDTO> lsPhieuXuat;

    private List<PhieuNhanBanChiTietDTO> lsPhieuNhanBanChiTiet;

    private List<KhachHangDTO> lsKhachHang;

    private List<PhieuXuatChiTietDTO> tamlsPhieuXuatChiTiet;

    private PhieuXuatDTO tamPhieuXuatDTO;

    private XuatPhongDTO xuatPhongDTO;

    private PhieuXuatChiTietDTO phieuXuatChiTietDTO;

    private PhieuNhanBanChiTietDTO phieuNhanBanChiTietDTO;

    private int tongtien = 0;

    private long Pn;

    private long Pnct;

    private int Ndid;

    private long KHid;

    private int temp = 0;


    //// sd cho phieu thu

    private Long tienThoi;
    private int tienDua;
    private List<PhieuThuDTO> lsPhieuThu;
    private PhieuThuDTO phieuThuDTO;
    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = Calendar.getInstance().getTime();
    String today = formatter.format(date);

    float dua;
    float thoi;
    String Pttt = "Tiền mặt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThanhToanBinding thanhToanBinding = ActivityThanhToanBinding.inflate(getLayoutInflater());
        setContentView(thanhToanBinding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("GET_BANID", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        lsHangHoa = new ArrayList<>();
        lsGoiMon = new ArrayList<>();
        lsPhieuNhan = new ArrayList<>();
        lsPhieuNhanBanChiTiet = new ArrayList<>();
        lsKhachHang = new ArrayList<>();
        tamlsPhieuXuatChiTiet = new ArrayList<>();

        BanDTO banDTO = new BanDTO();
        phieuNhanBanChiTietDTO = new PhieuNhanBanChiTietDTO();
        PhieuNhanDTO phieuNhanDTO = new PhieuNhanDTO();
        PhieuXuatDTO phieuXuatDTO = new PhieuXuatDTO();

        /// lấy danh sách phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanBanChiTietDTO dieuKienLocPhieuNhanBanChiTietDTO = new DieuKienLocPhieuNhanBanChiTietDTO();
        dieuKienLocPhieuNhanBanChiTietDTO.setPhieuNhanId(sharedPreferences.getLong("PNID", 0L));
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanBanChiTiet(dieuKienLocPhieuNhanBanChiTietDTO);

        ///Khai báo để lấy phiếu xuất
        PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
        dieuKienLocPhieuXuatDTO.setSoChungTu("pb");
        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);

        /// lay phieu nhan
        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
        dieuKienLocPhieuNhanDTO.setTrangThai("đang nhận");
        dieuKienLocPhieuNhanDTO.setLoaiPhieu(4);
        phieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);

        /// /lay hanghoa
        HangHoaPresenter hangHoaPresenter = new HangHoaPresenter(this);
        hangHoaPresenter.LayDanhSachHangHoa2("");

        /// lay Goi mon
        goiMonPresenter goiMonPresenter = new goiMonPresenter(this);
        GoiMonDTO goiMonDTO = new GoiMonDTO();

        if (sharedPreferences.getInt("KTTT", 0) == 4) {
            goiMonDTO.setBanId(sharedPreferences.getInt("BANID", 0));
            goiMonDTO.setTrangThai("chưa thanh toán");
            goiMonDTO.setGhiChu("");
            goiMonPresenter.LayDanhSachGoiMon(goiMonDTO);
        }
        if (sharedPreferences.getInt("KTTT", 0) == 1) {
            goiMonDTO.setBanId(sharedPreferences.getInt("BANID", 0));
            goiMonDTO.setTrangThai("chờ thanh toán");
            goiMonDTO.setGhiChu("");
            goiMonPresenter.LayDanhSachGoiMon(goiMonDTO);
        }


        ///khach hang
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);


        //////////


        thanhToanBinding.tvTendata.setText(sharedPreferences.getString("TEN", ""));

        lsPhieuThu = new ArrayList<>();
        PhieuThuPresenter phieuThuPresenter = new PhieuThuPresenter(this);
        phieuThuPresenter.LayDanhSachPhieuThu();


        DecimalFormat decimalFormat = new DecimalFormat("#,##0");

        Long tienTT = sharedPreferences.getLong("TT_NGAY", 0L) + sharedPreferences.getLong("TT_DV", 0L);
        thanhToanBinding.etThanhtoan.setText(String.valueOf(decimalFormat.format(tienTT)) + " đồng");
        thanhToanBinding.tvNgaylap.setText(today);


        thanhToanBinding.etDua.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //// tính tiền thừa khi khác đưa dư

                if (thanhToanBinding.etDua.getText().length() == 0) {

                    thanhToanBinding.tvThoinew.setText(String.valueOf(decimalFormat.format(0)) + " đồng");
                    thoi = 0;

                } else {
                    Long a = Long.parseLong(charSequence.toString());
                    Long chage = a - tienTT;
                    thanhToanBinding.tvThoinew.setText(String.valueOf(decimalFormat.format(chage)) + " đồng");
                    thoi = Float.valueOf(String.valueOf(chage));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        thanhToanBinding.tienmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// tên PTTT
                Pttt = "Tiền mặt";
                /// xét màu khi chọn
                thanhToanBinding.chuyenkhoan.setTextColor(Color.GRAY);
                thanhToanBinding.tienmat.setTextColor(Color.BLACK);

            }
        });


        /// khai bao ban
        BanPresenter banPresenter = new BanPresenter(this);


        thanhToanBinding.toolbarThanhtoan.icBack.setOnClickListener(view -> onBackPressed());


        thanhToanBinding.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thanhToanBinding.etDua.getText().length() > 0) {
                    dua = Float.valueOf(thanhToanBinding.etDua.getText().toString());
                } else {
                    dua = 0f;
                }

                if (dua < tienTT) {
                    Toast.makeText(ThanhToanBanActivity.this, "Vui lòng thanh toán đủ tiền!", Toast.LENGTH_SHORT).show();
                } else {
                    phieuThuDTO = new PhieuThuDTO(
                            "PT" + (lsPhieuThu.size() + 1),
                            date,
                            tienTT,
                            dua,
                            thoi,
                            Pttt,
                            "",
                            sharedPreferences.getLong("PNID", 0L),
                            thanhToanBinding.etGhichu.getText().toString()
                    );
                    phieuThuPresenter.ThemPhieuThu(phieuThuDTO);


                    if (sharedPreferences.getInt("KTTT", 0) == 4) {
                        banDTO.setBanId(sharedPreferences.getInt("BANID", 0));
                        banDTO.setTrangThaiId(1002);
                        banPresenter.CapNhatTrangThaiBan(banDTO);
                    }
                    ////lay thong tin tu Phieu nhan CT

                    /// cap nhat PNCT
                    for (int i = 0; i < lsPhieuNhanBanChiTiet.size(); i++) {
                        if (lsPhieuNhanBanChiTiet.get(i).getBanId() == sharedPreferences.getInt("BANID", 0)) {
                            Pnct = lsPhieuNhanBanChiTiet.get(i).getPhieuDatBanChiTietId();
                            Pn = lsPhieuNhanBanChiTiet.get(i).getPhieuNhanId();
                            phieuNhanBanChiTietDTO.setPhieuDatBanChiTietId(lsPhieuNhanBanChiTiet.get(i).getPhieuDatBanChiTietId());
                            // 4 :Đang thuê
                            // 1:Trả phòng chưa thanh toán
                            // 2: Đã thanh toán
                            phieuNhanBanChiTietDTO.setTrangThai(2);
                            if (lsPhieuNhanBanChiTiet.get(i).getThoiGianTraBan() != null) {
                                phieuNhanBanChiTietDTO.setThoiGianTraBan(lsPhieuNhanBanChiTiet.get(i).getThoiGianTraBan());

                            } else {
                                /// tự lấy ngày hiện tại
                                phieuNhanBanChiTietDTO.setThoiGianTraBan(Calendar.getInstance().getTime());

                            }


                            phieuNhanPhongChiTietPresenter.CapNhatPhieuNhanBanChiTiet(phieuNhanBanChiTietDTO);
                        }
                    }

                    for (int i = 0; i < lsPhieuNhan.size(); i++) {

                        if (lsPhieuNhan.get(i).getPhieuNhanId() == Pn) {

                            phieuNhanDTO.setPhieuNhanId(Pn);
                            phieuNhanDTO.setSoChungTu(lsPhieuNhan.get(i).getSoChungTu());
                            phieuNhanDTO.setNgayTra(date);
                            phieuNhanDTO.setTrangThai("đã trả");
                            phieuNhanPhongPresenter.CapNhatPhieuNhan(phieuNhanDTO);
                            KHid = lsPhieuNhan.get(i).getKhachHangId();
                            Ndid = lsPhieuNhan.get(i).getNguoiDungId();
                        }
                    }
                    ///cap nhat GM
                    for (int a = 0; a < lsGoiMon.size(); a++) {
                        goiMonDTO.setGoiMonId(lsGoiMon.get(a).getGoiMonId());
                        goiMonDTO.setGhiChu("");
                        goiMonDTO.setPhieuNhanId(Pn);
                        goiMonDTO.setTrangThai("đã thanh toán");
                        goiMonPresenter.CapNhatGM(goiMonDTO);

                    }
                    ///Thêm phiếu xuất///và pxct
                    ////kiểm tra có px ch
                    /// nếu có thì thêm pxct
                    ///nếu chưa thì tạo px mới

                    for (int i = 0; i < lsPhieuXuat.size(); i++) {
                        if (lsPhieuXuat.get(i).getPhieuNhanId() == Pn) {
                            for (int a = 0; a < lsGoiMon.size(); a++) {
                                for (int x = 0; x < lsHangHoa.size(); x++) {
                                    if (lsHangHoa.get(x).getHangHoaId() == lsGoiMon.get(a).getHangHoaId()) {
                                        PhieuXuatChiTietDTO phieuXuatChiTietDTO = new PhieuXuatChiTietDTO(
                                                lsPhieuXuat.get(i).getPhieuXuatId()
                                                , lsGoiMon.get(a).getHangHoaId()
                                                , Double.valueOf(lsGoiMon.get(a).getSoLuong())
                                                , Double.valueOf(lsHangHoa.get(x).getDonGia())
                                                , Double.valueOf((lsGoiMon.get(a).getSoLuong()) * (lsHangHoa.get(x).getDonGia()))
                                                , "", "", 1L
                                                , Pnct);
                                        phieuXuatPresenter.ThemPhieuXuatChiTiet(phieuXuatChiTietDTO);
                                        temp = 0;
                                    }
                                }


                            }
                            /// cap nhat phieu xuat
                            phieuXuatDTO.setPhieuXuatId(lsPhieuXuat.get(i).getPhieuXuatId());
                            phieuXuatDTO.setTrangthai(1);
                            phieuXuatDTO.setSoChungTu(lsPhieuXuat.get(i).getSoChungTu());
                            phieuXuatDTO.setTongThanhTien(lsPhieuXuat.get(i).getTongThanhTien() + sharedPreferences.getLong("TT_DV", 0L));
                            phieuXuatPresenter.CapNhatPX(phieuXuatDTO);

                        } else {
                            temp++;
                        }

                    }
                    if (temp == lsPhieuXuat.size()) {
                        tamPhieuXuatDTO = new PhieuXuatDTO(
                                KHid
                                , "PB" + (lsPhieuXuat.size() + 1)
                                , Pn
                                , date
                                , Ndid
                                , sharedPreferences.getLong("TT_DV", 0L)
                                , 0, 0, 1, ""
                        );
                        for (int r = 0; r < lsGoiMon.size(); r++) {
                            for (int a = 0; a < lsHangHoa.size(); a++) {
                                if (lsHangHoa.get(a).getHangHoaId() == lsGoiMon.get(r).getHangHoaId()) {
                                    phieuXuatChiTietDTO = new PhieuXuatChiTietDTO(
                                            lsGoiMon.get(r).getHangHoaId()
                                            , Double.valueOf(lsGoiMon.get(r).getSoLuong())
                                            , Double.valueOf(lsHangHoa.get(r).getDonGia())
                                            , Double.valueOf(lsGoiMon.get(r).getSoLuong() * lsHangHoa.get(a).getDonGia())
                                            , ""
                                            , "", 1L
                                            , Pnct
                                    );
                                    tamlsPhieuXuatChiTiet.add(phieuXuatChiTietDTO);
                                }
                            }

                        }
                        xuatPhongDTO = new XuatPhongDTO(tamPhieuXuatDTO, tamlsPhieuXuatChiTiet);
                        phieuXuatPresenter.ThemPhieuXuat(xuatPhongDTO);
                    }


                    editor.clear();
                    editor.apply();

                    Intent intent = new Intent(ThanhToanBanActivity.this, Toolbar_Drawer_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    finish();

                }
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        lsPhieuNhanBanChiTiet = new ArrayList<>();
        /// lấy danh sách phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanBanChiTietDTO dieuKienLocPhieuNhanBanChiTietDTO = new DieuKienLocPhieuNhanBanChiTietDTO();
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanBanChiTiet(dieuKienLocPhieuNhanBanChiTietDTO);

        lsGoiMon = new ArrayList<>();
        lsPhieuNhan = new ArrayList<>();

        /// lay phieu nhan
        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
        dieuKienLocPhieuNhanDTO.setTrangThai("đang nhận");
        dieuKienLocPhieuNhanDTO.setLoaiPhieu(4);
        phieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);

        lsKhachHang = new ArrayList<>();
        ///khach hang
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);


    }

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietSuccess(List<PhieuNhanBanChiTietDTO> list) {

        lsPhieuNhanBanChiTiet = list;
    }

    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
        lsPhieuNhan = list;

    }

    @Override
    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {
        lsKhachHang = list;

    }


    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        lsHangHoa = list;

    }

    @Override
    public void onLayDanhSachGoiMonSuccess(List<GoiMonDTO> list) {
        lsGoiMon = list;


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

    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
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

    }

    @Override
    public void onDoiBanError(String error) {

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
        lsPhieuXuat = list;

    }

    @Override
    public void onLayDanhSachPhieuThuSuccess(List<PhieuThuDTO> list) {
        lsPhieuThu = list;
        TextView sct = findViewById(R.id.tv_sochungtutt);
        sct.setText(String.valueOf("PTT" + lsPhieuThu.size()));
    }

    @Override
    public void onLayDanhSachPhieuThuError(String error) {
    }

    //thêm phiếu đặt phòng
    @Override
    public void onThemPhieuThuSuccess() {
    }

    @Override
    public void onThemPhieuThuError(String error) {
    }


    @Override
    public void onLayDanhSachPhieuXuatError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
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
    public void onThemKhachHangSuccess() {
    }

    @Override
    public void onThemKhachHangError(String error) {
    }


    @Override
    public void onLayDanhSachKhachHangError(String error) {
    }

    @Override
    public void onCapNhatPhieuNhanBanChiTietSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanBanChiTietError(String error) {
    }

}