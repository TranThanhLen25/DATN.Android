package com.example.datnandroidquanlynhahangkhachsan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Toolbar_Drawer_Activity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_drawer);
        navigationView = (NavigationView) findViewById(R.id.Nav_Draw);

        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.dra_open, R.string.dra_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        // nút trở về
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportFragmentManager().beginTransaction().replace(R.id.fra_draw,new Fragment_trangchu()).commit();
        navigationView.setCheckedItem(R.id.dra_trangchu);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            Fragment temp;

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
                        Toast.makeText(getApplicationContext(), "Đăng xuất", Toast.LENGTH_LONG).show();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fra_draw, temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });




    }

}