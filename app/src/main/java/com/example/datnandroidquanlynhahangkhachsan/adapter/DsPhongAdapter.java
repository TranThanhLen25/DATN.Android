package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.model.Phong;
import com.example.datnandroidquanlynhahangkhachsan.model.Phong;

import java.util.List;


public class DsPhongAdapter extends RecyclerView.Adapter<DsPhongAdapter.PhongViewHolder> {
    private List<Phong> lsPhong;

    public DsPhongAdapter(List<Phong> lsPhong) {
        this.lsPhong = lsPhong;
    }

    @NonNull
    @Override
    public PhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhsachphong, parent, false);
        return new PhongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhongViewHolder holder, int position) {
        Phong phong = lsPhong.get((position));
        if (phong == null) {
            return;
        }
        holder.tvsophong.setText(Integer.toString(phong.getSoPhong()));
        holder.tvloaiphong.setText(Integer.toString(phong.getLoaiPhongID()));
///////      giá
        holder.tvgia.setText(Integer.toString(phong.getTang()));

    }

    @Override
    public int getItemCount() {
        if ((lsPhong != null)) {
            return lsPhong.size();
        }
        return 0;
    }

    class PhongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvsophong, tvloaiphong, tvgia;

        public PhongViewHolder(@NonNull View itemView) {

            super(itemView);
            tvsophong = itemView.findViewById(R.id.tv_sophong);
            tvloaiphong = itemView.findViewById(R.id.tv_giuong);
            tvgia = itemView.findViewById(R.id.tv_gia_tien);

        }
    }
}
