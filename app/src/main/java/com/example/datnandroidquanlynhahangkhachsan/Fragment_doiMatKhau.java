package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDoiMatKhauBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungPresenter;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_doiMatKhau#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_doiMatKhau extends Fragment implements NguoiDungContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private NguoiDungPresenter nguoiDungPresenter;
    private NguoiDungDTO nguoiDungDTO;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private AppUtils appUtils;

    public Fragment_doiMatKhau() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_doiMatKhau.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_doiMatKhau newInstance(String param1, String param2) {
        Fragment_doiMatKhau fragment = new Fragment_doiMatKhau();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentDoiMatKhauBinding doiMatKhauBinding = FragmentDoiMatKhauBinding.inflate(inflater, container, false);
        doiMatKhauBinding.etMkc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    doiMatKhauBinding.tipMkc.setError("");
                } else {
                    doiMatKhauBinding.tipMkc.setError("Vui lòng nhập mật khẩu củ");
                    doiMatKhauBinding.tipMkc.setHelperText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        doiMatKhauBinding.etMkm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    doiMatKhauBinding.tipMkm.setError("");
                } else {
                    doiMatKhauBinding.tipMkm.setError("Vui lòng nhập mật khẩu mới");
                    doiMatKhauBinding.tipMkm.setHelperText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        doiMatKhauBinding.etNl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString();
                if (input.length() > 0) {
                    doiMatKhauBinding.tipNl.setError("");
                } else {
                    doiMatKhauBinding.tipNl.setError("Vui lòng nhập lại mật khẩu mới");
                    doiMatKhauBinding.tipNl.setHelperText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        doiMatKhauBinding.etMkm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String mkm = String.valueOf(doiMatKhauBinding.etMkm.getText());
                if (b) {

                } else {
                    if (mkm.length() < 8) {
                        doiMatKhauBinding.tipMkm.setError("Vui lòng nhập đủ ký tự");
                        doiMatKhauBinding.tipMkm.setHelperText("");
                    } else {
                        doiMatKhauBinding.tipMkm.setError("");
                        doiMatKhauBinding.tipMkm.setHelperText("");
                    }
                }
            }
        });
        doiMatKhauBinding.etNl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String nl = String.valueOf(doiMatKhauBinding.etNl.getText());
                if (nl.length() < 8) {
                    doiMatKhauBinding.tipNl.setError("Vui lòng nhập đủ ký tự");
                    doiMatKhauBinding.tipNl.setHelperText("");
                } else {
                    doiMatKhauBinding.tipNl.setError("");
                    doiMatKhauBinding.tipNl.setHelperText("");
                }
            }
        });

        nguoiDungPresenter = new NguoiDungPresenter(this);
        nguoiDungDTO = new NguoiDungDTO();
        sharedPreferences = getActivity().getSharedPreferences("NGUOI_DUNG", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String a = sharedPreferences.getString("PASSWORD", "");
doiMatKhauBinding.btnThoat.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        getActivity().onBackPressed();
    }
});
        doiMatKhauBinding.btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((doiMatKhauBinding.etMkc.getText().toString().equals(a)) &&
                        (doiMatKhauBinding.etMkm.length() >= 8 && doiMatKhauBinding.etNl.length() >= 8) &&
                        (doiMatKhauBinding.etMkm.getText().toString().equals(doiMatKhauBinding.etNl.getText().toString())) &&
                        (!(doiMatKhauBinding.etMkm.getText().toString().equals(doiMatKhauBinding.etMkc.getText().toString())))) {
                    editor.putString("PASSWORD", doiMatKhauBinding.etMkm.getText().toString());
                    editor.apply();
                    editor.commit();
                    nguoiDungDTO.setNguoiDungId(sharedPreferences.getInt("ID", 0));
                    nguoiDungDTO.setMatKhau(doiMatKhauBinding.etMkm.getText().toString());
                    nguoiDungDTO.setSdt(sharedPreferences.getString("SDT", ""));
                    nguoiDungDTO.setCccd(sharedPreferences.getString("CCCD", ""));
                    nguoiDungDTO.setDiaChi(sharedPreferences.getString("DIACHI", ""));
                    nguoiDungPresenter.CapNhatNguoiDung(nguoiDungDTO);

                                      Toast.makeText(getContext(), "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();

                    getActivity().onBackPressed();
                } else {
                    if (!doiMatKhauBinding.etMkc.getText().toString().equals(a)) {
                        Toast.makeText(getContext(), "Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
                    }
                    if (!(doiMatKhauBinding.etMkm.getText().toString().equals(doiMatKhauBinding.etNl.getText().toString()))) {
                        Toast.makeText(getContext(), "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
                    }

                    if (doiMatKhauBinding.etMkm.getText().toString().equals(doiMatKhauBinding.etMkc.getText().toString())) {
                        Toast.makeText(getContext(), "Mật khẩu đã tồn tại", Toast.LENGTH_SHORT).show();
                    }
                    if (doiMatKhauBinding.etMkm.length() < 8 || doiMatKhauBinding.etNl.length() <= 8) {
                        Toast.makeText(getContext(), "Vui lòng nhập đủ ký tự", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });

        return doiMatKhauBinding.getRoot();
    }

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
    public void onThemNguoiDungSuccess(){}

    @Override
    public void onThemNguoiDungError(String error){}
}