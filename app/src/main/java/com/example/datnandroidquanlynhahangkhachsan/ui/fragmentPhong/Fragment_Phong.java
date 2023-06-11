package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDsPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Phong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Phong extends Fragment implements PhongContract.View, LoaiPhongContract.View, PhieuNhanPhongChiTietContract.View, KhachHangContract.View, DsPhieuNhanPhongContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rscvDsPhong;
    private List<PhongDTO> lsPhong;
    private List<LoaiPhongDTO> lsLoaiPhong;
    private List<PhieuNhanPhongChiTietDTO> phieuNhanPhongChiTietDTO;

    private List<KhachHangDTO> lsKhachHang;

    private List<PhieuNhanDTO> lsPhieuNhan;

    private PhongAdapter dsPhongAdapter;
    private PhongPresenter danhSachPhongPresenter;
    private LoaiPhongPresenter loaiPhongPresenter;
    private FragmentDsPhongBinding fragmentDsPhongBinding;


    public Fragment_Phong() {
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
    public static Fragment_Phong newInstance(String param1, String param2) {
        Fragment_Phong fragment = new Fragment_Phong();
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

        fragmentDsPhongBinding = FragmentDsPhongBinding.inflate(inflater, container, false);

        rscvDsPhong = fragmentDsPhongBinding.rscvDsphong;
        //lấy danh sách phòng
        lsPhong = new ArrayList<>();
        danhSachPhongPresenter = new PhongPresenter(this);
        danhSachPhongPresenter.LayDanhSachPhong();
        // lấy loại phòng
        lsLoaiPhong = new ArrayList<>();
        loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();
        /// lay PNP chi tiet
        phieuNhanPhongChiTietDTO = new ArrayList<>();
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);
////lay khach hang
        lsKhachHang = new ArrayList<>();
        ///lấy khách hàng
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);
        ////lay phieu nhan
        lsPhieuNhan = new ArrayList<>();
        //// lấy ra ds PN
        DsPhieuNhanPhongPresenter dsPhieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
        dsPhieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 3);
        rscvDsPhong.setLayoutManager(gridLayoutManager);

        fragmentDsPhongBinding.iclAppback.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return fragmentDsPhongBinding.getRoot();


    }


////load lại trang khi trả phòng
    @Override
    public void onResume() {
        super.onResume();
        lsPhong = new ArrayList<>();
        danhSachPhongPresenter = new PhongPresenter(this);
        danhSachPhongPresenter.LayDanhSachPhong();
        // lấy loại phòng
        lsLoaiPhong=new ArrayList<>();
        loaiPhongPresenter=new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();

    }

    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> list) {
        lsPhong = list;
        dsPhongAdapter = new PhongAdapter(this);
        dsPhongAdapter.setData(lsPhieuNhan, lsKhachHang, lsPhong, getContext(), lsLoaiPhong, phieuNhanPhongChiTietDTO);
        rscvDsPhong.setAdapter(dsPhongAdapter);
    }
    @Override
    public void onLayDanhSachPhongError(String error) {


    }
    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> list) {
        lsLoaiPhong=list;
        dsPhongAdapter = new PhongAdapter(this);
        dsPhongAdapter.setData(lsPhieuNhan, lsKhachHang,lsPhong, getContext(),lsLoaiPhong,phieuNhanPhongChiTietDTO);
        rscvDsPhong.setAdapter(dsPhongAdapter);

    }
    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list){
        phieuNhanPhongChiTietDTO=list;
          }

    @Override
    public void onLayLoaiPhongError(String error) {

    }

    @Override
    public void onLayDanhSachPhong1gSuccess(List<PhongDTO> list) {

    }

    @Override
    public void onLayDanhSachPhong1gError(String error) {

    }

    @Override
    public void onCapNhatTrangThaiPhongSuccess() {


    }

    @Override
    public void onCapNhatTrangThaiPhongError(String error) {

    }
    @Override
    public void onCapNhatPhieuNhanPhongChiTietSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietError(String error) {
    }


    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietError(String error) {
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
        }

    @Override
    public void onLayDanhSachKhachHangError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
        lsPhieuNhan = list;
    }

    @Override
    public void onLayDanhSachPhieuNhanError(String error) {
    }

    //thêm phiếu đặt phòng
    @Override
    public void onThemPhieuNhanPhongSuccess() {
    }

    @Override
    public void onThemPhieuNhanPhongError(String error) {
    }

}