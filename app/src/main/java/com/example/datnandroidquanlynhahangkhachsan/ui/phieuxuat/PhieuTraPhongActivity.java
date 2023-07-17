package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThanhToan.ThanhToanActivity;
import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuTraPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.ListDichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.XuatPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;
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

public class PhieuTraPhongActivity extends AppCompatActivity implements PhieuNhanPhongChiTietContract.View, PhongContract.View, DsPhieuNhanPhongContract.View, PhieuXuatConTract.View, DichVuContract.View, HangHoaContract.View, KhachHangContract.View {
    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanPhongChiTiet;
    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<HangHoaDTO> lsHangHoa;
    private List<DichVuDTO> lsDichVu;
    private List<PhieuXuatDTO> lsPhieuXuat;

    private ListDichVuDTO listDichVuDTO;

    private List<KhachHangDTO> lsKhachHang;

    private  PhieuXuatDTO  phieuXuatDTO;


    private List<PhieuXuatChiTietDTO> lsPhieuXuatChiTiet;

    private List<PhieuXuatChiTietDTO> tamlsPhieuXuatChiTiet;

    private XuatPhongDTO xuatPhongDTO;

    private PhieuXuatChiTietDTO phieuXuatChiTietDTO;
    private PhongDTO phongDTO;


    private PhieuXuatDTO tamPhieuXuatDTO;
    private Context context;
    private String giatien;
    private PhieuTraPhongAdapter phieuTraPhongAdapter;
    private PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO;


    private long Pn;
    private long Pnct;

    private RecyclerView rscv;


    // lấy ngày nhận
    private Date NGAYNHAN;

    // lấy ngày trả
    private Date NGAYTRA;

    /// format nhận
    private String nhan;

    /// format trả
    private String tra=null;

    /// format ngày trả khi đã lưu

    private String ngayTraLuu;

    /// đếm sl ngày thuê
    private long SLNGAY;
    private long PNid;
    private long tienNgay;
    private int tienDV = 0;

    private long TongTien;

    // lấy ngày hiện tại
    Date date = Calendar.getInstance().getTime();

    // Định dạng ngày hiển thị ra
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String today = formatter.format(date);

    /// chuyển sang DatETiMeFormatter để đếm số ngày
    DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate vao;
    LocalDate ra;

    LocalDate raLuu;
    private int phongid;

    //// sd cho PHONGID
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    /// sd cho PN và Khách hàng
    private SharedPreferences sharedPreferences1;
    private SharedPreferences.Editor editor1;
    private RecyclerView recyclerView;
    ////đếm vị trí để kiểm tra có phiếu xuất chưa
    int temp = 0;

    long KHid;
    int Ndid;
private PhieuNhanDTO phieuNhanDTO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThemphieutraphongBinding phieuTraPhongBinding = ActivityThemphieutraphongBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        /////gán giá trị vào textview
       DecimalFormat decimalFormat=new DecimalFormat("#,##0"+" đồng");
       phieuTraPhongBinding.tvGiaPtp.setText(String.valueOf(decimalFormat.format(sharedPreferences.getInt("GIA",0))));
       phieuTraPhongBinding.tvHotenPtp.setText(sharedPreferences.getString("TEN",""));
       phieuTraPhongBinding.tvSdtptp.setText(sharedPreferences.getString("SDT",""));
       phieuTraPhongBinding.tvCccdPtp.setText(sharedPreferences.getString("CCCD",""));

        phieuTraPhongBinding.tvPhongData.setText(String.valueOf(sharedPreferences.getInt("SOPHONG", 0)));
        sharedPreferences1 = getSharedPreferences("PNID", MODE_PRIVATE);
        editor1 = sharedPreferences1.edit();

        /// lấy id phòng đã được lưu
        phongid = sharedPreferences.getInt("PHONGID", 0);

        phieuNhanPhongChiTietDTO = new PhieuNhanPhongChiTietDTO();
phieuXuatDTO=new PhieuXuatDTO();


        lsPhieuNhanPhongChiTiet = new ArrayList<>();

        phongDTO = new PhongDTO();

