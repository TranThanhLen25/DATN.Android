package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemChonloaiphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.soLuongLoaiPhong;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;

import java.util.ArrayList;
import java.util.List;

public class LoaiBanAdapter extends RecyclerView.Adapter<LoaiBanAdapter.LoaiBanViewHolder> {

    List<LoaiBanDTO> loaiBanDTOList;
    private Context context;

    public void setData(Context context, List<LoaiBanDTO> loaiBanDTOList) {
        this.loaiBanDTOList = loaiBanDTOList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LoaiBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChonloaiphongBinding itemChonloaiphongBinding = ItemChonloaiphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        //khai báo số lượng của từng loại phòng
        soLuongLoaiPhong.soLuong = new ArrayList<>();
        for (int i = 0; i < loaiBanDTOList.size(); i++) {
            soLuongLoaiPhong.soLuong.add(0);
        }
        return new LoaiBanAdapter.LoaiBanViewHolder(itemChonloaiphongBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiBanViewHolder holder, int position) {
        int index = position;

        LoaiBanDTO loaiBanDTO = loaiBanDTOList.get((index));
        if (loaiBanDTO == null) {
            return;
        }
        holder.tvtenloaiphong.setText(loaiBanDTO.getTenLoaiBan());
        holder.tvsoluong.setText(String.valueOf(soLuongLoaiPhong.soLuong.get(index)));

        //lấy số lượng loại phòng có sẵn dùng cho chi tiết
        //if (tempData.datPhongDTO.getPhieuDatPhongChiTiets().size() > 0) {
        if (tempData.Check == true) {
            for (int i = 0; i < tempData.datPhongDTO.getPhieuDatPhongChiTiets().size(); i++) {
                if (tempData.datPhongDTO.getPhieuDatPhongChiTiets().get(i).getLoaiPhongId() == loaiBanDTO.getLoaiBanId()) {
                    holder.tvsoluong.setText(String.valueOf(tempData.datPhongDTO.getPhieuDatPhongChiTiets().get(i).getSoLuong()));
                    // soLuongLoaiPhong.soLuong.set(index, tempData.datPhongDTO.getPhieuDatPhongChiTiets().get(i).getSoLuong());
                }
            }
        } else {

            //tăng số lượng phòng
            holder.btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int soLuong = soLuongLoaiPhong.soLuong.get(index) + 1;
                    soLuongLoaiPhong.soLuong.set(index, soLuong);
                    holder.tvsoluong.setText(String.valueOf(soLuong));
                }
            });

            //giảm số lượng phòng
            holder.btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (soLuongLoaiPhong.soLuong.get(index) > 0) {
                        int soLuong = soLuongLoaiPhong.soLuong.get(index) - 1;
                        soLuongLoaiPhong.soLuong.set(index, soLuong);
                        holder.tvsoluong.setText(String.valueOf(soLuong));
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if ((loaiBanDTOList != null)) {
            return loaiBanDTOList.size();
        }
        return 0;
    }

    class LoaiBanViewHolder extends RecyclerView.ViewHolder {
        private TextView tvtenloaiphong, tvsoluong;
        private ImageButton btnAdd;
        private ImageButton btnMinus;
        private ItemChonloaiphongBinding itemChonloaiphongBinding;

        public LoaiBanViewHolder(@NonNull ItemChonloaiphongBinding itemChonloaiphongBinding) {

            super(itemChonloaiphongBinding.getRoot());
            tvtenloaiphong = itemChonloaiphongBinding.tvTenloaiphong;
            tvsoluong = itemChonloaiphongBinding.tvSoluong;
            btnAdd = itemChonloaiphongBinding.btnAdd;
            btnMinus = itemChonloaiphongBinding.btnMinus;
        }
    }
}
