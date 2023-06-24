package com.example.datnandroidquanlynhahangkhachsan.ui.chitietphong;

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

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.adapter.MenuAdapter;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityChiTietPhongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.ListDichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.DichVu.DichVuPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.DanhSachMenuActivity;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.PhongPresenter;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.loaiphong.LoaiPhongPresenter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ChiTietPhongActivity extends AppCompatActivity implements DichVuContract.View, HangHoaContract.View, ItemTouchHelperListener, PhongContract.View, LoaiPhongContract.View {
    private RecyclerView rscvDichVu;
    private DichVuDTO xoaTatCaMenu;
    private List<DichVuDTO> dichVuDTOList;
    private List<DichVuDTO> listDichVuBanDau;
    private List<DichVuDTO> listDichVuCapNhat;
    private List<DichVuDTO> listDichVuThem;
    private ListDichVuDTO listDichVuDTO;
    private List<HangHoaDTO> hangHoaDTOList;
    private List<PhongDTO> lsPhong;
    private List<LoaiPhongDTO> lsLoaiPhong;
    private MenuAdapter menuAdapter;
    private ActivityChiTietPhongBinding ChiTietPhongBinding;
    private HangHoaPresenter hangHoaPresenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private PhongDTO phongDTO;
    private DichVuPresenter dichVuPresenter;
    private PhongPresenter phongPresenter;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChiTietPhongBinding = ChiTietPhongBinding.inflate(getLayoutInflater());
        setContentView(ChiTietPhongBinding.getRoot());


        listDichVuBanDau = new ArrayList<>();
        listDichVuCapNhat = new ArrayList<>();
        listDichVuThem = new ArrayList<>();
        xoaTatCaMenu = new DichVuDTO();
        phongDTO = new PhongDTO();


        LoaiPhongPresenter loaiPhongPresenter = new LoaiPhongPresenter(this);
        loaiPhongPresenter.LayLoaiPhong();

        phongPresenter = new PhongPresenter(this);
        phongPresenter.LayDanhSachPhong();


        ////gán thông tin vào textVIEW
        sharedPreferences = getSharedPreferences("PHONG", MODE_PRIVATE);
        ChiTietPhongBinding.tvLoaiphongchitiet.setText(sharedPreferences.getString("LOAIPHONG", ""));
        ChiTietPhongBinding.etHotenChitietphong.setText(sharedPreferences.getString("TEN", ""));
        ChiTietPhongBinding.tvSo.setText(String.valueOf(sharedPreferences.getInt("SOPHONG", 0)));

        //// format lại giá tiền
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        String formattedNumber = decimalFormat.format(sharedPreferences.getInt("GIA", 0));
        ChiTietPhongBinding.tvGiachitiet.setText(formattedNumber + " đồng");

        //chỉnh trạng thái bảo trì phòng
        ChiTietPhongBinding.btnBaotri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLogBaoTri();

            }
        });

        ChiTietPhongBinding.toolbarChitietphong.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //xóa menu dư khi thoát
                tempData.lsDichVu.clear();
                /// xóa thông tin phòng khi thoát
                SharedPreferences sharedPreferences = getSharedPreferences("PHONG", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                onBackPressed();
            }
        });

        //khởi tạo list hàng hóa id
        tempData.lsDichVu = new ArrayList<>();

            ChiTietPhongBinding.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int trangThaiID = sharedPreferences.getInt("TRANGTHAI", 0);
                if (trangThaiID == 4) {
                    tempData.CheckChucNang=true;
                    Intent intent = new Intent(ChiTietPhongActivity.this, DanhSachMenuActivity.class);
                    startActivity(intent);
                }
            }
        });


        ChiTietPhongBinding.btnLuuChitietphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //listDichVuCapNhat = dichVuDTOList;
                String test = "";
//                for (int i = 0; i < listDichVuCapNhat.size(); i++) {
//                    for (int j = 0; j < listDichVuThem.size(); j++) {
//                        if (listDichVuCapNhat.get(i).getHangHoaId() == listDichVuThem.get(j).getHangHoaId()) {
//                            listDichVuCapNhat.remove(i);
//                        }
//                    }
//                }
                //

                if (dichVuDTOList.size() == 0 && xoaTatCaMenu.getHangHoaId() > 0) {
                    xoaTatCaMenu.setTrangThai("xóa tất cả");
                    dichVuDTOList.add(xoaTatCaMenu);
                }
                listDichVuDTO = new ListDichVuDTO(dichVuDTOList);
                //dichVuPresenter.themDichVu(listDichVuDTO);
                dichVuPresenter.capNhatDichVu(listDichVuDTO);
                //   test += String.valueOf(listDichVuDTO.getListDichVuCapNhat().size());
