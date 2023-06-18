package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.ActivityChiTietKhachHang;
import com.example.datnandroidquanlynhahangkhachsan.FragmentKhachHang;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieuDatBanBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class KhachHangAdapter extends RecyclerView.Adapter<KhachHangAdapter.KhachHangViewHolder> {

    private Context context;
    private List<KhachHangDTO> lsKhachHang;
    private AppUtils ac;

    public KhachHangAdapter(FragmentKhachHang fragmentKhachHang) {
    }


    public void setData(Context context, List<KhachHangDTO> lsKhachHang) {
        this.context = context;
        this.lsKhachHang = lsKhachHang;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public KhachHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieuDatBanBinding itemPhieuDatBanBinding = ItemPhieuDatBanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new KhachHangAdapter.KhachHangViewHolder(itemPhieuDatBanBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull KhachHangViewHolder holder, int position) {
        KhachHangDTO khachHangDTO = lsKhachHang.get(position);
        if (khachHangDTO == null) {
            return;
        }
        if (khachHangDTO.getTenKhachHang().length() > 0) {
            holder.itemPhieuDatBanBinding.tvTenkhachhangPhieudatbanData.setText(String.valueOf(khachHangDTO.getTenKhachHang()));
        } else {
            holder.itemPhieuDatBanBinding.tvTenkhachhangPhieudatbanData.setText("Khách vãng lai");
        }
        if (khachHangDTO.getSdt() != null) {

            holder.itemPhieuDatBanBinding.tvSdtItemphieudatbanData.setText(String.valueOf("Số điện thoại: " + khachHangDTO.getSdt()));
        } else {

            holder.itemPhieuDatBanBinding.tvSdtItemphieudatbanData.setText("không có");
        }

        if (khachHangDTO.getCccd() != null) {


            holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatbanData.setText(String.valueOf(khachHangDTO.getCccd()));
        } else {

            holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatbanData.setText("không có");
        }
        holder.itemPhieuDatBanBinding.tvThoigianlapphieuItemphieudatban.setText("CCCD:");

        holder.itemPhieuDatBanBinding.tvSochungtuPhieudatbanData.setVisibility(View.GONE);
        holder.itemPhieuDatBanBinding.ctlBanItemphieudatban.setVisibility(View.GONE);
        holder.itemPhieuDatBanBinding.tvBanItemphieudatbanData.setVisibility(View.GONE);


        holder.itemPhieuDatBanBinding.ctlItemphieudatban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempData.tempDatakhachHangDTO = khachHangDTO;
                Intent intent = new Intent(context, ActivityChiTietKhachHang.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (lsKhachHang != null) {
            return lsKhachHang.size();
        }
        return 0;
    }

    public class KhachHangViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieuDatBanBinding itemPhieuDatBanBinding;

        public KhachHangViewHolder(@NonNull ItemPhieuDatBanBinding itemView) {
            super(itemView.getRoot());
            this.itemPhieuDatBanBinding = itemView;
        }
    }
}
