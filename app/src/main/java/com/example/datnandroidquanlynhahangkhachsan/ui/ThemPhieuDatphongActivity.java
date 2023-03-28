package com.example.datnandroidquanlynhahangkhachsan.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.CaptureAct;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieudatphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.Calendar;
import java.util.Locale;

public class ThemPhieuDatphongActivity extends AppCompatActivity {
    private ActivityThemphieudatphongBinding activityThemphieudatphongBinding;
    private String thoiGianNhan;
    private String thoiGianTra;
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


}