//                test +=
//                        " 1 " + listDichVuDTO.getListDichVuCapNhat().get(0).getDichVuID() +
//                        " 2 " + listDichVuDTO.getListDichVuCapNhat().get(0).getPhongID() +
//                        " 3 " + listDichVuDTO.getListDichVuCapNhat().get(0).getHangHoaId() +
//                        " 4 " + listDichVuDTO.getListDichVuCapNhat().get(0).getPhieuNhanID() +
//                        " 5 " + listDichVuDTO.getListDichVuCapNhat().get(0).getSoLuong() +
//                        " 6 " + listDichVuDTO.getListDichVuCapNhat().get(0).getDonGia() +
//                        " 7 " + listDichVuDTO.getListDichVuCapNhat().get(0).getThanhTien() +
//                        " 8 " + listDichVuDTO.getListDichVuCapNhat().get(0).getGhiChu() +
//                        " 9 " + listDichVuDTO.getListDichVuCapNhat().get(0).getTrangThai() +
//                        " 10 " + listDichVuDTO.getListDichVuCapNhat().get(0).getThoiGian();
//                Toast.makeText(ChiTietPhongActivity.this, test, Toast.LENGTH_SHORT).show();


                //xóa menu dư khi thoát
                tempData.lsDichVu.clear();
                onBackPressed();
            }
        });

        rscvDichVu = ChiTietPhongBinding.rscvDichvu;

        //khởi tạo list menu
        dichVuDTOList = new ArrayList<>();


        //lấy dữ liệu menu của phòng này;
        dichVuPresenter = new DichVuPresenter(this);
        DichVuDTO dichVuDTO = new DichVuDTO();
        SharedPreferences sharedPreferences = getSharedPreferences("PHONG", MODE_PRIVATE);
        int phongID = sharedPreferences.getInt("PHONGID", 0);
        dichVuDTO.setPhongID(phongID);
        dichVuDTO.setTrangThai("chưa thanh toán");
        dichVuDTO.setGhiChu("");

        hangHoaPresenter = new HangHoaPresenter(this);

        //lấy dữ liệu menu
        dichVuPresenter.LayDanhSachDichVu(dichVuDTO);

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
//                dichVuPresenter.LayDanhSachDichVu(dichVuDTO);
//
//                //lấy dữ liệu hàng hóa
//                hangHoaPresenter.LayDanhSachHangHoa2("");
//                if (count == 10) {
//                    handler.removeCallbacks(runnable);
//                }
//            }
//        }, delay);


//        menuAdapter = new MenuAdapter(dichVuDTOList, hangHoaDTOList);
//        rscvDichVu.setAdapter(menuAdapter);


        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        rscvDichVu.setLayoutManager(LinearLayoutManager);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rscvDichVu.addItemDecoration(decoration);


