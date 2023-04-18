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
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class DangNhapActivity extends AppCompatActivity implements NguoiDungContract.View {

    private List<NguoiDungDTO> lsNguoiDung;
    private NguoiDungPresenter nguoiDungPresenter;
    private ActivityDangNhapBinding dangNhapBinding;
    private String LuuThongTin = "taikhoan and matkhau";
    private Boolean save = false;
    String username="";
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
                if (input.length() > 0) {
                    dangNhapBinding.titleTk.setError("");
                } else {
                    dangNhapBinding.titleTk.setHelperText("");
                    dangNhapBinding.titleTk.setError("Vui lòng nhập tài khoản");
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
                    if (tvTK.length() < 8) {
                        dangNhapBinding.titleTk.setError("Vui lòng nhập đủ tên tài khoản");
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
                if (input.length() > 0) {
                    dangNhapBinding.titleMk.setError("");
                } else {
                    dangNhapBinding.titleMk.setError("Vui lòng nhập mật khẩu");
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
                    if (tvMK.length() < 8) {
                        dangNhapBinding.titleMk.setError("Vui lòng nhập đủ ký tự");
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
                for (int i = 0; i < lsNguoiDung.size(); i++) {
                    if (dangNhapBinding.etTaikhoan.getText().toString().equals(lsNguoiDung.get(i).getTaiKhoan())
                            && dangNhapBinding.etMatkhau.getText().toString().equals(lsNguoiDung.get(i).getMatKhau())) {
                        Intent intent = new Intent(DangNhapActivity.this, Toolbar_Drawer_Activity.class);
                        startActivity(intent);
                        rememberUser(dangNhapBinding.etTaikhoan.getText().toString(), dangNhapBinding.etMatkhau.getText().toString(), true);
                        save = true;

                    }
                }
                if (save == false)
                    Toast.makeText(DangNhapActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
            }
        });


       if (check()==1){
           Intent intent = new Intent(DangNhapActivity.this, Toolbar_Drawer_Activity.class);
           startActivity(intent);
       }
        setContentView(dangNhapBinding.getRoot());


    }

    public void rememberUser(String username, String password, boolean status) {
        SharedPreferences sharedPreferences = getSharedPreferences("NGUOI_DUNG", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        ///Thêm dữ liệu vào file
        editor.putString("USERNAME", username);
        editor.putString("PASSWORD", password);
        editor.putBoolean("REMEMBER", status);
        Toast.makeText(DangNhapActivity.this, "luu usernam va pas", Toast.LENGTH_LONG).show();
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

        Toast.makeText(this, "lay du lieu thanh cong", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onLayNguoiDungError(String error) {
        Toast.makeText(this, "Lay du lieu that bai", Toast.LENGTH_LONG).show();
    }
}