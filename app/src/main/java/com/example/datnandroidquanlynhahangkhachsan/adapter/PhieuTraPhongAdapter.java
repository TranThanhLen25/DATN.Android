package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuTraPhongActivity;

import java.util.List;

public class PhieuTraPhongAdapter extends RecyclerView.Adapter<PhieuTraPhongAdapter.PhieuTraPhongViewHolder> {
    private List<HangHoaDTO> lsHangHoa;


    private Context context;
    public PhieuTraPhongAdapter(List<HangHoaDTO> lsHangHoa) {
        this.lsHangHoa = lsHangHoa;
    }

    public PhieuTraPhongAdapter(PhieuTraPhongActivity phieuTraPhongActivity) {
    }
    public void setData(List<HangHoaDTO> lsHangHoa) {
        this.lsHangHoa = lsHangHoa;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuTraPhongAdapter.PhieuTraPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieutraphongBinding phieutraphongBinding=ItemPhieutraphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuTraPhongAdapter.PhieuTraPhongViewHolder(phieutraphongBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuTraPhongAdapter.PhieuTraPhongViewHolder holder, int position) {
        HangHoaDTO hangHoaDTO=lsHangHoa.get(position);
        if (hangHoaDTO == null) {
            return;
        }
//        holder.phieutraphongBinding.tvTendichvu.setText(hangHoaDTO.getTenHangHoa());
//        holder.phieutraphongBinding.tvDongiaHanghoaDichvu.setText(hangHoaDTO.getDonGia());
        }

    @Override
    public int getItemCount() {
        if ((lsHangHoa != null)) {
            return lsHangHoa.size();
        }
        return 0;
    }

    class PhieuTraPhongViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieutraphongBinding phieutraphongBinding;
        public PhieuTraPhongViewHolder(@NonNull ItemPhieutraphongBinding itemView) {

            super(itemView.getRoot());
            this.phieutraphongBinding=itemView;
        }
    }
}