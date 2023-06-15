package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemMenuPhieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuTraBanActivity;

import java.text.DecimalFormat;
import java.util.List;


public class PhieuTraBanAdapter extends RecyclerView.Adapter<PhieuTraBanAdapter.PhieuTraBanViewHolder> {
    private List<DichVuDTO> lsDichVu;
    private List<HangHoaDTO> lsHangHoa;


    private Context context;

    public PhieuTraBanAdapter(List<DichVuDTO> lsDichVu) {
        this.lsDichVu = lsDichVu;
    }

    public PhieuTraBanAdapter(PhieuTraBanActivity phieuTraBanActivity) {
    }

    public void setData(List<DichVuDTO> lsDichVu, Context context, List<HangHoaDTO> lsHangHoa) {
        this.lsDichVu = lsDichVu;
        this.context = context;
        this.lsHangHoa = lsHangHoa;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuTraBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMenuPhieutraphongBinding phieutraBanBinding=ItemMenuPhieutraphongBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PhieuTraBanViewHolder(phieutraBanBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuTraBanViewHolder holder, int position) {
        DichVuDTO dv = lsDichVu.get(position);
        if (dv == null) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        holder.phieutraBanBinding.tvSoluong.setText(String.valueOf(dv.getSoLuong()));
        holder.phieutraBanBinding.tvDongiaHanghoaDichvu.setText(String.valueOf(decimalFormat.format(dv.getDonGia())));
        holder.phieutraBanBinding.tvThanhtien.setText(String.valueOf(decimalFormat.format(dv.getDonGia() * dv.getSoLuong())));
        for (int i = 0; i < lsHangHoa.size(); i++) {
            if (lsHangHoa.get(i).getHangHoaId() == dv.getHangHoaId()) {
                holder.phieutraBanBinding.tvTendichvu.setText(lsHangHoa.get(i).getTenHangHoa());
            }
        }

    }

    @Override
    public int getItemCount() {
        if ((lsDichVu != null)) {
            return lsDichVu.size();
        }
        return 0;
    }

    class PhieuTraBanViewHolder extends RecyclerView.ViewHolder {
        private ItemMenuPhieutraphongBinding phieutraBanBinding;

        public PhieuTraBanViewHolder(@NonNull ItemMenuPhieutraphongBinding itemView) {

            super(itemView.getRoot());
            this.phieutraBanBinding = itemView;
        }
    }
}
