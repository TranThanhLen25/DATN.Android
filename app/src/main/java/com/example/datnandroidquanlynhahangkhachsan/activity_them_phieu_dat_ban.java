package com.example.datnandroidquanlynhahangkhachsan;

import static com.example.datnandroidquanlynhahangkhachsan.tempData.lsChonPhong.lsChonBanDataInt;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.LoaiBanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemPhieuDatBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.DatBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonBan.activity_chon_ban;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class activity_them_phieu_dat_ban extends AppCompatActivity implements DsPhieuDatPhongContract.View, LoaiPhongContract.View, KhachHangContract.View {
    private ActivityThemPhieuDatBanBinding activityThemPhieuDatBanBinding;
    private AppUtils ac;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter;
    private String thoiGianNhan = "";
    private String thoiGianTra = "";
    private LoaiPhongPresenter loaiPhongPresenter;
    private PhieuDatBanChiTietDTO phieuDatBanChiTietDTO;
    private List<PhieuDatBanChiTietDTO> lsphieuDatBanChiTietDTO;
    Calendar statcal = Calendar.getInstance(Locale.CHINESE);
    DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 1000;
    private KhachHangDTO khachHangDTO;
    private List<LoaiBanDTO> loaiBanDTOList;
    private LoaiBanAdapter loaiBanAdapter;
    private RecyclerView rcv_LoaiPhong;
    private DatBanDTO datBanDTO;
    private PhieuDatDTO phieuDatDTO;
    private List<PhieuDatBanChiTietDTO> ListPhieuDatBanChiTiet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThemPhieuDatBanBinding = activityThemPhieuDatBanBinding.inflate(getLayoutInflater());
        setContentView(activityThemPhieuDatBanBinding.getRoot());
        dsPhieuDatPhongPresenter=new DsPhieuDatPhongPresenter(this);
        khachHangDTO=new KhachHangDTO();


        KiemTraDuLieuDauVao();
        //setThoiGianNhanMacDinh();

        activityThemPhieuDatBanBinding.thembanPhieunhanban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_them_phieu_dat_ban.this, activity_chon_ban.class);
                startActivity(intent);
            }
        });
        activityThemPhieuDatBanBinding.toolbarPhieudatban.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.CheckChucNang = false;
                lsChonBanDataInt.clear();
                onBackPressed();
            }
        });
        activityThemPhieuDatBanBinding.BtnScanQRPhieudatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScanOptions options = new ScanOptions();
                options.setCaptureActivity(CaptureAct.class);
                barLaucher.launch(options);
            }
        });
        activityThemPhieuDatBanBinding.imgbtnThoigiannhanThemphieudatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogDateThoiGianNhan();
            }
        });
        activityThemPhieuDatBanBinding.imgbtnThoigiantraThemphieudatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogDateThoiGianTra();
            }
        });
        activityThemPhieuDatBanBinding.btnThemphieudatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnclickThemPhieuDat();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lsChonBanDataInt.size() > 0) {
            String a = String.valueOf(lsChonBanDataInt.size());
            Toast.makeText(this, a, Toast.LENGTH_LONG).show();
        }
    }

    private void OnclickThemPhieuDat() {
        //kiểm tra dữ liệu trước khi thêm phiếu đặt phòng
        if (activityThemPhieuDatBanBinding.etHotenPhieudatban.length() < 1
                || activityThemPhieuDatBanBinding.etCccdPhieudatban.length() < 12
                || activityThemPhieuDatBanBinding.etSdtPhieudatban.length() < 10
                || thoiGianNhan == "") {
            Toast.makeText(this, "vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
        } else {
            Date thoiGianNhanPhong = ac.formatStringToDateUtil(thoiGianNhan, "dd/MM/yyyy HH:mm");
            Date thoiGianTraPhong = null;
            thoiGianTra = String.valueOf(activityThemPhieuDatBanBinding.etThoigiantraPhieudatban.getText());
            if (thoiGianTra != null || thoiGianTra != "") {
                thoiGianTraPhong = ac.formatStringToDateUtil(thoiGianTra, "dd/MM/yyyy HH:mm");
            }
            //lấy dữ liệu phiếu đặt rồi thêm vào biến tạm
            //phieuNhanDTO = new PhieuNhanDTO("", thoiGianNhanPhong, 1, 3, thoiGianTraPhong, 1L, "", "đang nhận phòng");
            phieuDatDTO = new PhieuDatDTO("",thoiGianNhanPhong,1,2,thoiGianNhanPhong,thoiGianTraPhong,"",1L,"đang đặt");

            //tạo danh sách phiếu nhận chi tiết
//            phieuNhanPhongChiTietDTOS = new ArrayList<>();
//            for (int i = 0; i < lsChonPhongDataInt.size(); i++) {
//                PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO = new PhieuNhanPhongChiTietDTO();
//                phieuNhanPhongChiTietDTO.setPhieuNhanId(0);
//                phieuNhanPhongChiTietDTO.setPhongId(lsChonPhongDataInt.get(i));
//                phieuNhanPhongChiTietDTO.setSoNguoi(Integer.valueOf(String.valueOf(activityThemPhieuDatBanBinding.etSonguoiPhieunhanphong.getText())));
//                phieuNhanPhongChiTietDTO.setTrangThai(4);
//                phieuNhanPhongChiTietDTO.setThoiGianNhanPhong(thoiGianNhanPhong);
//                phieuNhanPhongChiTietDTO.setThoiGianTraPhong(thoiGianTraPhong);
//                phieuNhanPhongChiTietDTO.setDonGia(1);
//                phieuNhanPhongChiTietDTOS.add(phieuNhanPhongChiTietDTO);
//            }

            lsphieuDatBanChiTietDTO=new ArrayList<>();
            for (int i=0;i<lsChonBanDataInt.size();i++){
                PhieuDatBanChiTietDTO phieuDatBanChiTietDTO1 = new PhieuDatBanChiTietDTO();
                phieuDatBanChiTietDTO1.setPhieuDatId(0L);
                phieuDatBanChiTietDTO1.setBanId(lsChonBanDataInt.get(i));
                phieuDatBanChiTietDTO1.setSoNguoi(1);
                phieuDatBanChiTietDTO1.setThoiGianNhanDuKien(thoiGianNhanPhong);
                phieuDatBanChiTietDTO1.setTrangThai("đang đặt");
                lsphieuDatBanChiTietDTO.add(phieuDatBanChiTietDTO1);
            }

            //tạo khách hàng

            //lấy dữ liệu khách hàng từ edittext
            //nếu quét qr thì có thêm các thông tin khác còn không thì vẫn lấy ít nhất 3 thông tin của khách
            String sdt = String.valueOf(activityThemPhieuDatBanBinding.etSdtPhieudatban.getText());
            String CCCD = String.valueOf(activityThemPhieuDatBanBinding.etCccdPhieudatban.getText());
            String Hoten = String.valueOf(activityThemPhieuDatBanBinding.etHotenPhieudatban.getText());

            //set dữ liệu khách hàng vào biến khách hàng và thêm khách hàng vào database
            khachHangDTO.setCccd(CCCD);
            khachHangDTO.setTenKhachHang(Hoten);
            khachHangDTO.setSdt(sdt);
//
//            nhanPhongDTO = new NhanPhongDTO(phieuNhanDTO, phieuNhanPhongChiTietDTOS, khachHangDTO);
//            dsPhieuNhanPhongPresenter.ThemPhieuNhanPhong(nhanPhongDTO);

            datBanDTO = new DatBanDTO(phieuDatDTO,lsphieuDatBanChiTietDTO,khachHangDTO);
            dsPhieuDatPhongPresenter.ThemPhieuDatBan(datBanDTO);

            String a = String.valueOf(khachHangDTO.getTenKhachHang());
            // Toast.makeText(this, a, Toast.LENGTH_LONG).show();
            tempData.CheckChucNang = false;
            lsChonBanDataInt.clear();
            onBackPressed();
            Intent i = new Intent(this, Nav_Ban_Activity.class);
            startActivity(i);
        }
    }

    private void setThoiGianNhanMacDinh() {
        if (statcal.get(Calendar.DAY_OF_MONTH) < 10) {
            thoiGianNhan = "0" + String.valueOf(statcal.get(Calendar.DAY_OF_MONTH)) + "/";
        } else {
            thoiGianNhan = String.valueOf(statcal.get(Calendar.DAY_OF_MONTH)) + "/";
        }
        if (statcal.get(Calendar.MONTH) < 10) {
            thoiGianNhan += "0" + String.valueOf(statcal.get(Calendar.MONTH)) + "/" + String.valueOf(statcal.get(Calendar.YEAR));
        } else {
            thoiGianNhan += String.valueOf(statcal.get(Calendar.MONTH)) + "/" + String.valueOf(statcal.get(Calendar.YEAR));
        }
        if (statcal.get(Calendar.HOUR) < 10) {
            thoiGianNhan += " 0" + String.valueOf(statcal.get(Calendar.HOUR)) + ":";
        } else {
            thoiGianNhan += " " + String.valueOf(statcal.get(Calendar.HOUR)) + ":";
        }
        if (statcal.get(Calendar.MINUTE) < 10) {
            thoiGianNhan += "0" + String.valueOf(statcal.get(Calendar.MINUTE));
        } else {
            thoiGianNhan += String.valueOf(statcal.get(Calendar.MINUTE));
        }
        activityThemPhieuDatBanBinding.etThoigiannhanPhieudatban.setText(thoiGianNhan);
    }


    //xử lý quét qrcode
    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result -> {
        if ((result.getContents() != null)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity_them_phieu_dat_ban.this);
            builder.setTitle("Dữ liệu");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                //xử lý dữ liệu nhận được từ qrcode
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String a = result.getContents().toString();
                    String[] c = a.split("\\|");
                    String CCCD = c[0];
                    String HoTen = c[2];
                    Date NgaySinh = ac.formatStringToDateSQL(c[3], "ddMMyyyy");
                    String GioiTinh = c[4];
                    String NoiThuongTru = c[5];
                    activityThemPhieuDatBanBinding.etCccdPhieudatban.setText(CCCD);
                    activityThemPhieuDatBanBinding.etHotenPhieudatban.setText(HoTen);
                    khachHangDTO.setNgaySinh(NgaySinh);
                    khachHangDTO.setGioiTinh(GioiTinh);
                    khachHangDTO.setNoiThuongTru(NoiThuongTru);
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });

    //xử lý dữ liệu người dùng nhập vào
    private void KiemTraDuLieuDauVao() {

        activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatban.setHelperText("*lưu ý : Tên Khách Hàng là Bắt buộc");
        activityThemPhieuDatBanBinding.etHotenPhieudatban.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatban.setError("");
//                    Pattern pattern = Pattern.compile("abc");
//                    Matcher matcher = pattern.matcher(input);
//                    boolean hahaha= matcher.find();
//                    if (hahaha){
//                        activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatphong.setHelperText("tốt");
//                        activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatphong.setError("");
//                    }
//                    else {
//                        activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatphong.setHelperText("");
//                        activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatphong.setError(":(");
//                    }
                } else {
                    activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatban.setHelperText("");
                    //activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatphong.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                    activityThemPhieuDatBanBinding.inputlayoutHotenPhieudatban.setError("vui lòng nhập họ tên");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activityThemPhieuDatBanBinding.etCccdPhieudatban.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String abc = String.valueOf(activityThemPhieuDatBanBinding.etCccdPhieudatban.getText());
                if (abc.length() == 12) {
                    activityThemPhieuDatBanBinding.inputlayoutCccdPhieudatban.setHelperText("");
                    activityThemPhieuDatBanBinding.inputlayoutCccdPhieudatban.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activityThemPhieuDatBanBinding.etCccdPhieudatban.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String abc = String.valueOf(activityThemPhieuDatBanBinding.etCccdPhieudatban.getText());
                if (hasFocus) {

                } else {
                    if (abc.length() < 12) {
                        activityThemPhieuDatBanBinding.inputlayoutCccdPhieudatban.setHelperText("");
                        activityThemPhieuDatBanBinding.inputlayoutCccdPhieudatban.setError("vui lòng nhập đủ cccd");
                    } else {
                        activityThemPhieuDatBanBinding.inputlayoutCccdPhieudatban.setHelperText("");
                        activityThemPhieuDatBanBinding.inputlayoutCccdPhieudatban.setError("");
                    }
                }

            }
        });
        activityThemPhieuDatBanBinding.etSdtPhieudatban.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String abc = String.valueOf(activityThemPhieuDatBanBinding.etSdtPhieudatban.getText());
                if (abc.length() == 10) {
                    activityThemPhieuDatBanBinding.inputlayoutSdtPhieudatban.setHelperText("");
                    activityThemPhieuDatBanBinding.inputlayoutSdtPhieudatban.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activityThemPhieuDatBanBinding.etSdtPhieudatban.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String abc = String.valueOf(activityThemPhieuDatBanBinding.etSdtPhieudatban.getText());
                if (b) {

                } else {
                    if (abc.length() < 10) {
                        activityThemPhieuDatBanBinding.inputlayoutSdtPhieudatban.setHelperText("");
                        activityThemPhieuDatBanBinding.inputlayoutSdtPhieudatban.setError("vui lòng nhập đủ số điện thoại");
                    } else {
                        activityThemPhieuDatBanBinding.inputlayoutSdtPhieudatban.setHelperText("");
                        activityThemPhieuDatBanBinding.inputlayoutSdtPhieudatban.setError("");
                    }
                }
            }
        });

    }


    private void openDialogDateThoiGianNhan() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //activityThemPhieuDatBanBinding.etThoigiannhanPhieudatphong.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
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

                activityThemPhieuDatBanBinding.etThoigiannhanPhieudatban.setText(thoiGianNhan);
            }
        }, 15, 00, true);
        timePickerDialog.show();
    }

    private void openDialogDateThoiGianTra() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //activityThemPhieuDatBanBinding.etThoigianTraPhieudatphong.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
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

                activityThemPhieuDatBanBinding.etThoigiantraPhieudatban.setText(thoiGianTra);
            }
        }, 15, 00, true);
        timePickerDialog.show();
    }


    @Override
    public void onThemKhachHangSuccess() {

    }

    @Override
    public void onThemKhachHangError(String error) {

    }

    @Override
    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {

    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {

    }

    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> lsLoaiPhong) {

    }

    @Override
    public void onLayLoaiPhongError(String error) {

    }

    @Override
    public void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list) {

    }

    @Override
    public void onLayDanhSachPhieuDatError(String error) {

    }

    @Override
    public void onThemPhieuDatPhongSuccess() {

    }

    @Override
    public void onThemPhieuDatPhongError(String error) {

    }

    @Override
    public void onThemPhieuDatPhongChiTietSuccess() {

    }

    @Override
    public void onThemPhieuDatPhongChiTietError(String error) {

    }

    @Override
    public void onLayPhieuDatPhongChiTietSuccess(List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOList) {

    }

    @Override
    public void onLayPhieuDatPhongChiTietError(String error) {

    }

    @Override
    public void onThemPhieuDatBanSuccess() {
        Toast.makeText(this, "thêm phiếu đặt bàn thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuDatBanError(String error) {
        Toast.makeText(this, "thêm phiếu đặt bàn thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLayPhieuDatBanChiTietSuccess(List<PhieuDatBanChiTietDTO> phieuDatPhongChiTietDTOList) {

    }

    @Override
    public void onLayPhieuDatBanChiTietError(String error) {

    }

    @Override
    public void onCapNhatPhieuDatSuccess() {

    }

    @Override
    public void onCapNhatPhieuDatError(String error) {

    }
}