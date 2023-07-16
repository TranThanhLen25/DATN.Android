package com.example.datnandroidquanlynhahangkhachsan;

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
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ThemNhanVien_Activity extends AppCompatActivity implements NguoiDungContract.View {

    private List<NguoiDungDTO> nguoiDungDTO;

    private String sdt;
    private String diachi;
    private String gioitinh;
    private AppUtils appUtils;

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

        nhanVienBinding.etHotenNhanVien.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String tvHT = String.valueOf(nhanVienBinding.etHotenNhanVien.getText());
                if (b) {

                } else {
                    if (tvHT.length()<5) {
                        nhanVienBinding.inputlayoutHotenNhanVien.setError("Vui lòng nhập đầy đủ họ và tên");
                        nhanVienBinding.inputlayoutHotenNhanVien.setHelperText("");
                    } else {
                        nhanVienBinding.inputlayoutHotenNhanVien.setError("");
                        nhanVienBinding.inputlayoutHotenNhanVien.setHelperText("");
                    }
                }
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
                        nhanVienBinding.inputlayoutCccdNhanVien.setError("Vui lòng nhập đầy đủ ký tự cccd( cccd= 12)");
                        nhanVienBinding.inputlayoutCccdNhanVien.setHelperText("");
                    } else {
                        nhanVienBinding.inputlayoutCccdNhanVien.setError("");
                        nhanVienBinding.inputlayoutCccdNhanVien.setHelperText("");
                    }
                }
            }
        });

        nhanVienBinding.etSdtNhanVien.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    nhanVienBinding.inputlayoutSdtNhanVien.setError("");
                } else {
                    nhanVienBinding.inputlayoutSdtNhanVien.setHelperText("");
                    nhanVienBinding.inputlayoutSdtNhanVien.setError("Vui lòng nhập số điện thoại");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        nhanVienBinding.etSdtNhanVien.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String tvTK = String.valueOf(nhanVienBinding.etSdtNhanVien.getText());
                if (b) {

                } else {
                    if (tvTK.length() < 10) {
                        nhanVienBinding.inputlayoutSdtNhanVien.setError("Vui lòng nhập đầy đủ số điện thoại( sdt= 10)");
                        nhanVienBinding.inputlayoutSdtNhanVien.setHelperText("");
                    } else {
                        nhanVienBinding.inputlayoutSdtNhanVien.setError("");
                        nhanVienBinding.inputlayoutSdtNhanVien.setHelperText("");
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
                if (input.length() <7||appUtils.ktnhap(input)) {
                    nhanVienBinding.inputlayoutTkNhanVien.setHelperText("");
                    nhanVienBinding.inputlayoutTkNhanVien.setError("Vui lòng nhập đúng định dạng( A-Z, a-z,0-9, trên 7 ký tự)");
                } else {
                    nhanVienBinding.inputlayoutTkNhanVien.setError("");

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
                    if (tvTK.length() < 8||appUtils.ktnhap(tvTK)) {
                        nhanVienBinding.inputlayoutTkNhanVien.setError("Vui lòng nhập đúng định dạng( A-Z, a-z,0-9, trên 7 ký tự)");
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
                if (input.length() <8||appUtils.ktnhap(input)) {
                    nhanVienBinding.inputlayoutMkNhanVien.setHelperText("");
                    nhanVienBinding.inputlayoutMkNhanVien.setError("Vui lòng nhập đúng định dạng( A-Z, a-z,0-9, trên 7 ký tự)");


                } else {
                    nhanVienBinding.inputlayoutMkNhanVien.setError("");
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
                    if (tvTK.length() < 8||appUtils.ktnhap(tvTK)) {
                        nhanVienBinding.inputlayoutMkNhanVien.setError("Vui lòng nhập đúng định dạng( A-Z, a-z,0-9, trên 7 ký tự)");
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
                    if(nhanVienBinding.etSdtNhanVien.getText().toString().equals(nguoiDungDTO.get(i).getSdt()))
                    {
                        nhanVienBinding.inputlayoutSdtNhanVien.setError("Số điện thoại đã tồn tại");
                    }
                    if(
                       nhanVienBinding.etHotenNhanVien.getText().length()>5
                    && nhanVienBinding.etCccdNhanVien.getText().length()==12
                    && nhanVienBinding.etSdtNhanVien.getText().length()==10
                    && nhanVienBinding.etTkNhanVien.getText().length()>7
                    && nhanVienBinding.etMkNhanVien.getText().length()>7
                               //kiểm trả TK,Mk có khoản trống k
                    && (!(appUtils.ktnhap(String.valueOf(nhanVienBinding.etTkNhanVien.getText()))))
                    && (!(appUtils.ktnhap(String.valueOf(nhanVienBinding.etMkNhanVien.getText()))))

                    && !nhanVienBinding.etCccdNhanVien.getText().toString().equals(nguoiDungDTO.get(i).getCccd())
                    && !nhanVienBinding.etSdtNhanVien.getText().toString().equals(nguoiDungDTO.get(i).getSdt())
                    && !nhanVienBinding.etTkNhanVien.getText().toString().equals(nguoiDungDTO.get(i).getTaiKhoan()))
                    {
                        dem++;
                    }
                }
                if(dem==nguoiDungDTO.size())
                {
                    NguoiDungDTO nguoiDung = new NguoiDungDTO(
                            nhanVienBinding.etHotenNhanVien.getText().toString()
                            ,nhanVienBinding.etSdtNhanVien.getText().toString()
                            , nhanVienBinding.etCccdNhanVien.getText().toString()
                            , gioitinh
                            , diachi
                            , "Nhân viên lễ tân"
                            , nhanVienBinding.etTkNhanVien.getText().toString()
                            , md5(nhanVienBinding.etMkNhanVien.getText().toString())
                            , 1);

                    nguoiDungPresenter.ThemNguoiDung(nguoiDung);
                    Toast.makeText(ThemNhanVien_Activity.this, "Thêm tài khoản thành công", Toast.LENGTH_SHORT).show();
                   onBackPressed();

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