package com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuNhanPhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDsPhieuNhanPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatConTract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_dsPhieuNhanPhong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dsPhieuNhanPhong extends Fragment implements DsPhieuNhanPhongContract.View, KhachHangContract.View, PhieuXuatConTract.View {

    private RecyclerView rscvPhieuNhanPhong;
    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<KhachHangDTO> lsKhachHang;
    private List<PhieuXuatDTO> lsPhieuXuat;
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
        lsPhieuNhan = new ArrayList<>();
        ///lấy dữ liệu danh sách phiếu nhận
        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();

        ////loại 3:phiếu nhận phòng
        dieuKienLocPhieuNhanDTO.setLoaiPhieu(3);
        dieuKienLocPhieuNhanDTO.setTrangThai("đang nhận");
        phieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);

        ///lấy khách hàng
        lsKhachHang = new ArrayList<>();
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);

///lay PX
        lsPhieuXuat=new ArrayList<>();
        PhieuXuatPresenter phieuXuatPresenter=new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO=new DieuKienLocPhieuXuatDTO();
        dieuKienLocPhieuXuatDTO.setSoChungTu("px");
        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
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

        Date day = Calendar.getInstance().getTime();


        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvPhieuNhanPhong.setLayoutManager(LinearLayoutManager);

        return fragmentDsPhieuNhanPhongBinding.getRoot();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        lsPhieuNhan = new ArrayList<>();
//        ///lấy dữ liệu danh sách phiếu nhận
//        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
//        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
//
//        ////loại 3:phiếu nhận phòng
//        dieuKienLocPhieuNhanDTO.setLoaiPhieu(3);
//        phieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);
//
//        ///lấy khách hàng
//        lsKhachHang = new ArrayList<>();
//        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
//        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
//        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);
//        rscvPhieuNhanPhong = fragmentDsPhieuNhanPhongBinding.rscvDsphieunhanphong;
//        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
//        rscvPhieuNhanPhong.setLayoutManager(LinearLayoutManager);
//    }

    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
        lsPhieuNhan = list;
//        phieuNhanPhongAdapter = new PhieuNhanPhongAdapter(this);
//        phieuNhanPhongAdapter.setData(lsPhieuNhan, lsKhachHang,getContext());
//        rscvPhieuNhanPhong.setAdapter(phieuNhanPhongAdapter);
        //Toast.makeText(getContext(), "Lấy danh sách phiếu đặt phòng thành công", Toast.LENGTH_LONG).show();
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


    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {
        lsKhachHang = list;
        phieuNhanPhongAdapter = new PhieuNhanPhongAdapter(this);
        phieuNhanPhongAdapter.setData(lsPhieuXuat,lsPhieuNhan, lsKhachHang,getContext());
        rscvPhieuNhanPhong.setAdapter(phieuNhanPhongAdapter);

        //Toast.makeText(getContext(), "Lấy danh sách phiếu đặt phòng thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {
    }

    @Override
    public void onThemKhachHangSuccess() {

    }

    @Override
    public void onThemKhachHangError(String error) {

    }
    @Override
    public void onThemPhieuXuatSuccess(){}

    @Override
    public void onThemPhieuXuatError(String error){}

    @Override
    public void onThemPhieuXuatChiTietSuccess() {

    }

    @Override
    public void onThemPhieuXuatChiTietError(String error) {

    }


    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
        lsPhieuXuat=list;
        phieuNhanPhongAdapter = new PhieuNhanPhongAdapter(this);
        phieuNhanPhongAdapter.setData(lsPhieuXuat,lsPhieuNhan, lsKhachHang,getContext());
        rscvPhieuNhanPhong.setAdapter(phieuNhanPhongAdapter);

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
    public void onCapNhatPXError(String error){}

}