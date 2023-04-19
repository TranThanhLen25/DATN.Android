package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentThongtincanhanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_thongtincanhan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_thongtincanhan extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private NguoiDungPresenter nguoiDungPresenter;
    private List<NguoiDungDTO> lsNguoiDung;
    FragmentThongtincanhanBinding thongtincanhanBinding;


    private Fragment fragment;

    public Fragment_thongtincanhan() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_thongtincanhan.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_thongtincanhan newInstance(String param1, String param2) {
        Fragment_thongtincanhan fragment = new Fragment_thongtincanhan();
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

        thongtincanhanBinding = FragmentThongtincanhanBinding.inflate(inflater, container, false);
//// lấy thông tin người dùng trong file tạm để hiển thị ra
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("NGUOI_DUNG", Context.MODE_PRIVATE);

        thongtincanhanBinding.tvTentk.setText(sharedPreferences.getString("USERNAME", ""));

        thongtincanhanBinding.tvSdtnumber.setText(sharedPreferences.getString("SDT", ""));

        thongtincanhanBinding.tvQq.setText(sharedPreferences.getString("DIACHI", ""));

        thongtincanhanBinding.tvGt.setText(sharedPreferences.getString("GIOITINH", ""));

        thongtincanhanBinding.tvCccd.setText(sharedPreferences.getString("CCCD", ""));

        thongtincanhanBinding.tvCv.setText(sharedPreferences.getString("LOAITAIKHOAN", ""));

        thongtincanhanBinding.tvTenThongticanhan.setText(sharedPreferences.getString("TENNGUOIDUNG",""));
        thongtincanhanBinding.tvChucvutren.setText(sharedPreferences.getString("LOAITAIKHOAN", ""));

        thongtincanhanBinding.btnSuathongtincanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new fragment_chinhsuathongtincanhan();
                replaceFragment(fragment);
            }
        });

        return thongtincanhanBinding.getRoot();
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fra_draw, someFragment); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }


}