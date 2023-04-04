package com.example.datnandroidquanlynhahangkhachsan.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
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
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ThemPhieuDatphongActivity extends AppCompatActivity implements DsPhieuDatPhongContract.View {
    private ActivityThemphieudatphongBinding activityThemphieudatphongBinding;
    private List<PhieuDatDTO> lsPhieuDat;
    private PhieuDatPhongAdapter phieuDatPhongAdapter;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter;
    private String thoiGianNhan;
    private String thoiGianTra;


    PhieuDatDTO phieuDatDTO;
    private AppUtils ac;
    Calendar statcal = Calendar.getInstance(Locale.CHINESE);

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
            }
        });
    }

    private void OnclickThemPhieuDatPhong() {
        Date day = Calendar.getInstance().getTime();
        Date thoiGianNhanPhong= Calendar.getInstance().getTime();
        Date thoiGianTraPhong;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            thoiGianNhanPhong = format.parse(thoiGianNhan);
        } catch (ParseException e) {
        }
//        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(1);
        phieuDatDTO = new PhieuDatDTO("PDP", thoiGianNhanPhong, 1, 1, day, day, day.toString(), 1L, "đang đặt");
        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
        dsPhieuDatPhongPresenter.ThemPhieuDatPhong(phieuDatDTO);
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
//        lsPhieuDat = list;
//        phieuDatPhongAdapter = new PhieuDatPhongAdapter(this);
//        phieuDatPhongAdapter.setData(this, lsPhieuDat);
    }

    @Override
    public void onLayDanhSachPhieuDatError(String error) {
//        Toast.makeText(this, "Lấy danh sách phiếu đặt phòng thất bại", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuDatPhongSuccess() {
        Toast.makeText(this, "Thêm phiếu đặt phòng thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuDatPhongError(String error) {
        Toast.makeText(this, "Thêm phiếu đặt phòng thất bại", Toast.LENGTH_LONG).show();
    }
}