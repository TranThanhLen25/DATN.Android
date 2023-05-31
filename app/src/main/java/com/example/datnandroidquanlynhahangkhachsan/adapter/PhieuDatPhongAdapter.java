package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.PhieuDatPhongChiTietActivity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieudatphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.Fragment_dsPhieuDatPhong;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.ThemPhieuDatphongActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuDatPhongAdapter extends RecyclerView.Adapter<PhieuDatPhongAdapter.PhieuDatPhongViewHolder> {
    private List<PhieuDatDTO> lsPhieuDat;
    private AppUtils ac;
    private Context context;

    public PhieuDatPhongAdapter(List<PhieuDatDTO> lsPhieuDat) {
        this.lsPhieuDat = lsPhieuDat;
    }

    public PhieuDatPhongAdapter(Fragment_dsPhieuDatPhong fragment_dsPhieuDatPhong) {
    }

    public PhieuDatPhongAdapter(ThemPhieuDatphongActivity themPhieuDatphongActivity) {
    }

    public void setData(Context context, List<PhieuDatDTO> lsPhieuDat) {
        this.lsPhieuDat = lsPhieuDat;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuDatPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemPhieudatphongBinding phieudatphongBinding = ItemPhieudatphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new PhieuDatPhongViewHolder(phieudatphongBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuDatPhongViewHolder holder, int position) {
        PhieuDatDTO PhieuDat = lsPhieuDat.get((position));
        if (PhieuDat == null) {
            return;
        }

        holder.phieudatphongBinding.tvTenkhachhangPhieudatphongData.setText(String.valueOf(PhieuDat.getTrangThai()));
        holder.phieudatphongBinding.tvSdtItemphieudatphongData.setText(String.valueOf(PhieuDat.getGhiChu()));
        holder.phieudatphongBinding.tvSochungtuPhieudatphongData.setText(PhieuDat.getSoChungTu());
        holder.phieudatphongBinding.tvThoigianlapphieuItemphieudatphong.setText(ac.formatDateToString(PhieuDat.getNgayLap(), "dd/MM/yyyy HH:mm:ss"));
        holder.phieudatphongBinding.tvPhongItemphieudatphongData.setText(String.valueOf(PhieuDat.getKhachHangID()));
        holder.phieudatphongBinding.itemPhieudatphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PhieuDatPhongChiTietActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        if ((lsPhieuDat != null)) {
            return lsPhieuDat.size();
        }
        return 0;
    }

    class PhieuDatPhongViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieudatphongBinding phieudatphongBinding;


        public PhieuDatPhongViewHolder(@NonNull ItemPhieudatphongBinding itemView) {
            super(itemView.getRoot());
            this.phieudatphongBinding = itemView;

        }
    }
}
