package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemNhanVienBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungPresenter;

import java.util.ArrayList;
import java.util.List;

public class ThemNhanVien_Activity extends AppCompatActivity implements NguoiDungContract.View {

    private List<NguoiDungDTO> nguoiDungDTO;

    private String sdt;
    private String diachi;
    private String gioitinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityThemNhanVienBinding nhanVienBinding = ActivityThemNhanVienBinding.inflate(getLayoutInflater());
        nhanVienBinding.toolbarNhanVien.icBack.setOnClickListener(view -> onBackPressed());

        nhanVienBinding.etHotenNhanVien.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    nhanVienBinding.inputlayoutHotenNhanVien.setError("");
                } else {
                    nhanVienBinding.inputlayoutHotenNhanVien.setHelperText("");
                    nhanVienBinding.inputlayoutHotenNhanVien.setError("Vui lòng nhập đầy đủ họ và tên");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nhanVienBinding.etCccdNhanVien.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    nhanVienBinding.inputlayoutCccdNhanVien.setError("");
                } else {
                    nhanVienBinding.inputlayoutCccdNhanVien.setHelperText("");
                    nhanVienBinding.inputlayoutCccdNhanVien.setError("Vui lòng nhập số CCCD");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nhanVienBinding.etCccdNhanVien.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String tvTK = String.valueOf(nhanVienBinding.etCccdNhanVien.getText());
                if (b) {

                } else {
                    if (tvTK.length() < 12) {
                        nhanVienBinding.inputlayoutCccdNhanVien.setError("Vui lòng nhập đầy đủ ký tự cccd(=12)");
                        nhanVienBinding.inputlayoutCccdNhanVien.setHelperText("");
                    } else {
                        nhanVienBinding.inputlayoutCccdNhanVien.setError("");
                        nhanVienBinding.inputlayoutCccdNhanVien.setHelperText("");
                    }
                }
            }
        });
        nhanVienBinding.etTkNhanVien.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    nhanVienBinding.inputlayoutTkNhanVien.setError("");
                } else {
                    nhanVienBinding.inputlayoutTkNhanVien.setHelperText("");
                    nhanVienBinding.inputlayoutTkNhanVien.setError("Vui lòng thêm tên tài khoản để tạo mới");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nhanVienBinding.etTkNhanVien.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String tvTK = String.valueOf(nhanVienBinding.etTkNhanVien.getText());
                if (b) {

                } else {
                    if (tvTK.length() < 8) {
                        nhanVienBinding.inputlayoutTkNhanVien.setError("Vui lòng nhập đầy đủ ký tự( TK >=8) ");
                        nhanVienBinding.inputlayoutTkNhanVien.setHelperText("");
                    } else {
                        nhanVienBinding.inputlayoutTkNhanVien.setError("");
                        nhanVienBinding.inputlayoutTkNhanVien.setHelperText("");
                    }
                }
            }
        });


        nhanVienBinding.etMkNhanVien.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    nhanVienBinding.inputlayoutMkNhanVien.setError("");
                } else {
                    nhanVienBinding.inputlayoutMkNhanVien.setHelperText("");
                    nhanVienBinding.inputlayoutMkNhanVien.setError("Vui lòng nhập mật khẩu cho tài khoản(MK >=8)");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nhanVienBinding.etMkNhanVien.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String tvTK = String.valueOf(nhanVienBinding.etMkNhanVien.getText());
                if (b) {

                } else {
                    if (tvTK.length() < 8) {
                        nhanVienBinding.inputlayoutMkNhanVien.setError("Vui lòng nhập đầy đủ ký tự (>=8)");
                        nhanVienBinding.inputlayoutMkNhanVien.setHelperText("");
                    } else {
                        nhanVienBinding.inputlayoutMkNhanVien.setError("");
                        nhanVienBinding.inputlayoutMkNhanVien.setHelperText("");
                    }
                }
            }
        });


        nguoiDungDTO = new ArrayList<>();
        NguoiDungPresenter nguoiDungPresenter = new NguoiDungPresenter(this);
        nguoiDungPresenter.LayNguoiDung();


        nhanVienBinding.btnThemnhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nhanVienBinding.etSdtNhanVien.getText().length() == 10)
                {
                    sdt = nhanVienBinding.etSdtNhanVien.getText().toString();
                } else
                {
                    sdt = "Chưa có số điện thoại";
                }
                if (nhanVienBinding.etQqNhanVien.getText().length() > 0)
                {
                    diachi = nhanVienBinding.etQqNhanVien.getText().toString();
                } else
                {
                    diachi = "Chưa có địa chỉ";
                }

                if (nhanVienBinding.nam.isChecked() == true)
                {
                    gioitinh = "Nam";
                }
                else if (nhanVienBinding.nu.isChecked() == true)
                {
                    gioitinh = "Nữ";
                }
                else
                {
                    gioitinh = "Khác";
                }
                int dem=0;
                for (int i=0;i<nguoiDungDTO.size();i++)
                {
                    if(nhanVienBinding.etCccdNhanVien.getText().toString().equals(nguoiDungDTO.get(i).getCccd()))
                    {
                        nhanVienBinding.inputlayoutCccdNhanVien.setError("Căn Cước công dân đã tồn tại");
                    }
                    if(nhanVienBinding.etTkNhanVien.getText().toString().equals(nguoiDungDTO.get(i).getTaiKhoan()))
                    {
                        nhanVienBinding.inputlayoutTkNhanVien.setError("Tài khoản đã tồn tại");
                    }
                    if(
                       nhanVienBinding.etHotenNhanVien.getText().length()>5
                    && nhanVienBinding.etCccdNhanVien.getText().length()==12
                    && nhanVienBinding.etTkNhanVien.getText().length()>7
                    && nhanVienBinding.etMkNhanVien.getText().length()>7
                    && !nhanVienBinding.etCccdNhanVien.getText().toString().equals(nguoiDungDTO.get(i).getCccd())
                    && !nhanVienBinding.etTkNhanVien.getText().toString().equals(nguoiDungDTO.get(i).getTaiKhoan()))
                    {
                        dem++;
                    }
                }
                if(dem==nguoiDungDTO.size())
                {
                    NguoiDungDTO nguoiDung = new NguoiDungDTO(
                            nhanVienBinding.etHotenNhanVien.getText().toString()
                            ,sdt
                            , nhanVienBinding.etCccdNhanVien.getText().toString()
                            , gioitinh
                            , diachi
                            , "Nhân viên lễ tân"
                            , nhanVienBinding.etTkNhanVien.getText().toString()
                            , nhanVienBinding.etMkNhanVien.getText().toString(), 1);

                    nguoiDungPresenter.ThemNguoiDung(nguoiDung);
                   onBackPressed();
                    Toast.makeText(ThemNhanVien_Activity.this, "Thêm tài khoản thành công", Toast.LENGTH_SHORT).show();
                }



            }
        });

        setContentView(nhanVienBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        nguoiDungDTO = new ArrayList<>();
    }

    /// lấy danh sách người dùng
    @Override
    public void onLayNguoiDungSuccess(List<NguoiDungDTO> lsNguoiDung) {
        nguoiDungDTO = lsNguoiDung;

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
}