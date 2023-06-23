package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.HangHoaAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentQuanLyHangHoaBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_QuanLyHangHoa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_QuanLyHangHoa extends Fragment implements HangHoaContract.View {
    private List<HangHoaDTO> lsHangHoa;
    private FragmentQuanLyHangHoaBinding fragmentQuanLyHangHoaBinding;
    private HangHoaAdapter hangHoaAdapter;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private List<HangHoaDTO> searchList;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public Fragment_QuanLyHangHoa() {

    }


    public static Fragment_QuanLyHangHoa newInstance(String param1, String param2) {
        Fragment_QuanLyHangHoa fragment = new Fragment_QuanLyHangHoa();
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
        tempData.CheckChucNang = false;
        fragmentQuanLyHangHoaBinding = FragmentQuanLyHangHoaBinding.inflate(inflater, container, false);
        searchView = fragmentQuanLyHangHoaBinding.Search;
        recyclerView = fragmentQuanLyHangHoaBinding.rscvDsphieudatban;
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(LinearLayoutManager);
        lsHangHoa = new ArrayList<>();
        HangHoaPresenter hangHoaPresenter = new HangHoaPresenter(this);
        hangHoaPresenter.LayDanhSachHangHoa2("");

        return fragmentQuanLyHangHoaBinding.getRoot();
    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        lsHangHoa = list;
        hangHoaAdapter = new HangHoaAdapter(lsHangHoa);
        hangHoaAdapter.setData(getContext(), lsHangHoa);
        recyclerView.setAdapter(hangHoaAdapter);
    }

    @Override
    public void onLayDanhSachHangHoaError(String error) {

    }

    @Override
    public void onThemHangHoaSuccess() {

    }

    @Override
    public void onThemHangHoaError(String error) {

    }

    @Override
    public void onXoaHangHoaSuccess() {

    }

    @Override
    public void onXoaHangHoaError(String error) {

    }
}