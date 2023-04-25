package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieunhanphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.PhieuNhapDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieudat.PhieuDatDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieunhan.Fragment_dsPhieuNhanPhong;
import com.example.datnandroidquanlynhahangkhachsan.R;
import com.example.datnandroidquanlynhahangkhachsan.model.PhieuNhan;
import com.example.datnandroidquanlynhahangkhachsan.ui.phieuxuat.PhieuXuatActivity;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuNhanPhongAdapter extends RecyclerView.Adapter<PhieuNhanPhongAdapter.PhieuNhanPhongViewHolder> {
    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<KhachHangDTO>lsKhachHang;
    private AppUtils ac;
private Context context;
    public PhieuNhanPhongAdapter(List<PhieuNhanDTO> lsPhieuNhan) {

        this.lsPhieuNhan = lsPhieuNhan;
    }

    public PhieuNhanPhongAdapter(Fragment_dsPhieuNhanPhong fragment_dsPhieuNhanPhong) {
    }
    public void setData(List<PhieuNhanDTO> lsPhieuNhan,List<KhachHangDTO> lsKhachHang,Context context) {
        this.lsPhieuNhan = lsPhieuNhan;
        this.lsKhachHang=lsKhachHang;
        this.context=context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuNhanPhongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ItemPhieunhanphongBinding phieunhanphongBinding=ItemPhieunhanphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuNhanPhongViewHolder(phieunhanphongBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PhieuNhanPhongViewHolder holder, int position) {
      PhieuNhanDTO phieuNhanDTO=lsPhieuNhan.get(position);
        if (phieuNhanDTO == null) {
            return;
        }
        for (int i=0;i<lsKhachHang.size();i++)
        {
            if(phieuNhanDTO.getKhachHangId()==lsKhachHang.get(i).getKhachHangId())
            {
                holder.phieunhanphongBinding.tvTenkhachhangPhieunhanphongData.setText(lsKhachHang.get(i).getTenKhachHang());
                holder.phieunhanphongBinding.tvSdtItemphieunhanphongData.setText(lsKhachHang.get(i).getSdt());
            }
        }

        holder.phieunhanphongBinding.tvSochungtuPhieunhanphongData.setText(String.valueOf(phieuNhanDTO.getSoChungTu()));
        holder.phieunhanphongBinding.tvThoigianlapphieuItemphieunhanphongData.setText(ac.formatDateToString(phieuNhanDTO.getNgayLap(),"dd/MM/yyyy HH:mm:ss"));
        holder.phieunhanphongBinding.tvPhongItemphieunhanphongData.setText(phieuNhanDTO.getSoChungTu());



    }

    @Override
    public int getItemCount() {
        if ((lsPhieuNhan != null)) {
            return lsPhieuNhan.size();
        }
        return 0;
    }

    class PhieuNhanPhongViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieunhanphongBinding phieunhanphongBinding;
        public PhieuNhanPhongViewHolder(@NonNull ItemPhieunhanphongBinding itemView) {

            super(itemView.getRoot());
      this.phieunhanphongBinding=itemView;
        }
    }
}
