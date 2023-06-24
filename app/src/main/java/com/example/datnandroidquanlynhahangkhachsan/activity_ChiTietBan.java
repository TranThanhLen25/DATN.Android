package com.example.datnandroidquanlynhahangkhachsan;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

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
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.ListGoiMonDTO;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class activity_ChiTietBan extends AppCompatActivity implements goiMonContract.View, HangHoaContract.View, ItemTouchHelperListener, BanContract.View {

    private RecyclerView rscvGoiMon;
    private GoiMonDTO xoaTatCaMenu;
    private List<GoiMonDTO> goiMonDTOListHienThi;
    private ListGoiMonDTO goiMonDTOListCapNhat;
    private List<HangHoaDTO> hangHoaDTOList;
    private MenuBanAdapter menuBanAdapter;
    private ActivityChiTietBanBinding activityChiTietBanBinding;
    private HangHoaPresenter hangHoaPresenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private goiMonPresenter goiMonPresenter;
    private BanDTO banDTO;
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
        hangHoaDTOList = new ArrayList<>();
        xoaTatCaMenu = new GoiMonDTO();
        banPresenter = new BanPresenter(this);
        banDTO = new BanDTO();

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
                tempData.CheckChucNang=true;
                int trangThaiID = sharedPreferences.getInt("TRANGTHAI", 0);
                if (trangThaiID == 4) {
                    tempData.CheckChucNang=true;
                    Intent intent = new Intent(activity_ChiTietBan.this, DanhSachMenuActivity.class);
                    startActivity(intent);
                }
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

        activityChiTietBanBinding.btnLuuChitietban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (goiMonDTOListHienThi.size() == 0 && xoaTatCaMenu.getHangHoaId() > 0) {
                    xoaTatCaMenu.setTrangThai("xóa tất cả");
                    goiMonDTOListHienThi.add(xoaTatCaMenu);
                }
                goiMonDTOListCapNhat = new ListGoiMonDTO(goiMonDTOListHienThi);
                goiMonPresenter.CapNhatGoiMon(goiMonDTOListCapNhat);

                //xóa menu dư khi thoát
                tempData.lsDichVu.clear();
                onBackPressed();
            }
        });
        activityChiTietBanBinding.btnBaotri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLogBaoTri();
            }
        });
    }

    private void DiaLogBaoTri() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_huy_dat_phong);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        TextView btnYes = dialog.findViewById(R.id.btn_yes);
        TextView btnNo = dialog.findViewById(R.id.btn_no);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int trangThaiID = sharedPreferences.getInt("TRANGTHAI", 0);


                if (trangThaiID != 3) {

                    banDTO.setBanId(sharedPreferences.getInt("BANID", 0));
                    banDTO.setTrangThaiId(3);
                    banPresenter.CapNhatTrangThaiBan(banDTO);


                    dialog.dismiss();
                    onBackPressed();
                } else {
                    banDTO.setBanId(sharedPreferences.getInt("BANID", 0));
                    banDTO.setTrangThaiId(1);
                    banPresenter.CapNhatTrangThaiBan(banDTO);
                    dialog.dismiss();
                    onBackPressed();
                }

            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();


            }
        });


        dialog.show();


    }

    @Override
    protected void onResume() {
        super.onResume();
        tempData.CheckChucNang=false;
        //trường hợp menu trong chi tiết phòng đã có item
        if (goiMonDTOListHienThi.size() > 0) {

            //trong trường hợp muốn xóa tất cả menu
            xoaTatCaMenu = goiMonDTOListHienThi.get(0);

            //trong gọi menu có chọn ít nhất 1 item
            if (tempData.lsDichVu.size() > 0) {
                SharedPreferences sharedPreferences = getSharedPreferences("CHITIETBAN", MODE_PRIVATE);
                int banID = sharedPreferences.getInt("BANID", 0);
                HangHoaDTO hangHoaDTO = new HangHoaDTO();

                //kiểm tra menu được gọi đã có trong list menu trong chi tiết phòng hay chưa
                //nếu đã có thì xóa trong list menu gọi và tăng menu trong chi tiết phòng thêm 1
                for (int n = 0; n < goiMonDTOListHienThi.size(); n++) {
                    for (int m = 0; m < tempData.lsDichVu.size(); m++) {
                        if (goiMonDTOListHienThi.get(n).getHangHoaId() == tempData.lsDichVu.get(m)) {
                            goiMonDTOListHienThi.get(n).setSoLuong(goiMonDTOListHienThi.get(n).getSoLuong() + 1);
                            tempData.lsDichVu.remove(m);
                        }
                    }
                }

                //sau khi đã kiểm tra trùng menu ở trên
                //thì thêm những menu chưa có trong menu chi tiết phòng vào
                for (int i = 0; i < tempData.lsDichVu.size(); i++) {
                    for (int j = 0; j < hangHoaDTOList.size(); j++) {
                        if (hangHoaDTOList.get(j).getHangHoaId() == tempData.lsDichVu.get(i)) {
                            hangHoaDTO = hangHoaDTOList.get(j);
                            break;
                        }
                    }

                    Date day = Calendar.getInstance().getTime();
                    GoiMonDTO goiMonDTO = new GoiMonDTO(banID, tempData.lsDichVu.get(i), 0, 1, 1, 1, "", "chưa thanh toán", day);
                    goiMonDTOListHienThi.add(goiMonDTO);
                    // listDichVuThem.add(dichVuDTO);
                }
                tempData.lsDichVu.clear();
                menuBanAdapter = new MenuBanAdapter(goiMonDTOListHienThi, hangHoaDTOList);
                rscvGoiMon.setAdapter(menuBanAdapter);
            } else {

            }
        } else {
            //menu chi tiết phòng đang trống

            //trường hợp trong gọi menu > 0
            if (tempData.lsDichVu.size() > 0) {
                //dichVuDTOList.clear();

                //lấy phòng id
                SharedPreferences sharedPreferences = getSharedPreferences("CHITIETBAN", MODE_PRIVATE);
                int banID = sharedPreferences.getInt("BANID", 0);

                //khởi tạo hàng hóa, tìm lấy ra đơn giá
                HangHoaDTO hangHoaDTO = new HangHoaDTO();
                for (int i = 0; i < tempData.lsDichVu.size(); i++) {
                    for (int j = 0; j < hangHoaDTOList.size(); j++) {
                        if (hangHoaDTOList.get(j).getHangHoaId() == tempData.lsDichVu.get(i)) {
                            hangHoaDTO = hangHoaDTOList.get(j);
                            break;
                        }
                    }

                    Date day = Calendar.getInstance().getTime();
                    GoiMonDTO goiMonDTO = new GoiMonDTO(banID, tempData.lsDichVu.get(i), 0, 1, 1, 1, "", "chưa thanh toán", day);
                    goiMonDTOListHienThi.add(goiMonDTO);

                }
                tempData.lsDichVu.clear();
                menuBanAdapter = new MenuBanAdapter(goiMonDTOListHienThi, hangHoaDTOList);
                rscvGoiMon.setAdapter(menuBanAdapter);
            } else {

            }
        }
        if (goiMonDTOListHienThi.size() > 0) {
            xoaTatCaMenu = goiMonDTOListHienThi.get(0);
        }
        //  Toast.makeText(this,String.valueOf(goiMonDTOListHienThi.size()), Toast.LENGTH_SHORT).show();
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
        menuBanAdapter = new MenuBanAdapter(goiMonDTOListHienThi, hangHoaDTOList);
        rscvGoiMon.setAdapter(menuBanAdapter);
        //Toast.makeText(this,String.valueOf(goiMonDTOListHienThi.size()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLayDanhSachHangHoaError(String error) {

    }

    @Override
    public void onThemHangHoaSuccess() {

    }

    @Override
    public void onThemHangHoaError(String error) {

    }

    @Override
    public void onXoaHangHoaSuccess() {

    }

    @Override
    public void onXoaHangHoaError(String error) {

    }

    @Override
    public void onCapNhatHangHoaSuccess() {

    }

    @Override
    public void onCapNhatHangHoaError(String error) {

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
        menuBanAdapter = new MenuBanAdapter(goiMonDTOListHienThi, hangHoaDTOList);
        rscvGoiMon.setAdapter(menuBanAdapter);
        //Toast.makeText(this,String.valueOf(goiMonDTOListHienThi.size()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLayDanhSachGoiMonError(String error) {

    }

    @Override
    public void onCapNhatGoiMonSuccess() {

    }

    @Override
    public void onCapNhatGoiMonError(String error) {

    }

    @Override
    public void onCapNhatGMSuccess() {
    }

    @Override
    public void onCapNhatGMError(String error) {
    }

    @Override
    public void onCapNhatTrangThaiBanSuccess() {
    }

    @Override
    public void onCapNhatTrangThaiBanError(String error) {
    }
}