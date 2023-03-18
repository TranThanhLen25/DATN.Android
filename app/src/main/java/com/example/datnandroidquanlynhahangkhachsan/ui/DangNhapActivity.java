package com.example.datnandroidquanlynhahangkhachsan.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.datnandroidquanlynhahangkhachsan.MainActivity;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.Toolbar_Drawer_Activity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityMainBinding;

public class DangNhapActivity extends AppCompatActivity {
    ActivityMainBinding binding;

Button btnDN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        btnDN=(Button)findViewById(R.id.btn_dangnhap);
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DangNhapActivity.this, Toolbar_Drawer_Activity.class);
                startActivity(intent);
            }
        });

    }
}