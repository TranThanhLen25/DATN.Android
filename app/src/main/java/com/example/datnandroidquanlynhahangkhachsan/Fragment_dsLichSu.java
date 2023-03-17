package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_dsLichSu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dsLichSu extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Fragment fragment = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_dsLichSu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_dsLichSu.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_dsLichSu newInstance(String param1, String param2) {
        Fragment_dsLichSu fragment = new Fragment_dsLichSu();
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test:
                fragment = new fragment_menu();
                replaceFragment(fragment);
                break;
            default:
                fragment = new Fragment_dsPhieuNhanPhong();
                replaceFragment(fragment);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ds_lich_su, container, false);
        Button btnthemphieudatphong = (Button) view.findViewById(R.id.btn_test);
        btnthemphieudatphong.setOnClickListener(this);
        return view;
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, someFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}