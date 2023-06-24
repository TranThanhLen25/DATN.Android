package com.example.datnandroidquanlynhahangkhachsan;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.DangNhapActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.List;


public class Toolbar_Drawer_Activity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private MenuItem selectedItem;

    private Menu menu;
    private MenuItem vitri;

    private List<NguoiDungDTO> lsNguoiDung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_drawer);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.Nav_Draw);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.dra_open, R.string.dra_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        SharedPreferences sharedPreferences=getSharedPreferences("NGUOI_DUNG",MODE_PRIVATE);
        ////gán thông tin vào header
        View hearder=navigationView.inflateHeaderView(R.layout.draw_header);
        TextView tvTen=hearder.findViewById(R.id.tv_avt);
        TextView tvVitri=hearder.findViewById(R.id.tv_vitri);
        tvTen.setText(sharedPreferences.getString("TENNGUOIDUNG",""));
        tvVitri.setText(sharedPreferences.getString("LOAITAIKHOAN",""));




        getSupportFragmentManager().beginTransaction().replace(R.id.fra_draw, new Fragment_trangchu()).commit();
        navigationView.setCheckedItem(R.id.dra_trangchu);
        /// xét màu cho item trang chủ khi mới đăng nhập vào
        menu = navigationView.getMenu();
        MenuItem menuItem = menu.findItem(R.id.dra_trangchu);
        menuItem.setChecked(true);

        MenuItem dra_nhanVien=menu.findItem(R.id.dra_nhanvien);
        MenuItem dra_thongke=menu.findItem(R.id.dra_thongke);
        if(sharedPreferences.getString("LOAITAIKHOAN","").equals("Nhân viên lễ tân"))
        {
            dra_nhanVien.setVisible(false);
            dra_thongke.setVisible(false);
        }




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {





            ///cho đăng xuất khi vừa mới đăng nhập
            Fragment temp = new Fragment_trangchu();
            int vitri = R.id.dra_trangchu;

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();


                // chọn vào item logout k sáng
                if (id == R.id.dra_dangxuat) {
                    MenuItem m = menu.findItem(R.id.dra_dangxuat);
                    m.setChecked(false);
                    DiaLogout();
                    // màn hình đang chọn vẫn sáng khi chọn đăng xuất
                    MenuItem setLogout = menu.findItem(vitri);
                    setLogout.setChecked(true);
                }
                // kiểm tra item nào được chọn để xét màu cho item
                if (id != R.id.dra_dangxuat) {
                    if (selectedItem != null) {
                        selectedItem.setChecked(false);
                    }
                    selectedItem = item;
                    selectedItem.setChecked(true);
                }


                switch (id) {
                    case R.id.dra_trangchu:

                        temp = new Fragment_trangchu();
                        menuItem.setChecked(true);
                        vitri = R.id.dra_trangchu;
                        break;
                    case R.id.dra_nhaphang:
                        temp = new FragmentKhachHang();
                        menuItem.setChecked(false);

                        vitri = R.id.dra_nhaphang;
                        break;
                    case R.id.dra_kho:
                        temp = new Fragment_quanlykho();
                        menuItem.setChecked(false);
                        vitri = R.id.dra_kho;
                        break;
                    case R.id.dra_thongke:
                        temp = new Fragment_QuanLyHangHoa();
                        menuItem.setChecked(false);
                        vitri = R.id.dra_thongke;
                        break;

                    case R.id.dra_nhanvien:
                        temp = new Fragment_nhanVien();
                        menuItem.setChecked(false);
                        vitri = R.id.dra_nhanvien;
                        break;


                    case R.id.dra_thongtincanhan:
                        temp = new Fragment_thongtincanhan();
                        menuItem.setChecked(false);
                        vitri = R.id.dra_thongtincanhan;
                        break;
                    case R.id.dra_dangxuat:
                        navigationView.clearFocus();
                        break;
                }


                getSupportFragmentManager().beginTransaction().replace(R.id.fra_draw, temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;


            }
        });


    }


    private void DiaLogout() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_dialog_dang_xuat);
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
                sharedPreferences = getSharedPreferences("NGUOI_DUNG", MODE_PRIVATE);
                editor = sharedPreferences.edit();
                ///xóa thông tin tài khoản mật khẩu trong bộ nhớ
                editor.clear();
                editor.apply();
                Intent intent = new Intent(Toolbar_Drawer_Activity.this, DangNhapActivity.class);
                startActivity(intent);
                dialog.dismiss();
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






}