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
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.XuatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu.PhieuThuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu.PhieuThuPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatConTract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatPresenter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThanhToanTatCaActivity extends AppCompatActivity implements PhieuThuContract.View, PhieuXuatConTract.View, PhongContract.View, PhieuNhanPhongChiTietContract.View, LoaiPhongContract.View, DichVuContract.View, DsPhieuNhanPhongContract.View, HangHoaContract.View {

    private List<PhieuXuatChiTietDTO> lsPhieuXuatCT;
    private List<PhongDTO> lsPhong;
    private List<LoaiPhongDTO> loaiPhong;

    private List<HangHoaDTO> lsHangHoa;

    private PhieuNhanDTO phieuNhanDTO;

    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanCT;
    private Context context;

    private List<DichVuDTO> lsDichVu;

    private List<PhieuXuatDTO> lsPhieuXuat;
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

    long tonghoadonNGAY;
    long tienDV = 0L;
    long tienDVTong;
    long tongAll;
    long tongAllPX;
    private Float tongTien;


    // lấy ngày hiện tại
    Date date = Calendar.getInstance().getTime();

    // Định dạng ngày hiển thị ra
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String today = formatter.format(date);

    private PhieuXuatDTO tamPhieuXuatDTO;

    private List<PhieuXuatChiTietDTO> tamlsPhieuXuatChiTiet;

    private XuatPhongDTO xuatPhongDTO;
    private int temp = 0;

    private long PN;

    //// cho phieu thu

    private Long tienThoi;
    private int tienDua;
    private List<PhieuThuDTO> lsPhieuThu;
    private PhieuThuDTO phieuThuDTO;


    float dua;
    float thoi;
    String Pttt = "Tiền mặt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThanhToanBinding thanhToanBinding = ActivityThanhToanBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        lsPhieuXuatCT = new ArrayList<>();
        lsPhong = new ArrayList<>();
        loaiPhong = new ArrayList<>();
        lsDichVu = new ArrayList<>();
        lsPhieuNhanCT = new ArrayList<>();
        lsPhieuXuat = new ArrayList<>();
        tamlsPhieuXuatChiTiet = new ArrayList<>();
        lsHangHoa = new ArrayList<>();


        phieuNhanDTO = new PhieuNhanDTO();
        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);

        /// lấy loại phòng
        LoaiPhongPresenter loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();
        //// lấy phòng
        PhongPresenter phongPresenter = new PhongPresenter(this);
        phongPresenter.LayDanhSachPhong();


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
        // thanhToanBinding.tvTong.setText(String.valueOf(decimalFormat.format(sharedPreferences.getFloat("TONGTIEN", 0f))));

        ///lay hang hoa

        HangHoaPresenter hangHoaPresenter = new HangHoaPresenter(this);
        hangHoaPresenter.LayDanhSachHangHoa2("");

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
        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
        dieuKienLocPhieuNhanPhongChiTietDTO.setPhieuNhanId(pnid);
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);

        ///lay Dv
        DichVuPresenter dichVuPresenter = new DichVuPresenter(this);
        DichVuDTO dichVuDTO = new DichVuDTO();
        //
        dichVuDTO.setGhiChu("");
        dichVuDTO.setTrangThai("thanh");
        dichVuPresenter.LayDanhSachDichVu(dichVuDTO);


        PhieuXuatDTO phieuXuatDTO = new PhieuXuatDTO();
        PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO = new PhieuNhanPhongChiTietDTO();
        PhongDTO phongDTO = new PhongDTO();


