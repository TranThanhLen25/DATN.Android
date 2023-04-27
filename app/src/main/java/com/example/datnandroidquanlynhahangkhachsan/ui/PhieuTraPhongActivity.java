package com.example.datnandroidquanlynhahangkhachsan.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;

import java.util.List;

public class PhieuTraPhongActivity extends AppCompatActivity {
private List<PhieuNhanDTO> phieuNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThemphieutraphongBinding phieuTraPhongBinding=ActivityThemphieutraphongBinding.inflate(getLayoutInflater());

        setContentView(phieuTraPhongBinding.getRoot());
    }
}