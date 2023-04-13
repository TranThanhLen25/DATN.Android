package com.example.datnandroidquanlynhahangkhachsan;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityDangNhapBinding;
import com.example.datnandroidquanlynhahangkhachsan.ui.DangNhapActivity;
import com.google.android.material.navigation.NavigationView;

public class Toolbar_Drawer_Activity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ActivityDangNhapBinding dangNhapBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_drawer);
        navigationView = (NavigationView) findViewById(R.id.Nav_Draw);

        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        dangNhapBinding = ActivityDangNhapBinding.inflate(getLayoutInflater());

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.dra_open, R.string.dra_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        // nút trở về
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fra_draw,new Fragment_trangchu()).commit();
        navigationView.setCheckedItem(R.id.dra_trangchu);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            Fragment temp;
            Activity tamp;

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.dra_trangchu:
                        temp = new Fragment_trangchu();
                        break;
                    case R.id.dra_nhaphang:
                        temp = new Fragment_nhaphang();
                        break;
                    case R.id.dra_kho:
                        temp = new Fragment_quanlykho();
                        break;
                    case R.id.dra_thongke:
                        temp = new Fragment_thongke();
                        break;
                    case R.id.dra_thongtincanhan:
                        temp = new Fragment_thongtincanhan();
                        break;
                    case R.id.dra_dangxuat:
                        DiaLogout();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_draw, temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
    private void DiaLogout(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_dialog_dangxuat);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


    }


}