package com.example.datnandroidquanlynhahangkhachsan.ui.phieudat;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.CaptureAct;
import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuDatPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieudatphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.lsChonPhong;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonphong.ChonPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ThemPhieuDatphongActivity extends AppCompatActivity implements DsPhieuDatPhongContract.View, PhongContract.View, LoaiPhongContract.View, KhachHangContract.View {
    private ActivityThemphieudatphongBinding activityThemphieudatphongBinding;
    private List<PhieuDatDTO> lsPhieuDat;

    //private List<Integer> lsPhong;
    private List<LoaiPhongDTO> lsloaiPhong;
    private PhieuDatPhongAdapter phieuDatPhongAdapter;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter;
    private String thoiGianNhan = "";
    private String thoiGianTra = "";
    PhieuDatDTO phieuDatDTO;
    private List<PhongDTO> lsphong;
    private PhongPresenter phongPresenter;
    private LoaiPhongPresenter loaiPhongPresenter;

    PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO;
    List<PhieuDatPhongChiTietDTO> lsPhieuDatPhongChiTiet;
    private AppUtils ac;
    Calendar statcal = Calendar.getInstance(Locale.CHINESE);
    DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO;
    String danhSachPhongDangChon = "";
    private String[] duLieuKhachHang;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 1000;
    private KhachHangDTO khachHangDTO;
    private KhachHangPresenter khachHangPresenter;
    private PhongDTO phongDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThemphieudatphongBinding = activityThemphieudatphongBinding.inflate(getLayoutInflater());
        setContentView(activityThemphieudatphongBinding.getRoot());
        activityThemphieudatphongBinding.btnThemphongPhieudatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemPhieuDatphongActivity.this, ChonPhongActivity.class);
                startActivity(intent);
            }
        });


        activityThemphieudatphongBinding.BtnScanQRPhieudatphong.setOnClickListener(view -> {
            ScanOptions options = new ScanOptions();
            options.setCaptureActivity(CaptureAct.class);
            barLaucher.launch(options);
        });
        activityThemphieudatphongBinding.imgbtnThoigiannhanThemphieudatphong.setOnClickListener(view -> {
            openDialogDateThoiGianNhan();
        });
        activityThemphieudatphongBinding.imgbtnThoigiantraThemphieudatphong.setOnClickListener(view -> {
            openDialogDateThoiGianTra();
        });
        //lấy danh sách phòng
        lsphong = new ArrayList<>();
        phongPresenter = new PhongPresenter(this);
        phongPresenter.LayDanhSachPhong();
        //lấy danh sách loại phòng
        lsloaiPhong = new ArrayList<>();
        loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();
        activityThemphieudatphongBinding.tvPhongDataPhieudatphong.setText("");
        lsChonPhong.lsChonPhongDataInt = new ArrayList<>();
        //khai báo presenter khách hàng
        khachHangPresenter = new KhachHangPresenter(this);
        activityThemphieudatphongBinding.toolbarPhieudatphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lsChonPhong.lsChonPhongDataInt.clear();
                onBackPressed();
            }
        });

        activityThemphieudatphongBinding.btnThemphieudatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnclickThemPhieuDatPhong();
            }
        });
        lsPhieuDat = new ArrayList<>();
        lsphong = new ArrayList<>();
        lsPhieuDatPhongChiTiet = new ArrayList<>();

        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
        dieuKienLocPhieuDatDTO = new DieuKienLocPhieuDatDTO();
        dieuKienLocPhieuDatDTO.setLoaiPhieu(1);
        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
        KiemTraDuLieuDauVao();

        //lấy dữ liệu phiếu đặt mỗi giây
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);
                dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
            }
        }, delay);

        //khai báo khách hàng
        khachHangDTO = new KhachHangDTO();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
        danhSachPhongDangChon = "";
        activityThemphieudatphongBinding.tvPhongDataPhieudatphong.setText("abc");
        //lsChonPhong.lsChonPhongDataInt.clear();
        for (int i = 0; i < lsChonPhong.lsChonPhongDataInt.size(); i++) {
            for (int j = 0; j < lsphong.size(); j++) {
                if (lsChonPhong.lsChonPhongDataInt.get(i) == lsphong.get(j).getPhongId()) {
                    danhSachPhongDangChon += lsphong.get(j).getSoPhong();
                    if (i + 1 < lsChonPhong.lsChonPhongDataInt.size()) {
                        danhSachPhongDangChon += ", ";
                    }
                    activityThemphieudatphongBinding.tvPhongDataPhieudatphong.setText(danhSachPhongDangChon);
                }
            }
        }
    }

    private void OnclickThemPhieuDatPhong() {
        if (activityThemphieudatphongBinding.etHotenPhieudatphong.length() < 1
                || activityThemphieudatphongBinding.etCccdPhieudatphong.length() < 12
                || activityThemphieudatphongBinding.etSdtPhieudatphong.length() < 10
                || activityThemphieudatphongBinding.etSonguoiPhieudatphong.length() < 1
                || thoiGianNhan == ""
                || lsChonPhong.lsChonPhongDataInt.size() < 1) {
            Toast.makeText(this, "vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
        } else {
            dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
            Date day = Calendar.getInstance().getTime();
            Date thoiGianNhanPhong = ac.formatStringToDateUtil(thoiGianNhan, "dd/MM/yyyy HH:mm");
            Date thoiGianTraPhong = null;
            if (thoiGianTra != null || thoiGianTra != "") {
                thoiGianTraPhong = ac.formatStringToDateUtil(thoiGianTra, "dd/MM/yyyy HH:mm");
            }
            phieuDatDTO = new PhieuDatDTO("PDP" + (lsPhieuDat.size() + 1), day, 1, 1, thoiGianNhanPhong, thoiGianTraPhong, "ghi chu", 1L, "đang đặt");
            dsPhieuDatPhongPresenter.ThemPhieuDatPhong(phieuDatDTO);

//            Date abc = Calendar.getInstance().getTime();
//            Date xyz = ac.formatStringToDateSQL(thoiGianNhan, "dd/MM/yyyy HH:mm");
//            khachHangDTO = new KhachHangDTO("123","123","123", xyz,"nam","123");

//            String CCCD = duLieuKhachHang[0];
            String sdt = String.valueOf(activityThemphieudatphongBinding.etSdtPhieudatphong.getText());
//            String HoTen = duLieuKhachHang[2];
//            Date NgaySinh = ac.formatStringToDateSQL(duLieuKhachHang[3], "ddMMyyyy");
//            String GioiTinh = duLieuKhachHang[4];
//            String NoiThuongTru = duLieuKhachHang[5];
//            khachHangDTO = new KhachHangDTO(CCCD, sdt, HoTen, NgaySinh, GioiTinh, NoiThuongTru);

            String CCCD = String.valueOf(activityThemphieudatphongBinding.etCccdPhieudatphong.getText());
            String Hoten = String.valueOf(activityThemphieudatphongBinding.etHotenPhieudatphong.getText());

            khachHangDTO.setCccd(CCCD);
            khachHangDTO.setTenKhachHang(Hoten);
            khachHangDTO.setSdt(sdt);
//            if (!duLieuKhachHang[0].isEmpty()) {
//                NgaySinh = ac.formatStringToDateSQL(duLieuKhachHang[3], "ddMMyyyy");
//                GioiTinh = duLieuKhachHang[4];
//                NoiThuongTru = duLieuKhachHang[5];
//                khachHangDTO.setNgaySinh(NgaySinh);
//                khachHangDTO.setGioiTinh(GioiTinh);
//                khachHangDTO.setNoiThuongTru(NoiThuongTru);
//            }
            khachHangPresenter.ThemKhachHang(khachHangDTO);

            for (int i = 0; i < lsChonPhong.lsChonPhongDataInt.size(); i++) {
                //thêm phiếu đặt phòng chi tiết
                phieuDatPhongChiTietDTO = new PhieuDatPhongChiTietDTO(lsPhieuDat.get(lsPhieuDat.size() - 1).getPhieuDatID() + 1, lsChonPhong.lsChonPhongDataInt.get(i), 56);
                dsPhieuDatPhongPresenter.ThemPhieuDatPhongChiTiet(phieuDatPhongChiTietDTO);

                //cập nhật trạng thái phòng
                phongDTO = new PhongDTO();
                phongDTO.setPhongId(lsChonPhong.lsChonPhongDataInt.get(i));
                phongDTO.setTrangThaiId(2);
                phongPresenter.CapNhatTrangThaiPhong(phongDTO);
            }
//        Toast.makeText(this,  lsChonPhong.lsChonPhongDataInt.size(), Toast.LENGTH_LONG).show();
//            lsChonPhong.lsChonPhongDataInt.clear();
            onBackPressed();
        }
    }

    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result -> {
        if ((result.getContents() != null)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ThemPhieuDatphongActivity.this);
            builder.setTitle("Dữ liệu");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String a = result.getContents().toString();
                    String[] c = a.split("\\|");
                    duLieuKhachHang = c;
                    String CCCD = c[0];
                    String HoTen = c[2];
                    Date NgaySinh = ac.formatStringToDateSQL(c[3], "ddMMyyyy");
                    String GioiTinh = c[4];
                    String NoiThuongTru = c[5];
                    activityThemphieudatphongBinding.etCccdPhieudatphong.setText(CCCD);
                    activityThemphieudatphongBinding.etHotenPhieudatphong.setText(HoTen);
                    khachHangDTO.setNgaySinh(NgaySinh);
                    khachHangDTO.setGioiTinh(GioiTinh);
                    khachHangDTO.setNoiThuongTru(NoiThuongTru);
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });

    private void KiemTraDuLieuDauVao() {
        activityThemphieudatphongBinding.etHotenPhieudatphong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.setError("");
//                    Pattern pattern = Pattern.compile("abc");
//                    Matcher matcher = pattern.matcher(input);
//                    boolean hahaha= matcher.find();
//                    if (hahaha){
//                        activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.setHelperText("tốt");
//                        activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.setError("");
//                    }
//                    else {
//                        activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.setHelperText("");
//                        activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.setError(":(");
//                    }
                } else {
                    activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.setHelperText("");
                    //activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                    activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.setError("vui lòng nhập họ tên");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activityThemphieudatphongBinding.etCccdPhieudatphong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String abc = String.valueOf(activityThemphieudatphongBinding.etCccdPhieudatphong.getText());
                if (abc.length() == 12) {
                    activityThemphieudatphongBinding.inputlayoutCccdPhieudatphong.setHelperText("");
                    activityThemphieudatphongBinding.inputlayoutCccdPhieudatphong.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activityThemphieudatphongBinding.etCccdPhieudatphong.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String abc = String.valueOf(activityThemphieudatphongBinding.etCccdPhieudatphong.getText());
                if (hasFocus) {

                } else {
                    if (abc.length() < 12) {
                        activityThemphieudatphongBinding.inputlayoutCccdPhieudatphong.setHelperText("");
                        activityThemphieudatphongBinding.inputlayoutCccdPhieudatphong.setError("vui lòng nhập đủ cccd");
                    } else {
                        activityThemphieudatphongBinding.inputlayoutCccdPhieudatphong.setHelperText("");
                        activityThemphieudatphongBinding.inputlayoutCccdPhieudatphong.setError("");
                    }
                }

            }
        });
        activityThemphieudatphongBinding.etSdtPhieudatphong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String abc = String.valueOf(activityThemphieudatphongBinding.etSdtPhieudatphong.getText());
                if (abc.length() == 10) {
                    activityThemphieudatphongBinding.inputlayoutSdtPhieudatphong.setHelperText("");
                    activityThemphieudatphongBinding.inputlayoutSdtPhieudatphong.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activityThemphieudatphongBinding.etSdtPhieudatphong.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String abc = String.valueOf(activityThemphieudatphongBinding.etSdtPhieudatphong.getText());
                if (b) {

                } else {
                    if (abc.length() < 10) {
                        activityThemphieudatphongBinding.inputlayoutSdtPhieudatphong.setHelperText("");
                        activityThemphieudatphongBinding.inputlayoutSdtPhieudatphong.setError("vui lòng nhập đủ số điện thoại");
                    } else {
                        activityThemphieudatphongBinding.inputlayoutSdtPhieudatphong.setHelperText("");
                        activityThemphieudatphongBinding.inputlayoutSdtPhieudatphong.setError("");
                    }
                }
            }
        });

    }


    private void openDialogDateThoiGianNhan() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //activityThemphieudatphongBinding.etThoigiannhanPhieudatphong.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                thoiGianNhan = String.valueOf(day) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(year);
                if (day < 10) {
                    thoiGianNhan = "0" + String.valueOf(day);
                } else {
                    thoiGianNhan = String.valueOf(day);
                }
                if (month < 10) {
                    thoiGianNhan += "/0" + String.valueOf(month + 1) + "/" + String.valueOf(year);
                } else {
                    thoiGianNhan += "/" + String.valueOf(month + 1) + "/" + String.valueOf(year);
                }
                openDialogTimeThoiGianNhan();
            }
        }, statcal.get(Calendar.YEAR), statcal.get(Calendar.MONTH), statcal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void openDialogTimeThoiGianNhan() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                if (hour < 10) {
                    thoiGianNhan += " 0" + String.valueOf(hour);
                } else {
                    thoiGianNhan += " " + String.valueOf(hour);
                }
                if (minute < 10) {
                    thoiGianNhan += ":0" + (String.valueOf(minute));
                } else {
                    thoiGianNhan += ":" + (String.valueOf(minute));
                }

                activityThemphieudatphongBinding.etThoigiannhanPhieudatphong.setText(thoiGianNhan);
            }
        }, 15, 00, true);
        timePickerDialog.show();
    }

    private void openDialogDateThoiGianTra() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //activityThemphieudatphongBinding.etThoigianTraPhieudatphong.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
                thoiGianTra = String.valueOf(day) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(year);
                if (day < 10) {
                    thoiGianTra = "0" + String.valueOf(day);
                } else {
                    thoiGianTra = String.valueOf(day);
                }
                if (month < 10) {
                    thoiGianTra += "/0" + String.valueOf(month + 1) + "/" + String.valueOf(year);
                } else {
                    thoiGianTra += "/" + String.valueOf(month + 1) + "/" + String.valueOf(year);
                }
                openDialogTimeThoiGianTra();
            }
        }, statcal.get(Calendar.YEAR), statcal.get(Calendar.MONTH), statcal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void openDialogTimeThoiGianTra() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                if (hour < 10) {
                    thoiGianTra += " 0" + String.valueOf(hour);
                } else {
                    thoiGianTra += " " + String.valueOf(hour);
                }
                if (minute < 10) {
                    thoiGianTra += ":0" + (String.valueOf(minute));
                } else {
                    thoiGianTra += ":" + (String.valueOf(minute));
                }

                activityThemphieudatphongBinding.etThoigiantraPhieudatphong.setText(thoiGianTra);
            }
        }, 15, 00, true);
        timePickerDialog.show();
    }


    @Override
    public void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list) {
        lsPhieuDat = list;
    }

    @Override
    public void onLayDanhSachPhieuDatError(String error) {
//        Toast.makeText(this, "Lấy danh sách phiếu đặt phòng thất bại", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuDatPhongSuccess() {
        //Toast.makeText(this, "Thêm phiếu đặt phòng thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuDatPhongError(String error) {
        //Toast.makeText(this, "Thêm phiếu đặt phòng thất bại", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuDatPhongChiTietSuccess() {
        //Toast.makeText(this, "Thêm phiếu đặt phòng chi tiết thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuDatPhongChiTietError(String error) {
        //Toast.makeText(this, "Thêm phiếu đặt phòng chi tiết thất bại", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> lsLoaiPhong) {

    }

    @Override
    public void onLayLoaiPhongError(String error) {

    }

    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> lsDanhSachPhong) {
        lsphong = lsDanhSachPhong;
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
    public void onThemKhachHangSuccess() {
        Toast.makeText(this, "Thêm khách hàng thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemKhachHangError(String error) {
        Toast.makeText(this, "Thêm khách hàng thất bại", Toast.LENGTH_LONG).show();
    }
}