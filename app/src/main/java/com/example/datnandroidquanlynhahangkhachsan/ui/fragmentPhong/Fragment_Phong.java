package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhongAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDsPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.DieuKienLocPhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.DsPhieuDatPhongPresenter;
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

    private List<PhongDTO> searchPhong;

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


        lsPhong = new ArrayList<>();
        lsLoaiPhong = new ArrayList<>();
        phieuNhanPhongChiTietDTO = new ArrayList<>();
        lsPhieuNhan = new ArrayList<>();
        lsKhachHang = new ArrayList<>();


        //lấy danh sách phòng
        danhSachPhongPresenter = new PhongPresenter(this);
        danhSachPhongPresenter.LayDanhSachPhong();

        // lấy loại phòng
        loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();

        /// lay PNP chi tiet
        PhieuNhanPhongChiTietPresenter phieuNhanPhongChiTietPresenter = new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanPhongChiTietDTO dieuKienLocPhieuNhanPhongChiTietDTO = new DieuKienLocPhieuNhanPhongChiTietDTO();
        phieuNhanPhongChiTietPresenter.LayDanhSachPhieuNhanPhongChiTiet(dieuKienLocPhieuNhanPhongChiTietDTO);

        ////lay phieu nhan
        DsPhieuNhanPhongPresenter dsPhieuNhanPhongPresenter = new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO = new DieuKienLocPhieuNhanDTO();
        dsPhieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);

        ////lay khach hang
        KhachHangPresenter khachHangPresenter = new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO = new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);


        rscvDsPhong = fragmentDsPhongBinding.rscvDsphong;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 3);
        rscvDsPhong.setLayoutManager(gridLayoutManager);

        fragmentDsPhongBinding.iclAppback.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        SearchView searchView=fragmentDsPhongBinding.iclSearch.search;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchPhong=new ArrayList<>();

                if(newText.length()>0)
                {
           for (int i=0;i< lsPhong.size();i++)
           {
               if(String.valueOf(lsPhong.get(i).getSoPhong()).contains(newText) )
               {
                   searchPhong.add(lsPhong.get(i));
               }
           }
                    dsPhongAdapter = new PhongAdapter(Fragment_Phong.this);
                    dsPhongAdapter.setData(lsPhieuNhan, lsKhachHang, searchPhong, getContext(), lsLoaiPhong, phieuNhanPhongChiTietDTO);
                    rscvDsPhong.setAdapter(dsPhongAdapter);
                }
                return false;
            }
        });

        return fragmentDsPhongBinding.getRoot();


    }


////load lại trang khi trả phòng
    @Override
    public void onResume() {
        super.onResume();
        try {
            Thread.sleep(100);
            lsPhong = new ArrayList<>();
            lsLoaiPhong = new ArrayList<>();
            danhSachPhongPresenter = new PhongPresenter(this);
            danhSachPhongPresenter.LayDanhSachPhong();
            // lấy loại phòng
            loaiPhongPresenter = new LoaiPhongPresenter(this);
            loaiPhongPresenter.LayLoaiPhong();

            PhongAdapter phongAdapter=new PhongAdapter(this);
            phongAdapter.notifyDataSetChanged();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> list) {
        lsPhong = list;
        dsPhongAdapter = new PhongAdapter(this);
        dsPhongAdapter.setData(lsPhieuNhan, lsKhachHang, lsPhong, getContext(), lsLoaiPhong, phieuNhanPhongChiTietDTO);
        rscvDsPhong.setAdapter(dsPhongAdapter);
    }
    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> list) {
        lsLoaiPhong=list;
        dsPhongAdapter = new PhongAdapter(this);
        dsPhongAdapter.setData(lsPhieuNhan, lsKhachHang,lsPhong, getContext(),lsLoaiPhong,phieuNhanPhongChiTietDTO);
        rscvDsPhong.setAdapter(dsPhongAdapter);

    }
    @Override
    public void onLayDanhSachKhachHangSuccess(List<KhachHangDTO> list) {
        lsKhachHang = list;
        dsPhongAdapter = new PhongAdapter(this);
        dsPhongAdapter.setData(lsPhieuNhan, lsKhachHang,lsPhong, getContext(),lsLoaiPhong,phieuNhanPhongChiTietDTO);
        rscvDsPhong.setAdapter(dsPhongAdapter);

    }
    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {
        lsPhieuNhan = list;
        dsPhongAdapter = new PhongAdapter(this);
        dsPhongAdapter.setData(lsPhieuNhan, lsKhachHang,lsPhong, getContext(),lsLoaiPhong,phieuNhanPhongChiTietDTO);
        rscvDsPhong.setAdapter(dsPhongAdapter);
    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list){
        phieuNhanPhongChiTietDTO=list;
        dsPhongAdapter = new PhongAdapter(this);
        dsPhongAdapter.setData(lsPhieuNhan, lsKhachHang,lsPhong, getContext(),lsLoaiPhong,phieuNhanPhongChiTietDTO);
        rscvDsPhong.setAdapter(dsPhongAdapter);
    }




    @Override
    public void onLayDanhSachPhongError(String error) {


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
    public void onDoiPhongSuccess() {

    }

    @Override
    public void onDoiPhongError(String error) {

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
    public void onLayDanhSachKhachHangError(String error) {
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

    @Override
    public void onThemPhieuNhanBanSuccess() {

    }

    @Override
    public void onThemPhieuNhanBanError(String error) {

    }
    @Override
    public  void onLayDanhSachPhieuNhanBanChiTietSuccess(List<PhieuNhanBanChiTietDTO> list){}

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietError(String error){}
    @Override
    public void onCapNhatPhieuNhanSuccess(){}

    @Override
    public void onCapNhatPhieuNhanError(String error){}

    @Override
    public  void onCapNhatPhieuNhanBanChiTietSuccess(){}

    @Override
    public  void onCapNhatPhieuNhanBanChiTietError(String error){}
}