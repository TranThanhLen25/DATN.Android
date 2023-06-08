package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.PhieuDatPhongChiTietActivity;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemChonloaiphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.LoaiPhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.soLuongLoaiPhong;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieudat.ThemPhieuDatphongActivity;

import java.util.ArrayList;
import java.util.List;

public class LoaiPhongAdapter extends RecyclerView.Adapter<LoaiPhongAdapter.LoaiPhongViewHolder> {
    List<LoaiPhongDTO> loaiPhongDTOList;
    private Context context;
    private List<Integer> soLuongCoSan;
    private List<Integer> iDLoaiPhongCoSan;

    //
    public LoaiPhongAdapter(ThemPhieuDatphongActivity themPhieuDatphongActivity) {
    }

    public LoaiPhongAdapter(PhieuDatPhongChiTietActivity phieuDatPhongChiTietActivity) {
    }

    public void setData(Context context, List<LoaiPhongDTO> loaiPhongDTOList) {
        this.loaiPhongDTOList = loaiPhongDTOList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LoaiPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChonloaiphongBinding itemChonloaiphongBinding = ItemChonloaiphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        //khai báo số lượng của từng loại phòng
        soLuongLoaiPhong.soLuong = new ArrayList<>();
        for (int i = 0; i < loaiPhongDTOList.size(); i++) {
            soLuongLoaiPhong.soLuong.add(0);
        }
        return new LoaiPhongViewHolder(itemChonloaiphongBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiPhongViewHolder holder, int position) {
        int index = position;

        LoaiPhongDTO loaiPhongDTO = loaiPhongDTOList.get((index));
        if (loaiPhongDTO == null) {
            return;
        }
        holder.tvtenloaiphong.setText(loaiPhongDTO.getTenLoaiPhong());
        holder.tvsoluong.setText(String.valueOf(soLuongLoaiPhong.soLuong.get(index)));

        //lấy số lượng loại phòng có sẵn dùng cho chi tiết
        //if (tempData.datPhongDTO.getPhieuDatPhongChiTiets().size() > 0) {
        if (tempData.Check == true) {
            for (int i = 0; i < tempData.datPhongDTO.getPhieuDatPhongChiTiets().size(); i++) {
                if (tempData.datPhongDTO.getPhieuDatPhongChiTiets().get(i).getLoaiPhongId() == loaiPhongDTO.getLoaiPhongId()) {
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
        if ((loaiPhongDTOList != null)) {
            return loaiPhongDTOList.size();
        }
        return 0;
    }

    class LoaiPhongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvtenloaiphong, tvsoluong;
        private ImageButton btnAdd;
        private ImageButton btnMinus;
        private ItemChonloaiphongBinding itemChonloaiphongBinding;

        public LoaiPhongViewHolder(@NonNull ItemChonloaiphongBinding itemChonloaiphongBinding) {

            super(itemChonloaiphongBinding.getRoot());
            tvtenloaiphong = itemChonloaiphongBinding.tvTenloaiphong;
            tvsoluong = itemChonloaiphongBinding.tvSoluong;
            btnAdd = itemChonloaiphongBinding.btnAdd;
            btnMinus = itemChonloaiphongBinding.btnMinus;
        }
    }
}
