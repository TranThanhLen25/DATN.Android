package com.example.datnandroidquanlynhahangkhachsan.ui.chonphong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_dsPhong;


import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemChonphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemDanhsachphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhongDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.DanhSachPhongContract;
import com.example.datnandroidquanlynhahangkhachsan.ui.fragmentPhong.DsPhongAdapter;

import java.util.List;

public class ChonPhongAdapter extends RecyclerView.Adapter<ChonPhongAdapter.ChonPhongViewHolder> {

    private List<PhongDTO> lsPhong;
    private Context context;
    Fragment fragment = null;
    private boolean isClick;

    public ChonPhongAdapter(List<PhongDTO> lsPhong) {
        this.lsPhong = lsPhong;

    }

    public ChonPhongAdapter(ChonPhongActivity chonPhongActivity) {

    }

    public void setData(List<PhongDTO> lsPhong, Context context) {
        this.lsPhong = lsPhong;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChonPhongAdapter.ChonPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //hiện dialog

        ItemChonphongBinding chonphongBinding = ItemChonphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);


        return new ChonPhongAdapter.ChonPhongViewHolder(chonphongBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull ChonPhongAdapter.ChonPhongViewHolder holder, int position) {
        PhongDTO phong = lsPhong.get((position));
        if (phong == null) {
            return;
        }


        holder.chonphongBinding.tvSoChonphong.setText(String.valueOf(phong.getSoPhong()));

        ////hiển thị dấu tick ở item
        holder.chonphongBinding.ctlItemchonphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isClick = !isClick;
                if (isClick) {
                    holder.chonphongBinding.imgChonphong.setVisibility(View.VISIBLE);


                } else {
                    holder.chonphongBinding.imgChonphong.setVisibility(View.GONE);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        if ((lsPhong != null)) {
            return lsPhong.size();
        }
        return 0;
    }

    class ChonPhongViewHolder extends RecyclerView.ViewHolder {

        private ItemChonphongBinding chonphongBinding;

        public ChonPhongViewHolder(@NonNull ItemChonphongBinding dsPhong) {


            super(dsPhong.getRoot());
            this.chonphongBinding = dsPhong;


        }
    }
}
