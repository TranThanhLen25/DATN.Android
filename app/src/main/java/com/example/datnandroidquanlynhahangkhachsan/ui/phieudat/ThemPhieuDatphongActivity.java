package com.example.datnandroidquanlynhahangkhachsan.ui.phieudat;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ThemPhieuDatphongActivity extends AppCompatActivity implements DsPhieuDatPhongContract.View {
    private ActivityThemphieudatphongBinding activityThemphieudatphongBinding;
    private List<PhieuDatDTO> lsPhieuDat;

    private List<Integer> lsPhong;
    private PhieuDatPhongAdapter phieuDatPhongAdapter;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter;
    private String thoiGianNhan = "";
    private String thoiGianTra = "";
    PhieuDatDTO phieuDatDTO;

    PhieuDatPhongChiTietDTO phieuDatPhongChiTietDTO;
    List<PhieuDatPhongChiTietDTO> lsPhieuDatPhongChiTiet;
    private AppUtils ac;
    Calendar statcal = Calendar.getInstance(Locale.CHINESE);
    DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThemphieudatphongBinding = activityThemphieudatphongBinding.inflate(getLayoutInflater());
        setContentView(activityThemphieudatphongBinding.getRoot());
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

        activityThemphieudatphongBinding.toolbarPhieudatphong.icBack.setOnClickListener(view -> onBackPressed());
        activityThemphieudatphongBinding.btnThemphieudatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnclickThemPhieuDatPhong();
                onBackPressed();
            }
        });
        lsPhieuDat = new ArrayList<>();
        lsPhong = new ArrayList<>();
        lsPhieuDatPhongChiTiet = new ArrayList<>();
        lsPhong.add(7);
        lsPhong.add(8);
        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
        dieuKienLocPhieuDatDTO = new DieuKienLocPhieuDatDTO();
        dieuKienLocPhieuDatDTO.setLoaiPhieu(1);
        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
        KiemTraDuLieuDauVao();
    }

    private void OnclickThemPhieuDatPhong() {
        dieuKienLocPhieuDatDTO.setLoaiPhieu(1);
        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
        Date day = Calendar.getInstance().getTime();
        Date thoiGianNhanPhong = ac.formatStringToDateUtil(thoiGianNhan, "dd/MM/yyyy HH:mm");
        Date thoiGianTraPhong = null;
        if (thoiGianTra != null || thoiGianTra != "") {
            thoiGianTraPhong = ac.formatStringToDateUtil(thoiGianTra, "dd/MM/yyyy HH:mm");
        }
        phieuDatDTO = new PhieuDatDTO("PDP" + (lsPhieuDat.size() + 1), day, 1, 1, thoiGianNhanPhong, thoiGianTraPhong, "ghi chu", 1L, "đang đặt");
        dsPhieuDatPhongPresenter.ThemPhieuDatPhong(phieuDatDTO);
        for (int i = 0; i < lsPhong.size(); i++) {
            phieuDatPhongChiTietDTO = new PhieuDatPhongChiTietDTO(lsPhieuDat.get(lsPhieuDat.size() - 1).getPhieuDatID() + 1, lsPhong.get(i), 56);
            dsPhieuDatPhongPresenter.ThemPhieuDatPhongChiTiet(phieuDatPhongChiTietDTO);
        }

    }

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
                    activityThemphieudatphongBinding.inputlayoutHotenPhieudatphong.setError("vui lòng nhập họ tên");
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
                    String HoTen = c[0];
                    String CCCD = c[2];
                    activityThemphieudatphongBinding.etCccdPhieudatphong.setText(HoTen);
                    activityThemphieudatphongBinding.etHotenPhieudatphong.setText(CCCD);
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });


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
        Toast.makeText(this, "Thêm phiếu đặt phòng chi tiết thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuDatPhongChiTietError(String error) {
        Toast.makeText(this, "Thêm phiếu đặt phòng chi tiết thất bại", Toast.LENGTH_LONG).show();
    }
}