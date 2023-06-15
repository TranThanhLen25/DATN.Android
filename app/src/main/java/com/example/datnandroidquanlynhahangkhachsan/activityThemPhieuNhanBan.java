package com.example.datnandroidquanlynhahangkhachsan;

import static com.example.datnandroidquanlynhahangkhachsan.tempData.lsChonPhong.lsChonBanDataInt;

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

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemPhieuNhanBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.MutilTable.NhanBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonBan.activity_chon_ban;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class activityThemPhieuNhanBan extends AppCompatActivity  implements DsPhieuNhanPhongContract.View, KhachHangContract.View, LoaiPhongContract.View{
    private ActivityThemPhieuNhanBanBinding activityThemPhieuNhanBanBinding;
    private String thoiGianNhan;
    private String thoiGianTra;
    private AppUtils ac;
    Calendar statcal = Calendar.getInstance(Locale.CHINESE);
    private NhanBanDTO nhanBanDTO;
    private PhieuNhanDTO phieuNhanDTO;
    private List<PhieuNhanBanChiTietDTO> phieuNhanBanChiTietDTOS;
    private DsPhieuNhanPhongPresenter dsPhieuNhanPhongPresenter;
    private KhachHangDTO khachHangDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThemPhieuNhanBanBinding = activityThemPhieuNhanBanBinding.inflate(getLayoutInflater());
        setContentView(activityThemPhieuNhanBanBinding.getRoot());
        dsPhieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        khachHangDTO = new KhachHangDTO();
        activityThemPhieuNhanBanBinding.toolbarPhieunhanban.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lsChonBanDataInt.clear();
                onBackPressed();
            }
        });
        activityThemPhieuNhanBanBinding.BtnScanQRPhieunhanban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScanOptions options = new ScanOptions();
                options.setCaptureActivity(CaptureAct.class);
                barLaucher.launch(options);
            }
        });
        activityThemPhieuNhanBanBinding.imgbtnThoigiannhanThemphieunhanban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogDateThoiGianNhan();
            }
        });
        activityThemPhieuNhanBanBinding.imgbtnThoigiantraThemphieunhanban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogDateThoiGianTra();
            }
        });
        activityThemPhieuNhanBanBinding.thembanPhieunhanban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityThemPhieuNhanBan.this, activity_chon_ban.class);
                startActivity(intent);
            }
        });
        activityThemPhieuNhanBanBinding.btnThemphieunhanban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // onclickThemPhieuNhanBan();
                OnclickThemPhieuNhan();
            }
        });
        KiemTraDuLieuDauVao();
        setThoiGianNhanMacDinh();
        SetDuLieuNeuCo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lsChonBanDataInt.size() > 0) {
            String a = String.valueOf(lsChonBanDataInt.size());
            Toast.makeText(this, a, Toast.LENGTH_LONG).show();
        }
    }

    private void SetDuLieuNeuCo() {
        if (tempData.tempDatakhachHangDTO != null) {
            if (tempData.tempDatakhachHangDTO.getTenKhachHang()!=null){

                activityThemPhieuNhanBanBinding.etHotenPhieunhanban.setText(tempData.tempDatakhachHangDTO.getTenKhachHang());
            }
            if (tempData.tempDatakhachHangDTO.getCccd() != null) {
                activityThemPhieuNhanBanBinding.etCccdPhieunhanban.setText(tempData.tempDatakhachHangDTO.getCccd());
            }
            activityThemPhieuNhanBanBinding.etSdtPhieunhanban.setText(tempData.tempDatakhachHangDTO.getSdt());
        }
//        if (tempData.datPhongDTO.getPhieuDatPhongChiTiets().size() > 0) {
//            //lấy danh sách loại phòng
//            loaiPhongDTOList = new ArrayList<>();
//            loaiPhongPresenter = new LoaiPhongPresenter(this);
//            loaiPhongPresenter.LayLoaiPhong();
//
//            String soLuongPhong = "";
//            int loaiPhongID;
//            for (int i = 0; i < tempData.datPhongDTO.getPhieuDatPhongChiTiets().size(); i++) {
//                soLuongPhong += String.valueOf(i);
//                loaiPhongID = Integer.valueOf(tempData.datPhongDTO.getPhieuDatPhongChiTiets().get(i).getLoaiPhongId());
//                for (int j = 0; j < loaiPhongDTOList.size(); j++) {
//                    if (loaiPhongID == loaiPhongDTOList.get(j).getLoaiPhongId()) {
//                        soLuongPhong += String.valueOf(" " + loaiPhongDTOList.get(j).getTenLoaiPhong() + tempData.datPhongDTO.getPhieuDatPhongChiTiets().get(i).getSoLuong());
//                        if (i < tempData.datPhongDTO.getPhieuDatPhongChiTiets().size() + 1) {
//                            soLuongPhong += ", ";
//                        }
//                    }
//                }
//            }
//            themphieunhanphongBinding.tvPhongDataPhieunhanphong.setText(soLuongPhong);
//        }
    }

    private void OnclickThemPhieuNhan() {
        //kiểm tra dữ liệu trước khi thêm phiếu đặt phòng
        if (activityThemPhieuNhanBanBinding.etHotenPhieunhanban.length() < 1
                || activityThemPhieuNhanBanBinding.etCccdPhieunhanban.length() < 12
                || activityThemPhieuNhanBanBinding.etSdtPhieunhanban.length() < 10
                || thoiGianNhan == "") {
            Toast.makeText(this, "vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
        } else {
            Date thoiGianNhanPhong = ac.formatStringToDateUtil(thoiGianNhan, "dd/MM/yyyy HH:mm");
            Date thoiGianTraPhong = null;
            thoiGianTra = String.valueOf(activityThemPhieuNhanBanBinding.etThoigiantraPhieunhanban.getText());
            if (thoiGianTra != null || thoiGianTra != "") {
                thoiGianTraPhong = ac.formatStringToDateUtil(thoiGianTra, "dd/MM/yyyy HH:mm");
            }
            //lấy dữ liệu phiếu đặt rồi thêm vào biến tạm
            phieuNhanDTO = new PhieuNhanDTO("", thoiGianNhanPhong, 1, 4, thoiGianTraPhong, 1L, "", "đang nhận bàn");
            //phieuDatDTO = new PhieuDatDTO("",thoiGianNhanPhong,1,2,thoiGianNhanPhong,thoiGianTraPhong,"",1L,"đang đặt");

            //tạo danh sách phiếu nhận chi tiết
            phieuNhanBanChiTietDTOS = new ArrayList<>();
            for (int i = 0; i < lsChonBanDataInt.size(); i++) {
                PhieuNhanBanChiTietDTO phieuNhanPhongChiTietDTO = new PhieuNhanBanChiTietDTO();
                phieuNhanPhongChiTietDTO.setPhieuNhanId(0);
                phieuNhanPhongChiTietDTO.setBanId(lsChonBanDataInt.get(i));
                phieuNhanPhongChiTietDTO.setSoNguoi(1);
                phieuNhanPhongChiTietDTO.setTrangThai(4);
                phieuNhanPhongChiTietDTO.setThoiGianNhanBan(thoiGianNhanPhong);
                phieuNhanPhongChiTietDTO.setThoiGianTraBan(thoiGianTraPhong);
                phieuNhanBanChiTietDTOS.add(phieuNhanPhongChiTietDTO);
            }

//            lsphieuDatBanChiTietDTO=new ArrayList<>();
//            for (int i=0;i<lsChonBanDataInt.size();i++){
//                PhieuDatBanChiTietDTO phieuDatBanChiTietDTO1 = new PhieuDatBanChiTietDTO();
//                phieuDatBanChiTietDTO1.setPhieuDatId(0L);
//                phieuDatBanChiTietDTO1.setBanId(lsChonBanDataInt.get(i));
//                phieuDatBanChiTietDTO1.setSoNguoi(1);
//                phieuDatBanChiTietDTO1.setThoiGianNhanDuKien(thoiGianNhanPhong);
//                phieuDatBanChiTietDTO1.setTrangThai("đang đặt");
//                lsphieuDatBanChiTietDTO.add(phieuDatBanChiTietDTO1);
//            }

            //tạo khách hàng

            //lấy dữ liệu khách hàng từ edittext
            //nếu quét qr thì có thêm các thông tin khác còn không thì vẫn lấy ít nhất 3 thông tin của khách
            String sdt = String.valueOf(activityThemPhieuNhanBanBinding.etSdtPhieunhanban.getText());
            String CCCD = String.valueOf(activityThemPhieuNhanBanBinding.etCccdPhieunhanban.getText());
            String Hoten = String.valueOf(activityThemPhieuNhanBanBinding.etHotenPhieunhanban.getText());

            //set dữ liệu khách hàng vào biến khách hàng và thêm khách hàng vào database
            khachHangDTO.setCccd(CCCD);
            khachHangDTO.setTenKhachHang(Hoten);
            khachHangDTO.setSdt(sdt);
//
//            nhanPhongDTO = new NhanPhongDTO(phieuNhanDTO, phieuNhanPhongChiTietDTOS, khachHangDTO);
//            dsPhieuNhanPhongPresenter.ThemPhieuNhanPhong(nhanPhongDTO);

//            datBanDTO = new DatBanDTO(phieuDatDTO,lsphieuDatBanChiTietDTO,khachHangDTO);
//            dsPhieuDatPhongPresenter.ThemPhieuDatBan(datBanDTO);

            nhanBanDTO = new NhanBanDTO(phieuNhanDTO, phieuNhanBanChiTietDTOS, khachHangDTO);
            //dsPhieuNhanPhongPresenter.ThemPhieuNhanBan(nhanBanDTO);
            dsPhieuNhanPhongPresenter.ThemPhieuNhanBan(nhanBanDTO);

            String a = String.valueOf(khachHangDTO.getTenKhachHang());
            a+=nhanBanDTO.getPhieuNhanDTO().getTrangThai()+" "+nhanBanDTO.getPhieuNhanBanChiTietDTOs().size();
            Toast.makeText(this, a, Toast.LENGTH_LONG).show();
            lsChonBanDataInt.clear();
            onBackPressed();
        }
    }

    private void KiemTraDuLieuDauVao() {

        activityThemPhieuNhanBanBinding.inputlayoutHotenPhieunhanban.setHelperText("*lưu ý : Tên Khách Hàng là Bắt buộc");
        activityThemPhieuNhanBanBinding.etHotenPhieunhanban.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                activityThemPhieuNhanBanBinding.inputlayoutHotenPhieunhanban.setHelperText("*lưu ý : Tên Khách Hàng là Bắt buộc");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString();
                if (input.length() > 0) {
                    //activityThemPhieuNhanBanBinding.inputlayoutHotenPhieunhanphong.setError("*lưu ý : Tên Khách Hàng là Bắt buộc");
                    activityThemPhieuNhanBanBinding.inputlayoutHotenPhieunhanban.setHelperText("*lưu ý : Tên Khách Hàng là Bắt buộc");
//                    Pattern pattern = Pattern.compile("abc");
//                    Matcher matcher = pattern.matcher(input);
//                    boolean hahaha= matcher.find();
//                    if (hahaha){
//                        activityThemPhieuNhanBanBinding.inputlayoutHotenPhieudatphong.setHelperText("tốt");
//                        activityThemPhieuNhanBanBinding.inputlayoutHotenPhieudatphong.setError("");
//                    }
//                    else {
//                        activityThemPhieuNhanBanBinding.inputlayoutHotenPhieudatphong.setHelperText("");
//                        activityThemPhieuNhanBanBinding.inputlayoutHotenPhieudatphong.setError(":(");
//                    }
                } else {
                    // activityThemPhieuNhanBanBinding.inputlayoutHotenPhieunhanphong.setHelperText("*lưu ý : Tên Khách Hàng là Bắt buộc");
                    //activityThemPhieuNhanBanBinding.inputlayoutHotenPhieudatphong.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                    activityThemPhieuNhanBanBinding.inputlayoutHotenPhieunhanban.setError("vui lòng nhập họ tên");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        activityThemPhieuNhanBanBinding.etCccdPhieunhanban.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String abc = String.valueOf(activityThemPhieuNhanBanBinding.etCccdPhieunhanban.getText());
                if (abc.length() == 12) {
                    activityThemPhieuNhanBanBinding.inputlayoutCccdPhieunhanban.setHelperText("");
                    activityThemPhieuNhanBanBinding.inputlayoutCccdPhieunhanban.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activityThemPhieuNhanBanBinding.etCccdPhieunhanban.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String abc = String.valueOf(activityThemPhieuNhanBanBinding.etCccdPhieunhanban.getText());
                if (hasFocus) {

                } else {
                    if (abc.length() < 12) {
                        activityThemPhieuNhanBanBinding.inputlayoutCccdPhieunhanban.setHelperText("");
                        activityThemPhieuNhanBanBinding.inputlayoutCccdPhieunhanban.setError("vui lòng nhập đủ cccd");
                    } else {
                        activityThemPhieuNhanBanBinding.inputlayoutCccdPhieunhanban.setHelperText("");
                        activityThemPhieuNhanBanBinding.inputlayoutCccdPhieunhanban.setError("");
                    }
                }

            }
        });
        activityThemPhieuNhanBanBinding.etSdtPhieunhanban.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String abc = String.valueOf(activityThemPhieuNhanBanBinding.etSdtPhieunhanban.getText());
                if (abc.length() == 10) {
                    activityThemPhieuNhanBanBinding.inputlayoutSdtPhieunhanban.setHelperText("");
                    activityThemPhieuNhanBanBinding.inputlayoutSdtPhieunhanban.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activityThemPhieuNhanBanBinding.etSdtPhieunhanban.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String abc = String.valueOf(activityThemPhieuNhanBanBinding.etSdtPhieunhanban.getText());
                if (b) {

                } else {
                    if (abc.length() < 10) {
                        activityThemPhieuNhanBanBinding.inputlayoutSdtPhieunhanban.setHelperText("");
                        activityThemPhieuNhanBanBinding.inputlayoutSdtPhieunhanban.setError("vui lòng nhập đủ số điện thoại");
                    } else {
                        activityThemPhieuNhanBanBinding.inputlayoutSdtPhieunhanban.setHelperText("");
                        activityThemPhieuNhanBanBinding.inputlayoutSdtPhieunhanban.setError("");
                    }
                }
            }
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
            thoiGianNhan += " " + String.valueOf(statcal.get(Calendar.HOUR)) + ":";
        }
        if (statcal.get(Calendar.MINUTE) < 10) {
            thoiGianNhan += "0" + String.valueOf(statcal.get(Calendar.MINUTE));
        } else {
            thoiGianNhan += String.valueOf(statcal.get(Calendar.MINUTE));
        }
        activityThemPhieuNhanBanBinding.etThoigiannhanPhieunhanban.setText(thoiGianNhan);
    }

    ActivityResultLauncher<ScanOptions> barLaucher = registerForActivityResult(new ScanContract(), result -> {
        if ((result.getContents() != null)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activityThemPhieuNhanBan.this);
            builder.setTitle("Dữ liệu");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
//                    String a = result.getContents().toString();
//                    String[] c = a.split("\\|");
//                    String HoTen = c[2];
//                    String CCCD = c[0];
//                    activityThemPhieuNhanBanBinding.etHotenPhieunhanphong.setText(HoTen);
//                    activityThemPhieuNhanBanBinding.etCccdPhieunhanphong.setText(CCCD);
//                    dialogInterface.dismiss();
                    String a = result.getContents().toString();
                    String[] c = a.split("\\|");
                    String CCCD = c[0];
                    String HoTen = c[2];
                    Date NgaySinh = ac.formatStringToDateSQL(c[3], "ddMMyyyy");
                    String GioiTinh = c[4];
                    String NoiThuongTru = c[5];
                    activityThemPhieuNhanBanBinding.etCccdPhieunhanban.setText(CCCD);
                    activityThemPhieuNhanBanBinding.etHotenPhieunhanban.setText(HoTen);
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
                //activityThemPhieuNhanBanBinding.etThoigiannhanPhieunhanphong.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
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

                activityThemPhieuNhanBanBinding.etThoigiannhanPhieunhanban.setText(thoiGianNhan);
            }
        }, statcal.get(Calendar.HOUR), statcal.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    private void openDialogDateThoiGianTra() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //activityThemPhieuNhanBanBinding.etThoigianTraPhieunhanphong.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
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

                activityThemPhieuNhanBanBinding.etThoigiantraPhieunhanban.setText(thoiGianTra);
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

    @Override
    public void onThemPhieuNhanBanSuccess() {
        Toast.makeText(this, "thêm phiếu nhận bàn thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onThemPhieuNhanBanError(String error) {
        Toast.makeText(this, "thêm phiếu nhận bàn thất bại", Toast.LENGTH_LONG).show();
    }

//    @Override
//    public void onThemPhieuNhanBanSuccess() {
//        Toast.makeText(this, "thêm phiếu nhận bàn thành công", Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onThemPhieuNhanBanError(String error) {
//        Toast.makeText(this, "thêm phiếu nhận bàn thành công", Toast.LENGTH_LONG).show();
//    }
}