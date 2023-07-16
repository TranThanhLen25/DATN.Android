package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.datnandroidquanlynhahangkhachsan.adapter.PhieuThuAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentPhieuthuBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu.PhieuThuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu.PhieuThuPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_PhieuThu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_PhieuThu extends Fragment implements PhieuThuContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<PhieuThuDTO> lsPhieuThu;
    private List<PhieuThuDTO> searchPT;

    private RecyclerView rscvPT;

    public Fragment_PhieuThu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_phieuthu.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_PhieuThu newInstance(String param1, String param2) {
        Fragment_PhieuThu fragment = new Fragment_PhieuThu();
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


        FragmentPhieuthuBinding phieuthuBinding=FragmentPhieuthuBinding.inflate(inflater,container,false);
        /// lay phieu thu
        lsPhieuThu=new ArrayList<>();
        PhieuThuPresenter phieuThuPresenter=new PhieuThuPresenter(this);
        phieuThuPresenter.LayDanhSachPhieuThu();

        //
        rscvPT=phieuthuBinding.rscvDsPhieuThu;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        rscvPT.setLayoutManager(linearLayoutManager);
        phieuthuBinding.iclSearch.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchPT=new ArrayList<>();
                if(newText.length()>0)
                {
                    for (int i=0;i< lsPhieuThu.size();i++)
                    {
                        if(lsPhieuThu.get(i).getNgayLap().toString().contains(newText)||
                       String.valueOf(lsPhieuThu.get(i).getSoTienCanThanhToan()).contains(newText)
                        )
                        {
                            searchPT.add(lsPhieuThu.get(i));
                        }
                    }

                    PhieuThuAdapter phieuThuAdapter=new PhieuThuAdapter(Fragment_PhieuThu.this);
                    phieuThuAdapter.setData(getContext(),searchPT);
                    rscvPT.setAdapter(phieuThuAdapter);
                }
                return true;
            }
        });

        return phieuthuBinding.getRoot();
    }
@Override
   public void onLayDanhSachPhieuThuSuccess(List<PhieuThuDTO> list){
        lsPhieuThu=list;
    PhieuThuAdapter phieuThuAdapter=new PhieuThuAdapter(this);
    phieuThuAdapter.setData(getContext(),lsPhieuThu);
    rscvPT.setAdapter(phieuThuAdapter);
    // Đảo ngược thứ tự của tập dữ liệu
    Collections.reverse(lsPhieuThu);
    // Thông báo cho adapter về các thay đổi trong tập dữ liệu
    phieuThuAdapter.notifyDataSetChanged();
}

    @Override
    public  void onLayDanhSachPhieuThuError(String error){}

    //thêm phiếu đặt phòng
    @Override
    public  void onThemPhieuThuSuccess(){}

    @Override
    public void onThemPhieuThuError(String error){}
}