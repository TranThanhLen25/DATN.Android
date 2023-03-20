package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemDanhsachphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.model.Phong;
import com.example.datnandroidquanlynhahangkhachsan.model.Phong;

import java.util.List;


public class DsPhongAdapter extends RecyclerView.Adapter<DsPhongAdapter.PhongViewHolder> {
    private List<Phong> lsPhong;
    private Context context;

    public DsPhongAdapter(List<Phong> lsPhong) {
        this.lsPhong = lsPhong;
    }

    @NonNull
    @Override
    public PhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDanhsachphongBinding itemDanhsachphongBinding = ItemDanhsachphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new PhongViewHolder(itemDanhsachphongBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PhongViewHolder holder, int position) {
        Phong phong = lsPhong.get((position));
        if (phong == null) {
            return;
        }
        holder.itemDanhsachphongBinding.tvSophong.setText(String.valueOf(phong.getSoPhong()));
        holder.itemDanhsachphongBinding.tvGiaTien.setText(String.valueOf(phong.getLoaiPhongID()));
        holder.itemDanhsachphongBinding.tvGiuong.setText(String.valueOf(phong.getTang()));


    }

    @Override
    public int getItemCount() {
        if ((lsPhong != null)) {
            return lsPhong.size();
        }
        return 0;
    }

    class PhongViewHolder extends RecyclerView.ViewHolder {

        private final ItemDanhsachphongBinding itemDanhsachphongBinding;

        public PhongViewHolder(@NonNull ItemDanhsachphongBinding itemDanhsachphongBinding) {


            super(itemDanhsachphongBinding.getRoot());
            this.itemDanhsachphongBinding = itemDanhsachphongBinding;


        }
    }
}