        lsPhieuNhan = new ArrayList<>();

        lsDichVu = new ArrayList<>();

        lsHangHoa = new ArrayList<>();

        lsPhieuXuat = new ArrayList<>();

        lsPhieuXuatChiTiet = new ArrayList<>();

        tamlsPhieuXuatChiTiet = new ArrayList<>();

        lsKhachHang = new ArrayList<>();

        phieuNhanDTO=new PhieuNhanDTO();

        /// lấy danh sách phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
        dieuKienLocPhieuNhanPhongChiTietDTO.setPhieuNhanId(sharedPreferences.getLong("PNID",0L));
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);


        ///Khai báo để lấy phiếu xuất
        PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
        dieuKienLocPhieuXuatDTO.setSoChungTu("px");
        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
        /// lay phieu nhan
        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
        dieuKienLocPhieuNhanDTO.setTrangThai("đang nhận");
        dieuKienLocPhieuNhanDTO.setLoaiPhieu(3);
        phieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);

        ///lay hanghoa
        HangHoaPresenter hangHoaPresenter = new HangHoaPresenter(this);
        hangHoaPresenter.LayDanhSachHangHoa2("");

        //// lay DV


        DichVuDTO dichVuDTO = new DichVuDTO();
        DichVuPresenter dichVuPresenter = new DichVuPresenter(this);
        if(sharedPreferences.getInt("KTTHANHTOAN",0)==4)
        {
            dichVuDTO.setPhongID(phongid);
            dichVuDTO.setGhiChu("");
            dichVuDTO.setTrangThai("chưa thanh toán");
            dichVuPresenter.LayDanhSachDichVu(dichVuDTO);
        }       //// lay DV
        if(sharedPreferences.getInt("KTTHANHTOAN",0)==1)
        {

            dichVuDTO.setPhongID(phongid);
            dichVuDTO.setGhiChu("");
            dichVuDTO.setTrangThai("chờ thanh toán");
            dichVuPresenter.LayDanhSachDichVu(dichVuDTO);
        }







        ///khach hang

        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);


        recyclerView = phieuTraPhongBinding.rscvSudung;
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LinearLayoutManager);
        phieuTraPhongBinding.toolbarPhieutraphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                ///xóa dữ liệu khi trở về

