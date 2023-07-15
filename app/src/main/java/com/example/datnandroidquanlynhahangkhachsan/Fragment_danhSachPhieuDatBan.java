package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuDatBanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDanhSachPhieuDatBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Fragment_danhSachPhieuDatBan extends Fragment implements DsPhieuDatPhongContract.View, KhachHangContract.View {

    private FragmentDanhSachPhieuDatBanBinding fragmentDanhSachPhieuDatBanBinding;
    DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO;
    private RecyclerView rscvPhieuDatBan;
    private List<KhachHangDTO> lsKhachHang;
    private List<PhieuDatDTO> lsPhieuDat;
    private PhieuDatBanAdapter phieuDatBanAdapter;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter;

    private SearchView searchView;

    private List<PhieuDatDTO> searchList;

    private List<KhachHangDTO> searchListKhachHang;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public Fragment_danhSachPhieuDatBan() {

    }


    public static Fragment_danhSachPhieuDatBan newInstance(String param1, String param2) {
        Fragment_danhSachPhieuDatBan fragment = new Fragment_danhSachPhieuDatBan();
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
        fragmentDanhSachPhieuDatBanBinding = fragmentDanhSachPhieuDatBanBinding.inflate(inflater, container, false);
        fragmentDanhSachPhieuDatBanBinding.iclAppbackpdp.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        fragmentDanhSachPhieuDatBanBinding.flBtnThemphieudat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempData.Check = false;
                tempData.CheckChucNang = true;
                Intent intent = new Intent(getActivity(), activity_them_phieu_dat_ban.class);
                startActivity(intent);
            }
        });

        ///lấy khách hàng
        lsKhachHang = new ArrayList<>();
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);

        rscvPhieuDatBan = fragmentDanhSachPhieuDatBanBinding.rscvDsphieudatban;
        lsPhieuDat = new ArrayList<>();
        Date day = Calendar.getInstance().getTime();
        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
        dieuKienLocPhieuDatDTO = new DieuKienLocPhieuDatDTO();
        dieuKienLocPhieuDatDTO.setLoaiPhieu(2);
        dieuKienLocPhieuDatDTO.setTrangThai("đang đặt");
        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuDatBan.setLayoutManager(LinearLayoutManager);


        searchView = fragmentDanhSachPhieuDatBanBinding.Search;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();
                searchListKhachHang = new ArrayList<>();
                if (newText.length() > 0) {
                    for (int i = 0; i < lsKhachHang.size(); i++) {
                        if (lsKhachHang.get(i).getTenKhachHang().contains(newText) || lsKhachHang.get(i).getSdt().contains(newText)) {
                            searchListKhachHang.add(lsKhachHang.get(i));
                        }
                    }
                    for (int j = 0; j < searchListKhachHang.size(); j++) {
                        for (int i = 0; i < lsPhieuDat.size(); i++) {
                            if (searchListKhachHang.get(j).getKhachHangId()==lsPhieuDat.get(i).getKhachHangID()){
                                searchList.add(lsPhieuDat.get(i));
                            }
                        }
                    }


                    phieuDatBanAdapter = new PhieuDatBanAdapter(Fragment_danhSachPhieuDatBan.this);
                    phieuDatBanAdapter.setData(getContext(), searchList, lsKhachHang);
                    rscvPhieuDatBan.setAdapter(phieuDatBanAdapter);
                    //Toast.makeText(getContext(), String.valueOf(lsKhachHang.size()), Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });


        return fragmentDanhSachPhieuDatBanBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        ///lấy khách hàng
        lsKhachHang = new ArrayList<>();
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);

        rscvPhieuDatBan = fragmentDanhSachPhieuDatBanBinding.rscvDsphieudatban;
        lsPhieuDat = new ArrayList<>();
        Date day = Calendar.getInstance().getTime();
        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
        dieuKienLocPhieuDatDTO = new DieuKienLocPhieuDatDTO();
        dieuKienLocPhieuDatDTO.setLoaiPhieu(2);
        dieuKienLocPhieuDatDTO.setTrangThai("đang đặt");
        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuDatBan.setLayoutManager(LinearLayoutManager);
    }

    @Override
    public void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list) {
        lsPhieuDat = list;
        // Đảo ngược thứ tự của tập dữ liệu
        Collections.reverse(lsPhieuDat);
        phieuDatBanAdapter = new PhieuDatBanAdapter(this);
        phieuDatBanAdapter.setData(getContext(), lsPhieuDat, lsKhachHang);
        rscvPhieuDatBan.setAdapter(phieuDatBanAdapter);
        //Toast.makeText(getContext(), "Lấy danh sách phiếu đặt phòng thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLayDanhSachPhieuDatError(String error) {

    }

    @Override
    public void onThemPhieuDatPhongSuccess() {

    }

    @Override
    public void onThemPhieuDatPhongError(String error) {

    }

    @Override
    public void onThemPhieuDatPhongChiTietSuccess() {

    }

    @Override
    public void onThemPhieuDatPhongChiTietError(String error) {

    }

    @Override
    public void onLayPhieuDatPhongChiTietSuccess(List<PhieuDatPhongChiTietDTO> phieuDatPhongChiTietDTOList) {

    }

    @Override
    public void onLayPhieuDatPhongChiTietError(String error) {

    }

    @Override
    public void onThemPhieuDatBanSuccess() {

    }

    @Override
    public void onThemPhieuDatBanError(String error) {

    }

    @Override
    public void onLayPhieuDatBanChiTietSuccess(List<PhieuDatBanChiTietDTO> phieuDatPhongChiTietDTOList) {

    }

    @Override
    public void onLayPhieuDatBanChiTietError(String error) {

    }

    @Override
    public void onCapNhatPhieuDatSuccess() {

    }

    @Override
    public void onCapNhatPhieuDatError(String error) {

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
        phieuDatBanAdapter = new PhieuDatBanAdapter(this);
        phieuDatBanAdapter.setData(getContext(), lsPhieuDat, lsKhachHang);
        rscvPhieuDatBan.setAdapter(phieuDatBanAdapter);
    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {

    }
}