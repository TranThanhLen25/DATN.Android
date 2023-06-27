package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemChonphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;
import com.example.datnandroidquanlynhahangkhachsan.tempData.lsChonPhong;
import com.example.datnandroidquanlynhahangkhachsan.tempData.tempData;
import com.example.datnandroidquanlynhahangkhachsan.ui.chonBan.activity_chon_ban;

import java.util.List;

public class ChonBanAdapter extends RecyclerView.Adapter<ChonBanAdapter.ChonBanViewHolder> {

    private List<BanDTO> lsBan;
    private Context context;
    private List<LoaiBanDTO> lsLoaiBan;

    public ChonBanAdapter(activity_chon_ban activity_chon_ban) {
    }

    public void setData(List<BanDTO> lsBan, List<LoaiBanDTO> lsLoaiBan, Context context) {
        this.lsBan = lsBan;
        this.context = context;
        this.lsLoaiBan = lsLoaiBan;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChonBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChonphongBinding chonphongBinding = ItemChonphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);


        return new ChonBanAdapter.ChonBanViewHolder(chonphongBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChonBanViewHolder holder, int position) {
        BanDTO phong = lsBan.get((position));
        if (phong == null) {
            return;
        }
        holder.chonphongBinding.tvSoChonphong.setText(String.valueOf(phong.getTenBan()));
        for (int i = 0; i < lsLoaiBan.size(); i++) {
            if (phong.getLoaiBanId() == lsLoaiBan.get(i).getLoaiBanId()) {
                holder.chonphongBinding.tvLoaiphong.setText(lsLoaiBan.get(i).getTenLoaiBan());
            }
        }

        holder.chonphongBinding.imgChonphong.setVisibility(View.GONE);

        if (tempData.CheckChucNang == true) {
            // xét trạng thái dấu tick
            holder.chonphongBinding.ctlItemchonphong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (holder.chonphongBinding.imgChonphong.getVisibility() == View.GONE) {
                        holder.chonphongBinding.imgChonphong.setVisibility(View.VISIBLE);

                        lsChonPhong.lsChonBanDataInt.add(phong.getBanId());
                        int temp = 0;
                        for (int i = 0; i < lsChonPhong.lsChonBanDataInt.size(); i++) {
                            for (int j = i + 1; j < lsChonPhong.lsChonBanDataInt.size(); j++) {
                                if (lsChonPhong.lsChonBanDataInt.get(i) == lsChonPhong.lsChonBanDataInt.get(j)) {
                                    lsChonPhong.lsChonBanDataInt.remove(j);
                                }
                            }
                        }


                    } else {
                        holder.chonphongBinding.imgChonphong.setVisibility(View.GONE);
                        for (int i = 0; i < lsChonPhong.lsChonBanDataInt.size(); i++) {
                            if (phong.getBanId() == lsChonPhong.lsChonBanDataInt.get(i)) {
                                lsChonPhong.lsChonBanDataInt.remove(i);
                            }
                        }
                    }
                }
            });
            //set trạng thái về ban đầu
//        for (int i = 0; i < lsChonPhong.lsChonBanDataInt.size(); i++) {
//                holder.chonphongBinding.imgChonphong.setVisibility(View.GONE);
//        }
            //set trạng thái đã được chọn
            for (int i = 0; i < lsChonPhong.lsChonBanDataInt.size(); i++) {
                if (phong.getBanId() == lsChonPhong.lsChonBanDataInt.get(i)) {
                    holder.chonphongBinding.imgChonphong.setVisibility(View.VISIBLE);
                }
            }
        }
        else {
            if (phong.getTrangThaiId() != 4 && phong.getTrangThaiId() != 3) {

                if (tempData.checkDoiBan==true){

                    if (tempData.doiBan != null) {
                        if (tempData.doiBan.getBanId() == phong.getBanId()) {
                            holder.chonphongBinding.imgChonphong.setVisibility(View.VISIBLE);
                        }
                    }


                    // xét trạng thái dấu tick
                    holder.chonphongBinding.ctlItemchonphong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (holder.chonphongBinding.imgChonphong.getVisibility() == View.GONE) {
                                if (tempData.doiBan == null) {
                                    holder.chonphongBinding.imgChonphong.setVisibility(View.VISIBLE);
                                    tempData.doiBan = phong;
                                }
                            } else {
                                holder.chonphongBinding.imgChonphong.setVisibility(View.GONE);
                                tempData.doiBan = null;
                            }
                        }
                    });
                }
                else {

                    // xét trạng thái dấu tick
                    holder.chonphongBinding.ctlItemchonphong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (holder.chonphongBinding.imgChonphong.getVisibility() == View.GONE) {
                                holder.chonphongBinding.imgChonphong.setVisibility(View.VISIBLE);

                                lsChonPhong.lsChonBanDataInt.add(phong.getBanId());
                                int temp = 0;
                                for (int i = 0; i < lsChonPhong.lsChonBanDataInt.size(); i++) {
                                    for (int j = i + 1; j < lsChonPhong.lsChonBanDataInt.size(); j++) {
                                        if (lsChonPhong.lsChonBanDataInt.get(i) == lsChonPhong.lsChonBanDataInt.get(j)) {
                                            lsChonPhong.lsChonBanDataInt.remove(j);
                                        }
                                    }
                                }


                            } else {
                                holder.chonphongBinding.imgChonphong.setVisibility(View.GONE);
                                for (int i = 0; i < lsChonPhong.lsChonBanDataInt.size(); i++) {
                                    if (phong.getBanId() == lsChonPhong.lsChonBanDataInt.get(i)) {
                                        lsChonPhong.lsChonBanDataInt.remove(i);
                                    }
                                }
                            }
                        }
                    });
                    //set trạng thái về ban đầu
//        for (int i = 0; i < lsChonPhong.lsChonBanDataInt.size(); i++) {
//                holder.chonphongBinding.imgChonphong.setVisibility(View.GONE);
//        }
                    //set trạng thái đã được chọn
                    for (int i = 0; i < lsChonPhong.lsChonBanDataInt.size(); i++) {
                        if (phong.getBanId() == lsChonPhong.lsChonBanDataInt.get(i)) {
                            holder.chonphongBinding.imgChonphong.setVisibility(View.VISIBLE);
                        }
                    }
                }
            } else {

                holder.chonphongBinding.imgKhongchonphong.setVisibility(View.VISIBLE);
            }
        }



    }

    @Override
    public int getItemCount() {
        if ((lsBan != null)) {
            return lsBan.size();
        }
        return 0;
    }

    class ChonBanViewHolder extends RecyclerView.ViewHolder {

        private ItemChonphongBinding chonphongBinding;

        public ChonBanViewHolder(@NonNull ItemChonphongBinding dsPhong) {


            super(dsPhong.getRoot());
            this.chonphongBinding = dsPhong;


        }
    }
}
