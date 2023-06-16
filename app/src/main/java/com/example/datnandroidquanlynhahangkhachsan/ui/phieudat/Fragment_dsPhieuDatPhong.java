package com.example.datnandroidquanlynhahangkhachsan.ui.phieudat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuDatPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDsPhieuDatPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_dsPhieuDatPhong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dsPhieuDatPhong extends Fragment implements DsPhieuDatPhongContract.View, KhachHangContract.View {
    private RecyclerView rscvPhieuDatPhong;
    private List<PhieuDatDTO> lsPhieuDat;
    private PhieuDatPhongAdapter phieuDatPhongAdapter;
    private DsPhieuDatPhongPresenter dsPhieuDatPhongPresenter;
    private FragmentDsPhieuDatPhongBinding fragmentDsPhieuDatPhongBinding;
    DieuKienLocPhieuDatDTO dieuKienLocPhieuDatDTO;
    private List<KhachHangDTO> lsKhachHang;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_dsPhieuDatPhong() {
        ///  // Required empty public constructor
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
        super.onCreate(savedInstanceState);
        fragmentDsPhieuDatPhongBinding = fragmentDsPhieuDatPhongBinding.inflate(inflater, container, false);
        fragmentDsPhieuDatPhongBinding.iclAppbackpdp.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        fragmentDsPhieuDatPhongBinding.flBtnThemphieudat.setOnClickListener(new View.OnClickListener() {
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

        rscvPhieuDatPhong = fragmentDsPhieuDatPhongBinding.rscvDsphieudatphong;
        lsPhieuDat = new ArrayList<>();
        Date day = Calendar.getInstance().getTime();
        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
        dieuKienLocPhieuDatDTO = new DieuKienLocPhieuDatDTO();
        dieuKienLocPhieuDatDTO.setLoaiPhieu(1);
        dieuKienLocPhieuDatDTO.setTrangThai("đang đặt");
        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuDatPhong.setLayoutManager(LinearLayoutManager);
        return fragmentDsPhieuDatPhongBinding.getRoot();


    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        ///lấy khách hàng
//        lsKhachHang = new ArrayList<>();
//        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
//        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
//        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);
//
//        rscvPhieuDatPhong = fragmentDsPhieuDatPhongBinding.rscvDsphieudatphong;
//        lsPhieuDat = new ArrayList<>();
//        dsPhieuDatPhongPresenter = new DsPhieuDatPhongPresenter(this);
//        dieuKienLocPhieuDatDTO = new DieuKienLocPhieuDatDTO();
//        dieuKienLocPhieuDatDTO.setLoaiPhieu(1);
//        dieuKienLocPhieuDatDTO.setTrangThai("đang đặt");
//        dsPhieuDatPhongPresenter.LayDanhSachPhieuDat(dieuKienLocPhieuDatDTO);
//        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
//        rscvPhieuDatPhong.setLayoutManager(LinearLayoutManager);
//    }

    @Override
    public void onLayDanhSachPhieuDatSuccess(List<PhieuDatDTO> list) {
        lsPhieuDat = list;
        phieuDatPhongAdapter = new PhieuDatPhongAdapter(this);
        phieuDatPhongAdapter.setData(getContext(), lsPhieuDat, lsKhachHang);
        rscvPhieuDatPhong.setAdapter(phieuDatPhongAdapter);
        //Toast.makeText(getContext(), "Lấy danh sách phiếu đặt phòng thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLayDanhSachPhieuDatError(String error) {
        Toast.makeText(getContext(), "Lấy danh sách phiếu đặt phòng thất bại", Toast.LENGTH_LONG).show();
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
        phieuDatPhongAdapter = new PhieuDatPhongAdapter(this);
        phieuDatPhongAdapter.setData(getContext(), lsPhieuDat, lsKhachHang);
        rscvPhieuDatPhong.setAdapter(phieuDatPhongAdapter);
    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {

    }
}