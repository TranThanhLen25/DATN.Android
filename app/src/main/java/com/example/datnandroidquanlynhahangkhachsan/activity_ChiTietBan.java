package com.example.datnandroidquanlynhahangkhachsan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.adapter.MenuBanAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChiTietBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Ban.BanPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.DanhSachMenuActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.chitietphong.ItemTouchHelperListener;
import com.example.datnandroidquanlynhahangkhachsan.ui.chitietphong.MyButtonClickListener;
import com.example.datnandroidquanlynhahangkhachsan.ui.chitietphong.RecycleViewItemTouchHelper;
import com.example.datnandroidquanlynhahangkhachsan.ui.goiMon.goiMonContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.goiMon.goiMonPresenter;

import java.util.ArrayList;
import java.util.List;

public class activity_ChiTietBan extends AppCompatActivity implements goiMonContract.View, HangHoaContract.View, ItemTouchHelperListener, BanContract.View {

    private RecyclerView rscvGoiMon;
    private GoiMonDTO xoaTatCaMenu;
    private List<GoiMonDTO> goiMonDTOListHienThi;
    private List<GoiMonDTO> goiMonDTOListCapNhat;
    private List<HangHoaDTO> hangHoaDTOList;
    private MenuBanAdapter menuBanAdapter;
    private ActivityChiTietBanBinding activityChiTietBanBinding;
    private HangHoaPresenter hangHoaPresenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private goiMonPresenter goiMonPresenter;
    private BanPresenter banPresenter;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityChiTietBanBinding = ActivityChiTietBanBinding.inflate(getLayoutInflater());
        setContentView(activityChiTietBanBinding.getRoot());

        goiMonDTOListHienThi = new ArrayList<>();
        goiMonDTOListCapNhat = new ArrayList<>();
        hangHoaDTOList = new ArrayList<>();
        xoaTatCaMenu = new GoiMonDTO();


        ////gán thông tin vào textVIEW
        sharedPreferences = getSharedPreferences("CHITIETBAN", MODE_PRIVATE);
        activityChiTietBanBinding.tvLoaibanchitiet.setText(String.valueOf(sharedPreferences.getString("TENLOAIBAN", "")));
        activityChiTietBanBinding.tvSo.setText(String.valueOf(sharedPreferences.getString("TENBAN", "")));


        activityChiTietBanBinding.toolbarChitietban.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xóa menu dư khi thoát
                tempData.lsDichVu.clear();
                /// xóa thông tin phòng khi thoát
                SharedPreferences sharedPreferences = getSharedPreferences("CHITIETBAN", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                onBackPressed();
            }
        });
        //khởi tạo list hàng hóa id
        tempData.lsDichVu = new ArrayList<>();

        activityChiTietBanBinding.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_ChiTietBan.this, DanhSachMenuActivity.class);
                startActivity(intent);
            }
        });
        rscvGoiMon = activityChiTietBanBinding.rscvGoimon;

        //khởi tạo list menu
        goiMonDTOListHienThi = new ArrayList<>();


        //lấy dữ liệu menu của phòng này;
        goiMonPresenter = new goiMonPresenter(this);
        GoiMonDTO goiMonDTO = new GoiMonDTO();
        SharedPreferences sharedPreferences = getSharedPreferences("CHITIETBAN", MODE_PRIVATE);
        int banID = sharedPreferences.getInt("BANID", 0);
        goiMonDTO.setBanId(banID);
        goiMonDTO.setTrangThai("chưa thanh toán");
        goiMonDTO.setGhiChu("");

        hangHoaPresenter = new HangHoaPresenter(this);

        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        rscvGoiMon.setLayoutManager(LinearLayoutManager);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rscvGoiMon.addItemDecoration(decoration);

        //lấy dữ liệu menu
        goiMonPresenter.LayDanhSachGoiMon(goiMonDTO);

        //lấy dữ liệu hàng hóa
        hangHoaPresenter.LayDanhSachHangHoa2("");


        //lấy dữ liệu menu mỗi giây//
//        handler.postDelayed(runnable = new Runnable() {
//            int count = 0;
//
//            public void run() {
//                count++;
//                handler.postDelayed(runnable, delay);
//
//                //lấy dữ liệu menu
//                goiMonPresenter.LayDanhSachGoiMon(goiMonDTO);
//
//                //lấy dữ liệu hàng hóa
//                hangHoaPresenter.LayDanhSachHangHoa2("");
//                if (count == 10) {
//                    handler.removeCallbacks(runnable);
//                }
//            }
//        }, delay);

        RecycleViewItemTouchHelper recycleViewItemTouchHelper = new RecycleViewItemTouchHelper(this, rscvGoiMon, 300) {

            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<RecycleViewItemTouchHelper.MyButton> buffer) {
                buffer.add(new MyButton(activity_ChiTietBan.this,
                        "Delete",
                        30,
                        0,
                        Color.parseColor("#FF3c30"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                //Toast.makeText(ChiTietPhongActivity.this, "Delete click", Toast.LENGTH_LONG).show();
                                int position = viewHolder.getLayoutPosition();
                                menuBanAdapter.removeItem(position);
                            }
                        }));
            }
        };
    }

    @Override
    public void onLayDanhSachBanSuccess(List<BanDTO> lsDanhSachBan) {

    }

    @Override
    public void onLayDanhSachBanError(String error) {

    }

    @Override
    public void onLayDanhSachLoaiBanSuccess(List<LoaiBanDTO> list) {

    }

    @Override
    public void onLayDanhSachLoaiBanError(String error) {

    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        hangHoaDTOList = list;
        menuBanAdapter =new MenuBanAdapter(goiMonDTOListHienThi,hangHoaDTOList);
        rscvGoiMon.setAdapter(menuBanAdapter);
        //Toast.makeText(this,String.valueOf(goiMonDTOListHienThi.size()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLayDanhSachHangHoaError(String error) {

    }

    @Override
    public void itemTouchOnMove(int oldPosition, int newPosition) {

    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int position) {

    }

    @Override
    public void onLayDanhSachGoiMonSuccess(List<GoiMonDTO> list) {
        goiMonDTOListHienThi = list;
        if (goiMonDTOListHienThi.size() > 0) {
            xoaTatCaMenu = goiMonDTOListHienThi.get(0);
        }
        menuBanAdapter =new MenuBanAdapter(goiMonDTOListHienThi,hangHoaDTOList);
        rscvGoiMon.setAdapter(menuBanAdapter);
        //Toast.makeText(this,String.valueOf(goiMonDTOListHienThi.size()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLayDanhSachGoiMonError(String error) {

    }
}