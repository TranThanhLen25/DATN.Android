package com.example.datnandroidquanlynhahangkhachsan;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemphieudatphongBinding;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class themphieudatphong_activity extends AppCompatActivity {
    private ActivityThemphieudatphongBinding activityThemphieudatphongBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThemphieudatphongBinding = activityThemphieudatphongBinding.inflate(getLayoutInflater());
        setContentView(activityThemphieudatphongBinding.getRoot());
        activityThemphieudatphongBinding.BtnScanQRPhieudatphong.setOnClickListener(view -> {
            ScanOptions options=new ScanOptions();
            options.setCaptureActivity(CaptureAct.class);
            barLaucher.launch(options);
        });
    }
    ActivityResultLauncher<ScanOptions> barLaucher=registerForActivityResult(new ScanContract(), result -> {
        if ((result.getContents()!=null))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(themphieudatphong_activity.this);
            builder.setTitle("Dữ liệu");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String a= result.getContents().toString();
                    String[] c=a.split("\\|");
                    String HoTen = c[0];
                    String CCCD = c[2];
                    activityThemphieudatphongBinding.etCccdPhieudatphong.setText(HoTen);
                    activityThemphieudatphongBinding.etHotenPhieudatphong.setText(CCCD);
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });
}