package com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.Toolbar_Drawer_Activity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.DangNhapActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;

import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
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

public class PhieuTraPhongActivity extends AppCompatActivity implements PhieuNhanPhongChiTietContract.View, PhongContract.View,DsPhieuNhanPhongContract.View, KhachHangContract.View, PhieuXuatConTract.View {
    private List<PhieuNhanPhongChiTietDTO> lsPhieuNhanPhongChiTiet;
    private List<PhieuNhanDTO> lsPhieuNhan;
    private PhieuXuatDTO phieuXuatDTO;
    private List<HangHoaDTO> lsHangHoa;
    private List<PhieuXuatDTO> lsPhieuXuat;
    private PhongDTO phongDTO;
    private PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO;
    private PhieuXuatPresenter phieuXuatPresenter;
    private DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO;
    private List<KhachHangDTO> lsKhachHang;
    private RecyclerView rscv;
    private long PNCTid;

    // lấy ngày nhận
    private Date NGAYNHAN;

    // lấy ngày trả
    private Date NGAYTRA;

    /// format nhận
    private String nhan;

    /// format trả
    private String tra;

    /// đếm sl ngày thuê
    private long SLNGAY;

    private long PNid;

    private long tongTien;

    // lấy ngày hiện tại
    Date date = Calendar.getInstance().getTime();

    // Định dạng ngày hiển thị ra
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    String today = formatter.format(date);

    /// chuyển sang DatETiMeFormatter để đếm số ngày
    DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDate vao;

    LocalDate ra;

    private int phongid;

    //// sd cho PHONGID
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    /// sd cho PN và Khách hàng
    private SharedPreferences sharedPreferences1;
    private SharedPreferences.Editor editor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThemphieutraphongBinding phieuTraPhongBinding = ActivityThemphieutraphongBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        sharedPreferences1 = getSharedPreferences("PNID", MODE_PRIVATE);
        editor1=sharedPreferences1.edit();


        /// lấy id phòng đã được lưu
        phongid = sharedPreferences.getInt("PHONGID", 0);

        phieuNhanPhongChiTietDTO = new PhieuNhanPhongChiTietDTO();
        lsPhieuNhanPhongChiTiet=new ArrayList<>();

        phongDTO = new PhongDTO();

        lsPhieuNhan = new ArrayList<>();

        lsKhachHang = new ArrayList<>();

        lsHangHoa = new ArrayList<>();
        //// lấy ra ds PN
        DsPhieuNhanPhongPresenter dsPhieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
        dsPhieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);


        /// lấy danh sách phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);
        ///lấy khách hàng
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);

        ///Khai báo để lấy phiếu xuất
        lsPhieuXuat=new ArrayList<>();
        phieuXuatPresenter=new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO=new DieuKienLocPhieuXuatDTO();
        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);

        Toast.makeText(this, ""+lsPhieuXuat.size(), Toast.LENGTH_SHORT).show();

        phieuTraPhongBinding.toolbarPhieutraphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                ///xóa dữ liệu khi trở về

                editor = sharedPreferences.edit();
                editor1 = sharedPreferences1.edit();
                editor.clear();
                editor.commit();
                editor1.clear();
                editor1.commit();
            }
        });

