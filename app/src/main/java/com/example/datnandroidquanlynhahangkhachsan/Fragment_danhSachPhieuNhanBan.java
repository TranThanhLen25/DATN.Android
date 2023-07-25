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

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuNhanBanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDanhSachPhieuNhanBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatConTract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatPresenter;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Fragment_danhSachPhieuNhanBan extends Fragment implements DsPhieuNhanPhongContract.View, KhachHangContract.View, PhieuXuatConTract.View {

    private RecyclerView rscvPhieuNhanBan;
    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<KhachHangDTO> lsKhachHang;
    private PhieuNhanBanAdapter phieuNhanBanAdapter;
    private FragmentDanhSachPhieuNhanBanBinding fragmentDanhSachPhieuNhanBanBinding;

    private SearchView searchView;
    private List<PhieuXuatDTO> lsPhieuXuat;

    private List<PhieuNhanDTO> searchList;

    private List<KhachHangDTO> searchListKhachHang;

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

        ///lay PX
        lsPhieuXuat = new ArrayList<>();
        PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
        dieuKienLocPhieuXuatDTO.setSoChungTu("pb");
        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);


        fragmentDanhSachPhieuNhanBanBinding.iclAppbackpnp.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        fragmentDanhSachPhieuNhanBanBinding.flBtnThemphieunhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.tempDatakhachHangDTO=new KhachHangDTO();
                Intent intent = new Intent(getActivity(), activityThemPhieuNhanBan.class);
                startActivity(intent);
            }
        });
        rscvPhieuNhanBan = fragmentDanhSachPhieuNhanBanBinding.rscvDsphieunhanban;
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuNhanBan.setLayoutManager(LinearLayoutManager);



        searchView = fragmentDanhSachPhieuNhanBanBinding.Search;
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
                        for (int i = 0; i < lsPhieuNhan.size(); i++) {
                            if (searchListKhachHang.get(j).getKhachHangId() == lsPhieuNhan.get(i).getKhachHangId()) {
                                searchList.add(lsPhieuNhan.get(i));
                            }
                        }
                    }


                    phieuNhanBanAdapter = new PhieuNhanBanAdapter(Fragment_danhSachPhieuNhanBan.this);

                    phieuNhanBanAdapter.setData(lsPhieuXuat, searchList, lsKhachHang, getContext());
                    rscvPhieuNhanBan.setAdapter(phieuNhanBanAdapter);
                    //Toast.makeText(getContext(), String.valueOf(lsKhachHang.size()), Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

        return fragmentDanhSachPhieuNhanBanBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
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

        tempData.khachHangDTOList=lsKhachHang;
        phieuNhanBanAdapter = new PhieuNhanBanAdapter(this);
        phieuNhanBanAdapter.setData(lsPhieuXuat, lsPhieuNhan, lsKhachHang, getContext());
        rscvPhieuNhanBan.setAdapter(phieuNhanBanAdapter);
    }


    @Override
    public void onThemPhieuXuatSuccess() {
    }

    @Override
    public void onThemPhieuXuatError(String error) {
    }

    @Override
    public void onThemPhieuXuatChiTietSuccess() {
    }

    @Override
    public void onThemPhieuXuatChiTietError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
        lsPhieuXuat = list;
        phieuNhanBanAdapter = new PhieuNhanBanAdapter(this);
        phieuNhanBanAdapter.setData(lsPhieuXuat, lsPhieuNhan, lsKhachHang, getContext());
        rscvPhieuNhanBan.setAdapter(phieuNhanBanAdapter);
    }

    @Override
    public void onLayDanhSachPhieuXuatError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
    }

    @Override
    public void onLayDanhSachPhieuXuatChiTietError(String error) {
    }

    @Override
    public void onCapNhatPXSuccess() {
    }

    @Override
    public void onCapNhatPXError(String error) {
    }


    @Override
    public void onLayDanhSachKhachHangError(String error) {

    }

    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
        lsPhieuNhan = list;
        // Đảo ngược thứ tự của tập dữ liệu
        Collections.reverse(lsPhieuNhan);
        phieuNhanBanAdapter = new PhieuNhanBanAdapter(this);
        phieuNhanBanAdapter.setData(lsPhieuXuat, lsPhieuNhan, lsKhachHang, getContext());
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
    @Override
    public void onCapNhatPhieuNhanSuccess(){}

    @Override
    public void onCapNhatPhieuNhanError(String error){}

}