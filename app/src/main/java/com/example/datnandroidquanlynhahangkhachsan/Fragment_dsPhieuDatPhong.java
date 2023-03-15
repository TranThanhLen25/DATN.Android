package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuDatPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuDat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_dsPhieuDatPhong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dsPhieuDatPhong extends Fragment {
    private RecyclerView rscvPhieuDatPhong;
    private List<PhieuDat> lsPhieuDat;
    private PhieuDatPhongAdapter phieuDatPhongAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_dsPhieuDatPhong() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_dsPhieuDatPhong.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_dsPhieuDatPhong newInstance(String param1, String param2) {
        Fragment_dsPhieuDatPhong fragment = new Fragment_dsPhieuDatPhong();
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
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_ds_phieu_dat_phong, container, false);
        rscvPhieuDatPhong = view.findViewById(R.id.rscv_dsphieudatphong);
        lsPhieuDat = new ArrayList<>();
        //Timestamp day=new Timestamp(2000-1900,10-1,04,12,12,12,0);

        Date day =  Calendar.getInstance().getTime();

        PhieuDat pd1 = new PhieuDat(1L,  "1",  day, 1,1, day, day, "abc", 101L, "Đang đặt");
        PhieuDat pd2 = new PhieuDat(2L,  "2",  day, 2,1, day, day, "abc", 101L, "Đang đặt");
        lsPhieuDat.add(pd1);
        lsPhieuDat.add(pd2);
        phieuDatPhongAdapter = new PhieuDatPhongAdapter(lsPhieuDat);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuDatPhong.setLayoutManager(LinearLayoutManager);
//        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this.getActivity(), DividerItemDecoration.VERTICAL);
//        rscvPhieuDatPhong.addItemDecoration(decoration);
        rscvPhieuDatPhong.setAdapter(phieuDatPhongAdapter);
        return view;
    }
}