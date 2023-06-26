package com.example.datnandroidquanlynhahangkhachsan;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.datnandroidquanlynhahangkhachsan.databinding.FragmentDoanhthuBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.DieuKienLocPhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatChiTietDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieuxuat.PhieuXuatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatConTract;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatPresenter;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_doanhthu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_doanhthu extends Fragment implements PhieuXuatConTract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<PhieuXuatDTO> lsPhieuXuat;
    private FragmentDoanhthuBinding doanhthuBinding;


    public Fragment_doanhthu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_quanlykho.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_doanhthu newInstance(String param1, String param2) {
        Fragment_doanhthu fragment = new Fragment_doanhthu();
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

        doanhthuBinding = FragmentDoanhthuBinding.inflate(inflater, container, false);
        lsPhieuXuat = new ArrayList<>();

        if (doanhthuBinding.tatca.isChecked() == true) {
            PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
            DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
            dieuKienLocPhieuXuatDTO.setSoChungTu("P");
            phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
        } else if (doanhthuBinding.KS.isChecked() == true) {
            PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
            DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
            dieuKienLocPhieuXuatDTO.setSoChungTu("PX");
            phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
        } else {

            PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
            DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
            dieuKienLocPhieuXuatDTO.setSoChungTu("PB");
            phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
        }


        doanhthuBinding.KS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
            }
        });
        doanhthuBinding.tatca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
            }
        });
        doanhthuBinding.NH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
            }
        });


        // Inflate the layout for this fragment
        return doanhthuBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        lsPhieuXuat = new ArrayList<>();

        if (doanhthuBinding.tatca.isChecked() == true) {
            PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
            DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
            dieuKienLocPhieuXuatDTO.setSoChungTu("P");
            phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
        } else if (doanhthuBinding.KS.isChecked() == true) {
            PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
            DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
            dieuKienLocPhieuXuatDTO.setSoChungTu("PX");
            phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
        } else {

            PhieuXuatPresenter phieuXuatPresenter = new PhieuXuatPresenter(this);
            DieuKienLocPhieuXuatDTO dieuKienLocPhieuXuatDTO = new DieuKienLocPhieuXuatDTO();
            dieuKienLocPhieuXuatDTO.setSoChungTu("PB");
            phieuXuatPresenter.LayDanhSachPhieuXuat(dieuKienLocPhieuXuatDTO);
        }

    }

    @Override
    public void onLayDanhSachPhieuXuatSuccess(List<PhieuXuatDTO> list) {
        lsPhieuXuat = list;

        ArrayList<BarEntry> doanhthu = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        float tien1 = 0f;
        float tien2 = 0f;
        float tien3 = 0f;
        float tien4 = 0f;
        float tien5 = 0f;
        float tien6 = 0f;
        float tien7 = 0f;
        float tien8 = 0f;
        float tien9 = 0f;
        float tien10 = 0f;
        float tien11 = 0f;
        float tien12 = 0f;

        for (int i = 0; i < lsPhieuXuat.size(); i++) {
            //// lấy tháng ra
            String day = dateFormat.format(lsPhieuXuat.get(i).getNgayLap());
            LocalDate localDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int month = localDate.getMonthValue();
            if (month == 1) {
                tien1 = tien1 + lsPhieuXuat.get(i).getTongThanhTien();

            }
            if (month == 2) {
                tien2 = tien2 + lsPhieuXuat.get(i).getTongThanhTien();

            }
            if (month == 3) {
                tien3 = tien3 + lsPhieuXuat.get(i).getTongThanhTien();

            }
            if (month == 4) {
                tien4 = tien4 + lsPhieuXuat.get(i).getTongThanhTien();

            }

            if (month == 5) {
                tien5 = tien5 + lsPhieuXuat.get(i).getTongThanhTien();

            }

            if (month == 6) {
                tien6 = tien6 + lsPhieuXuat.get(i).getTongThanhTien();

            }
            if (month == 7) {
                tien7 = tien7 + lsPhieuXuat.get(i).getTongThanhTien();


            }
            if (month == 8) {
                tien8 = tien8 + lsPhieuXuat.get(i).getTongThanhTien();

            }
            if (month == 9) {
                tien9 = tien9 + lsPhieuXuat.get(i).getTongThanhTien();

            }
            if (month == 10) {
                tien10 = tien10 + lsPhieuXuat.get(i).getTongThanhTien();

            }
            if (month == 11) {
                tien11 = tien11 + lsPhieuXuat.get(i).getTongThanhTien();

            }
            if (month == 12) {
                tien12 = tien12 + lsPhieuXuat.get(i).getTongThanhTien();

            }

        }
//// thêm dữ liệu vào list
        doanhthu.add(new BarEntry(1, tien1 / 1000000));
        doanhthu.add(new BarEntry(2, tien2 / 1000000));
        doanhthu.add(new BarEntry(3, tien3 / 1000000));
        doanhthu.add(new BarEntry(4, tien4 / 1000000));
        doanhthu.add(new BarEntry(5, tien5 / 1000000));
        doanhthu.add(new BarEntry(6, tien6 / 1000000));
        doanhthu.add(new BarEntry(7, tien7 / 1000000));
        doanhthu.add(new BarEntry(8, tien8 / 1000000));
        doanhthu.add(new BarEntry(9, tien9 / 1000000));
        doanhthu.add(new BarEntry(10, tien10 / 1000000));
        doanhthu.add(new BarEntry(11, tien11 / 1000000));
        doanhthu.add(new BarEntry(12, tien12 / 1000000));


/// chú thích, tạo dữ liệu cho biểu đồ
        BarDataSet barDataSet = new BarDataSet(doanhthu, "triệu đồng");
//// xét theo radiobutton
        if (doanhthuBinding.tatca.isChecked() == true) {
            barDataSet.setColor(ColorTemplate.MATERIAL_COLORS[3]);
        } else if (doanhthuBinding.KS.isChecked() == true) {
            barDataSet.setColor(ColorTemplate.MATERIAL_COLORS[0]);
        } else {
            barDataSet.setColor(ColorTemplate.MATERIAL_COLORS[1]);
        }


/// màu chữ chú thích
        barDataSet.setValueTextColor(Color.BLACK);
// size chú thích
        barDataSet.setValueTextSize(12f);
/// tạo dữ liệu theo Bardateset
        BarData barData = new BarData(barDataSet);

        doanhthuBinding.barchart.setFitBars(true);
        doanhthuBinding.barchart.setData(barData);

        //// trục X
        doanhthuBinding.barchart.getDescription().setText("Tháng");
/// định dạng trục X
        XAxis xAxis = doanhthuBinding.barchart.getXAxis();
        xAxis.setAxisMinimum(0f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);

//// định dạng trục y và tắt trục y bên phải
        YAxis yAxis = doanhthuBinding.barchart.getAxisRight();
        yAxis.setEnabled(false);
        doanhthuBinding.barchart.getDescription().setTextSize(12f);

        /// hiệu ứng xuất hiện
        doanhthuBinding.barchart.animateY(2000);
        doanhthuBinding.barchart.invalidate();


    }


    @Override
    public void onThemPhieuXuatSuccess() {
    }

    @Override
    public void onThemPhieuXuatError(String error) {
    }

    @Override
    public void onThemPhieuXuatChiTietSuccess() {
    }

    @Override
    public void onThemPhieuXuatChiTietError(String error) {
    }


    @Override
    public void onLayDanhSachPhieuXuatError(String error) {
    }

    @Override
    public void onLayDanhSachPhieuXuatChiTietSuccess(List<PhieuXuatChiTietDTO> list) {
    }

    @Override
    public void onLayDanhSachPhieuXuatChiTietError(String error) {
    }

    @Override
    public void onCapNhatPXSuccess() {
    }

    @Override
    public void onCapNhatPXError(String error) {
    }
}