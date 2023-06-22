package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.KhachHangAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentKhachHangBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;

import java.util.ArrayList;
import java.util.List;


public class FragmentKhachHang extends Fragment implements KhachHangContract.View {
    private List<KhachHangDTO> lsKhachHang;
    private FragmentKhachHangBinding fragmentKhachHangBinding;
    private KhachHangAdapter khachHangAdapter;
    private RecyclerView rscvPhieuDatBan;
    private SearchView searchView;
    private List<KhachHangDTO> searchList;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public FragmentKhachHang() {
    }


    public static FragmentKhachHang newInstance(String param1, String param2) {
        FragmentKhachHang fragment = new FragmentKhachHang();
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
        fragmentKhachHangBinding = fragmentKhachHangBinding.inflate(inflater, container, false);
        searchView = fragmentKhachHangBinding.Search;
        rscvPhieuDatBan = fragmentKhachHangBinding.rscvDsphieudatban;
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuDatBan.setLayoutManager(LinearLayoutManager);
        ///lấy khách hàng
        lsKhachHang = new ArrayList<>();
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();
                if (newText.length()>0){
                    for (int i=0;i<lsKhachHang.size();i++){
                        if (lsKhachHang.get(i).getTenKhachHang().contains(newText)||lsKhachHang.get(i).getSdt().contains(newText)){
                            KhachHangDTO khachHangDTO = lsKhachHang.get(i);
                            searchList.add(khachHangDTO);
                        }
                    }
                    khachHangAdapter = new KhachHangAdapter(FragmentKhachHang.this);
                    khachHangAdapter.setData(getContext(), searchList);
                    rscvPhieuDatBan.setAdapter(khachHangAdapter);
                    //Toast.makeText(getContext(), String.valueOf(lsKhachHang.size()), Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

        return fragmentKhachHangBinding.getRoot();
    }


    @Override
    public void onThemKhachHangSuccess() {

    }

    @Override
    public void onThemKhachHangError(String error) {

    }

    @Override
    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {
        lsKhachHang = list;
        khachHangAdapter = new KhachHangAdapter(this);
        khachHangAdapter.setData(getContext(), lsKhachHang);
        rscvPhieuDatBan.setAdapter(khachHangAdapter);
        //Toast.makeText(getContext(), String.valueOf(lsKhachHang.size()), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {

    }
}