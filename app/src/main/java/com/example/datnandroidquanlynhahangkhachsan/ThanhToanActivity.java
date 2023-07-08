package com.example.datnandroidquanlynhahangkhachsan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThanhToanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuThuDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu.PhieuThuContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.PhieuThu.PhieuThuPresenter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThanhToanActivity extends AppCompatActivity implements PhieuThuContract.View {
    private Long tienThoi;
    private int tienDua;
    private List<PhieuThuDTO> lsPhieuThu;
    private PhieuThuDTO phieuThuDTO;
    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = Calendar.getInstance().getTime();
    String today = formatter.format(date);

    float dua;
    float thoi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThanhToanBinding thanhToanBinding = ActivityThanhToanBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("GET_PHONGID", MODE_PRIVATE);
        thanhToanBinding.tvTendata.setText(sharedPreferences.getString("TEN", ""));

        lsPhieuThu = new ArrayList<>();
        PhieuThuPresenter phieuThuPresenter = new PhieuThuPresenter(this);
        phieuThuPresenter.LayDanhSachPhieuThu();

        thanhToanBinding.toolbarThanhtoan.icBack.setVisibility(View.GONE);


        DecimalFormat decimalFormat = new DecimalFormat("#,##0");

        Long tienTT = sharedPreferences.getLong("TT_NGAY", 0L) + sharedPreferences.getLong("TT_DV", 0L);
        thanhToanBinding.etThanhtoan.setText(String.valueOf(decimalFormat.format(tienTT)) + " đồng");
        thanhToanBinding.tvNgaylap.setText(today);




        thanhToanBinding.etDua.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //// tính tiền thừa khi khác đưa dư

                if (thanhToanBinding.etDua.getText().length()==0)
                {

                    thanhToanBinding.tvThoinew.setText(String.valueOf(decimalFormat.format(0))+" đồng");
                    thoi=0;

                } else
                {
                    Long a = Long.parseLong(charSequence.toString());
                    Long chage = a - tienTT;
                    thanhToanBinding.tvThoinew.setText(String.valueOf(decimalFormat.format(chage))+" đồng");
                    thoi=Float.valueOf(String.valueOf(chage));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        thanhToanBinding.btnThanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(thanhToanBinding.etDua.getText().length()>0)
                {
                    dua= Float.valueOf( thanhToanBinding.etDua.getText().toString());
                }
                else
                {
                    dua=0f;
                }

                if(dua < tienTT)
                {
                    Toast.makeText(ThanhToanActivity.this, "Vui lòng thanh toán đủ tiền!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    phieuThuDTO = new PhieuThuDTO(
                            "PT" + (lsPhieuThu.size() + 1),
                            date,
                            tienTT,
                            dua,
                            thoi,
                            "Tiền mặt",
                            "",
                            sharedPreferences.getLong("PNID", 0L),
                            thanhToanBinding.etGhichu.getText().toString()
                    );
                    phieuThuPresenter.ThemPhieuThu(phieuThuDTO);
                    onBackPressed();
                    onBackPressed();
                    finish();
                }



            }
        });

        setContentView(thanhToanBinding.getRoot());
    }


    @Override
    public void onLayDanhSachPhieuThuSuccess(List<PhieuThuDTO> list) {
        lsPhieuThu = list;
        TextView sct = findViewById(R.id.tv_sochungtutt);
        sct.setText(String.valueOf("PTT" + lsPhieuThu.size()));
    }

    @Override
    public void onLayDanhSachPhieuThuError(String error) {
    }

    //thêm phiếu đặt phòng
    @Override
    public void onThemPhieuThuSuccess() {
    }

    @Override
    public void onThemPhieuThuError(String error) {
    }
}