package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentChinhsuathongtincanhanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_chinhsuathongtincanhan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_chinhsuathongtincanhan extends Fragment implements NguoiDungContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private NguoiDungDTO nguoiDungDTO;
    private NguoiDungPresenter nguoiDungPresenter;
    FragmentChinhsuathongtincanhanBinding chinhsuathongtincanhanBinding;

    public fragment_chinhsuathongtincanhan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_chinhsuathongtincanhan.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_chinhsuathongtincanhan newInstance(String param1, String param2) {
        fragment_chinhsuathongtincanhan fragment = new fragment_chinhsuathongtincanhan();
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
        chinhsuathongtincanhanBinding=FragmentChinhsuathongtincanhanBinding.inflate(inflater,container,false);
        chinhsuathongtincanhanBinding.btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
////gán thông tin người dùng
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences("NGUOI_DUNG", Context.MODE_PRIVATE);

        chinhsuathongtincanhanBinding.tvTentkchinhsua.setText(sharedPreferences.getString("USERNAME",""));

        chinhsuathongtincanhanBinding.etSdtctchinhsua.setText(sharedPreferences.getString("SDT", ""));

        chinhsuathongtincanhanBinding.etQqchinhsua.setText(sharedPreferences.getString("DIACHI", ""));


        chinhsuathongtincanhanBinding.tvGtchinhsua.setText(sharedPreferences.getString("GIOITINH", ""));

        chinhsuathongtincanhanBinding.tvCccdchinhsua.setText(sharedPreferences.getString("CCCD", ""));

        chinhsuathongtincanhanBinding.tvCvchinhsua.setText(sharedPreferences.getString("LOAITAIKHOAN", ""));

        chinhsuathongtincanhanBinding.tvTenThongticanhan.setText(sharedPreferences.getString("TENNGUOIDUNG", ""));

        chinhsuathongtincanhanBinding.tvChucvuthongtincanhan.setText(sharedPreferences.getString("LOAITAIKHOAN", ""));


        nguoiDungPresenter = new NguoiDungPresenter(this);
        nguoiDungDTO = new NguoiDungDTO();
        chinhsuathongtincanhanBinding.btnLuuthongtincanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (chinhsuathongtincanhanBinding.etSdtctchinhsua.getText().length() == 10 &&
                        !(chinhsuathongtincanhanBinding.etQqchinhsua.getText().toString().equals(""))) {


                    ///lấy người dùng id
                    nguoiDungDTO.setNguoiDungId(sharedPreferences.getInt("ID", 0));
                    ///lưu sdt lại và csdl
                    nguoiDungDTO.setSdt(chinhsuathongtincanhanBinding.etSdtctchinhsua.getText().toString());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    // gán địa chỉ vào file NGUOI_DUNG tạm
                    editor.putString("SDT", chinhsuathongtincanhanBinding.etSdtctchinhsua.getText().toString());
                    editor.putString("DIACHI", chinhsuathongtincanhanBinding.etQqchinhsua.getText().toString());
                    editor.apply();
                    editor.commit();
                    ////lưu lại địa chỉ
                    nguoiDungDTO.setDiaChi(chinhsuathongtincanhanBinding.etQqchinhsua.getText().toString());
                    ///mật khẩu giữ nguyên
                    nguoiDungDTO.setMatKhau(sharedPreferences.getString("PASSWORD", ""));


                    nguoiDungPresenter.CapNhatNguoiDung(nguoiDungDTO);
                    Toast.makeText(getContext(), "Chỉnh sửa thông tin thành công", Toast.LENGTH_SHORT).show();
                    getActivity().onBackPressed();
                } else {
                    Toast.makeText(getContext(), "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return chinhsuathongtincanhanBinding.getRoot();
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
}