package com.example.datnandroidquanlynhahangkhachsan;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChiTietNhanVienBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungPresenter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Activity_ChiTiet_NhanVien extends AppCompatActivity implements NguoiDungContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChiTietNhanVienBinding chiTietNhanVienBinding = ActivityChiTietNhanVienBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("TT_NHANVIEN", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        chiTietNhanVienBinding.cv.setText(sharedPreferences.getString("CV", ""));
        chiTietNhanVienBinding.tvTendata.setText(sharedPreferences.getString("TEN", ""));
        chiTietNhanVienBinding.tvCcdata.setText(sharedPreferences.getString("GT", ""));
        chiTietNhanVienBinding.tvSodtdata.setText(sharedPreferences.getString("SDT", ""));
        chiTietNhanVienBinding.tvGtdata.setText(sharedPreferences.getString("CCCD", ""));
        chiTietNhanVienBinding.etTktt.setText(sharedPreferences.getString("TK", ""));

        chiTietNhanVienBinding.tvQqdata.setText(sharedPreferences.getString("DC", ""));
        chiTietNhanVienBinding.toolbarTk.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                onBackPressed();
            }
        });

        if (sharedPreferences.getString("CV","").equals("Quản lý"))
        {
            chiTietNhanVienBinding.btnReset.setEnabled(false);
            chiTietNhanVienBinding.btnReset.setBackgroundColor(Color.GRAY);
        }


        NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
        NguoiDungPresenter nguoiDungPresenter = new NguoiDungPresenter(this);
        final Dialog dialog = new Dialog(this);
        chiTietNhanVienBinding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setContentView(R.layout.fragment_dialog_dang_xuat);
                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }
                TextView btnYes = dialog.findViewById(R.id.btn_yes);
                TextView btnNo = dialog.findViewById(R.id.btn_no);
                TextView text = dialog.findViewById(R.id.tv_dangxuat);
                text.setText("Đặt lại tài khoản cho nhân viên");
                btnNo.setText("Đóng");
                btnYes.setText("Đặt lại");
                window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nguoiDungDTO.setNguoiDungId(sharedPreferences.getInt("ID", 0));
                        nguoiDungDTO.setCccd(sharedPreferences.getString("CCCD", ""));
                        nguoiDungDTO.setDiaChi(sharedPreferences.getString("DC", ""));
                        nguoiDungDTO.setSdt(sharedPreferences.getString("SDT", ""));
                        nguoiDungDTO.setMatKhau(md5("12345678"));
                        nguoiDungDTO.setGioiTinh(sharedPreferences.getString("GT", ""));

                        nguoiDungPresenter.CapNhatNguoiDung(nguoiDungDTO);
                        dialog.dismiss();
                        onBackPressed();
                        Toast.makeText(Activity_ChiTiet_NhanVien.this, "Hãy yêu cầu nhân viên cập nhật lại mật khẩu mới", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });


        setContentView(chiTietNhanVienBinding.getRoot());
    }

    /// lấy danh sách người dùng
    @Override
    public void onLayNguoiDungSuccess(List<NguoiDungDTO> lsNguoiDung) {
    }

    @Override
    public void onLayNguoiDungError(String error) {
    }

    /// lấy người dùng theo id
    @Override
    public void onLayNguoiDungIDSuccess(List<NguoiDungDTO> lsNguoiDungID) {
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