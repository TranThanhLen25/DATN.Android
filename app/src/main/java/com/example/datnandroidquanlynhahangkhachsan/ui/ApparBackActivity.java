package com.example.datnandroidquanlynhahangkhachsan.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsLichSu;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhieuDatPhong;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhieuNhanPhong;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhong;
import com.example.datnandroidquanlynhahangkhachsan.Fragment_trangchu;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.Toolbar_Drawer_Activity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityMainBinding;

public class ApparBackActivity extends AppCompatActivity {


    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appar_back);

        btn_back = (Button) findViewById(R.id.ic_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}