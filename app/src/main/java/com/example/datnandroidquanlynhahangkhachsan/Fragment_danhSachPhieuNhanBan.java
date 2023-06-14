package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuNhanBanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDanhSachPhieuNhanBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;

import java.util.ArrayList;
import java.util.List;


public class Fragment_danhSachPhieuNhanBan extends Fragment implements DsPhieuNhanPhongContract.View, KhachHangContract.View {

    private RecyclerView rscvPhieuNhanBan;
    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<KhachHangDTO> lsKhachHang;
    private PhieuNhanBanAdapter phieuNhanBanAdapter;
    private FragmentDanhSachPhieuNhanBanBinding fragmentDanhSachPhieuNhanBanBinding;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public Fragment_danhSachPhieuNhanBan() {

    }


    public static Fragment_danhSachPhieuNhanBan newInstance(String param1, String param2) {
        Fragment_danhSachPhieuNhanBan fragment = new Fragment_danhSachPhieuNhanBan();
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
        fragmentDanhSachPhieuNhanBanBinding = fragmentDanhSachPhieuNhanBanBinding.inflate(inflater, container, false);

        lsPhieuNhan = new ArrayList<>();
        ///lấy dữ liệu danh sách phiếu nhận
        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();

        ////loại 3:phiếu nhận phòng
        dieuKienLocPhieuNhanDTO.setLoaiPhieu(4);
        dieuKienLocPhieuNhanDTO.setTrangThai("đang nhận");
        phieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);

        ///lấy khách hàng
        lsKhachHang = new ArrayList<>();
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);

        fragmentDanhSachPhieuNhanBanBinding.iclAppbackpnp.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        fragmentDanhSachPhieuNhanBanBinding.flBtnThemphieunhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activityThemPhieuNhanBan.class);
                startActivity(intent);
            }
        });
        rscvPhieuNhanBan = fragmentDanhSachPhieuNhanBanBinding.rscvDsphieunhanban;
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuNhanBan.setLayoutManager(LinearLayoutManager);


        return fragmentDanhSachPhieuNhanBanBinding.getRoot();
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
        phieuNhanBanAdapter = new PhieuNhanBanAdapter(this);
        phieuNhanBanAdapter.setData(lsPhieuNhan, lsKhachHang, getContext());
        rscvPhieuNhanBan.setAdapter(phieuNhanBanAdapter);
    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {

    }

    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
        lsPhieuNhan = list;
        phieuNhanBanAdapter = new PhieuNhanBanAdapter(this);
        phieuNhanBanAdapter.setData(lsPhieuNhan, lsKhachHang, getContext());
        rscvPhieuNhanBan.setAdapter(phieuNhanBanAdapter);
    }

    @Override
    public void onLayDanhSachPhieuNhanError(String error) {

    }

    @Override
    public void onThemPhieuNhanPhongSuccess() {

    }

    @Override
    public void onThemPhieuNhanPhongError(String error) {

    }

    @Override
    public void onThemPhieuNhanBanSuccess() {

    }

    @Override
    public void onThemPhieuNhanBanError(String error) {

    }


}