package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.datnandroidquanlynhahangkhachsan.adapter.DsPhongAdapter;

import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDsPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.model.Phong;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_dsPhong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dsPhong extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rscvDsPhong;
    private List<Phong> lsPhong;
    private DsPhongAdapter dsPhongAdapter;
private FragmentDsPhongBinding fragmentDsPhongBinding;


    public Fragment_dsPhong() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_dsPhong.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_dsPhong newInstance(String param1, String param2) {
        Fragment_dsPhong fragment = new Fragment_dsPhong();
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
        fragmentDsPhongBinding = FragmentDsPhongBinding.inflate(inflater,container,false);

        lsPhong = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Phong pn = new Phong(11,100+i, 300000);
            lsPhong.add(pn);
        }

        fragmentDsPhongBinding.iclAppback.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });




        rscvDsPhong=fragmentDsPhongBinding.rscvDsphong;
        dsPhongAdapter = new DsPhongAdapter(lsPhong,getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 3);
        rscvDsPhong.setLayoutManager(gridLayoutManager);
        rscvDsPhong.setAdapter(dsPhongAdapter);
        return fragmentDsPhongBinding.getRoot();
    }
}
