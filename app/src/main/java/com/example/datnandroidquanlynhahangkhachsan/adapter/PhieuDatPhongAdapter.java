package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhieuDatPhong;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuDat;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuDatPhongAdapter extends RecyclerView.Adapter<PhieuDatPhongAdapter.PhieuDatPhongViewHolder> {
    private List<PhieuDat> lsPhieuDat;
    private AppUtils ac;

    public PhieuDatPhongAdapter(List<PhieuDat> lsPhieuDat) {
        this.lsPhieuDat = lsPhieuDat;
    }

    public PhieuDatPhongAdapter(Fragment_dsPhieuDatPhong fragment_dsPhieuDatPhong) {
    }

    @NonNull
    @Override
    public PhieuDatPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phieudatphong, parent, false);
        return new PhieuDatPhongViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuDatPhongViewHolder holder, int position) {
        PhieuDat PhieuDat = lsPhieuDat.get((position));
        if (PhieuDat == null) {
            return;
        }
        holder.tvtenkhachhangphieudatphongdata.setText(String.valueOf(PhieuDat.getTrangThai()));
        holder.tvsdtitemphieudatphongdata.setText(String.valueOf(PhieuDat.getGhiChu()));
        holder.tvsochungtuphieudatphongdata.setText(PhieuDat.getSoChungTu());
//        SimpleDateFormat day1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        holder.tvthoigianlapphieuitemphieudatphongdata.setText(String.valueOf(day1.format(PhieuDat.getNgayLap())));
        holder.tvthoigianlapphieuitemphieudatphongdata.setText(ac.formatDateToString(PhieuDat.getNgayLap(),"dd/MM/yyyy HH:mm:ss"));
        holder.tvphongitemphieudatphongdata.setText(String.valueOf(PhieuDat.getKhachHangID()));
    }

    @Override
    public int getItemCount() {
        if ((lsPhieuDat != null)) {
            return lsPhieuDat.size();
        }
        return 0;
    }

    class PhieuDatPhongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvtenkhachhangphieudatphongdata,
                tvsochungtuphieudatphongdata,
                tvsdtitemphieudatphongdata,
                tvthoigianlapphieuitemphieudatphongdata,
                tvphongitemphieudatphongdata;

        public PhieuDatPhongViewHolder(@NonNull View itemView) {

            super(itemView);
            tvtenkhachhangphieudatphongdata = itemView.findViewById(R.id.tv_tenkhachhang_phieudatphong_data);
            tvsochungtuphieudatphongdata = itemView.findViewById(R.id.tv_sochungtu_phieudatphong_data);
            tvsdtitemphieudatphongdata = itemView.findViewById(R.id.tv_sdt_itemphieudatphong_data);
            tvthoigianlapphieuitemphieudatphongdata = itemView.findViewById(R.id.tv_thoigianlapphieu_itemphieudatphong_data);
            tvphongitemphieudatphongdata = itemView.findViewById(R.id.tv_phong_itemphieudatphong_data);
        }
    }
}
