package com.example.datnandroidquanlynhahangkhachsan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ActivityThemHangHoaBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.Menu.HangHoaPresenter;

import java.util.List;

public class ActivityThemHangHoa extends AppCompatActivity implements HangHoaContract.View {
    private String[] item = {"Gọi món", "Dịch vụ", "Đồ uống"};
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter<String> stringArrayAdapter;
    private ActivityThemHangHoaBinding activityThemHangHoaBinding;
    private HangHoaDTO hangHoaDTO;
    private String nhomHangHoa = "";
    private HangHoaPresenter hangHoaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityThemHangHoaBinding = ActivityThemHangHoaBinding.inflate(getLayoutInflater());
        setContentView(activityThemHangHoaBinding.getRoot());

        hangHoaDTO = new HangHoaDTO();
        hangHoaPresenter = new HangHoaPresenter(this);

        autoCompleteTextView = activityThemHangHoaBinding.autoComplete;
        stringArrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, item);
        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                nhomHangHoa = item;
                Toast.makeText(ActivityThemHangHoa.this, "Item: " + item, Toast.LENGTH_LONG).show();
            }
        });
        activityThemHangHoaBinding.toolbarPhieudatban.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        activityThemHangHoaBinding.btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickThemHangHoa();
            }
        });
    }

    private void onclickThemHangHoa() {
        if (activityThemHangHoaBinding.etTenhanghoa.length() == 0
                || activityThemHangHoaBinding.etMahanghoa.length() == 0
                || activityThemHangHoaBinding.etDongia.length() == 0
                || nhomHangHoa == "") {
            Toast.makeText(ActivityThemHangHoa.this, "vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
        } else {
            hangHoaDTO.setTenHangHoa(String.valueOf(activityThemHangHoaBinding.etTenhanghoa.getText()));
            hangHoaDTO.setMaHangHoa(String.valueOf(activityThemHangHoaBinding.etMahanghoa.getText()));
            hangHoaDTO.setDonGia(Integer.valueOf(String.valueOf(activityThemHangHoaBinding.etDongia.getText())));
            hangHoaDTO.setTrangThai("Đang kinh doanh");
            hangHoaDTO.setNhomHangHoa(nhomHangHoa);
            hangHoaPresenter.themHangHoa(hangHoaDTO);
            onBackPressed();
        }
    }

    @Override
    public void onLayDanhSachHangHoaSuccess(List<HangHoaDTO> list) {

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
}