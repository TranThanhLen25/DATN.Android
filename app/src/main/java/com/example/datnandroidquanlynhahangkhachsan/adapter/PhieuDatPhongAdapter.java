package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.model.KhachHang;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuDat;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuDatPhongChiTiet;
import com.example.datnandroidquanlynhahangkhachsan.model.Phong;

import java.util.List;

public class PhieuDatPhongAdapter extends RecyclerView.Adapter<PhieuDatPhongAdapter.PhieuDatPhongViewHolder> {
    private List<PhieuDat> lsPhieuDat;
    private List<PhieuDatPhongChiTiet> lsPhieuDatPhongChiTiet;
    private List<Phong> lsPhong;
    private List<KhachHang> lsKhachHang;

    public PhieuDatPhongAdapter(List<PhieuDat> lsPhieuDat) {
        this.lsPhieuDat = lsPhieuDat;
    }

    @NonNull
    @Override
    public PhieuDatPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phieudatphong, parent, false);
        return new PhieuDatPhongAdapter.PhieuDatPhongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuDatPhongViewHolder holder, int position) {
        PhieuDat PhieuDat = lsPhieuDat.get((position));
        PhieuDatPhongChiTiet PhieuDatPhongChiTiet = lsPhieuDatPhongChiTiet.get((position));
        KhachHang KhachHang = lsKhachHang.get((position));
        Phong Phong = lsPhong.get((position));
        if (PhieuDat == null) {
            return;
        }
        if (KhachHang.getKhachHangID() == PhieuDat.getKhachHangID()) {
            holder.tvtenkhachhangphieudatphongdata.setText(KhachHang.getTenKhachHang());
            holder.tvsdtitemphieudatphongdata.setText(KhachHang.getSdt());
        }
        holder.tvsochungtuphieudatphongdata.setText(PhieuDat.getSoChungTu());
        holder.tvthoigianlapphieuitemphieudatphongdata.setText(PhieuDat.getNgayLap().toString());
        if (PhieuDat.getPhieuDatID() == PhieuDatPhongChiTiet.getPhongID()) {
            holder.tvphongitemphieudatphongdata.setText(PhieuDatPhongChiTiet.getPhongID());
        }
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
