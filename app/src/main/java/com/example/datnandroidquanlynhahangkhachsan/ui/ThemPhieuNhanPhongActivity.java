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
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieunhanphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.Calendar;
import java.util.Locale;

public class ThemPhieuNhanPhongActivity extends AppCompatActivity {
    private ActivityThemphieunhanphongBinding themphieunhanphongBinding;
    private String thoiGianNhan;
    private String thoiGianTra;
    private AppUtils ac;
    Calendar statcal = Calendar.getInstance(Locale.CHINESE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themphieunhanphongBinding = themphieunhanphongBinding.inflate(getLayoutInflater());
        setContentView(themphieunhanphongBinding.getRoot());
        themphieunhanphongBinding.btnQuetqr.setOnClickListener(view -> {
            ScanOptions options = new ScanOptions();
            options.setCaptureActivity(CaptureAct.class);
            barLaucher.launch(options);
        });
        setThoiGianNhanMacDinh();
        themphieunhanphongBinding.imgbtnThoigiannhanThemphieunhanphong.setOnClickListener(view -> {
            openDialogDateThoiGianNhan();
        });
        themphieunhanphongBinding.imgbtnThoigiantraThemphieunhanphong.setOnClickListener(view -> {
            openDialogDateThoiGianTra();
        });

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
            thoiGianNhan += " " +String.valueOf(statcal.get(Calendar.HOUR)) + ":";
        }
        if (statcal.get(Calendar.MINUTE) < 10) {
            thoiGianNhan += "0" + String.valueOf(statcal.get(Calendar.MINUTE));
        } else {
            thoiGianNhan += String.valueOf(statcal.get(Calendar.MINUTE));
        }
        themphieunhanphongBinding.etThoigiannhanPhieunhanphong.setText(thoiGianNhan);
    }

    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result -> {
        if ((result.getContents() != null)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ThemPhieuNhanPhongActivity.this);
            builder.setTitle("Dữ liệu");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String a = result.getContents().toString();
                    String[] c = a.split("\\|");
                    String HoTen = c[2];
                    String CCCD = c[0];
                    themphieunhanphongBinding.etHotenPhieunhanphong.setText(HoTen);
                    themphieunhanphongBinding.etCccdPhieunhanphong.setText(CCCD);
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });

    private void openDialogDateThoiGianNhan() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //themphieunhanphongBinding.etThoigiannhanPhieunhanphong.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
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

                themphieunhanphongBinding.etThoigiannhanPhieunhanphong.setText(thoiGianNhan);
            }
        }, statcal.get(Calendar.HOUR), statcal.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    private void openDialogDateThoiGianTra() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //themphieunhanphongBinding.etThoigianTraPhieunhanphong.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
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

                themphieunhanphongBinding.etThoigiantraPhieunhanphong.setText(thoiGianTra);
            }
        }, 15, 00, true);
        timePickerDialog.show();
    }
}
