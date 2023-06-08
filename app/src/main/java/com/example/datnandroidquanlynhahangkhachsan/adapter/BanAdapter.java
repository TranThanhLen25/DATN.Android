package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_danhSachBan;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemDanhsachphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.BanDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.Ban.LoaiBanDTO;

import java.util.List;

public class BanAdapter extends RecyclerView.Adapter<BanAdapter.BanViewHolder> {
    private List<BanDTO> lsBan;
    private List<LoaiBanDTO> lsLoaiBan;
    private Context context;

    public BanAdapter(List<BanDTO> lsBan) {
        this.lsBan = lsBan;
    }

    public BanAdapter(Fragment_danhSachBan fragment_danhSachBan) {

    }

    public void setData(List<BanDTO> lsBan, List<LoaiBanDTO> lsLoaiBan, Context context) {
        this.lsBan = lsBan;
        this.lsLoaiBan = lsLoaiBan;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BanAdapter.BanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //hiện dialog

        ItemDanhsachphongBinding dsBanBinding = ItemDanhsachphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);


        return new BanAdapter.BanViewHolder(dsBanBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull BanAdapter.BanViewHolder holder, int position) {
        BanDTO banDTO = lsBan.get((position));
        if (banDTO == null) {
            return;
        }

        for (int i = 0; i < lsLoaiBan.size(); i++) {
            if (lsLoaiBan.get(i).getLoaiBanId() == banDTO.getLoaiBanId()) {
                holder.dsBanBinding.tvLoaiphong.setText(lsLoaiBan.get(i).getTenLoaiBan());
                holder.dsBanBinding.tvGiatien.setText(String.valueOf(lsLoaiBan.get(i).getSoNguoiToiDa()));
            }
        }
        holder.dsBanBinding.tvSophong.setText(banDTO.getTenBan());


    }

    @Override
    public int getItemCount() {
        if ((lsBan != null)) {
            return lsBan.size();
        }
        return 0;
    }

    class BanViewHolder extends RecyclerView.ViewHolder {

        private ItemDanhsachphongBinding dsBanBinding;

        public BanViewHolder(@NonNull ItemDanhsachphongBinding dsBanBinding) {


            super(dsBanBinding.getRoot());
            this.dsBanBinding = dsBanBinding;


        }
    }
}
