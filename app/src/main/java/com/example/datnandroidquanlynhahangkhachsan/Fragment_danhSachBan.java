package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.BanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDanhSachBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.DieuKienLocKhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.DieuKienLocPhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanBanChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanPhongChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.KhachHang.KhachHangPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.DsPhieuNhanPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.PhieuNhanPhongChiTietPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_danhSachBan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_danhSachBan extends Fragment implements BanContract.View, KhachHangContract.View, PhieuNhanPhongChiTietContract.View, DsPhieuNhanPhongContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerViewBan;

    private List<BanDTO> lsBan;
    private List<BanDTO> search_Ban;
    private List<LoaiBanDTO> lsLoaiBan;
    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<PhieuNhanBanChiTietDTO> lsPNCT;
    private List<KhachHangDTO> lsKhachHang;
    private Context context;

    public Fragment_danhSachBan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_danSachBan.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_danhSachBan newInstance(String param1, String param2) {
        Fragment_danhSachBan fragment = new Fragment_danhSachBan();
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
        FragmentDanhSachBanBinding danhSachBanBinding = FragmentDanhSachBanBinding.inflate(getLayoutInflater());
        lsBan = new ArrayList<>();
        lsLoaiBan = new ArrayList<>();
        lsPNCT=new ArrayList<>();
        lsPhieuNhan=new ArrayList<>();
        lsKhachHang=new ArrayList<>();
        ///laay Ban
        BanPresenter banPresenter = new BanPresenter(this);
        banPresenter.LayDanhSachBan();
        /// laay loai ban
        BanPresenter banPresenter1 = new BanPresenter(this);
        banPresenter1.LayDanhSachLoaiBan();
        ///lay pnct
        PhieuNhanPhongChiTietPresenter phieuNhanBanChiTietPresenter=new PhieuNhanPhongChiTietPresenter(this);
        DieuKienLocPhieuNhanBanChiTietDTO dieuKienLocPhieuNhanBanChiTietDTO=new DieuKienLocPhieuNhanBanChiTietDTO();
        phieuNhanBanChiTietPresenter.LayDanhSachPhieuNhanBanChiTiet(dieuKienLocPhieuNhanBanChiTietDTO);
        ///lay pn
        DsPhieuNhanPhongPresenter phieuNhanPhongPresenter=new DsPhieuNhanPhongPresenter(this);
        DieuKienLocPhieuNhanDTO dieuKienLocPhieuNhanDTO=new DieuKienLocPhieuNhanDTO();
        phieuNhanPhongPresenter.LayDanhSachPhieuNhan(dieuKienLocPhieuNhanDTO);
        /// lay khach hang
        KhachHangPresenter khachHangPresenter=new KhachHangPresenter(this);
        DieuKienLocKhachHangDTO dieuKienLocKhachHangDTO=new DieuKienLocKhachHangDTO();
        khachHangPresenter.LayDanhSachKhachHang(dieuKienLocKhachHangDTO);


        recyclerViewBan = danhSachBanBinding.rscvDsban;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 3);
        recyclerViewBan.setLayoutManager(gridLayoutManager);
        danhSachBanBinding.iclAppback.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        SearchView searchView=danhSachBanBinding.iclSearchban.search;

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                search_Ban=new ArrayList<>();
                if(newText.length()>0)
                {
                    for (int i=0;i< lsBan.size();i++)
                    {
                        if (lsBan.get(i).getTenBan().toUpperCase().contains(newText.toUpperCase()))
                        {
                            search_Ban.add(lsBan.get(i));
                        }
                    }

                    BanAdapter banAdapter = new BanAdapter(Fragment_danhSachBan.this);
                    banAdapter.setData(lsKhachHang,lsPNCT,lsPhieuNhan, search_Ban, lsLoaiBan, getContext());
                    recyclerViewBan.setAdapter(banAdapter);
                }
                return false;
            }
        });


        return danhSachBanBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        ///laay Ban
        BanPresenter banPresenter = new BanPresenter(this);
        banPresenter.LayDanhSachBan();
        /// laay loai ban
        BanPresenter banPresenter1 = new BanPresenter(this);
        banPresenter1.LayDanhSachLoaiBan();
    }

    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
        lsBan = lsDanhSachBan;
        BanAdapter banAdapter = new BanAdapter(this);
        banAdapter.setData(lsKhachHang,lsPNCT,lsPhieuNhan, lsBan, lsLoaiBan, getContext());
        recyclerViewBan.setAdapter(banAdapter);
    }

    @Override
    public void onLayDanhSachBanError(String error) {
    }

    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {
        lsLoaiBan = list;
        BanAdapter banAdapter = new BanAdapter(this);
        banAdapter.setData(lsKhachHang,lsPNCT,lsPhieuNhan, lsBan, lsLoaiBan, getContext());
        recyclerViewBan.setAdapter(banAdapter);


    }

    @Override
    public void onLayDanhSachLoaiBanError(String error) {
        Toast.makeText(getActivity(), "Lấy dữ liệu thất bại!!!", Toast.LENGTH_SHORT).show();
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
        BanAdapter banAdapter = new BanAdapter(this);
        banAdapter.setData(lsKhachHang,lsPNCT,lsPhieuNhan, lsBan, lsLoaiBan, getContext());
        recyclerViewBan.setAdapter(banAdapter);


    }

    @Override
    public void onLayDanhSachKhachHangError(String error) {
    }

    //lấy danh sách phiếu nhận phòng
    @Override
    public void onLayDanhSachPhieuNhanSuccess(List<PhieuNhanDTO> list) {

        lsPhieuNhan=list;
        BanAdapter banAdapter = new BanAdapter(this);
        banAdapter.setData(lsKhachHang,lsPNCT,lsPhieuNhan, lsBan, lsLoaiBan, getContext());
        recyclerViewBan.setAdapter(banAdapter);

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

    //thêm phiếu nhận bàn
    @Override
    public void onThemPhieuNhanBanSuccess() {
    }

    @Override
    public void onThemPhieuNhanBanError(String error) {
    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietSuccess() {
    }

    @Override
    public void onCapNhatPhieuNhanPhongChiTietError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietSuccess(List<PhieuNhanPhongChiTietDTO> list) {

    }

    @Override
    public void onLayDanhSachPhieuNhanPhongChiTietError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietSuccess(List<PhieuNhanBanChiTietDTO> list){
        lsPNCT=list;
        BanAdapter banAdapter = new BanAdapter(this);
        banAdapter.setData(lsKhachHang,lsPNCT,lsPhieuNhan, lsBan, lsLoaiBan, getContext());
        recyclerViewBan.setAdapter(banAdapter);



    }

    @Override
    public void onLayDanhSachPhieuNhanBanChiTietError(String error){


    }
    @Override
    public void onCapNhatPhieuNhanSuccess(){}

    @Override
    public void onCapNhatPhieuNhanError(String error){}
    @Override
    public void onCapNhatTrangThaiBanSuccess(){}

    @Override
    public void onCapNhatTrangThaiBanError(String error){}

    @Override
    public void onCapNhatPhieuNhanBanChiTietSuccess(){}

    @Override
    public void onCapNhatPhieuNhanBanChiTietError(String error){}
}