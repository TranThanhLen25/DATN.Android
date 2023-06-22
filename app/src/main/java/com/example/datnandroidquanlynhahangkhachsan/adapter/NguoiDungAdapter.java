package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.datnandroidquanlynhahangkhachsan.Fragment_nhanVien;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuDatBanBinding;

import com.example.datnandroidquanlynhahangkhachsan.entities.NguoiDungDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class NguoiDungAdapter extends RecyclerView.Adapter<NguoiDungAdapter.NguoiDungViewHolder> {
    
    private List<NguoiDungDTO> lsNguoiDung;
    private Context context;

    public NguoiDungAdapter(Fragment_nhanVien fragment_nhanVien) {
    }


    public void setData(Context context, List<NguoiDungDTO> lsNguoiDung) {
        this.context = context;
        this.lsNguoiDung = lsNguoiDung;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public NguoiDungAdapter.NguoiDungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieuDatBanBinding itemPhieuDatBanBinding = ItemPhieuDatBanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NguoiDungAdapter.NguoiDungViewHolder(itemPhieuDatBanBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NguoiDungAdapter.NguoiDungViewHolder holder, int position) {
        NguoiDungDTO nguoiDung = lsNguoiDung.get(position);
        if (nguoiDung == null) {
            return;
        }
        holder.itemPhieuDatBanBinding.tvTenkhachhangPhieudatbanData.setText(nguoiDung.getTenNguoiDung());
        holder.itemPhieuDatBanBinding.tvSdtItemphieudatbanData.setText(nguoiDung.getSdt());
        holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatbanData.setText(nguoiDung.getDiaChi());
        holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatban.setText("Địa chỉ: ");
        holder.itemPhieuDatBanBinding.tvSochungtuPhieudatbanData.setText(nguoiDung.getCccd());
        holder.itemPhieuDatBanBinding.tvBanItemphieudatbanData.setText(nguoiDung.getTaiKhoan());

    }

    @Override
    public int getItemCount() {
        if (lsNguoiDung != null) {
            return lsNguoiDung.size();
        }
        return 0;
    }

    public class NguoiDungViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuDatBanBinding itemPhieuDatBanBinding;

        public NguoiDungViewHolder(@NonNull ItemPhieuDatBanBinding itemView) {
            super(itemView.getRoot());
            this.itemPhieuDatBanBinding = itemView;
        }
    }
}
