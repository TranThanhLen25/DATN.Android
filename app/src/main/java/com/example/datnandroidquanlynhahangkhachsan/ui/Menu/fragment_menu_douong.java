package com.example.datnandroidquanlynhahangkhachsan.ui.Menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.adapter.HangHoaAdapter;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_menu_douong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_menu_douong extends Fragment implements HangHoaContract.View {
    private RecyclerView rscvHangHoaDoUong;
    private List<HangHoaDTO> lsHangHoa;
    private HangHoaAdapter hangHoaAdapter;
    private HangHoaPresenter hangHoaPresenter;

    // TODO: Rename parameter arguments, choose names that match
   // // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_menu_douong() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_menu_douong.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_menu_douong newInstance(String param1, String param2) {
        fragment_menu_douong fragment = new fragment_menu_douong();
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
        //return inflater.inflate(R.layout.fragment_menu_douong, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_menu_douong, container, false);

        rscvHangHoaDoUong = view.findViewById(R.id.rscv_hanghoa_douong);
        lsHangHoa = new ArrayList<>();
        Date day = Calendar.getInstance().getTime();
        hangHoaPresenter = new HangHoaPresenter(this);
        hangHoaPresenter.LayDanhSachHangHoa2("Đồ uống");
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this.getActivity());
        rscvHangHoaDoUong.setLayoutManager(LinearLayoutManager);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this.getActivity(), DividerItemDecoration.VERTICAL);
        rscvHangHoaDoUong.addItemDecoration(decoration);
        return view;
    }

    @Override

    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        lsHangHoa = list;
        hangHoaAdapter = new HangHoaAdapter(this);
        hangHoaAdapter.setData(getContext(), lsHangHoa);
        rscvHangHoaDoUong.setAdapter(hangHoaAdapter);
    }

    @Override
    public void onLayDanhSachHangHoaError(String error) {
        Toast.makeText(getContext(), "Lay du lieu that bai", Toast.LENGTH_LONG).show();
    }
}