package com.example.datnandroidquanlynhahangkhachsan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datnandroidquanlynhahangkhachsan.Fragment_danhSachPhieuNhanBan;
import com.example.datnandroidquanlynhahangkhachsan.databinding.ItemPhieunhanphongBinding;
import com.example.datnandroidquanlynhahangkhachsan.entities.KhachHang.KhachHangDTO;
import com.example.datnandroidquanlynhahangkhachsan.entities.phieunhan.PhieuNhanDTO;
import com.example.datnandroidquanlynhahangkhachsan.utils.AppUtils;

import java.util.List;

public class PhieuNhanBanAdapter extends RecyclerView.Adapter<PhieuNhanBanAdapter.PhieuNhanBanViewHolder> {

    private List<PhieuNhanDTO> lsPhieuNhan;
    private List<KhachHangDTO> lsKhachHang;
    private AppUtils ac;
    private Context context;

    public PhieuNhanBanAdapter(List<PhieuNhanDTO> lsPhieuNhan) {

        this.lsPhieuNhan = lsPhieuNhan;
    }

    public PhieuNhanBanAdapter(Fragment_danhSachPhieuNhanBan fragment_danhSachPhieuNhanBan) {
    }

    public void setData(List<PhieuNhanDTO> lsPhieuNhan, List<KhachHangDTO> lsKhachHang, Context context) {
        this.lsPhieuNhan = lsPhieuNhan;
        this.lsKhachHang = lsKhachHang;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhieuNhanBanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhieunhanphongBinding phieunhanphongBinding = ItemPhieunhanphongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhieuNhanBanViewHolder(phieunhanphongBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhieuNhanBanViewHolder holder, int position) {
        PhieuNhanDTO phieuNhanDTO = lsPhieuNhan.get(position);
        if (phieuNhanDTO == null) {
            return;
        }
        for (int i = 0; i < lsKhachHang.size(); i++) {
            if (phieuNhanDTO.getKhachHangId() == lsKhachHang.get(i).getKhachHangId()) {
                holder.phieunhanphongBinding.tvTenkhachhangPhieunhanphongData.setText(lsKhachHang.get(i).getTenKhachHang());
                holder.phieunhanphongBinding.tvSdtItemphieunhanphongData.setText(lsKhachHang.get(i).getSdt());
            }
        }

        holder.phieunhanphongBinding.tvSochungtuPhieunhanphongData.setText(String.valueOf(phieuNhanDTO.getSoChungTu()));
        holder.phieunhanphongBinding.tvThoigianlapphieuItemphieunhanphongData.setText(ac.formatDateToString(phieuNhanDTO.getNgayLap(), "dd/MM/yyyy HH:mm:ss"));
        holder.phieunhanphongBinding.tvPhongItemphieunhanphongData.setText(phieuNhanDTO.getSoChungTu());

    }

    @Override
    public int getItemCount() {
        if ((lsPhieuNhan != null)) {
            return lsPhieuNhan.size();
        }
        return 0;
    }

    class PhieuNhanBanViewHolder extends RecyclerView.ViewHolder {
        private ItemPhieunhanphongBinding phieunhanphongBinding;

        public PhieuNhanBanViewHolder(@NonNull ItemPhieunhanphongBinding itemView) {
            super(itemView.getRoot());
            this.phieunhanphongBinding = itemView;
        }
    }
}
