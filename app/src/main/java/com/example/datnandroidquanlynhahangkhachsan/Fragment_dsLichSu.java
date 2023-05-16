package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuXuatAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDsLichSuBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.DanhSachMenuActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.ThemPhieuNhanPhongActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.Fragment_dsPhieuNhanPhong;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatConTract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_dsLichSu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_dsLichSu extends Fragment implements PhieuXuatConTract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Fragment fragment = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentDsLichSuBinding phieuXuatBinding;
    private List<PhieuXuatDTO> phieuXuat;
    private PhieuXuatAdapter phieuXuatAdapter;
    private RecyclerView recyclerView;
    public Fragment_dsLichSu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_dsLichSu.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_dsLichSu newInstance(String param1, String param2) {
        Fragment_dsLichSu fragment = new Fragment_dsLichSu();
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
        phieuXuatBinding=FragmentDsLichSuBinding.inflate(inflater,container,false);
        phieuXuat = new ArrayList<>();

        PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
        DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
        phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);

        recyclerView = phieuXuatBinding.rscvDslichsu;
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(LinearLayoutManager);


        return phieuXuatBinding.getRoot();
    }
    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
        phieuXuat = list;
        phieuXuatAdapter = new PhieuXuatAdapter(this);
        phieuXuatAdapter.setData(phieuXuat, getContext());
        recyclerView.setAdapter(phieuXuatAdapter);
        Toast.makeText(getContext(), "aaaaaaaaaaaaaaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onLayDanhSachPhieuXuatError(String error) {
    }

    @Override
    public void onThemPhieuXuatSuccess(){}

    @Override
    public void onThemPhieuXuatError(String error){}

}