///// phieu thu

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


        thanhToanBinding.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thanhToanBinding.etDua.getText().length() > 0) {
                    dua = Float.valueOf(thanhToanBinding.etDua.getText().toString());
                } else {
                    dua = 0f;
                }

                if (dua < tienTT) {
                    Toast.makeText(ThanhToanTatCaActivity.this, "Vui lòng thanh toán đủ tiền!", Toast.LENGTH_SHORT).show();
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


                    //// cap nhat PNct
                    for (int i = 0; i < lsPhieuNhanCT.size(); i++) {
                        for (int a = 0; a < lsDichVu.size(); a++) {

                            if ((lsDichVu.get(a).getTrangThai().equals("chưa thanh toán")
                                    && lsDichVu.get(a).getPhongID() == lsPhieuNhanCT.get(i).getPhongId()
                                    && lsPhieuXuat.size() != 0
                                    && lsPhieuNhanCT.get(i).getTrangThai() == 4)
                                    || (lsDichVu.get(a).getTrangThai().equals("chờ thanh toán")
                                    && lsPhieuNhanCT.get(i).getPhieuNhanId() == lsDichVu.get(a).getPhieuNhanID()
                                    && lsPhieuXuat.size() != 0
                                    && lsDichVu.get(a).getPhongID() == lsPhieuNhanCT.get(i).getPhongId())) {
                                for (int u = 0; u < lsHangHoa.size(); u++) {
                                    if (lsHangHoa.get(u).getHangHoaId() == lsDichVu.get(a).getHangHoaId()) {
                                        PhieuXuatChiTietDTO phieuXuatChiTietDTO = new PhieuXuatChiTietDTO(sharedPreferences.getLong("PXID", 0L), lsDichVu.get(a).getHangHoaId(), Double.valueOf(lsDichVu.get(a).getSoLuong()), Double.valueOf(lsHangHoa.get(u).getDonGia()), Double.valueOf((lsDichVu.get(a).getSoLuong()) * (lsHangHoa.get(u).getDonGia())), "", "", lsPhieuNhanCT.get(i).getPhieuNhanPhongChiTietId(), 1L);
                                        /// tạo phiếu xuất chi tiết mới
                                        phieuXuatPresenter.ThemPhieuXuatChiTiet(phieuXuatChiTietDTO);
                                        dichVuDTO.setDichVuID(lsDichVu.get(a).getDichVuID());
                                        dichVuDTO.setTrangThai("đã thanh toán");
                                        dichVuDTO.setPhieuNhanID(pnid);
                                        dichVuPresenter.CapNhatDV(dichVuDTO);
                                    }
                                }


                            }


                        }

                        if (lsPhieuNhanCT.get(i).getTrangThai() == 4) {
                            phieuNhanPhongChiTietDTO.setPhieuNhanPhongChiTietId(lsPhieuNhanCT.get(i).getPhieuNhanPhongChiTietId());
                            phieuNhanPhongChiTietDTO.setTrangThai(2);
                            if (lsPhieuNhanCT.get(i).getThoiGianTraPhong() == null) {
                                phieuNhanPhongChiTietDTO.setThoiGianTraPhong(date);
                            } else {
                                phieuNhanPhongChiTietDTO.setThoiGianTraPhong(lsPhieuNhanCT.get(i).getThoiGianTraPhong());
                            }
                            phieuNhanPhongChiTietPresenter.CapNhatPhieuNhanPhongChiTiet(phieuNhanPhongChiTietDTO);
                            /// cap nhat trang thai phong
                            phongDTO.setPhongId(lsPhieuNhanCT.get(i).getPhongId());
                            phongDTO.setTrangThaiId(1002);
                            phongPresenter.CapNhatTrangThaiPhong(phongDTO);
                        }

                        if (lsPhieuNhanCT.get(i).getTrangThai() == 1) {
                            phieuNhanPhongChiTietDTO.setPhieuNhanPhongChiTietId(lsPhieuNhanCT.get(i).getPhieuNhanPhongChiTietId());
                            phieuNhanPhongChiTietDTO.setTrangThai(2);
                            if (lsPhieuNhanCT.get(i).getThoiGianTraPhong() == null) {
                                phieuNhanPhongChiTietDTO.setThoiGianTraPhong(date);
                            } else {
                                phieuNhanPhongChiTietDTO.setThoiGianTraPhong(lsPhieuNhanCT.get(i).getThoiGianTraPhong());
                            }
                            phieuNhanPhongChiTietPresenter.CapNhatPhieuNhanPhongChiTiet(phieuNhanPhongChiTietDTO);
                        }


                    }

                    /// cap nhat px
                    if (pxid != 0) {
                        for (int i = 0; i < lsPhieuXuat.size(); i++) {
                            phieuXuatDTO.setPhieuXuatId(pxid);
                            phieuXuatDTO.setTrangthai(2);
                            phieuXuatDTO.setSoChungTu(sharedPreferences.getString("SCT", ""));
                            phieuXuatDTO.setTongThanhTien(lsPhieuXuat.get(i).getTongThanhTien() + sharedPreferences.getLong("TT_NGAY", 0L) + sharedPreferences.getLong("TT_DV", 0L));
                            phieuXuatPresenter.CapNhatPX(phieuXuatDTO);
                        }

                    }


                    /// kiểm tra coi có phiếu xuất chưa_ nếu chưa tạo phiếu xuất và phiếu xuất chi tiết
                    if (lsPhieuXuat.size() == 0) {
                        dieuKienLocPhieuXuatDTO.setSoChungTu("px");
                        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
                        tamPhieuXuatDTO = new PhieuXuatDTO(
                                sharedPreferences.getLong("KHID", 0L)
                                , "PX" + (sharedPreferences.getLong("PNID", 0L))
                                , sharedPreferences.getLong("PNID", 0L)
                                , date
                                , sharedPreferences.getInt("NGUOIDUNG", 0)
                                , sharedPreferences.getLong("TT_NGAY", 0L) + sharedPreferences.getLong("TT_DV", 0L)
                                , 0
                                , 0
                                , 2
                                , ""
                        );
                        for (int r = 0; r < lsDichVu.size(); r++) {
                            for (int a = 0; a < lsPhieuNhanCT.size(); a++) {
                                if ((lsPhieuNhanCT.get(a).getPhongId() == lsDichVu.get(r).getPhongID()
                                        && lsDichVu.get(r).getTrangThai().equals("chưa thanh toán")
                                        && lsPhieuNhanCT.get(a).getTrangThai() == 4)
                                        || (lsPhieuNhanCT.get(a).getPhongId() == lsDichVu.get(r).getPhongID()
                                        && lsPhieuNhanCT.get(a).getPhieuNhanId() == lsDichVu.get(r).getPhieuNhanID()
                                        && lsDichVu.get(r).getTrangThai().equals("chờ thanh toán"))

                                ) {
                                    for (int u = 0; u < lsHangHoa.size(); u++) {
                                        if (lsHangHoa.get(u).getHangHoaId() == lsDichVu.get(r).getHangHoaId()) {
                                            PhieuXuatChiTietDTO phieuXuatChiTietDTO = new PhieuXuatChiTietDTO(lsDichVu.get(r).getHangHoaId(), Double.valueOf(lsDichVu.get(r).getSoLuong()), Double.valueOf(lsHangHoa.get(u).getDonGia()), Double.valueOf((lsDichVu.get(r).getSoLuong()) * (lsHangHoa.get(u).getDonGia())), "", "", lsPhieuNhanCT.get(a).getPhieuNhanPhongChiTietId(), 1L);
                                            tamlsPhieuXuatChiTiet.add(phieuXuatChiTietDTO);

                                            dichVuDTO.setDichVuID(lsDichVu.get(r).getDichVuID());
                                            dichVuDTO.setTrangThai("đã thanh toán");
                                            dichVuDTO.setPhieuNhanID(pnid);
                                            dichVuPresenter.CapNhatDV(dichVuDTO);
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
                    Intent intent=new Intent(ThanhToanTatCaActivity.this, Toolbar_Drawer_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                    finish();


                }
            }
        });
        setContentView(thanhToanBinding.getRoot());

    }



    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
        lsPhieuXuatCT = list;

    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {
        lsPhieuNhanCT = list;


    }

    @Override
    public void onLayDvPnSuccess(List<DichVuDTO> list) {


    }


    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong) {
        lsPhong = lsDanhSachPhong;


    }

    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> lsLoaiPhong) {
        loaiPhong = lsLoaiPhong;

    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        lsHangHoa = list;

    }

    @Override
    public void onLayDanhSachDichVuSuccess(List<DichVuDTO> list) {
        lsDichVu = list;


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
    public void onDoiPhongSuccess() {

    }

    @Override
    public void onDoiPhongError(String error) {

    }

    @Override
    public void onThemPhieuXuatSuccess() {
    }

    @Override
    public void onThemPhieuXuatError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
        lsPhieuXuat = list;
//        Toast.makeText(ThanhToanTatCaActivity.this, ""+lsPhieuXuat.size(), Toast.LENGTH_SHORT).show();

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

    @Override
    public void onCapNhatPXSuccess() {


    }

    @Override
    public void onCapNhatPXError(String error) {

    }

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietSuccess(List<PhieuNhanBanChiTietDTO> list) {
    }

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietError(String error) {
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
    public void onCapNhatPhieuNhanBanChiTietSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanBanChiTietError(String error) {
    }
}