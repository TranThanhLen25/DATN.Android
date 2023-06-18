package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemMenuPhieutraphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.DichVu.DichVuDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.HangHoaDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuTraPhongActivity;

import java.text.DecimalFormat;
import java.util.List;

public class PhieuTraPhongAdapter extends RecyclerView.Adapter<PhieuTraPhongAdapter.PhieuTraPhongViewHolder> {
    private List<DichVuDTO> lsDichVu;
    private List<HangHoaDTO> lsHangHoa;


    private Context context;

    public PhieuTraPhongAdapter(List<DichVuDTO> lsDichVu) {
        this.lsDichVu = lsDichVu;
    }

    public PhieuTraPhongAdapter(PhieuTraPhongActivity phieuTraPhongActivity) {
    }

    public void setData(List<DichVuDTO> lsDichVu, Context context, List<HangHoaDTO> lsHangHoa) {
        this.lsDichVu = lsDichVu;
        this.context = context;
        this.lsHangHoa = lsHangHoa;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuTraPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMenuPhieutraphongBinding phieutraphongBinding = ItemMenuPhieutraphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuTraPhongViewHolder(phieutraphongBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuTraPhongViewHolder holder, int position) {
        DichVuDTO dv = lsDichVu.get(position);
        if (dv == null) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        holder.phieutraphongBinding.tvSoluong.setText(String.valueOf(dv.getSoLuong()));


    for (int i=0;i<lsHangHoa.size();i++)
    {
        if(lsHangHoa.get(i).getHangHoaId()==dv.getHangHoaId())
        {
            holder.phieutraphongBinding.tvTendichvu.setText(lsHangHoa.get(i).getTenHangHoa());
            holder.phieutraphongBinding.tvDongiaHanghoaDichvu.setText(String.valueOf(decimalFormat.format(lsHangHoa.get(i).getDonGia())));
            holder.phieutraphongBinding.tvThanhtien.setText(String.valueOf(decimalFormat.format(lsHangHoa.get(i).getDonGia() * dv.getSoLuong())));
        }
    }

    }

    @Override
    public int getItemCount() {
        if ((lsDichVu != null)) {
            return lsDichVu.size();
        }
        return 0;
    }

    class PhieuTraPhongViewHolder extends RecyclerView.ViewHolder {
        private ItemMenuPhieutraphongBinding phieutraphongBinding;

        public PhieuTraPhongViewHolder(@NonNull ItemMenuPhieutraphongBinding itemView) {

            super(itemView.getRoot());
            this.phieutraphongBinding = itemView;
        }
    }
}