package com.example.datnandroidquanlynhahangkhachsan.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.Toolbar_Drawer_Activity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityDangNhapBinding;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityToolbarDrawerBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DangNhapActivity extends AppCompatActivity implements NguoiDungContract.View {

    private List<NguoiDungDTO> lsNguoiDung;
    private NguoiDungPresenter nguoiDungPresenter;
    private ActivityDangNhapBinding dangNhapBinding;
    private String LuuThongTin = "taikhoan and matkhau";
    private Boolean save = false;

    private AppUtils appUtils;
    String username = "";
    ActivityToolbarDrawerBinding toolbarDrawerBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        lsNguoiDung = new ArrayList<>();
        dangNhapBinding = ActivityDangNhapBinding.inflate(getLayoutInflater());
        toolbarDrawerBinding=ActivityToolbarDrawerBinding.inflate(getLayoutInflater());

        nguoiDungPresenter = new NguoiDungPresenter(DangNhapActivity.this);
        nguoiDungPresenter.LayNguoiDung();

        ///xét lỗi tài khoản
        dangNhapBinding.etTaikhoan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                boolean kt = appUtils.ktnhap(input);
                if (kt) {
                    dangNhapBinding.titleTk.setHelperText("");
                    dangNhapBinding.titleTk.setError("Vui lòng nhập tên tài khoản( A-Za-z0-9, 8 ký tự trở lên)");

                } else {
                    dangNhapBinding.titleTk.setError("");

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dangNhapBinding.etTaikhoan.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String tvTK = String.valueOf(dangNhapBinding.etTaikhoan.getText());
                if (b) {

                } else {
                    if (tvTK.length() < 8 || appUtils.ktnhap(tvTK)) {
                        dangNhapBinding.titleTk.setError("Vui lòng nhập tên tài khoản( A-Za-z0-9, 8 ký tự trở lên)");
                        dangNhapBinding.titleTk.setHelperText("");
                    } else {
                        dangNhapBinding.titleTk.setError("");
                        dangNhapBinding.titleTk.setHelperText("");
                    }
                }
            }
        });
        /// xét lỗi mật khẩu
        dangNhapBinding.etMatkhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                boolean kt=appUtils.ktnhap(input);
                if (!kt) {
                    dangNhapBinding.titleMk.setError("");
                } else {
                    dangNhapBinding.titleMk.setError("Vui lòng nhập mật khẩu( A-Za-z0-9, 8 ký tự trở lên)");
                    dangNhapBinding.titleMk.setHelperText("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dangNhapBinding.etMatkhau.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String tvMK = String.valueOf(dangNhapBinding.etMatkhau.getText());
                if (b) {

                } else {
                    if (tvMK.length() < 8 || appUtils.ktnhap(tvMK)) {
                        dangNhapBinding.titleMk.setError("Vui lòng nhập mật khẩu( A-Za-z0-9, 8 ký tự trở lên)");
                        dangNhapBinding.titleMk.setHelperText("");
                    } else {
                        dangNhapBinding.titleMk.setError("");
                        dangNhapBinding.titleMk.setHelperText("");
                    }
                }
            }
        });

        dangNhapBinding.btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String MK=dangNhapBinding.etMatkhau.getText().toString();

                for (int i = 0; i < lsNguoiDung.size(); i++) {
                    if (dangNhapBinding.etTaikhoan.getText().toString().equals(lsNguoiDung.get(i).getTaiKhoan())
                            && md5(MK).equals(lsNguoiDung.get(i).getMatKhau())) {

                        rememberUser(
                                dangNhapBinding.etTaikhoan.getText().toString(),
                                md5(dangNhapBinding.etMatkhau.getText().toString()),
                                lsNguoiDung.get(i).getNguoiDungId(),
                                lsNguoiDung.get(i).getTenNguoiDung(),
                                lsNguoiDung.get(i).getSdt(),
                                lsNguoiDung.get(i).getCccd(),
                                lsNguoiDung.get(i).getGioiTinh(),
                                lsNguoiDung.get(i).getDiaChi(),
                                lsNguoiDung.get(i).getLoaiTaiKhoan(),
                                true);
                                 save = true;

                        Intent intent = new Intent(DangNhapActivity.this, Toolbar_Drawer_Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();

                    }
                }
                if (save == false)
                    Toast.makeText(DangNhapActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
            }
        });


        if (check() == 1) {
            Intent intent = new Intent(DangNhapActivity.this, Toolbar_Drawer_Activity.class);

            startActivity(intent);
        }
        setContentView(dangNhapBinding.getRoot());


    }

    public void rememberUser(String username,
                             String password,
                             int id,
                             String tennguoidung,
                             String sdt,
                             String cccd,
                             String gioitinh,
                             String diachi,
                             String loaitaikhoan,
                             boolean status) {
        SharedPreferences sharedPreferences = getSharedPreferences("NGUOI_DUNG", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
//        Gson gson = new Gson();
//        gson.toJson()

        ///Thêm dữ liệu vào file
        editor.putString("USERNAME", username);
        editor.putString("PASSWORD", password);
        editor.putInt("ID", id);
        editor.putString("TENNGUOIDUNG", tennguoidung);
        editor.putString("SDT", sdt);
        editor.putString("CCCD", cccd);
        editor.putString("GIOITINH", gioitinh);
        editor.putString("DIACHI", diachi);
        editor.putString("LOAITAIKHOAN", loaitaikhoan);
        editor.putBoolean("REMEMBER", status);

        //Lưu lại
        editor.commit();
    }

    public int check() {
        SharedPreferences sharedPreferences = getSharedPreferences("NGUOI_DUNG", MODE_PRIVATE);
        boolean check = sharedPreferences.getBoolean("REMEMBER", false);
        if (check) {
            username = sharedPreferences.getString("USERNAME", "");
            return 1;
        } else return -1;
    }


    @Override
    public void onLayNguoiDungSuccess(List<NguoiDungDTO> list) {
        lsNguoiDung = list;


    }

    @Override
    public void onLayNguoiDungError(String error) {
        Toast.makeText(this, "Lấy dữ liệu thất bại!!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLayNguoiDungIDSuccess(List<NguoiDungDTO> list) {

    }

    @Override
    public void onLayNguoiDungIDError(String error) {

    }

    @Override
    public void onCapNhatNguoiDungSuccess() {
    }

    @Override
    public void onCapNhatNguoiDungError(String error) {
    }

    @Override
    public void onThemNguoiDungSuccess() {
    }

    @Override
    public void onThemNguoiDungError(String error) {
    }

    ////Mã hóa mật khẩu MD5
    public static String md5(String text) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(text.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte b : result) {
                int number = b & 0xff;
                String hex = Integer.toHexString(number);
                if (hex.length() == 1) {
                    sb.append("0" + hex);
                } else {
                    sb.append(hex);
                }
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}

