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

        ChiTietPhongBinding.toolbarChitietphong.icBack.setOnClickListener(view -> onBackPressed());
        ChiTietPhongBinding.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietPhongActivity.this, DanhSachMenuActivity.class);
                startActivity(intent);
            }
        });
        ChiTietPhongBinding.btnLuuChitietphong.setOnClickListener(view -> onBackPressed());

        rscvDichVu = findViewById(R.id.rscv_dichvu);
        //thêm dữ liệu dịch vụ
        lsdichvu = new ArrayList<>();
        DichVu dv1 = new DichVu("dv1", "1", "1", "1");
        DichVu dv2 = new DichVu("dv2", "2", "2", "2");
        DichVu dv3 = new DichVu("dv3", "3", "3", "3");
        DichVu dv4 = new DichVu("dv4", "4", "4", "4");
        lsdichvu.add(dv1);
        lsdichvu.add(dv2);
        lsdichvu.add(dv3);
        lsdichvu.add(dv4);

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