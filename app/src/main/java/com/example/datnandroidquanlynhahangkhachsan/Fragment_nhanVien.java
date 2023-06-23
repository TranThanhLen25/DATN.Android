package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private RecyclerView recyclerView;

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
        lsNguoiDung=new ArrayList<>();
        /// lay Ds nguoi dung
        NguoiDungPresenter nguoiDungPresenter=new NguoiDungPresenter(this);
        nguoiDungPresenter.LayNguoiDung();
// Đảo ngược thứ tự của tập dữ liệu
        Collections.reverse(lsNguoiDung);
        nhanVienBinding.flBtnNhanvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ThemNhanVien_Activity.class);
                startActivity(intent);
            }
        });

         recyclerView=nhanVienBinding.rscvDsnhanvien;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        return nhanVienBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        lsNguoiDung=new ArrayList<>();
        /// lay Ds nguoi dung
        NguoiDungPresenter nguoiDungPresenter=new NguoiDungPresenter(this);
        nguoiDungPresenter.LayNguoiDung();
        // Đảo ngược thứ tự của tập dữ liệu
        Collections.reverse(lsNguoiDung);
    }

    /// lấy danh sách người dùng
   @Override
   public void onLayNguoiDungSuccess(List<NguoiDungDTO> lsNguoiDung){
        lsNguoiDung=lsNguoiDung;
       NguoiDungAdapter nguoiDungAdapter=new NguoiDungAdapter(this);
       nguoiDungAdapter.setData(getContext(),lsNguoiDung);
       recyclerView.setAdapter(nguoiDungAdapter);


   }

    @Override
    public void onLayNguoiDungError(String error){}

    /// lấy người dùng theo id
    @Override
    public void onLayNguoiDungIDSuccess(List<NguoiDungDTO> lsNguoiDungID){}

    @Override
    public void onLayNguoiDungIDError(String error){}

    @Override
    public void onCapNhatNguoiDungSuccess(){}

    @Override
    public  void onCapNhatNguoiDungError(String error){}

    @Override
    public void onThemNguoiDungSuccess(){}

    @Override
    public void onThemNguoiDungError(String error){}
}