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

import com.example.datnandroidquanlynhahangkhachsan.MainActivity;
import com.example.datnandroidquanlynhahangkhachsan.Nav_Ban_Activity;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.Toolbar_Drawer_Activity;
import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuXuatBanChiTietAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThanhToanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.XuatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThanhToanTatCaBanActivity extends AppCompatActivity implements PhieuThuContract.View, PhieuXuatConTract.View, BanContract.View, PhieuNhanPhongChiTietContract.View, DsPhieuNhanPhongContract.View, HangHoaContract.View, goiMonContract.View {

    private List<PhieuXuatChiTietDTO> lsPhieuXuatCT;
    private List<BanDTO> lsBan;
    private List<GoiMonDTO> lsGoiMon;
    private List<HangHoaDTO> lsHangHoa;
    private List<PhieuXuatDTO> lsPhieuXuat;
    private List<PhieuNhanBanChiTietDTO> lsPhieuNhanCT;

    private List<LoaiBanDTO> lsLoaiBan;
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
    /////
    private Long tienThoi;
    private int tienDua;
    private List<PhieuThuDTO> lsPhieuThu;
    private PhieuThuDTO phieuThuDTO;


    String today = formatter.format(date);

    float dua;
    float thoi;
    String Pttt = "Tiền mặt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThanhToanBinding thanhToanBinding = ActivityThanhToanBinding.inflate(getLayoutInflater());
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
        lsLoaiBan = new ArrayList<>();

        phieuNhanDTO = new PhieuNhanDTO();

        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);

        thanhToanBinding.toolbarThanhtoan.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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


        /// lay ban
        BanPresenter banPresenter = new BanPresenter(this);
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


        ///lay hang hoa

        HangHoaPresenter hangHoaPresenter = new HangHoaPresenter(this);
        hangHoaPresenter.LayDanhSachHangHoa2("");

        /// lay Gọi món
        goiMonPresenter goiMonPresenter = new goiMonPresenter(this);
        GoiMonDTO goiMonDTO = new GoiMonDTO();
        goiMonDTO.setTrangThai("thanh");
        goiMonDTO.setGhiChu("");
        goiMonPresenter.LayDanhSachGoiMon(goiMonDTO);

        ////////

        thanhToanBinding.tvTendata.setText(sharedPreferences.getString("TEN", ""));

        lsPhieuThu = new ArrayList<>();
        PhieuThuPresenter phieuThuPresenter = new PhieuThuPresenter(this);
        phieuThuPresenter.LayDanhSachPhieuThu();


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


        PhieuXuatDTO phieuXuatDTO = new PhieuXuatDTO();
        PhieuNhanBanChiTietDTO phieuNhanBanChiTietDTO = new PhieuNhanBanChiTietDTO();
        BanDTO banDTO = new BanDTO();


        thanhToanBinding.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thanhToanBinding.etDua.getText().length() > 0) {
                    dua = Float.valueOf(thanhToanBinding.etDua.getText().toString());
                } else {
                    dua = 0f;
                }

                if (dua < tienTT) {
                    Toast.makeText(ThanhToanTatCaBanActivity.this, "Vui lòng thanh toán đủ tiền!", Toast.LENGTH_SHORT).show();
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


                    phieuNhanDTO.setPhieuNhanId(pnid);
                    phieuNhanDTO.setSoChungTu(String.valueOf(sct));
                    phieuNhanDTO.setNgayTra(date);
                    phieuNhanDTO.setTrangThai("đã trả");
                    phieuNhanPhongPresenter.CapNhatPhieuNhan(phieuNhanDTO);

                    //// cap nhat PNct và tạo PXCT
                    for (int i = 0; i < lsPhieuNhanCT.size(); i++) {
                        for (int a = 0; a < lsGoiMon.size(); a++) {
                            if ((lsGoiMon.get(a).getTrangThai().equals("chưa thanh toán")
                                    && lsGoiMon.get(a).getBanId() == lsPhieuNhanCT.get(i).getBanId()
                                    && lsPhieuXuat.size() != 0
                                    && lsPhieuNhanCT.get(i).getTrangThai() == 4)

                                    || (lsGoiMon.get(a).getTrangThai().equals("chờ thanh toán")
                                    && lsPhieuNhanCT.get(i).getPhieuNhanId() == lsGoiMon.get(a).getPhieuNhanId()
                                    && lsGoiMon.get(a).getBanId() == lsPhieuNhanCT.get(i).getBanId()
                                    && lsPhieuXuat.size() != 0
                            )) {

                                for (int u = 0; u < lsHangHoa.size(); u++) {
                                    if (lsHangHoa.get(u).getHangHoaId() == lsGoiMon.get(a).getHangHoaId()) {
                                        PhieuXuatChiTietDTO phieuXuatChiTietDTO = new PhieuXuatChiTietDTO(
                                                pxid
                                                , lsGoiMon.get(a).getHangHoaId()
                                                , Double.valueOf(lsGoiMon.get(a).getSoLuong())
                                                , Double.valueOf(lsHangHoa.get(u).getDonGia())
                                                , Double.valueOf(lsGoiMon.get(a).getSoLuong() * lsHangHoa.get(u).getDonGia())
                                                , "", "", 1L
                                                , lsPhieuNhanCT.get(i).getPhieuDatBanChiTietId()
                                        );
                                        /// tạo phiếu xuất chi tiết mới
                                        phieuXuatPresenter.ThemPhieuXuatChiTiet(phieuXuatChiTietDTO);
                                        // cap nhat GM
                                        goiMonDTO.setGoiMonId(lsGoiMon.get(a).getGoiMonId());
                                        goiMonDTO.setGhiChu("");
                                        goiMonDTO.setPhieuNhanId(pnid);
                                        goiMonDTO.setTrangThai("đã thanh toán");
                                        goiMonPresenter.CapNhatGM(goiMonDTO);
                                    }
                                }


                            }


                        }

                        if (lsPhieuNhanCT.get(i).getTrangThai() != 2) {
                            phieuNhanBanChiTietDTO.setPhieuDatBanChiTietId(lsPhieuNhanCT.get(i).getPhieuDatBanChiTietId());
                            phieuNhanBanChiTietDTO.setTrangThai(2);
                            if (lsPhieuNhanCT.get(i).getThoiGianTraBan() == null) {
                                phieuNhanBanChiTietDTO.setThoiGianTraBan(date);
                            } else {
                                phieuNhanBanChiTietDTO.setThoiGianTraBan(lsPhieuNhanCT.get(i).getThoiGianTraBan());
                            }
                            phieuNhanPhongChiTietPresenter.CapNhatPhieuNhanBanChiTiet(phieuNhanBanChiTietDTO);
                        }

                        if (lsPhieuNhanCT.get(i).getTrangThai() == 4) {
                            /// cap nhat trang thai ban
                            banDTO.setBanId(lsPhieuNhanCT.get(i).getBanId());
                            banDTO.setTrangThaiId(1002);
                            banPresenter.CapNhatTrangThaiBan(banDTO);
                        }


                    }

                    /// cap nhat px
                    if (pxid != 0) {
                        for (int i = 0; i < lsPhieuXuat.size(); i++) {
                            phieuXuatDTO.setPhieuXuatId(pxid);
                            phieuXuatDTO.setTrangthai(2);
                            phieuXuatDTO.setSoChungTu(sharedPreferences.getString("SCT", ""));
                            phieuXuatDTO.setTongThanhTien(lsPhieuXuat.get(i).getTongThanhTien() + sharedPreferences.getLong("TT_DV", 0L));
                            phieuXuatPresenter.CapNhatPX(phieuXuatDTO);
                        }

                    }


                    /// kiểm tra coi có phiếu xuất chưa_ nếu chưa tạo phiếu xuất và phiếu xuất chi tiết
                    if (lsPhieuXuat.size() == 0) {

                        dieuKienLocPhieuXuatDTO.setSoChungTu("pb");
                        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
                        tamPhieuXuatDTO = new PhieuXuatDTO(
                                sharedPreferences.getLong("KHID", 0L)
                                , "PB" + (lsGoiMon.size() + 1)
                                , sharedPreferences.getLong("PNID", 0L)
                                , date
                                , sharedPreferences.getInt("NGUOIDUNG", 0)
                                , sharedPreferences.getLong("TT_DV", 0L)
                                , 0
                                , 0
                                , 2
                                , ""
                        );
                        for (int r = 0; r < lsGoiMon.size(); r++) {
                            for (int a = 0; a < lsPhieuNhanCT.size(); a++) {
                                if ((lsPhieuNhanCT.get(a).getBanId() == lsGoiMon.get(r).getBanId() &&
                                        lsGoiMon.get(r).getTrangThai().equals("chưa thanh toán")
                                        && lsPhieuNhanCT.get(a).getTrangThai() == 4)
                                        || (lsGoiMon.get(r).getTrangThai().equals("chờ thanh toán")
                                        && lsPhieuNhanCT.get(a).getPhieuNhanId() == lsGoiMon.get(r).getPhieuNhanId()
                                        && lsGoiMon.get(r).getBanId() == lsPhieuNhanCT.get(a).getBanId()

                                )) {
                                    for (int u = 0; u < lsHangHoa.size(); u++) {
                                        if (lsHangHoa.get(u).getHangHoaId() == lsGoiMon.get(r).getHangHoaId()) {
                                            PhieuXuatChiTietDTO phieuXuatChiTietDTO = new PhieuXuatChiTietDTO(
                                                    lsGoiMon.get(r).getHangHoaId()
                                                    , Double.valueOf(lsGoiMon.get(r).getSoLuong())
                                                    , Double.valueOf(lsHangHoa.get(u).getDonGia())
                                                    , Double.valueOf((lsGoiMon.get(r).getSoLuong()) * (lsHangHoa.get(u).getDonGia()))
                                                    , ""
                                                    , "", 1L
                                                    , lsPhieuNhanCT.get(a).getPhieuDatBanChiTietId()
                                            );
                                            tamlsPhieuXuatChiTiet.add(phieuXuatChiTietDTO);

                                            goiMonDTO.setGoiMonId(lsGoiMon.get(r).getGoiMonId());
                                            goiMonDTO.setTrangThai("đã thanh toán");
                                            goiMonDTO.setPhieuNhanId(pnid);
                                            goiMonDTO.setGhiChu("");
                                            goiMonPresenter.CapNhatGM(goiMonDTO);
                                        }
                                    }


                                }

                            }

                        }
                        xuatPhongDTO = new XuatPhongDTO(tamPhieuXuatDTO, tamlsPhieuXuatChiTiet);
                        phieuXuatPresenter.ThemPhieuXuat(xuatPhongDTO);
                    }

                    editor.clear();
                    editor.apply();
                    editor1.clear();
                    editor1.apply();
                    Intent intent = new Intent(ThanhToanTatCaBanActivity.this, Nav_Ban_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });
        setContentView(thanhToanBinding.getRoot());

    }

    @Override
    protected void onResume() {
        super.onResume();
        lsPhieuNhanCT = new ArrayList<>();
        lsGoiMon = new ArrayList<>();
    }


    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
        lsPhieuXuat = list;



    }

    //lấy danh sách gọi món kèm theo điều kiện lọc
    @Override
    public void onLayDanhSachGoiMonSuccess(List<GoiMonDTO> list) {
        lsGoiMon = list;

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

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("TT_DV", tienDV);
        editor.commit();



    }

    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
        lsPhieuXuatCT = list;

    }

    ////lấy danh sách phòng
    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
        lsBan = lsDanhSachBan;

    }

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietSuccess(List<PhieuNhanBanChiTietDTO> list) {
        lsPhieuNhanCT = list;

    }


    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {
        lsLoaiBan = list;

    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        lsHangHoa = list;

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


}