//        ItemTouchHelper.Callback callback = new RecycleViewItemTouchHelper(this);
//        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
//        touchHelper.attachToRecyclerView(rscvDichVu);

        RecycleViewItemTouchHelper recycleViewItemTouchHelper = new RecycleViewItemTouchHelper(this, rscvDichVu, 300) {

            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<RecycleViewItemTouchHelper.MyButton> buffer) {
                buffer.add(new MyButton(ChiTietPhongActivity.this,
                        "Delete",
                        30,
                        0,
                        Color.parseColor("#FF3c30"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                //Toast.makeText(ChiTietPhongActivity.this, "Delete click", Toast.LENGTH_LONG).show();
                                int position = viewHolder.getLayoutPosition();
                                menuAdapter.removeItem(position);
                            }
                        }));
            }
        };
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
                    int phongID = sharedPreferences.getInt("PHONGID", 0);
                    phongDTO.setPhongId(phongID);
                    phongDTO.setTrangThaiId(3);
                    phongPresenter.CapNhatTrangThaiPhong(phongDTO);
                    dialog.dismiss();
                    onBackPressed();
                }
                else {
                    int phongID = sharedPreferences.getInt("PHONGID", 0);
                    phongDTO.setPhongId(phongID);
                    phongDTO.setTrangThaiId(1);
                    phongPresenter.CapNhatTrangThaiPhong(phongDTO);
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
        //trường hợp menu trong chi tiết phòng đã có item
        if (dichVuDTOList.size() > 0) {

            //trong trường hợp muốn xóa tất cả menu
            xoaTatCaMenu = dichVuDTOList.get(0);

            //trong gọi menu có chọn ít nhất 1 item
            if (tempData.lsDichVu.size() > 0) {
                SharedPreferences sharedPreferences = getSharedPreferences("PHONG", MODE_PRIVATE);
                int phongID = sharedPreferences.getInt("PHONGID", 0);
                HangHoaDTO hangHoaDTO = new HangHoaDTO();

                //kiểm tra menu được gọi đã có trong list menu trong chi tiết phòng hay chưa
                //nếu đã có thì xóa trong list menu gọi và tăng menu trong chi tiết phòng thêm 1
                for (int n = 0; n < dichVuDTOList.size(); n++) {
                    for (int m = 0; m < tempData.lsDichVu.size(); m++) {
                        if (dichVuDTOList.get(n).getHangHoaId() == tempData.lsDichVu.get(m)) {
                            dichVuDTOList.get(n).setSoLuong(dichVuDTOList.get(n).getSoLuong() + 1);
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
                    DichVuDTO dichVuDTO = new DichVuDTO(phongID, tempData.lsDichVu.get(i), 1);
                    Date day = Calendar.getInstance().getTime();
                    dichVuDTO.setDonGia(1);
                    dichVuDTO.setThanhTien(1);
                    dichVuDTO.setGhiChu("string");
                    dichVuDTO.setTrangThai("chưa thanh toán");
                    dichVuDTO.setThoiGian(day);
                    dichVuDTO.setPhieuNhanID(0);
                    dichVuDTOList.add(dichVuDTO);
                    listDichVuThem.add(dichVuDTO);
                }
                tempData.lsDichVu.clear();
                menuAdapter = new MenuAdapter(dichVuDTOList, hangHoaDTOList);
                rscvDichVu.setAdapter(menuAdapter);
            } else {

            }
        } else {
            //menu chi tiết phòng đang trống

            //trường hợp trong gọi menu > 0
            if (tempData.lsDichVu.size() > 0) {
                //dichVuDTOList.clear();

                //lấy phòng id
                SharedPreferences sharedPreferences = getSharedPreferences("PHONG", MODE_PRIVATE);
                int phongID = sharedPreferences.getInt("PHONGID", 0);

                //khởi tạo hàng hóa, tìm lấy ra đơn giá
                HangHoaDTO hangHoaDTO = new HangHoaDTO();
                for (int i = 0; i < tempData.lsDichVu.size(); i++) {
                    for (int j = 0; j < hangHoaDTOList.size(); j++) {
                        if (hangHoaDTOList.get(j).getHangHoaId() == tempData.lsDichVu.get(i)) {
                            hangHoaDTO = hangHoaDTOList.get(j);
                            break;
                        }
                    }

                    //thêm hàng hóa vào menu trong chi tiết phòng
                    DichVuDTO dichVuDTO = new DichVuDTO(phongID, tempData.lsDichVu.get(i), 1);
                    dichVuDTOList.add(dichVuDTO);

                    Date day = Calendar.getInstance().getTime();
                    dichVuDTO.setDonGia(1);
                    dichVuDTO.setThanhTien(1);
                    dichVuDTO.setGhiChu("string");
                    dichVuDTO.setTrangThai("chưa thanh toán");
                    dichVuDTO.setThoiGian(day);
                    dichVuDTO.setPhieuNhanID(0);
                    listDichVuThem.add(dichVuDTO);
                }
                tempData.lsDichVu.clear();
                menuAdapter = new MenuAdapter(dichVuDTOList, hangHoaDTOList);
                rscvDichVu.setAdapter(menuAdapter);
            } else {

            }
        }
        if (dichVuDTOList.size() > 0) {
            xoaTatCaMenu = dichVuDTOList.get(0);
        }
    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {
        hangHoaDTOList = list;
        menuAdapter = new MenuAdapter(dichVuDTOList, hangHoaDTOList);
        rscvDichVu.setAdapter(menuAdapter);
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
    public void itemTouchOnMove(int oldposition, int newPosition) {
        //lsdichvu.add(newPosition, lsdichvu.remove(oldposition));
        //menuAdapter.notifyItemMoved(oldposition, newPosition);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int position) {
        //menuAdapter.removeItem(viewHolder.getAdapterPosition());
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

    @Override
    public void onLayDanhSachDichVuSuccess(List<DichVuDTO> list) {
        dichVuDTOList = list;
        if (dichVuDTOList.size() > 0) {
            xoaTatCaMenu = dichVuDTOList.get(0);
        }
//        listDichVuBanDau = dichVuDTOList;
        menuAdapter = new MenuAdapter(dichVuDTOList, hangHoaDTOList);
        rscvDichVu.setAdapter(menuAdapter);
    }

    @Override
    public void onLayDanhSachDichVuError(String error) {

    }

    @Override
    public void onthemDichVuSuccess() {
        //  Toast.makeText(ChiTietPhongActivity.this, "thêm dịch vụ thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onthemDichVuError(String error) {
        //  Toast.makeText(ChiTietPhongActivity.this, "thêm dịch vụ thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void oncapNhatDichVuSuccess() {
        // Toast.makeText(ChiTietPhongActivity.this, "cập nhật dịch vụ thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void oncapNhatDichVuError(String error) {
        // Toast.makeText(ChiTietPhongActivity.this, "cập nhật dịch vụ thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLayDvPnSuccess(List<DichVuDTO> list) {
    }

    @Override
    public void onLayDvPnError(String error) {
    }

    @Override
    public void onCapNhatDVSuccess() {
    }

    @Override
    public void onCapNhatDVError(String error) {
    }
}