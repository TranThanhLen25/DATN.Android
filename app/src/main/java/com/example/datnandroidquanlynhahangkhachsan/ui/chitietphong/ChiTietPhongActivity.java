package com.example.datnandroidquanlynhahangkhachsan.ui.chitietphong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.adapter.MenuAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChiTietPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.DanhSachMenuActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.MenuDichVuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.MenuDichVuPresenter;

import java.util.ArrayList;
import java.util.List;

public class ChiTietPhongActivity extends AppCompatActivity implements MenuDichVuContract.View, ItemTouchHelperListener {
    private RecyclerView rscvDichVu;
    private List<DichVu> lsdichvu;
    private List<DichVuDTO> dichVuDTOList;
    private List<HangHoaDTO> hangHoaDTOList;
    private MenuAdapter menuAdapter;
    private ActivityChiTietPhongBinding ChiTietPhongBinding;
    private MenuDichVuPresenter menuDichVuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_chi_tiet_phong);

        ChiTietPhongBinding = ChiTietPhongBinding.inflate(getLayoutInflater());
        setContentView(ChiTietPhongBinding.getRoot());

        ChiTietPhongBinding.toolbarChitietphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempData.lsDichVu.clear();
                onBackPressed();
            }
        });
        ChiTietPhongBinding.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietPhongActivity.this, DanhSachMenuActivity.class);
                startActivity(intent);
            }
        });
        ChiTietPhongBinding.btnLuuChitietphong.setOnClickListener(view -> onBackPressed());

        rscvDichVu = findViewById(R.id.rscv_dichvu);

        //khởi tạo danh sách menu
        tempData.lsDichVu = new ArrayList<>();

        //thêm dữ liệu dịch vụ
        lsdichvu = new ArrayList<>();
        if (tempData.lsDichVu.size()>0){
            for (int i=0;i<tempData.lsDichVu.size();i++){
                DichVu dv1 = new DichVu("dv"+tempData.lsDichVu.get(i), "1", "1", "1");
                lsdichvu.add(dv1);
            }
        }

        //lấy dữ liệu hàng hóa
        menuDichVuPresenter = new MenuDichVuPresenter(this);
        menuDichVuPresenter.LayDanhSachHangHoa2("");

        menuAdapter = new MenuAdapter(lsdichvu);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        rscvDichVu.setLayoutManager(LinearLayoutManager);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rscvDichVu.addItemDecoration(decoration);
        rscvDichVu.setAdapter(menuAdapter);

        ItemTouchHelper.Callback callback = new RecycleViewItemTouchHelper(this);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(rscvDichVu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lsdichvu.clear();
        for (int i=0;i<tempData.lsDichVu.size();i++){
            for (int j=0;j<lsdichvu.size();j++){
                if (lsdichvu.get(j).get)
            }
            DichVu dv1 = new DichVu("dv"+tempData.lsDichVu.get(i), "1", "1", "1");
            lsdichvu.add(dv1);
        }
        menuAdapter = new MenuAdapter(lsdichvu);
        rscvDichVu.setAdapter(menuAdapter);
    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        hangHoaDTOList = list;
    }

    @Override
    public void onLayDanhSachHangHoaError(String error) {

    }


    @Override
    public void itemTouchOnMove(int oldposition, int newPosition) {
        //lsdichvu.add(newPosition, lsdichvu.remove(oldposition));
        //menuAdapter.notifyItemMoved(oldposition, newPosition);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int position) {
//        String menuDelete = lsdichvu.get(viewHolder.getAdapterPosition()).getTenHangHoa();
//        DichVu dichVu = lsdichvu.get(viewHolder.getAdapterPosition());
//        int indexDelete = viewHolder.getAdapterPosition();
        menuAdapter.removeItem(viewHolder.getAdapterPosition());
    }
}