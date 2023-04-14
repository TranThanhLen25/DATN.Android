package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;

import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDsPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonphong.LoaiPhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.DsPhongAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_dsPhong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dsPhong extends Fragment implements PhongContract.View , LoaiPhongContract.View {

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
    private DsPhongAdapter dsPhongAdapter;
    private PhongPresenter danhSachPhongPresenter;
    private LoaiPhongPresenter loaiPhongPresenter;
    private FragmentDsPhongBinding fragmentDsPhongBinding;


    public Fragment_dsPhong() {
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
    public static Fragment_dsPhong newInstance(String param1, String param2) {
        Fragment_dsPhong fragment = new Fragment_dsPhong();
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
        lsLoaiPhong=new ArrayList<>();
       loaiPhongPresenter=new LoaiPhongPresenter(this);
       loaiPhongPresenter.LayLoaiPhong();


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

    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> list) {
        lsPhong = list;
        dsPhongAdapter = new DsPhongAdapter(this);
        dsPhongAdapter.setData(lsPhong, getContext(),lsLoaiPhong);
        rscvDsPhong.setAdapter(dsPhongAdapter);
    }
    @Override
    public void onLayDanhSachPhongError(String error) {

        Toast.makeText(getContext(), "Lay du lieu that bai", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> list) {
        lsLoaiPhong=list;
        dsPhongAdapter = new DsPhongAdapter(this);
        dsPhongAdapter.setData(lsPhong, getContext(),lsLoaiPhong);
        rscvDsPhong.setAdapter(dsPhongAdapter);

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

}