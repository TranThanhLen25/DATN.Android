package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.NguoiDungAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentNhanVienBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.dangnhap.NguoiDungPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_nhanVien#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_nhanVien extends Fragment implements NguoiDungContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<NguoiDungDTO> lsNguoiDung;
    private List<NguoiDungDTO> search_NguoiDung;
    private RecyclerView rccwND;


    public Fragment_nhanVien() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_nhanVien.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_nhanVien newInstance(String param1, String param2) {
        Fragment_nhanVien fragment = new Fragment_nhanVien();
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
        FragmentNhanVienBinding nhanVienBinding=FragmentNhanVienBinding.inflate(inflater,container,false);

        /// lay Ds nguoi dung
        lsNguoiDung=new ArrayList<>();
        NguoiDungPresenter nguoiDungPresenter = new NguoiDungPresenter(this);
        nguoiDungPresenter.LayNguoiDung();



        rccwND = nhanVienBinding.rscvDsnhanvien;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rccwND.setLayoutManager(linearLayoutManager);

        nhanVienBinding.iclSearchnv.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search_NguoiDung=new ArrayList<>();
                if(newText.length()>0)
                {
                    for (NguoiDungDTO nguoiDungDTO:lsNguoiDung)
                    {
                        if(nguoiDungDTO.getTenNguoiDung().toUpperCase().contains(newText.toUpperCase()))
                        {
                            search_NguoiDung.add(nguoiDungDTO);
                        }
                    }
                    NguoiDungAdapter  nguoiDungAdapter = new NguoiDungAdapter(Fragment_nhanVien.this);
                    nguoiDungAdapter.setData( search_NguoiDung,getContext());
                    rccwND .setAdapter(nguoiDungAdapter);
                }
                return true;
            }
        });

        ///thêm NV
        nhanVienBinding.flBtnNhanvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ThemNhanVien_Activity.class);
                startActivity(intent);
            }
        });
        return nhanVienBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        lsNguoiDung = new ArrayList<>();
        NguoiDungAdapter nguoiDungAdapter=new NguoiDungAdapter(Fragment_nhanVien.this);
        /// lay Ds nguoi dung

        NguoiDungPresenter nguoiDungPresenter = new NguoiDungPresenter(Fragment_nhanVien.this);
        nguoiDungPresenter.LayNguoiDung();

        nguoiDungAdapter.notifyDataSetChanged();

    }

    @Override
    public void onLayNguoiDungSuccess(List<NguoiDungDTO> lsNguoiDung) {
        lsNguoiDung = lsNguoiDung;
        NguoiDungAdapter  nguoiDungAdapter = new NguoiDungAdapter(this);
        nguoiDungAdapter.setData( lsNguoiDung,getContext());
        rccwND.setAdapter(nguoiDungAdapter);
        Collections.reverse(lsNguoiDung);
        nguoiDungAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLayNguoiDungError(String error) {
    }

    /// lấy người dùng theo id
    @Override
    public void onLayNguoiDungIDSuccess(List<NguoiDungDTO> lsNguoiDungID) {
    }

    @Override
    public void onLayNguoiDungIDError(String error) {
    }

    @Override
    public void onCapNhatNguoiDungSuccess(){}

    @Override
    public  void onCapNhatNguoiDungError(String error){}

    @Override
    public void onThemNguoiDungSuccess(){}

    @Override
    public void onThemNguoiDungError(String error){}
}