package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemMenuPhieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.goiMon.GoiMonDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuTraBanActivity;

import java.text.DecimalFormat;
import java.util.List;


public class PhieuTraBanAdapter extends RecyclerView.Adapter<PhieuTraBanAdapter.PhieuTraBanViewHolder>{
    private List<GoiMonDTO> lsGoiMon;
    private List<HangHoaDTO> lsHangHoa;


    private Context context;

    public PhieuTraBanAdapter(List<GoiMonDTO> lsGoiMon) {
        this.lsGoiMon = lsGoiMon;
    }

    public PhieuTraBanAdapter(PhieuTraBanActivity phieuTraBanActivity) {
    }

    public void setData(List<GoiMonDTO> lsGoiMon, Context context, List<HangHoaDTO> lsHangHoa) {
        this.lsGoiMon = lsGoiMon;
        this.context = context;
        this.lsHangHoa = lsHangHoa;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuTraBanAdapter.PhieuTraBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMenuPhieutraphongBinding phieutraBanBinding=ItemMenuPhieutraphongBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PhieuTraBanViewHolder(phieutraBanBinding);
    }

@Override
    public void onBindViewHolder(@NonNull PhieuTraBanAdapter.PhieuTraBanViewHolder holder, int position) {
        GoiMonDTO gm = lsGoiMon.get(position);
        if (gm == null) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        for (int i=0;i<lsHangHoa.size();i++)
        {
            if(lsHangHoa.get(i).getHangHoaId()== gm.getHangHoaId())
            {
                holder.phieutraBanBinding.tvTendichvu.setText(lsHangHoa.get(i).getTenHangHoa());
                holder.phieutraBanBinding.tvDongiaHanghoaDichvu.setText(String.valueOf(lsHangHoa.get(i).getDonGia()) );
                holder.phieutraBanBinding.tvThanhtien.setText(String.valueOf(lsHangHoa.get(i).getDonGia()*gm.getSoLuong()) );
            }
        }
        holder.phieutraBanBinding.tvSoluong.setText(String.valueOf(gm.getSoLuong()));



    }

    @Override
    public int getItemCount() {
        if ((lsGoiMon != null)) {
            return lsGoiMon.size();
        }
        return 0;
    }

    class PhieuTraBanViewHolder extends RecyclerView.ViewHolder {
        private ItemMenuPhieutraphongBinding phieutraBanBinding;

        public PhieuTraBanViewHolder(@NonNull ItemMenuPhieutraphongBinding itemView) {

            super(itemView.getRoot());
            this.phieutraBanBinding = itemView;
        }
    }
}
