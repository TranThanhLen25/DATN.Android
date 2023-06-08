package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuDatBanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDanhSachPhieuDatBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.ThemPhieuDatphongActivity;

import java.util.ArrayList;
import java.util.Calendar;
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
                Intent intent = new Intent(getActivity(), ThemPhieuDatphongActivity.class);
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


        return fragmentDanhSachPhieuDatBanBinding.getRoot();
    }

    @Override
    public void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list) {
        lsPhieuDat = list;
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
    public void onThemKhachHangSuccess() {

    }

    @Override
    public void onThemKhachHangError(String error) {

    }

    @Override
    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {
        lsKhachHang=list;
    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {

    }
}