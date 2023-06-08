package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

import static com.example.datnandroidquanlynhahangkhachsan.tempData.lsChonPhong.lsChonPhongDataInt;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.CaptureAct;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieunhanphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonphong.ChonPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ThemPhieuNhanPhongActivity extends AppCompatActivity implements DsPhieuNhanPhongContract.View, KhachHangContract.View {
    private ActivityThemphieunhanphongBinding themphieunhanphongBinding;
    private String thoiGianNhan;
    private String thoiGianTra;
    private AppUtils ac;
    Calendar statcal = Calendar.getInstance(Locale.CHINESE);
    private NhanPhongDTO nhanPhongDTO;
    private PhieuNhanDTO phieuNhanDTO;
    private List<PhieuNhanPhongChiTietDTO> phieuNhanPhongChiTietDTOS;
    private DsPhieuNhanPhongPresenter dsPhieuNhanPhongPresenter;
    private KhachHangDTO khachHangDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themphieunhanphongBinding = themphieunhanphongBinding.inflate(getLayoutInflater());
        setContentView(themphieunhanphongBinding.getRoot());
        dsPhieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        khachHangDTO = new KhachHangDTO();
        themphieunhanphongBinding.toolbarThemphieunhanphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lsChonPhongDataInt.clear();
                onBackPressed();
            }
        });
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
        themphieunhanphongBinding.themphongPhieunhanphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemPhieuNhanPhongActivity.this, ChonPhongActivity.class);
                startActivity(intent);
            }
        });
        themphieunhanphongBinding.btnXacnhanPhieunhaphang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnclickThemPhieuNhan();
            }
        });
    }

    private void OnclickThemPhieuNhan() {
        //kiểm tra dữ liệu trước khi thêm phiếu đặt phòng
        if (themphieunhanphongBinding.etHotenPhieunhanphong.length() < 1
                || themphieunhanphongBinding.etCccdPhieunhanphong.length() < 12
                || themphieunhanphongBinding.etSdtPhieunhanphong.length() < 10
                || thoiGianNhan == "") {
            Toast.makeText(this, "vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
        } else {
            Date thoiGianNhanPhong = ac.formatStringToDateUtil(thoiGianNhan, "dd/MM/yyyy HH:mm");
            Date thoiGianTraPhong = null;
            thoiGianTra = String.valueOf(themphieunhanphongBinding.etThoigiantraPhieunhanphong.getText());
            if (thoiGianTra != null || thoiGianTra != "") {
                thoiGianTraPhong = ac.formatStringToDateUtil(thoiGianTra, "dd/MM/yyyy HH:mm");
            }
            //lấy dữ liệu phiếu đặt rồi thêm vào biến tạm
            phieuNhanDTO = new PhieuNhanDTO("", thoiGianNhanPhong, 1, 3, thoiGianTraPhong, 1L, "", "đang nhận phòng");

            //tạo danh sách phiếu nhận chi tiết
            phieuNhanPhongChiTietDTOS = new ArrayList<>();
            for (int i = 0; i < lsChonPhongDataInt.size(); i++) {
                PhieuNhanPhongChiTietDTO phieuNhanPhongChiTietDTO = new PhieuNhanPhongChiTietDTO();
                phieuNhanPhongChiTietDTO.setPhieuNhanId(0);
                phieuNhanPhongChiTietDTO.setPhongId(lsChonPhongDataInt.get(i));
                phieuNhanPhongChiTietDTO.setSoNguoi(Integer.valueOf(String.valueOf(themphieunhanphongBinding.etSonguoiPhieunhanphong.getText())));
                phieuNhanPhongChiTietDTO.setTrangThai(4);
                phieuNhanPhongChiTietDTO.setThoiGianNhanPhong(thoiGianNhanPhong);
                phieuNhanPhongChiTietDTO.setThoiGianTraPhong(thoiGianTraPhong);
                phieuNhanPhongChiTietDTO.setDonGia(1);
                phieuNhanPhongChiTietDTOS.add(phieuNhanPhongChiTietDTO);
            }

            //tạo khách hàng

            //lấy dữ liệu khách hàng từ edittext
            //nếu quét qr thì có thêm các thông tin khác còn không thì vẫn lấy ít nhất 3 thông tin của khách
            String sdt = String.valueOf(themphieunhanphongBinding.etSdtPhieunhanphong.getText());
            String CCCD = String.valueOf(themphieunhanphongBinding.etCccdPhieunhanphong.getText());
            String Hoten = String.valueOf(themphieunhanphongBinding.etHotenPhieunhanphong.getText());

            //set dữ liệu khách hàng vào biến khách hàng và thêm khách hàng vào database
            khachHangDTO.setCccd(CCCD);
            khachHangDTO.setTenKhachHang(Hoten);
            khachHangDTO.setSdt(sdt);

            nhanPhongDTO = new NhanPhongDTO(phieuNhanDTO, phieuNhanPhongChiTietDTOS, khachHangDTO);
            dsPhieuNhanPhongPresenter.ThemPhieuNhanPhong(nhanPhongDTO);

            String a = String.valueOf(khachHangDTO.getTenKhachHang());
            Toast.makeText(this, a, Toast.LENGTH_LONG).show();
            lsChonPhongDataInt.clear();
            onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lsChonPhongDataInt.size() > 0) {
            String a = String.valueOf(lsChonPhongDataInt.size());
            Toast.makeText(this, a, Toast.LENGTH_LONG).show();
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
//                    String a = result.getContents().toString();
//                    String[] c = a.split("\\|");
//                    String HoTen = c[2];
//                    String CCCD = c[0];
//                    themphieunhanphongBinding.etHotenPhieunhanphong.setText(HoTen);
//                    themphieunhanphongBinding.etCccdPhieunhanphong.setText(CCCD);
//                    dialogInterface.dismiss();
                    String a = result.getContents().toString();
                    String[] c = a.split("\\|");
                    String CCCD = c[0];
                    String HoTen = c[2];
                    Date NgaySinh = ac.formatStringToDateSQL(c[3], "ddMMyyyy");
                    String GioiTinh = c[4];
                    String NoiThuongTru = c[5];
                    themphieunhanphongBinding.etCccdPhieunhanphong.setText(CCCD);
                    themphieunhanphongBinding.etHotenPhieunhanphong.setText(HoTen);
                    khachHangDTO.setNgaySinh(NgaySinh);
                    khachHangDTO.setGioiTinh(GioiTinh);
                    khachHangDTO.setNoiThuongTru(NoiThuongTru);
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
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {

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
}
