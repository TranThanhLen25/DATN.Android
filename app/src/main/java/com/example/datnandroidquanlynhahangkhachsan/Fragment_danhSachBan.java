package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.BanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDanhSachBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_danhSachBan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_danhSachBan extends Fragment implements BanContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerViewBan;
    private List<BanDTO> lsBan;
    private List<LoaiBanDTO> lsLoaiBan;
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
        ///laay Ban
        BanPresenter banPresenter = new BanPresenter(this);
        banPresenter.LayDanhSachBan();

        /// laay loai ban
        BanPresenter banPresenter1 = new BanPresenter(this);
        banPresenter1.LayDanhSachLoaiBan();

        recyclerViewBan = danhSachBanBinding.rscvDsban;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 3);
        recyclerViewBan.setLayoutManager(gridLayoutManager);
        danhSachBanBinding.iclAppback.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return danhSachBanBinding.getRoot();
    }

    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {
        lsBan = lsDanhSachBan;
        BanAdapter banAdapter = new BanAdapter(this);
        banAdapter.setData(lsBan, lsLoaiBan, getContext());
        recyclerViewBan.setAdapter(banAdapter);
    }

    @Override
    public void onLayDanhSachBanError(String error) {
    }

    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {
        lsLoaiBan = list;
        BanAdapter banAdapter = new BanAdapter(this);
        banAdapter.setData(lsBan, lsLoaiBan, getContext());
        recyclerViewBan.setAdapter(banAdapter);
        Toast.makeText(getActivity(), "aaaaaaaa", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLayDanhSachLoaiBanError(String error) {
        Toast.makeText(getActivity(), "ssssssss", Toast.LENGTH_SHORT).show();
    }
}