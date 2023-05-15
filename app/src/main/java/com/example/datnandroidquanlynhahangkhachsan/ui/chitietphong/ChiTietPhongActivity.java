package com.example.datnandroidquanlynhahangkhachsan.ui.chitietphong;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.model.DichVu;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.DanhSachMenuActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.MenuDichVuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.MenuDichVuPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhongActivity extends AppCompatActivity implements MenuDichVuContract.View, ItemTouchHelperListener, PhongContract.View, LoaiPhongContract.View {
    private RecyclerView rscvDichVu;
    private List<DichVu> lsdichvu;
    private List<DichVuDTO> dichVuDTOList;
    private List<HangHoaDTO> hangHoaDTOList;
    private List<PhongDTO> lsPhong;
    private List<LoaiPhongDTO> lsLoaiPhong;
    private MenuAdapter menuAdapter;
    private ActivityChiTietPhongBinding ChiTietPhongBinding;
    private MenuDichVuPresenter menuDichVuPresenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phong);

        ChiTietPhongBinding = ChiTietPhongBinding.inflate(getLayoutInflater());


        LoaiPhongPresenter loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();

        PhongPresenter phongPresenter = new PhongPresenter(this);
        phongPresenter.LayDanhSachPhong();


        ////gán thông tin vào textVIEW
        sharedPreferences=getSharedPreferences("PHONG",MODE_PRIVATE);
       ChiTietPhongBinding.tvLoaiphongchitiet.setText(sharedPreferences.getString("LOAIPHONG",""));
       ChiTietPhongBinding.tvSo.setText(String.valueOf(sharedPreferences.getInt("SOPHONG", 0))  );

        //// format lại giá tiền
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        String formattedNumber = decimalFormat.format(sharedPreferences.getInt("GIA", 0));
         ChiTietPhongBinding.tvGiachitiet.setText(formattedNumber+ " đồng");



        ChiTietPhongBinding.toolbarChitietphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// xóa thông tin phòng khi thoát
                SharedPreferences sharedPreferences = getSharedPreferences("PHONG", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
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
        setContentView(ChiTietPhongBinding.getRoot());
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


    @Override
    public void onLayLoaiPhongSuccess(List<LoaiPhongDTO> list) {

        lsLoaiPhong = list;
    }

    @Override
    public void onLayLoaiPhongError(String error) {
    }

    @Override
    public void onLayDanhSachPhongSuccess(List<PhongDTO> list) {
        lsPhong = list;
    }

    @Override
    public void onLayDanhSachPhongError(String error) {
    }

    @Override
    public void onLayDanhSachPhong1gSuccess(List<PhongDTO> list) {
    }

    @Override
    public void onLayDanhSachPhong1gError(String error) {
    }

    @Override
    public void onCapNhatTrangThaiPhongSuccess() {
    }

    @Override
    public void onCapNhatTrangThaiPhongError(String error) {
    }
}