//        ///ngày trả là ngày hiện tại
        phieuTraPhongBinding.tvNgaytra.setText(today.toString());

        /////gán giá trị vào textview
        phieuTraPhongBinding.tvPhongData.setText(String.valueOf(sharedPreferences.getInt("SOPHONG", 0)));



        /// cập nhật trạng thái phòng
        PhongPresenter phongPresenter = new PhongPresenter(this);
        final Dialog dialog = new Dialog(this);
        phieuTraPhongBinding.btnTraPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.fragment_dialog_dang_xuat);
                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }
                TextView btnYes = dialog.findViewById(R.id.btn_yes);
                TextView btnNo = dialog.findViewById(R.id.btn_no);
                btnNo.setText("Để sau");
                btnYes.setText("Thanh toán");
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        phongDTO.setPhongId(phongid);
                        phongDTO.setTrangThaiId(1);
                        phongPresenter.CapNhatTrangThaiPhong(phongDTO);

                        ////pnct
                        phieuNhanPhongChiTietDTO.setPhieuNhanPhongChiTietId(PNCTid);
                        // 4 :Đang thuê
                        // 1:Trả phòng chưa thanh toán
                        // 2: Đã thanh toán
                        phieuNhanPhongChiTietDTO.setTrangThai(2);
                        /// tự lấy ngày hiện tại
                        phieuNhanPhongChiTietDTO.setThoiGianTraPhong(date);


                        phieuNhanPhongChiTietPresenter.CapNhatPhieuNhanPhongChiTiet(phieuNhanPhongChiTietDTO);
                        ///Thêm phiếu xuất


                        phieuXuatDTO=new PhieuXuatDTO(sharedPreferences1.getLong("KHID", 0L),"PX"+(lsPhieuXuat.size()+1),
                                sharedPreferences1.getLong("PNID", 0L),date,sharedPreferences1.getInt("NDID", 0),1111111,3,10,1,"Ghi chu");

                        phieuXuatPresenter.ThemPhieuXuat(phieuXuatDTO);

                        ///xóa id đã lưu

                        editor = sharedPreferences.edit();
                        editor1 = sharedPreferences1.edit();
                        editor.clear();
                        editor.commit();
                        editor1.clear();
                        editor1.commit();
                        onBackPressed();


                    }
                });
                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        phongDTO.setPhongId(phongid);
                        phongDTO.setTrangThaiId(1);
                        phongPresenter.CapNhatTrangThaiPhong(phongDTO);

                        ////pnct
                        phieuNhanPhongChiTietDTO.setPhieuNhanPhongChiTietId(PNCTid);
                        // 4 :Đang thuê
                        // 1:Trả phòng chưa thanh toán
                        // 2: Đã thanh toán
                        phieuNhanPhongChiTietDTO.setTrangThai(1);
                        /// tự lấy ngày hiện tại
                        phieuNhanPhongChiTietDTO.setThoiGianTraPhong(date);
                        phieuNhanPhongChiTietPresenter.CapNhatPhieuNhanPhongChiTiet(phieuNhanPhongChiTietDTO);
                        ///Thêm phiếu xuất


                        phieuXuatDTO=new PhieuXuatDTO(sharedPreferences1.getLong("KHID", 0L),"PX"+(lsPhieuXuat.size()+1),
                                sharedPreferences1.getLong("PNID", 0L),date,sharedPreferences1.getInt("NDID", 0),1111111,3,10,1,"Ghi chu");

                        phieuXuatPresenter.ThemPhieuXuat(phieuXuatDTO);

                        ///xóa id đã lưu

                        editor = sharedPreferences.edit();
                        editor1 = sharedPreferences1.edit();
                        editor.clear();
                        editor.commit();
                        editor1.clear();
                        editor1.commit();
                        onBackPressed();

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
        phieuNhanPhongChiTietDTO = new PhieuNhanPhongChiTietDTO();
        lsPhieuNhan = new ArrayList<>();
        lsKhachHang = new ArrayList<>();
        //// lấy ra ds PN
        DsPhieuNhanPhongPresenter dsPhieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
        dsPhieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);


        /// lấy list phiếu nhận chi tiết
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);

        /// lấy lại list khách hàng
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);
    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {
        lsPhieuNhanPhongChiTiet = list;

        /// lấy giá trị phongid gán cho PNCT
        for (int i = 0; i < lsPhieuNhanPhongChiTiet.size(); i++) {
            if (lsPhieuNhanPhongChiTiet.get(i).getPhongId() == phongid) {
                /// lấy id pnct
                PNCTid = Long.valueOf(lsPhieuNhanPhongChiTiet.get(i).getPhieuNhanPhongChiTietId());
                ///lấy id pn
                PNid=Long.valueOf(lsPhieuNhanPhongChiTiet.get(i).getPhieuNhanId());
                NGAYNHAN = lsPhieuNhanPhongChiTiet.get(i).getThoiGianNhanPhong();
                NGAYTRA = lsPhieuNhanPhongChiTiet.get(i).getThoiGianTraPhong();


                nhan = formatter.format(NGAYNHAN);
                tra = formatter.format(date);
//                editor1 = sharedPreferences1.edit();
                editor1.putLong("PNID", PNid);
                editor1.commit();


            }
        }
        /// chuyển ngày sang LocalDate
        vao = LocalDate.parse(nhan, fm);
        ra = LocalDate.parse(today, fm);
        /// đếm số lượng ngày
        SLNGAY = ra.toEpochDay() - vao.toEpochDay();
        //ngày trả
        TextView tvt = findViewById(R.id.tv_ngaytra);
//        if(NGAYTRA!=null)
//        {
//            tvt.setText(tra);
//        }

        ///ngày nhận
        TextView tvn = findViewById(R.id.tv_ngaynhan);
        tvn.setText(nhan);
        ///số lượng ngày thuê
        TextView soluong = findViewById(R.id.tv_songaythue);
        soluong.setText(String.valueOf(SLNGAY));

        ///giá tiền thuê của tổng ngày
        sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        tongTien = Long.valueOf(SLNGAY) * Long.valueOf(sharedPreferences.getInt("GIA", 0));
        ///format giá tiền
        DecimalFormat decimalFormat = new DecimalFormat("#,##0" + " đồng");
        String giatien = decimalFormat.format(tongTien);
        TextView tong = findViewById(R.id.tv_tong);
        tong.setText(String.valueOf(giatien));


    }

    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
        lsPhieuNhan = list;

        Long a = sharedPreferences1.getLong("PNID", 0L);
        for (int i = 0; i < lsPhieuNhan.size(); i++) {
            if (lsPhieuNhan.get(i).getPhieuNhanId() == a) {
//                editor1 = sharedPreferences1.edit();
                editor1.putLong("KHID", lsPhieuNhan.get(i).getKhachHangId());
                editor1.putInt("NDID", lsPhieuNhan.get(i).getNguoiDungId());
                editor1.commit();

            }

        }
    }

    @Override
    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {
        lsKhachHang = list;
        Long kh = sharedPreferences1.getLong("KHID", 0L);

        TextView ten = findViewById(R.id.et_hoten_phieutraphong);
        TextView cccd = findViewById(R.id.et_cccd_phieutraphong);
        TextView sdt = findViewById(R.id.tv_sdtptp);
        for (int i = 0; i < lsKhachHang.size(); i++) {
            if (lsKhachHang.get(i).getKhachHangId() == kh) {
                ten.setText(lsKhachHang.get(i).getTenKhachHang());
                cccd.setText(lsKhachHang.get(i).getCccd());
                sdt.setText(lsKhachHang.get(i).getSdt());

            }
        }


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
    public void onThemKhachHangSuccess() {
    }

    @Override
    public void onThemKhachHangError(String error) {
    }


    @Override
    public void onLayDanhSachKhachHangError(String error) {
    }




    @Override
    public void onThemPhieuXuatSuccess(){}

    @Override
    public void onThemPhieuXuatError(String error){}

    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list){
        lsPhieuXuat=list;
    }

    @Override
    public void onLayDanhSachPhieuXuatError(String error){}


    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list){}

    @Override
    public void onLayDanhSachPhieuXuatChiTietError(String error){}


}