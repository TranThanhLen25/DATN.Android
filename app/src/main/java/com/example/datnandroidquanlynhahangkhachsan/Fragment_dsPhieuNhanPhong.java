package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuNhanPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDsPhieuNhanPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuNhan;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuNhan;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuDatphongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuNhanPhongActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_dsPhieuNhanPhong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dsPhieuNhanPhong extends Fragment {

    private RecyclerView rscvPhieuNhanPhong;
    private List<PhieuNhan> lsPhieuNhan;
    private PhieuNhanPhongAdapter phieuNhanPhongAdapter;
    private FragmentDsPhieuNhanPhongBinding fragmentDsPhieuNhanPhongBinding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_dsPhieuNhanPhong() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_dsPhieuNhanPhong.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_dsPhieuNhanPhong newInstance(String param1, String param2) {
        Fragment_dsPhieuNhanPhong fragment = new Fragment_dsPhieuNhanPhong();
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
        super.onCreate(savedInstanceState);
        fragmentDsPhieuNhanPhongBinding = fragmentDsPhieuNhanPhongBinding.inflate(inflater, container, false);
        fragmentDsPhieuNhanPhongBinding.iclAppbackpnp.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        fragmentDsPhieuNhanPhongBinding.flBtnThemphieunhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ThemPhieuNhanPhongActivity.class);
                startActivity(intent);
            }
        });
        rscvPhieuNhanPhong = fragmentDsPhieuNhanPhongBinding.rscvDsphieunhanphong;
        lsPhieuNhan = new ArrayList<>();
        Date day = Calendar.getInstance().getTime();
        for (int i = 0; i < 10; i++) {
            PhieuNhan pn = new PhieuNhan(1L, "PN" + (i + 1), day, 1, 1, day, (i + 1L), "abc", "Đã nhận");
            lsPhieuNhan.add(pn);
        }
        phieuNhanPhongAdapter = new PhieuNhanPhongAdapter(lsPhieuNhan);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuNhanPhong.setLayoutManager(LinearLayoutManager);
        rscvPhieuNhanPhong.setAdapter(phieuNhanPhongAdapter);
        return fragmentDsPhieuNhanPhongBinding.getRoot();
    }
}