//                editor = sharedPreferences.edit();
//                editor1 = sharedPreferences1.edit();
//                editor.clear();
//                editor.commit();
//                editor1.clear();
//                editor1.commit();
            }
        });



        /// cập nhật trạng thái phòng
        PhongPresenter phongPresenter = new PhongPresenter(this);
        final Dialog dialog = new Dialog(this);
        phieuTraPhongBinding.btnTraPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setContentView(R.layout.fragment_dialog_dang_xuat);
                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }
                TextView btnYes = dialog.findViewById(R.id.btn_yes);
                TextView btnNo = dialog.findViewById(R.id.btn_no);
                TextView text = dialog.findViewById(R.id.tv_dangxuat);
                text.setText("Bạn muốn thanh toán ngay ?");
                btnNo.setText("Trả sau");
                btnYes.setText("Thanh toán");
                window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {








                        ///xóa id đã lưu

                        dialog.dismiss();
                        Intent intent = new Intent(PhieuTraPhongActivity.this, ThanhToanActivity.class);

                        startActivity(intent);

                    }
                });



                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (sharedPreferences.getInt("KTTHANHTOAN",0)==4) {
                            phongDTO.setPhongId(phongid);
                            phongDTO.setTrangThaiId(1002);
                            phongPresenter.CapNhatTrangThaiPhong(phongDTO);
                        }
                        ////lay thong tin tu Phieu nhan CT

                        ///cap nhat DV
                        for (int a = 0; a < lsDichVu.size(); a++) {
                            dichVuDTO.setPhieuNhanID(sharedPreferences.getLong("PNID",0L));
                            dichVuDTO.setDichVuID(lsDichVu.get(a).getDichVuID());
                            dichVuDTO.setTrangThai("chờ thanh toán");
                            dichVuPresenter.CapNhatDV(dichVuDTO);
                        }

                        /// cap nhat PNCT
                        for (int i = 0; i < lsPhieuNhanPhongChiTiet.size(); i++) {
                            if (lsPhieuNhanPhongChiTiet.get(i).getPhongId() == phongid) {
                                Pnct=lsPhieuNhanPhongChiTiet.get(i).getPhieuNhanPhongChiTietId();
                                Pn = lsPhieuNhanPhongChiTiet.get(i).getPhieuNhanId();
                                phieuNhanPhongChiTietDTO.setPhieuNhanPhongChiTietId(lsPhieuNhanPhongChiTiet.get(i).getPhieuNhanPhongChiTietId());
                                // 4 :Đang thuê
                                // 1:Trả phòng chưa thanh toán
                                // 2: Đã thanh toán
                                phieuNhanPhongChiTietDTO.setTrangThai(1);
                                /// tự lấy ngày hiện tại
                                phieuNhanPhongChiTietDTO.setThoiGianTraPhong(date);
                                phieuNhanPhongChiTietPresenter.CapNhatPhieuNhanPhongChiTiet(phieuNhanPhongChiTietDTO);
                            }
                        }
                        onBackPressed();
                        dialog.dismiss();

                    }
                });





                dialog.show();

            }

        });


        setContentView(phieuTraPhongBinding.getRoot());
    }


    @Override
    protected void onResume() {
        super.onResume();

        try {
            Thread.sleep(200);
            lsPhieuNhanPhongChiTiet = new ArrayList<>();
            /// lấy danh sách phiếu nhận chi tiết
            PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
            DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
            phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);
            //// lay DV
            lsDichVu = new ArrayList<>();
            lsPhieuNhan=new ArrayList<>();
            /// lay phieu nhan
            DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
            DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
            dieuKienLocPhieuNhanDTO.setTrangThai("đang nhận");
            dieuKienLocPhieuNhanDTO.setLoaiPhieu(3);
            phieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);
            ///khach hang
            lsKhachHang=new ArrayList<>();
            KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
            DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
            khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }





    }


    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {
        lsPhieuNhanPhongChiTiet = list;
        sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        /// lấy giá trị phongid gán cho PNCT
       for (int i = 0; i < lsPhieuNhanPhongChiTiet.size(); i++) {

            if (lsPhieuNhanPhongChiTiet.get(i).getPhongId() == sharedPreferences.getInt("PHONGID", 0)) {
                ///lay va luu id PN
                editor.putLong("PN", lsPhieuNhanPhongChiTiet.get(i).getPhieuNhanId());
                editor.commit();
                NGAYNHAN = lsPhieuNhanPhongChiTiet.get(i).getThoiGianNhanPhong();

                if (lsPhieuNhanPhongChiTiet.get(i).getThoiGianTraPhong()==null) {
                    NGAYTRA =date;
                }
                else {
                    NGAYTRA = lsPhieuNhanPhongChiTiet.get(i).getThoiGianTraPhong();
                }
                nhan = formatter.format(NGAYNHAN);
                tra=formatter.format(NGAYTRA);

                TextView tvt = findViewById(R.id.tv_ngaytra);
                /// chuyển ngày sang LocalDate
                vao = LocalDate.parse(nhan, fm);
                ra = LocalDate.parse(tra, fm);
                //ngày trả
                tvt.setText(tra);
                /// đếm số lượng ngày

                if(ra.toEpochDay() - vao.toEpochDay()==0)
                {
                    SLNGAY=1;
                }
                else
                {
                    SLNGAY = ra.toEpochDay() - vao.toEpochDay();
                }
                ///ngày nhận
                TextView tvn = findViewById(R.id.tv_ngaynhan);
                tvn.setText(nhan);
            }
        }
        ///số lượng ngày thuê
        TextView soluong = findViewById(R.id.tv_songaythue);
        soluong.setText(String.valueOf(SLNGAY));
        ///giá tiền thuê của tổng ngày
        tienNgay = Long.valueOf(SLNGAY) * Long.valueOf(sharedPreferences.getInt("GIA", 0));
        editor.putLong("TONGTIEN", tienNgay);
        editor.commit();

    }

    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
        sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        lsPhieuNhan = list;
        for (int i=0;i<lsPhieuNhan.size();i++)
        {
            if(lsPhieuNhan.get(i).getPhieuNhanId()==sharedPreferences.getLong("PN",0L))
            {
                editor.putLong("KH",lsPhieuNhan.get(i).getKhachHangId());
                editor.commit();
            }
        }

    }
    @Override
    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {
        lsKhachHang = list;

    }


    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        lsHangHoa = list;
        phieuTraPhongAdapter = new PhieuTraPhongAdapter(this);
        phieuTraPhongAdapter.setData(lsDichVu, context, lsHangHoa);
        recyclerView.setAdapter(phieuTraPhongAdapter);
    }

    @Override
    public void onLayDanhSachDichVuSuccess(List<DichVuDTO> list) {
        lsDichVu = list;
        phieuTraPhongAdapter = new PhieuTraPhongAdapter(this);
        phieuTraPhongAdapter.setData(lsDichVu, context, lsHangHoa);
        recyclerView.setAdapter(phieuTraPhongAdapter);
        sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        try {
            Thread.sleep(200);
            for (int y=0;y<lsHangHoa.size();y++)
            {
                for (int i = 0; i < lsDichVu.size(); i++) {

                    if(lsDichVu.get(i).getHangHoaId()==lsHangHoa.get(y).getHangHoaId())
                    {
                        tienDV = tienDV + lsHangHoa.get(y).getDonGia() * lsDichVu.get(i).getSoLuong();
                    }
                }
            }

            /// tinh tong tien
            Long TT = sharedPreferences.getLong("TONGTIEN", 0L);
            ///format giá tiền
            DecimalFormat decimalFormat = new DecimalFormat("#,##0" + " đồng");
            ///tổng tiền
            giatien = decimalFormat.format(TongTien);
            TextView tv_tong = findViewById(R.id.tv_tongTien);
            tv_tong.setText(String.valueOf(decimalFormat.format(sharedPreferences.getLong("TONGTIEN", 0L)+Long.valueOf(tienDV))));

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        editor.putLong("TT_NGAY", sharedPreferences.getLong("TONGTIEN", 0L));
        editor.putLong("TT_DV", tienDV);
        editor.commit();

    }
    @Override
    public void onLayDvPnSuccess(List<DichVuDTO> list) {


    }
    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
        lsPhieuXuat = list;
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
    public void onThemKhachHangSuccess() {
    }

    @Override
    public void onThemKhachHangError(String error) {
    }


    @Override
    public void onLayDanhSachKhachHangError(String error) {
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
    public void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong) {
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
    public void onLayDanhSachPhieuNhanError(String error) {
    }

    @Override
    public void onThemPhieuNhanPhongSuccess() {

    }

    @Override
    public void onThemPhieuNhanPhongError(String error) {

    }

    @Override
    public void onThemPhieuNhanBanSuccess() {

    }

    @Override
    public void onThemPhieuNhanBanError(String error) {

    }


    @Override
    public void onThemPhieuXuatSuccess() {


    }

    @Override
    public void onThemPhieuXuatError(String error) {


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
    public void onThemPhieuXuatChiTietSuccess() {


    }

    @Override
    public void onThemPhieuXuatChiTietError(String error) {

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

    @Override
    public void oncapNhatDichVuSuccess() {
    }

    @Override
    public void oncapNhatDichVuError(String error) {
    }


    @Override
    public void onLayDvPnError(String error) {
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
    public void onLayDanhSachPhieuNhanBanChiTietSuccess(List<PhieuNhanBanChiTietDTO> list){}

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietError(String error){}
    @Override
    public void onCapNhatPhieuNhanSuccess(){}

    @Override
    public void onCapNhatPhieuNhanError(String error){}

    @Override
    public  void onCapNhatPhieuNhanBanChiTietSuccess(){}

    @Override
    public  void onCapNhatPhieuNhanBanChiTietError(String error){}
}